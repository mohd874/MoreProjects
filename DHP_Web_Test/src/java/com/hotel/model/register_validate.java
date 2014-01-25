
package com.hotel.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class register_validate {
    
    //account info
    //will not be validated-vvvvvvvvvvvvv
    private String uname, pass, con_pass;
    //will not be validated-^^^^^^^^^^^^^
    
    //personal info
    private String name, sur_name, title, pre_phone, phone, pre_mobile, mobile, email;
    
    //will not be validated-vvvvvvvvvvvvv
    private String fax, address, passport, b_o_box, nationality, email_confirmation;
    //will not be validated-^^^^^^^^^^^^^
    
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
        setEmail_confirmation(email_confirmation);
        setFax(fax);
        setAddress(address);
        setPassport(passport);
        setB_o_box(b_o_box);
        setNationality(nationality);
        setFax(fax);
    }
    
    
    
    private ResultSet res = null;
    
    
    public String validate_info(){
        
        String msg = "";
        try {
            
            //validating uname
            
            try {
                if(!getUname().equalsIgnoreCase("") || !getUname().equalsIgnoreCase(null)){
                    msg += DB_Control.Open_DB_Connection();
                    
                    String sql_query = "select * from sysuser where user_name = '"+getUname()+"'";
                    setRes(DB_Control.execute_sql_query(sql_query));
                    
                    if(getRes().next()){
                        msg += "There is already a user with the same User name \n";
                    }
                }else{
                    msg += "put your user name \n";
                }
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                msg += "SQL Exeption "+ex.toString()+" ";
            } catch (NullPointerException ex){
                System.out.println("null exeption in validating uname \n");
            }
            try {
                
                // password validation
                if(!getPass().equalsIgnoreCase("") || !getPass().equalsIgnoreCase(null)){
                    if(!getCon_pass().equalsIgnoreCase("")|| !getCon_pass().equalsIgnoreCase(null)){
                        if(!getPass().equalsIgnoreCase(getCon_pass())){
                            msg += "passwords does not match \n";
                        }
                    }else{
                        msg += "confirm your password!!";
                    }
                }else{
                    msg += "put a password!!";
                }
                //name, sur_name and title validation
                
                if(getName().equalsIgnoreCase("") || getName().equalsIgnoreCase(null)){
                    msg += "put your name \n";
                }
                
                if(getSur_name().equalsIgnoreCase("") || getSur_name().equalsIgnoreCase(null)){
                    msg += "put your sur_name \n";
                }
                
                if(getTitle().equalsIgnoreCase("") || getTitle().equalsIgnoreCase(null)){
                    msg += "put your title \n";
                }
            } catch (NullPointerException ex){
                System.out.println("null exeption in validating password \n");
            }
            
            //phone validation
            
            String current_number;
            
            boolean numbersIsAllDigits = true;
            
            for(int i=0; i<getPre_phone().length(); i++){
                try {
                    
                    current_number = getPre_phone().substring(i,i+1);
                    System.out.println(current_number);
                    Integer.parseInt(current_number);
                    
                } catch(NumberFormatException nfe) {
                    numbersIsAllDigits = false;
                    msg += "pre_phone number is not fully digits!! \n";
                    break;
                }
            }
            
            numbersIsAllDigits = true;
            
            for(int i=0; i<getPhone().length(); i++){
                try {
                    
                    current_number = getPhone().substring(i,i+1);
                    System.out.println(current_number);
                    Integer.parseInt(current_number);
                    
                } catch(NumberFormatException nfe) {
                    numbersIsAllDigits = false;
                    msg += "phone number is not fully digits!! \n";
                    break;
                }
            }
            //mobile validation
            
            numbersIsAllDigits = true;
            
            for(int i=0; i<getPre_mobile().length(); i++){
                try {
                    current_number = getPre_mobile().substring(i,i+1);
                    System.out.println(current_number);
                    Integer.parseInt(current_number);
                    
                } catch(NumberFormatException nfe) {
                    numbersIsAllDigits = false;
                    msg += "pre_mobile number is not fully digits!! \n";
                    break;
                }
            }
            
            numbersIsAllDigits = true;
            
            for(int i=0; i<getMobile().length(); i++){
                try {
                    
                    current_number = getMobile().substring(i,i+1);
                    System.out.println(current_number);
                    Integer.parseInt(current_number);
                    
                } catch(NumberFormatException nfe) {
                    numbersIsAllDigits = false;
                    msg += "mobile number is not fully digits!! \n";
                    break;
                }
            }
            
            //fax numbers checking
            
            numbersIsAllDigits = true;
            
            if(!getFax().equalsIgnoreCase("") || !getFax().equalsIgnoreCase(null)){
                for(int i=0; i<getFax().length(); i++){
                    try {
                        
                        current_number = getFax().substring(i,i+1);
                        System.out.println(current_number);
                        Integer.parseInt(current_number);
                        
                    } catch(NumberFormatException nfe) {
                        numbersIsAllDigits = false;
                        msg += "fax is not fully digits!! \n";
                        break;
                    }
                }
            }
            
            //email validation
            try {
                
                
                if(!getEmail().equalsIgnoreCase("") || !getEmail().equalsIgnoreCase(null)){
                    if(getEmail().indexOf("@") == -1 || getEmail().indexOf(".") == -1){
                        msg += "put a valide email!! \n";
                    }
                    
                }else{
                    msg += "put a valide email!! \n";
                }
            } catch (NullPointerException ex){
                System.out.println("null exeption in validating email \n");
            }
        } catch (NullPointerException ex){
            ex.printStackTrace();
            System.out.println("a null exeption in the big!!" + ex.toString() + "\n");
        }
        
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
    
    public String getFax() {
        return fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getPassport() {
        return passport;
    }
    
    public void setPassport(String passport) {
        this.passport = passport;
    }
    
    public String getB_o_box() {
        return b_o_box;
    }
    
    public void setB_o_box(String b_o_box) {
        this.b_o_box = b_o_box;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    public String getEmail_confirmation() {
        return email_confirmation;
    }
    
    public void setEmail_confirmation(String email_confirmation) {
        this.email_confirmation = email_confirmation;
    }
    
    public ResultSet getRes() {
        return res;
    }
    
    public void setRes(ResultSet res) {
        this.res = res;
    }
    
    
    
    
    
}
