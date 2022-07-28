package co.com.sofka.usecase.jugador;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.jugador.gateways.JugadorRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class JugadorUseCase {

    private final JugadorRepository repository;

    public Mono<Jugador> crearJugador(Jugador jugador) {
        return repository.save(jugador);
    }

    public Flux<Jugador> listarJugador() {
        return repository.findAll();
    }

    public Mono<Jugador> listarPorId(String id) {
        return repository.findById(id);
    }

    public Mono<Jugador> actualizarJugador(String id, Jugador jugador) {
        return repository.update(id, jugador);
    }
}
