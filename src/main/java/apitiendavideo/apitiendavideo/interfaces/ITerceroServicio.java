package apitiendavideo.apitiendavideo.interfaces;

import java.util.List;

import apitiendavideo.apitiendavideo.modelos.Tercero;

public interface ITerceroServicio {
    
    public List<Tercero> listar();

    public List<Tercero> obtener(String id);

    public List<Tercero> buscar(String nombre);

    public Tercero guardar(Tercero tercero);

    public boolean eliminar(Long id);

}
