
package com.hotel.model;

import java.util.Hashtable;

public class emp_registration_validate {
    
    
    public emp_registration_validate() {
        
    }
    
    private special_charectars_validation_class scvc = new special_charectars_validation_class();
    private Hashtable ht = new Hashtable();
    
    public String validate(String uname,String password,String con_password,String name,String surname,String phone,
            String mobile,String b_o_box,String address,String passport,String nationality,String job_title,String marital_status,
            String gender,String years_of_exp, String service_no, String user_type){
        
        //preparing and reseting values
        String msg = "";
        getHt().put("uname","");
        getHt().put("name","");
        getHt().put("surname","");
        getHt().put("password","");
        getHt().put("con_password","");
        getHt().put("address","");
        getHt().put("passport","");
        getHt().put("nationality","");
        getHt().put("job_title","");
        getHt().put("marital_status","");
        getHt().put("gender","");
        getHt().put("years_of_exp","");
        getHt().put("phone","");
        getHt().put("mobile","");
        getHt().put("service_no","");
        getHt().put("user_type","");
        
        
        
        //uname, name, surname, password, con_password, address, passport, nationality, job_title, marital_status,
        //gender
        
        if(uname.equalsIgnoreCase("")){
            msg += "no user name<br>";
            getHt().put("uname","<br>put a user name");
        }
        if(scvc.validate(uname) == false){
            msg += "uname contain special characters<br>";
            getHt().put("uname","<br>"+scvc.getMsg());
        }
        
        if(name.equalsIgnoreCase("")){
            msg += "no name<br>";
            getHt().put("name","<br>put a name");
        }
        if(scvc.validate(name) == false){
            msg += "name contain special characters<br>";
            getHt().put("name","<br>"+scvc.getMsg());
        }
        
        if(surname.equalsIgnoreCase("")){
            msg += "no surname<br>";
            getHt().put("surname","<br>put a surname");
        }
        if(scvc.validate(surname) == false){
            msg += "surname contain special characters<br>";
            getHt().put("surname","<br>"+scvc.getMsg());
        }
        
        if(password.equalsIgnoreCase("")){
            msg += "no password<br>";
            getHt().put("password","<br>put a password");
        }
        if(scvc.validate(password) == false){
            msg += "password contain special characters<br>";
            getHt().put("password","<br>"+scvc.getMsg());
        }
        
        if(con_password.equalsIgnoreCase("")){
            msg += "confirm your password<br>";
            getHt().put("con_password","<br>confirm your password");
        }
        if(scvc.validate(con_password) == false){
            msg += "password confirmation contain special characters<br>";
            getHt().put("con_password","<br>"+scvc.getMsg());
        }
        
        if(address.equalsIgnoreCase("")){
            msg += "no address<br>";
            getHt().put("address","<br>put your address");
        }
        if(scvc.validate(address) == false){
            msg += "address contain special characters<br>";
            getHt().put("address","<br>"+scvc.getMsg());
        }
        
        if(passport.equalsIgnoreCase("")){
            msg += "no passport<br>";
            getHt().put("passport","<br>put your passport number");
        }
        if(scvc.validate(address) == false){
            msg += "address contain special characters<br>";
            getHt().put("address","<br>"+scvc.getMsg());
        }
        
        if(b_o_box.equalsIgnoreCase("")){
            msg += "no b_o_box<br>";
            getHt().put("b_o_box","<br>put P.O.Box");
        }
        if(scvc.validate(b_o_box) == false){
            msg += "P.O.Box contain special characters<br>";
            getHt().put("b_o_box","<br>"+scvc.getMsg());
        }
        
        if(nationality.equalsIgnoreCase("")){
            msg += "choose a nationality<br>";
            getHt().put("nationality","<br>choose your nationality");
            
        }
        if(scvc.validate(nationality) == false){
            msg += "nationality contain special characters<br>";
            getHt().put("nationality","<br>"+scvc.getMsg());
        }
        
        if(job_title.equalsIgnoreCase("")){
            msg += "no job title<br>";
            getHt().put("job_title","<br>put your job title");
        }
        if(scvc.validate(job_title) == false){
            msg += "job title contain special characters<br>";
            getHt().put("job_title","<br>"+scvc.getMsg());
        }
        
        if(marital_status.equalsIgnoreCase("")){
            msg += "choose your marital status<br>";
            getHt().put("marital_status","<br>choose your marital status");
        }
        if(scvc.validate(marital_status) == false){
            msg += "marital_status contain special characters<br>";
            getHt().put("marital_status","<br>"+scvc.getMsg());
        }
        
        if(gender.equalsIgnoreCase("")){
            msg += "choose your gender<br>";
            getHt().put("gender","<br>choose your gender");
        }
        if(scvc.validate(gender) == false){
            msg += "gender contain special characters<br>";
            getHt().put("gender","<br>"+scvc.getMsg());
        }
        
        if(user_type.equalsIgnoreCase("")){
            msg += "choose your user type<br>";
            getHt().put("user_type","<br>choose your user type");
        }
        if(scvc.validate(user_type) == false){
            msg += "user type contain special characters<br>";
            getHt().put("user_type","<br>"+scvc.getMsg());
        }
        
        //matching the password
        if(!password.equals(con_password)){
            msg += "passwords are not matched<br>";
            getHt().put("password","passwords are not match");
        }
        
        //validating numiric fields
        //years_of_exp
        if(years_of_exp.equalsIgnoreCase("")){
            msg += "no years of experience<br>";
            getHt().put("years_of_exp","<br>put you years of experience");
        }else{
            try {
                int number = Integer.parseInt(years_of_exp);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                msg += "years of experience should be a number<br>";
                getHt().put("years_of_exp","<br>years of exp should be a number");
            }
        }
        //phone
        if(phone.equalsIgnoreCase("")){
            msg += "no phone<br>";
            getHt().put("phone","<br>put your phone number");
        }else{
            String current_number;
            boolean numbersIsAllDigits = true;
            for(int i=0; i<phone.length(); i++){
                try {
                    current_number = phone.substring(i,i+1);
                    System.out.println(current_number);
                    Integer.parseInt(current_number);
                    
                } catch(NumberFormatException nfe) {
                    numbersIsAllDigits = false;
                    msg += "phone numbers are not fully digits<br>";
                    getHt().put("phone","<br>phone number are not fully digits");
                    break;
                }
            }
        }
        //mobile
        if(mobile.equalsIgnoreCase("")){
            msg += "no mobile<br>";
            getHt().put("mobile","<br>put your number");
        }else{
            String current_number;
            boolean numbersIsAllDigits = true;
            for(int i=0; i<mobile.length(); i++){
                try {
                    current_number = mobile.substring(i,i+1);
                    System.out.println(current_number);
                    Integer.parseInt(current_number);
                    
                } catch(NumberFormatException nfe) {
                    numbersIsAllDigits = false;
                    msg += "mobile numbers are not fully digits<br>";
                    getHt().put("mobile","<br>mobile number is not fully digits");
                    break;
                }
            }
        }
        //service_no
        if(service_no.equalsIgnoreCase("")){
            msg += "choose the type of service<br>";
            getHt().put("service_no","<br>put your service type");
        }
            
        
        
        return msg;
    }
    
    public Hashtable getHt() {
        return ht;
    }
    
    public void setHt(Hashtable ht) {
        this.ht = ht;
    }
    
}
