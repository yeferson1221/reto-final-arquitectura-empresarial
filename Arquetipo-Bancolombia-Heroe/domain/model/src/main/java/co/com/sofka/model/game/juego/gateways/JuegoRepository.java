package co.com.sofka.model.game.juego.gateways;

import co.com.sofka.model.game.juego.Juego;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface JuegoRepository {

    Mono<Juego> save(Juego juego);
    Flux<Juego> findAll();
}
