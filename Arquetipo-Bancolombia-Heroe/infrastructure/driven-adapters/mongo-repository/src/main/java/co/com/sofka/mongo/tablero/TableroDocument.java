package co.com.sofka.mongo.tablero;

import co.com.sofka.model.game.Carta;
import co.com.sofka.model.game.juego.Juego;
import co.com.sofka.model.game.Jugador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableroDocument {
    private String id;
    private Carta carta;
    private Jugador jugador;
    private Juego juego;
}
