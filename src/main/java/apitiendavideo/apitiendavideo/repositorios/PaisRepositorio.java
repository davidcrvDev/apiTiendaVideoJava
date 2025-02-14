package apitiendavideo.apitiendavideo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import apitiendavideo.apitiendavideo.modelos.Pais;
import apitiendavideo.apitiendavideo.modelos.Tercero;

@Repository
public interface PaisRepositorio extends JpaRepository<Pais, Long> {

    @Query("SELECT p FROM Pais p WHERE p.pais like '%' || ?1 || '%'")
    List<Pais> buscar(String nombre);

    @Query(value = "SELECT id_pais, nombre_pais, codigoalfa3 FROM pais p ORDER BY id_pais ASC", nativeQuery = true) //id, pais, codigoAlfa3
    List<Pais> listar();

}
