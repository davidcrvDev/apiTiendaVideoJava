package apitiendavideo.apitiendavideo.modelos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "USUARIO") //Esto es aparte para los usuarios que se logean a la app
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_USUARIO")
    private long id;

    @OneToOne //Es posible que a futuro sea @ManyToOne en caso de que 1 cliente pueda tener varios usuarios de ingreso y VICEVERSA
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "ID_CLIENTE")
    private Cliente cliente;

    @Column(name = "CLAVE", nullable = false, length = 12)
    private String clave;

    @Column(name = "ROL_USUARIO", length = 20)
    private String rol_usuario;

    //private String token;


    public Usuario() {
    }

    public Usuario(long id, Cliente cliente, String clave, String rol_usuario) {
        this.id = id;
        this.cliente = cliente;
        this.clave = clave;
        this.rol_usuario = rol_usuario;
    }

    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRolUsuario() {
        return rol_usuario;
    }

    public void setRolUsuario(String rol_usuario) {
        this.rol_usuario = rol_usuario;
    }

    // public String getToken() {
    //     return token;
    // }

    // public void setToken(String token) {
    //     this.token = token;
    // }

}