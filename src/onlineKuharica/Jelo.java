package onlineKuharica;

public class Jelo {
    private Integer jelo_id;
    private int kuhar_id;
    private String ime_jela;
    private int vrsta_jela_id;
    private int tezina_pripreme;
    private String trajanje_pripreme;
    private int broj_osoba;
    private String opis_jela;

    public int getJelo_id() {
        return jelo_id;
    }

    public void setJelo_id(int jelo_id) {
        this.jelo_id = jelo_id;
    }

    public Integer getKuhar_id() {
        return kuhar_id;
    }

    public void setKuhar_id(int kuhar_id) {
        this.kuhar_id = kuhar_id;
    }

    public String getIme_jela() {
        return ime_jela;
    }

    public void setIme_jela(String ime_jela) {
        this.ime_jela = ime_jela;
    }

    public int getVrsta_jela_id() {
        return vrsta_jela_id;
    }

    public void setVrsta_jela_id(int vrsta_jela_id) {
        this.vrsta_jela_id = vrsta_jela_id;
    }

    public int getTezina_pripreme() {
        return tezina_pripreme;
    }

    public void setTezina_pripreme(int tezina_pripreme) {
        this.tezina_pripreme = tezina_pripreme;
    }

    public String getTrajanje_pripreme() {
        return trajanje_pripreme;
    }

    public void setTrajanje_pripreme(String trajanje_pripreme) {
        this.trajanje_pripreme = trajanje_pripreme;
    }

    public int getBroj_osoba() {
        return broj_osoba;
    }

    public void setBroj_osoba(int broj_osoba) {
        this.broj_osoba = broj_osoba;
    }

    public String getOpis_jela() {
        return opis_jela;
    }

    public void setOpis_jela(String opis_jela) {
        this.opis_jela = opis_jela;
    }

    public Jelo(Integer jelo_id, int kuhar_id, String ime_jela, int vrsta_jela_id, String trajanje_pripreme, int broj_osoba, String opis_jela) {
        this.jelo_id = jelo_id;
        this.kuhar_id = kuhar_id;
        this.ime_jela = ime_jela;
        this.vrsta_jela_id = vrsta_jela_id;
        this.tezina_pripreme = tezina_pripreme;
        this.trajanje_pripreme = trajanje_pripreme;
        this.broj_osoba = broj_osoba;
        this.opis_jela = opis_jela;
    }
}
