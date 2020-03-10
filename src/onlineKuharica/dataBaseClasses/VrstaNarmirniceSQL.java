package onlineKuharica.dataBaseClasses;

import onlineKuharica.java.VrstaNamirnice;

import java.sql.SQLException;
import java.util.ArrayList;

public class VrstaNarmirniceSQL extends Connector{
    private String sqlGetAllVrstaNamirnice = "SELECT * FROM online_kuharica.vrsta_namirnice;";
  //  private String sqlGetVrstaNamirniceByName= "SELECT `online_kuharica`.`vrsta_namirnice`.`vrsta_namirnice_id` FROM `online_kuharica`.`vrsta_namirnice` where `vrsta_namirnice`.`ime_vrste` = ?";

    /**
     * Dohvati sve vrste namrnica iz DB-a
     * @return
     */
    public ArrayList<VrstaNamirnice> getAllVrstaNamirniceDB(){
        connectToDatabase();
        ArrayList<VrstaNamirnice> vrsteNamirnice = new ArrayList<>();
        try {
            prpStmt = conn.prepareStatement(sqlGetAllVrstaNamirnice);
            rs = prpStmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()){
                VrstaNamirnice vrstaNamirnice = new VrstaNamirnice();
                setVrstaNamirniceFromResponse(vrstaNamirnice);
                vrsteNamirnice.add(vrstaNamirnice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vrsteNamirnice;
    }

    /**
     * Helper funkcija za setovanje polja u objektu koji se dobije iz ResultSet-a
     * @param vrstaNamirnice
     * @throws SQLException
     */
    private void setVrstaNamirniceFromResponse(VrstaNamirnice vrstaNamirnice) throws SQLException{
        vrstaNamirnice.setVrstaNamirniceId(rs.getInt("vrsta_namirnice_id"));
        vrstaNamirnice.setImeVrste(rs.getString("ime_vrste"));
    }
}
