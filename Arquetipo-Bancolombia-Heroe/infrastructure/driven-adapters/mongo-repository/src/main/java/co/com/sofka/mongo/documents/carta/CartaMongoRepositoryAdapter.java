package co.com.sofka.mongo.documents.carta;

import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.carta.gateways.CartaRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class CartaMongoRepositoryAdapter extends AdapterOperations<Carta, CartaDocument, String, CartaMongoDBRepository>
        implements CartaRepository {

    public CartaMongoRepositoryAdapter(CartaMongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Carta.class));
    }

    @Override
    public Mono<Carta> update(String id, Carta carta) {
        carta.setId(id);
        return repository
                .save(new CartaDocument(carta.getId(), carta.getNombre(), carta.getValor(), carta.getUri(), carta.getEsOculta()))
                .flatMap(element -> Mono.just(carta));
    }
}
