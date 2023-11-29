package apitiendavideo.apitiendavideo.modelos;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CIUDAD")
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CIUDAD")
    private long id;

    @Column(name = "NOMBRE_CIUDAD", nullable = false, length = 50)
    private String ciudad;

    @ManyToOne
    @JoinColumn(name = "IDREGION", referencedColumnName = "ID_REGION")
    private Region region;

    public Ciudad() {
    }

    public Ciudad(long id, Region region, String ciudad) {
        this.id = id;
        this.region = region;
        this.ciudad = ciudad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

}