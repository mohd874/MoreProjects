
package com.hotel.model;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import java.sql.SQLException;



public class reservation_validate {
    
    
    public reservation_validate() {
    }
    
    public static String search_room(String credit_card_no, String credit_card_type,
            int expiry_month, int expiry_year){
        String all_ok = "";
        
        try{
            //credit card # 
            if(credit_card_no.length() < 12) all_ok += "too long";
            
            double a = Double.parseDouble(credit_card_no); 
            
            //credit card type
            //if(!credit_card_type.equalsIgnoreCase("master_card") & !credit_card_type.equalsIgnoreCase("visa_card")
            //  &!credit_card_type.equalsIgnoreCase("american_experess") ){
            //   all_ok += "card not found";
            //}
            
            //credit card month
            if(expiry_month <= 0 || expiry_month >=13) all_ok += "invalid month";
            //credit card year
            if(expiry_year <= 2005) all_ok += "invalid year";
            
            
        }
        catch(Exception e){
            all_ok += "error";
        }
        
        return all_ok;
    }
}
