
package com.hotel.web;

import com.hotel.model.DB_Checker;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.servlet.*;
import javax.servlet.http.*;

public class DB_Checker_starter extends HttpServlet {
    
    /*
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
     
        String order = request.getParameter("order");
     
        if(order.equalsIgnoreCase("start")){
            System.out.println("THE ORDER START!!");
            DB_Checker dbc = new DB_Checker();
            request.getSession().setAttribute("DB_Checker",dbc);
     
        }else if(order.equalsIgnoreCase("stop")){
            System.out.println("THE ORDER STOP!!");
            DB_Checker dbc = (DB_Checker)request.getAttribute("DB_Checker");
     
            //System.out.println("DBC IS NOT NULL");
                dbc.stopTimer();
                request.getSession().setAttribute("DB_Checker",dbc);
     
        }
        //RequestDispatcher view = request.getRequestDispatcher("timer_control_panel.jsp");
        //view.forward(request, response);
        response.sendRedirect("timer_control_panel.jsp");
     
    }
     */
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        try{
            String order = request.getParameter("order");
            
            if(order.equalsIgnoreCase("start")){
                System.out.println("THE ORDER START!!");
                DB_Checker dbc = new DB_Checker();
                request.getSession().setAttribute("DB_Checker",dbc);
                
            }else if(order.equalsIgnoreCase("stop")){
                
                try {
                    System.out.println("THE ORDER STOP!!");
                    DB_Checker dbc = (DB_Checker)request.getSession().getAttribute("DB_Checker");
                    //System.out.println("DBC IS NOT NULL");
                    dbc.stopTimer();
                    request.getSession().setAttribute("DB_Checker",dbc);
                } catch(NullPointerException npe) {
                    
                }
                
            }
            //RequestDispatcher view = request.getRequestDispatcher("timer_control_panel.jsp");
            //view.forward(request, response);
            response.sendRedirect("timer_control_panel.jsp");
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
