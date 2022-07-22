package co.com.sofka.usecase.carta.actualizarcarta;

import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.carta.gateways.CartaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ActualizarCartaUseCase {

    private final CartaRepository cartaRepository;


}
