package apitiendavideo.apitiendavideo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apitiendavideo.apitiendavideo.interfaces.IInventarioServicio;
import apitiendavideo.apitiendavideo.modelos.Inventario;
import apitiendavideo.apitiendavideo.repositorios.InventarioRepositorio;

@Service
public class InventarioServicio implements IInventarioServicio {

    @Autowired
    private InventarioRepositorio repositorio;

    @Override
    public List<Inventario> listar() {
        return repositorio.findAll();
    }

    @Override
    public Inventario obtener(Long id) {
        var inventario = repositorio.findById(id);
        return inventario.isEmpty() ? null : inventario.get();
    }

    @Override
    public List<Inventario> buscar(String nombre, Long id) {
        return repositorio.buscar(nombre, id);
    }

    @Override
    public Inventario guardar(Inventario inventario) {
        return repositorio.save(inventario);
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

    public long contarInventario() {
        return repositorio.count();
    }
}
