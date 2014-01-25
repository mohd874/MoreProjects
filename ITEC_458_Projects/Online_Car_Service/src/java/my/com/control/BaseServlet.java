/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.com.control;

import java.io.*;
import java.net.*;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import my.com.db.AccessHelper;
import my.com.db.DatabaseUtil;

/**
 *
 * @author Saeed
 */
public class BaseServlet extends HttpServlet {

    protected static DatabaseUtil dbUtil = new DatabaseUtil();
    protected final String USER_BEAN_STRING = "userBean";
    
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected Date getDateFromString(String dateString) {
        Date date = null;
        if (dateString != null) {
            Calendar c = Calendar.getInstance();
            StringTokenizer st = new StringTokenizer(dateString, "-");
            try {
                c.set(c.DAY_OF_MONTH, Integer.parseInt(st.nextToken()));
                c.set(c.MONTH, (Integer.parseInt(st.nextToken())-1));
                c.set(c.YEAR, Integer.parseInt(st.nextToken()));

                date = c.getTime();
            } catch (Exception e) {
                date = null;
            }
        }
        return date;
    }
    
    protected String getStringFromDate(Date date) {
        String dateString = "";
        if (date != null) {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            dateString = sdf.format(date);
        }
        return dateString;
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
