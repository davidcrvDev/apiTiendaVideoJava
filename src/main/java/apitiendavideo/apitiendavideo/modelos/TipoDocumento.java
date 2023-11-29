package apitiendavideo.apitiendavideo.modelos;

import javax.persistence.*;

@Entity
@Table(name = "TIPODOCUMENTO")
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPODOC")
    private long id;

    @Column(name = "NOMBRE_TIPODOC", nullable = false, length = 60)
    private String tipo;

    @Column(name = "INGLES", nullable = false, length = 40)
    private String ingles;

    @Column(name = "SIGLA", nullable = true, length = 5)
    private String sigla;

    public TipoDocumento() {
    }

    public TipoDocumento(long id, String tipo, String ingles, String sigla) {
        this.id = id;
        this.tipo = tipo;
        this.ingles = ingles;
        this.sigla = sigla;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIngles() {
        return ingles;
    }

    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

}