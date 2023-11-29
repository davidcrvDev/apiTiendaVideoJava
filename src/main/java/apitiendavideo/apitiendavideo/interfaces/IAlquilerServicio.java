package apitiendavideo.apitiendavideo.interfaces;

import java.util.List;

import apitiendavideo.apitiendavideo.modelos.Alquiler;
import apitiendavideo.apitiendavideo.modelos.Tercero;

public interface IAlquilerServicio {

    public List<Alquiler> listar();

    public Alquiler obtener(Long id);

    public List<Tercero> buscarTercero(Long id);

    public Alquiler guardar(Alquiler alquiler);

    public boolean eliminar(Long id);

    //public boolean estaVencido(Long id);

}
