package co.com.sofka.tablero.api;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.tablero.Tablero;
import co.com.sofka.usecase.tablero.TableroUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerTablero {
    private final TableroUseCase tableroUseCase;

    public Mono<ServerResponse> crearTableroUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Tablero.class)
                .flatMap(tablero -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(tableroUseCase.crearTablero(tablero), Tablero.class));
    }

    public Mono<ServerResponse> listarTableroUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(tableroUseCase.listarTablero(), Tablero.class);
    }



    public Mono<ServerResponse> obtenerGanadorRonda(ServerRequest serverRequest) {
        var idRonda = serverRequest.pathVariable("idronda");
        var idJuego = serverRequest.pathVariable("idjuego");

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(tableroUseCase.jugarTablero(idRonda,idJuego), Jugador.class);
    }
}
