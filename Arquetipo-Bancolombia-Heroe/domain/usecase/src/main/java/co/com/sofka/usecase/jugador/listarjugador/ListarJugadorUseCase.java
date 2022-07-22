package co.com.sofka.usecase.jugador.listarjugador;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.jugador.gateways.JugadorRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListarJugadorUseCase {

    private final JugadorRepository repository;

    public Flux<Jugador> listarJugador() {
        return repository.findAll();
    }
}
