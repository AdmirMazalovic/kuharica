package onlineKuharica.QueryClasses;

import onlineKuharica.Kuhar;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KuharSQL extends Connector {
    ResultSet rs = null;
    String sqlGetKuharById = "SELECT * FROM `online_kuharica`.`kuhar` WHERE `kuhar_id` = ?";

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
                kuhar.setDatumRegistracije(rs.getTimestamp("datum_registracije"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnectionSQL();
        return kuhar;
    }
}
