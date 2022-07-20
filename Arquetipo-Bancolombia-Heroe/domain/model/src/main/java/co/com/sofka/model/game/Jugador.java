package co.com.sofka.model.game;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Jugador {
    private String id;
    private String name;
    private String email;
    private Long score;
    private String turno;

    public Jugador(String name, String email) {
        this.name = name;
        this.email = email;
        this.score = 0L;
    }

    public Jugador() {
    }
}
