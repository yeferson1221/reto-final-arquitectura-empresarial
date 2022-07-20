package co.com.sofka.tablero.api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRest {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(Handler handler) {
        return route(POST("/api/tablero"), handler::crearTableroUseCase)
                .and(route(GET("/api/tablero"), handler::listarTableroUseCase));
        // .and(route(GET("/api/usecase/{id}"), handler::listForIdUseCase))
        // .and(route(GET("/api/usecase/nombre/{name}"), handler::listarForNameUseCase))
        // .and(route(DELETE("/api/pet/{id}"), handler::deleteGETUseCase))
        // .and(route(POST("/api/pet/{id}"), handler::updatePOSTUseCase));
    }
}
