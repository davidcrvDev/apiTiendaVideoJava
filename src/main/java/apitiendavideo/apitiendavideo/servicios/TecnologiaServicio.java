package apitiendavideo.apitiendavideo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apitiendavideo.apitiendavideo.interfaces.ITecnologiaServicio;
import apitiendavideo.apitiendavideo.modelos.Tecnologia;
import apitiendavideo.apitiendavideo.repositorios.TecnologiaRepositorio;

@Service
public class TecnologiaServicio implements ITecnologiaServicio {

    @Autowired
    private TecnologiaRepositorio repositorio;

    @Override
    public List<Tecnologia> listar() {
        return repositorio.listar();
    }

    @Override
    public Tecnologia obtener(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public List<Tecnologia> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public Tecnologia guardar(Tecnologia tecnologia) {
        return repositorio.save(tecnologia);
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
