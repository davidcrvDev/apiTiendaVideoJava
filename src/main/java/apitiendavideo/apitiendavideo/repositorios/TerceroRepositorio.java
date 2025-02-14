package apitiendavideo.apitiendavideo.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import apitiendavideo.apitiendavideo.modelos.Tercero;

@Repository
public interface TerceroRepositorio extends JpaRepository<Tercero, Long>{

    @Query("SELECT c FROM Tercero c WHERE c.nombre like '%' || ?1 || '%'")
    List<Tercero> buscar(String nombre);

    @Query("SELECT te FROM Tercero te order by id ASC")
    List<Tercero> listar();
    
    @Query("SELECT c FROM Tercero c WHERE c.id like '%' || ?1 || '%'")
    List<Tercero> buscarID(String id);
}
