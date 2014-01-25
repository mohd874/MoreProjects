
package com.hotel.web;

import com.hotel.model.DB_Control;
import com.hotel.model.profile_validate;
import com.hotel.model.tracing_bean;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class profile_control extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        //getting user_id
        tracing_bean tb = (tracing_bean)request.getSession().getAttribute("tracing_bean");
        String user_id = tb.getUserID();
        //(END)getting user_id
        //getting request parameters
        String uname        = request.getParameter("uname");
        String old_pass     = request.getParameter("old_pass");
        String new_pass     = request.getParameter("new_pass");
        String con_pass     = request.getParameter("con_pass");
        String name         = request.getParameter("name");
        String sur_name     = request.getParameter("sur_name");
        String title        = request.getParameter("title");
        String phone        = request.getParameter("phone");
        String mobile       = request.getParameter("mobile");
        String fax          = request.getParameter("fax");
        String address      = request.getParameter("address");
        String passport     = request.getParameter("passport");
        String b_o_box      = request.getParameter("b_o_box");
        String nationality  = request.getParameter("nationality");
        String email        = request.getParameter("email");
        String con_email    = request.getParameter("con_email");
        //(END) getting request parameters
        
        //validating request parameters
        profile_validate pv = new profile_validate();
        String msg = pv.validate(user_id,name,sur_name,old_pass,new_pass,con_pass,title,phone,mobile,address,email);
        //(ENDvalidating request parameters
        
        
        //System.out.println(msg);
        
        
        //Action
        String sql_query;
        
        //creating sql statement
        if(msg.equalsIgnoreCase("")){
            System.out.println("Succese");
            if(!old_pass.equalsIgnoreCase("")){
                System.out.println("change with password");
                sql_query = "update sysuser, customers set " +
                        "name = '"+ name +"'," +
                        "surname = '"+ sur_name +"'," +
                        "password = '"+ new_pass +"'," +
                        "title = '"+ title +"'," +
                        "phone_number = '"+ phone +"'," +
                        "mobile_number = '"+ mobile +"'," +
                        "fax = '"+ fax +"'," +
                        "address = '"+ address +"'," +
                        "passport_number = '"+ name +"'," +
                        "b_o_box = '"+ b_o_box +"'," +
                        "nationality = '"+ nationality +"'," +
                        "e_mail = '"+ email +"'" +
                        "where user_id = customer_id and user_id = '"+ user_id +"'";
            }else{
                System.out.println("change without password");
                sql_query = "update sysuser, customers set " +
                        "name = "+ name +"," +
                        "surname = "+ sur_name +"," +
                        "title = "+ title +"," +
                        "phone_number = "+ phone +"," +
                        "mobile_number = "+ mobile +"," +
                        "fax = "+ fax +"," +
                        "address = "+ address +"," +
                        "passport_number = "+ name +"," +
                        "b_o_box = "+ b_o_box +"," +
                        "nationality = "+ nationality +"," +
                        "e_mail = "+ email +"," +
                        "where user_id = customer_id and user_id = "+ user_id +"";
            }
            //(END)creating sql statement
            
            System.out.println(sql_query);
            
            DB_Control.Open_DB_Connection();
            DB_Control.update_database(sql_query);
            
        }else{
            System.out.println(msg);
        }
    }
}
