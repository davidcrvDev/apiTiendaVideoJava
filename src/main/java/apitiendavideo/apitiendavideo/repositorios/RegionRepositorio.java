package apitiendavideo.apitiendavideo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import apitiendavideo.apitiendavideo.modelos.Region;

@Repository
public interface RegionRepositorio extends JpaRepository<Region, Long> {

    @Query("SELECT r FROM Region r WHERE r.region like '%' || ?1 || '%'")
    List<Region> buscar(String nombre);

}