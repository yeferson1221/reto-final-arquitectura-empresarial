package co.com.sofka.usecase.jugador.apostarcarta;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.jugador.gateways.JugadorRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ApostarCartaUseCase {

    private final JugadorRepository jugadorRepository;


}
