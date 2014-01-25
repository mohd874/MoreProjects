
package com.hotel.web;

import com.hotel.model.DB_Control;
import com.hotel.model.special_charectars_validation_class;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;
import java.io.*;
import java.net.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

public class check_in extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try{
            //get and reset values
            Hashtable ht = new Hashtable();
            special_charectars_validation_class scvc = new special_charectars_validation_class();
            
            String[] reservation_id = request.getParameterValues("reservation_id");
            String msg = "";
            ht.put("reservations_id","");
            
            try{
                
                if(reservation_id.length <= 0){
                    msg += "There is no selected room(s)!!";
                    ht.put("reservation_id","There is no selected room(s)!!");
                }else{
                    int i= -1;
                    while(reservation_id.length > (i+1) ){
                        i++;
                        System.out.println("the IDs for the selected rooms: "+reservation_id[i]);
                        if( scvc.validate(reservation_id[i]) == false){
                            msg += "special character error";
                            ht.put("reservation_id","one of the selected rooms has one or more special character!!");
                        }
                    }
                }
                
            }catch(NullPointerException npe){
                msg += "There is no selected room(s)!!";
                ht.put("reservation_id","There is no selected room(s)!!");
            }
            
            
            System.out.println(msg);
            
            if(msg.equalsIgnoreCase("")){
                
                DB_Control.Open_DB_Connection();
                
                String sql_query = "";
                
                int i= -1;
                while(reservation_id.length > (i+1) ){
                    i++;
                    sql_query = "update customer_reservation set check_in = 'y' where reservation_id = '"+ reservation_id[i] +"' ";
                    
                    try {
                        
                        DB_Control.update_database(sql_query);
                        
                    } catch (SQLException ex) {
                        msg += "sql error: "+ex;
                        System.out.println(msg);
                        ht.put("reservation_id","sql error: "+ex);
                        request.setAttribute("ht",ht);
                        RequestDispatcher view = request.getRequestDispatcher("check.jsp");
                        view.forward(request, response);
                        break;
                    }
                }
                
                DB_Control.closeConnection();
                msg += (i+1)+" reservation(s) were checked as IN ";
                request.setAttribute("status",msg);
                RequestDispatcher view = request.getRequestDispatcher("check.jsp");
                view.forward(request, response);
                
            }else{
                request.setAttribute("errors",msg);
                RequestDispatcher view = request.getRequestDispatcher("check.jsp");
                view.forward(request, response);
                
            }
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
