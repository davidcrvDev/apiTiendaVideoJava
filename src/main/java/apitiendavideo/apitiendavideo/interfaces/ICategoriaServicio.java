package apitiendavideo.apitiendavideo.interfaces;

import java.util.List;

import apitiendavideo.apitiendavideo.modelos.Categoria;

public interface ICategoriaServicio {

    public List<Categoria> listar();

    public Categoria obtener(Long id);

    public List<Categoria> buscar(String nombre);

    public Categoria guardar(Categoria categoria);

    public boolean eliminar(Long id);
}
