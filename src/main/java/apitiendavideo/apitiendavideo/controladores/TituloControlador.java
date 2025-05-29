package apitiendavideo.apitiendavideo.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apitiendavideo.apitiendavideo.interfaces.ITituloServicio;
import apitiendavideo.apitiendavideo.modelos.Titulo;
import apitiendavideo.apitiendavideo.repositorios.TituloRepositorio;
import org.apache.poi.ss.usermodel.Row;

@RestController
@RequestMapping("/titulos")
public class TituloControlador {

    private final TituloRepositorio tituloRepositorio;

    public TituloControlador(TituloRepositorio tituloRepositorio) {
        this.tituloRepositorio = tituloRepositorio;
    }

    @Autowired
    private ITituloServicio servicio;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Titulo> listar() {
        return servicio.listar();
    }

    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Titulo obtener(@PathVariable Long id) {
        return servicio.obtener(id);
    }

    @RequestMapping(value = "/buscar/{nombre}", method = RequestMethod.GET)
    public List<Titulo> buscar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Titulo crear(@RequestBody Titulo titulo) {
        return servicio.guardar(titulo);
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Titulo actualizar(@RequestBody Titulo titulo) {
        if (servicio.obtener(titulo.getId()) != null) {
            return servicio.guardar(titulo);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable long id) {
        return servicio.eliminar(id);
    }

    @GetMapping("/existe/{nombre}")
    public ResponseEntity<Boolean> existeTitulo(@PathVariable String nombre) {
        boolean existe = tituloRepositorio.existsByNombreIgnoreCase(nombre.trim());
        return ResponseEntity.ok(existe);
    }

    @GetMapping("/reporte")
    public void exportarTitulosExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=titulos_reporte.xlsx");

        List<Titulo> titulos = servicio.listar();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Reporte Titulos");

        // Encabezados
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Nombre");
        header.createCell(1).setCellValue("Director");
        header.createCell(2).setCellValue("Categoria");

        // Datos
        int rowNum = 1;
        for (Titulo t : titulos) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(t.getNombre());
            row.createCell(1).setCellValue(t.getDirector());
            row.createCell(2).setCellValue(t.getCategoria() != null ? t.getCategoria().toString() : "");
        }

        workbook.write(response.getOutputStream());
        workbook.close();
    }
}
