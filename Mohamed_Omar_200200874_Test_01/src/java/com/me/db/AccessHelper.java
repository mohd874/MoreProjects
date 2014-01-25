package com.me.db;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccessHelper {
    //private String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
    private String strFile = "employeesdb.mdb";
    private String connectionString = "";

    public AccessHelper() { //throws ClassNotFoundException
        //not needed in JDBC 4.0
        //Class.forName(driver);

        //get the url for the resource
        URL url = getClass().getResource(strFile);
        //create a file using the url
        File file = new File(url.getFile());
        //get the absolute path and replace URL specific characters
        //with OS specific characters
        String dbFile = file.getAbsolutePath().replace("%20", " ");
        //form a connection string using driver specific syntax and the db file
        connectionString = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + dbFile;
    }

    public Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(connectionString, "", "");
        return conn;
    }

    public static void main(String[] args) {
        try {
            AccessHelper jh = new AccessHelper();
            Connection conn = jh.getConnection();
            System.out.println("Got Connection Successfully.");
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }
}
