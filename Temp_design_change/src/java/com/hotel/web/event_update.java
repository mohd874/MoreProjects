
package com.hotel.web;

import com.hotel.model.DB_Control;
import java.io.*;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.http.*;

public class event_update extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        try{
        /* notes:
         *- need validation for dates
         *- need validation for prices
         */
            
            String[] appointments = request.getParameterValues("appointment_no");
            String[] date_from = request.getParameterValues("date_from");
            String[] date_to = request.getParameterValues("date_to");
            String[] comment = request.getParameterValues("comment");
            String[] total_price = request.getParameterValues("total_price");
            String[] description = request.getParameterValues("description");
            String[] customer_id = request.getParameterValues("names");
            String[] facility_no = request.getParameterValues("facilities");
            String[] event_id = request.getParameterValues("events");
            
            
            
            for(int i=0; i<appointments.length; i++){
                System.out.println(appointments[i].toString());
                System.out.println(date_from[i].toString());
                System.out.println(date_to[i].toString());
                System.out.println(comment[i].toString());
                System.out.println(total_price[i].toString());
                System.out.println(description[i].toString());
                System.out.println(customer_id[i].toString());
                System.out.println(facility_no[i].toString());
                System.out.println(event_id[i].toString());
                System.out.println("--------------------next----------------------");
                
            }
            
            
            
            
            String sql_query;
            
            for(int i=0; i<appointments.length; i++){
                sql_query = "update event_schedule set " +
                        "date_from = '"+ date_from[i] +"', " +
                        "date_to = '"+ date_to[i] +"', " +
                        "comment = '"+ comment[i] +"', " +
                        "total_price = '"+ total_price[i] +"', " +
                        "description = '"+ description[i] +"', " +
                        "customer_id = '"+ customer_id[i] +"', " +
                        "facility_no = '"+ facility_no[i] +"', " +
                        "event_id = '"+ event_id[i] +"' " +
                        "where appointment_no = "+ appointments[i] +"";
                System.out.println(sql_query);
                try {
                    DB_Control.update_database(sql_query);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            
            RequestDispatcher view;
            view = request.getRequestDispatcher("events.jsp");
            view.forward(request,response);
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
