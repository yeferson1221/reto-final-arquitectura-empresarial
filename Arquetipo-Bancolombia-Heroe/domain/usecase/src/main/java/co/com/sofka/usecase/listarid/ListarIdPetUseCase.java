package co.com.sofka.usecase.listarid;

import co.com.sofka.model.game.Tablero;
import co.com.sofka.model.game.gateways.TableroRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ListarIdPetUseCase {
    private final TableroRepository repository;

    public Mono<Tablero> listarIdPet(String id) {
        return repository.findById(id);
    }
}
