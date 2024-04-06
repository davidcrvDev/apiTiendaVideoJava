package apitiendavideo.apitiendavideo.modelos;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ALQUILER")
public class Alquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "secuencia_alquiler")
    @GenericGenerator(name = "secuencia_alquiler", strategy = "increment")
    @Column(name = "ID_ALQUILER")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "IDINVENTARIO", referencedColumnName = "ID_INVENTARIO")
    private Inventario inventario;

    @ManyToOne
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "ID_CLIENTE") //Pasa de ser "tercero" a "CLIENTE"
    private Tercero tercero;

    @Column(name = "FECHA_PRESTAMO", nullable = false)
    private LocalDate fechaPrestamo;

    @Column(name = "PLAZO_ALQUILER")
    private int plazo;

    @Column(name = "FECHA_DEVOLUCION")
    private LocalDate fechaDevolucion;

    @Column(name = "PRECIO_ALQUILER", nullable = false)
    private double precio;

    public Alquiler() {
    }

    public Alquiler(Long id, Tercero tercero, LocalDate fechaPrestamo, int plazo,
                     LocalDate fechaDevolucion, double precio, Inventario inventario) {
        this.id = id;
        this.inventario = inventario;
        this.tercero = tercero;
        this.fechaPrestamo = fechaPrestamo;
        this.plazo = plazo;
        this.fechaDevolucion = fechaDevolucion;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Tercero getTercero() {
        return tercero;
    }

    public void setTercero(Tercero tercero) {
        this.tercero = tercero;
    }

}