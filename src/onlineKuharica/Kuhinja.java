package onlineKuharica;

public class Kuhinja {
    private Integer kuhinjaId;
    private String imeKuhinje;
    private String opisKuhinje;

    public Kuhinja(Integer kuhinjaId, String imeKuhinje, String opisKuhinje) {
        this.kuhinjaId = kuhinjaId;
        this.imeKuhinje = imeKuhinje;
        this.opisKuhinje = opisKuhinje;
    }

    public Kuhinja() {
    }

    public Integer getKuhinjaId() {
        return kuhinjaId;
    }

    public void setKuhinjaId(Integer kuhinjaId) {
        this.kuhinjaId = kuhinjaId;
    }

    public String getImeKuhinje() {
        return imeKuhinje;
    }

    public void setImeKuhinje(String imeKuhinje) {
        this.imeKuhinje = imeKuhinje;
    }

    public String getOpisKuhinje() {
        return opisKuhinje;
    }

    public void setOpisKuhinje(String opisKuhinje) {
        this.opisKuhinje = opisKuhinje;
    }
}
