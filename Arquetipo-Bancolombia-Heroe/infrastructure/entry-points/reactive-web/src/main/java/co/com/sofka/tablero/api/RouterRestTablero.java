package co.com.sofka.tablero.api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRestTablero {
    @Bean
    public RouterFunction<ServerResponse> routerFunctionTablero(HandlerTablero handlerTablero) {
        return route(POST("/api/tablero"), handlerTablero::crearTableroUseCase)
                .and(route(GET("/api/tablero"), handlerTablero::listarTableroUseCase));
        // .and(route(GET("/api/usecase/{id}"), handler::listForIdUseCase))
        // .and(route(GET("/api/usecase/nombre/{name}"), handler::listarForNameUseCase))
        // .and(route(DELETE("/api/pet/{id}"), handler::deleteGETUseCase))
        // .and(route(POST("/api/pet/{id}"), handler::updatePOSTUseCase));
    }
}
