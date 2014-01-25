
package com.hotel.model;

import java.util.Hashtable;
import java.util.Calendar;
import java.util.Date;


public class reservation_validation {
    
    
    public reservation_validation() {
    }
    
    private static Hashtable ht = new Hashtable();
    private static String full_arrival_date;
    private static String full_departure_date;
    
    public static String validat_information(String date_arrival, String date_departure, String flight, String credit_card_no, String credit_card_type,
            int expiry_month, int expiry_year, char confirmation){
        String all_ok = "";
        /*
        getHt().put("ard","");
        getHt().put("dpd","");
        getHt().put("ccn","");
        getHt().put("cct","");
        getHt().put("expm","");
        getHt().put("expy","");
        getHt().put("cfm","");
        */
        try{
            //getting arrival date
            int a_day, a_month, a_year;
            a_day = Integer.parseInt(date_arrival.substring(3,5));
            //System.out.println("the day is: "+a_day);
            a_month = Integer.parseInt(date_arrival.substring(0,2));
            //System.out.println("The month is :"+a_month);
            a_year = Integer.parseInt(date_arrival.substring(6,10));
            //System.out.println("The year is : "+a_year);
            
            
            Calendar c = Calendar.getInstance();
            c.set(a_year,a_month,a_day);
            
            Date ard = c.getTime();
            System.out.println(ard.toString());
            
            setFull_arrival_date(a_year+"/"+a_month+"/"+a_day);
            
            //getting departure date
            int d_day, d_month, d_year;
            d_day = Integer.parseInt(date_departure.substring(3,5));
            //System.out.println("the day is: "+d_day);
            d_month = Integer.parseInt(date_departure.substring(0,2));
            //System.out.println("The month is :"+d_month);
            d_year = Integer.parseInt(date_departure.substring(6,10));
            //System.out.println("The year is : "+d_year);
            
            setFull_departure_date(d_year+"/"+d_month+"/"+d_day);
            
            c.set(d_year,d_month,d_day);
            
            Date dpd = c.getTime();
            System.out.println(dpd.toString());
            
            Date current_date = new Date();
            if(ard.before(current_date)){
                all_ok += ", arrive befor current\n";
                getHt().put("ard","Arrival date cannot be before the current date!!");
            }
            if(dpd.before(ard)){
                all_ok += ", depart befor arrive\n";
                getHt().put("dpd","Departure date cannot be before Arrival date!!");
            }
            
            //credit card #
            
            double a = Double.parseDouble(credit_card_no);
            
            boolean numbersIsAllDigits = true;
            
            for(int i=0; i<credit_card_no.length() ; i++){
                try {
                    
                    String current_number = credit_card_no.substring(i,i+1);
                    System.out.println(current_number);
                    Integer.parseInt(current_number);
                    
                } catch(NumberFormatException nfe) {
                    numbersIsAllDigits = false;
                    break;
                }
            }
            
            
            if(credit_card_no == null ){
                all_ok += "There is no credit card number";
                getHt().put("ccn","plz put the credit card number!!");
            }
            if(credit_card_no.length() < 12 ){
                all_ok += "too short credit card number";
                getHt().put("ccn","the credit card number is longer than the expected!!");
            }
            if(!numbersIsAllDigits){
                all_ok += "not all are digits";
                getHt().put("ccn","not all the credit card numbers are digits!!");
            }
            
            //credit card type
            if(!credit_card_type.equalsIgnoreCase("master_card") & !credit_card_type.equalsIgnoreCase("visa_card")
            &!credit_card_type.equalsIgnoreCase("american_experess") ){
                all_ok += ",card not found";
                getHt().put("cct","plz select a credit card");
            }
            
            //credit card month
            if(expiry_month <= 0 || expiry_month >=13){ 
                all_ok += "invalid month"; 
                getHt().put("expm","invalid month");
            }
            //credit card year
            if(expiry_year <= Calendar.YEAR) {
                all_ok += ",invalid year";
                getHt().put("expy","invalid year");
            }
            
            //confirmation
            
            
        } catch(Exception e){
            all_ok += ", "+e.toString();
        }
        
        System.out.println("here is the hashtable: "+getHt().get("ard"));
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
    
}
