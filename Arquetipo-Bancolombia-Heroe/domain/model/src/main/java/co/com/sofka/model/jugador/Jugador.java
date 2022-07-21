package co.com.sofka.model.jugador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Jugador {
    private String id;
    private String nombre;
    private String email;
    private Long puntos;
    private String turno;
}
