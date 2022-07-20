package co.com.sofka.usecase.listarpet;

import co.com.sofka.model.game.Tablero;
import co.com.sofka.model.game.gateways.TableroRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListarPetUseCase {
    private final TableroRepository repository;

    public Flux<Tablero> listarPet() {
        return repository.findAll();
    }
}
