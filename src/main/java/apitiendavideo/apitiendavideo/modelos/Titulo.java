package apitiendavideo.apitiendavideo.modelos;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "TITULO")
public class Titulo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_titulo")
    @GenericGenerator(name = "secuencia_titulo", strategy = "increment")
    @Column(name = "ID_TITULO")
    private long id;

    @Column(name = "NOMBRE_TITULO",nullable = false, length = 50, unique = true)
    private String nombre;

    @Column(name = "AÑO_TITULO", nullable = false, length = 4)
    private int año;

    // @Column(name = "PROTAGONISTAS_TITULO", length = 500)
    // private String protagonistas;

    // @Column(name = "PRODUCTOR_TITULO", length = 50)
    // private String productor;

    @Column(name = "DIRECTOR_TITULO", length = 50)
    private String director;

    @ManyToOne
    @JoinColumn(name = "IDEMPRESA", referencedColumnName = "ID_EMPRESA")
    private Empresa empresa;

    @Column(name = "PRECIO_TITULO", nullable = false)
    private double precio;

    @OneToMany(mappedBy = "titulo")
    private List<Inventario> inventarios;

    public Titulo() {
    }

    public Titulo(long id, String nombre, int año, String protagonistas, String productor, String director,
            Empresa empresa, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.año = año;
        // this.protagonistas = protagonistas;
        // this.productor = productor;
        this.director = director;
        this.empresa = empresa;
        this.precio = precio;
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

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    // public String getProtagonistas() {
    //     return protagonistas;
    // }

    // public void setProtagonistas(String protagonistas) {
    //     this.protagonistas = protagonistas;
    // }

    // public String getProductor() {
    //     return productor;
    // }

    // public void setProductor(String productor) {
    //     this.productor = productor;
    // }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}