package apitiendavideo.apitiendavideo.servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apitiendavideo.apitiendavideo.interfaces.IEmpresaServicio;
import apitiendavideo.apitiendavideo.modelos.Empresa;
import apitiendavideo.apitiendavideo.modelos.Titulo;
import apitiendavideo.apitiendavideo.repositorios.EmpresaRepositorio;

@Service
public class EmpresaServicio implements IEmpresaServicio {

    @Autowired
    private EmpresaRepositorio repositorio;

    @PersistenceContext
    public EntityManager em;

    @Override
    public List<Empresa> listar() {
        return repositorio.findAll();
    }

    @Override
    public Empresa obtener(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public List<Empresa> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public Empresa guardar(Empresa empresa) {
        return repositorio.save(empresa);
    }

    @Override
    public boolean eliminar(Long id) {
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    // @Override
    // public List<Titulo> buscarTitulos(String nombre) {
    //     List<Titulo> titulos = em.createStoredProcedureQuery("fBuscarTitulosPorEmpresa", Titulo.class)
    //             .registerStoredProcedureParameter("nombreEmpresa", String.class, ParameterMode.IN)
    //             .setParameter("nombreEmpresa", nombre)
    //             .getResultList();

    //     return titulos;
    // }

}
