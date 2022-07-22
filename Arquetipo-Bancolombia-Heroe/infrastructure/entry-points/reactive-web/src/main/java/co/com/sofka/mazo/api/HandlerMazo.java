package co.com.sofka.mazo.api;

import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.mazo.Mazo;
import co.com.sofka.usecase.mazo.crearmazo.CrearMazoUseCase;
import co.com.sofka.usecase.mazo.listarmazo.ListarMazoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerMazo {

    private final CrearMazoUseCase crearMazoUseCase;


    public Mono<ServerResponse> crearMazoUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(crearMazoUseCase.crearMazo(), Mazo.class);
    }

    public Mono<ServerResponse> listarMazoUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(crearMazoUseCase.listarMazo(), Mazo.class);
    }
}