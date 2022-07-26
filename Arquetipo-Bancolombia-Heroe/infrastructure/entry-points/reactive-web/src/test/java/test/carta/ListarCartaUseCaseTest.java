package test.carta;

import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.carta.gateways.CartaRepository;
import co.com.sofka.usecase.carta.CartaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

class ListarCartaUseCaseTest {

    @InjectMocks
    private CartaUseCase cartaUseCaseTest;

    @Mock
    private CartaRepository cartaRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarCartaCorrecto() {
        //arrange
        Carta carta = Carta.builder()
                .id("987")
                .nombre("Zodiac")
                .uri("")
                .valor(5L)
                .build();

        Carta carta1 = Carta.builder()
                .id("254")
                .nombre("Iron Man")
                .uri("")
                .valor(5L)
                .build();

        Carta carta2 = Carta.builder()
                .id("632")
                .nombre("Thor")
                .uri("")
                .valor(6L)
                .build();

        List<Carta> listCarta = new ArrayList<>();
        listCarta.add(carta);
        listCarta.add(carta1);
        listCarta.add(carta2);

        when(cartaRepository.findAll()).thenReturn(Flux.fromStream(listCarta.stream()));

        //asert
        StepVerifier.create(cartaRepository.findAll().collectList())
                .assertNext(cartas -> Assertions.assertEquals(3, cartas.size()))
                .expectComplete()
                .verify();
    }
}