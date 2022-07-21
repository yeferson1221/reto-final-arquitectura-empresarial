package co.com.sofka.mongo.documents.jugador;

import co.com.sofka.model.juego.Juego;
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
                .save(new JugadorDocument(jugador.getId(), jugador.getNombre(), jugador.getMazo(), jugador.getTurno(), jugador.getPuntaje()))
                .flatMap(element -> Mono.just(jugador));
    }

    @Override
    public Mono<Jugador> retirarse(String id, Juego juego) {
        return null;
    }

    @Override
    public Mono<Jugador> apostarCarta(String id, Jugador jugador) {
        jugador.setId(id);
        return repository
                .save(new JugadorDocument(jugador.getId(), jugador.getNombre(), jugador.getMazo(), jugador.getTurno(), jugador.getPuntaje()))
                .flatMap(x -> Mono.just(jugador));
    }
}