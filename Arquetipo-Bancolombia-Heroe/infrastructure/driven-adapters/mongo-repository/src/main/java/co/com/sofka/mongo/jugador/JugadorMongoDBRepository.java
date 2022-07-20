package co.com.sofka.mongo.jugador;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface JugadorMongoDBRepository extends ReactiveMongoRepository<JugadorDocument, String>, ReactiveQueryByExampleExecutor<JugadorDocument> {
   // Flux<Carta> findByName(String name);
}
