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
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static reactor.core.publisher.Mono.when;

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

        //act
        when((Publisher<?>) carta).thenReturn(carta.getNombre());


        //asert
        StepVerifier.create(cartaRepository.findAll());
                Assertions.assertEquals("Zodiac", carta.getNombre().toString());
                //.expectComplete().verify();
    }
}