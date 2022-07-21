package co.com.sofka.jugador.api;

import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.usecase.jugador.actualizarjugador.ActualizarJugadorUseCase;
import co.com.sofka.usecase.jugador.apostarcarta.ApostarCartaUseCase;
import co.com.sofka.usecase.jugador.crearjugador.CrearJugadorUseCase;
import co.com.sofka.usecase.jugador.listarjugador.ListarJugadorUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class HandlerJugadorTest {

    @Mock
    private  CrearJugadorUseCase crearJudadorUseCase;
    @Mock
    private  ListarJugadorUseCase listarJugadorUseCase;
    @Mock
    private  ActualizarJugadorUseCase actualizarJugadorUseCase;
    @Mock
    private  ApostarCartaUseCase apostarCartaUseCase;

    //permite simular una peticion
    private WebTestClient client;

    @BeforeEach
    void setUp() {
        //se crean los mocks
        MockitoAnnotations.openMocks(this);

        HandlerJugador handler =new HandlerJugador( crearJudadorUseCase, listarJugadorUseCase,
                actualizarJugadorUseCase,apostarCartaUseCase);
                RouterRestJugador router = new RouterRestJugador();

        //simulacion de peticion a handler por medio del router
        this.client = WebTestClient.bindToRouterFunction(router.routerFunctionJugador(handler))
                .configureClient().baseUrl("/api/").build();

    }

    @Test
    void crearJugadorUseCase() {



        Jugador jugador = Jugador.builder()
                .id("123")
                .nombre("Yisus")
                .puntos(0L)
                .turno("1")
                .build();

        Map<String,String > request = new HashMap<>();
        request.put("nombre","Santi");
        request.put("puntos","0");
        request.put("turno","1");
        request.put("id","16543");
        request.put("cartas","1");

        //Cuando se ejecute el metodo crearJugador cualquier objeto de tipo jugador
        when(crearJudadorUseCase.crearJugador(any(Jugador.class))).thenReturn(Mono.just(jugador));

        this.client.post().uri("jugador").bodyValue(jugador).exchange().expectStatus()
                .isOk()
                .expectBody(Jugador.class)
                .isEqualTo(jugador);



    }

    @Test
    void listarJugadorUseCase() {
    }
}