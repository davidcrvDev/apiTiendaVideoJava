package apitiendavideo.apitiendavideo.modelos;

import javax.persistence.*;

@Entity
@Table(name = "CLIENTE") //La tabla "tercero" pasa a ser ahora "CLIENTE"
public class Tercero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE", length = 50)
    private String id;

    @ManyToOne
    @JoinColumn(name = "IDTIPODOCUMENTO", referencedColumnName = "ID_TIPODOC")
    private TipoDocumento tipoDocumento;

    @Column(name = "NOMBRE_CLIENTE", nullable = false, length = 60)
    private String nombre;

    @Column(name = "DIRECCION_CLIENTE", nullable = false, length = 50)
    private String direccion;

    @Column(name = "TELEFONO_CLIENTE", nullable = true, length = 20)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "IDCIUDAD", referencedColumnName = "ID_CIUDAD")
    private Ciudad ciudad;

    @Column(name = "CORREO_CLIENTE", nullable = false, length = 50)
    private String correo;

    @Column(name = "MOVIL_CLIENTE", nullable = false, length = 20)
    private String movil;


    // //Se borra documento, el ID ahora sera tambien el documento.
    // @Column(name = "documento", length = 50)
    // private String documento;

    // //Se borra(creo), no se le ve sentido y no concuerda con las columnas del DDL.
    // @Column(name = "tipopersona")
    // private TipoPersona tipoPersona;

    public Tercero(String id, TipoDocumento tipoDocumento, Ciudad ciudad, String direccion, String telefono, String movil,
            String correo, String nombre) { //, String documento, TipoPersona tipoPersona
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.movil = movil;
        this.correo = correo;
        this.nombre = nombre;
        // this.documento = documento;
        // this.tipoPersona = tipoPersona;
    }

    public Tercero() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
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

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // public String getDocumento() {
    //     return documento;
    // }

    // public void setDocumento(String documento) {
    //     this.documento = documento;
    // }

    // public TipoPersona getTipoPersona() {
    //     return tipoPersona;
    // }

    // public void setTipoPersona(TipoPersona tipoPersona) {
    //     this.tipoPersona = tipoPersona;
    // }

    // public boolean obligadoIva() {
    //     switch (this.tipoPersona) {
    //         case NATURAL:
    //             return false;
    //         case JURIDICA:
    //             return true;
    //         case PUBLICA:
    //             return false;
    //     }
    //     return false;
    // }

}