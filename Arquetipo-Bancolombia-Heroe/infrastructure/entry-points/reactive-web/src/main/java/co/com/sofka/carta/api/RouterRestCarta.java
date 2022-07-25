package co.com.sofka.carta.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RouterRestCarta {
    @Bean
    public RouterFunction<ServerResponse> routerFunctionCarta(HandlerCarta handlerCarta) {
        return route(POST("/api/carta"), handlerCarta::crearCartaUseCase)
                .andRoute(POST("/api/carta/{id}"), handlerCarta::actualizarCartaUseCase)
                .andRoute(GET("/api/carta"), handlerCarta::listarCartaUseCase);
    }
}
