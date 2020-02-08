package onlineKuharica.QueryClasses;

import onlineKuharica.Namirnica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NamirnicaSQL extends Connector{
    String sqlGetNamirnice = "SELECT * FROM `online_kuharica`.`namirnica` WHERE `jelo_id` = ?";


    /**
     * Dohvati sve namirnice za jelo sa [jeloId]
     * @param jeloId - id jela
     * @return - array list namirnica potrebnih za pripremu jela
     */
    public ArrayList<Namirnica> getNamirniceByJeloIdDB(Integer jeloId){
        ArrayList<Namirnica> namirnice = new ArrayList<>();
        connectToDatabase();
        try {
            prpStmt = conn.prepareStatement(sqlGetNamirnice);
            prpStmt.setInt(1, jeloId);
            rs = prpStmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()){
                Namirnica namirnica = new Namirnica();
                setNamirnicaFromResponse(rs, namirnica);
                namirnice.add(namirnica);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return namirnice;
    }

    private void setNamirnicaFromResponse(ResultSet rs, Namirnica namirnica) throws SQLException {
        namirnica.setNamirnicaId(rs.getInt("namirnica_id"));
        namirnica.setJeloId(rs.getInt("jelo_id"));
        namirnica.setImeNamirnice(rs.getString("ime_namirnice"));
        namirnica.setMjernaJedinica(rs.getString("mjerna_jedinica"));
        namirnica.setKolicina(rs.getLong("kolicina"));
    }
}
