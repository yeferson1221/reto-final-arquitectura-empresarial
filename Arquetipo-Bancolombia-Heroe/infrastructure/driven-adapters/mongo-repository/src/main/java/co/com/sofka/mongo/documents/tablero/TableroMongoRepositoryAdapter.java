package co.com.sofka.mongo.documents.tablero;

import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.tablero.Tablero;
import co.com.sofka.model.tablero.gateways.TableroRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
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
    public Flux<Tablero> delateAll() {
        return null;
    }

    @Override
   public Flux<Tablero> buscarTableroIdJuegoIdRonda(String idJuego, String idRonda){
        return repository.findAllByIdJuegoAndRonda(idJuego,idRonda);
    }

    @Override
    public Mono<Tablero> buscarTableroIdJuegoIdRondaIdcarta(String idJuego, String idRonda, String idCarta) {
        return repository.findAllByIdJuegoAndRondaAndIdcarta(idJuego,idRonda,idCarta);
    }


}