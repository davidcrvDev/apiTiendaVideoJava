package apitiendavideo.apitiendavideo.modelos;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CATEGORIA")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_categoria")
    @GenericGenerator(name = "secuencia_categoria", strategy = "increment")
    @Column(name = "ID_CATEGORIA")
    private long id;

    @Column(name = "NOMBRE_CATEGORIA", nullable = false, length = 25)
    private String nombre;

    @Column(name = "DESCRIPCION", length = 255)
    private String descripcion;

    @Column(name = "CLASIFICACION_EDAD", length = 20)
    private String clasificacion_edad;

    public Categoria() {
    }

    public Categoria(long id, String nombre, String descripcion, String clasificacion_edad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.clasificacion_edad = clasificacion_edad;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getClasificacion_edad() {
        return clasificacion_edad;
    }

    public void setClasificacion_edad(String clasificacion_edad) {
        this.clasificacion_edad = clasificacion_edad;
    }
}
