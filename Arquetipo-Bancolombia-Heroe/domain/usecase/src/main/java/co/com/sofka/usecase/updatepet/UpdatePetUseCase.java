package co.com.sofka.usecase.updatepet;

import co.com.sofka.model.game.Tablero;
import co.com.sofka.model.game.gateways.TableroRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdatePetUseCase {

    private final TableroRepository tableroRepository;

    public Mono<Tablero> updatePet(String id, Tablero pet) {
        return tableroRepository.update(id,pet);
    }
}
