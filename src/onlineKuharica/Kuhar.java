package onlineKuharica;

import java.util.Date;

public class Kuhar {
    private Integer kuharId;
    private String ime;
    private String prezime;
    private String email;
    private String password;
    private char spol;
    private Date datum_rodjenja;
    private String drzava;
    private String grad;
    private Integer zip;
    private String adresa;
    private String brojTelefona;
    private String oMeni;

    public Kuhar(Integer kuharId, String ime, String prezime, String email, String password, char spol, Date datum_rodjenja, String drzava, String grad, Integer zip, String adresa, String brojTelefona, String oMeni) {
        this.kuharId = kuharId;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.password = password;
        this.spol = spol;
        this.datum_rodjenja = datum_rodjenja;
        this.drzava = drzava;
        this.grad = grad;
        this.zip = zip;
        this.adresa = adresa;
        this.brojTelefona = brojTelefona;
        this.oMeni = oMeni;
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

    public Date getDatum_rodjenja() {
        return datum_rodjenja;
    }

    public void setDatum_rodjenja(Date datum_rodjenja) {
        this.datum_rodjenja = datum_rodjenja;
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

    public String getoMeni() {
        return oMeni;
    }

    public void setoMeni(String oMeni) {
        this.oMeni = oMeni;
    }
}
