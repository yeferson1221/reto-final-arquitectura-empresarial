package co.com.sofka.usecase.juego.crearjuego;

import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.juego.gateways.JuegoRepository;
import co.com.sofka.model.jugador.gateways.JugadorRepository;
import co.com.sofka.model.mazo.gateways.MazoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;

@RequiredArgsConstructor
public class CrearJuegoUseCase {
    private final JuegoRepository juegoRepository;
    private final JugadorRepository jugadorRepository;
    private final MazoRepository mazoRepository;

    public Mono<Juego> crearJuego() {

        return jugadorRepository.findAll()
                .collectList()
                .map(jugador -> {
                    Collections.shuffle(jugador); // lo que hago es mapear  se aplica shuffle barajar
                    return jugador;}) // retornar ordenado
                .map(jugador -> jugador.subList(0,4)) // traigame solo 5 utilizando metodo sublist
                .map(jugador -> Juego.builder().jugadores(jugador).build());
    }

    public Mono<Juego> crearJuego(Juego juego) {
        return this.juegoRepository.save(juego);
    }



    public Flux<Juego> listarJuego() {
        return juegoRepository.findAll();
    }

}
