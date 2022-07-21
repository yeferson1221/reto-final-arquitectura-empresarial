package co.com.sofka.model.mazo;
import co.com.sofka.model.carta.Carta;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class Mazo {
    private String id;
    private List<Carta>mazos;
    private Integer cantidad;
}
