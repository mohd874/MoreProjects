
package com.hotel.web;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.hotel.model.login_validator;
import com.hotel.model.tracing_bean;

public class login_control extends HttpServlet {
    
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

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
        System.out.println(userType);
        tracing_bean tb = new tracing_bean(uname, userType, userID);
        
        session.setAttribute("tracing_bean",tb);
        /*request.setAttribute("uname", uname);
         *request.setAttribute("utype", userType);
         */
        view = request.getRequestDispatcher("home.jsp");
        }
        
        else{
        errors = "The errors are: "+lc.getMsg();
        System.out.println(errors.toString());
        
        request.setAttribute("errors", errors);
        
        view = request.getRequestDispatcher("login.jsp");
        }
       
        
        session.setAttribute("errors", errors);
        view.forward(request, response);
    }
    
}
