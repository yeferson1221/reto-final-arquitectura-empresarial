package co.com.sofka.juego.api;

import co.com.sofka.model.juego.Juego;
import co.com.sofka.usecase.juego.crearjuego.CrearJuegoUseCase;
import co.com.sofka.usecase.juego.listarjuego.ListarJuegoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerJuego {

    private final CrearJuegoUseCase crearJuegoUseCase;


    public Mono<ServerResponse> crearJuegoUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Juego.class)
                .flatMap(juego -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(crearJuegoUseCase.crearJuego(juego), Juego.class));
    }

    public Mono<ServerResponse> listarJuegoUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(crearJuegoUseCase.listarJuego(), Juego.class);
    }
}
