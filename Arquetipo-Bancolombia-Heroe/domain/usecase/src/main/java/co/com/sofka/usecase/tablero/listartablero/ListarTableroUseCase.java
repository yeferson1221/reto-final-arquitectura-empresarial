package co.com.sofka.usecase.tablero.listartablero;

import co.com.sofka.model.tablero.Tablero;
import co.com.sofka.model.tablero.gateways.TableroRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListarTableroUseCase {
    private final TableroRepository repository;

    public Flux<Tablero> listarTablero(){
        return repository.findAll();
    }
}
