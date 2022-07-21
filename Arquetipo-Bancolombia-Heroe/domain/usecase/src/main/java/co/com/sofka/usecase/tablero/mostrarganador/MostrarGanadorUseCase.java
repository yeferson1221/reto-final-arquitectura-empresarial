package co.com.sofka.usecase.tablero.mostrarganador;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.tablero.Tablero;
import co.com.sofka.model.tablero.gateways.TableroRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class MostrarGanadorUseCase {

    private final TableroRepository tableroRepository;

    public Mono<Tablero> mostrarGanador(String id, Jugador jugador) {
        return tableroRepository.mostrarGanador(id, jugador);
    }
}
