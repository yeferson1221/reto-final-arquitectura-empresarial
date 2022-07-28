package co.com.sofka.mongo.documents.mazo;

import co.com.sofka.model.carta.Carta;
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
public class MazoDocument {

    @Id
    private String id;
    private List<Carta> baraja;
    private Integer cantidad;
}
