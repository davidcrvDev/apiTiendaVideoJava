package apitiendavideo.apitiendavideo.interfaces;

import java.util.List;

import apitiendavideo.apitiendavideo.modelos.Cliente;

public interface IClienteServicio {

    public List<Cliente> listar();

    public Cliente obtener(String id);

    public List<Cliente> buscar(String nombre);

    public Cliente guardar(Cliente cliente);

    public boolean eliminar(String id);
    
    public long contarClientes();

}
