
package com.hotel.web;

import com.hotel.model.DB_Control;
import com.hotel.model.event_search_validate;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

public class events_control extends HttpServlet {
    
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        
        String act = request.getParameter("act");
        RequestDispatcher view;
        String sql_query;
        if(act.equalsIgnoreCase("s")){
            
            
            String dateS  = request.getParameter("dateF");
            String dateT  = request.getParameter("dateT");
            String minP   = request.getParameter("minP");
            String maxP   = request.getParameter("maxP");
            String c_name = request.getParameter("c_name");
            String typeF  = request.getParameter("typeF");
            String typeE  = request.getParameter("typeE");
            
            
            //validation
            System.out.println("Servelte :" + dateS);
            event_search_validate ec = new event_search_validate();
            sql_query = ec.create_search_query(dateS,dateT,minP,maxP,c_name,typeF,typeE);
            
            System.out.println(sql_query);
            
            System.out.println( DB_Control.Open_DB_Connection());
            
            ResultSet res = DB_Control.execute_sql_query(sql_query);
            
            if(res == null){
                System.out.println("servlet: res is null");
            }else{
                try {
                    while(res.next()){
                        System.out.println( res.getString("total_price"));
                    }
                    res.beforeFirst();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            
            Result res1 = ResultSupport.toResult(res);
            request.setAttribute("results1",res1);
            //System.out.println("the number of rows in res1 is: "+res1.getRowCount());
            request.setAttribute("results",res);
            
            //HttpSession session = request.getSession();
            //session.setAttribute("results",res);
            
            view = request.getRequestDispatcher("events.jsp");
            //DB_Control.closeConnection();
            view.forward(request, response);
            
            
        }else if(act.equalsIgnoreCase("e")){
            
            //preparing the event_schedule records
            String[] selectedResults = request.getParameterValues("selectedResults");
            sql_query = "select * from event_schedule where appointment_no in (";
            for (int i=0; i<selectedResults.length; i++){
                sql_query += "'"+ selectedResults[i] +"'";
                if(i<(selectedResults.length -1)){
                    sql_query += ",";
                }
            }
            sql_query += ")";
            System.out.println("the appointments query is: "+sql_query);
            
            Result appointments = ResultSupport.toResult(DB_Control.execute_sql_query(sql_query));
            //(END)preparing the event_schedule records
           
            
            //preparing names
            sql_query = "Select user_name, user_id, name, surname From sysuser where user_id in (select customer_id from customers)";
            System.out.println("the names query is: "+sql_query);
            Result names = ResultSupport.toResult(DB_Control.execute_sql_query(sql_query));
            //(END)preparing names
            
            //preparing facilities
            sql_query = "select facility_no, facility_type from facilities ";
            System.out.println("the facilities query is: "+sql_query);
            Result facilities = ResultSupport.toResult(DB_Control.execute_sql_query(sql_query));
            //(END)preparing facilities
            
            //preparing events
            sql_query = "select event_id, event_type  from events where event_id";
            System.out.println("the events query is: "+sql_query);
            Result events = ResultSupport.toResult(DB_Control.execute_sql_query(sql_query));
            //(END)preparing events
            
            
            request.setAttribute("appointments",appointments);
            request.setAttribute("names",names);
            request.setAttribute("facilities",facilities);
            request.setAttribute("events",events);
            
            view = request.getRequestDispatcher("edit_event.jsp");
            view.forward(request, response);
        }else if(act.equalsIgnoreCase("d")){
            String[] appointment_no = request.getParameterValues("selectedResults");
            System.out.println(appointment_no.length);
            System.out.println( DB_Control.Open_DB_Connection());
            for(int i=0; i<appointment_no.length; i++){
                System.out.println(i+" "+appointment_no[i]);
                sql_query = "delete from event_schedule where appointment_no = "+ appointment_no[i] +"";
                System.out.println(sql_query);
                System.out.println(i+" "+DB_Control.update_database(sql_query));
            }
            view = request.getRequestDispatcher("events.jsp");
            view.forward(request, response);
        }else{
            view = request.getRequestDispatcher("events.jsp");
            view.forward(request, response);
        }
        
    }
}