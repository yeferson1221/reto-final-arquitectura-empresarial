package co.com.sofka.juego.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRestJuego {

    @Bean
    public RouterFunction<ServerResponse> routerFunctionJuego(HandlerJuego handlerJuego) {

        return route(GET("/api/juego"), handlerJuego::crearJuegoUseCase)
                .andRoute(GET("api/juego/lista"), handlerJuego::listarJuegoUseCase)
                .andRoute(GET("api/ganadorjuego/{idjuego}"), handlerJuego::obtenerGanadorJuego)
                .andRoute(DELETE("api/juego/{idjugador}/{idjuego}"), handlerJuego::retirarseUseCase)
                .andRoute(GET("api/juego/{idRonda}"), handlerJuego::aumentaRondaUseCase);

    }
}

