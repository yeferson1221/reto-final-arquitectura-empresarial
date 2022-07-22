package co.com.sofka.usecase.juego;

import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.juego.gateways.JuegoRepository;
import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.jugador.gateways.JugadorRepository;
import co.com.sofka.model.mazo.gateways.MazoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;

@RequiredArgsConstructor
public class JuegoUseCase {
    private final JuegoRepository juegoRepository;
    private final JugadorRepository jugadorRepository;
    private final MazoRepository mazoRepository;

    public Mono<Juego> crearJuego() {

        return jugadorRepository.findAll()
                .collectList()
                .map(jugador -> {
                    Collections.shuffle(jugador); // lo que hago es mapear  se aplica shuffle barajar
                    return jugador;
                }) // retornar ordenado
                .map(jugador -> jugador.subList(0, 4)) // traigame solo 5 utilizando metodo sublist
                .map(jugador -> Juego.builder().jugadores(jugador).build());
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

}
