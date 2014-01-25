/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package email;

import com.me.model.User;
import java.io.*;
import java.net.*;

import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.http.*;
import util.MailUtilLocal;

/**
 *
 * @author Saeed
 */
public class AddToEmailListServlet extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //get parameters from request
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        
        User user = new User(firstName,lastName,email);
        request.setAttribute("user", user);
        
        //send email to user
        String to = email;
        String from = "email_list@alnahdi.com";
        String subject = "Welcome to our email list";
        String body = "Dear "+firstName+" "+lastName+", \n\n" +
                "Thanks for joining our email list. We'll make sure to send " +
                "you announcements about new products and promotions. \n" +
                "Have a great day and thanks again!\n\n" +
                "AlNahdi & Associates";
        boolean isBodyHTML = false;
        try{
            MailUtilLocal.sendMail(to,from,subject,body,isBodyHTML);
        }catch(MessagingException e){
            String errorMessage = "ERROR: Unable to send email. " +
                    "Check Tomcat logs for details.<br>" +
                    "NOTE: you may need to configure your system " +
                    "as described in chapter 15.<br>" +
                    "ERROR MESSAGE: "+e.getMessage();
            request.setAttribute("errorMessage", errorMessage);
        }

        //forward request and response to JSP Page
        String url = "/display_email_entry.jsp";
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
