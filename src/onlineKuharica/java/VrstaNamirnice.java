package onlineKuharica.java;

import onlineKuharica.dataBaseClasses.VrstaJelaSQL;
import onlineKuharica.dataBaseClasses.VrstaNarmirniceSQL;

import java.util.ArrayList;

public class VrstaNamirnice extends VrstaJelaSQL {
    private Integer vrstaNamirniceId;
    private String imeVrste;
    private VrstaNarmirniceSQL vrstaNarmirniceSQL = new VrstaNarmirniceSQL();

    public VrstaNamirnice(Integer vrstaNamirniceId, String imeVrste) {
        this.vrstaNamirniceId = vrstaNamirniceId;
        this.imeVrste = imeVrste;
    }

    public VrstaNamirnice() {
    }

    public Integer getVrstaNamirniceId() {
        return vrstaNamirniceId;
    }

    public void setVrstaNamirniceId(Integer vrstaNamirniceId) {
        this.vrstaNamirniceId = vrstaNamirniceId;
    }

    public String getImeVrste() {
        return imeVrste;
    }

    public void setImeVrste(String imeVrste) {
        this.imeVrste = imeVrste;
    }

    /**
     * Dohvati sve vrste namirnica iz baze podataka
     *
     * @return
     */
    public ArrayList<VrstaNamirnice> getAllVrstaNamirnice() {
        return vrstaNarmirniceSQL.getAllVrstaNamirniceDB();
    }

    public VrstaNamirnice getVrstaNamirniceById(Integer vrstaNamirniceId) {
        return vrstaNarmirniceSQL.getVrstaNamirniceById(vrstaNamirniceId);
    }
}
