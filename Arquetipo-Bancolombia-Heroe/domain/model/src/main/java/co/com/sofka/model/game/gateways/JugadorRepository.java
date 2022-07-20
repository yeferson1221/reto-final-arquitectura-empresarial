package co.com.sofka.model.game.gateways;

import co.com.sofka.model.game.Jugador;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface JugadorRepository {

    Mono<Jugador> save(Jugador jugador);
    Flux<Jugador> findAll();
//    Mono<Void> delete(String id);
//    Mono<Jugador> findById(String id);
//    Mono<Jugador> update(String id, Jugador jugador);
//    Flux<Jugador> findByName(String name);
}
