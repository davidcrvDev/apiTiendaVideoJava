package apitiendavideo.apitiendavideo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import apitiendavideo.apitiendavideo.modelos.Categoria;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {
    
    @Query("SELECT ca FROM Categoria ca WHERE ca.nombre like '%' || ?1 || '%'")
    List<Categoria> buscar(String nombre);

    @Query("SELECT ca FROM Categoria ca order by id ASC")
    List<Categoria> listar();
}
