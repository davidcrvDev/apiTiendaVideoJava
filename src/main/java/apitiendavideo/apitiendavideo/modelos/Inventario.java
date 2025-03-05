package apitiendavideo.apitiendavideo.modelos;

import java.sql.Date;
//import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "INVENTARIO")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_INVENTARIO")
    private long id;

    @ManyToOne
    @JoinColumn(name = "IDTITULO", referencedColumnName = "ID_TITULO")
    private Titulo titulo;

    @Column(name = "DISPONIBLE", nullable = false)//Paso de ser "consecutivo" a "DISPONIBLE"
    private Integer disponible;

    @ManyToOne
    @JoinColumn(name = "IDDISPOSITIVO", referencedColumnName = "ID_DISPOSITIVO")//Pasa de ser "tecnologia" a "DISPOSITIVO"
    private Tecnologia tecnologia;

    @Column(name = "FECHA_ADQUISICION", nullable = false)
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaAdquisicion;

    @Column(name = "PRECIO_TITULO", nullable = false)
    private double precio;

    @Column(name = "ACTIVO", nullable = false, length = 1)
    private String activo;

    public Inventario() {
    }

    public Inventario(long id, Titulo titulo, Integer disponible, Tecnologia tecnologia, LocalDate fechaAdquisicion,
            Double precio, String activo) {
        this.id = id;
        this.titulo = titulo;
        this.disponible = disponible;
        this.tecnologia = tecnologia;
        this.fechaAdquisicion = fechaAdquisicion;
        this.precio = precio;
        this.activo = activo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

    public Integer getDisponible() {
        return disponible;
    }

    public void setDisponible(Integer disponible) {
        this.disponible = disponible;
    }

    public Tecnologia getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(Tecnologia tecnologia) {
        this.tecnologia = tecnologia;
    }

    public LocalDate getFechaadquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaadquisicion(LocalDate fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }


}
