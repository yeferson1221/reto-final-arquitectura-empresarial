package co.com.sofka.model.tablero.gateways;

import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.tablero.Tablero;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TableroRepository {

    Mono<Tablero> save(Tablero tablero);

    Flux<Tablero> findAll();

    Mono<Tablero> findById(String idJuego);

    Flux<Tablero> buscarTableroIdJuegoIdRonda(String idJuego, String idRonda);

    Mono<Tablero> buscarTableroIdJuegoIdRondaIdcarta(String idJuego, String idRonda, String idCarta);
}
