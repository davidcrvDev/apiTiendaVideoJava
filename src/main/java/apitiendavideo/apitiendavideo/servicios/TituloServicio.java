package apitiendavideo.apitiendavideo.servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apitiendavideo.apitiendavideo.interfaces.ITituloServicio;
import apitiendavideo.apitiendavideo.modelos.Titulo;
import apitiendavideo.apitiendavideo.repositorios.TituloRepositorio;

@Service
public class TituloServicio implements ITituloServicio{
    
    @Autowired
    private TituloRepositorio repositorio;

    @PersistenceContext
    public EntityManager em;

    @Override
    public List<Titulo> listar() {
        return repositorio.listar();
    }

    @Override
    public Titulo obtener(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public List<Titulo> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public Titulo guardar(Titulo titulo) {
        return repositorio.saveAndFlush(titulo);
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
