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

class ActualizarCartaUseCaseTest {

    @InjectMocks
    private CartaUseCase cartaUseCaseTest;

    @Mock
    private CartaRepository cartaRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void actualizarCartaCorrecto() {
        //arrange
        Carta carta = Carta.builder()
                .id("987")
                .nombre("Zodiac")
                .uri("")
                .valor(5L)
                .build();

        var command = cartaRepository.update(carta.getId(), carta);

        //act

        //asert
        StepVerifier.create(cartaUseCaseTest.actualizarCarta(carta.getId(), carta))
                .assertNext(carta1 -> Assertions.assertEquals("987", carta1.getId()))
                .expectComplete()
                .verify();
    }
}