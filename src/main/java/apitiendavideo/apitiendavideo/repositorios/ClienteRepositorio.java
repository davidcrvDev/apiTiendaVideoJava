package apitiendavideo.apitiendavideo.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import apitiendavideo.apitiendavideo.modelos.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, String> {

    @Query("SELECT c FROM Cliente c WHERE c.nombre like '%' || ?1 || '%'")
    List<Cliente> buscar(String nombre);

    // Nuevo método para login
    Optional<Cliente> findByCorreo(String correo);
    
}
