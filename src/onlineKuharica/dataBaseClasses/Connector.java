package onlineKuharica.dataBaseClasses;

import java.sql.*;
public class Connector {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/?autoReconnect=true&useSSL=false";

    private static final String USER = "root";
    private static final String PASS = "admin";
    protected static Connection conn = null;
    protected static Statement stmt = null;
    protected static ResultSet rs = null;
    protected static PreparedStatement prpStmt = null;

    public static void connectToDatabase()
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    public static void closeConnectionSQL() {
        try {
            stmt.close();
            conn.close();
            prpStmt.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (prpStmt != null) {
                    prpStmt.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
