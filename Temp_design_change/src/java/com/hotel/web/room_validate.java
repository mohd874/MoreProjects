

package com.hotel.web;

import com.hotel.model.DB_Control;
import com.hotel.model.tracing_bean;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.servlet.*;
import javax.servlet.http.*;


public class room_validate extends HttpServlet {
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try{
            String msg = "";
            boolean pass = true;
            String [] selectedRooms = request.getParameterValues("selected_rooms");
            
            if(selectedRooms.length <= 0){
                msg += "please select a room!!";
                request.setAttribute("errors",msg);
                RequestDispatcher view = request.getRequestDispatcher("reservation_search_page.jsp");
                view.forward(request, response);
            }
            
            tracing_bean tb = (tracing_bean)request.getSession().getAttribute("tracing_bean");
            tb.setRooms_id(selectedRooms);
        /*
        if(selectedRooms.length < 1){
            System.out.println("there is no rooms selected");
            msg += "there is no rooms selected";
            pass = false;
        } else{
            pass = true;
            for(int i=0; i < selectedRooms.length; i++){
                System.out.println("this is the numbers from the request: ");
                System.out.println(selectedRooms[i]);
                System.out.println("this is the numbers from the bean: ");
                System.out.println(tb.rooms_id[i]);
            }
        }
         */
            String connectionError = DB_Control.Open_DB_Connection();
            System.out.println(connectionError.toString());
            
            ResultSet res = null;
            int count = 0;
            String sql_query;
            
            //--------------(START)Double check----------------
            sql_query = "select room_id, room_type, room_view, room_price from rooms where ";
            sql_query += "room_id not in (select room_id from customer_reservation where ";
            sql_query += "arrival_date between '"+ tb.getArd() +"' and '"+ tb.getDpd() +"' or " +
                    "depart_date between '"+ tb.getArd() +"' and '"+ tb.getDpd() +"' or " +
                    "'"+ tb.getArd() +"' between arrival_date and depart_date or " +
                    "'"+ tb.getDpd() +"' between arrival_date and depart_date) and " +
                    "room_id in (";
            
            for(int i=0; i<selectedRooms.length; i++){
                
                sql_query += "'"+selectedRooms[i]+"'";
                if((i+1) < selectedRooms.length){
                    sql_query += ",";
                }
                
            }
            sql_query += ")";
            System.out.println(sql_query);
            try {
                res = DB_Control.execute_sql_query(sql_query);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                while(res.next()){
                    count++;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
            System.out.println("selectedRooms.length: "+selectedRooms.length);
            System.out.println("count: "+count);
            
            if(count < selectedRooms.length){
                msg += "Some of your rooms where reserved by another customer while you were selecting, please select another room\n" +
                        "We apologize for the inconvenient";
                request.setAttribute("errors",msg);
                RequestDispatcher view = request.getRequestDispatcher("reservation_search_page.jsp");
                view.forward(request, response);
            }
            //--------------(END)Double check----------------
            
            
            //--------------(START) getting selectedRooms information--------------
            
            String[] Rtype = new String[selectedRooms.length];
            String[] Rview = new String[selectedRooms.length];
            String[] Rprice = new String[selectedRooms.length];
            
            try {
                for(int i=0; i < selectedRooms.length; i++){
                    sql_query = "select * from rooms where room_id = '"+selectedRooms[i]+"'";
                    res = DB_Control.execute_sql_query(sql_query);
                    res.next();
                    
                    Rtype[i] = res.getString("room_type");
                    Rview[i] = res.getString("room_view");
                    Rprice[i] = res.getString("room_price");
                }
                tb.setRoomT(Rtype);
                tb.setRoomV(Rview);
                tb.setPrice(Rprice);
                
            } catch (SQLException ex) {
                pass = false;
                msg += ex.toString();
                System.out.println(ex.toString());
            }
            
            //--------------(END) getting selectedRooms information--------------
            
            //System.out.println(tb.getUname());
            
            for(int i=0; i<Rprice.length; i++){
                System.out.println(Rtype[i]);
            }
            
            HttpSession session = request.getSession();
            RequestDispatcher view;
            
            if(pass == true){
                //String sql_query = "insert into customer_reservation (arrival_date,depart_date,flight_number,confirmation,note,credit_card_no,"
                //		+"credit_card_type,credit_card_exp_month,credit_card_exp_year,customer_id,room_id)"
                //       +"values ('2006-11-2','2006-11-9','k009','n','test','82980883','visa card','4','2007','1','3') ";
                session.setAttribute("tracing_bean",tb);
                view = request.getRequestDispatcher("reservation_check.jsp");
            }else{
                request.setAttribute("errors",msg);
                view = request.getRequestDispatcher("reservation_search_page.jsp");
            }
            
            DB_Control.closeConnection();
            view.forward(request,response);
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
