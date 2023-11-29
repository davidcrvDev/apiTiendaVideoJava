package apitiendavideo.apitiendavideo.interfaces;

import java.util.List;

import apitiendavideo.apitiendavideo.modelos.Region;

public interface IRegionServicio {
    
    public List<Region> listar();

    public Region obtener(Long id);

    public List<Region> buscar(String nombre);

    public Region guardar(Region pais);

    public boolean eliminar(Long id);
}
