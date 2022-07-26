package co.com.sofka.mazo.api;

import co.com.sofka.model.mazo.Mazo;
import co.com.sofka.usecase.mazo.MazoUseCase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerMazo {

    private final MazoUseCase mazoUseCase;

    public Mono<ServerResponse> crearMazoUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(mazoUseCase.crearMazo(), Mazo.class);
    }

    public Mono<ServerResponse> listarMazoUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(mazoUseCase.listarMazo(), Mazo.class);
    }
}