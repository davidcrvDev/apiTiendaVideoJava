package apitiendavideo.apitiendavideo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apitiendavideo.apitiendavideo.interfaces.ITipoDocumentoServicio;
import apitiendavideo.apitiendavideo.modelos.TipoDocumento;
import apitiendavideo.apitiendavideo.repositorios.TipoDocumentoRepositorio;

@Service
public class TipoDocumentoServicio implements ITipoDocumentoServicio{
    
    @Autowired
    private TipoDocumentoRepositorio repositorio;

    @Override
    public List<TipoDocumento> listar() {
        return repositorio.listar();
    }

    @Override
    public TipoDocumento obtener(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public List<TipoDocumento> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public TipoDocumento guardar(TipoDocumento tipo) {
        return repositorio.save(tipo);
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
