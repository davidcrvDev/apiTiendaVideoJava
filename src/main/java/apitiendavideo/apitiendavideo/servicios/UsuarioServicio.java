package apitiendavideo.apitiendavideo.servicios;

//import java.util.Date;
import java.util.List;
import java.util.Optional;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import apitiendavideo.apitiendavideo.interfaces.IUsuarioServicio;
import apitiendavideo.apitiendavideo.modelos.Usuario;
import apitiendavideo.apitiendavideo.repositorios.UsuarioRepositorio;
import apitiendavideo.apitiendavideo.modelos.Cliente;
import apitiendavideo.apitiendavideo.repositorios.ClienteRepositorio;
// import apitiendavideo.apitiendavideo.seguridad.FiltroSeguridad;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;


@Service
public class UsuarioServicio implements IUsuarioServicio {

    @Autowired
    private UsuarioRepositorio repositorio;
    
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Override
    public List<Usuario> listar(){
        return repositorio.findAll();
    }

    /*Codigo anterior de: nuevoUsuario
    @Override
    public Usuario nuevoUsuario(Usuario usuario){
        return repositorio.save(usuario);
    }*/
    @Override
    public Usuario nuevoUsuario(Usuario usuario) {
        // Verificar si el cliente asociado existe antes de guardar el usuario
        if (usuario.getCliente() != null) {
            Optional<Cliente> clienteExistente = clienteRepositorio.findById(usuario.getCliente().getId());
            if (clienteExistente.isPresent()) {
                usuario.setCliente(clienteExistente.get()); // Asignar cliente existente
            } else {
                // Manejar el caso en que el cliente no exista (opcional)
                throw new IllegalArgumentException("Cliente no encontrado para el usuario."); // Anteriormente: return null
            }
        }
        return repositorio.save(usuario); // Guardar el usuario
    }

    /*Codigo anterior de: modificar
    @Override
    public Usuario modificar(Usuario usuario){
        return repositorio.save(usuario);
    }*/
    @Override
    public Usuario modificar(Usuario usuario) {
        // Verificar que el usuario existe
        Optional<Usuario> usuarioExistente = repositorio.findById(usuario.getId());
        if (usuarioExistente.isPresent()) {
            // Verificar si el cliente también necesita actualizarse
            if (usuario.getCliente() != null) {
                Optional<Cliente> clienteExistente = clienteRepositorio.findById(usuario.getCliente().getId());
                if (clienteExistente.isPresent()) {
                    usuario.setCliente(clienteExistente.get());
                } else {
                    throw new IllegalArgumentException("Cliente no encontrado para el usuario."); // Anteriormente: return null
                }
            }
            return repositorio.save(usuario); // Guardar los cambios
        }
        return null;
    }

    //Comentado porque en el Repositorio tambien se ha comentado
    // @Override
    // public List<Usuario> buscar(String nombreUsuario){
    //     return repositorio.buscar(nombreUsuario);
    // }

    @Override
    public Usuario obtener(Long id){
        return repositorio.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con ID: " + id));//.orElse(null);
    }

    @Override
    public Usuario login(Long clienteId, String clave) {
        return repositorio.findByCliente_IdAndClave(clienteId, clave)
                        .orElse(null); // Devuelve null si no encuentra al usuario
    }



    /*Codigo anterior de: login
    @Override
    public Usuario login(String nombreUsuario, String clave) {
        
        Usuario usuario = new Usuario(); 

        usuario.setUsuario(nombreUsuario);
        usuario.setClave(clave);

        if(usuario.getUsuario() != nombreUsuario) {
            return null;
        }
        else{
            //String token = obtenerJWTToken(nombreUsuario);
        
            //usuario.setToken(token);
            return usuario;
        }

        
        // String token = obtenerJWTToken(nombreUsuario);
        
        // usuario.setToken(token);
        // return usuario;
    }*/

    // private String obtenerJWTToken(String nombreUsuario) {

    //     List<GrantedAuthority> grantedAuthorities = AuthorityUtils
    //             .commaSeparatedStringToAuthorityList("ROLE_USER");

    //     String token = Jwts
    //             .builder()
    //             .setId("tiendavideo")
    //             .claim("authorities",
    //                     grantedAuthorities.stream()
    //                             .map(GrantedAuthority::getAuthority)
    //                             .collect(Collectors.toList()))
    //             .setIssuedAt(new Date(System.currentTimeMillis()))
    //             .setExpiration(new Date(System.currentTimeMillis() + 3000000))
    //             .signWith(SignatureAlgorithm.HS512, FiltroSeguridad.SECRETO.getBytes())
    //             .compact();

    //     return "Bearer " + token;
    // }

    @Override
    public Cliente obtenerClientePorId(Long idCliente) {
        return clienteRepositorio.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + idCliente));
    }

    public boolean existePorId(Long id) {
        return repositorio.existsById(id); // Ajusta según tu repositorio
    }
    
    public boolean existePorClave(String clave) {
        return repositorio.existsByClave(clave);
    }
    

}
