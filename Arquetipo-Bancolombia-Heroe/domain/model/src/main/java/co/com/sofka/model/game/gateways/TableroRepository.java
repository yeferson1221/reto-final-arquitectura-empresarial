package co.com.sofka.model.game.gateways;
import co.com.sofka.model.game.Tablero;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TableroRepository {
    Mono<Tablero> save(Tablero tablero);
    Flux<Tablero> findAll();
}
