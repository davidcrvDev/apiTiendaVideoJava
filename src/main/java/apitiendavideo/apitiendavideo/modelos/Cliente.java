package apitiendavideo.apitiendavideo.modelos;

import javax.persistence.*;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CLIENTE")
    private long id;

    @ManyToOne
    @JoinColumn(name = "IDTIPODOCUMENTO", referencedColumnName = "ID_TIPODOC")
    private TipoDocumento tipo_documento;

    @Column(name = "NOMBRE_CLIENTE", nullable = false, length = 60)
    private String nombre_cliente;

    @Column(name = "DIRECCION_CLIENTE", nullable = false, length = 50)
    private String direccion;

    @Column(name = "TELEFONO_CLIENTE", length = 20)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "IDCIUDAD", referencedColumnName = "ID_CIUDAD")
    private Ciudad ciudad;

    @Column(name = "CORREO_CLIENTE", nullable = false, length = 50)
    private String correo;

    @Column(name = "MOVIL_CLIENTE", nullable = false, length = 20)
    private String movil;

    public Cliente() {
    }

    public Cliente(long id, TipoDocumento tipo_documento, String nombre_cliente, String direccion, String telefono,
            Ciudad ciudad, String correo, String movil) {
        this.id = id;
        this.tipo_documento = tipo_documento;
        this.nombre_cliente = nombre_cliente;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.correo = correo;
        this.movil = movil;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TipoDocumento getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(TipoDocumento tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    
    
}
