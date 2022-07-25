package test;

import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.carta.gateways.CartaRepository;
import co.com.sofka.usecase.carta.CartaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.test.StepVerifier;

class CrearCartaUseCaseTest {

    @InjectMocks
    private CartaUseCase useCaseTest;

    @Mock
    private CartaRepository cartaRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void crearCartaCorrecta() {

        Carta carta = Carta.builder()
                .id("123")
                .nombre("Zodiac")
                .uri("")
                .valor(5L)
                .build();
        var command = new Carta(carta.getId(), carta.getNombre(), carta.getValor(), carta.getUri(), carta.getEsOculta());

        //act

        //asert
        StepVerifier.create(useCaseTest.crearCarta(carta))
                .assertNext(carta1 -> Assertions.assertEquals("Zodiac", carta1.getNombre().toString()))
                .expectComplete().verify();
    }
}