package co.com.sofka.mongo.documents.tablero;

import co.com.sofka.model.tablero.Tablero;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TableroMongoDBRepository extends ReactiveMongoRepository<TableroDocument, String>, ReactiveQueryByExampleExecutor<TableroDocument> {

    Flux<Tablero> findAllByIdJuegoAndRonda(String idJuego, String idRonda);

    Mono<Tablero> findAllByIdJuegoAndRondaAndIdcarta(String idJuego, String idRonda, String idCarta);
}
