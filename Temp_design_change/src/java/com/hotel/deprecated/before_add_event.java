package com.hotel.deprecated;

import com.hotel.model.DB_Control;
import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

public class before_add_event extends HttpServlet {
   
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        
        DB_Control.Open_DB_Connection();
        
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
        
        //req.setAttribute("msg",req.getParameter("msg"));
        /*
        try {
         
            while(res.next()){
                System.out.println(res.getString("name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        */
        
        
        RequestDispatcher view = req.getRequestDispatcher("add_event.jsp");
        view.forward(req, resp);
    }
    
}
