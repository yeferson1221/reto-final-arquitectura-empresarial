package co.com.sofka.mongo.documents.juego;

import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.juego.gateways.JuegoRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class JuegoMongoRepositoryAdapter extends AdapterOperations<Juego, JuegoDocument, String, JuegoMongoDBRepository>
        implements JuegoRepository {

    public JuegoMongoRepositoryAdapter(JuegoMongoDBRepository repository, ObjectMapper mapper) {
        super(repository, mapper, document -> mapper.map(document, Juego.class));
    }

    @Override
    public Flux<Carta> pasarCartasApostadas() {
        return null;
    }
}
