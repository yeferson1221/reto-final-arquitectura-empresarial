package co.com.sofka.usecase.carta;

import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.carta.gateways.CartaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearCartaUseCase {
    private final CartaRepository repository;

    public Mono<Carta> crearCarta(Carta carta) {
        return repository.save(carta);
    }

    public Mono<Carta> actualizarCarta(String id, Carta carta) {
        return repository.update(id, carta);
    }

    public Flux<Carta> listarCarta(){
        return repository.findAll();
    }
}
