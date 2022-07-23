package co.com.sofka.model.carta;
import lombok.*;

@Data
@ToString
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
