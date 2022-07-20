package co.com.sofka.model.game.gateways;

import co.com.sofka.model.game.Tablero;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TableroRepository {
     Mono<Tablero> save(Tablero pet);
     Flux<Tablero> findAll();
     Mono<Void> delete(String id);
     Mono<Tablero> findById(String id);
     Mono<Tablero> update(String id, Tablero pet);
     Flux<Tablero> findByName(String name);
}
