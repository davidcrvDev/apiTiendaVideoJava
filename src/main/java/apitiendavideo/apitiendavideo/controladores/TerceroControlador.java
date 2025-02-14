package apitiendavideo.apitiendavideo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apitiendavideo.apitiendavideo.interfaces.ITerceroServicio;
//import org.hibernate.exception.ConstraintViolationException;
import apitiendavideo.apitiendavideo.modelos.Tercero;

@RestController
@RequestMapping("/terceros")
public class TerceroControlador {
    
    @Autowired
    private ITerceroServicio servicio;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Tercero> listar() {
        return servicio.listar();
    }

    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public List<Tercero> obtener(@PathVariable String id) {
        return servicio.obtener(id);
    }

    @RequestMapping(value = "/buscar/{nombre}", method = RequestMethod.GET)
    public List<Tercero> buscar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Tercero crear(@RequestBody Tercero tercero) {
        return servicio.guardar(tercero);
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Tercero actualizar(@RequestBody Tercero tercero) {
        if (servicio.obtener(tercero.getId()) != null) {
            return servicio.guardar(tercero);
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
