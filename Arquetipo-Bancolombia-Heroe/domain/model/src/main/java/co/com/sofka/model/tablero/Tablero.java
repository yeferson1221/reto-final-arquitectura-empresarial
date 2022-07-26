package co.com.sofka.model.tablero;

import co.com.sofka.model.carta.Carta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Tablero {

    private String id;
    private String idjugador;
    private String idcarta;
    private Integer tiempo;
    private String ronda;
    private String idJuego;


    @Override
    public String toString() {
        return "Tablero{" +
                "id='" + id + '\'' +
                ", carta=" + idcarta +
                ", jugador=" + idjugador +
                ", tiempo=" + tiempo +
                ", ronda=" + ronda +
                '}';
    }

}
