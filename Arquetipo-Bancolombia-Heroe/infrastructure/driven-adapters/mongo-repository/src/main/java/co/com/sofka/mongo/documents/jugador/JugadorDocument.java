package co.com.sofka.mongo.documents.jugador;

import co.com.sofka.model.carta.Carta;
import co.com.sofka.model.mazo.Mazo;
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
public class JugadorDocument {

    @Id
    private String id;
    private String nombre;
    private Mazo mazo;
    private String turno;
    private Integer puntaje;
}
