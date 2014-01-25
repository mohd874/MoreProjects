
package com.hotel.web;

import com.hotel.model.DB_Control;
import com.hotel.model.tracing_bean;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class reservation_update extends HttpServlet {
    
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        
        tracing_bean tb = (tracing_bean) request.getSession().getAttribute("tracing_bean");
        String msg = DB_Control.Open_DB_Connection();
        System.out.println("ERRORS WHILE OPENING THE DB CONNECTION: "+msg);
        RequestDispatcher view;
        /*
         *insert  into customer_reservation (arrival_date, depart_date, flight_number, confirmation, note, credit_card_no,
                                             credit_card_type, credit_card_exp_month, credit_card_exp_year, customer_id,
                                             room_id)
          values ('2006-11-12', '2006-11-14', 'e000','y','test','6549858574692938','visa','2','2009','4','5')
         */
        if(msg.equalsIgnoreCase("")){
            System.out.println("START INSERTING THE DATA.....");
            String sql_query = "insert  into customer_reservation (arrival_date, depart_date, flight_number, confirmation, note, credit_card_no,"
                    +"credit_card_type, credit_card_exp_month, credit_card_exp_year, customer_id,"
                    +"room_id)"
                    +"values ";
            
            for(int i=0; i<tb.rooms_id.length; i++){
                sql_query += "('"+ tb.getArd() +"', '"+ tb.getDpd() +"', '"+ tb.getFlight()
                +"','"+ tb.getCfm() +"','note','"+ tb.getCcn() +"','"+ tb.getCct()
                +"','"+ tb.getExpm() +"','"+ tb.getExpy() +"','"+ tb.getUserID() +"','"+ tb.rooms_id[i] +"')";
                if(i<(tb.rooms_id.length - 1)){
                    sql_query += ", ";
                }
            }
            sql_query += ";";
            System.out.println(sql_query);
            
            int changedRows = DB_Control.update_database(sql_query);
            System.out.println("The number of changed rows is: " + changedRows);
            view = request.getRequestDispatcher("reservation_thnx.jsp");
            System.out.println("FINISHING INSERTING THE DATA.....");
        }else{
            System.out.println("AN ERROR OCCURED WHILE INSERTING THE DATA.....");
            view = request.getRequestDispatcher("error.jsp");
        }
        DB_Control.closeConnection();
        view.forward(request, response);
    }
}
