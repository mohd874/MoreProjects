
package com.hotel.web;

import com.hotel.model.reservation_on_error;
import com.hotel.model.reservation_validation;
import com.hotel.model.tracing_bean;
import java.io.*;
import java.util.Hashtable;

import javax.servlet.*;
import javax.servlet.http.*;

public class reservation_control extends HttpServlet {
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String msg = "";
        
        String ard = request.getParameter("date_arrival");
        String dpd = request.getParameter("date_depart");
        String flight = request.getParameter("flight");
        String ccn = request.getParameter("credit_card_no");
        String cct = request.getParameter("credit_card_type");
        int expm = Integer.parseInt(request.getParameter("expiry_month"));
        int expy = Integer.parseInt(request.getParameter("expiry_year"));
        String c = request.getParameter("confirmation");
        char cfm = c.charAt(0);
        
        System.out.println(ard+"\n"+dpd+"\n"+flight+"\n"+ccn+"\n"+cct+"\n"+expm+"\n"+expy+"\n"+c+"\n"+cfm+"\n");
        
        
        try {    
            msg += reservation_validation.validat_information(ard,dpd,flight,ccn,cct,expm,expy,cfm);
            System.out.println(msg);
        } 
        catch(NullPointerException npe) {
            System.out.println(npe.getStackTrace());
        }
        
        
        HttpSession session = request.getSession();
        RequestDispatcher view;
        
        if(msg.equals("") || msg.equals(null)){
            tracing_bean tb = (tracing_bean)request.getSession().getAttribute("tracing_bean");
            tb.setArd(reservation_validation.getFull_arrival_date());
            tb.setDpd(reservation_validation.getFull_departure_date());
            tb.setFlight(flight);
            tb.setCcn(ccn);
            tb.setCct(cct);
            tb.setExpm(expm);
            tb.setExpy(expy);
            tb.setCfm(cfm);
            System.out.println(tb.getArd()+" ' "+tb.getDpd()+" ' "+tb.getCcn()+" ' ");
            session.setAttribute("tracing_bean",tb);
            view = request.getRequestDispatcher("reservation_search_page.jsp");  
        } 
        else{
            Hashtable ht = reservation_validation.getHt();
            reservation_on_error roe = new reservation_on_error(ard,dpd,flight,ccn,cct,expm,expy,cfm,ht);
            request.setAttribute("field_values", roe);
            request.setAttribute("msg",msg);
            //request.setAttribute("");
            view = request.getRequestDispatcher("reservation.jsp");
        }
        view.forward(request, response);
    }
    
}
