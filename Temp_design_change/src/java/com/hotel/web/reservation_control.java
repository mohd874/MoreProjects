
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
        
        try{
            String msg = "";
            RequestDispatcher view = null;
            tracing_bean tb = (tracing_bean)request.getSession().getAttribute("tracing_bean");
            
            if(tb.getUtype().equalsIgnoreCase("4")){
                String ard = request.getParameter("date_arrival");
                String dpd = request.getParameter("date_depart");
                String flight = request.getParameter("flight");
                String ccn = request.getParameter("credit_card_no");
                String cct = request.getParameter("credit_card_type");
                String expm = request.getParameter("expiry_month");
                String expy = request.getParameter("expiry_year");
                
                String note = request.getParameter("note");
                String c = request.getParameter("confirmation");
                char cfm = c.charAt(0);
                
                System.out.println(ard+"\n"+dpd+"\n"+flight+"\n"+ccn+"\n"+cct+"\n"+expm+"\n"+expy+"\n"+c+"\n"+cfm+"\n"+note+"\n");
                
                
                try {
                    msg += reservation_validation.validat_information(ard,dpd,flight,ccn,cct,expm,expy,cfm);
                    System.out.println(msg);
                } catch(NullPointerException npe) {
                    System.out.println(npe.getStackTrace());
                }
                
                
                HttpSession session = request.getSession();
                
                if(msg.equals("") || msg.equals(null)){
                    tb.setArd(reservation_validation.getFull_arrival_date());
                    tb.setDpd(reservation_validation.getFull_departure_date());
                    tb.setFlight(flight);
                    tb.setCcn(ccn);
                    tb.setCct(reservation_validation.getCct());
                    tb.setExpm(Integer.parseInt(expm));
                    tb.setExpy(Integer.parseInt(expy));
                    tb.setCfm(cfm);
                    System.out.println(tb.getArd()+" ' "+tb.getDpd()+" ' "+tb.getCcn()+" ' ");
                    session.setAttribute("tracing_bean",tb);
                    view = request.getRequestDispatcher("reservation_search_page.jsp");
                } else{
                    Hashtable ht = reservation_validation.getHt();
                    reservation_on_error roe;
                    
                    try {
                        roe = new reservation_on_error(ard, dpd, flight, ccn, reservation_validation.getCct(), Integer.parseInt(expm), Integer.parseInt(expy), cfm, ht, note);
                    } catch (NumberFormatException ex) {
                        roe = new reservation_on_error(ard, dpd, flight, ccn, reservation_validation.getCct(), 0, 0, cfm, ht, note);
                    }
                    
                    request.setAttribute("field_values", roe);
                    request.setAttribute("errors",msg);
                    //request.setAttribute("");
                    view = request.getRequestDispatcher("reservation.jsp");
                }
                
            }else if(tb.getUtype().equalsIgnoreCase("3")){
                
                String customer_id = request.getParameter("user_id");
                String ard = request.getParameter("date_arrival");
                String dpd = request.getParameter("date_depart");
                String flight = request.getParameter("flight");
                String ccn = request.getParameter("credit_card_no");
                String cct = request.getParameter("credit_card_type");
                String expm = request.getParameter("expiry_month");
                String expy = request.getParameter("expiry_year");
                
                String note = request.getParameter("note");
                String c = request.getParameter("confirmation");
                char cfm = c.charAt(0);
                
                System.out.println(customer_id+"\n"+ard+"\n"+dpd+"\n"+flight+"\n"+ccn+"\n"+cct+"\n"+expm+"\n"+expy+"\n"+c+"\n"+cfm+"\n"+note+"\n");
                
                //validate value
                try{
                    msg += reservation_validation.validat_information(ard,dpd,flight,ccn,cct,expm,expy,cfm);
                    System.out.println("customer_id: "+customer_id);
                    reservation_validation.getHt().put("user_id","");
                    if(customer_id.equalsIgnoreCase("")){
                        msg += "Choose a customer to reserve to!!";
                        reservation_validation.getHt().put("user_id","Choose a customer to reserve to!!");
                    }
                    System.out.println(msg);
                }catch (NullPointerException npe){
                    msg += "Choose a customer to reserve to!!";
                }
                HttpSession session = request.getSession();
                
                if(msg.equals("") || msg.equals(null)){
                    tb.setCustomer_id(customer_id);
                    tb.setArd(reservation_validation.getFull_arrival_date());
                    tb.setDpd(reservation_validation.getFull_departure_date());
                    tb.setFlight(flight);
                    tb.setCcn(ccn);
                    tb.setCct(reservation_validation.getCct());
                    tb.setExpm(Integer.parseInt(expm));
                    tb.setExpy(Integer.parseInt(expy));
                    tb.setCfm(cfm);
                    System.out.println(tb.getArd()+" ' "+tb.getDpd()+" ' "+tb.getCcn()+" ' ");
                    session.setAttribute("tracing_bean",tb);
                    view = request.getRequestDispatcher("reservation_search_page.jsp");
                } else{
                    Hashtable ht = reservation_validation.getHt();
                    reservation_on_error roe;
                    
                    try {
                        roe = new reservation_on_error(ard, dpd, flight, ccn, reservation_validation.getCct(), Integer.parseInt(expm), Integer.parseInt(expy), cfm, ht, note, customer_id);
                    } catch (NumberFormatException ex) {
                        roe = new reservation_on_error(ard, dpd, flight, ccn, reservation_validation.getCct(), 0, 0, cfm, ht, note, customer_id);
                    }
                    
                    request.setAttribute("field_values", roe);
                    request.setAttribute("errors",msg);
                    //request.setAttribute("");
                    view = request.getRequestDispatcher("reservation_reseptionist.jsp");
                }
            }else{
                view = request.getRequestDispatcher("home.jsp");
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
