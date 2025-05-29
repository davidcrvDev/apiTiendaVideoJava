package apitiendavideo.apitiendavideo.controladores;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apitiendavideo.apitiendavideo.interfaces.IClienteServicio;
import apitiendavideo.apitiendavideo.interfaces.ITituloServicio;
import apitiendavideo.apitiendavideo.modelos.Cliente;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;

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

    @GetMapping("/reporte")
    public void exportarClientesExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=clientes_reporte.xlsx");

        List<Cliente> clientes = servicio.listar();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Reporte Clientes");

        // Encabezados
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Nombre");
        header.createCell(1).setCellValue("Teléfono");
        header.createCell(2).setCellValue("Correo");

        // Datos
        int rowNum = 1;
        for (Cliente c : clientes) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(c.getNombre());
            row.createCell(1).setCellValue(c.getTelefono());
            row.createCell(2).setCellValue(c.getCorreo());
        }

        workbook.write(response.getOutputStream());
        workbook.close();
    }
}
