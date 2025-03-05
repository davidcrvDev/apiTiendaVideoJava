package apitiendavideo.apitiendavideo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apitiendavideo.apitiendavideo.interfaces.ICategoriaServicio;
import apitiendavideo.apitiendavideo.modelos.Categoria;
import apitiendavideo.apitiendavideo.repositorios.CategoriaRepositorio;

@Service
public class CategoriaServicio implements ICategoriaServicio {
    @Autowired
    private CategoriaRepositorio repositorio;

    @Override
    public List<Categoria> listar() {
        return repositorio.findAll();
    }

    @Override
    public Categoria obtener(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public List<Categoria> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public Categoria guardar(Categoria categoria) {
        return repositorio.save(categoria);
    }

    @Override
    public boolean eliminar(Long id) {
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
