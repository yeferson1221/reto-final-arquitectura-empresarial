package co.com.sofka.usecase.jugador.crearjugador;

import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.jugador.gateways.JugadorRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearJugadorUseCase {

    private final JugadorRepository repository;

    public Mono<Jugador> crearJugador(Jugador jugador) {
        return repository.save(jugador);
    }

    public Mono<Jugador> actualizarJugador(String id, co.com.sofka.model.jugador.Jugador jugador) {
        return repository.update(id, jugador);
    }

    public Mono<Jugador> apostarCarta(String id, Jugador jugador) {
        return repository.apostarCarta(id, jugador);
    }

    public Flux<Jugador> listarJugador() {
        return repository.findAll();
    }

    public Mono<Jugador> retirarse(String id, Juego juego) {
        return repository.retirarse(id, juego);
    }

}
