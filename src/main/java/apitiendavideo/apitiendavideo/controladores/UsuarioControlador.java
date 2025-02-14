package apitiendavideo.apitiendavideo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import apitiendavideo.apitiendavideo.interfaces.IUsuarioServicio;
import apitiendavideo.apitiendavideo.modelos.Cliente;
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

    // Cometado porque en: Repositorio, Servicio, IServicio y Controlador estan comentados
    // @RequestMapping(value = "/buscar/{nombreUsuario}", method = RequestMethod.GET)
    // public List<Usuario> buscar(@PathVariable String nombreUsuario) {
    //     return servicio.buscar(nombreUsuario);
    // }

    //Codigo anterior de Crear nuevoUsuario
    // @RequestMapping(value = "/nuevoUsuario", method = RequestMethod.POST)
    // public Usuario nuevoUsuario(@RequestBody Usuario usuario) {
    //     return servicio.nuevoUsuario(usuario);
    // }

    // Crear un nuevo usuario
    @PostMapping("/nuevoUsuario")
    public ResponseEntity<?> nuevoUsuario(@RequestBody Usuario usuario, 
                                          @RequestParam Long idCliente) {
        // Validar si el usuario ya existe (por su ID, clave o cualquier otro criterio relevante)
        if (servicio.existePorId(usuario.getId())) {
            return ResponseEntity.badRequest().body("El usuario ya existe.");
        }

        // Vincular con cliente
        Cliente cliente = servicio.obtenerClientePorId(idCliente);
        if (cliente == null) {
            return ResponseEntity.badRequest().body("El cliente no existe.");
        }
        usuario.setCliente(cliente);

        Usuario nuevoUsuario = servicio.nuevoUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    //Codigo anterior de modificarUsuario
    // @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    // public Usuario modificar(@RequestBody Usuario usuario) {
    //     if (servicio.obtener(usuario.getId()) != null) {
    //         return servicio.modificar(usuario);
    //     }
    //     else{
    //         return null;
    //     }
    // }

    // Modificar un usuario existente
    @PutMapping("/modificar")
    public ResponseEntity<?> modificar(@RequestBody Usuario usuario) {
        if (servicio.obtener(usuario.getId()) == null) {
            return ResponseEntity.badRequest().body("El usuario no existe.");
        }

        Usuario usuarioModificado = servicio.modificar(usuario);
        return ResponseEntity.ok(usuarioModificado);
    }


    //Codigo anterior de login del usuario
    // private Usuario usuario;
    // @GetMapping("/login")
    // public Usuario login(@RequestParam("usuario") String nombreUsuario,
    //  @RequestParam("clave") String clave) {
        
    //     // if(usuario.getUsuario() != nombreUsuario) {
    //     //     return null;
    //     // }
    //     // else{
    //     //     return servicio.login(nombreUsuario, clave);
    //     // }
    //     return servicio.login(nombreUsuario, clave);
    // }

    // Login de usuario
    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam("usuario") Long clienteId,
                                   @RequestParam("clave") String clave) {
        // Usuario usuario = servicio.login(clienteId, clave);
        // if (usuario == null) {
        //     return ResponseEntity.status(401).body("Credenciales incorrectas.");
        // }

        return ResponseEntity.ok("Logueado");
    }

}
