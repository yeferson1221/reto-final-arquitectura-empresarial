package co.com.sofka.tablero.api;

import co.com.sofka.model.tablero.Tablero;
import co.com.sofka.usecase.tablero.creartablero.CrearTableroUseCase;
import co.com.sofka.usecase.tablero.listartablero.ListarTableroUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerTablero {
    private final CrearTableroUseCase crearTableroUseCase;
    private final ListarTableroUseCase listarTableroUseCase;

    public Mono<ServerResponse> crearTableroUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Tablero.class)
                .flatMap(tablero -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(crearTableroUseCase.crearTablero(tablero), Tablero.class));
    }

    public Mono<ServerResponse> listarTableroUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listarTableroUseCase.listarTablero(), Tablero.class);
    }
}
