package co.com.sofka.model.game.gateways;

import co.com.sofka.model.game.Carta;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CartaRepository {

    Mono<Carta> save(Carta carta);

    Flux<Carta> findAll();
//    Mono<Void> delete(String id);
//    Mono<Carta> findById(String id);
//    Mono<Carta> update(String id, Carta carta);
//    Flux<Carta> findByName(String name);
}
