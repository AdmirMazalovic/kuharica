package onlineKuharica;

import onlineKuharica.QueryClasses.VrstaJelaSQL;
import onlineKuharica.QueryClasses.VrstaNarmirniceSQL;

import java.util.ArrayList;

public class VrstaNamirnice extends VrstaJelaSQL {
    private Integer vrstaNamirniceId;
    private String imeVrste;

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
     * @return
     */
    public ArrayList<VrstaNamirnice> getAllVrstaNamirnice(){
        VrstaNarmirniceSQL vrstaNarmirniceSQL = new VrstaNarmirniceSQL();
        return vrstaNarmirniceSQL.getAllVrstaNamirniceDB();
    }
}
