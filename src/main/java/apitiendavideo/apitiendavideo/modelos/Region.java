package apitiendavideo.apitiendavideo.modelos;

import javax.persistence.*;

@Entity
@Table(name = "REGION")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_REGION")
    private long id;

    @Column(name = "NOMBRE_REGION", nullable = false, length = 50)
    private String region;

    @ManyToOne
    @JoinColumn(name = "IDPAIS", referencedColumnName = "ID_PAIS")
    private Pais pais;

    //Se elimina "codigo"
    

    public Region() {
    }

    public Region(long id, String region, Pais pais) {
        this.id = id;
        this.region = region;
        this.pais = pais;
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

}
