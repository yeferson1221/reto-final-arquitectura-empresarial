package co.com.sofka.usecase.juego;

import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.juego.gateways.JuegoRepository;
import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.jugador.gateways.JugadorRepository;
import co.com.sofka.usecase.mazo.MazoUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;


@RequiredArgsConstructor
public class JuegoUseCase {
    private final JuegoRepository juegoRepository;
    private final JugadorRepository jugadorRepository;
    private final MazoUseCase mazoUseCase;

    /**
     * Obtenemos todos los jugadores, la aplanamos y la transformamos con flatmap
     * para a cada jugador setttear el mazo, haciendo uso del metodo mazoUseCase.crearMazo()
     * coleccionamos y cada jugador lo agregamos al nuevo juego, finalmente guardamos en bd.
     *
     * @return
     */
    public Mono<Juego> crearJuego() {
        return jugadorRepository
                .findAll()
                .flatMap(jugador -> {
                    return mazoUseCase.crearMazo()
                            .map(mazo -> {
                                jugador.setMazo(mazo);
                                return jugador;
                            });
                })
                .collectList()
                .map(jugador -> Juego.builder()
                        .jugadores(jugador)
                        .build())
                .flatMap(juegoRepository::save);
    }

    /**
     * Metodo que obtiene un ganador del juego, se busca el juego por
     * id, se obtiene la lista de jugadores y se obtiene el max
     *
     * @param idJuego id para buscar el juego en bd
     * @return jugador con puntaje mas alto.
     */
    public Mono<Jugador> obtenerGanadorJuego(String idJuego) {

        return juegoRepository.findById(idJuego)
                .map(juego -> juego.getJugadores().stream()
                        .max(Comparator.comparing(Jugador::getPuntaje))
                        .get());

        /*
        return jugadorRepository.findAll().collectList()
                .map(jugadors -> jugadors.stream()
                        .max(Comparator.comparing(Jugador::getPuntaje)).get());

         */
    }

    /**
     * Metodo que elimina un jugador del juego, obtenemos el juego por id,
     * luego obtenemos la lista de jugadores, luego filtramos por idJugador
     * y removemos de la lista; finalmente guardamos en bd.
     *
     * @param idJugador jugador a ser eliminado
     * @param idJuego   idJuego
     * @return juego actualizado.
     */
    public Mono<Juego> retirarse(String idJugador, String idJuego) {
        return juegoRepository.findById(idJuego)
                .map(juego -> {
                    Jugador jugador = juego.getJugadores()
                            .stream()
                            .filter(jugador1 -> jugador1.getId().equals(idJugador))
                            .findFirst()
                            .get();

                    juego.getJugadores()
                            .remove(jugador);

                    return juego;
                }).cast(Juego.class).flatMap(juegoRepository::save);
    }

    public Flux<Carta> pasarCartasAlGanador() {
        return Flux.just(new Carta());
    }

    public Mono<Juego> aumentarRonda(String idJuego) {
        return juegoRepository.findById(idJuego)
                .map(ronda -> {
                    ronda.setRonda(ronda.getRonda() + 1);
                    return ronda;
                }).flatMap(juegoRepository::save);
    }
}
