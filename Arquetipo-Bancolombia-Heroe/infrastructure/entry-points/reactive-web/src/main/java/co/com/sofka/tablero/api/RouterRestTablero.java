package co.com.sofka.tablero.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRestTablero {
    @Bean
    public RouterFunction<ServerResponse> routerFunctionTablero(HandlerTablero handlerTablero) {
        return route(POST("/api/tablero"), handlerTablero::crearTableroUseCase)
                .andRoute(GET("/api/tablero"), handlerTablero::listarTableroUseCase)
                .andRoute(DELETE("/api/tablero/{idTablero}"), handlerTablero::eliminarTableroPorIdUseCase)
                .andRoute(GET("/api/tablero/{idronda}/{idjuego}"), handlerTablero::obtenerGanadorRonda);
    }
}
