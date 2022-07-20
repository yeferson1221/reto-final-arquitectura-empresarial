package co.com.sofka.mongo.tablero;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface TableroMongoDBRepository extends ReactiveMongoRepository<TableroDocument, String>, ReactiveQueryByExampleExecutor<TableroDocument> {

}
