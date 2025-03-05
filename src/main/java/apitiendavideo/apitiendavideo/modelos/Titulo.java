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

    @Column(name = "NOMBRE_TITULO", nullable = false, length = 50) //, unique = true
    private String nombre;

    @Column(name = "ANO_TITULO", nullable = false, length = 4)
    private int ano;

    // @Column(name = "PROTAGONISTAS_TITULO", length = 500)
    // private String protagonistas;

    // @Column(name = "PRODUCTOR_TITULO", length = 50)
    // private String productor;

    @Column(name = "DIRECTOR_TITULO", length = 50)
    private String director;

    @ManyToOne
    @JoinColumn(name = "IDCATEGORIA", referencedColumnName = "ID_CATEGORIA")
    private Categoria categoria;

    @OneToMany(mappedBy = "titulo")
    private List<Inventario> inventarios;

    public Titulo() {
    }

    public Titulo(long id, String nombre, int ano, String director,
            Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.ano = ano;
        this.director = director;
        this.categoria = categoria;
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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}