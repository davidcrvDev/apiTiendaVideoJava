package apitiendavideo.apitiendavideo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import apitiendavideo.apitiendavideo.interfaces.IUsuarioServicio;
import apitiendavideo.apitiendavideo.modelos.Usuario;
import apitiendavideo.apitiendavideo.repositorios.UsuarioRepositorio;
import apitiendavideo.apitiendavideo.servicios.UsuarioServicio;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    @Autowired
    private IUsuarioServicio servicio;
    private UsuarioRepositorio repositorio;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Usuario> listar() {
        return servicio.listar();
    }

    @RequestMapping(value = "/buscar/{nombreUsuario}", method = RequestMethod.GET)
    public List<Usuario> buscar(@PathVariable String nombreUsuario) {
        return servicio.buscar(nombreUsuario);
    }

    @RequestMapping(value = "/nuevoUsuario", method = RequestMethod.POST)
    public Usuario nuevoUsuario(@RequestBody Usuario usuario) {
        return servicio.nuevoUsuario(usuario);
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Usuario modificar(@RequestBody Usuario usuario) {
        if (servicio.obtener(usuario.getId()) != null) {
            return servicio.modificar(usuario);
        }
        else{
            return null;
        }
    }



    private Usuario usuario;
    @GetMapping("/login")
    public Usuario login(@RequestParam("usuario") String nombreUsuario,
     @RequestParam("clave") String clave) {
        
        // if(usuario.getUsuario() != nombreUsuario) {
        //     return null;
        // }
        // else{
        //     return servicio.login(nombreUsuario, clave);
        // }
        return servicio.login(nombreUsuario, clave);
    }

}
