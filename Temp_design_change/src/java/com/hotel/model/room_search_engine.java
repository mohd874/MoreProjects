
package com.hotel.model;

/*
 * - room_search_engine.java
 * - Author: Mohammed Omar --- mohd874@hotmail.com
 * - Priject: Hotel Reservation & Account Managment System for Daffodiles Palace Hotel
 * - Date: 06-06-2006
 * - Purpose: used to create and apply sql statments accoding to the user input
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

public class room_search_engine {
    
    
    public room_search_engine() {
        
    }
    
    private static ResultSet res; //to get sql statment result
    private static Result result; //to get sql statment result, this will be sent to the customer
    private static String price; //I don't remember
    
    public static String room_search(String roomT, String roomV, String price1, String price2, String date_arrival, String date_depart){
        
        //preparing values
        String msg = "";
        
        System.out.println("the received values are: "+roomT+" ' "+roomV+" ' "+price1+" ' "+price2);
        
        
        //--------validatiing prices----------
        
        /* this will validate the price values */
        
        //----price1----
        boolean numbersIsAllDigits = true;
        if(!price1.equalsIgnoreCase("")){
            for(int i=0; i<price1.length() ; i++){
                try {
                    
                    String current_number = price1.substring(i,i+1);
                    System.out.println(current_number);
                    Integer.parseInt(current_number);
                    
                } catch(NumberFormatException nfe) {
                    numbersIsAllDigits = false;
                    price1 = "0";
                    break;
                }
            }
        } else{
            price1 = "0";
        }
        //----price2----
        
        if(!price2.equalsIgnoreCase("")){
            for(int i=0; i<price2.length() ; i++){
                try {
                    
                    String current_number = price2.substring(i,i+1);
                    System.out.println(current_number);
                    Integer.parseInt(current_number);
                    
                } catch(NumberFormatException nfe) {
                    numbersIsAllDigits = false;
                    price2 = "9999999999999999";
                    break;
                }
            }
        } else{
            price2 = "9999999999999999";
        }
        
        //--------(END)validatiing prices----------
        
        //Creating SQL query and get the results
        
        //if the prices are not digits
        if(numbersIsAllDigits == false){
            msg += "please put correct values!!";
        } 
        //if the prices are OK
        else{
            try {
                
                //open database connection
                DB_Control.Open_DB_Connection();
                
                //prepare SQL queries
                String sql_query = "select room_id, room_type, room_view, room_price from rooms ";
                sql_query += "where ";
                
                if(!roomT.equalsIgnoreCase("*")){
                    sql_query += "room_type = '"+roomT+"' and ";
                }
                
                if(!roomV.equalsIgnoreCase("*")){
                    sql_query += "room_view = '"+roomV+"' and ";
                }
                
                if(numbersIsAllDigits == true){
                    sql_query += " room_price between ";
                    sql_query += " ' "+price1+" ' and ' "+price2+" ' and ";
                }
                
                sql_query += "room_id not in (select room_id from customer_reservation where ";
                sql_query += "arrival_date between '"+ date_arrival +"' and '"+ date_depart +"' or " +
                        "depart_date between '"+ date_arrival +"' and '"+ date_depart +"' or " +
                        "'"+ date_arrival +"' between arrival_date and depart_date or " +
                        "'"+date_depart +"' between arrival_date and depart_date)";
                System.out.println(sql_query);
                
                //apply the SQL statment and put it in Result object
                setResult(ResultSupport.toResult(DB_Control.execute_sql_query(sql_query)));
                res = DB_Control.execute_sql_query(sql_query);
                
                //create message if no data found
                if(getRes().next() == false){
                    msg += "no data found";
                }
                
                //view the result
                while(res.next()){
                    System.out.println("Room Type: "+res.getString("room_type"));
                    System.out.println("Room View: "+res.getString("room_view"));
                    System.out.println("Room Price: "+res.getString("room_price"));
                    setPrice(res.getString("room_price"));
                }
                
                
            } catch (SQLException ex) {
                System.out.println(ex.toString());
                msg += "error in sql statement!!";
            } catch (NullPointerException npe){
                System.out.println(npe.toString());
            }
            
        }
        
        //close the connection
        DB_Control.closeConnection();
        return msg;
    }
    
    public static ResultSet getRes() {
        return res;
    }
    
    public static void setRes(ResultSet aRes) {
        res = aRes;
    }
    
    public static Result getResult() {
        return result;
    }
    
    public static void setResult(Result aResult) {
        result = aResult;
    }
    
    public static String getPrice() {
        return price;
    }
    
    public static void setPrice(String aPrice) {
        price = aPrice;
    }
    
    
}
