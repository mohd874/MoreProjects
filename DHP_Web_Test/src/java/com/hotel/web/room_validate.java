

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
        
        String msg = "";
        boolean pass = false;
        String [] selectedRooms = request.getParameterValues("selected_rooms");
        
        tracing_bean tb = (tracing_bean)request.getSession().getAttribute("tracing_bean");
        tb.setRooms_id(selectedRooms);
        
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
        
        
        
        
        //--------------(START) getting selectedRooms information--------------
        String connectionError = DB_Control.Open_DB_Connection();
        System.out.println(connectionError.toString());
        
        ResultSet res;
        int count;
        String sql_query;
        
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
            System.out.println(ex.toString());
        }
        //--------------(END) getting selectedRooms information--------------
        
        System.out.println(tb.getUname());
        
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
            request.setAttribute("msg",msg);
            view = request.getRequestDispatcher("reservation_search_page.jsp");
        }
        
        view.forward(request,response);
    }
    
}
