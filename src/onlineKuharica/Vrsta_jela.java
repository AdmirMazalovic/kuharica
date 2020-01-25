package onlineKuharica;

public class Vrsta_jela {
    public Vrsta_jela() {
    }

    private int vrsta_jela_id;
    private String vrsta_jela;

    public int getVrsta_jela_id() {
        return vrsta_jela_id;
    }

    public void setVrsta_jela_id(int vrsta_jela_id) {
        this.vrsta_jela_id = vrsta_jela_id;
    }

    public String getVrsta_jela(){
        return vrsta_jela;
    }

    public void setVrsta_jela(String vrsta_jela){
        this.vrsta_jela = vrsta_jela;
    }

    public Vrsta_jela(int vrsta_jela_id, String vrsta_jela){
        this.vrsta_jela_id = vrsta_jela_id;
        this.vrsta_jela = vrsta_jela;
    }
}
