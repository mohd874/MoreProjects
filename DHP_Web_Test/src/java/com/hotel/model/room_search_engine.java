
package com.hotel.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

public class room_search_engine {
    
    
    public room_search_engine() {
        
    }
    
    private static ResultSet res;
    private static Result result;
    private static String price;
    public static String room_search(String roomT, String roomV, String price1, String price2){
        
        String msg = "";
        
        
        System.out.println("the received values are: "+roomT+" ' "+roomV+" ' "+price1+" ' "+price2);
        
        //--------validatiing prices----------
        
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
         }
        else{
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
                    price2 = "0";
                    break;
                }
            }
        }
        else{
            price2 = "0";
        }
        
        
        if(numbersIsAllDigits == false){
            msg += "please put correct values!!";
        } else{
            try {
                
                DB_Control.Open_DB_Connection();
                String sql_query = "select room_id, room_type, room_view, room_price from rooms ";
                if(!roomT.equalsIgnoreCase("*") || !roomV.equalsIgnoreCase("*")){
                    sql_query += "where ";
                    
                    if(!roomT.equalsIgnoreCase("*")){
                        sql_query += "room_type = '"+roomT+"'";
                    }
                    if(!roomV.equalsIgnoreCase("*")){
                        if(!roomT.equalsIgnoreCase("*")){
                            sql_query += " and ";
                        }
                        sql_query += "room_view = '"+roomV+"'";
                    }
                    if(numbersIsAllDigits == true){
                        if(!roomT.equalsIgnoreCase("*") || !roomV.equalsIgnoreCase("*")){
                            sql_query += " and ";
                        }
                        sql_query += " room_price between ";
                        sql_query += " ' "+price1+" ' and ' "+price2+" ' ";
                    }
                    
                }
                
                
                System.out.println(sql_query);
                setResult(ResultSupport.toResult(DB_Control.execute_sql_query(sql_query)));
                res = DB_Control.execute_sql_query(sql_query);
                
                if(getRes().next() == false){
                    msg += "no data found";
                }
                
                
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
