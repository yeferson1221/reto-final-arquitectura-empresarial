package co.com.sofka.model.tablero;
import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.juego.Juego;
import lombok.*;

import java.util.Map;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Tablero {

    private String id;
    private Map<String,Carta> carta;
    private Integer tiempo;


    @Override
    public String toString() {
        return "Tablero{" +
                "id='" + id + '\'' +
                ", carta=" + carta +
                ", tiempo=" + tiempo +
                '}';
    }

}
