package apitiendavideo.apitiendavideo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import apitiendavideo.apitiendavideo.interfaces.IAlquilerServicio;
import apitiendavideo.apitiendavideo.modelos.Alquiler;


@RestController 
@RequestMapping("/alquileres")
public class AlquilerControlador {

    @Autowired
    private IAlquilerServicio servicio;

    @GetMapping("/listar")
    public List<Alquiler> listar() {
        return servicio.listar();
    }

    @GetMapping("/obtener/{id}")
    public Alquiler obtener(@PathVariable Long id) {
        return servicio.obtener(id);
    }

    @GetMapping("/{id}/buscarcliente")
    public List<Alquiler> buscarCliente(@PathVariable Long id) {
        return servicio.buscarCliente(id);
    }
    
    @PostMapping("/agregar")
    public Alquiler crear(@RequestBody Alquiler alquiler) {
        return servicio.guardar(alquiler);
    }

    @PutMapping("/modificar")
    public Alquiler actualizar(@RequestBody Alquiler id) {
        if (servicio.obtener(id.getId()) != null) {
            return servicio.guardar(id);
        } else {
            return null;
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean eliminar(@PathVariable long id) {
        return servicio.eliminar(id);
    }
    
}
