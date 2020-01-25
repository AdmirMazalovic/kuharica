package onlineKuharica;

public class Namirnica {
    private Integer namirnicaId;
    private Integer jeloId;
    private String imeNamirnice;

    public Namirnica(Integer namirnicaId, Integer jeloId, String imeNamirnice) {
        this.namirnicaId = namirnicaId;
        this.jeloId = jeloId;
        this.imeNamirnice = imeNamirnice;
    }

    public Namirnica() {
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
}
