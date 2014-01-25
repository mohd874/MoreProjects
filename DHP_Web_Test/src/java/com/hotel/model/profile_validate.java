
package com.hotel.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class profile_validate {
    
    
    public profile_validate() {
    }
    
    public String validate(String user_id, String name, String sur_name, String old_pass, String new_pass, String con_pass,
            String title, String phone, String mobile, String address, String email){
        String msg = "";
        
        //validating name, sur_name, title
        if(name.equalsIgnoreCase("")){
            msg += "name is missing!!<br>";
        }
        if(sur_name.equalsIgnoreCase("")){
            msg += "sur_name is missing!!<br>";
        }
        if(title.equalsIgnoreCase("")){
            msg += "title is missing!!<br>";
        }
        if(address.equalsIgnoreCase("")){
            msg += "address is missing!!<br>";
        }
        //(END)validating name, sur_name, title
        
        
        //validating password
        ResultSet res = DB_Control.execute_sql_query("select password from sysuser where user_id = "+ user_id);
        String pass = "";
        try {
            res.next();
            pass = res.getString("password");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        if(!old_pass.equalsIgnoreCase("")){
            if(old_pass.equalsIgnoreCase(pass)){
                if(!new_pass.equalsIgnoreCase("")){
                    if(!new_pass.equalsIgnoreCase(old_pass))
                        if(!con_pass.equalsIgnoreCase(new_pass)){
                        msg += "passwords are not match<br>";
                        }
                }else{
                    msg += "put a password to change<br>";
                }
            }else{
                msg += "the new password must not match the old password<br>";
            }
        }else{
            msg += "the old password is incorrect<br>";
        }
        
        
        //(ENDvalidating password
        
        
        //validating phone, mobile
        String current_number;
        
        for(int i=0; i<phone.length(); i++){
            try {
                current_number = phone.substring(i,i+1);
                System.out.println(current_number);
                Integer.parseInt(current_number);
                
            } catch(NumberFormatException nfe) {
                msg += "phone number is not fully digits!! <br>";
                break;
            }
        }
        
        
        for(int i=0; i<mobile.length(); i++){
            try {
                current_number = mobile.substring(i,i+1);
                System.out.println(current_number);
                Integer.parseInt(current_number);
                
            } catch(NumberFormatException nfe) {
                msg += "mobile number is not fully digits!! <br>";
                break;
            }
        }
        //(END)validating phone, mobile
        
        
        //validating email
        try {
            if(!email.equalsIgnoreCase("") || !email.equalsIgnoreCase(null)){
                if(email.indexOf("@") == -1 || email.indexOf(".") == -1){
                    msg += "put a valide email!! <br>";
                }
                
            }else{
                msg += "put a valide email!! <br>";
            }
        } catch (NullPointerException ex){
            System.out.println("null exeption in validating email <br>");
        }
        //(END)validating email
        
        return msg;
    }
}

