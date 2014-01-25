
package com.hotel.web;

import com.hotel.model.DB_Control;
import com.hotel.model.add_event_validate;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

public class add_event extends HttpServlet {
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        
        String dateF = req.getParameter("dateF");
        String dateT = req.getParameter("dateT");
        String comment = req.getParameter("comment");
        String price = req.getParameter("price");
        String desc = req.getParameter("desc");
        String name = req.getParameter("name");
        String facility = req.getParameter("facility");
        String event = req.getParameter("event");
        
        
        System.out.println( "the request ATT are: "+ dateF +" , "+ dateT +" , "+ comment +" , "+ price +" , "+ desc +" , "+ name +" , "+ facility +" , "+ event);
        
        String msg = add_event_validate.validate(dateF, dateT, comment, price, desc, name, facility, event);
        
        System.out.println("the errors: "+msg);
        
        RequestDispatcher view;
        
        if(!msg.equalsIgnoreCase("")){
            
            //preparing lists
            String sql_query;
            //getting names
            sql_query = "select user_id, name, surname from sysuser";
            Result result_names;
            result_names = ResultSupport.toResult(DB_Control.execute_sql_query(sql_query));
            req.setAttribute("result_names", result_names);
            
            //getting facilityies
            sql_query = "select * from facilities";
            Result result_facilities;
            result_facilities = ResultSupport.toResult(DB_Control.execute_sql_query(sql_query));
            req.setAttribute("result_facilities", result_facilities);
            
            //getting events
            sql_query = "select * from events";
            Result result_events;
            result_events = ResultSupport.toResult(DB_Control.execute_sql_query(sql_query));
            req.setAttribute("result_events", result_events);
            
            msg = "You have the following errors: <br>" + msg;
            req.setAttribute("msg",msg);
            view = req.getRequestDispatcher("add_event.jsp");
        }else{
            String sql_query = "insert into event_schedule (date_from, date_to, comment, total_price, description,  customer_id, facility_no, event_id)"
                    +" values ('"+ add_event_validate.getFull_dateS() +"','"+ add_event_validate.getFull_dateT() +"','"+ comment +"','"+ price +"','"+ desc +"',"+ name +","+ facility +","+ event +")";
            System.out.println(sql_query);
            DB_Control.update_database(sql_query);
            DB_Control.closeConnection();
            view = req.getRequestDispatcher("home.jsp");
        }
        view.forward(req, resp);
    }
    
}
