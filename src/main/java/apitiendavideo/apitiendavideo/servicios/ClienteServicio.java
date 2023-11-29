package apitiendavideo.apitiendavideo.servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apitiendavideo.apitiendavideo.interfaces.IClienteServicio;
import apitiendavideo.apitiendavideo.modelos.Cliente;
import apitiendavideo.apitiendavideo.repositorios.ClienteRepositorio;

@Service
public class ClienteServicio implements IClienteServicio {

    @Autowired
    private ClienteRepositorio repositorio;

    @PersistenceContext
    public EntityManager em;

    @Override
    public List<Cliente> listar() {
        return repositorio.findAll();
    }

    @Override
    public Cliente obtener(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public List<Cliente> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        return repositorio.save(cliente);
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
