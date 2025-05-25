package apitiendavideo.apitiendavideo.modelos;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "DISPOSITIVO")
public class Tecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_tecnologia")
    @GenericGenerator(name = "secuencia_tecnologia", strategy = "increment")
    @Column(name = "ID_DISPOSITIVO")
    private long id;

    @Column(name = "NOMBRE_DISPOSITIVO", nullable = false, length = 50)
    private String nombre;

    @Column(name = "FABRICANTE", length = 100)
    private String fabricante;

    @Column(name = "IDIOMAS_COMPATIBLES", length = 50)
    private String idiomas_compatibles;

    public Tecnologia() {
    }

    public Tecnologia(long id, String nombre, String fabricante, String idiomas_compatibles) {
        this.id = id;
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.idiomas_compatibles = idiomas_compatibles;
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

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getIdiomas_compatibles() {
        return idiomas_compatibles;
    }

    public void setIdiomas_compatibles(String idiomas_compatibles) {
        this.idiomas_compatibles = idiomas_compatibles;
    }
}
