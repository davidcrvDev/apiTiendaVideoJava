package apitiendavideo.apitiendavideo.interfaces;

import java.util.List;

import apitiendavideo.apitiendavideo.modelos.Cliente;
import apitiendavideo.apitiendavideo.modelos.Usuario;

public interface IUsuarioServicio {

    public List<Usuario> listar();

    public Usuario login(Long clienteId, String clave);

    public Usuario nuevoUsuario(Usuario usuario);

    public Usuario obtener(Long id);

    public Usuario modificar(Usuario usuario);

    //public List<Usuario> buscar(String nombreUsuario); Comentado porque en el Repositorio y en el Servicio esta comentado

    Cliente obtenerClientePorId(Long idCliente);

    public boolean existePorId(Long id);
}
