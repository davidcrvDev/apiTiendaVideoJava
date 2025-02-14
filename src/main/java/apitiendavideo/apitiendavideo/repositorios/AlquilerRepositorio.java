package apitiendavideo.apitiendavideo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import apitiendavideo.apitiendavideo.modelos.Alquiler;
import apitiendavideo.apitiendavideo.modelos.Tercero;

@Repository
public interface AlquilerRepositorio extends JpaRepository<Alquiler,Long> {

    @Query("SELECT a FROM Alquiler a WHERE a.id LIKE '%' || ?1 || '%'")
    List<Alquiler> buscar(Long id);

    //SELECT i FROM Inventario i join i.titulo t WHERE t.nombre like '%' || ?1 || '%'; ON a.idcliente = c.id_cliente
    @Query("SELECT a FROM Alquiler a JOIN a.tercero c WHERE c.id LIKE '%' || ?1 || '%'")
    List<Tercero> buscarCliente(String id);
    
}
