package test;

import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.carta.gateways.CartaRepository;
import co.com.sofka.model.mazo.gateways.MazoRepository;
import co.com.sofka.usecase.mazo.crearmazo.CrearMazoUseCase;
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

import static org.mockito.Mockito.when;


class CrearMazoUseCaseTest {


    @InjectMocks
    private CrearMazoUseCase useCaseTest;

    @Mock
    private CartaRepository cartaRepository;

    @Mock
    private  MazoRepository mazoRepository;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

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

        List<Carta> listCarta = new ArrayList<>();
        listCarta.add(carta);
        listCarta.add(carta2);
        listCarta.add(carta3);
        listCarta.add(carta4);
        listCarta.add(carta5);
        listCarta.add(carta6);


        //mockiamos el metodo findAll pasando la lista creada anteriormente
        when(cartaRepository.findAll()).thenReturn(Flux.fromStream(listCarta.stream()));


        StepVerifier.create( useCaseTest.crearMazo())
                .assertNext(mazo -> Assertions.assertEquals(5,mazo.getMazo().size()))
                .expectComplete()
                .verify();
    }
}