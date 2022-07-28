package co.com.sofka.mongo.documents.mazo;

import co.com.sofka.model.mazo.Mazo;
import co.com.sofka.model.mazo.gateways.MazoRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MazoMongoRepositoryAdapter extends AdapterOperations<Mazo, MazoDocument, String, MazoMongoDBRepository> implements MazoRepository {

    public MazoMongoRepositoryAdapter(MazoMongoDBRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Mazo.class));
    }
}
