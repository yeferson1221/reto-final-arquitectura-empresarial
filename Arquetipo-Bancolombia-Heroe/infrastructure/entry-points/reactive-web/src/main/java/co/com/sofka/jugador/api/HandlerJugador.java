package co.com.sofka.jugador.api;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.usecase.jugador.actualizarjugador.ActualizarJugadorUseCase;
import co.com.sofka.usecase.jugador.crearjugador.CrearJugadorUseCase;
import co.com.sofka.usecase.jugador.listarjugador.ListarJugadorUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerJugador {

    private final CrearJugadorUseCase crearJudadorUseCase;
    private final ListarJugadorUseCase listarJugadorUseCase;

    private final ActualizarJugadorUseCase actualizarJugadorUseCase;

    public Mono<ServerResponse> crearJugadorUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Jugador.class)
                .flatMap(jugador -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(crearJudadorUseCase.crearJugador(jugador), Jugador.class));
    }

    public Mono<ServerResponse> listarJugadorUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listarJugadorUseCase.listarJugador(), Jugador.class);
    }

    public Mono<ServerResponse> actualizarJugadorUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Jugador.class)
                .flatMap(element -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(actualizarJugadorUseCase.actualizarJugador(id, element), Jugador.class));
    }
}
