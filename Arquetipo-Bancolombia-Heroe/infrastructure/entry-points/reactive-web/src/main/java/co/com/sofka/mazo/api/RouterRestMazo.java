package co.com.sofka.mazo.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRestMazo {

    @Bean
    public RouterFunction<ServerResponse> routerFunctionMazo(HandlerMazo handlerMazo) {

        return route(GET("/api/mazo"), handlerMazo::crearMazoUseCase)
                .andRoute(GET("/api/mazo/listar"), handlerMazo::listarMazoUseCase);
    }
}
