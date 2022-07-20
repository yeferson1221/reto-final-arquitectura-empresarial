package co.com.sofka.model.game;

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
    private String name;
    private String email;
    private Long score;
    private String turno;
}
