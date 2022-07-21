package co.com.sofka.mongo.juego;

import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.tablero.Tablero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JuegoDocument {

    @Id
    private String id;
    private String numeroRonda;
    private Jugador jugador;
    private Carta carta;
    private Tablero tablero;
}
