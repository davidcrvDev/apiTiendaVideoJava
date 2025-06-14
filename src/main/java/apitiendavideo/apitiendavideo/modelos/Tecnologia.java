package apitiendavideo.apitiendavideo.modelos;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "DISPOSITIVO") //El nombre de la tabla "tecnologia" pasa a ser ahora "DISPOSITIVO"
public class Tecnologia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_tecnologia")
    @GenericGenerator(name = "secuencia_tecnologia", strategy = "increment")
    @Column(name = "ID_DISPOSITIVO")
    private long id;

    @Column(name = "NOMBRE_DISPOSITIVO",nullable = false, length = 50)
    private String nombre;

    public Tecnologia() {
    }

    public Tecnologia(long id, String nombre) {
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