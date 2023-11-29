package apitiendavideo.apitiendavideo.modelos;

import java.sql.Date;
//import com.fasterxml.jackson.annotation.JsonFormat;
//import java.time.LocalDate;
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
    private Integer consecutivo;

    @ManyToOne
    @JoinColumn(name = "IDDISPOSITIVO", referencedColumnName = "ID_DISPOSITIVO")//Pasa de ser "tecnologia" a "DISPOSITIVO"
    private Tecnologia tecnologia;

    @Column(name = "FECHA_ADQUISICION", nullable = false)
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaAdquisicion;

    @Column(name = "ACTIVO", nullable = false, length = 1)
    private String activo;

    public Inventario() {
    }

    public Inventario(long id, Titulo titulo, Integer consecutivo, Tecnologia tecnologia, Date fechaAdquisicion,
            String activo) {
        this.id = id;
        this.titulo = titulo;
        this.consecutivo = consecutivo;
        this.tecnologia = tecnologia;
        this.fechaAdquisicion = fechaAdquisicion;
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

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Tecnologia getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(Tecnologia tecnologia) {
        this.tecnologia = tecnologia;
    }

    public Date getFechaadquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaadquisicion(Date fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }


}
