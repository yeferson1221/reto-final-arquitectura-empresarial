package co.com.sofka.api;

import co.com.sofka.model.game.Carta;
import co.com.sofka.usecase.carta.crearcarta.CrearCartaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    private final CrearCartaUseCase crearCartaUseCase;





    public Mono<ServerResponse> crearCartaUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Carta.class)
                .flatMap(crearCartaUseCase::crearCarta)
                .flatMap(carta -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(crearCartaUseCase.crearCarta(carta), Carta.class));
    }

}
