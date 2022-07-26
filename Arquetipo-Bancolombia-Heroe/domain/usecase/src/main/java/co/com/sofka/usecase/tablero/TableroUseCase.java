package co.com.sofka.usecase.tablero;


import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.carta.gateways.CartaRepository;
import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.jugador.gateways.JugadorRepository;
import co.com.sofka.model.tablero.Tablero;
import co.com.sofka.model.tablero.gateways.TableroRepository;
import co.com.sofka.usecase.carta.CartaUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;


@RequiredArgsConstructor
public class TableroUseCase {
    private final TableroRepository tableroRepository;
    private final JugadorRepository jugadorRepository;

    private final CartaRepository cartaRepository;

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
                .map(cartas -> cartas.stream().max(Comparator.comparing(Carta::getValor)).get())
                .flatMap(carta -> tableroRepository.buscarTableroIdJuegoIdRondaIdcarta(idJuego, idRonda, carta.getId()))
                .flatMap(tablero -> jugadorRepository.findById(tablero.getIdjugador()));

    }
}
