package co.com.sofka.model.game;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Carta {
    private String id;
    private String nombre;
    private String descripcion;
    private Long valor;
}
