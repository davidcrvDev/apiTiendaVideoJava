package apitiendavideo.apitiendavideo.interfaces;

import java.util.List;

import apitiendavideo.apitiendavideo.modelos.DetalleAlquiler;

public interface IDetalleAlquilerServicio {
    
    public List<DetalleAlquiler> listar();

    public DetalleAlquiler obtener(Long id);

    public List<DetalleAlquiler> buscarDetalleAlquiler(Long id); //Posiblemente inecesario

    public DetalleAlquiler guardar(DetalleAlquiler detalleAlquiler);

    public boolean eliminar(Long id);
}
