package com.me.da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLHelper {
//    private String driver = "com.mysql.jdbc.Driver";
//    private String strFile = "attendeesdb.mdb";
    private String connectionString = "";

    public MySQLHelper() { //throws ClassNotFoundException
        //not needed in JDBC 4.0
        //Class.forName(driver);

        //form a connection string using driver specific syntax and the db file
        connectionString = "jdbc:mysql://localhost:3306/attendeesdb";
    }

    public Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(connectionString, "root", "123");
        return conn;
    }

    public static void main(String[] args) {
        try {
            MySQLHelper jh = new MySQLHelper();
            Connection conn = jh.getConnection();
            System.out.println("Got Connection Successfully.");
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }
}
