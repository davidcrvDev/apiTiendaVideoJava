package apitiendavideo.apitiendavideo.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import apitiendavideo.apitiendavideo.modelos.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
    
    // @Query("SELECT u FROM Usuario u WHERE u.usuario like '%' || ?1 || '%'")
    // List<Usuario> buscar(String nombreUsuario);

    // Buscar usuario por cliente y clave
    Optional<Usuario> findByCliente_IdAndClave(Long clienteId, String clave);

    // Validar existencia de usuario por clave (o cualquier otro atributo)
    boolean existsByClave(String clave);

    // Listar usuarios de un cliente específico
    @Query("SELECT u FROM Usuario u WHERE u.cliente.id = ?1")
    List<Usuario> findByClienteId(Long clienteId);
}
