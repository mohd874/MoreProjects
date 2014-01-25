
package com.hotel.web;

import com.hotel.model.DB_Control;
import com.hotel.model.services_validate;
import com.hotel.model.tracing_bean;
import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

public class services_control extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try{
            tracing_bean tb = (tracing_bean)request.getSession().getAttribute("tracing_bean");
            String msg = "";
            if(tb.getUtype().equalsIgnoreCase("4")){
                
                String service_id    = request.getParameter("service_id");//not null
                String date          = request.getParameter("date");//valide date
                String hours         = request.getParameter("hours");//valide hour
                String minuts        = request.getParameter("minuts");//valide minut
                String desc          = request.getParameter("description");//no validation
                String[] selectedRooms = request.getParameterValues("selectedRooms");//not null (will contain the reservation_id)
                
                System.out.println(service_id+"\n"+date+"\n"+hours+"\n"+minuts+"\n"+desc+"\n");
                try {
                    for(int i=0; i<selectedRooms.length; i++){
                        System.out.println(selectedRooms[i]);
                    }
                } catch(NullPointerException npe){
                    msg += "no rooms where selected!!<br>";
                }
                
                services_validate sv = new services_validate();
                msg += sv.validate(service_id,date,hours,minuts,selectedRooms);
                RequestDispatcher view;
                
                if(msg.equalsIgnoreCase("")){
                    String sql_query = "insert into service_schedule (date,time,description,reservation_id,service_no) values";
                    
                    for(int i=0; i<selectedRooms.length; i++){
                        sql_query += "('"+sv.getFullDate()+"','"+(hours+":"+minuts)+"','"+desc+"','"+selectedRooms[i]+"','"+ service_id +"')";
                        if(i<(selectedRooms.length-1)){
                            sql_query += ",";
                        }
                    }
                    System.out.println(sql_query);
                    System.out.println(DB_Control.Open_DB_Connection());
                    
                    try {
                        
                        System.out.println(DB_Control.update_database(sql_query));
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    
                    DB_Control.closeConnection();
                    response.sendRedirect("home.jsp");
                }else{
                    System.out.println(msg);
                    request.setAttribute("ht",sv.getHt());
                    
                    view = request.getRequestDispatcher("services_customer.jsp");
                    view.forward(request,response);
                }
            }else{
                
                String customer_id = request.getParameter("customers");
                String room_id = request.getParameter("rooms");
                String date_form = request.getParameter("date_from");
                String date_to = request.getParameter("date_to");
                
                String sql_query = "Select "+
                        "service_schedule.order_id,"+
                        "service_schedule.`date`,"+
                        "service_schedule.`time`,"+
                        "service_schedule.description,"+
                        "service_schedule.job_done,"+
                        "service_schedule.reservation_id,"+
                        "service_schedule.employee_id,"+
                        "service_schedule.service_no,"+
                        "sysuser.user_id,"+
                        "sysuser.name,"+
                        "sysuser.surname,"+
                        "rooms.room_id,"+
                        "rooms.room_number "+
                        
                        " From "+
                        "service_schedule"+
                        ","+
                        "rooms"+
                        ","+
                        "sysuser"+
                        ","+
                        "customer_reservation"+
                        " Where ";
                
                if(!customer_id.equalsIgnoreCase("") && !customer_id.equalsIgnoreCase(null)){
                    sql_query += " user_id = '"+ customer_id +"' AND";
                }
                if(!room_id.equalsIgnoreCase("") && !room_id.equalsIgnoreCase(null)){
                    sql_query += " rooms.room_id = '"+ room_id +"' AND";
                }
                sql_query += " service_schedule.reservation_id = customer_reservation.reservation_id AND"+
                        " sysuser.user_id = customer_reservation.customer_id AND"+
                        " rooms.room_id = customer_reservation.room_id"+
                        " order by "+
                        " service_schedule.employee_id";
                
                request.setAttribute("query",sql_query);
                System.out.println(sql_query);
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
