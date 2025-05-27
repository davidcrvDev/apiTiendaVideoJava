package apitiendavideo.apitiendavideo.servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apitiendavideo.apitiendavideo.interfaces.IClienteServicio;
import apitiendavideo.apitiendavideo.modelos.Cliente;
import apitiendavideo.apitiendavideo.modelos.TipoDocumento;
import apitiendavideo.apitiendavideo.repositorios.ClienteRepositorio;
import apitiendavideo.apitiendavideo.repositorios.TipoDocumentoRepositorio;


@Service
public class ClienteServicio implements IClienteServicio {

    @Autowired
    private ClienteRepositorio repositorio;

    @Autowired
    private TipoDocumentoRepositorio tipoDocumentoRepositorio;

    @PersistenceContext
    public EntityManager em;

    @Override
    public List<Cliente> listar() {
        return repositorio.findAll();
    }

    @Override
    public Cliente obtener(String id) {
        return repositorio.findById(id).get();
    }

    @Override
    public List<Cliente> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        TipoDocumento tipoDoc = tipoDocumentoRepositorio.findById(cliente.getTipoDocumento().getId())
        .orElseThrow(() -> new RuntimeException("TipoDocumento no encontrado"));
        cliente.setTipoDocumento(tipoDoc);
        return repositorio.save(cliente);
    }

    @Override
    public boolean eliminar(String id) {
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
