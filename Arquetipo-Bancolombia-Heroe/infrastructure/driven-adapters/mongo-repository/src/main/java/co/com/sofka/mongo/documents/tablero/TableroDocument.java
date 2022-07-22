package co.com.sofka.mongo.documents.tablero;

import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.jugador.Jugador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableroDocument {
    private String id;
    private Map<String,Carta> carta;
    private Integer tiempo;
}
