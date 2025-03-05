package apitiendavideo.apitiendavideo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apitiendavideo.apitiendavideo.interfaces.IDetalleAlquilerServicio;
import apitiendavideo.apitiendavideo.modelos.DetalleAlquiler;



@RestController
@RequestMapping("/detallealquileres"  )
public class DetalleAlquilerControlador {
    
    @Autowired
    private IDetalleAlquilerServicio servicio;

    @GetMapping("/listar")
    public List<DetalleAlquiler> listar() {
        return servicio.listar();
    }

    @GetMapping("/obtener/{id}")
    public DetalleAlquiler obtener(@PathVariable Long id) {
        return servicio.obtener(id);
    }

    @GetMapping("/{id}/buscardetallealquiler")
    public List<DetalleAlquiler> buscarDetalleAlquiler(@PathVariable Long id) {
        return servicio.buscarDetalleAlquiler(id);
    }

    @PostMapping("/agregar")
    public DetalleAlquiler crear(@RequestBody DetalleAlquiler detalleAlquiler) {
        return servicio.guardar(detalleAlquiler);
    }

    @PutMapping("/modificar")
    public DetalleAlquiler actualizar(@RequestBody DetalleAlquiler id) {
        if (servicio.obtener(id.getId()) != null) {
            return servicio.guardar(id);
        } else {
            return null;
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean eliminar(@PathVariable Long id) {
        return servicio.eliminar(id);
    }
}
