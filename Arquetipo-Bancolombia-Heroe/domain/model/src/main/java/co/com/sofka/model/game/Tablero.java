package co.com.sofka.model.game;
import co.com.sofka.model.game.juego.Juego;
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
}
