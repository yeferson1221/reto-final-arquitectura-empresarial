package co.com.sofka.usecase.tablero;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.tablero.Tablero;
import co.com.sofka.model.tablero.gateways.TableroRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class TableroUseCase {
    private final TableroRepository repository;

    public Mono<Tablero> crearTablero(Tablero tablero) {
        return repository.save(tablero);
    }

    public Flux<Tablero> listarTablero() {
        return repository.findAll();
    }

    public Mono<Tablero> mostrarGanadorJuego(String id, Jugador jugador) {
        return repository.mostrarGanadorJuego(id, jugador);
    }

    public Mono<Tablero> mostrarGanadorRonda(String id, Jugador jugador) {
        return repository.mostrarGanadorRonda(id, jugador);
    }
}
