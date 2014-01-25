
package com.hotel.web;

import com.hotel.model.DB_Control;
import com.hotel.model.tracing_bean;
import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

public class confirmation_control extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try{
            //getting request values
            String[] action = request.getParameterValues("action");
            String[] reservation_id = request.getParameterValues("reservation_id");
            //open database connection
            DB_Control.Open_DB_Connection();
            
            //prepare variables
            String msg = "";
            int confirm_count = 0, cancel_count = 0;
            String sql_query = "";
            tracing_bean tb = (tracing_bean)request.getSession().getAttribute("tracing_bean");
            
            //create sql_query and exceute it
            for(int i=0; i<action.length; i++){
                sql_query = "";
                //if the room was confirmed
                if(action[i].equalsIgnoreCase("confirm")){
                    System.out.println("room  number "+action[i]+" was confirmed!");
                    sql_query = "update customer_reservation set confirmation = 'y' where reservation_id = '"+reservation_id[i]+"' and customer_id = '"+tb.getUserID()+"' ";
                    System.out.println("sql query for room confirmation: "+sql_query);
                    confirm_count++;
                }
                //if the room was canceled
                else if(action[i].equalsIgnoreCase("cancel")){
                    System.out.println("room  number "+action[i]+" was canceled!");
                    sql_query = "delete from customer_reservation where reservation_id = '"+reservation_id[i]+"' and customer_id = '"+tb.getUserID()+"' ";
                    System.out.println("sql query for room confirmation: "+sql_query);
                    cancel_count++;
                }
                
                try {
                    DB_Control.update_database(sql_query);
                } catch (SQLException ex) {
                    //eception in case of sql faliuer
                    //ex.printStackTrace();
                    msg = "An error occur while updating the database in confirmation control: "+ex;
                    break;
                }
                
            }
            
            //creating status massege
            RequestDispatcher view;
            if(!msg.equalsIgnoreCase("")){
                request.setAttribute("status",msg);
            }else{
                msg = confirm_count+" room(s) were confirmed<br>"+cancel_count+" room(s) were canceled";
                request.setAttribute("status",msg);
            }
            
            //forward to reservation_confirmation.jsp
            view = request.getRequestDispatcher("reservation_confirmation.jsp");
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
