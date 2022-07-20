package co.com.sofka.mongo.jugador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JugadorDocument {
    @Id
    private String id;
    private String name;
    private String email;
    private Long score;
    private String turno;

}
