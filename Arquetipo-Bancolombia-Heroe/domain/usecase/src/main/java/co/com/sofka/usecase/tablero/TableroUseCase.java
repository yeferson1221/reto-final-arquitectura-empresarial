package co.com.sofka.usecase.tablero;

import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.mazo.Mazo;
import co.com.sofka.model.tablero.Tablero;
import co.com.sofka.model.tablero.gateways.TableroRepository;
import co.com.sofka.usecase.jugador.JugadorUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class TableroUseCase {
    private final TableroRepository tableroRepository;
    private final JugadorUseCase jugadorUseCase;

    public Mono<Tablero> crearTablero(Tablero tablero) {
        return tableroRepository.save(tablero);
    }

    public Flux<Tablero> listarTablero() {
        return tableroRepository.findAll();
    }

    public Mono<Tablero> mostrarGanadorJuego(String id, Jugador jugador) {
        return tableroRepository.mostrarGanadorJuego(id, jugador);
    }

//    public Mono<Jugador> mostrarGanadorRonda(String idJugador, String idCarta) {
//
//        return jugadorUseCase
//                .listarPorId(idJugador)
//                .map(jugador -> {
//                    Mazo mazo = jugador.getMazo()
//                            .stream()
//                            .filter(jugador1 -> jugador1.getId() == id).findFirst().get();
//
//                    jugador.getJugadores()
//                            .remove(jugador);
//
//                    return jugador;
//
//                }).cast(Juego.class).flatMap(juegoRepository::save);
//    }

//    public Mono<Juego> retirarse(String id, String idJuego) {
//
//        return juegoRepository.findById(idJuego).map(juego -> {
//            Jugador jugador = juego.getJugadores()
//                    .stream()
//                    .filter(jugador1 -> jugador1.getId() == id).findFirst().get();
//
//            juego.getJugadores()
//                    .remove(jugador);
//
//            return juego;
//
//        }).cast(Juego.class).flatMap(juegoRepository::save);
//
//    }
}
