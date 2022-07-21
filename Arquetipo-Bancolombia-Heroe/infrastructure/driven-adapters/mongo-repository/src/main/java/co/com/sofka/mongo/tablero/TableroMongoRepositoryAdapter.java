package co.com.sofka.mongo.tablero;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.tablero.Tablero;
import co.com.sofka.model.tablero.gateways.TableroRepository;
import co.com.sofka.mongo.helper.AdapterOperations;

import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class TableroMongoRepositoryAdapter extends AdapterOperations<Tablero, TableroDocument, String, TableroMongoDBRepository>
        implements TableroRepository {

    public TableroMongoRepositoryAdapter(TableroMongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Tablero.class));
    }

    @Override
    public Mono<Tablero> mostrarGanador(String id, Jugador jugador) {
        return null;
    }
}
