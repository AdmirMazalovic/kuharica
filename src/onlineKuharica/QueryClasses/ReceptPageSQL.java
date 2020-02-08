package onlineKuharica.QueryClasses;

import onlineKuharica.ReceptPage;

import java.sql.SQLException;

public class ReceptPageSQL extends Connector {

    String sqlGetRecept = "SELECT `jelo`.`jelo_id`," +
            "    `jelo`.`kuhar_id`," +
            "    `kuhar`.`ime`," +
            "    `kuhar`.`prezime`," +
            "    `kuhar`.`email`," +
            "     `kuhar`.`drzava`," +
            "     `kuhar`.`grad`,"+
            "    `jelo`.`ime_jela`," +
            "    `jelo`.`kuhinja_id`," +
            "    `jelo`.`vrsta_jela_id`," +
            "    `jelo`.`tezina_pripreme`," +
            "    `jelo`.`trajanje_pripreme`," +
            "    `jelo`.`broj_osoba`," +
            "    `jelo`.`opis_jela`," +
            "    `recept`.`datum_objave`," +
            "    `recept`.`opis_pripreme`" +
            "FROM `online_kuharica`.`jelo` LEFT JOIN `online_kuharica`.`recept` ON `jelo`.`jelo_id` = `recept`.`jelo_id`" +
            "LEFT JOIN `online_kuharica`.`kuhar` ON `jelo`.`kuhar_id` = `kuhar`.`kuhar_id`" +
            "WHERE `jelo`.`jelo_id` = ?";

    public ReceptPage getReceptByJeloIdDB(Integer jeloId) {
        ReceptPage receptPage = new ReceptPage();
        connectToDatabase();
        try {
            prpStmt = conn.prepareStatement(sqlGetRecept);
            prpStmt.setInt(1, jeloId);
            rs = prpStmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                setReceptFromResponse(receptPage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return receptPage;

    }

    private void setReceptFromResponse(ReceptPage receptPage) throws SQLException {
        receptPage.setKuharId(rs.getInt("kuhar_id"));
        receptPage.setIme(rs.getString("ime"));
        receptPage.setPrezime(rs.getString("prezime"));
        receptPage.setEmail(rs.getString("email"));
        receptPage.setDrzava(rs.getString("drzava"));
        receptPage.setGrad(rs.getString("grad"));
        receptPage.setJeloId(rs.getInt("jelo_id"));
        receptPage.setImeJela(rs.getString("ime_jela"));
        receptPage.setKuhinjaId(rs.getInt("kuhinja_id"));
        receptPage.setVrstaJelaId(rs.getInt("vrsta_jela_id"));
        receptPage.setTezinaPripreme(rs.getInt("tezina_pripreme"));
        receptPage.setTrajanjePripreme(rs.getString("trajanje_pripreme"));
        receptPage.setBrojOsoba(rs.getInt("broj_osoba"));
        receptPage.setOpisJela(rs.getString("opis_jela"));
        receptPage.setDatumObjave(rs.getDate("datum_objave"));
        receptPage.setOpisJela(rs.getString("opis_pripreme"));
    }
}
