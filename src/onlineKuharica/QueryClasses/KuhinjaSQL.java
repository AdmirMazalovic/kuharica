package onlineKuharica.QueryClasses;

import onlineKuharica.Kuhinja;

import java.sql.SQLException;
import java.util.ArrayList;

public class KuhinjaSQL extends Connector  {
    String sqlGetAllKuhinja = "SELECT * FROM online_kuharica.kuhinja";

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
