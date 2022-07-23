package co.com.sofka.model.jugador.gateways;

import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.jugador.Jugador;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface JugadorRepository {

    Mono<Jugador> save(Jugador jugador);

    Flux<Jugador> findAll();

    Mono<Jugador> findById(String id);

    Mono<Jugador> update(String id, Jugador jugador);

}
