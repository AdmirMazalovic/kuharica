package onlineKuharica.dataBaseClasses;

import onlineKuharica.java.Recept;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceptSQL extends Connector {
    String sqlGetReceptByJeloId = "SELECT * FROM `online_kuharica`.`recept` WHERE `recept`.`jelo_id` = ?";
    String sqlAddRecept = "INSERT INTO `online_kuharica`.`recept` (`jelo_id`, `datum_objave`, `opis_pripreme`) VALUES (?, NOW(), ?)";
    String sqlUpdateRecept = "UPDATE online_kuharica.recept SET opis_pripreme = ? WHERE jelo_id = ?";


    /**
     * Dohvata recept od jela sa jelo id-om
     * @param jeloId - id jela za koje zelimo dohvatiti recept
     * @return - recept
     */
    public Recept getReceptByJeloIdDB(Integer jeloId){
        Recept recept = new Recept();
        connectToDatabase();
        try {
            prpStmt = conn.prepareStatement(sqlGetReceptByJeloId);
            prpStmt.setInt(1, jeloId);
            rs = prpStmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while(rs.next()){
                setReceptObjectFromResponse(rs, recept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recept;
    }

    /**
     * Dodaj novi recept
     * @param recept
     */
    public void addReceptDB(Recept recept){
        connectToDatabase();
        try {
            prpStmt = conn.prepareStatement(sqlAddRecept);
            prpStmt.setInt(1, recept.getJeloId());
            prpStmt.setString(2, recept.getOpisPipreme());
            prpStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Helper funkcija (object mapper) za objekat tipa Recept
     * @param rs - Result set
     * @param recept - objekat tipa Recept
     * @throws SQLException
     */
    private void setReceptObjectFromResponse(ResultSet rs, Recept recept) throws SQLException {
        recept.setJeloId(rs.getInt("jelo_id"));
        recept.setDatumObjave(rs.getDate("datum_objave"));
        recept.setOpisPipreme(rs.getString("opis_pripreme"));
    }

    public void updateReceptDB(Integer jelo_id, String opis_pripreme) {
        connectToDatabase();
        try {
            prpStmt = conn.prepareStatement(sqlUpdateRecept);
            prpStmt.setString(1, opis_pripreme);
            prpStmt.setInt(2, jelo_id);
            prpStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}