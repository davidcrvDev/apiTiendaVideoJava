package apitiendavideo.apitiendavideo.servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apitiendavideo.apitiendavideo.interfaces.IAlquilerServicio;
import apitiendavideo.apitiendavideo.modelos.Alquiler;
import apitiendavideo.apitiendavideo.modelos.Tercero;
import apitiendavideo.apitiendavideo.repositorios.AlquilerRepositorio;

@Service
public class AlquilerServicio implements IAlquilerServicio{
    @Autowired
    private AlquilerRepositorio repositorio;

    @PersistenceContext
    public EntityManager em;

    @Override
    public List<Alquiler> listar() {
        return repositorio.findAll();
    }

    @Override
    public Alquiler obtener(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public List<Tercero> buscarTercero(String id) {
        return repositorio.buscarCliente(id);
    }

    @Override
    public Alquiler guardar(Alquiler alquiler) {
        return repositorio.save(alquiler);
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

    // @Override
    // public boolean estaVencido(Long id) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'estaVencido'");
    // }
    
}
