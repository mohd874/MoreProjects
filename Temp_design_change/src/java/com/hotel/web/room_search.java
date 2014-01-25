
package com.hotel.web;

import com.hotel.model.room_search_engine;
import com.hotel.model.tracing_bean;
import java.io.*;
import java.sql.ResultSet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.jstl.sql.Result;

public class room_search extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        try{
            String roomT = request.getParameter("room_type");
            String roomV = request.getParameter("room_view");
            String price1 = request.getParameter("first_num");
            String price2 = request.getParameter("second_num");
            
            tracing_bean tb = (tracing_bean)request.getSession().getAttribute("tracing_bean");
            
            ResultSet res;
            Result rs;
            
            String msg = room_search_engine.room_search(roomT,roomV,price1,price2,tb.getArd(),tb.getDpd());
            RequestDispatcher view;
            
            System.out.println(msg);
            
            res = room_search_engine.getRes();
            rs = room_search_engine.getResult();
            HttpSession session = request.getSession();
            
            if(msg.equalsIgnoreCase("")){
                res = room_search_engine.getRes();
                request.setAttribute("results2",rs);
                request.setAttribute("msg",msg);
            /*tracing_bean tb = (tracing_bean)request.getSession().getAttribute("tracing_bean");
            tb.setRoomT(roomT);
            tb.setRoomV(roomV);
            tb.setPrice(room_search_engine.getPrice());
            session.setAttribute("tracing_bean",tb);*/
                
                view = request.getRequestDispatcher("reservation_search_page.jsp");
            } else{
                request.setAttribute("msg",msg);
                view = request.getRequestDispatcher("reservation_search_page.jsp");
            }
            
            view.forward(request, response);
            
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
