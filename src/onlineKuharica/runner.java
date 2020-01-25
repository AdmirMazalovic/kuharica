package onlineKuharica;

import java.sql.ResultSet;
import java.sql.SQLException;

public class runner extends Konektor {
    public static void main(String[] args) {
        Vrsta_jela vrsta_jela = new Vrsta_jela();
        Jelo jelo = new Jelo(null, 2, "Test jelo", 1, "02:00", 4, "Testno jelo");
        String sql = "SELECT `vrsta_jela` FROM `online_kuharica`.`vrsta_jela`" + "where `vrsta_jela_id` = ?";
        ResultSet rs = null;
       // int iD = 0;
        connectToDatabase();
        try {
            prpStmt = conn.prepareStatement(sql);
            prpStmt.setString(1, jelo.getKuhar_id().toString());
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
