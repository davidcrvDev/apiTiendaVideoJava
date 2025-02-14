package apitiendavideo.apitiendavideo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apitiendavideo.apitiendavideo.interfaces.ITerceroServicio;
import apitiendavideo.apitiendavideo.modelos.Tercero;
import apitiendavideo.apitiendavideo.repositorios.TerceroRepositorio;

@Service
public class TerceroServicio implements ITerceroServicio{
    
    @Autowired
    private TerceroRepositorio repositorio;

    @Override
    public List<Tercero> listar() {
        return repositorio.listar();
    }

    @Override
    public List<Tercero> obtener(String id) {
        return repositorio.buscarID(id);//findById.get()
    }

    @Override
    public List<Tercero> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public Tercero guardar(Tercero tercero) {
        return repositorio.save(tercero);
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
