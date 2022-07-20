package co.com.sofka.model.carta.gateways;

import co.com.sofka.model.carta.Carta;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CartaRepository {

    Mono<Carta> save(Carta carta);

    Flux<Carta> findAll();
}
