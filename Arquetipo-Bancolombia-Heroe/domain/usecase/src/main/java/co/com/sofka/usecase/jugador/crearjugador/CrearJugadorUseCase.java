package co.com.sofka.usecase.jugador.crearjugador;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.jugador.gateways.JugadorRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearJugadorUseCase {

    private final JugadorRepository repository;

    public Mono<Jugador> crearJugador(Jugador jugador) {
        return repository.save(jugador);
    }
}
