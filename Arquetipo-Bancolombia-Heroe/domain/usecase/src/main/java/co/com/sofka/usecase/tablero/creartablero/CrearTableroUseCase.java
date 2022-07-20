package co.com.sofka.usecase.tablero.creartablero;
import co.com.sofka.model.tablero.Tablero;
import co.com.sofka.model.tablero.gateways.TableroRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearTableroUseCase {
    private final TableroRepository repository;
    public Mono<Tablero> crearTablero(Tablero tablero){
        return repository.save(tablero);
    }
}
