package co.com.sofka.carta.api;

import co.com.sofka.model.carta.Carta;
import co.com.sofka.usecase.carta.crearcarta.CrearCartaUseCase;
import co.com.sofka.usecase.carta.listarcarta.ListarCartaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerCarta {
    private final CrearCartaUseCase crearCartaUseCase;
    private final ListarCartaUseCase listarCartaUseCase;

    public Mono<ServerResponse> crearCartaUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Carta.class)
                .flatMap(carta -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(crearCartaUseCase.crearCarta(carta), Carta.class));
    }

    public Mono<ServerResponse> listarGETUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listarCartaUseCase.listarCarta(), Carta.class);
    }

}
