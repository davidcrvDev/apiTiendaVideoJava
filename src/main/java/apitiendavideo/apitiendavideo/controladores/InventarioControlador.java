package apitiendavideo.apitiendavideo.controladores;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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

    @GetMapping("/buscar/{nombre}/{id}")
    public List<Inventario> buscar(@PathVariable String nombre, @PathVariable Long id) {
        return servicio.buscar(nombre, id);
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

    @GetMapping("/reporte")
    public void exportarInventariosExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=inventarios_reporte.xlsx");

        List<Inventario> inventarios = servicio.listar();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Reporte Inventarios");

        // Encabezados
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Título");
        header.createCell(1).setCellValue("Tecnología");
        header.createCell(2).setCellValue("Precio");

        // Datos
        int rowNum = 1;
        for (Inventario inv : inventarios) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(inv.getTitulo().toString()); // Ajusta según tu modelo
            row.createCell(1).setCellValue(inv.getTecnologia().toString()); // Ajusta según tu modelo
            row.createCell(2).setCellValue(inv.getPrecio()); // Ajusta según tu modelo
        }

        workbook.write(response.getOutputStream());
        workbook.close();
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
