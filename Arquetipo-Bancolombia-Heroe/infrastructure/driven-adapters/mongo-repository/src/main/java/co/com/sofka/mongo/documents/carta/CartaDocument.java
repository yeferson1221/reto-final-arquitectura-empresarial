package co.com.sofka.mongo.documents.carta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartaDocument {

    @Id
    private String id;
    private String nombre;
    private Long valor;
    private String uri;
    private Boolean esOculta;
}
