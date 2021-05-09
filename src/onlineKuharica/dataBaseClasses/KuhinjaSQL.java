package onlineKuharica.dataBaseClasses;

import onlineKuharica.java.Kuhinja;

import java.sql.SQLException;
import java.util.ArrayList;

public class KuhinjaSQL extends Connector  {
    String sqlGetAllKuhinja = "SELECT * FROM online_kuharica.kuhinja";
    String sqlGetKuhinjaById = "SELECT * FROM online_kuharica.kuhinja WHERE online_kuharica.kuhinja.kuhinja_id = ?";

    /**
     * Dohvati sve vrste kuhinja iz baze
     * @return - Array lista kuhinja
     */
    public ArrayList<Kuhinja> getAllKuhinjaDB(){
        connectToDatabase();
        ArrayList<Kuhinja> kuhinje = new ArrayList<>();
        try{
            prpStmt = conn.prepareStatement(sqlGetAllKuhinja);
            rs = prpStmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()){
                Kuhinja kuhinja = new Kuhinja();
                setKuhinjaObjectFromResponse(kuhinja);
                kuhinje.add(kuhinja);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kuhinje;
    }


    public Kuhinja getKuhinjaById(Integer kuhinjaId) throws SQLException{
        connectToDatabase();
        Kuhinja kuhinja = new Kuhinja();

        try{
            prpStmt = conn.prepareStatement(sqlGetKuhinjaById);
            prpStmt.setInt(1, kuhinjaId);
            rs = prpStmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()){
                setKuhinjaObjectFromResponse(kuhinja);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kuhinja;
    }



    /**
     * Helper funkcija za setovanje polja u objektu kuhinja koji se dobije iz ResultSet objekta
     * @param kuhinja
     * @throws SQLException
     */
    private void setKuhinjaObjectFromResponse(Kuhinja kuhinja) throws SQLException{
        kuhinja.setKuhinjaId(rs.getInt("kuhinja_id"));
        kuhinja.setImeKuhinje(rs.getString("ime_kuhinje"));
        kuhinja.setOpisKuhinje(rs.getString("opis_kuhinje"));
    }
}
