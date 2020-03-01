package onlineKuharica.QueryClasses;

import onlineKuharica.Jelo;

import java.sql.SQLException;
import java.util.ArrayList;

public class JeloSQL extends Connector {
    String sqlGetAllJelo = "SELECT * FROM `online_kuharica`.`jelo`";
    String sqlGetJelaByKuharId = "SELECT * FROM `online_kuharica`.`jelo` WHERE `jelo`.`kuhar_id` = ?";
    String sqlGetJeloByKuhinjaId = "SELECT * FROM `online_kuharica`.`jelo` WHERE `jelo`.`kuhinja_id` = ?";
    String sqlGetJeloByTezinaPripreme = "SELECT * FROM `online_kuharica`.`jelo` WHERE `jelo`.`tezina_pripreme` = ?";
    String sqlDeleteJeloById = "DELETE FROM `online_kuharica`.`jelo` WHERE `jelo`.`jelo_id` = ?";


    /**
     * Vraca sva jelo od kuhara
     * @param kuharId - id kuhara
     * @return
     */
    public ArrayList<Jelo> getJelaByKuharIdDB(Integer kuharId){
        connectToDatabase();
        ArrayList<Jelo> jela = new ArrayList<>();
        try {
            prpStmt = conn.prepareStatement(sqlGetJelaByKuharId);
            prpStmt.setString(1, kuharId.toString());
            rs = prpStmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                Jelo jelo = new Jelo();
                setJeloObjectFromResponse(jelo);
                jela.add(jelo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnectionSQL();
        return jela;
    }

    /**
     * Dohvati sva jela iz baze
     * @return - Array list svih jela
     */
    public ArrayList<Jelo> getAllJelo(){
        connectToDatabase();
        ArrayList<Jelo> jela = new ArrayList<>();
        try {
            prpStmt = conn.prepareStatement(sqlGetAllJelo);
            rs = prpStmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                Jelo jelo = new Jelo();
                setJeloObjectFromResponse(jelo);
                jela.add(jelo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnectionSQL();
        return jela;
    }

    /**
     * Dovhati sva jela koja pripadaju kuhinji sa [kuhinjaId]
     * @param kuhinjaId - id kuhinje
     * @return - array list svih jela koji pripadaju kuhinji sa [kuhinjaId]
     */
    public ArrayList<Jelo> getJelaByKuhinjaIdDB(Integer kuhinjaId){
        connectToDatabase();
        ArrayList<Jelo> jela = new ArrayList<>();
        try {
            prpStmt = conn.prepareStatement(sqlGetJeloByKuhinjaId);
            prpStmt.setString(1, kuhinjaId.toString());
            rs = prpStmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                Jelo jelo = new Jelo();
                setJeloObjectFromResponse(jelo);
                jela.add(jelo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnectionSQL();
        return jela;
    }

    /**
     * Izbrisi jelo iz baze
     * @param jeloId
     * @return
     */
    public int deleteJeloDB(Integer jeloId) {
        connectToDatabase();
        try {
            prpStmt = conn.prepareStatement(sqlDeleteJeloById);
            prpStmt.setInt(1, jeloId);
            return prpStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * Helper funkcija (object mapper) za objekat tipa Jelo
     * @param jelo
     * @throws SQLException
     */
    private void setJeloObjectFromResponse(Jelo jelo) throws SQLException {
        jelo.setJeloId(rs.getInt("jelo_id"));
        jelo.setKuharId(rs.getInt("kuhar_id"));
        jelo.setImeJela(rs.getString("ime_jela"));
        jelo.setKuhinjaId(rs.getInt("kuhinja_id"));
        jelo.setVrstaJelaId(rs.getInt("vrsta_jela_id"));
        jelo.setTezinaPripreme(rs.getString("tezina_pripreme"));
        jelo.setTrajanjePripreme(rs.getString("trajanje_pripreme"));
        jelo.setBrojOsoba(rs.getInt("broj_osoba"));
        jelo.setOpisJela(rs.getString("opis_jela"));
    }
}
