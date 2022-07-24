package co.com.sofka.juego.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRestJuego {


    @Bean
    public RouterFunction<ServerResponse> routerFunctionJuego(HandlerJuego handlerJuego) {

        return route(GET("/api/juego"), handlerJuego::crearJuegoUseCase)
                .andRoute(DELETE("api/juego/{idjugador}/{idjuego}"), handlerJuego::eliminarJugador)
                .andRoute(GET("api/ganadorjuego/{idjuego}"), handlerJuego::obtenerGanadorJuego);
    }
}

