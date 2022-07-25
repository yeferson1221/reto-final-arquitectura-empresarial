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
     * Obtener el ganador de la ronda, de las cartas en juego
     * quien tiene la mayor valor y retornar ese jugador.
     */
    public Mono<Jugador> obtenerGanadorJuego(String idJuego) {
        return jugadorRepository.findAll().collectList()
                .map(jugadors -> jugadors.stream()
                        .max(Comparator.comparing(Jugador::getPuntaje)).get());

    }

    public Mono<Juego> retirarse(String id, String idJuego) {
        return juegoRepository.findById(idJuego).map(juego -> {
            Jugador jugador = juego.getJugadores()
                    .stream()
                    .filter(jugador1 -> jugador1.getId().equals(id)).findFirst().get();

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
