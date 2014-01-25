

package com.hotel.model;

import com.hotel.model.DB_Control;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login_validator {
    
    
    public login_validator() {
    }
    
    String msg = "";
    String uType;
    private String userID;
    
    //-----------------login process-----------------
    public boolean login(String uname, String pass){
        
        boolean login_ok = true;
        Connection con = null;
        ResultSet res = null;
        
        try {
            
            setMsg(getMsg() + DB_Control.Open_DB_Connection());
            
            String sql_query = ("select * from sysuser where user_name = '"+ uname +"' and password = '"+ pass + "'");
            
            res = DB_Control.execute_sql_query(sql_query);
            
            if(res.next()) {
                uType = res.getString("user_type");
                userID = res.getString("user_id");
                login_ok = true;
            }
            else {
                login_ok = false;
                msg += "Either the user name or the password are wrong, please check the spelling and try again!!";
            }
            /*
                int counter = 0;
                while(res.next()){
                    counter++;
                }
                
                if(counter == 0 || counter > 1 || !getMsg().equalsIgnoreCase("")){
                    login_ok = false;
                } else{
                    login_ok = true;
                }
              */  
            
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
    
}
