package co.com.sofka.jugador.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRestJugador {

    @Bean
    public RouterFunction<ServerResponse> routerFunctionJugador(HandlerJugador handlerJugador) {
        return route(POST("/api/jugador"), handlerJugador::crearJugadorUseCase)
                .andRoute(GET("/api/jugador"), handlerJugador::listarJugadorUseCase)
                .andRoute(GET("/api/jugador/{id}"), handlerJugador::listarPorId)
                .andRoute(POST("/api/jugador/{id}"), handlerJugador::actualizarJugadorUseCase)
                .andRoute(POST("/api/jugador/apostar/{id}"), handlerJugador::apostarCarta);
    }
}
