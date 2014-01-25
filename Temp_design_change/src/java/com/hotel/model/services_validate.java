
package com.hotel.model;

/*
 * - services_validate.java
 * - Author: Mohammed Omar --- mohd874@hotmail.com
 * - Priject: Hotel Reservation & Account Managment System for Daffodiles Palace Hotel
 * - Date: 06-06-2006
 * - Purpose: used to validate values that are coming from customer services page
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

public class services_validate {
    
    
    public services_validate() {
        
    }
    private String fullDate; //the date entered by the user, will be used in the sql qeury
    private Hashtable ht = new Hashtable(); //used to store error messages
    
    public String validate(String service_id, String date, String hours, String minuts, String[] selectedRooms){
        String msg = "";
        
        //reseting value
        getHt().put("service_id","");
        getHt().put("date","");
        getHt().put("hours","");
        getHt().put("minuts","");
        getHt().put("selectedRooms","");
        getHt().put("sql","");
        
        
        //validate service_id, selectedRooms
        if(service_id.equalsIgnoreCase("")){
            msg += "choose a service<br>";
            getHt().put("service_id","<br>choose a serivce");
        }
        
        try {
            if(selectedRooms.length <= 0){
                msg += "select a room to serve<br>";
                getHt().put("selectedRooms","select a room to serve");
            }
        } catch(NullPointerException npe) {
            msg += "select a room to serve<br>";
            getHt().put("selectedRooms","select a room to serve");
        }
        //(END)validate service_id, selectedRooms
        
        
        
        
        //validate date
        Date d;
        if(!date.equalsIgnoreCase("")){
            try {
                int a_day, a_month, a_year;
                a_day = Integer.parseInt(date.substring(3,5));
                //System.out.println("the day is: "+a_day);
                a_month = Integer.parseInt(date.substring(0,2));
                //System.out.println("The month is :"+a_month);
                a_year = Integer.parseInt(date.substring(6,10));
                //System.out.println("The year is : "+a_year);
                
                setFullDate(date.substring(6,10)+"/"+date.substring(0,2)+"-"+date.substring(3,5));
                
                Calendar c = Calendar.getInstance();
                c.set(a_year,(a_month-1),a_day);
                
                System.out.println(c.toString());
                
                d = c.getTime();
                Date current = new Date();
                
                System.out.println(c.toString());
                System.out.println(d.toString());
                System.out.println(current.toString());
                
                if(d.before(current)){
                    msg += "date cannot be before TODAY date<br>";
                    getHt().put("date","<br>date cannot be before TODAY date");
                }
                
                //validate if the order is in the reservation time
                DB_Control.Open_DB_Connection();
                String sql_query = "";
                SimpleDateFormat sdf = new SimpleDateFormat();
                sdf.applyPattern("yyyy-MM-dd");
                ResultSet res;
                String room_number = "no number";
                int false_count = 0;
                
                try{
                    for(int i=0; i<selectedRooms.length; i++){
                        
                        try {
                            
                            //getting room number
                            sql_query = "select room_number from rooms where room_id = (select room_id from customer_reservation where reservation_id = "+ selectedRooms[i] +")";
                            System.out.println("the sql query to get room#: "+sql_query);
                            
                            res = DB_Control.execute_sql_query(sql_query);
                            if(res.next()){
                                room_number = res.getString("room_number");
                            }
                            
                            
                            //checking the date
                            sql_query = "select arrival_date, depart_date from customer_reservation, rooms where '"+sdf.format(d)+"' " +
                                    "between arrival_date and depart_date and customer_reservation.room_id = rooms.room_id and reservation_id = "+ selectedRooms[i] +"";
                            
                            System.out.println("sql query for validating service date: "+sql_query);
                            
                            res = DB_Control.execute_sql_query(sql_query);
                            
                            if(!res.next()){
                                //if the result is null
                                msg += "the date you have choosen is not in the reservation period of room #: "+room_number;
                                getHt().put("date","<br>the date you have choosen is not in the reservation period of room #: "+room_number);
                                false_count++;
                            }
                            
                        } catch (SQLException ex) {
                            msg += "error while fetching data from dhp_db_test database using: "+sql_query;
                            getHt().put("sql","<br>error while fetching data from database!");
                            ex.printStackTrace();
                        }
                        
                    }
                    System.out.println("the number of falses: "+false_count);
                    DB_Control.closeConnection();
                }catch(NullPointerException npe){
                    msg += "no room were choosen";
                    npe.printStackTrace();
                }
                //(END)validate if the order is in the reservation time
                
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                msg += "invalid date<br>";
            } catch (StringIndexOutOfBoundsException ex){
                ex.printStackTrace();
                msg += "invalid date<br>";
            }
            
        }else{
            msg += "choose a date<br>";
        }
        //(END)validate date

        //validate hours, minuts
        try {
            int testH = Integer.parseInt(hours);
            if(testH > 24 || testH < 0){
                msg += "the hour should be less than 24 and more than zero<br>";
                getHt().put("hours","<br>the hour should be less than 24 and more than zero");
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            msg += "invalid hour<br>";
            getHt().put("hours","<br>invalid hour");
        }
        
        
        try {
            int testM = Integer.parseInt(minuts);
            if(testM > 59 || testM < 0){
                msg += "the minuts should be less than 59 and more than zero<br>";
                getHt().put("minuts","<br>the minuts should be less than 59 and more than zero");
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            msg += "invalid minuts<br>";
            getHt().put("minuts","<br>invalid minuts");
        }
        //(END)validate hours, minuts
        
        
        
        return msg;
    }
    
    public String getFullDate() {
        return fullDate;
    }
    
    public void setFullDate(String fullDate) {
        this.fullDate = fullDate;
    }

    public Hashtable getHt() {
        return ht;
    }

    public void setHt(Hashtable ht) {
        this.ht = ht;
    }
}
