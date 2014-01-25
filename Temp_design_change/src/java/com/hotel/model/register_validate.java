package com.hotel.model;

/*
 * - tracing_bean.java
 * - Author: Mohammed Omar --- mohd874@hotmail.com
 * - Priject: Hotel Reservation & Account Managment System for Daffodiles Palace Hotel
 * - Date: 06-06-2006
 * - Purpose: used to validate values that come from registration page
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

public class register_validate {
    
    //account info
    private String uname/*user name*/, pass/*password*/, con_pass/*password confirmation*/;
    
    //personal info
    private String name/*customer name*/, sur_name/*customer surname*/, title, /*national phone code*/pre_phone, /*phone number*/phone,
            /*national mobile code*/pre_mobile, /*mobile number*/mobile, /*email address*/email, /*fax number*/fax;
    
    private Hashtable ht = new Hashtable();//HashTable to store errors
    
    public register_validate(String uname, String pass, String con_pass, String name, String sur_name, String title,
            String pre_phone, String phone, String pre_mobile, String mobile, String email, String fax) {
        setUname(uname);
        setPass(pass);
        setCon_pass(con_pass);
        setName(name);
        setSur_name(sur_name);
        setTitle(title);
        setPre_phone(pre_phone);
        setPhone(phone);
        setPre_mobile(pre_mobile);
        setMobile(mobile);
        setEmail(email);
        setFax(fax);
    }
    
    
    
    private ResultSet res = null;//to store SQL query result
    
    public String validate_info(){
        
        //prepare values
        String msg = "";
        special_charectars_validation_class scvc = new special_charectars_validation_class();//to check if the string has any special character
        
        //reset values
        ht.put("uname","");
        ht.put("pass","");
        ht.put("con_pass","");
        ht.put("name","");
        ht.put("sur_name","");
        ht.put("title","");
        ht.put("pre_phone","");
        ht.put("phone","");
        ht.put("pre_mobile","");
        ht.put("mobile","");
        ht.put("email","");
        ht.put("fax","");
        
        
        try {
            
            //validating if the user name has special characters and if it is already used by another customer
            try {
                //check if the user name has any special characters
                if(scvc.validate(getUname()) == true){
                    //if the user name is not an empty string
                    if(!getUname().equalsIgnoreCase("")){
                        msg += DB_Control.Open_DB_Connection();
                        System.out.println("uname: "+uname);
                        String sql_query = "select * from sysuser where user_name = '"+getUname()+"'";
                        setRes(DB_Control.execute_sql_query(sql_query));
                        
                        //if there is a result that means the user name is already used
                        if(getRes().next()){
                            msg += "<br>There is already a user with the same User name \n";
                            ht.put("uname","<br>There is already a user with the same User name");
                        }
                        
                    }
                    //empty strings are not allowed
                    else{
                        msg += "<br>put your user name \n";
                        ht.put("uname","<br>put your user name");
                    }
                }
                //speial characters are not allowed
                else{
                    msg += "<br>"+scvc.getMsg()+"\n";
                    ht.put("uname","<br>"+scvc.getMsg());
                }
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                msg += "SQL Exeption "+ex.toString()+" ";
            } catch (NullPointerException ex){
                ex.printStackTrace();
                System.out.println("null exeption in validating uname \n");
            }
            
            
            try {
                
                //password validation(both password and password confirmation must be exactly matched  
                if(!getPass().equalsIgnoreCase("")){
                    if(!getCon_pass().equalsIgnoreCase("")){
                        if(!getPass().equals(getCon_pass())){
                            msg += "<br>passwords does not match \n";
                            ht.put("pass","<br>passwords does not match");
                        }
                    }else{
                        msg += "<br>confirm your password!!";
                        ht.put("con_pass","<br>confirm youur password");
                    }
                }else{
                    msg += "<br>put a password!!";
                    ht.put("pass","<br>put a password");
                }
                
                //check if password have special chercter
                if(scvc.validate(pass) == false){
                    msg += "<br>"+scvc.getMsg()+"\n";
                    ht.put("pass","<br>"+scvc.getMsg());
                }
                //check if confirmed password have special characters
                if(scvc.validate(con_pass) == false){
                    msg += "<br>"+scvc.getMsg()+"\n";
                    ht.put("con_pass","<br>"+scvc.getMsg());
                }
                
                
                //check if name, sur_name and title are not empty string and don't havre special charcter
                if(getName().equalsIgnoreCase("") || getName().equalsIgnoreCase(null)){
                    msg += "<br>put your name \n";
                    ht.put("name","<br>put your name");
                }
               
                if(scvc.validate(name) == false){
                    msg += "<br>"+scvc.getMsg()+"\n";
                    ht.put("name","<br>"+scvc.getMsg());
                }
                
                if(getSur_name().equalsIgnoreCase("") || getSur_name().equalsIgnoreCase(null)){
                    msg += "<br>put your sur_name \n";
                    ht.put("surname","<br>put your surname");
                }
                 
                if(scvc.validate(sur_name) == false){
                    msg += "<br>"+scvc.getMsg()+"\n";
                    ht.put("surname","<br>"+scvc.getMsg());
                }
                
                //title is not required
                //if(getTitle().equalsIgnoreCase("") || getTitle().equalsIgnoreCase(null)){
                //    msg += "<br>put your title \n";
                //}
            } catch (NullPointerException ex){
                System.out.println("null exeption in validating password \n");
            }
            
            //check if phone number was fully degits
            String current_number;
            
            boolean numbersIsAllDigits = true;
            
            for(int i=0; i<getPre_phone().length(); i++){
                try {
                    
                    current_number = getPre_phone().substring(i,i+1);
                    System.out.println(current_number);
                    Integer.parseInt(current_number);
                    
                } catch(NumberFormatException nfe) {
                    numbersIsAllDigits = false;
                    msg += "<br>phone number is not fully digits!! \n";
                    ht.put("phone","<br>phone number is not fully digits");
                    break;
                }
            }
            
            numbersIsAllDigits = true;
            if(ht.get("phone") == ""){
                for(int i=0; i<getPhone().length(); i++){
                    try {
                        
                        current_number = getPhone().substring(i,i+1);
                        System.out.println(current_number);
                        Integer.parseInt(current_number);
                        
                    } catch(NumberFormatException nfe) {
                        numbersIsAllDigits = false;
                        msg += "<br>phone number is not fully digits!! \n";
                        ht.put("phone","<br>phone number is not fully digits");
                        break;
                    }
                }
            }
            //check if mopile number is fully digets
            
            numbersIsAllDigits = true;
            
            for(int i=0; i<getPre_mobile().length(); i++){
                try {
                    current_number = getPre_mobile().substring(i,i+1);
                    System.out.println(current_number);
                    Integer.parseInt(current_number);
                    
                } catch(NumberFormatException nfe) {
                    numbersIsAllDigits = false;
                    msg += "<br>mobile number is not fully digits!! \n";
                    ht.put("mobile","<br>mobile number is not fully digits");
                    break;
                }
            }
            
            numbersIsAllDigits = true;
            if(ht.get("mobile") == ""){
                for(int i=0; i<getMobile().length(); i++){
                    try {
                        
                        current_number = getMobile().substring(i,i+1);
                        System.out.println(current_number);
                        Integer.parseInt(current_number);
                        
                    } catch(NumberFormatException nfe) {
                        numbersIsAllDigits = false;
                        msg += "mobile number is not fully digits!! \n";
                        ht.put("mobile","<br>mobile number is not fully digits");
                        break;
                    }
                }
            }
            //checking fax number is fully digets
            
            numbersIsAllDigits = true;
            
            if(!getFax().equalsIgnoreCase("") || !getFax().equalsIgnoreCase(null)){
                for(int i=0; i<getFax().length(); i++){
                    try {
                        
                        current_number = getFax().substring(i,i+1);
                        System.out.println(current_number);
                        Integer.parseInt(current_number);
                        
                    } catch(NumberFormatException nfe) {
                        numbersIsAllDigits = false;
                        msg += "<br>fax is not fully digits!! \n";
                        ht.put("fax","<br>fax is not fully digits");
                        break;
                    }
                }
            }
            
            //check if email have "@" and "." and check special charcters eccept "-" and "_"
            try {
                
                if(!getEmail().equalsIgnoreCase("")){
                    if(getEmail().indexOf("@") == -1 || getEmail().indexOf(".") == -1){
                        msg += "<br>put a valide email!! \n";
                        ht.put("email","<br>put a valid email");
                    }
                    
                }else{
                    msg += "<br>put a valide email!! \n";
                    ht.put("email","<br>put a valid email");
                }
                
                if(scvc.validate_email(getEmail()) == false){
                    msg += "<br>you email has an illegal character!! \n";
                        ht.put("email","<br>"+scvc.getMsg());
                }
                
            } catch (NullPointerException ex){
                System.out.println("null exeption in validating email \n");
            }
        } catch (NullPointerException ex){
            ex.printStackTrace();
            System.out.println("a null exeption in the big!!" + ex.toString() + "\n");
        }
        //close Data Base Connection
        DB_Control.closeConnection();
        return msg;
    }
    
    public String getUname() {
        return uname;
    }
    
    public void setUname(String uname) {
        this.uname = uname;
    }
    
    public String getPass() {
        return pass;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public String getCon_pass() {
        return con_pass;
    }
    
    public void setCon_pass(String con_pass) {
        this.con_pass = con_pass;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSur_name() {
        return sur_name;
    }
    
    public void setSur_name(String sur_name) {
        this.sur_name = sur_name;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getPre_phone() {
        return pre_phone;
    }
    
    public void setPre_phone(String pre_phone) {
        this.pre_phone = pre_phone;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getPre_mobile() {
        return pre_mobile;
    }
    
    public void setPre_mobile(String pre_mobile) {
        this.pre_mobile = pre_mobile;
    }
    
    public String getMobile() {
        return mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public ResultSet getRes() {
        return res;
    }
    
    public void setRes(ResultSet res) {
        this.res = res;
    }
    
    public Hashtable getHt() {
        return ht;
    }
    
    public void setHt(Hashtable ht) {
        this.ht = ht;
    }
    
    public String getFax() {
        return fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }
    
    
    
    
    
}
