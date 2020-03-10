package onlineKuharica.java;

import onlineKuharica.dataBaseClasses.VrstaJelaSQL;

import java.util.ArrayList;

public class VrstaJela extends VrstaJelaSQL {
    private int vrsta_jela_id;
    private String vrsta_jela;

    public VrstaJela(int vrsta_jela_id, String vrsta_jela) {
        this.vrsta_jela_id = vrsta_jela_id;
        this.vrsta_jela = vrsta_jela;
    }

    public VrstaJela() {
    }

    public int getVrsta_jela_id() {
        return vrsta_jela_id;
    }

    public void setVrsta_jela_id(int vrsta_jela_id) {
        this.vrsta_jela_id = vrsta_jela_id;
    }

    public String getVrsta_jela() {
        return vrsta_jela;
    }

    public void setVrsta_jela(String vrsta_jela) {
        this.vrsta_jela = vrsta_jela;
    }

    /**
     * Vraca vrstu jela po id-u
     * @param vrstaJelaId - id vrste jela
     * @return Vrsta jela
     */
    public VrstaJela getVrstaJelaById(Integer vrstaJelaId){
        VrstaJelaSQL vrstaJelaSQL = new VrstaJelaSQL();
        return vrstaJelaSQL.getVrstaJelaByIdDB(vrstaJelaId);
    }

    /**
     * Dodaj novu vrstu jela u bazu
     * @param vrstaJela - Vrsta jela
     * @return nova dodana vrsta jela
     */
    public VrstaJela addVrstaJela(VrstaJela vrstaJela){
        VrstaJelaSQL novaVrstaJela = new VrstaJelaSQL();
        return novaVrstaJela.addVrstaJelaDB(vrstaJela);
    }

    /**
     * Dohvati sve vrste jela iz DB
     * @return
     */
    public ArrayList<VrstaJela> getAllVrstaJela(){
        VrstaJelaSQL vrstaJelaSQL = new VrstaJelaSQL();
        return vrstaJelaSQL.getAllVrstaJelaDB();
    }
}
