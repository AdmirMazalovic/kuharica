package onlineKuharica;

import onlineKuharica.QueryClasses.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class runner extends Connector {
    public static void main(String[] args) {
        VrstaJela vrsta_jela = new VrstaJela();
        Jelo jelo = new Jelo(null, 2, "Test jelo", 1, 2, "02:00", 4, "Testno jelo");
        String sql = "SELECT `vrsta_jela` FROM `online_kuharica`.`vrsta_jela`" + "where `vrsta_jela_id` = ?";
        ResultSet rs = null;
        // int iD = 0;
        connectToDatabase();
        try {
            prpStmt = conn.prepareStatement(sql);
            prpStmt.setString(1, jelo.getKuharId().toString());
            //System.out.println(prpStmt);
            rs = prpStmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                //    int id = rs.getInt("vrsta_jela_id");
                String vrstaJela = rs.getString("vrsta_jela");
                //     System.out.println(id);
                System.out.println(vrstaJela);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
