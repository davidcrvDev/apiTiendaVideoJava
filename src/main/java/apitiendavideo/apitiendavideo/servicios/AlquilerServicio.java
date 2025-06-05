package apitiendavideo.apitiendavideo.servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import apitiendavideo.apitiendavideo.interfaces.IAlquilerServicio;
import apitiendavideo.apitiendavideo.modelos.Alquiler;
import apitiendavideo.apitiendavideo.modelos.DetalleAlquiler;
import apitiendavideo.apitiendavideo.repositorios.AlquilerRepositorio;

@Service
public class AlquilerServicio implements IAlquilerServicio {
    @Autowired
    private AlquilerRepositorio repositorio;

    @PersistenceContext
    public EntityManager em;

    @Override
    public List<Alquiler> listar() {
        return repositorio.findAll();
    }

    @Override
    public Alquiler obtener(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public List<Alquiler> buscarCliente(Long id) {
        return repositorio.buscarCliente(id);
    }

    @Transactional
    @Override
    public Alquiler guardar(Alquiler alquiler) {
        double totalAlquiler = 0.0;
        // Asociar el alquiler a cada detalle (esto es MUY IMPORTANTE)
        if (alquiler.getDetalles() != null) {
            for (DetalleAlquiler detalle : alquiler.getDetalles()) {
                detalle.setAlquiler(alquiler);

                // Obtener precio unitario desde el inventario (o donde corresponda)
                double precioUnitario = detalle.getInventario().getPrecio(); // Asegúrate que exista este campo
                detalle.setPrecio_unitario(precioUnitario);

                // Calcular subtotal
                double subtotal = precioUnitario * detalle.getCantidad();
                detalle.setSubtotal(subtotal);

                // Acumular al total del alquiler
                totalAlquiler += subtotal;
            }
        }
        // Establecer el precio total del alquiler
        alquiler.setPrecio(totalAlquiler);

        return repositorio.save(alquiler);
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
    // public boolean estaVencido(Long id) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method
    // 'estaVencido'");
    // }

}
