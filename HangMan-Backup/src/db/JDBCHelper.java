/*
 * JDBCHelper.java
 *
 * Created on May 21, 2007, 4:55 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package db;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author S200200874
 */
public class JDBCHelper {
    private String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
    private  String strFile = "hangman.mdb";
    private String connectionString = "";
    
    /** Creates a new instance of JDBCHelper */
    public JDBCHelper() throws ClassNotFoundException{
        Class.forName(driver);
        
        URL url = getClass().getResource(strFile);
        
        File file = new File(url.getFile());
        
        String dbFile = file.getAbsolutePath().replace("%20"," ");
        
        connectionString = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+dbFile;
    }
    
    public Connection getConnection() throws SQLException{
        Connection conn = DriverManager.getConnection(connectionString,"","");
        return conn;
    }
    
    public static void main(String[] args) {
        try {
        
            JDBCHelper jh = new JDBCHelper();
            System.out.println("Driver loaded");
            Connection conn = jh.getConnection();
        } catch (ClassNotFoundException ex) {
            System.out.println("Could not load the MS Access Driver. Exception message: "+ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
