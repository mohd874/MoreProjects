package com.hotel.model;

/*
 * - prifile_validate.java
 * - Author: Mohammed Omar --- mohd874@hotmail.com
 * - Priject: Hotel Reservation & Account Managment System for Daffodiles Palace Hotel
 * - Date: 06-06-2006
 * - Purpose: used to validate value that come from profile page    
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

public class profile_validate {
    
    
    public profile_validate() {
    }
    
    private Hashtable ht = new Hashtable();// TO STORE ERROR MASSAGES
    private special_charectars_validation_class scvc = new special_charectars_validation_class();// VALIDATE special charcters
    
    public String validate_customer(String user_id, String name, String sur_name, String old_pass, String new_pass, String con_pass,
            String title, String phone, String mobile, String fax, String address, String email){
        
        //prepare and reset values
        String msg = "";
        
        getHt().put("name","");
        getHt().put("sur_name","");
        getHt().put("old_pass","");
        getHt().put("new_pass","");
        getHt().put("con_pass","");
        getHt().put("title","");
        getHt().put("phone","");
        getHt().put("mobile","");
        getHt().put("fax","");
        getHt().put("address","");
        getHt().put("email","");
        
        
        //check the name, surnmae and title for empty string and special charcters
        if(name.equalsIgnoreCase("")){
            msg += "name is missing!!<br>";
            getHt().put("name","<br>name is missing!!");
        }
        
        if(scvc.validate(name) == false){
            msg += "<br>"+scvc.getMsg()+"\n";
            getHt().put("name","<br>"+scvc.getMsg());
        }
        
        if(sur_name.equalsIgnoreCase("")){
            msg += "sur_name is missing!!<br>";
            getHt().put("sur_name","<br>sur_name is missing!!");
        }
        
        if(scvc.validate(sur_name) == false){
            msg += "<br>"+scvc.getMsg()+"\n";
            getHt().put("sur_name","<br>"+scvc.getMsg());
        }
        /*
        if(title.equalsIgnoreCase("")){
            msg += "title is missing!!<br>";
            getHt().put("name","<br>title is missing!!");
        }
        */
        if(scvc.validate(title) == false){
            msg += "<br>"+scvc.getMsg()+"\n";
            getHt().put("title","<br>"+scvc.getMsg());
        }
        //(END)validating name, sur_name, title
        
        
        //validating changing password parameters
        //get the password from the database
        DB_Control.Open_DB_Connection();
        ResultSet res = null;
        try {
            res = DB_Control.execute_sql_query("select password from sysuser where user_id = " + user_id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        String pass = "";
        try {
            res.next();
            pass = res.getString("password");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        if(!old_pass.equalsIgnoreCase("")){
            if(old_pass.equals(pass)){//both old password and database password must be identecaly matched
                if(!new_pass.equalsIgnoreCase("")){
                    if(!new_pass.equalsIgnoreCase(old_pass)){
                        if(!con_pass.equals(new_pass)){
                            msg += "passwords are not match<br>";
                            getHt().put("con_pass","<br>passwords are not match!!");
                        }
                    }
                }else{
                    msg += "put a password to change<br>";
                    getHt().put("new_pass","<br>put a password to change!!");
                }
            }else{
                msg += "the old password is incorrect<br>";
                getHt().put("old_pass","<br>the old password is incorrect!!");
            }
        }else{
            //msg += "the old password is incorrect<br>";
        }
        //validate if old_password, new password and confirmed password have no special characters
        if(scvc.validate(old_pass) == false){
            msg += "<br>"+scvc.getMsg()+"\n";
            getHt().put("old_pass","<br>"+scvc.getMsg());
        }
        
        if(scvc.validate(new_pass) == false){
            msg += "<br>"+scvc.getMsg()+"\n";
            getHt().put("new_pass","<br>"+scvc.getMsg());
        }
        
        if(scvc.validate(con_pass) == false){
            msg += "<br>"+scvc.getMsg()+"\n";
            getHt().put("con_pass","<br>"+scvc.getMsg());
        }
        
        //(ENDvalidating password
        
        
        //validate if phone, mobile, fax are fully digits
        String current_number;
        
        for(int i=0; i<phone.length(); i++){
            try {
                current_number = phone.substring(i,i+1);
                System.out.println(current_number);
                Integer.parseInt(current_number);
                
            } catch(NumberFormatException nfe) {
                msg += "phone number is not fully digits!! <br>";
                getHt().put("phone","<br>phone number is not fully digits!!");
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
                getHt().put("mobile","<br>mobile number is not fully digits!!");
                break;
            }
        }
        
        
        for(int i=0; i<fax.length(); i++){
            try {
                current_number = fax.substring(i,i+1);
                System.out.println(current_number);
                Integer.parseInt(current_number);
                
            } catch(NumberFormatException nfe) {
                msg += "fax number is not fully digits!! <br>";
                getHt().put("fax","<br>fax number is not fully digits!!");
                break;
            }
        }
        //(END)validating phone, mobile, fax
        
        
        //validate if email has "@" and "." and if it has special character except "-" and "_"
        try {
            if(!email.equalsIgnoreCase("") || !email.equalsIgnoreCase(null)){
                if(email.indexOf("@") == -1 || email.indexOf(".") == -1){
                    msg += "put a valide email!! <br>";
                    getHt().put("email","<br>put a valid email!!");
                }
                
            }else{
                msg += "put a valide email!! <br>";
                getHt().put("email","<br>put a valid email!!");
            }
        } catch (NullPointerException ex){
            System.out.println("null exeption in validating email <br>");
        }
        //(END)validating email
        
        return msg;
    }
    
    public String validate_employee(String user_id, String name, String sur_name, String old_pass, String new_pass, String con_pass,
            String job_title,String marital_status, String gender, String phone, String mobile, String address,String passport, String years_of_exp){
        
        //prepare and reset values
        String msg = "";
        
        getHt().put("name","");
        getHt().put("sur_name","");
        getHt().put("old_pass","");
        getHt().put("new_pass","");
        getHt().put("con_pass","");
        getHt().put("job_title","");
        getHt().put("marital_status","");
        getHt().put("gender","");
        getHt().put("phone","");
        getHt().put("mobile","");
        getHt().put("address","");
        getHt().put("passport","");
        getHt().put("years_of_exp","");
        
        //validating name, sur_name, title
        if(name.equalsIgnoreCase("")){
            msg += "name is missing!!<br>";
            getHt().put("name","<br>name is missing!!");
        }
        if(scvc.validate(name) == false){
            msg += "<br>"+scvc.getMsg()+"\n";
            getHt().put("name","<br>"+scvc.getMsg());
        }
        
        if(sur_name.equalsIgnoreCase("")){
            msg += "sur_name is missing!!<br>";
            getHt().put("sur_name","<br>sur_name is missing!!");
        }
        if(scvc.validate(sur_name) == false){
            msg += "<br>"+scvc.getMsg()+"\n";
            getHt().put("sur_name","<br>"+scvc.getMsg());
        }
        
        if(job_title.equalsIgnoreCase("")){
            msg += "job title is missing!!<br>";
            getHt().put("job_title","<br>job title is missing!!");
        }
        if(scvc.validate(job_title) == false){
            msg += "<br>"+scvc.getMsg()+"\n";
            getHt().put("job_title","<br>"+scvc.getMsg());
        }
        
        if(address.equalsIgnoreCase("")){
            msg += "address is missing!!<br>";
            getHt().put("address","<br>address is missing!!");
        }
        if(scvc.validate(address) == false){
            msg += "<br>"+scvc.getMsg()+"\n";
            getHt().put("address","<br>"+scvc.getMsg());
        }
        
        if(passport.equalsIgnoreCase("")){
            msg += "passport number is missing!!<br>";
            getHt().put("passport","<br>passport number is missing!!");
        }
        if(scvc.validate(passport) == false){
            msg += "<br>"+scvc.getMsg()+"\n";
            getHt().put("passport","<br>"+scvc.getMsg());
        }
        
        if(marital_status.equalsIgnoreCase("")){
            msg += "marital_status is missing!!<br>";
            getHt().put("marital_status","<br>marital status is missing!!");
        }
        if(scvc.validate(marital_status) == false){
            msg += "<br>"+scvc.getMsg()+"\n";
            getHt().put("marital_status","<br>"+scvc.getMsg());
        }
        
        if(gender.equalsIgnoreCase("")){
            msg += "gender is missing!!<br>";
            getHt().put("gender","<br>gender is missing!!");
        }
        if(scvc.validate(gender) == false){
            msg += "<br>"+scvc.getMsg()+"\n";
            getHt().put("gender","<br>"+scvc.getMsg());
        }
        
        //(END)validating name, sur_name, title
        
        //validating password
        DB_Control.Open_DB_Connection();
        ResultSet res = null;
        try {
            res = DB_Control.execute_sql_query("select password from sysuser where user_id = " + user_id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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
                    if(!new_pass.equalsIgnoreCase(old_pass)){
                        if(!con_pass.equals(new_pass)){
                            msg += "passwords are not match<br>";
                            getHt().put("con_pass","<br>passwords are not match!!");
                        }
                    }
                }else{
                    msg += "put a password to change<br>";
                    getHt().put("new_pass","<br>put a new password to change!!");
                }
            }else{
                msg += "the old password must is incorrect<br>";
                getHt().put("old_pass","<br>the old password is incorrect");
            }
        }else{
            //msg += "the old password is incorrect<br>";
        }
        
        if(scvc.validate(old_pass) == false){
            msg += "<br>"+scvc.getMsg()+"\n";
            getHt().put("old_pass","<br>"+scvc.getMsg());
        }
        
        if(scvc.validate(new_pass) == false){
            msg += "<br>"+scvc.getMsg()+"\n";
            getHt().put("new_pass","<br>"+scvc.getMsg());
        }
        
        if(scvc.validate(con_pass) == false){
            msg += "<br>"+scvc.getMsg()+"\n";
            getHt().put("con_pass","<br>"+scvc.getMsg());
        }
        
        //(ENDvalidating password
        
        
        //validating phone, mobile, years_of_exp
        String current_number;
        
        if(!phone.equalsIgnoreCase("")){
            for(int i=0; i<phone.length(); i++){
                try {
                    current_number = phone.substring(i,i+1);
                    System.out.println(current_number);
                    Integer.parseInt(current_number);
                    
                } catch(NumberFormatException nfe) {
                    msg += "phone number is not fully digits!! <br>";
                    getHt().put("phone","<br>phone number is not fully digits!!");
                    break;
                }
            }
        }else{
            msg += "put a phone number!!<br>";
            getHt().put("phone","<br>put a phone number");
        }
        
        for(int i=0; i<mobile.length(); i++){
            try {
                current_number = mobile.substring(i,i+1);
                System.out.println(current_number);
                Integer.parseInt(current_number);
                
            } catch(NumberFormatException nfe) {
                msg += "mobile number is not fully digits!! <br>";
                getHt().put("mobile","<br>mobile number is not fully digits!!");
                break;
            }
        }
        
        if(!years_of_exp.equalsIgnoreCase("")){
            for(int i=0; i<years_of_exp.length(); i++){
                try {
                    current_number = years_of_exp.substring(i,i+1);
                    System.out.println(current_number);
                    Integer.parseInt(current_number);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    msg += "years of exp is not fully digits!! <br>";
                    getHt().put("years_of_exp","<br>years of exp is not fully digits!!");
                    break;
                }
            }
        }else{
            msg += "put the year you have worked<br>";
            getHt().put("years_of_exp","<br>put the year you have worked!!");
        }
        
        //(END)validating phone, mobile, years_of_exp
        
        return msg;
    }
    
    public String validate_customer(String user_id, String name, String sur_name,
            String title, String phone, String mobile, String address, String email){
        
        //prepare and reset values
        String msg = "";
        
        getHt().put("name","");
        getHt().put("sur_name","");
        getHt().put("title","");
        getHt().put("phone","");
        getHt().put("mobile","");
        getHt().put("address","");
        getHt().put("email","");
        
        
        //validating name, sur_name, title
        if(name.equalsIgnoreCase("")){
            msg += "name is missing!!<br>";
            getHt().put("name","<br>name is missing!!");
        }
        
        if(scvc.validate(name) == false){
            msg += "<br>"+scvc.getMsg()+"\n";
            getHt().put("name","<br>"+scvc.getMsg());
        }
        
        if(sur_name.equalsIgnoreCase("")){
            msg += "sur_name is missing!!<br>";
            getHt().put("sur_name","<br>sur_name is missing!!");
        }
        
        if(scvc.validate(sur_name) == false){
            msg += "<br>"+scvc.getMsg()+"\n";
            getHt().put("sur_name","<br>"+scvc.getMsg());
        }
        
        if(title.equalsIgnoreCase("")){
            msg += "title is missing!!<br>";
            getHt().put("name","<br>title is missing!!");
        }
        
        if(scvc.validate(title) == false){
            msg += "<br>"+scvc.getMsg()+"\n";
            getHt().put("title","<br>"+scvc.getMsg());
        }
        //(END)validating name, sur_name, title
        
        
        //validating password
        DB_Control.Open_DB_Connection();
        ResultSet res = null;
        try {
            res = DB_Control.execute_sql_query("select password from sysuser where user_id = " + user_id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String pass = "";
        try {
            res.next();
            pass = res.getString("password");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        
        //validating phone, mobile
        String current_number;
        
        for(int i=0; i<phone.length(); i++){
            try {
                current_number = phone.substring(i,i+1);
                System.out.println(current_number);
                Integer.parseInt(current_number);
                
            } catch(NumberFormatException nfe) {
                msg += "phone number is not fully digits!! <br>";
                getHt().put("phone","<br>phone number is not fully digits!!");
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
                getHt().put("mobile","<br>mobile number is not fully digits!!");
                break;
            }
        }
        //(END)validating phone, mobile
        
        //validating the email
        try {
            
            if(!email.equalsIgnoreCase("")){
                if(email.indexOf("@") == -1 || email.indexOf(".") == -1){
                    msg += "<br>put a valide email!! \n";
                    ht.put("email","<br>put a valid email");
                }
                
            }else{
                msg += "<br>put a valide email!! \n";
                ht.put("email","<br>put a valid email");
            }
            
            if(scvc.validate_email(email) == false){
                msg += "<br>you email has an illegal character!! \n";
                ht.put("email","<br>"+scvc.getMsg());
            }
            
        } catch (NullPointerException ex){
            System.out.println("null exeption in validating email \n");
        }
        //(END)validating the email
        
        return msg;
    }
    
    public String validate_employee(String user_id, String name, String sur_name,
            String job_title,String marital_status, String gender, String phone, String mobile, String address,String passport, String years_of_exp){
        
        //prepare and reset values
        String msg = "";
        
        getHt().put("name","");
        getHt().put("sur_name","");
        getHt().put("job_title","");
        getHt().put("marital_status","");
        getHt().put("gender","");
        getHt().put("phone","");
        getHt().put("mobile","");
        getHt().put("address","");
        getHt().put("passport","");
        getHt().put("years_of_exp","");
        
        //validating name, sur_name, title
        if(name.equalsIgnoreCase("")){
            msg += "name is missing!!<br>";
            getHt().put("name","<br>name is missing!!");
        }
        if(scvc.validate(name) == false){
            msg += "<br>"+scvc.getMsg()+"\n";
            getHt().put("name","<br>"+scvc.getMsg());
        }
        
        if(sur_name.equalsIgnoreCase("")){
            msg += "sur_name is missing!!<br>";
            getHt().put("sur_name","<br>sur_name is missing!!");
        }
        if(scvc.validate(sur_name) == false){
            msg += "<br>"+scvc.getMsg()+"\n";
            getHt().put("sur_name","<br>"+scvc.getMsg());
        }
        
        if(job_title.equalsIgnoreCase("")){
            msg += "job title is missing!!<br>";
            getHt().put("job_title","<br>job title is missing!!");
        }
        if(scvc.validate(job_title) == false){
            msg += "<br>"+scvc.getMsg()+"\n";
            getHt().put("job_title","<br>"+scvc.getMsg());
        }
        
        if(address.equalsIgnoreCase("")){
            msg += "address is missing!!<br>";
            getHt().put("address","<br>address is missing!!");
        }
        if(scvc.validate(address) == false){
            msg += "<br>"+scvc.getMsg()+"\n";
            getHt().put("address","<br>"+scvc.getMsg());
        }
        
        if(passport.equalsIgnoreCase("")){
            msg += "passport number is missing!!<br>";
            getHt().put("passport","<br>passport number is missing!!");
        }
        if(scvc.validate(passport) == false){
            msg += "<br>"+scvc.getMsg()+"\n";
            getHt().put("passport","<br>"+scvc.getMsg());
        }
         
        if(marital_status.equalsIgnoreCase("")){
            msg += "marital_status is missing!!<br>";
            getHt().put("marital_status","<br>marital status is missing!!");
        }
        if(scvc.validate(marital_status) == false){
            msg += "<br>"+scvc.getMsg()+"\n";
            getHt().put("marital_status","<br>"+scvc.getMsg());
        }
        
        if(gender.equalsIgnoreCase("")){
            msg += "gender is missing!!<br>";
            getHt().put("gender","<br>gender is missing!!");
        }
        if(scvc.validate(gender) == false){
            msg += "<br>"+scvc.getMsg()+"\n";
            getHt().put("gender","<br>"+scvc.getMsg());
        }
        
        //(END)validating name, sur_name, title
        
        
        
        //validating phone, mobile, years_of_exp
        String current_number;
        
        if(!phone.equalsIgnoreCase("")){
            for(int i=0; i<phone.length(); i++){
                try {
                    current_number = phone.substring(i,i+1);
                    System.out.println(current_number);
                    Integer.parseInt(current_number);
                    
                } catch(NumberFormatException nfe) {
                    msg += "phone number is not fully digits!! <br>";
                    getHt().put("phone","<br>phone number is not fully digits!!");
                    break;
                }
            }
        }else{
            msg += "put a phone number!!<br>";
            getHt().put("phone","<br>put a phone number");
        }
        
        for(int i=0; i<mobile.length(); i++){
            try {
                current_number = mobile.substring(i,i+1);
                System.out.println(current_number);
                Integer.parseInt(current_number);
                
            } catch(NumberFormatException nfe) {
                msg += "mobile number is not fully digits!! <br>";
                getHt().put("mobile","<br>mobile number is not fully digits!!");
                break;
            }
        }
        
        if(!years_of_exp.equalsIgnoreCase("")){
            for(int i=0; i<years_of_exp.length(); i++){
                try {
                    current_number = years_of_exp.substring(i,i+1);
                    System.out.println(current_number);
                    Integer.parseInt(current_number);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    msg += "years of exp is not fully digits!! <br>";
                    getHt().put("years_of_exp","<br>years of exp is not fully digits!!");
                    break;
                }
            }
        }else{
            msg += "put the year you have worked<br>";
            getHt().put("years_of_exp","<br>put the year you have worked!!");
        }
        
        //(END)validating phone, mobile, years_of_exp
        
        return msg;
    }
    
    public Hashtable getHt() {
        return ht;
    }
    
    public void setHt(Hashtable ht) {
        this.ht = ht;
    }
}

