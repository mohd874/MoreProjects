
package com.hotel.model;

/*
 * - reservation_validation.java
 * - Author: Mohammed Omar --- mohd874@hotmail.com
 * - Priject: Hotel Reservation & Account Managment System for Daffodiles Palace Hotel
 * - Date: 06-06-2006
 * - Purpose: validate the input value that was recieved from reservation page
 */

import java.text.DecimalFormat;
import java.util.Hashtable;
import java.util.Calendar;
import java.util.Date;


public class reservation_validation {
    
    
    public reservation_validation() {
    }
    
    private static Hashtable ht = new Hashtable(); //to store error messages
    private static String full_arrival_date;
    private static String full_departure_date;
    private static String cct; //credit card type
    
    public static String validat_information(String date_arrival, String date_departure, String flight, String credit_card_no, String credit_card_type,
            String expiry_month, String expiry_year, char confirmation){
        String all_ok = "";
        
        //reset values
        getHt().put("ard","");
        getHt().put("dpd","");
        getHt().put("ccn","");
        getHt().put("cct","");
        getHt().put("expm","");
        getHt().put("expy","");
        getHt().put("cfm","");
        
        
        try{
            
            //getting arrival date
            int a_day, a_month, a_year;
            a_day = Integer.parseInt(date_arrival.substring(3,5));
            //System.out.println("the day is: "+a_day);
            a_month = Integer.parseInt(date_arrival.substring(0,2));
            //System.out.println("The month is :"+a_month);
            a_year = Integer.parseInt(date_arrival.substring(6,10));
            //System.out.println("The year is : "+a_year);
            
            //create Calendar Object
            Calendar c = Calendar.getInstance();
            
            //put the arrival date into the Calendar object
            c.set(a_year,(a_month-1), a_day) ;
            
            //create Date object from Calendar object(for comparing arrival date and depart date)
            Date ard = c.getTime();
            System.out.println(ard.toString());
            
            //put arrival date as string according to MySQL database format "yyyy-MM-dd"
            setFull_arrival_date(date_arrival.substring(6,10)+"-"+date_arrival.substring(0,2)+"-"+ date_arrival.substring(3,5));
            System.out.println("format test: "+getFull_arrival_date());
            
            
            //getting departure date
            int d_day, d_month, d_year;
            d_day = Integer.parseInt(date_departure.substring(3,5));
            //System.out.println("the day is: "+d_day);
            d_month = Integer.parseInt(date_departure.substring(0,2));
            //System.out.println("The month is :"+d_month);
            d_year = Integer.parseInt(date_departure.substring(6,10));
            //System.out.println("The year is : "+d_year);
            
            //put depart date as string according to MySQL database format "yyyy-MM-dd"
            setFull_departure_date(date_departure.substring(6,10)+"-"+date_departure.substring(0,2)+"-"+date_departure.substring(3,5));
            
            //put depart date into the Calendar object
            c.set(d_year,(d_month-1),d_day);
            
            //create Date object from Calendar object(for comparing arrival date and depart date)
            Date dpd = c.getTime();
            System.out.println(dpd.toString());
            
            //create Date object that represent the current date(for comparing)
            Date current_date = Calendar.getInstance().getTime();
            
            /*
            System.out.println("current: "+current_date.toString());
            System.out.println("ard: "+ard.toString());
            System.out.println("current: "+ (current_date.getTime()/(1000*60*60*24)) );
            System.out.println("ard: "+(ard.getTime()/(1000*60*60*24)) );
            */
            
            //validating the date difference (arrival date must be after the current date)
            if(ard.before(current_date)){
                all_ok += ", arrive befor current\n";
                getHt().put("ard","<br>Arrival date cannot be before the current date!!");
            }
            
            //validating the date difference (depart date must be after the arrival date)
            if(dpd.before(ard)){
                all_ok += ", depart befor arrive\n";
                getHt().put("dpd","<br>Departure date cannot be before Arrival date!!");
            }
            
            //if the difference between the arrival date and current date is less than 3 days
            int current_days = (int)(current_date.getTime() / (1000*60*60*24));
            int ard_days = (int)(ard.getTime() / (1000*60*60*24));
            int dateDiff = (int)( ard_days - current_days );
            System.out.println("the differnce between arrival_date and current_date: "+dateDiff);
            
            if(dateDiff < 3){
                if(confirmation == 'n'){
                    all_ok += ", difference between arrival and current is less than 3 days\n";
                    getHt().put("cfm","<br>Sorry you must confirm because the arrival date is near(less than 3 days from todays date)");
                }
            }
            
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("An Error happened while checking the date: "+e.toString());
            all_ok += "- invalid date<br>";
            getHt().put("ard","<br>Either Arrival Date or Depart Date is invalid!!");
        }
        
        
        //credit card # and expiary date
        //international credit card validation
        creditCardValidation ccv = new creditCardValidation();
        boolean check_OK = ccv.validateCreditCard(credit_card_no,expiry_month,expiry_year);
        
        if(check_OK == false){
            all_ok += ", "+ccv.getCCVSError();
            getHt().put("ccn",ccv.getCCVSError());
        }else{
            setCct(ccv.getCCVSType());
        }
        
        //credit card type
        /*
            try{
            if(!credit_card_type.equalsIgnoreCase("master_card") & !credit_card_type.equalsIgnoreCase("visa_card")
            &!credit_card_type.equalsIgnoreCase("american_experess") ){
                all_ok += "- select a credit card<br>";
                getHt().put("cct","plz select a credit card");
            }
        } catch(Exception e){
            e.printStackTrace();
            all_ok += "An Error happened while checking the Credit Card Type: "+e.toString()+"<br>";
        }
         */
        
        
        return all_ok;
    }
    
    public static Hashtable getHt() {
        return ht;
    }
    
    public static void setHt(Hashtable aHt) {
        ht = aHt;
    }
    
    public static String getFull_arrival_date() {
        return full_arrival_date;
    }
    
    public static void setFull_arrival_date(String aFull_arrival_date) {
        full_arrival_date = aFull_arrival_date;
    }
    
    public static String getFull_departure_date() {
        return full_departure_date;
    }
    
    public static void setFull_departure_date(String aFull_departure_date) {
        full_departure_date = aFull_departure_date;
    }

    public static String getCct() {
        return cct;
    }

    public static void setCct(String aCct) {
        cct = aCct;
    }
    
}
