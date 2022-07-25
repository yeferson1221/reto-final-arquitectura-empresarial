package co.com.sofka.model.mazo;

import co.com.sofka.model.carta.Carta;
import lombok.*;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Mazo {

    private String id;
    private List<Carta> baraja;
    private Integer cantidad;

    @Override
    public String toString() {
        return "Mazo{" +
                "id='" + id + '\'' +
                ", mazo=" + baraja +
                ", cantidad=" + cantidad +
                '}';
    }
}
