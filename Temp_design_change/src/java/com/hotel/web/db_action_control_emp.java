package com.hotel.web;

import com.hotel.model.DB_Control;
import java.io.*;
import java.net.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

public class db_action_control_emp extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try{
            String add = request.getParameter("add");
            String delete = request.getParameter("delete");
            String edit = request.getParameter("edit");
            String url = request.getHeader("referer");
            
            try {
                if(!add.equalsIgnoreCase("") && !add.equalsIgnoreCase(null)){
                    if(url.equalsIgnoreCase("db_customers.jsp")){
                        response.sendRedirect("registration.jsp");
                    }else{
                        response.sendRedirect("emp_registration.jsp");
                    }
                }
            } catch (Exception ex) {
                System.out.println("add button exception!!");
            }
            
            
            try{
                if(!delete.equalsIgnoreCase("") && !delete.equalsIgnoreCase(null)){
                    String[] ID = request.getParameterValues("user_id");
                    
                    //preparing delete query for customers
                    String employee_sql_query = "delete from employees where customer_id in (";
                    
                    for(int i=0; i<ID.length; i++){
                        employee_sql_query += " '"+ID[i]+"' ";
                        if(i < (ID.length - 1)){
                            employee_sql_query += ", ";
                        }
                    }
                    employee_sql_query += ")";
                    
                    System.out.println("The Employees Delete Query: "+employee_sql_query);
                    
                    //preparing delete query for sysuser
                    String sysuser_sql_query = "delete from sysuser where user_id in (";
                    
                    for(int i=0; i<ID.length; i++){
                        sysuser_sql_query += " '"+ID[i]+"' ";
                        if(i < (ID.length - 1)){
                            sysuser_sql_query += ", ";
                        }
                    }
                    sysuser_sql_query += ")";
                    System.out.println("The Sysuser Delete Query: "+sysuser_sql_query);
                    
                    
                    //preparing delete query for other tables
                    
                    //query 1
                    String sql_query_1 = "update service_schedule set employee_id = null where employee_id in(";
                    
                    for(int i=0; i<ID.length; i++){
                        sql_query_1 += " '"+ID[i]+"' ";
                        if(i < (ID.length - 1)){
                            sql_query_1 += ", ";
                        }
                    }
                    sql_query_1 += "))";
                    System.out.println("The Delete Query 1: "+sql_query_1);
                    
                    DB_Control.Open_DB_Connection();
                    
                    try {
                        DB_Control.update_database(employee_sql_query);
                        DB_Control.update_database(sysuser_sql_query);
                        DB_Control.update_database(sql_query_1);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        String msg = "an error occourd while deleting data!!"+ex.toString()+"<br>Sorry for the inconvenient";
                        request.setAttribute("errors", msg);
                        RequestDispatcher view = request.getRequestDispatcher("db_employee.jsp");
                        view .forward(request, response);
                    }
                    response.sendRedirect("db_employee.jsp");
                }
            } catch (Exception ex) {
                System.out.println("delete button exception!!");
            }
            
            
            try{
                if(!edit.equalsIgnoreCase("") && !edit.equalsIgnoreCase(null)){
                    String[] user_id = request.getParameterValues("user_id");
                    String msg = "";
                    if(user_id.length > 1){
                        msg = "you have to choose one person at a time!!";
                        System.out.println(msg);
                        request.setAttribute("errors",msg);
                        RequestDispatcher view = request.getRequestDispatcher("db_employee.jsp");
                        view.forward(request, response);
                    }else if(user_id.length < 1){
                        msg = "choose one person to edit!!";
                        System.out.println(msg);
                        request.setAttribute("errors",msg);
                        RequestDispatcher view = request.getRequestDispatcher("db_employee.jsp");
                        view.forward(request, response);
                    }
                    
                    System.out.println("redirecting to profile_user....");
                    //request.setAttribute("user_id",user_id[0]);
                    request.setAttribute("user_id",user_id[0]);
                    request.getSession().setAttribute("return_to","db_employee.jsp");
                    
                    RequestDispatcher view = request.getRequestDispatcher("profile_admin.jsp");
                    view.forward(request, response);
                }
            } catch (Exception ex) {
                System.out.println("edit button exception!!"+ex.toString());
            }
            response.sendRedirect(url.substring(url.lastIndexOf("/")+1));
            
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
