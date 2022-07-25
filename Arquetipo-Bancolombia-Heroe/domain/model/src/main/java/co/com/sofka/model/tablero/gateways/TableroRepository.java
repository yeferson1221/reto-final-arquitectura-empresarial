package co.com.sofka.model.tablero.gateways;

import co.com.sofka.model.tablero.Tablero;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TableroRepository {

    Mono<Tablero> save(Tablero tablero);

    Flux<Tablero> findAll();

}
