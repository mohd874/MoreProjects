/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.front;

import com.me.model.Customer;
import com.me.model.CustomerManager;
import java.io.*;
import java.net.*;

import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Saeed
 */
public class CustomerServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String url = "/index.jsp";
        String action = req.getParameter("action");
        
        if (action == null) {
            displayCustomers(req);
        } else if ("displayCustomer".equalsIgnoreCase(action)) {
            displayCustomer(req);
            url = "/customerDetails.jsp";
        } else if ("edit".equalsIgnoreCase(action)) {
            editCustomer(req);
            url = "editCustomer.jsp";
        } else if ("save".equalsIgnoreCase(action.trim())) {
            saveCustomer(req);
        }
        req.getRequestDispatcher(url).forward(req, resp);
    }

    private void displayCustomers(HttpServletRequest request) {
        ArrayList<Customer> customers = CustomerManager.getCustomers();
        request.setAttribute("customers", customers);
    }

    private void displayCustomer(HttpServletRequest request) {
        String id = request.getParameter("id");
        Customer customer = CustomerManager.getCustomer(id);
        request.setAttribute("customer", customer);
    }

    private void editCustomer(HttpServletRequest request) {
        String id = request.getParameter("id");
        Customer customer = CustomerManager.getCustomer(id);
        request.setAttribute("customer", customer);
    }

    private void saveCustomer(HttpServletRequest request) {
        String id = request.getParameter("id");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        CustomerManager.updateCustomer(new Customer(id, firstName, lastName));
        displayCustomers(request);
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
