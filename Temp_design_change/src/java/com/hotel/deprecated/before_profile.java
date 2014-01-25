package com.hotel.deprecated;

import com.hotel.model.DB_Control;
import com.hotel.model.tracing_bean;
import java.io.*;
import java.sql.SQLException;
import java.util.SortedMap;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

public class before_profile extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        tracing_bean tb = (tracing_bean)request.getSession().getAttribute("tracing_bean");
        RequestDispatcher view;
        
        if(!tb.getUtype().equalsIgnoreCase("5")){
            //getting user data
            DB_Control.Open_DB_Connection();
            
            String sql_query = "select * from sysuser, customers where user_id = "+ tb.getUserID() +
                               " and user_id = customer_id";
            System.out.println(sql_query);
            Result res = null;
            try {
                res = ResultSupport.toResult(DB_Control.execute_sql_query(sql_query));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("number of rows: "+res.getRowCount());
            String[] columsNames = res.getColumnNames();
            SortedMap[] records = res.getRows();
            
            
            for(int i=0; i<columsNames.length; i++){
                System.out.println(columsNames[i]);
            }
            
            request.setAttribute("user_info",res);
            
            view = request.getRequestDispatcher("profile.jsp");
            view.forward(request, response);
        }else{
            view = request.getRequestDispatcher("home.jsp");
            view.forward(request, response);
        }
        
    }
    
}
