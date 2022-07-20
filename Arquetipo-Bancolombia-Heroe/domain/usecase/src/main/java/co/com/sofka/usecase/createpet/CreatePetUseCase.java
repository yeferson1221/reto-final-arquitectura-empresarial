package co.com.sofka.usecase.createpet;

import co.com.sofka.model.game.Tablero;
import co.com.sofka.model.game.gateways.TableroRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor

public class CreatePetUseCase {
    private final TableroRepository repository;

    public Mono<Tablero> createPet(Tablero pet) {
        return repository.save(pet);
    }
}
