package onlineKuharica;

import java.util.Date;

public class Recept {
    private Integer jeloId;
    private Date datumObjave;
    private String opisPipreme;

    public Recept(Integer jeloId, Date datumObjave, String opisPipreme) {
        this.jeloId = jeloId;
        this.datumObjave = datumObjave;
        this.opisPipreme = opisPipreme;
    }

    public Recept() {
    }

    public Integer getJeloId() {
        return jeloId;
    }

    public void setJeloId(Integer jeloId) {
        this.jeloId = jeloId;
    }

    public Date getDatumObjave() {
        return datumObjave;
    }

    public void setDatumObjave(Date datumObjave) {
        this.datumObjave = datumObjave;
    }

    public String getOpisPipreme() {
        return opisPipreme;
    }

    public void setOpisPipreme(String opisPipreme) {
        this.opisPipreme = opisPipreme;
    }
}
