package apitiendavideo.apitiendavideo.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import apitiendavideo.apitiendavideo.modelos.TipoDocumento;

@Repository
public interface TipoDocumentoRepositorio  extends JpaRepository<TipoDocumento, Long>{

    @Query("SELECT td FROM TipoDocumento td WHERE td.tipo like '%' || ?1 || '%'")
    List<TipoDocumento> buscar(String nombre);

    @Query("SELECT td FROM TipoDocumento td order by id ASC")
    List<TipoDocumento> listar();
    
}
