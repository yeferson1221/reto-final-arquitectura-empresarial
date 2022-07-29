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

@Component
@RequiredArgsConstructor
public class HandlerJuego {

    private final JuegoUseCase juegoUseCase;

    public Mono<ServerResponse> listarJuegoUseCase(ServerRequest serverRequest){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(juegoUseCase.listarJuego(), Juego.class);
    }

    public Mono<ServerResponse> listarJuegoIdUseCase(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("idjuego");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(juegoUseCase.listarJuedoId(id), Juego.class);
    }

    public Mono<ServerResponse> crearJuegoUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(juegoUseCase.crearJuego(), Juego.class);
    }

    public Mono<ServerResponse> retirarseUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("idjugador");
        var juego = serverRequest.pathVariable("idjuego");

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON) // expone la respuesta en formato json depende dle mediatype
                .body(juegoUseCase.retirarse(id, juego), Juego.class);
    }

    /**
     * Handler para obtener el el ganador del juego.
     *
     * @param serverRequest Peticion
     * @return Jugador ganador.
     */
    public Mono<ServerResponse> obtenerGanadorJuego(ServerRequest serverRequest) {
        var idJuego = serverRequest.pathVariable("idjuego");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(juegoUseCase.obtenerGanadorJuego(idJuego), Jugador.class);
    }

    public Flux<Carta> pasarCartasAlGanadorUseCase(ServerRequest serverRequest) {
        return juegoUseCase.pasarCartasAlGanador();
    }


    public Mono<ServerResponse> aumentaRondaUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("idRonda");
        return serverRequest.bodyToMono(Juego.class)
                .flatMap(juego -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(juegoUseCase.aumentarRonda(id), Juego.class));
    }

}

