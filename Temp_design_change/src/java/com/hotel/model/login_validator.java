package com.hotel.model;

/*
 * - prifile_validate.java
 * - Author: Mohammed Omar --- mohd874@hotmail.com
 * - Priject: Hotel Reservation & Account Managment System for Daffodiles Palace Hotel
 * - Date: 06-06-2006
 * - Purpose: used to login name and password from login page    
 */

import com.hotel.model.DB_Control;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login_validator {
    
    public login_validator() {
    }
    
    String msg = "";
    String uType;
    private String name;//user real name
    private String title;//user title
    private String surname;//user surname
    private String userID;//user ID
    
    //-----------------login process-----------------
    public boolean login(String uname, String pass){
        
        boolean login_ok = true;
        ResultSet res = null;//to get sql results
        
        special_charectars_validation_class scvc = new special_charectars_validation_class();//to valide strings special characters
        
        //check if the user name and password don't have special characters
        if(scvc.validate(uname)==false || scvc.validate(pass)==false){
            msg += "Either the user name or the password are wrong, please check the spelling and try again!!";
            return false;
        }
        
        try {
            //getting user name and password from database
            setMsg(getMsg() + DB_Control.Open_DB_Connection());
            
            String sql_query = ("select * from sysuser where user_name = '"+ uname +"' and password = '"+ pass + "' and user_type != '6'");
            System.out.println(sql_query);
            res = DB_Control.execute_sql_query(sql_query);
            
            String check_pass = "";
            if(res.next()) {
                check_pass = res.getString("password");
                //check if the inputed password is the same as the database password
                if(pass.equals(check_pass)){
                    uType = res.getString("user_type");
                    userID = res.getString("user_id");
                    name = res.getString("name");
                    setTitle(res.getString("title"));
                    setSurname(res.getString("surname"));
                    login_ok = true;
                }else{
                    login_ok = false;
                    msg += "Either the user name or the password are wrong, please check the spelling and try again!!";
                }
                
            } else {
                login_ok = false;
                msg += "Either the user name or the password are wrong, please check the spelling and try again!!";
            }
            
        } catch (SQLException ex) {
            setMsg(getMsg() + ex.toString());
        }
        
        DB_Control.closeConnection();
        return login_ok;
    }
    
    public String getUserType(){
        return uType;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public String getUserID() {
        return userID;
    }
    
    public void setUserID(String ID) {
        this.userID = ID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
}
