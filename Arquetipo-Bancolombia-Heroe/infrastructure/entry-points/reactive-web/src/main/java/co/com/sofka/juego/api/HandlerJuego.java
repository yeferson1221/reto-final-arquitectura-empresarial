package co.com.sofka.juego.api;

import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.juego.Juego;
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

    public Mono<ServerResponse> crearJuegoUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(juegoUseCase.crearJuego(), Juego.class);
    }

    public Flux<Carta> pasarCartasApostadasUseCase(ServerRequest serverRequest) {
        return juegoUseCase.pasarCartasApostadas();
    }

    public Mono<ServerResponse> eliminarJugadorUseCase(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("idjugador");
       // var juego = serverRequest.pathVariable("idjuego");
        var juego="";

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON) // expone la respuesta en formato json depende dle mediatype
                .body(juegoUseCase.retirarse(id, juego), Juego.class);
    }

    public Mono<ServerResponse> aumentaRondaUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Juego.class)
                .flatMap(juego -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(juegoUseCase.aumentarRonda(id), Juego.class));
    }
}
