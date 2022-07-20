package co.com.sofka.usecase.jugador.createjugador;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.jugador.gateways.JugadorRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateJugadorUseCase {

    private final JugadorRepository repository;

    public Mono<Jugador> crearCarta(Jugador jugador) {
        return repository.save(jugador);
    }
}
