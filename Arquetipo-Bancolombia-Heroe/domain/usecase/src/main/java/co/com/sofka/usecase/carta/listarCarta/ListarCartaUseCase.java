package co.com.sofka.usecase.carta.listarCarta;

import co.com.sofka.model.game.Carta;
import co.com.sofka.model.game.gateways.CartaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListarCartaUseCase {
    private final CartaRepository repository;

    public Flux<Carta> listarCarta(){
        return repository.findAll();
    }
}
