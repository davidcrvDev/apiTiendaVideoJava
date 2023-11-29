package apitiendavideo.apitiendavideo.interfaces;

import java.util.List;

import apitiendavideo.apitiendavideo.modelos.Usuario;

public interface IUsuarioServicio {

    public List<Usuario> listar();

    public Usuario login(String nombreUsuario, String clave);

    public Usuario nuevoUsuario(Usuario usuario);

    public Usuario obtener(Long id);

    public Usuario modificar(Usuario usuario);

    public List<Usuario> buscar(String nombreUsuario);

}
