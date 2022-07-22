package co.com.sofka.usecase.mazo.crearmazo;

import co.com.sofka.model.carta.gateways.CartaRepository;
import co.com.sofka.model.mazo.Mazo;
import co.com.sofka.model.mazo.gateways.MazoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;

@RequiredArgsConstructor
public class CrearMazoUseCase {
    private final CartaRepository cartaRepository;
    private final MazoRepository mazoRepository;

    public Mono<Mazo> crearMazo() {
        return cartaRepository.findAll() // nos d flux de cartas
                .collectList() // mono de lista de cartas
                .map(cartas -> {
                    Collections.shuffle(cartas); // lo que hago es mapear  se aplica shuffle barajar
                    return cartas;
                }) // retornar ordenado
                .map(cartas -> cartas.subList(0, 5)) // traigame solo 5 utilizando metodo sublist
                .map(cartas -> Mazo.builder().mazo(cartas).build()); // construir un mazo
    }

    public Flux<Mazo> listarMazo() {
        return mazoRepository.findAll();
    }
}