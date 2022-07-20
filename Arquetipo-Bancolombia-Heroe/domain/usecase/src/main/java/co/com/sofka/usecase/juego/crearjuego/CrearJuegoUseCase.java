package co.com.sofka.usecase.juego.crearjuego;

import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.juego.gateways.JuegoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearJuegoUseCase {

    private final JuegoRepository juegoRepository;

    public Mono<Juego> crearJuego(Juego juego) {
        return this.juegoRepository.save(juego);
    }
}
