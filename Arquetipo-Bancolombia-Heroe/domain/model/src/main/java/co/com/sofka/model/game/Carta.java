package co.com.sofka.model.game;

public class Carta {
    private String id;
    private String nombre;
    private String descripcion;
    private Long valor;

    public Carta(String id, String nombre, String descripcion, Long valor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor = valor;
    }
}
