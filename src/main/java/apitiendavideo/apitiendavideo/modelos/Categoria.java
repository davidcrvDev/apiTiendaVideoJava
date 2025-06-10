package apitiendavideo.apitiendavideo.modelos;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CATEGORIA")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_categoria")
    @GenericGenerator(name = "secuencia_categoria", strategy = "increment")
    @Column(name = "ID_CATEGORIA")
    private long id;

    @Column(name = "NOMBRE_CATEGORIA",nullable = false, length = 25)
    private String nombre;

    public Categoria() {
    }

    public Categoria(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
