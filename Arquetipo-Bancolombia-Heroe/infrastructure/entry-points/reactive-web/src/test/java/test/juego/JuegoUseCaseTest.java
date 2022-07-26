package test.juego;

import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.carta.gateways.CartaRepository;
import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.jugador.gateways.JugadorRepository;
import co.com.sofka.usecase.juego.JuegoUseCase;
import co.com.sofka.usecase.mazo.MazoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class JuegoUseCaseTest {

    @InjectMocks
    private JuegoUseCase juegoUseCase;

    @Mock
    private JugadorRepository jugadorRepository;

    @Mock
    private MazoUseCase mazoUseCase;

    @Mock
    private CartaRepository cartaRepository;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void crearJuego() {

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

        List<Carta> listCarta = new ArrayList<>();
        listCarta.add(carta);
        listCarta.add(carta2);
        listCarta.add(carta3);
        listCarta.add(carta4);
        listCarta.add(carta5);
        listCarta.add(carta6);

        List<Jugador> listJugador = new ArrayList<>();

        Jugador jugador1 = Jugador.builder()
                .id("123")
                .nombre("Juan").build();

        Jugador jugador2 = Jugador.builder()
                .id("321")
                .nombre("Aleja").build();

        Jugador jugador3 = Jugador.builder()
                .id("456")
                .nombre("David").build();

        Jugador jugador4 = Jugador.builder()
                .id("654")
                .nombre("Stella").build();


        //mockiamos el metodo findAll pasando la lista creada anteriormente
        when(cartaRepository.findAll()).thenReturn(Flux.fromStream(listCarta.stream()));

        when(jugadorRepository.findAll()).thenReturn(Flux.fromStream(listJugador.stream()));



        StepVerifier.create(juegoUseCase.crearJuego())
                .assertNext(juego -> Assertions.assertEquals("", juego.getId()))
                .expectComplete()
                .verify();
    }

    @Test
    void retirarse() {
    }
}