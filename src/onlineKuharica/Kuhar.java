package onlineKuharica;

import onlineKuharica.QueryClasses.KuharSQL;

import java.util.Date;

public class Kuhar extends KuharSQL {
    private Integer kuharId;
    private String ime;
    private String prezime;
    private String email;
    private String password;
    private char spol;
    private Date datumRodjenja;
    private String drzava;
    private String grad;
    private Integer zip;
    private String adresa;
    private String brojTelefona;
    private String oMeni;
    private Date datumRegistracije;

    public Kuhar(Integer kuharId, String ime, String prezime, String email, String password, char spol, Date datumRodjenja, String drzava, String grad, Integer zip, String adresa, String brojTelefona, String oMeni, Date datumRegistracije) {
        this.kuharId = kuharId;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.password = password;
        this.spol = spol;
        this.datumRodjenja = datumRodjenja;
        this.drzava = drzava;
        this.grad = grad;
        this.zip = zip;
        this.adresa = adresa;
        this.brojTelefona = brojTelefona;
        this.oMeni = oMeni;
        this.datumRegistracije = datumRegistracije;
    }

    public Kuhar() {
    }

    public Integer getKuharId() {
        return kuharId;
    }

    public void setKuharId(Integer kuharId) {
        this.kuharId = kuharId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getSpol() {
        return spol;
    }

    public void setSpol(char spol) {
        this.spol = spol;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getOmeni() {
        return oMeni;
    }

    public void setOmeni(String oMeni) {
        this.oMeni = oMeni;
    }

    public Date getDatumRegistracije() {
        return datumRegistracije;
    }

    public void setDatumRegistracije(Date datumRegistracije) {
        this.datumRegistracije = datumRegistracije;
    }

    /**
     * Dohvati kuhara iz baze po id-u
     * @param kuharId - id kuhara
     * @return - kuhar
     */
    public Kuhar getKuharById(Integer kuharId){
        KuharSQL kuharSQL = new KuharSQL();
        return kuharSQL.getKuharByIdDB(kuharId);
    }

    /**
     * Dohvati kuhara iz baze po imenu
     * @param imeKuhara - ime kuhara
     * @return - kuhar
     */
    public Kuhar getKuharByName(String imeKuhara){
        KuharSQL kuharSQL = new KuharSQL();
        return kuharSQL.getKuharByNameDB(imeKuhara);
    }


    /**
     * Dodaj novog kuhara u bazu
     * @param kuhar - kuhar kojeg dodajemo u bazu
     * @return - kuhar koji je dadan u bazu
     */
    public Kuhar addKuhar(Kuhar kuhar){
        KuharSQL kuharSQL = new KuharSQL();
        return kuharSQL.addKuharDB(kuhar);
    }
}
