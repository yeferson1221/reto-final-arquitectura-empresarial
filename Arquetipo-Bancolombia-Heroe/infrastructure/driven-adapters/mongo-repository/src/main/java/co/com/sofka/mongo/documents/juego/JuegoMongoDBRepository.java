package co.com.sofka.mongo.documents.juego;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface JuegoMongoDBRepository extends ReactiveMongoRepository<JuegoDocument, String>,
        ReactiveQueryByExampleExecutor<JuegoDocument> {

}
