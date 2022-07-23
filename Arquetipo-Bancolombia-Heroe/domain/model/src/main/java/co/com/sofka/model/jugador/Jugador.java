package co.com.sofka.model.jugador;

import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.mazo.Mazo;
import lombok.*;
import reactor.core.publisher.Mono;

import java.util.List;

@Data
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Jugador {
    private String id;
    private String nombre;
    private Mazo mazo;
    private String turno;
    private Integer puntaje;
}
