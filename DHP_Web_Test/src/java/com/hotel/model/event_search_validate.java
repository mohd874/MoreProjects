
package com.hotel.model;

import java.util.Calendar;
import java.util.Date;

public class event_search_validate {
    
    
    public event_search_validate() {
        
        
        
    }
    
    public String create_search_query(String dateS ,String dateT, String minP,String maxP,
            String c_name,String typeF,String typeE){
        
        String full_dateS = "";
        String full_dateT = "";
        int count = 0;
        //dates
        try {
            //getting dateS
            System.out.println("class:" + dateS);
            int a_day, a_month, a_year;
            a_day = Integer.parseInt(dateS.substring(3,5));
            //System.out.println("the day is: "+a_day);
            a_month = Integer.parseInt(dateS.substring(0,2));
            //System.out.println("The month is :"+a_month);
            a_year = Integer.parseInt(dateS.substring(6,10));
            //System.out.println("The year is : "+a_year);
            
            full_dateS = a_year+"/"+a_month+"/"+a_day;
            
            System.out.println("class:" + dateS);
            
            int b_day, b_month, b_year;
            b_day = Integer.parseInt(dateT.substring(3,5));
            //System.out.println("the day is: "+a_day);
            b_month = Integer.parseInt(dateT.substring(0,2));
            //System.out.println("The month is :"+a_month);
            b_year = Integer.parseInt(dateT.substring(6,10));
            //System.out.println("The year is : "+a_year);
            
            full_dateT = b_year+"/"+b_month+"/"+b_day;
            
            count++;
            
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            System.out.println(ex.toString());
            System.out.println("FAILED TO GET 'dateF' OR 'dateT' OR BOTH!!!!");
            full_dateS = "";
            full_dateT = "";
        } catch (IndexOutOfBoundsException ex){
            ex.printStackTrace();
            System.out.println(ex.toString());
            System.out.println("FAILED TO GET 'dateF' OR 'dateT' OR BOTH!!!!");
            full_dateS = "";
            full_dateT = "";
        }
        
        //prices
        
        boolean numbersIsAllDigits = true;
        
        String current_number ;
        if(!minP.equalsIgnoreCase("")){
            for(int i=0; i<minP.length() ; i++){
                try {
                    
                    current_number = minP.substring(i,i+1);
                    System.out.println(current_number);
                    Integer.parseInt(current_number);
                    
                } catch(NumberFormatException nfe) {
                    System.out.println("minP is not fully digits");
                    minP = "0";
                    numbersIsAllDigits = false;
                    break;
                }
            }
        }else{
            numbersIsAllDigits = false;
        }
        
        if(!maxP.equalsIgnoreCase("")){
            for(int i=0; i<maxP.length() ; i++){
                try {
                    
                    current_number = maxP.substring(i,i+1);
                    System.out.println(current_number);
                    Integer.parseInt(current_number);
                    
                } catch(NumberFormatException nfe) {
                    System.out.println("maxP is not fully digits");
                    maxP = "0";
                    numbersIsAllDigits = false;
                    break;
                }
            }
        }else{
            numbersIsAllDigits = false;
        }
        
        
        if(numbersIsAllDigits = true){
            count++;
        }
        
        
        String query = "select * from event_schedule ";
        if(count > 0 ){
            query +=  "where ";
            
            if(numbersIsAllDigits = true || !maxP.equalsIgnoreCase("") && !minP.equalsIgnoreCase("")){
                query += "total_price between '"+ minP +"' and '"+ maxP +"' ";
            }
            
            if(!full_dateS.equalsIgnoreCase("") && !full_dateT.equalsIgnoreCase("")){
                query += "and date_from between '"+ full_dateS +"' and '"+ full_dateT +"' ";
            }
        }
        
        
        System.out.println(query);
        return query;
    }
    
    
    
    
    
}
