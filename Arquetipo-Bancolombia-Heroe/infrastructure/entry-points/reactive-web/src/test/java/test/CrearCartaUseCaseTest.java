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
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import static org.mockito.Mockito.when;

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
                .uri("www.gogole.com")
                .valor(5L)
                .build();
        //act
        when(cartaRepository.findById("123")).thenReturn(Mono.just(carta));
        //asert
        StepVerifier.create( useCaseTest.findById("123"))
                .assertNext(carta1 ->{
                    Assertions.assertEquals("Zodiac", carta1.getNombre());
                    Assertions.assertEquals("123", carta1.getId());
                } )
                .expectComplete()
                .verify();
    }


}