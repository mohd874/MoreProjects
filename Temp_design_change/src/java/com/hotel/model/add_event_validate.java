
package com.hotel.model;

import java.util.Hashtable;

public class add_event_validate {
    
    
    public add_event_validate() {
        
    }
    
    private static String full_dateS = "";
    private static String full_dateT = "";
    private static Hashtable ht = new Hashtable();
    private static special_charectars_validation_class scvc = new special_charectars_validation_class();
    
    public static String validate(String dateF, String dateT, String comment, String price, String desc,
            String name, String facility, String event, String home_show){
        
        //prepare and reset valiues
        String msg = "";
        getHt().put("dateF","");
        getHt().put("dateT","");
        getHt().put("comment","");
        getHt().put("price","");
        getHt().put("desc","");
        getHt().put("name","");
        getHt().put("facility","");
        getHt().put("event","");
        getHt().put("home_show","");
        
        //validate dates
        int count = 0;
        
        try {
            //getting dateS
            System.out.println("class:" + dateF);
            int a_day, a_month, a_year;
            a_day = Integer.parseInt(dateF.substring(3,5));
            //System.out.println("the day is: "+a_day);
            a_month = Integer.parseInt(dateF.substring(0,2));
            //System.out.println("The month is :"+a_month);
            a_year = Integer.parseInt(dateF.substring(6,10));
            //System.out.println("The year is : "+a_year);
            
            setFull_dateS(a_year+"/"+a_month+"/"+a_day);
            
            System.out.println("class:" + dateF);
            
            int b_day, b_month, b_year;
            b_day = Integer.parseInt(dateT.substring(3,5));
            //System.out.println("the day is: "+a_day);
            b_month = Integer.parseInt(dateT.substring(0,2));
            //System.out.println("The month is :"+a_month);
            b_year = Integer.parseInt(dateT.substring(6,10));
            //System.out.println("The year is : "+a_year);
            
            setFull_dateT(b_year+"/"+b_month+"/"+b_day);
            
            count++;
            
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            System.out.println(ex.toString());
            System.out.println("FAILED TO GET 'dateF' OR 'dateT' OR BOTH!!!!");
            msg += "- date is incorrect<br>";
            getHt().put("dateF","Either \"Date from\" or \"Date to\" is incorrect!");
            setFull_dateS("");
            setFull_dateT("");
        } catch (IndexOutOfBoundsException ex){
            ex.printStackTrace();
            System.out.println(ex.toString());
            System.out.println("FAILED TO GET 'dateF' OR 'dateT' OR BOTH!!!!");
            msg += "- date is incorrect<br>";
            getHt().put("dateF","Either \"Date from\" or \"Date to\" is incorrect!");
            setFull_dateS("");
            setFull_dateT("");
        }
        
        
        //validate price
        
        boolean numbersIsAllDigits = true;
        
        String current_number ;
        if(!price.equalsIgnoreCase("")){
            for(int i=0; i<price.length() ; i++){
                try {
                    
                    current_number = price.substring(i,i+1);
                    System.out.println(current_number);
                    Integer.parseInt(current_number);
                    
                } catch(NumberFormatException nfe) {
                    System.out.println("price is not fully digits");
                    msg += "- price is not fully digits<br>";
                    getHt().put("price","Price is not fully digits");
                    price = "0";
                    numbersIsAllDigits = false;
                    break;
                }
            }
        }else{
            numbersIsAllDigits = false;
            System.out.println("put a Price");
            msg += "- put a price<br>";
            getHt().put("price","put a Price");
        }
        
        
        //validating commment, desc, name, facility, event against special characters
        if(scvc.validate(comment) == false){
            msg += "comment have special character!<br>";
            ht.put("comment","<br>"+scvc.getMsg());
        }
        
        if(scvc.validate(desc) == false){
            msg += "desc have special character!<br>";
            ht.put("desc","<br>"+scvc.getMsg());
        }
        
        if(scvc.validate(name) == false){
            msg += "name have special character!<br>";
            ht.put("name","<br>"+scvc.getMsg());
        }
        
        if(scvc.validate(facility) == false){
            msg += "facility have special character!<br>";
            ht.put("facility","<br>"+scvc.getMsg());
        }
        
        if(scvc.validate(event) == false){
            msg += "event have special character!<br>";
            ht.put("event","<br>"+scvc.getMsg());
        }
        
        if(scvc.validate(home_show) == false){
            msg += "your choice have special character!<br>";
            ht.put("home_show","<br>"+scvc.getMsg());
        }
        
        //validating customer, facility, event
        if(name.equalsIgnoreCase("")){
            msg += "choose a customer!";
            ht.put("name","<br>Choose a customer");
        }
        
        if(facility.equalsIgnoreCase("")){
            msg += "choose a facility!";
            ht.put("facility","<br>Choose a facility");
        }
        
        if(event.equalsIgnoreCase("")){
            msg += "choose an event!";
            ht.put("event","<br>Choose an event");
        }
        
        
        
        return msg;
    }
    
    public static String getFull_dateS() {
        return full_dateS;
    }
    
    public static void setFull_dateS(String aFull_dateS) {
        full_dateS = aFull_dateS;
    }
    
    public static String getFull_dateT() {
        return full_dateT;
    }
    
    public static void setFull_dateT(String aFull_dateT) {
        full_dateT = aFull_dateT;
    }
    
    public static Hashtable getHt() {
        return ht;
    }
    
    public static void setHt(Hashtable aHt) {
        ht = aHt;
    }
    
}
