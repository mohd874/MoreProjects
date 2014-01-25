/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.control;

import com.me.db.EmployeeManager;
import com.me.model.Employee;
import com.me.util.ValidationUtil;
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
public class AddEmployee extends HttpServlet {

    EmployeeManager manager = new EmployeeManager();

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/index.jsp";

        String action = request.getParameter("action");
        request.setAttribute("departmentsList", manager.getAllDepartments());
        if (action == null) {
        //do nothing
        } else if ("add".equalsIgnoreCase(action.trim())) {
            Employee emp = validateEmployee(request);
            if (emp != null) {
                request.setAttribute("msg", "Employee was added successfully");
            }
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    private Employee validateEmployee(HttpServletRequest request) {
        Employee emp = null;
        List<String> errors = new ArrayList<String>();

        String idString = request.getParameter("id");
        String firstName = request.getParameter("fName");
        String lastName = request.getParameter("lName");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");
        String departmentString = request.getParameter("department");

        int id = 0, department = 0;

        try {
            if (idString == null || idString.equalsIgnoreCase("")) {
                errors.add("Employee id is required");
            } else {
                id = Integer.parseInt(idString);
                if (idString.length() != 4) {
                    errors.add("Employee id must be four numbers only");
                } else if (manager.getEmployeeById(id) != null) {
                    errors.add("Employee id is already used");
                }
            }
        } catch (NumberFormatException ex) {
            errors.add("Invalid employee id");
        }

        try {
            department = Integer.parseInt(departmentString);
        } catch (NumberFormatException ex) {
            errors.add("Invalid department");
        }

        if (firstName == null || firstName.trim().equalsIgnoreCase("")) {
            errors.add("First Name is required");
        }

        if (lastName == null || lastName.trim().equalsIgnoreCase("")) {
            errors.add("Last Name is required");
        }

        if (email == null || email.trim().equalsIgnoreCase("")) {
            errors.add("Email is required");
        } else {
            if (!ValidationUtil.validateEmail(email)) {
                errors.add("Email is invalid");
            }
        }

        if (errors.size() > 0) {
            request.setAttribute("id", idString);
            request.setAttribute("fName", firstName);
            request.setAttribute("lName", lastName);
            request.setAttribute("email", email);
            request.setAttribute("mobile", mobile);
            request.setAttribute("address", address);
            request.setAttribute("department", departmentString);
            request.setAttribute("errors", errors);
        } else {
            emp = new Employee(id, department, firstName, lastName, email, address, mobile);
            manager.addEmployee(emp);
        }
        return emp;
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
