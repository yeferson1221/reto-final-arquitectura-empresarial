package co.com.sofka.mongo.jugador;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.jugador.gateways.JugadorRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class JugadorMongoRepositoryAdapter extends AdapterOperations<Jugador, JugadorDocument, String, JugadorMongoDBRepository>
        implements JugadorRepository {

    public JugadorMongoRepositoryAdapter(JugadorMongoDBRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Jugador.class));
    }

    @Override
    public Mono<Jugador> update(String id, Jugador jugador) {
        jugador.setId(id);

        return repository
                .save(new JugadorDocument(jugador.getId(), jugador.getNombre(), jugador.getPuntos(), jugador.getTurno()))
                .flatMap(element -> Mono.just(jugador));
    }

//    @Override
//    public Mono<Void> delete(String id) {
//        repository.deleteById(id).;
//        var pet = repository.findById(id)
//                .flatMap(element -> {
//                    repository.deleteById(element.getId());
//                    return Mono.just(new Pet(element.getId(), element.getName(), element.getRaza()));
//                });
//        return repository.deleteById(id);
//    }
//
//    @Override
//    public Mono<Carta> update(String id, Carta carta) {
//        return null;
//    }
//
//    @Override
//    public Flux<Carta> findByName(String name) {
//        return null;
//    }
//
//     @Override
//    public Mono<Carta> update(String id, Carta carta) {
//        carta.setId(id);
//
//        return repository
//                .save(new CartaDocument(pet.getId(), pet.getName(), pet.getBreed()))
//                .flatMap(element -> Mono.just(pet));
//    }
//
//    @Override
//    public Flux<Carta> findByName(String name){
//        return  repository.findByName(name);
//    }
}
