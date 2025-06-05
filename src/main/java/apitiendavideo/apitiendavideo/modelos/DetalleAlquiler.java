package apitiendavideo.apitiendavideo.modelos;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "DETALLE_ALQUILER")
public class DetalleAlquiler {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "secuencia_detalle_alquiler")
    @GenericGenerator(name = "secuencia_detalle_alquiler", strategy = "increment")
    @Column(name = "ID_DETALLE_ALQUILER")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "IDALQUILER", referencedColumnName = "ID_ALQUILER")
    @JsonBackReference
    private Alquiler alquiler;

    @ManyToOne
    @JoinColumn(name = "IDINVENTARIO", referencedColumnName = "ID_INVENTARIO")
    private Inventario inventario;

    @Column(name = "CANTIDAD", nullable = false)
    private int cantidad;

    @Column(name = "PRECIO_UNITARIO", nullable = false)
    private double precio_unitario;

    @Column(name = "SUBTOTAL", insertable = false, updatable = false)
    private double subtotal;

    public DetalleAlquiler() {
    }

    public DetalleAlquiler(Long id, Alquiler alquiler, Inventario inventario, int cantidad, 
                            double precio_unitario, double subtotal) {
        this.id = id;
        this.alquiler = alquiler;
        this.inventario = inventario;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.subtotal = subtotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

}
