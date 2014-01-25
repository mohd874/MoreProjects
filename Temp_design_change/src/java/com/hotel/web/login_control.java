
package com.hotel.web;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.hotel.model.login_validator;
import com.hotel.model.tracing_bean;

public class login_control extends HttpServlet {
    
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        try{
            String uname = request.getParameter("uname");
            String pass = request.getParameter("pass");
            RequestDispatcher view;
            
            login_validator lc = new login_validator();
            
            boolean found = lc.login(uname, pass);
            //System.out.println("The message is: "+lc.getMsg());
            HttpSession session = request.getSession();
            
            String errors = "";
            
            if(found == true){
                String userType = lc.getUserType();
                String userID = lc.getUserID();
                String name = lc.getName();
                String surname = lc.getSurname();
                String title = lc.getTitle();
                System.out.println(userType);
                tracing_bean tb = new tracing_bean(uname, name, userType, userID, surname, title);
                
                session.setAttribute("tracing_bean",tb);
                
            }
            
            else{
                errors = lc.getMsg();
                System.out.println(errors.toString());
                
                request.setAttribute("errors", errors);
            }
            
            String url = request.getHeader("referer");
            int lastIndex = url.lastIndexOf("/");
            
            url = url.substring(lastIndex+1);
            System.out.println("the url: "+url);
            
            //this will cause an infinite loop!!!!!
            //view = request.getRequestDispatcher(url);
            
            view = request.getRequestDispatcher("home.jsp");
            view.forward(request, response);
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
