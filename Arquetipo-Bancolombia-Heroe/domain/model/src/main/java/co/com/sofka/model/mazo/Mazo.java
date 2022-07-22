package co.com.sofka.model.mazo;

import co.com.sofka.model.carta.Carta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Mazo {

    private String id;
    private List<Carta> mazo;
    private Integer cantidad;
}
