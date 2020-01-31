package onlineKuharica.QueryClasses;

import onlineKuharica.Kuhar;

import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class KuharSQL extends Connector {
    ResultSet rs = null;
    String sqlGetKuharById = "SELECT * FROM `online_kuharica`.`kuhar` WHERE `kuhar_id` = ?";
    String sqlGetKuharByName = "SELECT * FROM `online_kuharica`.`kuhar` WHERE `ime` = ?";
    String sqlAddKuhar = "INSERT INTO `online_kuharica`.`kuhar`" +
            "(`kuhar_id`,`ime` ,`prezime`, `email`, `password`, `spol`, `datum_rodjenja`, `drzava`, `grad`, `zip`, `adresa`, `broj_telefona`, `o_meni`,`datum_registracije`)" +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
     * @param imeKuhara -kuhar id
     * @return kuhar
     */
    public Kuhar getKuharByNameDB(String imeKuhara) {
        Kuhar kuhar = new Kuhar();
        connectToDatabase();
        try {
            prpStmt = conn.prepareStatement(sqlGetKuharByName);
            prpStmt.setString(1, imeKuhara);
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
        return getKuharByNameDB(kuhar.getIme());
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
