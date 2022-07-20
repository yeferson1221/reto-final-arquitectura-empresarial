package co.com.sofka.model.game;
import lombok.Builder;
import lombok.Data;


@Data
@Builder(toBuilder = true)
public class Tablero {
    private String id;
    private Turno turno;
    private Carta carta;
    private Jugador jugador;
    private Juego  juego;
    private Puntaje puntaje;


}
