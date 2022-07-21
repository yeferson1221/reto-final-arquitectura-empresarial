package co.com.sofka.mongo.documents.juego;

import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.tablero.Tablero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JuegoDocument {

    @Id
    private String id;
    private String ronda;
    private List<Jugador> jugadore;
    private Tablero tablero;
    private Jugador ganador;
}
