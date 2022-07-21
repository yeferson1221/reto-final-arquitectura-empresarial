package co.com.sofka.usecase.mazo.crearmazo;

import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.juego.gateways.JuegoRepository;
import co.com.sofka.model.mazo.Mazo;
import co.com.sofka.model.mazo.gateways.MazoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearMazoUseCase {
    private final MazoRepository repository;
    public Mono<Mazo> crearMazo( Mazo mazo){
        return repository.save(mazo);
    }

}
