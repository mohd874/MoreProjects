/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me;

import java.io.*;
import java.net.*;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Saeed
 */
public class CalculationServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        retainFormValues(req);
        if (!isFormValid(req)) {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }

        String str1 = req.getParameter("txtA");
        String str2 = req.getParameter("txtB");

        String strOp = req.getParameter("rdOperation");

        float num1, num2;
        String result = "";

        num1 = Float.parseFloat(str1);
        num2 = Float.parseFloat(str2);

        if ("add".equalsIgnoreCase(strOp)) {
            result = (num1 + num2) + "";
        } else if ("subtract".equalsIgnoreCase(strOp)) {
            result = (num1 - num2) + "";
        } else if ("multiply".equalsIgnoreCase(strOp)) {
            result = (num1 * num2) + "";
        } else if ("divide".equalsIgnoreCase(strOp)) {
            result = (num1 / num2) + "";
        }
        req.setAttribute("result", result);
        req.setAttribute("txtA", num1);
        req.setAttribute("txtB", num2);
        
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    private void retainFormValues(HttpServletRequest req) {
        String strA = req.getParameter("txtA");
        String strB = req.getParameter("txtB");
        String strOp = req.getParameter("rdOperation");
        System.out.println("txtA: "+strA);
        
        req.setAttribute("a", strA);
        req.setAttribute("b", strB);
        
        String [] c = {"","","",""};
        
             if("add".equals(strOp))c[0]="checked";
        else if("subtract".equals(strOp))c[1]="checked";
        else if("multiply".equals(strOp))c[2]="checked";
        else if("divide".equals(strOp))c[3]="checked";
        
        req.setAttribute("c", c);
    }

    private boolean isFormValid(HttpServletRequest req) {

        String str1 = req.getParameter("txtA");
        String str2 = req.getParameter("txtB");

        String strOp = req.getParameter("rdOperation");

        List<String> errors = new ArrayList<String>();

        try {
            Float.parseFloat(str1);
        } catch (Exception e) {
            errors.add("please put a valid value to A");
        }

        try {
            float num = Float.parseFloat(str2);
            if (num == 0) {
                errors.add("can not divide by zero");
            }
        } catch (Exception e) {
            errors.add("please put a valid value to b");
        }

        if (strOp == null) {
            errors.add("please select an operation");
        }

        req.setAttribute("errors", errors);
        return errors.size() == 0;
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

class CalcFormBean{
    
    int numA,numB;
    String operation,result;
    List<String> errors;
}
