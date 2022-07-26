package co.com.sofka.mongo.documents.tablero;

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
    private String idjugador;
    private String idcarta;
    private Integer tiempo;
    private String ronda;
    private String idJuego;
}
