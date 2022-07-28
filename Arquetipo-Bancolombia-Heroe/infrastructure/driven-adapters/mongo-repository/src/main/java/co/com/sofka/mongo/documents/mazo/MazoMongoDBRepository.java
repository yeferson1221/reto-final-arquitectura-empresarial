package co.com.sofka.mongo.documents.mazo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MazoMongoDBRepository extends ReactiveMongoRepository<MazoDocument, String>,
        ReactiveQueryByExampleExecutor<MazoDocument> {

}
