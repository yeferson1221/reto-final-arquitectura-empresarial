package co.com.sofka.usecase.deletapet;

import co.com.sofka.model.game.gateways.TableroRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeletePetUseCase {
    private final TableroRepository tableroRepository;

    public Mono<Void> deletePet(String id) {
        return tableroRepository.delete(id);
    }
}
