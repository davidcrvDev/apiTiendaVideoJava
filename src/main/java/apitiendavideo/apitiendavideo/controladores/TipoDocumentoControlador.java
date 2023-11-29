package apitiendavideo.apitiendavideo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import apitiendavideo.apitiendavideo.interfaces.ITipoDocumentoServicio;
import apitiendavideo.apitiendavideo.modelos.TipoDocumento;

@RestController
@RequestMapping("/tipodocumentos")
public class TipoDocumentoControlador {
    
    @Autowired
    private ITipoDocumentoServicio servicio;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<TipoDocumento> listar() {
        return servicio.listar();
    }

    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public TipoDocumento obtener(@PathVariable Long id) {
        return servicio.obtener(id);
    }

    @RequestMapping(value = "/buscar/{nombre}", method = RequestMethod.GET)
    public List<TipoDocumento> buscar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public TipoDocumento crear(@RequestBody TipoDocumento tipo) {
        return servicio.guardar(tipo);
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public TipoDocumento actualizar(@RequestBody TipoDocumento tipo) {
        if (servicio.obtener(tipo.getId()) != null) {
            return servicio.guardar(tipo);
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
