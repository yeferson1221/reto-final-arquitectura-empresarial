package co.com.sofka.model.mazo;

import co.com.sofka.model.carta.Carta;
import lombok.*;

import java.util.List;

@Data
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Mazo {

    private String id;
    private List<Carta> mazo;
    private Integer cantidad;
}
