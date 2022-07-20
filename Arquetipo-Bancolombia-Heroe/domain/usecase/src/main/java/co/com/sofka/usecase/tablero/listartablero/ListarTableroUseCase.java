package co.com.sofka.usecase.tablero.listartablero;

import co.com.sofka.model.game.Tablero;
import co.com.sofka.model.game.gateways.TableroRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListarTableroUseCase {
    private final TableroRepository repository;

    public Flux<Tablero> listarTablero(){
        return repository.findAll();
    }
}
