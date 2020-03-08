package onlineKuharica.QueryClasses;

import onlineKuharica.VrstaJela;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class VrstaJelaSQL extends Connector {
    String sqlGetAllVrstaJela = "SELECT * FROM `online_kuharica`.`vrsta_jela`";
    String sqlGetVrstaJelaById = "SELECT `vrsta_jela`, `vrsta_jela_id` FROM `online_kuharica`.`vrsta_jela` WHERE `vrsta_jela_id` = ?";
    String sqlGetVrstaJelaByName = "SELECT `vrsta_jela`, `vrsta_jela_id` FROM `online_kuharica`.`vrsta_jela` WHERE `vrsta_jela` = ?";
    String sqlAddVrstaJela = "INSERT INTO `online_kuharica`.`vrsta_jela` (`vrsta_jela_id`, `vrsta_jela`) VALUES (?, ?)";

    /**
     * Dohvata vrstu jela iz baze sa vrsta_jela_id: [vrstaJelaId]
     *
     * @param vrstaJelaId - id vrste jela
     * @return - vraca vrstu jela
     */
    public VrstaJela getVrstaJelaByIdDB(Integer vrstaJelaId) {
        VrstaJela vrstaJela = new VrstaJela();
        connectToDatabase();
        try {
            prpStmt = conn.prepareStatement(sqlGetVrstaJelaById);
            prpStmt.setString(1, vrstaJelaId.toString());
            rs = prpStmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                vrstaJela.setVrsta_jela_id(rs.getInt("vrsta_jela_id"));
                vrstaJela.setVrsta_jela(rs.getString("vrsta_jela"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnectionSQL();
        return vrstaJela;
    }

    /**
     * Dohvati vrstu jela po imenu
     *
     * @param vrstaJelaName - ime vrste jela
     * @return
     */
    public VrstaJela getVrstaJelaByNameDB(String vrstaJelaName) {
        VrstaJela vrstaJela = new VrstaJela();
        connectToDatabase();
        try {
            prpStmt = conn.prepareStatement(sqlGetVrstaJelaByName);
            prpStmt.setString(1, vrstaJelaName);
            rs = prpStmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                vrstaJela.setVrsta_jela_id(rs.getInt("vrsta_jela_id"));
                vrstaJela.setVrsta_jela(rs.getString("vrsta_jela"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnectionSQL();
        return vrstaJela;
    }

    /**
     * Dodaj novu vrstu jela
     * @param vrstaJela - Vrsta jela
     * @return - Nova vrsta jela dodana u bazu
     */
    public VrstaJela addVrstaJelaDB(VrstaJela vrstaJela) {
        VrstaJela novaVrstaJela = null;
        connectToDatabase();
        try {
            prpStmt = conn.prepareStatement(sqlAddVrstaJela);
            prpStmt.setNull(1, Types.INTEGER);
            prpStmt.setString(2, vrstaJela.getVrsta_jela());
            prpStmt.executeUpdate();
            novaVrstaJela = getVrstaJelaByNameDB(vrstaJela.getVrsta_jela());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnectionSQL();
        return novaVrstaJela;
    }

    /**
     * Dohvati sve vrste jela iz DB
     * @return
     */
    public ArrayList<VrstaJela> getAllVrstaJelaDB(){
        connectToDatabase();
        ArrayList<VrstaJela> vrsteJela = new ArrayList<>();
        try {
            prpStmt = conn.prepareStatement(sqlGetAllVrstaJela);
            rs = prpStmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()){
                VrstaJela vrstaJela = new VrstaJela();
                setVrstaJelaObjectFromResponse(vrstaJela);
                vrsteJela.add(vrstaJela);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vrsteJela;
    }


    /**
     * Helper funkcija (object mapper) za setovanje polja u objektu vrstaJela koji se dobije iz ResultSet objekta
     * @param vrstaJela
     * @throws SQLException
     */
    private void setVrstaJelaObjectFromResponse(VrstaJela vrstaJela) throws SQLException{
        vrstaJela.setVrsta_jela_id(rs.getInt("vrsta_jela_id"));
        vrstaJela.setVrsta_jela(rs.getString("vrsta_jela"));
    }
}
