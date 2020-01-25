package onlineKuharica;

public class VrstaNamirnice {
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
}
