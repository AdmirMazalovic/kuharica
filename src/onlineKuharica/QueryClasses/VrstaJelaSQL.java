package onlineKuharica.QueryClasses;

import onlineKuharica.VrstaJela;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VrstaJelaSQL extends Connector {
    ResultSet rs = null;
    String sqlGetVrstaJela = "SELECT `vrsta_jela` FROM `online_kuharica`.`vrsta_jela`" + "where `vrsta_jela_id` = ?";

    /**
     * Dohvata vrstu jela iz baze sa vrsta_jela_id: [vrstaJelaId]
     * @param vrstaJelaId - id vrste jela
     * @return - vraca vrstu jela
     */
    public VrstaJela getVrstaJela(Integer vrstaJelaId) {
        VrstaJela vrstaJela = new VrstaJela();
        connectToDatabase();
        try {
            prpStmt = conn.prepareStatement(sqlGetVrstaJela);
            prpStmt.setString(1, vrstaJelaId.toString());
            rs = prpStmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                vrstaJela.setVrsta_jela(rs.getString("vrsta_jela"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        vrstaJela.setVrsta_jela_id(vrstaJelaId);
        return vrstaJela;
    }
}
