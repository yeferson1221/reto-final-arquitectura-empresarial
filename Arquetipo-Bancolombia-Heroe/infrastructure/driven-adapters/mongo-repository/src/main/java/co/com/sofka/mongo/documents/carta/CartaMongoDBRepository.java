package co.com.sofka.mongo.documents.carta;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface CartaMongoDBRepository extends ReactiveMongoRepository<CartaDocument, String>,
        ReactiveQueryByExampleExecutor<CartaDocument> {

}
