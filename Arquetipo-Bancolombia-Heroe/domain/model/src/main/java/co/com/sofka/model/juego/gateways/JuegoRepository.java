package co.com.sofka.model.juego.gateways;

import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.juego.Juego;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.swing.text.html.parser.Entity;

public interface JuegoRepository {

    Mono<Juego> save(Juego juego);

    Flux<Juego> findAll();

    Flux<Carta> pasarCartasApostadas();

    Mono<Juego> findById(String idJuego);


}
