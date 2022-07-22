package co.com.sofka.usecase.mazo.listarmazo;

import co.com.sofka.model.mazo.Mazo;
import co.com.sofka.model.mazo.gateways.MazoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListarMazoUseCase {

    private final MazoRepository mazoRepository;


}
