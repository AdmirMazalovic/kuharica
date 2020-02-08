package onlineKuharica;

import onlineKuharica.QueryClasses.NamirnicaSQL;

import java.util.ArrayList;

public class Namirnica extends NamirnicaSQL {
    private Integer namirnicaId;
    private Integer jeloId;
    private String imeNamirnice;
    private String mjernaJedinica;
    private Long kolicina;

    public Namirnica(){
    }

    public Integer getNamirnicaId() {
        return namirnicaId;
    }

    public void setNamirnicaId(Integer namirnicaId) {
        this.namirnicaId = namirnicaId;
    }

    public Integer getJeloId() {
        return jeloId;
    }

    public void setJeloId(Integer jeloId) {
        this.jeloId = jeloId;
    }

    public String getImeNamirnice() {
        return imeNamirnice;
    }

    public void setImeNamirnice(String imeNamirnice) {
        this.imeNamirnice = imeNamirnice;
    }

    public String getMjernaJedinica() {
        return mjernaJedinica;
    }

    public void setMjernaJedinica(String mjernaJedinica) {
        this.mjernaJedinica = mjernaJedinica;
    }

    public Long getKolicina() {
        return kolicina;
    }

    public void setKolicina(Long kolicina) {
        this.kolicina = kolicina;
    }

    /**
     * Dohvati sve namirnice za jelo sa [jeloId]
     * @param jeloId - id jela za kojeg dohvatamo namirnice iz baze
     * @return - array lista svih namirnica potrebnih za pripremu jela
     */
    public ArrayList<Namirnica> getNamirniceByJeloIdDB(Integer jeloId){
        NamirnicaSQL namirnicaSQL = new NamirnicaSQL();
        return namirnicaSQL.getNamirniceByJeloIdDB(jeloId);
    }
}
