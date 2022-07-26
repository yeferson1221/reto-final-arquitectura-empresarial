package co.com.sofka.usecase.mazo;

import co.com.sofka.model.carta.gateways.CartaRepository;
import co.com.sofka.model.mazo.Mazo;
import co.com.sofka.model.mazo.gateways.MazoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;

@RequiredArgsConstructor
public class MazoUseCase {
    private final CartaRepository cartaRepository;
    private final MazoRepository mazoRepository;

    /**
     * Obtenemos todas las cartas las coleecionamos, sobre la lista cartas
     * aplicamos el shuffle que permite mezclar los elementos,
     * creamos un map para transformar y obtener una sublist de 5 elementos,
     * finalmente construimos un mazo y agregamos las cartas y la cantidad y ud id
     * generado aleatoriamente.
     * @return
     */
    public Mono<Mazo> crearMazo() {
        return cartaRepository.findAll() // nos d flux de cartas
                .collectList() // mono de lista de cartas
                .map(cartas -> {
                    Collections.shuffle(cartas); // lo que hago es mapear  se aplica shuffle barajar
                    return cartas;
                }) // retornar ordenado
                .map(cartas -> cartas.subList(0, 5)) // traigame solo 5 utilizando metodo sublist
                .map(cartas -> Mazo.builder().baraja(cartas).cantidad(5).id(String.valueOf(Math.random())).build()); // construir un mazo
    }

    public Flux<Mazo> listarMazo() {
        return mazoRepository.findAll();
    }
}