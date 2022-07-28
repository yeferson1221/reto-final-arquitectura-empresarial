package co.com.sofka.model.carta;
import lombok.*;

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

    @Override
    public String toString() {
        return "Carta{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", valor=" + valor +
                ", uri='" + uri + '\'' +
                ", esOculta=" + esOculta +
                '}';
    }
}
