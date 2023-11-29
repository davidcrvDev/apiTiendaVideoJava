package apitiendavideo.apitiendavideo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import apitiendavideo.apitiendavideo.interfaces.IRegionServicio;
import apitiendavideo.apitiendavideo.modelos.Region;

@RestController
@RequestMapping("/regiones")
public class RegionControlador {

    @Autowired
    private IRegionServicio servicio;

    @GetMapping("/listar")
    public List<Region> listar() {
        return servicio.listar();
    }

    @GetMapping("/obtener/{id}")
    public Region obtener(@PathVariable Long id) {
        return servicio.obtener(id);
    }

    @GetMapping("/buscar/{nombre}")
    public List<Region> buscar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    @PostMapping("/agregar")
    public Region crear(@RequestBody Region region) {
        return servicio.guardar(region);
    }

    @PutMapping("/modificar")
    public Region actualizar(@RequestBody Region region) {
        if (servicio.obtener(region.getId()) != null) {
            return servicio.guardar(region);
        } else {
            return null;
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean eliminar(@PathVariable long id) {
        return servicio.eliminar(id);
    }

}
