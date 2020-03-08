package onlineKuharica.QueryClasses;

import onlineKuharica.Jelo;

import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class JeloSQL extends Connector {
    String sqlGetAllJelo = "SELECT * FROM `online_kuharica`.`jelo`";
    String sqlGetJelaByKuharId = "SELECT * FROM `online_kuharica`.`jelo` WHERE `jelo`.`kuhar_id` = ?";
    String sqlGetJeloByKuhinjaId = "SELECT * FROM `online_kuharica`.`jelo` WHERE `jelo`.`kuhinja_id` = ?";
    String sqlGetJeloByTezinaPripreme = "SELECT * FROM `online_kuharica`.`jelo` WHERE `jelo`.`tezina_pripreme` = ?";
    String sqlDeleteJeloById = "DELETE FROM `online_kuharica`.`jelo` WHERE `jelo`.`jelo_id` = ?";
    String sqlAddJelo = "INSERT INTO `online_kuharica`.`jelo` (`jelo_id`, `kuhar_id`, `ime_jela`, `kuhinja_id`, `vrsta_jela_id`, `tezina_pripreme`, `trajanje_pripreme`, `broj_osoba`, `opis_jela`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String sqlGetJeloByNameAndKuharId = "SELECT * FROM `online_kuharica`.`jelo` WHERE `jelo`.`kuhar_id` = ? AND `jelo`.`ime_jela` = ?";

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
     * Dodaj jelo u bazu
     * @param jelo
     */
    public void addJeloDB(Jelo jelo){
        connectToDatabase();
        try {
            prpStmt = conn.prepareStatement(sqlAddJelo);
            prpStmt.setNull(1, Types.INTEGER);
            prpStmt.setInt(2, jelo.getKuharId());
            prpStmt.setString(3, jelo.getImeJela());
            prpStmt.setInt(4, jelo.getKuhinjaId());
            prpStmt.setInt(5, jelo.getVrstaJelaId());
            prpStmt.setString(6, jelo.getTezinaPripreme());
            prpStmt.setString(7, jelo.getTrajanjePripreme());
            prpStmt.setInt(8, jelo.getBrojOsoba());
            prpStmt.setString(9, jelo.getOpisJela());
            prpStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Dohvati jelo iz baze po imenu i kuhar id-u
     * @param imeJela - ime jela koje se dohavata
     * @param kuharId - kuhar id koji je dodao/napisao recept za jelo
     * @return - jelo
     */
    public Jelo getJeloByNameAndKuharIdDB(String imeJela, Integer kuharId){
        Jelo jelo = new Jelo();
        connectToDatabase();
        try {
            prpStmt = conn.prepareStatement(sqlGetJeloByNameAndKuharId);
            prpStmt.setInt(1, kuharId);
            prpStmt.setString(2, imeJela);
            rs = prpStmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                setJeloObjectFromResponse(jelo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        closeConnectionSQL();
        return jelo;
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
