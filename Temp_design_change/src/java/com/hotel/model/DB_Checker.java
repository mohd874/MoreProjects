
package com.hotel.model;

import java.sql.SQLException;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DB_Checker {
    
    private Timer t;
    private String sql_query;
    private ResultSet res = null;
    private SimpleDateFormat sdf = new SimpleDateFormat();
    public DB_Checker() {
        
        t = new Timer(5000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //what should be performed every period of time
                check_finished_reservations();
                check_finished_events();
                ckeck_unconfirmed_rooms();
                check_services_reservations();
            }
        });
        
        t.start();
        
    }
    
    /*
     *------------------------------------------------------
     *------the steps to create a good check method---------
     *------------------------------------------------------
     *
     //open database connection
     DB_Control.Open_DB_Connection();
     
     //getting today date
     Date d = new Date();
     sdf.applyPattern("yyyy-MM-dd");
     
     String shortDate = sdf.format(d);
     System.out.println("The current date: "+shortDate);
     
     //preparing sql_query
     
     //execute query
     
     //getting information
     
     //insert data
     
     //close database connection
     DB_Control.closeConnection();
     *-------------------------------------------------------
     *-------------------------------------------------------
     *-------------------------------------------------------
     */
    
    
    public void check_finished_reservations(){
        Date d = new Date();
        //open database connection
        DB_Control.Open_DB_Connection();
        
        //preparing date with yyyy-MM-dd format
        
        sdf.applyPattern("yyyy-MM-dd");
        
        String shortDate = sdf.format(d);
        System.out.println("The current date: "+shortDate);
        /*
        year = Integer.parseInt(shortDate.substring(0,4));
        month= Integer.parseInt(shortDate.substring(5,7));
        day  = Integer.parseInt(shortDate.substring(8,10));
         */
        //System.out.println(year+"/"+month+"/"+day);
        
        //getting records from customer_reservation where depart_date is later than current date
        sql_query = "select * from customer_reservation where depart_date < '"+shortDate+"'";
        System.out.println("select statment reservation query:"+sql_query);
        res = null;
        try {
            res = DB_Control.execute_sql_query(sql_query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        //preparing instances
        String reservation_id;
        String arrival_date;
        String depart_date;
        String flight_number;
        String confirmation;
        String note;
        String credit_card_number;
        String credit_card_type;
        String credit_card_exp_month;
        String credit_card_exp_year;
        String customer_id;
        String room_id;
        
        try {
            
            while(res.next()){
                //getting informations
                reservation_id = res.getString("reservation_id");
                depart_date = res.getString("depart_date");
                arrival_date = res.getString("arrival_date");
                flight_number = res.getString("flight_number");
                confirmation = res.getString("confirmation");
                note = res.getString("note");
                credit_card_type = res.getString("credit_card_type");
                credit_card_number = res.getString("credit_card_no");
                credit_card_exp_month = res.getString("credit_card_exp_month");
                credit_card_exp_year = res.getString("credit_card_exp_year");
                customer_id = res.getString("customer_id");
                room_id = res.getString("room_id");
                
                //insert the data to reservation_history
                sql_query = "insert into reservation_history (reservation_id, arrival_date, depart_date, flight_number, " +
                        "confirmation, note, credit_card_no, credit_card_type, credit_card_exp_month, credit_card_exp_year, " +
                        "customer_id, room_id) values ('"+reservation_id+"','"+arrival_date+"','"+depart_date+"','"+flight_number+"'," +
                        "'"+confirmation+"','"+note+"','"+credit_card_number+"','"+credit_card_type+"','"+credit_card_exp_month+"'," +
                        "'"+credit_card_exp_year+"','"+customer_id+"','"+room_id+"')";
                System.out.println("insert reservation_history query: "+sql_query);
                
                DB_Control.update_database(sql_query);
                
                //delete record from customer_reservation
                sql_query = "delete from customer_reservation where reservation_id = '"+reservation_id+"'";
                System.out.println("delete query: "+sql_query);
                
                DB_Control.update_database(sql_query);
            }
            //close database connection
            DB_Control.closeConnection();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void check_finished_events(){
        //open database connection
        DB_Control.Open_DB_Connection();
        
        //getting today date
        Date d = new Date();
        sdf.applyPattern("yyyy-MM-dd");
        
        String shortDate = sdf.format(d);
        System.out.println("The current date: "+shortDate);
        
        //preparing sql_query
        sql_query = "select * from event_schedule where date_to < '"+ shortDate +"'";
        System.out.println("select event query: "+sql_query);
        res = null;
        try {
            res = DB_Control.execute_sql_query(sql_query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        //getting information
        String appointment_no;
        String date_from;
        String date_to;
        String comment;
        String total_price;
        String description;
        String customer_id;
        String facility_no;
        String event_id;
        
        try {
            
            while(res.next()){
                
                appointment_no = res.getString("appointment_no");
                date_from = res.getString("date_from");
                date_to = res.getString("date_to");
                comment = res.getString("comment");
                total_price = res.getString("total_price");
                description = res.getString("description");
                customer_id = res.getString("customer_id");
                facility_no = res.getString("facility_no");
                event_id = res.getString("event_id");
                
                //insert data
                sql_query = "insert into event_history (appointment_no, date_from, date_to, comment, total_price, description," +
                        "customer_id, facility_no, event_id) values('"+appointment_no+"','"+date_from+"','"+date_to+"'," +
                        "'"+comment+"','"+total_price+"','"+description+"','"+customer_id+"','"+facility_no+"','"+event_id+"')";
                System.out.println("insert event_history query: "+sql_query);
                
                System.out.println("the number of chenged rows in event_history: "+DB_Control.update_database(sql_query));
                
                //delete old data
                sql_query = "delete from event_schedule where appointment_no = '"+appointment_no+"'";
                
                System.out.println("delete event_history query: "+sql_query);
                
                System.out.println("the number of chenged rows in event_schedule: "+DB_Control.update_database(sql_query));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        //close database connection
        DB_Control.closeConnection();
        
    }
    
    public void ckeck_unconfirmed_rooms(){
        //open database connection
        DB_Control.Open_DB_Connection();
        
        //getting today date
        Date d = new Date();
        sdf.applyPattern("yyyy-MM-dd");
        
        String shortDate = sdf.format(d);
        System.out.println("The current date: "+shortDate);
        
        //preparing sql_query
        sql_query = "Select " +
                "cr.reservation_id, " +
                "cr.arrival_date, " +
                "cr.depart_date, " +
                "cr.flight_number, " +
                "cr.confirmation, " +
                "cr.note, " +
                "cr.credit_card_no, " +
                "cr.credit_card_type, " +
                "cr.credit_card_exp_month, " +
                "cr.credit_card_exp_year, " +
                "cr.customer_id, " +
                "cr.room_id, " +
                "cr.check_in " +
                "From " +
                "customer_reservation AS cr " +
                "Where " +
                "cr.confirmation = 'n' " +
                "and (datediff(arrival_date,'2006-06-04')) < 2";
        
        
        //execute query
        try {
            res = DB_Control.execute_sql_query(sql_query);
            
            //preparing instances
            String reservation_id;
            String arrival_date;
            String depart_date;
            String flight_number;
            String confirmation;
            String note;
            String credit_card_number;
            String credit_card_type;
            String credit_card_exp_month;
            String credit_card_exp_year;
            String customer_id;
            String room_id;
            
            
            while(res.next()){
                
                //getting informations
                reservation_id = res.getString("reservation_id");
                depart_date = res.getString("depart_date");
                arrival_date = res.getString("arrival_date");
                flight_number = res.getString("flight_number");
                confirmation = res.getString("confirmation");
                note = res.getString("note");
                credit_card_type = res.getString("credit_card_type");
                credit_card_number = res.getString("credit_card_no");
                credit_card_exp_month = res.getString("credit_card_exp_month");
                credit_card_exp_year = res.getString("credit_card_exp_year");
                customer_id = res.getString("customer_id");
                room_id = res.getString("room_id");
                
                //insert the data to reservation_history
                sql_query = "insert into reservation_history (reservation_id, arrival_date, depart_date, flight_number, " +
                        "confirmation, note, credit_card_no, credit_card_type, credit_card_exp_month, credit_card_exp_year, " +
                        "customer_id, room_id) values ('"+reservation_id+"','"+arrival_date+"','"+depart_date+"','"+flight_number+"'," +
                        "'"+confirmation+"','"+note+"','"+credit_card_number+"','"+credit_card_type+"','"+credit_card_exp_month+"'," +
                        "'"+credit_card_exp_year+"','"+customer_id+"','"+room_id+"')";
                System.out.println("insert reservation_history query: "+sql_query);
                
                DB_Control.update_database(sql_query);
                
                //delete record from customer_reservation
                sql_query = "delete from customer_reservation where reservation_id = '"+reservation_id+"'";
                System.out.println("delete query: "+sql_query);
                
                DB_Control.update_database(sql_query);
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        //close database connection
        DB_Control.closeConnection();
    }
    
    public void check_services_reservations(){
        Date d = new Date();
        //open database connection
        DB_Control.Open_DB_Connection();
        
        //preparing date with yyyy-MM-dd format
        
        sdf.applyPattern("yyyy-MM-dd");
        
        String shortDate = sdf.format(d);
        System.out.println("The current date: "+shortDate);
        /*
        year = Integer.parseInt(shortDate.substring(0,4));
        month= Integer.parseInt(shortDate.substring(5,7));
        day  = Integer.parseInt(shortDate.substring(8,10));
         */
        //System.out.println(year+"/"+month+"/"+day);
        
        //getting records from customer_reservation where depart_date is later than current date
        sql_query = "select * from service_schedule where date < '"+shortDate+"' and job_done = 'job done : yes'";
        System.out.println("select statment services schedulequery:"+sql_query);
        res = null;
        try {
            res = DB_Control.execute_sql_query(sql_query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        //preparing instances
        String order_id;
        String date;
        String time;
        String desc;
        String reservation_id;
        String employee_id;
        String services_no;
        
        try {
            
            while(res.next()){
                //getting informations
                order_id = res.getString("order_id");
                date = res.getString("date");
                time = res.getString("time");
                desc = res.getString("description");
                reservation_id = res.getString("reservation_id");
                employee_id = res.getString("employee_id");
                services_no = res.getString("service_no");
                
                DB_Control.update_database(sql_query);
                
                //delete record from customer_reservation
                sql_query = "delete from service_schedule where order_id = '"+order_id+"'";
                System.out.println("delete query: "+sql_query);
                
                DB_Control.update_database(sql_query);
            }
            //close database connection
            DB_Control.closeConnection();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void stopTimer() {
        t.stop();
    }
    
    /*
    public int getDay() {
        day = c.DAY_OF_MONTH;
        return day;
    }
     
    public int getMonth() {
        month = c.MONTH;
        return month;
    }
     
    public int getYear() {
        //year = c.YEAR;
        year = Calendar.YEAR - 1900;
        return year;
    }
     */
}
