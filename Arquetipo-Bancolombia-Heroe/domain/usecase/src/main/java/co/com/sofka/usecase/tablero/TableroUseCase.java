package co.com.sofka.usecase.tablero;

import co.com.sofka.model.tablero.Tablero;
import co.com.sofka.model.tablero.gateways.TableroRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class TableroUseCase {
    private final TableroRepository tableroRepository;

    public Mono<Tablero> crearTablero(Tablero tablero) {
        return tableroRepository.save(tablero);
    }

    public Flux<Tablero> listarTablero() {
        return tableroRepository.findAll();
    }
}
