package onlineKuharica;

import onlineKuharica.QueryClasses.NamirnicaSQL;

import java.util.ArrayList;

public class Namirnica extends NamirnicaSQL {
    private Integer namirnicaId = null;
    private Integer jeloId;
    private Integer vrstaNamirniceId;
    private String imeNamirnice;
    private String mjernaJedinica;
    private Long kolicina;

    public Namirnica(Integer jeloId, Integer vrstaNamirniceId, String imeNamirnice, String mjernaJedinica, Long kolicina) {
        this.jeloId = jeloId;
        this.vrstaNamirniceId = vrstaNamirniceId;
        this.imeNamirnice = imeNamirnice;
        this.mjernaJedinica = mjernaJedinica;
        this.kolicina = kolicina;
    }

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

    public void setVrstaNamirniceId(Integer vrstaNamirniceId) {
        this.vrstaNamirniceId = vrstaNamirniceId;
    }

    public Integer getVrstaNamirniceId() {
        return vrstaNamirniceId;
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
    public ArrayList<Namirnica> getNamirniceByJeloId(Integer jeloId){
        NamirnicaSQL namirnicaSQL = new NamirnicaSQL();
        return namirnicaSQL.getNamirniceByJeloIdDB(jeloId);
    }

    /**
     * Dodaj namirnicu za jelo sa [jeloId]
     * @param namirnica - namirnica koja se dodaja
     * @param jeloId - jelo za koje je dodana namirnica
     */
    public void addNamirnica(Namirnica namirnica, Integer jeloId){
        NamirnicaSQL namirnicaSQL = new NamirnicaSQL();
        namirnicaSQL.addNamirnicaDB(namirnica, jeloId);
    }
}
