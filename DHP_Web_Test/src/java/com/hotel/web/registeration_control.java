
package com.hotel.web;

import com.hotel.model.DB_Control;
import com.hotel.model.register_validate;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

public class registeration_control extends HttpServlet {
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        String con_pass = request.getParameter("con_pass");
        String name = request.getParameter("name");
        String sur_name = request.getParameter("sur_name");
        String title = request.getParameter("title");
        String pre_phone = request.getParameter("pre_phone");
        String phone = request.getParameter("phone");
        String pre_mobile = request.getParameter("pre_mobile");
        String mobile = request.getParameter("mobile");
        String fax = request.getParameter("fax");
        String address = request.getParameter("address");
        String passport = request.getParameter("passport");
        String b_o_box = request.getParameter("b_o_box");
        String nationality = request.getParameter("nationality");
        String email = request.getParameter("email");
        String email_confirmation = request.getParameter("email_confirmation");
        
        System.out.println(uname +" ' "+ pass +" ' "+ con_pass +" ' "+ name +" ' "+ sur_name +" ' "+ title
                +" ' "+ pre_phone +" ' "+ phone +" ' "+ pre_mobile +" ' "+ mobile +" ' "+ fax +" ' "+ address +" ' "+
                b_o_box +" ' "+ nationality +" ' "+ email +" ' "+ email_confirmation);
        
        boolean all_ok = true;
        //(START)validating information
        register_validate rv = new register_validate(uname, pass, con_pass, name, sur_name, title, pre_phone, phone,
                pre_mobile, mobile, email, fax);
        
        String msg = rv.validate_info();
        //(END)validating information
        
        
        System.out.println(msg);
        RequestDispatcher view;
        
        
        
        //(START) inserting data
        
        if(!msg.equalsIgnoreCase("")){
            System.out.println("error in inserting data: "+msg);
            all_ok = false;
            view = request.getRequestDispatcher("registration.jsp");
        }else{
            
            msg = DB_Control.Open_DB_Connection();
           /*Example for insert query in sysuser table
            insert  into sysuser (user_name, password, name, surname, phone_number, mobile_number, address, 
                                   passport_number, b_o_box, nationality, user_type)
             values
             ( 'most_wanted', 'Most123', 'mohamed', 'james', '97124564566', 
               '971501231233', 'negeria the capital the third street', 'a654254642686975', '234234', 'negeria', '4')
            */
            //create insert query for sysuser
            String sql_query = "insert  into sysuser (user_name, password, name, surname, phone_number, mobile_number,"
                               +" address, passport_number, b_o_box, nationality, user_type)"
                               +"values"
                               +"( '"+ uname +"', '"+ pass +"', '"+ name +"', '"+ sur_name +"', '"+ phone +"', '"+ mobile 
                               +"', '"+ address +"', '"+ passport +"', '"+ b_o_box +"', '"+ nationality +"', '4')";
            //execute query
            System.out.println("sysuser insert query: "+sql_query);
            int complete_insert = DB_Control.update_database(sql_query);
            System.out.println("The complete_insert = "+complete_insert);
            
            if(complete_insert <= 0){
                System.out.println("error in inserting data of sys tables: " + complete_insert);
                all_ok = false;
            }
            
            //getting max id
            sql_query = "select max(user_id) from sysuser";
            System.out.println("getting max id query: "+sql_query);
            ResultSet res = DB_Control.execute_sql_query(sql_query);
            String userID = "";
            
            try {
                res.next();
                userID = res.getString("max(user_id)");
            } catch (SQLException ex) {
                ex.printStackTrace();
                all_ok = false;
                System.out.println("error while getting the user_id: "+ex.toString());
            }
            
            //create query for customers table
            sql_query = "insert into customers (customer_id, title, fax, e_mail)"
                        +"values ('"+ userID +"','"+ title +"','"+ fax +"','"+ email +"')";
            System.out.println(sql_query);
            complete_insert = DB_Control.update_database(sql_query);
            if(complete_insert <= 0){
                System.out.println("error in inserting data of customer tables: " + complete_insert);
                all_ok = false;
            }
            System.out.println("the affected row in customers table: " + complete_insert);
            
            
            //(END) inserting data
            if(all_ok = true){
                view = request.getRequestDispatcher("registration_complete.jsp");
            }else{
                view = request.getRequestDispatcher("registration.jsp");
            }
            
            view.forward(request, response);
            
            
        }
        
    }
    
    
}
