package apitiendavideo.apitiendavideo.dtos;

public class ClienteDTO {
    public Long id;
    public String nombre;
    public String correo;
    public String rol;

    public ClienteDTO(Long id, String nombre, String correo, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
    }
}
