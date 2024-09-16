package apitiendavideo.apitiendavideo.modelos;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "EMPRESA")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_empresa")
    @GenericGenerator(name = "secuencia_empresa", strategy = "increment")
    @Column(name = "ID_EMPRESA")
    private long id;

    @Column(name = "NOMBRE_EMPRESA",nullable = false, length = 50) //, unique = true
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "IDPAIS", referencedColumnName = "ID_PAIS")
    private Pais pais;

    public Empresa() {
    }

    public Empresa(long id, Pais pais, String nombre) {
        this.id = id;
        this.pais = pais;
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

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

}