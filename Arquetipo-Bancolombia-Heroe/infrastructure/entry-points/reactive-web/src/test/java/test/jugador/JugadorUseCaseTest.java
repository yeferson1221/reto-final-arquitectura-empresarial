package test.jugador;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.jugador.gateways.JugadorRepository;
import co.com.sofka.usecase.jugador.JugadorUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

class JugadorUseCaseTest {

    @InjectMocks
    private JugadorUseCase jugadorUseCaseTest;

    @Mock
    private JugadorRepository jugadorRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void crearJugadorCorrecto() {
        Jugador jugador = Jugador.builder()
                .id("4")
                .nombre("Santi")
                .turno("1")
                .puntaje(500)
                .build();

        when(jugadorRepository.findById("4")).thenReturn(Mono.just(jugador));

        StepVerifier.create(jugadorUseCaseTest.listarPorId("4"))
                .assertNext(jugador1 -> {
                    Assertions.assertEquals("4", jugador1.getId());
                    Assertions.assertEquals("Santi", jugador1.getNombre());
                    Assertions.assertEquals("1", jugador1.getTurno());
                    Assertions.assertEquals(500, jugador1.getPuntaje());
                })
                .expectComplete()
                .verify();
    }
}