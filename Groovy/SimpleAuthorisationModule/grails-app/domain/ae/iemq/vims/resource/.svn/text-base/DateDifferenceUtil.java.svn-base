package ae.iemq.vims.resource;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import ae.iemq.vims.domain.Period;
 
/**
 * @author WB308415 srireddy
 * 
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 * 
 * This code was taken from:
 * http://forum.java.sun.com/thread.jspa?forumID=54&threadID=748690
 */


public class DateDifferenceUtil {
	
	public static void main(String[] args) {
		Date fromDate = new Date(System.currentTimeMillis());
		// fromDate is "System Current Date"
		Calendar calendar = Calendar.getInstance();
		calendar.set(2006, 10, 06);
		/*
		 * 2006:-> Year
		 * 10  :-> November 
		 * 06  :-> Date
		 */
		Date toDate = calendar.getTime();
		System.out.println("Date Difference");
		System.out.println("from " + fromDate);
		System.out.println(" to  " + toDate);
		System.out.println(" Total days are: "
				+ getDateDifferenceInDays(fromDate, toDate) + " Days.");
		System.out.println(" Total No. of working days are : "
				+ getDateDifferenceInDaysExcludingSatSun(fromDate, toDate) + " Days.");
	}
 
	public static int getDateDifferenceInDays(Date fromDate, Date toDate) {
		if (fromDate == null || toDate == null) {
			return 0;
		}
		boolean neglect = false;
		int calUnit = Calendar.DATE;
		if (fromDate.after(toDate)) {
			// swaps the date if fromDate is after toDate
			Date temp = fromDate;
			fromDate = toDate;
			toDate = temp;
			neglect = true;
		}
		// estimate the diff. d1 is now guaranteed <= d2
		int estimate = getEstDiff(calUnit, fromDate, toDate);
		// convert the Dates to GregorianCalendars
		GregorianCalendar calendar1 = new GregorianCalendar();
		calendar1.setTime(fromDate);
		GregorianCalendar calendar2 = new GregorianCalendar();
		calendar2.setTime(toDate);
		calendar1.add(calUnit, (int) estimate - 2);
		for (int iterate = estimate - 1;; iterate++) {
			calendar1.add(calUnit, 1);
			if (calendar1.after(calendar2)) {
				if (neglect) {
					return 1 - iterate;
				} else {
					return iterate ;
				}
			}
		}
	}
 
	private static int getEstDiff(int calUnit, Date d1, Date d2) {
		double aDAY_MILLIS = 1000 * 60 * 60 * 24.0015;
		double aWEEK_MILLIS = aDAY_MILLIS * 7;
		double aMONTH_MILLIS = aDAY_MILLIS * 30.43675;
		double aYEAR_MILLIS = aWEEK_MILLIS * 52.2;
		long diff = d2.getTime() - d1.getTime();
		switch (calUnit) {
		case Calendar.DAY_OF_WEEK_IN_MONTH:
		case Calendar.DAY_OF_MONTH:
			return (int) (diff / aDAY_MILLIS + .5);
		case Calendar.WEEK_OF_YEAR:
			return (int) (diff / aWEEK_MILLIS + .5);
		case Calendar.MONTH:
			return (int) (diff / aMONTH_MILLIS + .5);
		case Calendar.YEAR:
			return (int) (diff / aYEAR_MILLIS + .5);
		default:
			return 0;
		}
	}
 
	public static int getDateDifferenceInDaysExcludingSatSun(Date fromDate,Date toDate)
	{
		if (fromDate == null || toDate == null) {
			return 0;
		}
		if (fromDate.after(toDate)) {
			Date temp = fromDate;
			fromDate = toDate;
			toDate = temp;
		}
		Calendar calFrom = Calendar.getInstance();
		calFrom.setTime(fromDate);
		Calendar calTo = Calendar.getInstance();
		calTo.setTime(toDate);
		int iNoOfWorkingDays = 0;
		do {
			if (calFrom.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
			&& calFrom.get(Calendar.DAY_OF_WEEK) != Calendar.FRIDAY) {
				iNoOfWorkingDays += 1;
			}
			calFrom.add(Calendar.DATE, 1);
		} while (calFrom.getTimeInMillis() < calTo.getTimeInMillis());
		return iNoOfWorkingDays;
	}
	
	public static boolean isBetween (Date compare, Period period){
		if (compare.after(period.startDate)&&compare.before(period.endDate)) return true;
		else return false;
	}
	

	
}

