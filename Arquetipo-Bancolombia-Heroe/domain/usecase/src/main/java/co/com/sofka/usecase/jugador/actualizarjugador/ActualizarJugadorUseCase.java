package co.com.sofka.usecase.jugador.actualizarjugador;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.jugador.gateways.JugadorRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ActualizarJugadorUseCase {

    private final JugadorRepository jugadorRepository;

    public Mono<Jugador> actualizarJugador(String id, Jugador jugador) {
        return jugadorRepository.update(id, jugador);
    }

}
