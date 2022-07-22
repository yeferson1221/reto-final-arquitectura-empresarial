package co.com.sofka.model.carta;
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
    private Long valor;
    private String uri;
    private Boolean esOculta;
}