package apitiendavideo.apitiendavideo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apitiendavideo.apitiendavideo.interfaces.IEmpresaServicio;
import apitiendavideo.apitiendavideo.modelos.Empresa;
import apitiendavideo.apitiendavideo.modelos.Titulo;

@RestController
@RequestMapping("/empresas")
public class EmpresaControlador {

    @Autowired
    private IEmpresaServicio servicio;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Empresa> listar() {
        return servicio.listar();
    }

    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Empresa obtener(@PathVariable Long id) {
        return servicio.obtener(id);
    }

    @RequestMapping(value = "/buscar/{nombre}", method = RequestMethod.GET)
    public List<Empresa> buscar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    // @RequestMapping(value = "/{nombre}/buscartitulos", method = RequestMethod.GET)
    // public List<Titulo> buscarTitulos(@PathVariable String nombre) {
    //     return servicio.buscarTitulos(nombre);
    // }

    @PostMapping(value = "/agregar")//, method = RequestMethod.POST
    public Empresa crear(@RequestBody Empresa empresa) {
        return servicio.guardar(empresa);
    }

    @PutMapping(value = "/modificar")
    public Empresa actualizar(@RequestBody Empresa empresa) {
        if (servicio.obtener(empresa.getId()) != null) {
            return servicio.guardar(empresa);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable long id) {
        return servicio.eliminar(id);
    }


}
