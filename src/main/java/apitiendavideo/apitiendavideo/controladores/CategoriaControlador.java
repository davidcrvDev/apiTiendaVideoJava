package apitiendavideo.apitiendavideo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apitiendavideo.apitiendavideo.interfaces.ICategoriaServicio;
import apitiendavideo.apitiendavideo.modelos.Categoria;

@RestController
@RequestMapping("/categorias")
public class CategoriaControlador {
    
    @Autowired
    private ICategoriaServicio servicio;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Categoria> listar() {
        return servicio.listar();
    }

    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Categoria obtener(@PathVariable Long id) {
        return servicio.obtener(id);
    }

    @RequestMapping(value = "/buscar/{nombre}", method = RequestMethod.GET)
    public List<Categoria> buscar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Categoria crear(@RequestBody Categoria categoria) {
        return servicio.guardar(categoria);
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Categoria actualizar(@RequestBody Categoria categoria) {
        if (servicio.obtener(categoria.getId()) != null) {
            return servicio.guardar(categoria);
        }
        else{
            return null;
        }
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable long id) {
        return servicio.eliminar(id);
        
    }
}
