package com.me.controllers;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.me.da.*;
import com.me.model.Attendee;

public class AttendeeServlet extends HttpServlet {

    AttendeeManager manager = new AttendeeManager();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.jsp";
        String action = request.getParameter("action");

        if ("add attendee".equalsIgnoreCase(action)) {
            String name = request.getParameter("name");
            String login = request.getParameter("login");
            String password = request.getParameter("password");

            Attendee attendee = new Attendee(-1, login, password, name);
            manager.addAttendee(attendee);
        } else if ("add email".equalsIgnoreCase(action)) {
            String id = request.getParameter("id");
            if (id == null) {
                request.setAttribute("error", "Please select an attendee");
            } else {
                String email = request.getParameter("email");
                manager.addEmailToAttendee(Integer.parseInt(id), email);
            }
        }

        request.setAttribute("attendees", manager.getAttendees());
        request.getRequestDispatcher(url).forward(request, response);
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
