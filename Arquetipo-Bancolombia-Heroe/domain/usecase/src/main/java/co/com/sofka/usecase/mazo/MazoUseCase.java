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
     *
     * @return
     */
    public Mono<Mazo> crearMazo() {
        return cartaRepository.findAll() // nos d flux de cartas
                .collectList()
                .map(cartas -> {
                    Collections.shuffle(cartas); // lo que hago es mapear  se aplica shuffle barajar
                    return cartas;
                })
                .map(cartas -> cartas.subList(0, 1))
                .map(cartas -> Mazo.builder().baraja(cartas).cantidad(cartas.size()).id(String.valueOf(Math.random()))
                        .build())
                .flatMap(mazoRepository::save); // construir un mazo
    }

    public Flux<Mazo> listarMazo() {
        return mazoRepository.findAll();
    }
}