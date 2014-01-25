/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sketchapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saeed
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
//        Calendar newCal = Calendar.getInstance();
//        int day = newCal.get( newCal.DAY_OF_WEEK );
//        System.out.println(day);
//        System.out.println(newCal.FRIDAY);
            /************get week number from date************/
            SimpleDateFormat sdf;
            Calendar cal;
            Date date;
            int week;
            String sample = "05/05/2008";
            sdf = new SimpleDateFormat("MM/dd/yyyy");
            date = sdf.parse(sample);
            cal = Calendar.getInstance();
            cal.setTime(date);
            week = cal.get(Calendar.WEEK_OF_YEAR);
            
            System.out.println("week: "+week);
            System.out.println("Sat: "+Calendar.SATURDAY);
            System.out.println("Sun: "+Calendar.SUNDAY);
            System.out.println("Mon: "+Calendar.MONDAY);
            System.out.println("Tue: "+Calendar.TUESDAY);
            System.out.println("Wen: "+Calendar.WEDNESDAY);
            System.out.println("Thu: "+Calendar.THURSDAY);
            System.out.println("Fri: "+Calendar.FRIDAY);
            
            System.out.println("Todays day: "+cal.getDisplayName(cal.DAY_OF_WEEK
                    , cal.LONG, Locale.getDefault()));
            
            cal.add(cal.DAY_OF_YEAR, -cal.get(cal.DAY_OF_WEEK));
            System.out.println("add: "+-cal.get(cal.DAY_OF_WEEK));
            System.out.println("Start Date: "+cal.getDisplayName(cal.DAY_OF_WEEK
                    , cal.LONG, Locale.getDefault())+"" +
                    " "+cal.getTime());
            cal.add(cal.DAY_OF_YEAR, (cal.SATURDAY-1));
            System.out.println("add: "+(cal.SATURDAY-1));
            System.out.println("End   Date: "+cal.getDisplayName(cal.DAY_OF_WEEK
                    , cal.LONG, Locale.getDefault())+"" +
                    " "+cal.getTime());
            
            cal = Calendar.getInstance();
            
            System.out.println("Todays day: "+cal.getDisplayName(cal.DAY_OF_WEEK
                    , cal.LONG, Locale.getDefault()));
            
            Map map = new HashMap();
            
            String s = (String)map.get("string");
            System.out.println(""+s);
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
