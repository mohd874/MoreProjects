
package com.hotel.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;


public class DB_Control {
    
    static Connection con = null;
    static Statement stm = null;
    static ResultSet res = null;
    static int completeQuery = 0;
    
    public DB_Control() {
    }
    
    public static String Open_DB_Connection(){
        String msg = "";
        try {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dph_db_test", "root", "123");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            msg = "ClassNotFoundException";
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
            msg = "ClassNotFoundException";
        } catch (InstantiationException ex) {
            ex.printStackTrace();
            msg = "ClassNotFoundException";
        } catch (SQLException ex) {
            ex.printStackTrace();
            msg = "ClassNotFoundException";
        }catch(NullPointerException npe){
            msg += "NullPonitException";
        }
        
        
        return msg;
    }
    
    public static ResultSet execute_sql_query(String query) throws SQLException {
       
        try {
            
            stm = con.createStatement();
            res = stm.executeQuery(query);
            
            //while(res.next()){
              //  System.out.println(res.getString("user_name"));
            //}
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NullPointerException npe){
            npe.printStackTrace();
        }
        
        return res;
    }
    
    public static int update_database(String query) throws SQLException {
       
        try {
            
            stm = con.createStatement();
            completeQuery = stm.executeUpdate(query);
            
            //while(res.next()){
              //  System.out.println(res.getString("user_name"));
            //}
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            
            completeQuery = -1;
        } catch (NullPointerException npe){
            completeQuery = -1;
        }
        
        return completeQuery;
    }
    
    
    public static void closeConnection(){
        try {
            if(con != null){
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
