/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me;

import java.io.*;
import java.net.*;

import java.util.HashMap;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Saeed
 */
public class MyServlet extends HttpServlet {

    private HashMap forwards;
    
    public void init(ServletConfig arg0) throws ServletException {
        super.init(arg0);
        forwards = new HashMap();
        forwards.put("hot",arg0.getInitParameter("hot"));
        forwards.put("cool",arg0.getInitParameter("cool"));
    }
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String servletPath = request.getServletPath();
        
        String logicalName = servletPath.substring(servletPath.lastIndexOf("/")+1, servletPath.indexOf("."));
        
        String physicalPath = "/";
        if(logicalName.equalsIgnoreCase("hot")){
            physicalPath += (String) forwards.get("hot");
        }else if(logicalName.equalsIgnoreCase("cool")){
            physicalPath += (String) forwards.get("cool");
        }
        
        request.getRequestDispatcher(physicalPath).forward(request, response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
    * Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
