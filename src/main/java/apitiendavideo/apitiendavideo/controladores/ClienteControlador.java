package apitiendavideo.apitiendavideo.controladores;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apitiendavideo.apitiendavideo.interfaces.IClienteServicio;
import apitiendavideo.apitiendavideo.modelos.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteControlador {

    @Autowired
    private IClienteServicio servicio;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Cliente> listar() {
        return servicio.listar();
    }
    // boolean morosos
    @PatchMapping("/{id}/moroso")
    public ResponseEntity<Cliente> actualizarMoroso(@PathVariable String id, @RequestBody Map<String, Boolean> body) {
        Boolean nuevoMoroso = body.get("moroso");
        Cliente cliente = servicio.obtener(id);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        cliente.setMoroso(nuevoMoroso);
        Cliente actualizado = servicio.guardar(cliente);
        return ResponseEntity.ok(actualizado);
    }

    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Cliente obtener(@PathVariable String id) {
        return servicio.obtener(id);
    }

    @RequestMapping(value = "/buscar/{nombre}", method = RequestMethod.GET)
    public List<Cliente> buscar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Cliente crear(@RequestBody Cliente cliente) {
        return servicio.guardar(cliente);
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Cliente actualizar(@RequestBody Cliente cliente) {
        if (servicio.obtener(cliente.getId()) != null) {
            return servicio.guardar(cliente);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable String id) {
        return servicio.eliminar(id);
    }
}
