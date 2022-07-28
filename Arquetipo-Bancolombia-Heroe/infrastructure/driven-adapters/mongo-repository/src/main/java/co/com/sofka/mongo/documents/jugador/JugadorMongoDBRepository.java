package co.com.sofka.mongo.documents.jugador;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface JugadorMongoDBRepository extends ReactiveMongoRepository<JugadorDocument, String>,
        ReactiveQueryByExampleExecutor<JugadorDocument> {

}
