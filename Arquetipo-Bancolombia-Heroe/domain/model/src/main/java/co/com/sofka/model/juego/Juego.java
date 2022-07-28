package co.com.sofka.model.juego;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.tablero.Tablero;
import lombok.*;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Juego {

    private String id;
    private String ronda;
    private List<Jugador> jugadores;
    private Tablero tablero;
    private Jugador ganador;

    @Override
    public String toString() {
        return "Juego{" +
                "id='" + id + '\'' +
                ", ronda='" + ronda + '\'' +
                ", jugadores=" + jugadores +
                ", tablero=" + tablero +
                ", ganador=" + ganador +
                '}';
    }
}
