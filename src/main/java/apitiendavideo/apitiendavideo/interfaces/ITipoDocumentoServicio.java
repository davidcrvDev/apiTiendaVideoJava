package apitiendavideo.apitiendavideo.interfaces;

import java.util.List;

import apitiendavideo.apitiendavideo.modelos.TipoDocumento;

public interface ITipoDocumentoServicio {
    
    public List<TipoDocumento> listar();

    public TipoDocumento obtener(Long id);

    public List<TipoDocumento> buscar(String nombre);

    public TipoDocumento guardar(TipoDocumento tipoDocumento);

    public boolean eliminar(Long id);

}
