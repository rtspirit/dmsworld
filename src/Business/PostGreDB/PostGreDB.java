/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PostGreDB;

/**
 *
 * @author rtspi
 */

    
import Business.ConfigureASystem;
import Business.EcoSystem;
import com.sun.org.apache.xml.internal.security.signature.ObjectContainer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author postgresqltutorial.com
 */
public class PostGreDB{

    private final String url = "jdbc:postgresql://localhost/postgres";
    private final String user = "postgres";
    private final String password = "admin";
    private static PostGreDB postgredb;
    

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public synchronized static PostGreDB getInstance(){
        if (postgredb == null){
            postgredb = new PostGreDB();
        }
        return postgredb;
    }

    protected synchronized static void shutdown(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
    
    
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
    

    /**
     * @param args the command line arguments
     */
    
//    public static void main(String[] args) {
//        PostGreDB app = new PostGreDB();
//        app.connect();
//    }
    
}

  

