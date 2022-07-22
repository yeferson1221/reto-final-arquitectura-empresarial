package test;

import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.usecase.carta.crearcarta.CrearCartaUseCase;
import co.com.sofka.usecase.jugador.crearjugador.CrearJugadorUseCase;
import co.com.sofka.usecase.mazo.crearmazo.CrearMazoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CrearMazoUseCaseTest {


    @Mock
    private CrearMazoUseCase useCaseTest;

    @Mock
    private CrearCartaUseCase crearCartaUseCase;



    @BeforeEach
    void setUp() {
    }

    @Test
    void crearMazoAleatorioMaximo5Cartas() {

        Carta carta = Carta.builder()
                .id("123")
                .nombre("Zodiac")
                .uri("")
                .valor(5L)
                .build();

        Carta carta2 = Carta.builder()
                .id("321")
                .nombre("Zodiac")
                .uri("")
                .valor(5L)
                .build();

        Carta carta3 = Carta.builder()
                .id("456")
                .nombre("Zodiac")
                .uri("")
                .valor(5L)
                .build();

        Carta carta4 = Carta.builder()
                .id("654")
                .nombre("Zodiac")
                .uri("")
                .valor(5L)
                .build();

        Carta carta5 = Carta.builder()
                .id("789")
                .nombre("Zodiac")
                .uri("")
                .valor(5L)
                .build();

        Carta carta6 = Carta.builder()
                .id("987")
                .nombre("Zodiac")
                .uri("")
                .valor(5L)
                .build();

        crearCartaUseCase.crearCarta(carta);
        crearCartaUseCase.crearCarta(carta6);
        crearCartaUseCase.crearCarta(carta2);
        crearCartaUseCase.crearCarta(carta3);
        crearCartaUseCase.crearCarta(carta4);
        crearCartaUseCase.crearCarta(carta5);

        //Cuando se ejecute el metodo crearJugador cualquier objeto de tipo jugador
        when(crearCartaUseCase.crearCarta(any(Carta.class))).thenReturn(Mono.just(carta));

        StepVerifier.create( useCaseTest.crearMazo())
                .assertNext(mazo -> Assertions.assertEquals(5,mazo.getMazo().size()))
                .expectComplete()
                .verify();
    }
}