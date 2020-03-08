package onlineKuharica.QueryClasses;

import onlineKuharica.Namirnica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class NamirnicaSQL extends Connector{
    String sqlGetNamirnice = "SELECT * FROM `online_kuharica`.`namirnica` WHERE `jelo_id` = ?";
    String sqlAddNamirnica = "INSERT INTO `online_kuharica`.`namirnica` (`namirnica_id`, `jelo_id`, `vrsta_namirnice_id`, `ime_namirnice`, `mjerna_jedinica`, `kolicina`) VALUES (?, ?, ?, ? , ?, ?)";

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

    /**
     * Dodaj namirnicu u bazu podataka za jelo sa [jeloId]
     * @param namirnica
     * @param jeloId
     */
    public void addNamirnicaDB(Namirnica namirnica, Integer jeloId){
        connectToDatabase();
        try {
            prpStmt = conn.prepareStatement(sqlAddNamirnica);
            prpStmt.setNull(1, Types.INTEGER);
            prpStmt.setInt(2, jeloId);
            prpStmt.setInt(3, namirnica.getVrstaNamirniceId());
            prpStmt.setString(4, namirnica.getImeNamirnice());
            prpStmt.setString(5, namirnica.getMjernaJedinica());
            prpStmt.setDouble(6, namirnica.getKolicina());
            prpStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //`namirnica_id`, `jelo_id`, `vrsta_namirnice_id`, `ime_namirnice`, `mjerna_jedinica`, `kolicina`) VALUES

    private void setNamirnicaFromResponse(ResultSet rs, Namirnica namirnica) throws SQLException {
        namirnica.setNamirnicaId(rs.getInt("namirnica_id"));
        namirnica.setJeloId(rs.getInt("jelo_id"));
        namirnica.setImeNamirnice(rs.getString("ime_namirnice"));
        namirnica.setMjernaJedinica(rs.getString("mjerna_jedinica"));
        namirnica.setKolicina(rs.getLong("kolicina"));
    }
}
