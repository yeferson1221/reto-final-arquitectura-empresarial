package co.com.sofka.usecase.tablero;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.tablero.Tablero;
import co.com.sofka.model.tablero.gateways.TableroRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class TableroUseCase {
    private final TableroRepository tableroRepository;

    public Mono<Tablero> crearTablero(Tablero tablero) {
        //cuando se guarda verificar si estan todas las apuesas

        return tableroRepository.save(tablero);
    }

    public Flux<Tablero> listarTablero() {
        return tableroRepository.findAll();
    }

    public Mono<Jugador> obtenerGanadorRonda(String idRonda){
      return Mono.just(null);
    }
}
