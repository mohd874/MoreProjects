/*
 * profile_admin_control.java
 *
 * Created on May 30, 2006, 1:02 PM
 */

package com.hotel.web;

import com.hotel.model.DB_Control;
import com.hotel.model.profile_validate;
import com.hotel.model.tracing_bean;
import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

public class profile_admin_control extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try{
            //get and reset valules
            String user_id = request.getParameter("hidden_user_id");
            String user_type = request.getParameter("hidden_user_type");
            String action = request.getParameter("Submit");
            tracing_bean tb = (tracing_bean)request.getSession().getAttribute("tracing_bean");
            String msg = "";
            
            RequestDispatcher view;
            
            System.out.println("user_id: "+user_id+"\nuser_type: "+user_type+"\nAction: "+action);
            
            //if the admin request to reset the password for a certain user
            if(action.equalsIgnoreCase("Reset Password")){
                
                //prepare sql statement
                String sql_query = "update sysuser set password = '0000' where user_id = '"+ user_id +"'";
                
                //open database connection
                DB_Control.Open_DB_Connection();
                
                //execute sql query
                try {
                    
                    DB_Control.update_database(sql_query);
                    
                } catch (SQLException ex) {
                    msg += "There was a problem while updating the database: "+ex;
                    request.setAttribute("errors",msg);
                    ex.printStackTrace();
                }
                
                //printing errors
                System.out.println("\n\n"+msg+"\n\n");
                
                //put the values in the request
                request.setAttribute("user_id",user_id);
                
                //redirecting
                msg += "The password was reseted";
                request.setAttribute("status",msg);
                request.setAttribute("user_id",user_id);
                
                if(tb.getUtype().equalsIgnoreCase("1")){
                    view = request.getRequestDispatcher("profile_admin.jsp");
                }else if(tb.getUtype().equalsIgnoreCase("2")){
                    view = request.getRequestDispatcher("profile_officer.jsp");
                }else if(tb.getUtype().equalsIgnoreCase("3")){
                    view = request.getRequestDispatcher("profile_reseptionist.jsp");
                }else{
                    view = request.getRequestDispatcher("home.jsp");
                }
                
                view.forward(request, response);
                
            }
            //if the admin want to update the profile
            else if(action.equalsIgnoreCase("update")){
                System.out.println("This is the update action!!");
                
                if(user_type.equalsIgnoreCase("4")){
                    
                    //getting request parameters
                    String uname        = request.getParameter("uname");
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
                    
                    //check con_email
                    try{
                        if(con_email.equalsIgnoreCase("")){
                            con_email = "n";
                        }
                    }catch(NullPointerException npe){
                        con_email = "n";
                    }
                    
                    
                    //(END) getting request parameters
                    
                    //validating request parameters
                    profile_validate pv = new profile_validate();
                    msg = pv.validate_customer(user_id,name,sur_name,title,phone,mobile,address,email);
                    //(ENDvalidating request parameters
                    
                    
                    //System.out.println(msg);
                    
                    
                    //Action
                    String sql_query;
                    
                    //creating sql statement
                    if(msg.equalsIgnoreCase("")){
                        
                        //create sql query
                        
                        sql_query = "update sysuser, customers set " +
                                "name = '"+ name +"'," +
                                "surname = '"+ sur_name +"'," +
                                "title = '"+ title +"'," +
                                "phone_number = '"+ phone +"'," +
                                "mobile_number = '"+ mobile +"'," +
                                "fax = '"+ fax +"'," +
                                "address = '"+ address +"'," +
                                "passport_number = '"+ name +"'," +
                                "b_o_box = '"+ b_o_box +"'," +
                                "nationality = '"+ nationality +"'," +
                                "e_mail = '"+ email +"' " +
                                "where user_id = customer_id and user_id = '"+ user_id +"'";
                        
                        //(END)creating sql statement
                        
                        System.out.println(sql_query);
                        
                        //Execute Query and Exit
                        DB_Control.Open_DB_Connection();
                        try {
                            DB_Control.update_database(sql_query);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        
                        System.out.println("The profile was updated successfuly");
                        msg += "The profile was updated successfuly";
                        request.setAttribute("status",msg);
                        request.setAttribute("user_id",user_id);
                        
                        if(tb.getUtype().equalsIgnoreCase("1")){
                            view = request.getRequestDispatcher("profile_admin.jsp");
                        }else if(tb.getUtype().equalsIgnoreCase("2")){
                            view = request.getRequestDispatcher("profile_officer.jsp");
                        }else if(tb.getUtype().equalsIgnoreCase("3")){
                            view = request.getRequestDispatcher("profile_reseptionist.jsp");
                        }else{
                            view = request.getRequestDispatcher("home.jsp");
                        }
                        
                        view.forward(request, response);
                        //response.sendRedirect("profile.jsp");
                        
                        //(END)Execute Query and Exit
                        
                    }else{
                        System.out.println(msg);
                        request.setAttribute("errors",msg);
                        request.setAttribute("user_id",user_id);
                        request.setAttribute("ht",pv.getHt());
                        request.setAttribute("user_id",user_id);
                        
                        if(tb.getUtype().equalsIgnoreCase("1")){
                            view = request.getRequestDispatcher("profile_admin.jsp");
                        }else if(tb.getUtype().equalsIgnoreCase("2")){
                            view = request.getRequestDispatcher("profile_officer.jsp");
                        }else if(tb.getUtype().equalsIgnoreCase("3")){
                            view = request.getRequestDispatcher("profile_reseptionist.jsp");
                        }else{
                            view = request.getRequestDispatcher("home.jsp");
                        }
                        
                        view.forward(request, response);
                    }
                }else{
                    
                    String self_user_id = tb.getUserID();
                    
                    //if the admin want to change the profile
                    if(self_user_id.equalsIgnoreCase(user_id)){
                        
                        System.out.println("The admin will change his own profile");
                        
                        String uname        = request.getParameter("uname");
                        String old_pass     = request.getParameter("old_pass");
                        String new_pass     = request.getParameter("new_pass");
                        String con_pass     = request.getParameter("con_pass");
                        String name         = request.getParameter("name");
                        String sur_name     = request.getParameter("sur_name");
                        String marital_status = request.getParameter("marital_status");
                        String phone        = request.getParameter("phone");
                        String mobile       = request.getParameter("mobile");
                        String job_title    = request.getParameter("job_title");
                        String address      = request.getParameter("address");
                        String passport     = request.getParameter("passport");
                        String b_o_box      = request.getParameter("b_o_box");
                        String nationality  = request.getParameter("nationality");
                        String gender       = request.getParameter("gender");
                        String years_of_exp = request.getParameter("years_of_exp");
                        
                        profile_validate pv = new profile_validate();
                        
                        msg = pv.validate_employee(user_id, name, sur_name, old_pass, new_pass, con_pass, job_title, marital_status, gender,
                                phone, mobile, address,passport, years_of_exp);
                        
                        //preparing sql_query
                        if(msg.equalsIgnoreCase("")){
                            String sql_query = "";
                            //if the employee want to change the old password
                            if(!old_pass.equalsIgnoreCase("")){
                                System.out.println("change with password");
                                sql_query = "update sysuser, employees set " +
                                        "name = '"+ name +"'," +
                                        "surname = '"+ sur_name +"'," +
                                        "password = '"+ new_pass +"'," +
                                        "marital_status = '"+ marital_status +"'," +
                                        "job_title = '"+ job_title +"', "+
                                        "phone_number = '"+ phone +"'," +
                                        "mobile_number = '"+ mobile +"'," +
                                        "gender = '"+ gender +"'," +
                                        "address = '"+ address +"'," +
                                        "passport_number = '"+ name +"'," +
                                        "b_o_box = '"+ b_o_box +"'," +
                                        "nationality = '"+ nationality +"'," +
                                        "years_of_exp = '"+ years_of_exp +"' " +
                                        "where user_id = employee_id and user_id = '"+ user_id +"'";
                            }
                            //if the employee don't wanr to change the old password
                            else{
                                System.out.println("change without password");
                                sql_query = "update sysuser, employees set " +
                                        "name = '"+ name +"'," +
                                        "surname = '"+ sur_name +"'," +
                                        "marital_status = '"+ marital_status +"'," +
                                        "job_title = '"+ job_title +"', "+
                                        "phone_number = '"+ phone +"'," +
                                        "mobile_number = '"+ mobile +"'," +
                                        "gender = '"+ gender +"'," +
                                        "address = '"+ address +"'," +
                                        "passport_number = '"+ name +"'," +
                                        "b_o_box = '"+ b_o_box +"'," +
                                        "nationality = '"+ nationality +"'," +
                                        "years_of_exp = '"+ years_of_exp +"' " +
                                        "where user_id = employee_id and user_id = '"+ user_id +"'";
                            }
                            
                            System.out.println(sql_query);
                            
                            //executing query
                            DB_Control.Open_DB_Connection();
                            
                            try {
                                DB_Control.update_database(sql_query);
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                                System.out.println("\n\nAN ERROR OCCURED WHILE UPDATEING THE DATABASE!!!!");
                                msg +="AN ERROR OCCURED WHILE UPDATEING THE DATABASE!!!!";
                                request.setAttribute("errors",msg);
                            }
                            
                            System.out.println("\n\nfinished updateing the database");
                            
                            if(msg.equalsIgnoreCase("")){
                                msg += "the profile was updated";
                                request.setAttribute("status",msg);
                            }
                            
                            
                        }else{
                            request.setAttribute("errors",msg);
                            request.setAttribute("ht",pv.getHt());
                        }
                        
                        request.setAttribute("user_id",user_id);
                        if(tb.getUtype().equalsIgnoreCase("1")){
                            view = request.getRequestDispatcher("profile_admin.jsp");
                        }else if(tb.getUtype().equalsIgnoreCase("2")){
                            view = request.getRequestDispatcher("profile_officer.jsp");
                        }else if(tb.getUtype().equalsIgnoreCase("3")){
                            view = request.getRequestDispatcher("profile_reseptionist.jsp");
                        }else{
                            view = request.getRequestDispatcher("home.jsp");
                        }
                        
                        view.forward(request, response);
                    }
                    //the admin will change an employee profile
                    else{
                        
                        String uname        = request.getParameter("uname");
                        String name         = request.getParameter("name");
                        String sur_name     = request.getParameter("sur_name");
                        String marital_status = request.getParameter("marital_status");
                        String phone        = request.getParameter("phone");
                        String mobile       = request.getParameter("mobile");
                        String job_title    = request.getParameter("job_title");
                        String address      = request.getParameter("address");
                        String passport     = request.getParameter("passport");
                        String b_o_box      = request.getParameter("b_o_box");
                        String nationality  = request.getParameter("nationality");
                        String gender       = request.getParameter("gender");
                        String years_of_exp = request.getParameter("years_of_exp");
                        
                        profile_validate pv = new profile_validate();
                        
                        msg = pv.validate_employee(user_id, name, sur_name, job_title, marital_status, gender,
                                phone, mobile, address,passport, years_of_exp);
                        
                        //preparing sql_query
                        if(msg.equalsIgnoreCase("")){
                            String sql_query = "";
                            
                            System.out.println("change without password");
                            sql_query = "update sysuser, employees set " +
                                    "name = '"+ name +"'," +
                                    "surname = '"+ sur_name +"'," +
                                    "marital_status = '"+ marital_status +"'," +
                                    "job_title = '"+ job_title +"', "+
                                    "phone_number = '"+ phone +"'," +
                                    "mobile_number = '"+ mobile +"'," +
                                    "gender = '"+ gender +"'," +
                                    "address = '"+ address +"'," +
                                    "passport_number = '"+ name +"'," +
                                    "b_o_box = '"+ b_o_box +"'," +
                                    "nationality = '"+ nationality +"'," +
                                    "years_of_exp = '"+ years_of_exp +"' " +
                                    "where user_id = employee_id and user_id = '"+ user_id +"'";
                            
                            System.out.println(sql_query);
                            
                            //executing query
                            DB_Control.Open_DB_Connection();
                            
                            try {
                                DB_Control.update_database(sql_query);
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                                System.out.println("\n\nAN ERROR OCCURED WHILE UPDATEING THE DATABASE!!!!");
                                msg +="AN ERROR OCCURED WHILE UPDATEING THE DATABASE!!!!";
                                request.setAttribute("errors",msg);
                            }
                            
                            System.out.println("\n\nfinished updateing the database");
                            
                            if(msg.equalsIgnoreCase("")){
                                msg += "the profile was updated";
                                request.setAttribute("status",msg);
                            }
                            
                            
                        }else{
                            request.setAttribute("errors",msg);
                            request.setAttribute("ht",pv.getHt());
                        }
                        
                        request.setAttribute("user_id",user_id);
                        if(tb.getUtype().equalsIgnoreCase("1")){
                            view = request.getRequestDispatcher("profile_admin.jsp");
                        }else if(tb.getUtype().equalsIgnoreCase("2")){
                            view = request.getRequestDispatcher("profile_officer.jsp");
                        }else if(tb.getUtype().equalsIgnoreCase("3")){
                            view = request.getRequestDispatcher("profile_reseptionist.jsp");
                        }else{
                            view = request.getRequestDispatcher("home.jsp");
                        }
                        
                        view.forward(request, response);
                        
                    }
                }
                
                //get and reset values
                
            }
        } catch (Exception ex) {
            try {
                System.out.println("Error: "+ex);
                sendErrorRedirect(request,response,"/error.jsp",ex);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
    protected void sendErrorRedirect(HttpServletRequest request,
            HttpServletResponse response, String errorPageURL,
            Throwable e)
            throws ServletException, IOException {
        System.out.println(e);
        request.setAttribute("javax.servlet.jsp.jspException", e);
        getServletConfig().getServletContext().
                getRequestDispatcher(errorPageURL).forward(request,
                response);
    }
}
