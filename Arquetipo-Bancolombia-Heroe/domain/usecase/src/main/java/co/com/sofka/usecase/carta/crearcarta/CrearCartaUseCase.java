package co.com.sofka.usecase.carta.crearcarta;

import co.com.sofka.model.game.Carta;
import co.com.sofka.model.game.gateways.CartaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearCartaUseCase {
    private final CartaRepository repository;

    public Mono<Carta> crearCarta(Carta carta) {
        return repository.save(carta);
    }
}
