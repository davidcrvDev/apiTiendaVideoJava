package apitiendavideo.apitiendavideo.modelos;

import javax.persistence.*;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CLIENTE")
    private String id;

    @ManyToOne
    @JoinColumn(name = "IDTIPODOCUMENTO", referencedColumnName = "ID_TIPODOC")
    private TipoDocumento tipo_documento;

    @Column(name = "NOMBRE_CLIENTE", nullable = false, length = 60)
    private String nombre_cliente;

    @Column(name = "APELLIDO_CLIENTE", nullable = false, length = 60)
    private String apellido_cliente;

    @Column(name = "DIRECCION_CLIENTE", nullable = false, length = 50)
    private String direccion;

    @Column(name = "TELEFONO_CLIENTE", length = 20)
    private String telefono;

    @Column(name = "CORREO_CLIENTE", nullable = false, length = 50)
    private String correo;

    @Column(name = "MOVIL_CLIENTE", nullable = false, length = 20)
    private String movil;

    @Column(name = "CLAVE", nullable = false, length = 12)
    private String clave;

    @Column(name = "ROL", nullable = false, length = 20)
    private String rol;

    @Column(name = "MOROSO", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean moroso;

    @Column(name = "ACTIVO", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean activo;

    public Cliente() {
    }

    public Cliente(String id, TipoDocumento tipo_documento, String nombre_cliente, String apellido_cliente, String direccion, 
                    String telefono, String correo, String movil, String clave, String rol, boolean moroso, boolean activo) {
        this.id = id;
        this.tipo_documento = tipo_documento;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.movil = movil;
        this.clave = clave;
        this.rol = rol;
        this.moroso = moroso;
        this.activo = activo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getApellido_cliente() {
        return apellido_cliente;
    }

    public void setApellido_cliente(String apellido_cliente) {
        this.apellido_cliente = apellido_cliente;
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Boolean getMoroso() {
        return moroso;
    }

    public void setMoroso(Boolean moroso) {
        this.moroso = moroso;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    
    
}