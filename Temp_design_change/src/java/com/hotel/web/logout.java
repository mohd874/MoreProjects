package com.hotel.web;

import com.hotel.model.tracing_bean;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class logout extends HttpServlet {
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try{
        tracing_bean tb = (tracing_bean)request.getSession().getAttribute("tracing_bean");
        
        tb.setUname("Guest");
        tb.setName("Guest");
        tb.setUtype("5");
        tb.setUserID(null);
        
        request.getSession().setAttribute("tracing_bean", tb);
        response.sendRedirect("home.jsp");
        
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
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    }
    
}
