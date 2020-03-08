package onlineKuharica;

import onlineKuharica.QueryClasses.JeloSQL;

import java.util.ArrayList;

public class Jelo extends JeloSQL{
    private Integer jeloId = null;
    private Integer kuharId;
    private String imeJela;
    private Integer kuhinjaId;
    private Integer vrstaJelaId;
    private String tezinaPripreme;
    private String trajanjePripreme;
    private Integer brojOsoba;
    private String opisJela;

    public Jelo(Integer kuharId, String imeJela, Integer kuhinjaId, Integer vrstaJelaId, String tezinaPripreme, String trajanjePripreme, Integer brojOsoba, String opisJela) {
        this.kuharId = kuharId;
        this.imeJela = imeJela;
        this.kuhinjaId = kuhinjaId;
        this.vrstaJelaId = vrstaJelaId;
        this.tezinaPripreme = tezinaPripreme;
        this.trajanjePripreme = trajanjePripreme;
        this.brojOsoba = brojOsoba;
        this.opisJela = opisJela;
    }

    public Jelo() {
    }

    public Integer getJeloId() {
        return jeloId;
    }

    public void setJeloId(Integer jeloId) {
        this.jeloId = jeloId;
    }

    public Integer getKuharId() {
        return kuharId;
    }

    public void setKuharId(Integer kuharId) {
        this.kuharId = kuharId;
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

    public String getTezinaPripreme() {
        return tezinaPripreme;
    }

    public void setTezinaPripreme(String tezinaPripreme) {
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

    /**
     * Vraca sva jela od kuhara sa [kuharId]
     *
     * @param kuharId - id kuhara
     * @return - sva jela koja je kreirao kuhar
     */
    public ArrayList<Jelo> getAllJelaByKuharId(Integer kuharId) {
        JeloSQL jeloSQL = new JeloSQL();
        return jeloSQL.getJelaByKuharIdDB(kuharId);
    }

    /**
     * Vraca sva jela iz baze
     *
     * @return - array list svih jela
     */
    public ArrayList<Jelo> getAllJelo() {
        JeloSQL jeloSQL = new JeloSQL();
        return jeloSQL.getAllJelo();
    }

    /**
     * Vraca sva jela koja pripadaju kuhinji sa [kuhinjaId]
     * @param kuharId
     * @return
     */
    public ArrayList<Jelo> getJeloByKuhinjaId(Integer kuharId){
        JeloSQL jeloSQL = new JeloSQL();
        return jeloSQL.getJelaByKuhinjaIdDB(kuhinjaId);
    }

    /**
     * Izbrisi jelo iz baze po [jeloId]
     * @param jeloId - id jela
     * @return 1 ako je jelo izbrisano, 0 ako brisanje nije uspjesno
     */
    public int deleteJelo(Integer jeloId){
        JeloSQL jeloSQL = new JeloSQL();
        return jeloSQL.deleteJeloDB(jeloId);
    }

    /**
     * Dodaj novo jelo u bazu
     * @param jelo
     */
    public void addJelo(Jelo jelo){
        JeloSQL jeloSQL = new JeloSQL();
        jeloSQL.addJeloDB(jelo);
    }

    /**
     * Dohavati jelo iz DB za jelo sa [imeJela] od kuhara sa [kuharId]
     * @param imeJela
     * @param kuharId
     * @return
     */
    public Jelo getJeloByNameAndKuharId(String imeJela, Integer kuharId){
        JeloSQL jeloSQL = new JeloSQL();
        return jeloSQL.getJeloByNameAndKuharIdDB(imeJela, kuharId);
    }
}

