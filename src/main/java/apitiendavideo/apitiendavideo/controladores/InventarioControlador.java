package apitiendavideo.apitiendavideo.controladores;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import apitiendavideo.apitiendavideo.interfaces.IInventarioServicio;
import apitiendavideo.apitiendavideo.modelos.Inventario;

@RestController
@RequestMapping("/inventarios")
public class InventarioControlador {

    @Autowired
    private IInventarioServicio servicio;

    @GetMapping("/listar")
    public List<Inventario> listar() {
        return servicio.listar();
    }

    @GetMapping("/obtener/{id}")
    public Inventario obtener(@PathVariable Long id) {
        return servicio.obtener(id);
    }

    @GetMapping("/buscar/{nombre}")
    public List<Inventario> buscar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }


    @PostMapping("/agregar")
    public Inventario crear(@RequestBody Inventario inventario) {
        return servicio.guardar(inventario);
    }

    @PutMapping("/modificar")
    public Inventario actualizar(@RequestBody Inventario inventario) {
        if (servicio.obtener(inventario.getId()) != null) {
            return servicio.guardar(inventario);
        } else {
            return null;
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean eliminar(@PathVariable long id) {
        return servicio.eliminar(id);
    }

    // @PostMapping("/tu_endpoint")
    // public String dateToString(@RequestBody Inventario inventario) {
    //     // Otras operaciones...

    //     // Convertir la cadena (String) a Date
    //     try {
    //         String fechaString = inventario.getFechaadquisicion().toString(); // asumiendo que en TuRequest existe el método getFecha()
    //         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    //         LocalDate fecha = LocalDate.parse(fechaString, formatter);
    //         return "Operación exitosa";
    //     } catch (DateTimeParseException e) {
    //         // Manejar la excepción si la cadena no puede ser convertida a LocalDate
    //         e.printStackTrace();
    //         return "Error: Formato de fecha incorrecto";
    //     } catch (Exception e) {
    //         // Manejar otras excepciones si es necesario
    //         e.printStackTrace();
    //         return "Error interno del servidor";
    //     }
    // }


}
