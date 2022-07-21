package co.com.sofka.model.juego;

import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.tablero.Tablero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Juego {

    private String id;
    private String numeroRonda;
    private Jugador jugador;
    private Carta carta;
    private Tablero tablero;
}
