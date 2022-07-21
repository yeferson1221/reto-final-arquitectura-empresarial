package co.com.sofka.usecase.carta.listarcarta;

import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.carta.gateways.CartaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListarCartaUseCase {
    private final CartaRepository repository;

    public Flux<Carta> listarCarta(){
        return repository.findAll();
    }
}
