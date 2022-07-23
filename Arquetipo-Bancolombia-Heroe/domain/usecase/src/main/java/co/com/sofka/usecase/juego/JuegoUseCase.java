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

@RequiredArgsConstructor
public class JuegoUseCase {
    private final JuegoRepository juegoRepository;
    private final JugadorRepository jugadorRepository;
    private final MazoUseCase mazoUseCase;

    public Mono<Juego> crearJuego() {

        return jugadorRepository.findAll().flatMap(jugador -> {
                    return mazoUseCase.crearMazo()
                            .map(mazo -> {
                                jugador.setMazo(mazo);
                                return jugador;
                            });
                }).collectList()
                .map(jugador -> Juego.builder().jugadores(jugador).build());
    }

    /**
     * AL momento de crear el juego se debe generar un mazo de 5 cartas y
     * enviarlo.
     */
    public void obtenerMazo() {

    }

    /**
     * Obtener el ganador de la ronda, de las cartas en juego
     * quien tiene la mayor valor y retornar ese jugador.
     *
     * @return
     */
    public Mono<Jugador> obtenerGanador() {
        return Mono.empty();
    }

    public Flux<Juego> listarJuego() {
        return juegoRepository.findAll();
    }

    public Flux<Carta> pasarCartasApostadas() {
        return juegoRepository.pasarCartasApostadas();
    }

}
