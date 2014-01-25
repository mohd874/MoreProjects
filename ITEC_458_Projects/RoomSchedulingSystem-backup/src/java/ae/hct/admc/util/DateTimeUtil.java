/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ae.hct.admc.util;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Saeed
 */
public class DateTimeUtil {

    public static Date getWeekStartDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (cal.get(cal.DAY_OF_WEEK) != cal.SATURDAY) {
            cal.set(cal.DAY_OF_YEAR, -cal.get(cal.DAY_OF_WEEK));
        }
        return cal.getTime();
    }

    public static Date getWeekEndDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (cal.get(cal.DAY_OF_WEEK) != cal.FRIDAY) {
            cal.add(cal.DAY_OF_YEAR, (cal.SATURDAY - 1));
        }
        return cal.getTime();
    }
    
    public static int getNumberOfWeeksBetweenDates(Date startDate,Date endDate){
        int numberOfWeeks = 0;
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        
        while(cal.getTime().before(endDate)){
            numberOfWeeks++;
            cal.add(cal.DAY_OF_YEAR, 7);
        }
        return numberOfWeeks;
    }
    
    public static void addDaysToCalendar(Calendar c, int numberOfDays){
        c.add(c.DAY_OF_YEAR, numberOfDays);
    }
    
}
