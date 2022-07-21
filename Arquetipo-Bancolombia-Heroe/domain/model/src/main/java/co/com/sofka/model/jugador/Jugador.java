package co.com.sofka.model.jugador;

import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.mazo.Mazo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Jugador {

    private String id;
    private String nombre;
    private Mazo mazo;
    private String turno;
    //private List<Carta> cartas;
}
