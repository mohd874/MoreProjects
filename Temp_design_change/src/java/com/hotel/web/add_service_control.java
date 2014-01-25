
package com.hotel.web;

import com.hotel.model.DB_Control;
import java.io.*;
import java.net.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

public class add_service_control extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        try{
            
            String service_type = request.getParameter("service_type");
            String service_desc = request.getParameter("service_desc");
            
            System.out.println("service_type: "+service_type+"\nservice_desc: "+service_desc);
            
            String msg = "";
            
            if(service_type.equalsIgnoreCase("") || service_type.equalsIgnoreCase(null)){
                msg += "type the service type<br>";
            }
            if(service_desc.equalsIgnoreCase("") || service_desc.equalsIgnoreCase(null)){
                msg += "type the service description<br>";
            }
            
            System.out.println(msg);
            
            if(msg.equalsIgnoreCase("")){
                String sql_query = "insert into services (service_type,service_desc) values ( '"+service_type+"','"+service_desc+"')";
                System.out.println(sql_query);
                
                DB_Control.Open_DB_Connection();
                try {
                    System.out.println(DB_Control.update_database(sql_query));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                
                DB_Control.closeConnection();
                response.sendRedirect("add_service.jsp");
            }else{
                msg = "Adding service operation was inturappted by the following errors:<br>"+msg;
                request.setAttribute("errors",msg);
                RequestDispatcher view = request.getRequestDispatcher("add_service.jsp");
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
