package onlineKuharica;

import onlineKuharica.QueryClasses.ReceptSQL;

import java.sql.Date;

public class Recept extends ReceptSQL {
    private Integer jeloId;
    private Date datumObjave;
    private String opisPipreme;

    public Recept(Integer jeloId, String opisPipreme) {
        this.jeloId = jeloId;
        this.datumObjave = null;
        this.opisPipreme = opisPipreme;
    }

    public Recept() {
        datumObjave = null;
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

    /**
     * Vrati recept od jela sa [jeloId]
     * @param jeloId - id jela za koje dohvatamo recept
     * @return - recept za jelo sa jelo id
     */
    public Recept getReceptByJeloId(Integer jeloId){
        ReceptSQL receptSQL = new ReceptSQL();
        return receptSQL.getReceptByJeloIdDB(jeloId);
    }

    /**
     * Dodaj recept u DB
     * @param recept
     */
    public void addRecept(Recept recept){
        ReceptSQL receptSQL = new ReceptSQL();
        receptSQL.addReceptDB(recept);
    }
}
