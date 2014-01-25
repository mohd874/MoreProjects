
package com.hotel.model;

import java.util.Calendar;
import java.util.Date;

public class services_validate {
    
    
    public services_validate() {
        
    }
    private String fullDate;
    
    public String validate(String service_id, String date, String hours, String minuts, String[] selectedRooms){
        String msg = "";
        
        //validate service_id, selectedRooms
        
        if(service_id.equalsIgnoreCase("")){
            msg += "choose a service<br>";
        }
        
        try {
            if(selectedRooms.length <= 0){
                msg += "select a room to serve<br>";
            }
        } catch(NullPointerException npe) {
            msg += "select a room to serve<br>";
        }
        //(END)validate service_id, selectedRooms
        
        
        
        
        //validate date
        if(!date.equalsIgnoreCase("")){
            try {
                int a_day, a_month, a_year;
                a_day = Integer.parseInt(date.substring(3,5));
                //System.out.println("the day is: "+a_day);
                a_month = Integer.parseInt(date.substring(0,2));
                //System.out.println("The month is :"+a_month);
                a_year = Integer.parseInt(date.substring(6,10));
                //System.out.println("The year is : "+a_year);
                
                setFullDate(a_year+"/"+a_month+"/"+a_day);
                
                Calendar c = Calendar.getInstance();
                c.set(a_year,a_month,a_day);
                
                System.out.println(c.toString());
                
                Date d = c.getTime();
                Date current = new Date();
                
                System.out.println(c.toString());
                System.out.println(d.toString());
                System.out.println(current.toString());
                
                if(d.before(current)){
                    msg += "date cannot be before TODAY date<br>";
                }
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
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            msg += "invalid hour<br>";
        }
        
        
        try {            
            int testM = Integer.parseInt(minuts);
            if(testM > 59 || testM < 0){
                msg += "the minuts should be less than 59 and more than zero<br>";
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            msg += "invalid minuts<br>";
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
}
