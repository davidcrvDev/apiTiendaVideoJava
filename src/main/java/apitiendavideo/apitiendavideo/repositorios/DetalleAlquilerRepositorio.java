package apitiendavideo.apitiendavideo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import apitiendavideo.apitiendavideo.modelos.DetalleAlquiler;

@Repository
public interface DetalleAlquilerRepositorio extends JpaRepository<DetalleAlquiler, Long> {
    
    @Query("SELECT da FROM DetalleAlquiler da WHERE da.id LIKE '%' || ?1 || '%'")
    List<DetalleAlquiler> buscar(Long id);

    //SELECT i FROM Inventario i join i.titulo t WHERE t.nombre like '%' || ?1 || '%'; ON a.idcliente = c.id_cliente
    @Query("SELECT da FROM DetalleAlquiler da JOIN da.alquiler a WHERE a.id =   ?1 ")
    List<DetalleAlquiler> buscarDetalleAlquiler(Long id);
}
