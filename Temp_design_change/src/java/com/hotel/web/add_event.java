
package com.hotel.web;

import com.hotel.model.DB_Control;
import com.hotel.model.add_event_validate;
import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

public class add_event extends HttpServlet {
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        
        try{
            
            String dateF = req.getParameter("dateF");
            String dateT = req.getParameter("dateT");
            String comment = req.getParameter("comment");
            String price = req.getParameter("price");
            String desc = req.getParameter("desc");
            String name = req.getParameter("name");
            String facility = req.getParameter("facility");
            String event = req.getParameter("event");
            String home_show = req.getParameter("home_show");
            
            
            System.out.println( "the request ATT are: "+ dateF +" , "+ dateT +" , "+ comment +" , "+ price +" , "+ desc +" , "+ name +" , "+ facility +" , "+ event);
            
            String msg = add_event_validate.validate(dateF, dateT, comment, price, desc, name, facility, event, home_show);
            
            System.out.println("the errors: "+msg);
            
            RequestDispatcher view;
            
            if(!msg.equalsIgnoreCase("")){
                
            /*-----------------------------------------------------
             *--------replaced by SQL Tags in add_event.jsp--------
             *-----------------------------------------------------
            //preparing lists
            String sql_query;
             
            //getting names
            sql_query = "select user_id, name, surname from sysuser";
            Result result_names = null;
            try {
                result_names = ResultSupport.toResult(DB_Control.execute_sql_query(sql_query));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            req.setAttribute("result_names", result_names);
             
            //getting facilityies
            sql_query = "select * from facilities";
            Result result_facilities = null;
            try {
                result_facilities = ResultSupport.toResult(DB_Control.execute_sql_query(sql_query));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            req.setAttribute("result_facilities", result_facilities);
             
            //getting events
            sql_query = "select * from events";
            Result result_events = null;
            try {
                result_events = ResultSupport.toResult(DB_Control.execute_sql_query(sql_query));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            req.setAttribute("result_events", result_events);
             
             -----------------------------------------------------*
             --------replaced by SQL Tags in add_event.jsp--------*
             -----------------------------------------------------*/
                
                msg = "You have the following errors: <br>" + msg;
                req.setAttribute("msg",msg);
                req.setAttribute("ht",add_event_validate.getHt());
                view = req.getRequestDispatcher("add_event.jsp");
            }else{
                String sql_query = "insert into event_schedule (date_from, date_to, comment, total_price, description,  customer_id, facility_no, event_id, home_show)"
                        +" values ('"+ add_event_validate.getFull_dateS() +"','"+ add_event_validate.getFull_dateT() +"','"+ comment +"','"+ price +"','"+ desc +"','"+ name +"','"+ facility +"','"+ event +"','"+ home_show +"')";
                System.out.println(sql_query);
                
                try {
                    DB_Control.update_database(sql_query);
                } catch(SQLException sqle) {
                    sqle.printStackTrace();
                    msg += "there eas an error while inserting event data into the database, please try after some time!!";
                    req.setAttribute("errors",msg);
                    view = req.getRequestDispatcher("add_event.jsp");
                }
                
                msg += "The event was entered sucssefuly";
                req.setAttribute("status",msg);
                DB_Control.closeConnection();
                view = req.getRequestDispatcher("events.jsp");
            }
            view.forward(req, resp);
            
        } catch (Exception ex) {
            try {
                System.out.println("Error: "+ex);
                sendErrorRedirect(req,resp,"/error.jsp",ex);
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
