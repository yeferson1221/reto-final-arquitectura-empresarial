package co.com.sofka.juego.api;

import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.usecase.juego.JuegoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.swing.text.html.parser.Entity;

@Component
@RequiredArgsConstructor
public class HandlerJuego {

    private final JuegoUseCase crearJuegoUseCase;

    public Mono<ServerResponse> crearJuegoUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(crearJuegoUseCase.crearJuego(), Juego.class);
    }

    public Flux<Carta> pasarCartasApostadas(ServerRequest serverRequest) {
        return crearJuegoUseCase.pasarCartasApostadas();
    }

    public Mono<ServerResponse> eliminarJugador(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("idjugador");
       var juego = serverRequest.pathVariable("idjuego");


        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON) // expone la respuesta en formato json depende dle mediatype
                .body(crearJuegoUseCase.retirarse(id, juego), Juego.class);
    }

    /**
     * Handler para obtener el el ganador del juego.
     *
     * @param serverRequest Peticion
     * @return Jugador ganador.
     */
    public Mono<ServerResponse> obtenerGanadorJuego(ServerRequest serverRequest){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(crearJuegoUseCase.obtenerGanadorJuego(), Jugador.class);

    }
}
