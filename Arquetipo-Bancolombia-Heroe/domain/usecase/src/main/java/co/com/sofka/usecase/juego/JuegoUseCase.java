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

import java.util.Objects;


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
    public Mono<Jugador> obtenerGanador() {
        return Mono.empty();
    }

    public Flux<Juego> listarJuego() {
        return juegoRepository.findAll();
    }

    public Mono<Juego> retirarse(String id, String idJuego) {
        return juegoRepository.findById(idJuego).map(juego -> {
            Jugador jugador = juego.getJugadores()
                    .stream()
                    .filter(jugador1 -> Objects.equals(jugador1.getId(), id)).findFirst().get();

            juego.getJugadores()
                    .remove(jugador);

            return juego;

        }).cast(Juego.class).flatMap(juegoRepository::save);
    }

    public Flux<Carta> pasarCartasApostadas() {
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
