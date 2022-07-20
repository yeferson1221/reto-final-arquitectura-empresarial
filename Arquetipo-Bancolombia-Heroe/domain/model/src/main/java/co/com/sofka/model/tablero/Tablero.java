package co.com.sofka.model.tablero;
import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.jugador.Jugador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Tablero {
    private String id;
    private Carta carta;
    private Jugador jugador;
    private Juego juego;
    private Long puntos;
}
