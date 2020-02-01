package onlineKuharica.QueryClasses;

import onlineKuharica.Kuhar;

import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class KuharSQL extends Connector {
    ResultSet rs = null;
    String sqlGetKuharById = "SELECT * FROM `online_kuharica`.`kuhar` WHERE `kuhar_id` = ?";
    String sqlGetKuharByName = "SELECT * FROM `online_kuharica`.`kuhar` WHERE `ime` = ? AND `prezime` = ?";
    String sqlGetKuharForLogin = "SELECT * FROM `online_kuharica`.`kuhar` WHERE `ime` = ? AND `prezime` = ? AND `password` = ?";
    String sqlAddKuhar = "INSERT INTO `online_kuharica`.`kuhar`" +
            "(`kuhar_id`,`ime` ,`prezime`, `email`, `password`, `spol`, `datum_rodjenja`, `drzava`, `grad`, `zip`, `adresa`, `broj_telefona`, `o_meni`,`datum_registracije`)" +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String sqlUpdateKuhar = "UPDATE online_kuharica.kuhar SET `ime`= ?, `prezime` = ?, `email` = ?, `datum_rodjenja` = ?, `drzava` =  ?, `grad` = ?, `zip` = ?, `adresa` = ?, `broj_telefona` = ?, `o_meni` = ?  WHERE `kuhar_id` = ?";
    String sqlUpdatePassword = "UPDATE online_kuharica.kuhar SET `password` = ? WHERE `kuhar_id` = ?";

    /**
     * Dohvati kuhara iz baze podataka po id-u
     *
     * @param kuharId -kuhar id
     * @return kuhar
     */
    public Kuhar getKuharByIdDB(Integer kuharId) {
        Kuhar kuhar = new Kuhar();
        connectToDatabase();
        try {
            prpStmt = conn.prepareStatement(sqlGetKuharById);
            prpStmt.setString(1, kuharId.toString());
            rs = prpStmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                setKuharObjectFromResposne(kuhar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnectionSQL();
        return kuhar;
    }

    /**
     * Dohvati kuhara iz baze podataka po imenu
     *
     * @param imeKuhara - ime kuhara
     * @param prezime   - prezime kuhara
     * @return kuhar
     */
    public Kuhar getKuharByNameDB(String imeKuhara, String prezime) {
        Kuhar kuhar = new Kuhar();
        connectToDatabase();
        try {
            prpStmt = conn.prepareStatement(sqlGetKuharByName);
            prpStmt.setString(1, imeKuhara);
            prpStmt.setString(2, prezime);
            rs = prpStmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                setKuharObjectFromResposne(kuhar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnectionSQL();
        return kuhar;
    }

    /**
     * Dohvati kuhara iz baze po imenu, przimenu i passwordu (koristi se za login u aplikaciju)
     *
     * @param imeKuhara     - ime kuhara
     * @param prezimeKuhara - prezime kuhara
     * @param password      - password kuhara
     * @return - kuhar objekat
     */
    public Kuhar getKuharForLoginDB(String imeKuhara, String prezimeKuhara, String password) {
        Kuhar kuhar = new Kuhar();
        connectToDatabase();
        try {
            prpStmt = conn.prepareStatement(sqlGetKuharForLogin);
            prpStmt.setString(1, imeKuhara);
            prpStmt.setString(2, prezimeKuhara);
            prpStmt.setString(3, password);
            rs = prpStmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                setKuharObjectFromResposne(kuhar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnectionSQL();
        return kuhar;
    }


    public Kuhar addKuharDB(Kuhar kuhar) {
        connectToDatabase();
        try {
            prpStmt = conn.prepareStatement(sqlAddKuhar);
            prpStmt.setNull(1, Types.INTEGER);
            prpStmt.setString(2, kuhar.getIme());
            prpStmt.setString(3, kuhar.getPrezime());
            prpStmt.setString(4, kuhar.getEmail());
            prpStmt.setString(5, kuhar.getPassword());
            prpStmt.setString(6, String.valueOf(kuhar.getSpol()));
            prpStmt.setString(7, kuhar.getDatumRodjenja().toString());
            prpStmt.setString(8, kuhar.getDrzava());
            prpStmt.setString(9, kuhar.getGrad());
            prpStmt.setInt(10, kuhar.getZip());
            prpStmt.setString(11, kuhar.getAdresa());
            prpStmt.setString(12, kuhar.getBrojTelefona());
            prpStmt.setString(13, kuhar.getOmeni());
            Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
            prpStmt.setTimestamp(14, date);
            prpStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getKuharForLoginDB(kuhar.getIme(), kuhar.getPrezime(), kuhar.getPassword());
    }

    /**
     * Update kuhara sa novim informacijama
     *
     * @param kuhar - kuhar koji se updatuje
     * @return - kuhar sa novim infomracijama
     */
    public Kuhar updateKuharInfoDB(Kuhar kuhar) {
        connectToDatabase();
        try {
            prpStmt = conn.prepareStatement(sqlUpdateKuhar);
            prpStmt.setString(1, kuhar.getIme());
            prpStmt.setString(2, kuhar.getPrezime());
            prpStmt.setString(3, kuhar.getEmail());
            prpStmt.setDate(4, kuhar.getDatumRodjenja());
            prpStmt.setString(5, kuhar.getDrzava());
            prpStmt.setString(6, kuhar.getGrad());
            prpStmt.setInt(7, kuhar.getZip());
            prpStmt.setString(8, kuhar.getAdresa());
            prpStmt.setString(9, kuhar.getBrojTelefona());
            prpStmt.setString(10, kuhar.getOmeni());
            prpStmt.setInt(11, kuhar.getKuharId());
            prpStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getKuharByIdDB(kuhar.getKuharId());
    }

    /**
     * Helper funkcija za setovanje polja u objektu kuhar koji se dobije iz ResultSet objekta
     *
     * @param kuhar - kuhar objekat cija polja se setuju
     * @throws SQLException
     */
    private void setKuharObjectFromResposne(Kuhar kuhar) throws SQLException {
        kuhar.setKuharId(rs.getInt("kuhar_id"));
        kuhar.setIme(rs.getString("ime"));
        kuhar.setPrezime(rs.getString("prezime"));
        kuhar.setEmail(rs.getString("email"));
        kuhar.setPassword(rs.getString("password"));
        kuhar.setSpol(rs.getString("spol").toCharArray()[0]);
        kuhar.setDatumRodjenja(rs.getDate("datum_rodjenja"));
        kuhar.setGrad(rs.getString("grad"));
        kuhar.setZip(rs.getInt("zip"));
        kuhar.setAdresa(rs.getString("adresa"));
        kuhar.setBrojTelefona(rs.getString("broj_telefona"));
        kuhar.setOmeni(rs.getString("o_meni"));
        kuhar.setDatumRegistracije(rs.getDate("datum_registracije"));
    }
}
