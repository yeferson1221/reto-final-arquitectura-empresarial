package co.com.sofka.carta.api;

import co.com.sofka.model.carta.Carta;
import co.com.sofka.usecase.carta.CartaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerCarta {
    private final CartaUseCase cartaUseCase;

    public Mono<ServerResponse> crearCartaUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Carta.class)
                .flatMap(carta -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(cartaUseCase.crearCarta(carta), Carta.class));
    }

    public Mono<ServerResponse> actualizarCartaUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Carta.class)
                .flatMap(element -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(cartaUseCase.actualizarCarta(id, element), Carta.class));
    }

    public Mono<ServerResponse> listarCartaUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(cartaUseCase.listarCarta(), Carta.class);
    }
}
