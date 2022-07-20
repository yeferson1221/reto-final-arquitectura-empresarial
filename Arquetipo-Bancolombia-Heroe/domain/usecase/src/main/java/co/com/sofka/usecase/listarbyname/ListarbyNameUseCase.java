package co.com.sofka.usecase.listarbyname;

import co.com.sofka.model.game.Tablero;
import co.com.sofka.model.game.gateways.TableroRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListarbyNameUseCase {

    private final TableroRepository repository;

    public Flux<Tablero> listarByName(String name) {
        return repository.findByName(name);
    }
}
