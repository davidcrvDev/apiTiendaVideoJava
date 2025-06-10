package apitiendavideo.apitiendavideo.modelos;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ALQUILER")
public class Alquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "secuencia_alquiler")
    @GenericGenerator(name = "secuencia_alquiler", strategy = "increment")
    @Column(name = "ID_ALQUILER")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "ID_CLIENTE") // Pasa de ser "tercero" a "CLIENTE"
    private Cliente cliente;

    @Column(name = "FECHA_PRESTAMO", nullable = false)
    private LocalDate fechaPrestamo;

    @Column(name = "PLAZO_ALQUILER")
    private int plazo;

    @Column(name = "FECHA_DEVOLUCION")
    private LocalDate fechaDevolucion;

    @Column(name = "PRECIO_ALQUILER", nullable = false)
    private double precio;

    @OneToMany(mappedBy = "alquiler", cascade = CascadeType.ALL, orphanRemoval = true) // 
    @JsonManagedReference
    private List<DetalleAlquiler> detalles;

    public Alquiler() {
    }

    public Alquiler(Long id, Cliente cliente, LocalDate fechaPrestamo, int plazo,
            LocalDate fechaDevolucion, double precio) {
        this.id = id;
        this.cliente = cliente;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleAlquiler> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleAlquiler> detalles) {
        this.detalles = detalles;
    }

}