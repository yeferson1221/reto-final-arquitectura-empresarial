package co.com.sofka.mongo;

import co.com.sofka.model.game.Carta;
import co.com.sofka.model.game.Tablero;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import reactor.core.publisher.Flux;

public interface MongoDBRepository extends ReactiveMongoRepository<CartaDocument, String>, ReactiveQueryByExampleExecutor<CartaDocument> {
   // Flux<Carta> findByName(String name);
}
