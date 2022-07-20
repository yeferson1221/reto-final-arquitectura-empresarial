package co.com.sofka.mongo.juego;

import co.com.sofka.model.game.juego.Juego;
import co.com.sofka.model.game.juego.gateways.JuegoRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;

public class JuegoMongoRepositoryAdapter extends AdapterOperations<Juego, JuegoDocument, String, JuegoMongoDBRepository>
        implements JuegoRepository {

    public JuegoMongoRepositoryAdapter(JuegoMongoDBRepository repository, ObjectMapper mapper) {
        super(repository, mapper, document -> mapper.map(document, Juego.class));
    }
}
