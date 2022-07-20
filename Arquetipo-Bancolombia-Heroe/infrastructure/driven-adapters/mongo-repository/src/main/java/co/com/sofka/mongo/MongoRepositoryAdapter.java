package co.com.sofka.mongo;

import co.com.sofka.model.game.Tablero;
import co.com.sofka.model.game.gateways.TableroRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class MongoRepositoryAdapter extends AdapterOperations<Tablero, PetDocument, String, MongoDBRepository>
        implements TableroRepository {

    public MongoRepositoryAdapter(MongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Tablero.class));
    }


    @Override
    public Mono<Void> delete(String id) {
//        repository.deleteById(id).;
//        var pet = repository.findById(id)
//                .flatMap(element -> {
//                    repository.deleteById(element.getId());
//                    return Mono.just(new Pet(element.getId(), element.getName(), element.getRaza()));
//                });
        return repository.deleteById(id);
    }

    @Override
    public Mono<Tablero> update(String id, Tablero pet) {
        pet.setId(id);

        return repository
                .save(new PetDocument(pet.getId(), pet.getName(), pet.getBreed()))
                .flatMap(element -> Mono.just(pet));
    }

    @Override
    public Flux<Tablero> findByName(String name){
        return  repository.findByName(name);
    }
}
