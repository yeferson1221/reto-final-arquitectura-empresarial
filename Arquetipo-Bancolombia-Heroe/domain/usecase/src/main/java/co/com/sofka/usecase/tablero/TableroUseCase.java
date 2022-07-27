package co.com.sofka.usecase.tablero;

import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.carta.gateways.CartaRepository;
import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.juego.gateways.JuegoRepository;
import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.jugador.gateways.JugadorRepository;
import co.com.sofka.model.mazo.Mazo;
import co.com.sofka.model.tablero.Tablero;
import co.com.sofka.model.tablero.gateways.TableroRepository;
import co.com.sofka.usecase.carta.CartaUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class TableroUseCase {
    private final TableroRepository tableroRepository;
    private final JugadorRepository jugadorRepository;

    private final CartaRepository cartaRepository;

    private final JuegoRepository juegoRepository;

    private final CartaUseCase cartaUseCase;

    public Mono<Tablero> crearTablero(Tablero tablero) {
        //cuando se guarda verificar si estan todas las apuesas

        return tableroRepository.save(tablero);
    }

    public Flux<Tablero> listarTablero() {
        return tableroRepository.findAll();
    }

    public Mono<Tablero> listarTableroById(String idJuego) {
        return tableroRepository.findById(idJuego);
    }

    public Mono<Juego> apostar(String idRonda, String idJuego) {

        return juegoRepository.findById(idJuego)
                .zipWith(obtenerGanadorRonda(idRonda, idJuego))
                .map(tuple2 ->

                        tuple2.getT1().getJugadores().stream()
                                .filter(jugador -> jugador.equals(tuple2.getT2()))
                                .findFirst()
                                .get()
                )
                .flatMap(jugador ->
                        tableroRepository.buscarTableroIdJuegoIdRonda(idJuego, idRonda)
                                .flatMap(tablero -> cartaUseCase.findById(tablero.getIdcarta()))
                                .collectList()
                                .map(cartas -> Mazo.builder().baraja(cartas).cantidad(cartas.size()).id(String.valueOf(Math.random()))
                                        .build())
                                .map(mazo -> {
                                    jugador.getMazo().getBaraja().addAll(mazo.getBaraja());
                                    return jugador;
                                })
                )
                .flatMap(jugador -> juegoRepository.findById(idJuego)
                        .map(juego -> {
                            Jugador j = juego.getJugadores().stream()
                                    .filter(jugador1 -> jugador1.getId().equals(jugador.getId())).findFirst().get();

                            juego.getJugadores()
                                    .remove(j);

                            juego.getJugadores().add(jugador);
                            return juego;
                        }))
                .flatMap(juegoRepository::save);
    }

    /**
     * ColletList espera hasta que se complete el flujo y los colelcciona.
     * .get() extraer el valor del optional.
     *
     * @param idRonda
     * @param idJuego
     * @return
     */
    public Mono<Jugador> obtenerGanadorRonda(String idRonda, String idJuego) {
        return tableroRepository.buscarTableroIdJuegoIdRonda(idJuego, idRonda)
                .flatMap(tablero -> cartaUseCase.findById(tablero.getIdcarta()))
                .collectList()
                .map(cartas -> cartas.stream()
                        .max(Comparator.comparing(Carta::getValor)).get())
                .flatMap(carta -> tableroRepository.buscarTableroIdJuegoIdRondaIdcarta(idJuego, idRonda, carta.getId()))
                .flatMap(tablero -> jugadorRepository.findById(tablero.getIdjugador()))
                .map(jugador -> jugador.toBuilder().puntaje(10).build());

    }


}
