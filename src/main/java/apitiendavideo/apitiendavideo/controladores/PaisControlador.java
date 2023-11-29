package apitiendavideo.apitiendavideo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import apitiendavideo.apitiendavideo.interfaces.IPaisServicio;
import apitiendavideo.apitiendavideo.modelos.Pais;

@RestController
@RequestMapping("/paises")
public class PaisControlador {

    @Autowired
    private IPaisServicio servicio;

    @GetMapping("/listar")
    public List<Pais> listar() {
        return servicio.listar();
    }

    @GetMapping("/obtener/{id}")
    public Pais obtener(@PathVariable Long id) {
        return servicio.obtener(id);
    }

    @GetMapping("/buscar/{nombre}")
    public List<Pais> buscar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    @PostMapping("/agregar")
    public Pais crear(@RequestBody Pais pais) {
        return servicio.guardar(pais);
    }

    @PutMapping("/modificar")
    public Pais actualizar(@RequestBody Pais pais) {
        if (servicio.obtener(pais.getId()) != null) {
            return servicio.guardar(pais);
        } else {
            return null;
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean eliminar(@PathVariable long id) {
        return servicio.eliminar(id);
    }

}
