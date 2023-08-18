package co.com.falabella.connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConnectionDB {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String USER = "root"; 
    private static String PASSWORD = "";
    private static String DB = "dbquestions";
    private static String URL = "jdbc:mysql://localhost:3306/"+DB+"?autoReconnect=true&useSSL=false";
    
    private Connection conn;
    
    public ConnectionDB(){
        conn = null;
    }

    public static String getDB() {
        return DB;
    }

    public static void setDB(String DB) {
        ConnectionDB.DB = DB;
    }

    public static String getDRIVER() {
        return DRIVER;
    }

    public static void setDRIVER(String DRIVER) {
        ConnectionDB.DRIVER = DRIVER;
    }

    public static String getUSER() {
        return USER;
    }

    public static void setUSER(String USER) {
        ConnectionDB.USER = USER;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static void setPASSWORD(String PASSWORD) {
        ConnectionDB.PASSWORD = PASSWORD;
    }

    public static String getURL() {
        return URL;
    }

    public static void setURL(String URL) {
        ConnectionDB.URL = URL;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    public Connection getConnection(){
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar con la base de datos");
            System.exit(0);
        }
        return conn;
    }
    
    public void desconectar(){
        try {
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexion con la base de datos");
        }
    }
    
}
