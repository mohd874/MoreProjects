
package com.hotel.web;

import com.hotel.model.DB_Control;
import java.io.*;
import java.net.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

public class services_update extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try{
            //getting data
            String[] order_id = request.getParameterValues("order_id");
            String[] emp_id   = request.getParameterValues("emp_id");
            String[] job_done = request.getParameterValues("job_done");
            
            String msg = "";
            ResultSet res = null;
            int job_done_count = 0;
            
            DB_Control.Open_DB_Connection();
            
            
            if(job_done != null){
                for(int i=0; i<job_done.length; i++){
                    System.out.println("\njob_done: "+job_done[i]);
                }
            }else{
                msg += "<br>There is no job selected!!";
            }
            
            String job_update = "";
            if(msg.equalsIgnoreCase("")){
                for(int i=0; i<job_done.length; i++){
                    if(!job_done[i].equalsIgnoreCase("")){
                        try {
                            res = DB_Control.execute_sql_query("select employee_id from service_schedule where order_id = '"+job_done[i]+"'");
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        
                        try {
                            res.next();
                            if(res.getString("employee_id").equalsIgnoreCase(null)){
                                job_done_count++;
                            }else{
                                System.out.println(DB_Control.update_database("update service_schedule set " +
                                        "job_done = 'job done : yes' where order_id = '"+job_done[i]+"'"));
                            }
                            
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } catch (NullPointerException npe){
                            job_done_count++;
                        }
                    }
                }
                job_update = job_done_count+" job(s) were updated!!<br>";
                request.setAttribute("update",job_update);
            }
            
            
            
            if(order_id != null){
                for(int i=0; i<order_id.length; i++){
                    System.out.println("\norder_id: "+order_id[i]);
                }
            }else{
                msg += "<br>There is no selected order!!";
            }
            if(emp_id != null){
                for(int i=0; i<emp_id.length; i++){
                    System.out.println("\nemp_id: "+emp_id[i]);
                }
            }else{
                msg += "<br>There is no employee selected!!";
            }
            
            
            if(!msg.equalsIgnoreCase("")){
                request.setAttribute("errors",msg);
                RequestDispatcher view = request.getRequestDispatcher("services_officer.jsp");
                view.forward(request, response);
            }
            
            
            
            
            boolean match = true;
            int assign_count = 0;
            
            String[] toBeUsed_order_id = new String[order_id.length];
            String[] toBeUsed_emp_id = new String[order_id.length];
            
            
            //filtring the correctly assigned jobs
            for(int i=0; i<order_id.length; i++){
                if(order_id[i].equalsIgnoreCase("") || emp_id[i].equalsIgnoreCase("")){
                    assign_count++;
                    
                }else{
                    toBeUsed_emp_id[i] = emp_id[i];
                    toBeUsed_order_id[i] = order_id[i];
                    
                }
                if(order_id[i].equalsIgnoreCase("") && emp_id[i].equalsIgnoreCase("")){
                    assign_count--;
                }
            }
            
            
            
            
            System.out.println(job_done_count);
            if(assign_count > 0){
                match = false;
            }
            
            
            
            System.out.println("to be useed------");
            for(int i=0; i<toBeUsed_order_id.length; i++){
                System.out.println("//////////////");
                System.out.println(toBeUsed_order_id[i]);
                System.out.println(toBeUsed_emp_id[i]);
                System.out.println("//////////////");
            }
            System.out.println("to be useed------");
            System.out.println(match+" "+assign_count);
            String sql_query = "";
            
            
            for(int i=0; i<toBeUsed_emp_id.length; i++){
                sql_query = "update service_schedule set employee_id = '"+toBeUsed_emp_id[i]+"' where order_id = '"+toBeUsed_order_id[i]+"'";
                try{
                    System.out.println(i + DB_Control.update_database(sql_query));
                } catch(SQLException sqle){
                    sqle.printStackTrace();
                    msg += "an error occour while updating the services!!"+sqle.toString();
                }
            }
            
            DB_Control.closeConnection();
            if(job_done_count > 0){
                msg += job_done_count+" job(s) cannot be finished unlease they are assigned!!";
            }
            if(match == false){
                msg = assign_count+" orders were not assigned because either employee or aassign are not choosen!!<br>" ;
                
                System.out.println("msg = "+msg);
                request.setAttribute("errors",msg);
                RequestDispatcher view = request.getRequestDispatcher("services_officer.jsp");
                view.forward(request, response);
            }else{
                request.setAttribute("errors",msg);
                RequestDispatcher view = request.getRequestDispatcher("services_officer.jsp");
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
