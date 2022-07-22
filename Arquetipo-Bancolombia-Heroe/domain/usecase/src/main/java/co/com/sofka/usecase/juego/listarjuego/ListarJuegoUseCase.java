package co.com.sofka.usecase.juego.listarjuego;

import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.juego.gateways.JuegoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListarJuegoUseCase {

    private final JuegoRepository repository;

    public Flux<Juego> listarJuego() {
        return repository.findAll();
    }
}
