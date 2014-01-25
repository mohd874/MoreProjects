
package com.hotel.web;

import com.hotel.model.DB_Control;
import com.hotel.model.emp_registration_validate;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;


public class emp_registration_control extends HttpServlet {
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        try{
            //getting values from the employee registration page
            String uname = request.getParameter("user_name");
            String password = request.getParameter("password");
            String con_password = request.getParameter("con_password");
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String phone = request.getParameter("phone_number");
            String mobile = request.getParameter("mobile_number");
            String b_o_box = request.getParameter("b_o_box");
            String address = request.getParameter("address");
            String passport = request.getParameter("passport_number");
            String nationality = request.getParameter("nationality");
            String job_title = request.getParameter("job_title");
            String marital_status = request.getParameter("marital_status");
            String gender = request.getParameter("gender");
            String years_of_exp = request.getParameter("years_of_exp");
            String service_no = request.getParameter("service_type");
            String user_type = request.getParameter("user_type");
            
            System.out.println("uname: "+uname+"\npassword: "+password+"\ncon_password: "+con_password+"\nsurname: "+surname+"\nmobile: "
                    +mobile+"\nb_o_box: "+ b_o_box +"\naddress: "+address+"\npassport: "+passport+"\nnationality: "+nationality+"\njob_title: "+job_title
                    +"\nmarital_status: "+marital_status+"\ngender: "+gender+"\nyears_of_exp: "+years_of_exp+"\nservice_no: "+service_no+
                    "\nuser_type: "+user_type);
            
            emp_registration_validate erv = new emp_registration_validate();
            
            String msg = erv.validate(uname,password,con_password,name,surname,phone,mobile,b_o_box,address,passport,nationality
                    ,job_title,marital_status,gender,years_of_exp,service_no,user_type);
            
            System.out.println(msg);
            
            if(msg.equalsIgnoreCase("")){
                
                String sql_query = "insert into sysuser (user_name, password, name, surname, phone_number, mobile_number," +
                        " address, passport_number, b_o_box, nationality, user_type)"+
                        " values('"+ uname +"','"+ password +"','"+ name +"','"+ surname +"','"+ phone +"'" +
                        ",'"+ mobile +"','"+ address +"','"+ passport +"','"+ b_o_box +"','"+ nationality +"','"+ user_type +"')";
                
                System.out.println(sql_query);
                
                DB_Control.Open_DB_Connection();
                
                System.out.println("sysuser table changes: ");
                try {
                    System.out.println(DB_Control.update_database(sql_query));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                ResultSet res = null;
                try {
                    res = DB_Control.execute_sql_query("select max(user_id) as user_id from sysuser");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                String emp_id = "";
                try {
                    res.next();
                    if(res != null){
                        emp_id = res.getString("user_id");
                    }else{
                        System.out.println("res is null");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                
                String sql_query_2= "insert into employees (employee_id,job_title,marital_status,gender,years_of_exp,service_no) "+
                        "values( '"+emp_id+"','"+job_title+"','"+marital_status+"','"+gender+"','"+years_of_exp+
                        "','"+service_no+"')";
                
                System.out.println(sql_query_2);
                System.out.println("employees table changes: ");
                try {
                    System.out.println(DB_Control.update_database(sql_query_2));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                
                response.sendRedirect("home.jsp");
                
            }else{
                msg = "you have the following errors: <br>"+msg;
                //request.setAttribute("errors",msg);
                request.setAttribute("ht", erv.getHt());
                
                request.setAttribute("uname",uname);
                request.setAttribute("password",password);
                request.setAttribute("con_password",con_password);
                request.setAttribute("name",name);
                request.setAttribute("surname",surname);
                request.setAttribute("phone",phone);
                request.setAttribute("mobile",mobile);
                request.setAttribute("b_o_box",b_o_box);
                request.setAttribute("address",address);
                request.setAttribute("passport",passport);
                request.setAttribute("nationality",nationality);
                request.setAttribute("job_title",job_title);
                request.setAttribute("marital_status",marital_status);
                request.setAttribute("gender",gender);
                request.setAttribute("years_of_exp",years_of_exp);
                request.setAttribute("service_no",service_no);
                request.setAttribute("user_type",user_type);
                
                
                RequestDispatcher view = request.getRequestDispatcher("emp_registration.jsp");
                view.forward(request,response);
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
