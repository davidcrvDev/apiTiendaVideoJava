package apitiendavideo.apitiendavideo.servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apitiendavideo.apitiendavideo.interfaces.IDetalleAlquilerServicio;
import apitiendavideo.apitiendavideo.modelos.DetalleAlquiler;
import apitiendavideo.apitiendavideo.repositorios.DetalleAlquilerRepositorio;

@Service
public class DetalleAlquilerServicio implements IDetalleAlquilerServicio {
    @Autowired
    private DetalleAlquilerRepositorio repositorio;

    @PersistenceContext
    public EntityManager em;

    @Override
    public List<DetalleAlquiler> listar() {
        return repositorio.findAll();
    }

    @Override
    public DetalleAlquiler obtener(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public List<DetalleAlquiler> buscarDetalleAlquiler(Long id) {
        return repositorio.buscarDetalleAlquiler(id);
    }

    @Override
    public DetalleAlquiler guardar(DetalleAlquiler detalleAlquiler) {
        return repositorio.save(detalleAlquiler);
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
