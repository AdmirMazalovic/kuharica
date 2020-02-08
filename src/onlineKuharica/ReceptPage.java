package onlineKuharica;

import onlineKuharica.QueryClasses.ReceptPageSQL;

import java.sql.Date;

public class ReceptPage extends ReceptPageSQL {
    private Integer kuharId = null;
    private String ime;
    private String prezime;
    private String email;
    private String drzava;
    private String grad;
    private Integer jeloId = null;
    private String imeJela;
    private Integer kuhinjaId;
    private Integer vrstaJelaId;
    private Integer tezinaPripreme;
    private String trajanjePripreme;
    private Integer brojOsoba;
    private String opisJela;
    private Date datumObjave;
    private String opisPipreme;

    public ReceptPage() {
    }

    public Integer getKuharId() {
        return kuharId;
    }

    public void setKuharId(Integer kuharId) {
        this.kuharId = kuharId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public Integer getJeloId() {
        return jeloId;
    }

    public void setJeloId(Integer jeloId) {
        this.jeloId = jeloId;
    }

    public String getImeJela() {
        return imeJela;
    }

    public void setImeJela(String imeJela) {
        this.imeJela = imeJela;
    }

    public Integer getKuhinjaId() {
        return kuhinjaId;
    }

    public void setKuhinjaId(Integer kuhinjaId) {
        this.kuhinjaId = kuhinjaId;
    }

    public Integer getVrstaJelaId() {
        return vrstaJelaId;
    }

    public void setVrstaJelaId(Integer vrstaJelaId) {
        this.vrstaJelaId = vrstaJelaId;
    }

    public Integer getTezinaPripreme() {
        return tezinaPripreme;
    }

    public void setTezinaPripreme(Integer tezinaPripreme) {
        this.tezinaPripreme = tezinaPripreme;
    }

    public String getTrajanjePripreme() {
        return trajanjePripreme;
    }

    public void setTrajanjePripreme(String trajanjePripreme) {
        this.trajanjePripreme = trajanjePripreme;
    }

    public Integer getBrojOsoba() {
        return brojOsoba;
    }

    public void setBrojOsoba(Integer brojOsoba) {
        this.brojOsoba = brojOsoba;
    }

    public String getOpisJela() {
        return opisJela;
    }

    public void setOpisJela(String opisJela) {
        this.opisJela = opisJela;
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
     * Dohvati recept sa informacijama o kuharu i jelu
     *
     * @param JeloId - id jela
     * @return
     */
    public ReceptPage getRecetById(Integer JeloId) {
        ReceptPageSQL receptPageSQL = new ReceptPage();
        return receptPageSQL.getReceptByJeloIdDB(jeloId);
    }

}
