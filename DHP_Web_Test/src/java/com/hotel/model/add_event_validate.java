
package com.hotel.model;

public class add_event_validate {
    

    public add_event_validate() {
        
        
    }
    
    private static String full_dateS = "";
    private static String full_dateT = "";
        
    
    public static String validate(String dateF, String dateT, String comment, String price, String desc,
                            String name, String facility, String event){
       String msg = "";
        
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
            setFull_dateS("");
            setFull_dateT("");
        } catch (IndexOutOfBoundsException ex){
            ex.printStackTrace();
            System.out.println(ex.toString());
            System.out.println("FAILED TO GET 'dateF' OR 'dateT' OR BOTH!!!!");
            msg += "- date is incorrect<br>";
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
                    price = "0";
                    numbersIsAllDigits = false;
                    break;
                }
            }
        }else{
            numbersIsAllDigits = false;
            System.out.println("put a price");
            msg += "- put a price<br>";
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
    
}
