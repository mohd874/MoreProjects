/*
 * Copyright (c) IeMQ.
 * All rights reserved.
 */
package ae.iemq.vims.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import ae.iemq.vims.domain.Period;

/**
 * Date Utilities.
 */
public final class DateUtil {

	/**
	 * The default format of a date.
	 */
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

	/**
	 * Empty private constructor.
	 */
	public DateUtil() {
	}

	public static boolean periodsIntersect(Period periodOne, Period periodTwo) {
		return intervalsIntersect(periodOne.startDate, periodOne.endDate,
				periodTwo.startDate, periodTwo.endDate);
	}

	public static boolean intervalsIntersect(Date startOne, Date endOne,
			Date startTwo, Date endTwo) {

		return (!(startTwo.after(endOne) || startOne.after(endTwo)));
	}

	/**
	 * Returns the current date.
	 * 
	 * @return Date
	 */
	public static Date currentDate() {
		return Calendar.getInstance().getTime();
	}

	/**
	 * Returns the current date.
	 * 
	 * @return Date
	 */
	public static long Duration(Date startDate, Date endDate) {
		long from = startDate.getTime();
		long to = endDate.getTime();
		double difference = to - from;
		long days = Math.round((difference / (1000 * 60 * 60 * 24)));

		return days;
	}

	/**
	 * Returns the current date as a String using the default format.
	 * 
	 * @return String
	 */
	public static String currentDateToString() {
		return dateToString(currentDate());
	}
	
	/**
	 * Returns the current year as a String.
	 * 
	 * @return String
	 */
	public static String currentYearToString() {
		
		String currentYear = currentDateToString();
		currentYear = currentYear.substring(0, 4);
		return currentYear;
	}
	
	/**
	 * Returns the current month as a String.
	 * 
	 * @return String
	 */
	public static int currentMonthInt() {
		return Calendar.getInstance().get(Calendar.MONTH);
	}

	/**
	 * Returns a String representation of the given Date using the default
	 * format.
	 * 
	 * @param date
	 *            The date to return.
	 * @return String
	 */
	public static String dateToString(final Date date) {
		String dateTimeString = dateToString(date, DEFAULT_DATE_FORMAT);
		return dateTimeString;
	}

	/**
	 * Returns the current date as a String in the given format.
	 * 
	 * @param dateTimeFormat
	 *            The format to use.
	 * @return String
	 */
	public static String currentDateToString(final String dateTimeFormat) {
		return dateToString(currentDate(), dateTimeFormat);
	}

	/**
	 * Returns a String representation of the provided Date in the given format.
	 * 
	 * @param date
	 *            The date to return.
	 * @param dateTimeFormat
	 *            The format to use.
	 * @return String
	 */
	public static String dateToString(final Date date,
			final String dateTimeFormat) {
		// Convert the date into an appropriately formatted string
		SimpleDateFormat dateFormatter = new SimpleDateFormat(dateTimeFormat);
		String dateTimeString = dateFormatter.format(date);
		return dateTimeString;
	}

	/**
	 * Returns a String representation of the given Date using the supplied
	 * format.
	 * 
	 * @param date
	 *            The Date to return.
	 * @param dateTimeFormat
	 *            The format to use.
	 * @return String
	 */
	public static Date stringToDate(final String date,
			final String dateTimeFormat) {
		Date vReturn = null;

		if (date == null || dateTimeFormat == null) {
		} else {
			// Attempt to parse the string date into the agreed format
			SimpleDateFormat dateFormatter = new SimpleDateFormat(
					dateTimeFormat);
			dateFormatter.setLenient(false);
			ParsePosition pos = new ParsePosition(0);
			Date createdDateTime = dateFormatter.parse(date, pos);
			vReturn = createdDateTime;
		}

		return vReturn;
	}

	/**
	 * resetTimeFrom 00:00.
	 * 
	 * @param aDate
	 * @return
	 */
	public static Date resetTimeFrom(final Date aDate) {
		Date vReturnDate = null;
		if (aDate != null) {
			Calendar vCalendar = Calendar.getInstance();
			vCalendar.setTime(aDate);
			vCalendar.set(Calendar.HOUR, 0);
			vCalendar.set(Calendar.MINUTE, 0);
			vCalendar.set(Calendar.SECOND, 0);
			vReturnDate = vCalendar.getTime();
		}
		return vReturnDate;
	}

	/**
	 * resetTimeTo 24:00.
	 * 
	 * @param aDate
	 * @return
	 */
	public static Date resetTimeTo(final Date aDate) {
		Date vReturnDate = null;
		if (aDate != null) {
			Calendar vCalendar = Calendar.getInstance();
			vCalendar.setTime(aDate);
			vCalendar.set(Calendar.HOUR, 23);
			vCalendar.set(Calendar.MINUTE, 59);
			vCalendar.set(Calendar.SECOND, 59);
			return vCalendar.getTime();
		}
		return vReturnDate;
	}

	/**
	 * Convert java.sql.Date to java.util.Date.
	 * 
	 * @param aDate -
	 *            java.sql.Date.
	 * @return java.util.Date.
	 */
	public static java.util.Date sqlDate2UtilDate(final java.sql.Date aDate) {

		java.util.Date vReturn = null;

		if (aDate == null) {
		} else {
			vReturn = aDate;
		}

		return vReturn;
	}

	/**
	 * Convert java.sql.Timestamp to Date String
	 * 
	 * @param aDate -
	 *            java.sql.Timestamp
	 * @return java.util.Date.
	 */
	public static String timestamp2DateString(
			final java.sql.Timestamp aTimestamp) {
		String vReturn = null;

		if (aTimestamp == null) {
		} else {
			vReturn = aTimestamp.toString().substring(0, 10);
		}
		return vReturn;
	}

	/**
	 * Formats an input date string to a required format.
	 * 
	 * @param aInputDateString -
	 *            The input date.
	 * @param aInputDateFormat -
	 *            The format of the input date.
	 * @param aRequiredFormat -
	 *            The required format.
	 * @return String.
	 */
	public static String formatDateString(final String aInputDateString,
			final String aInputDateFormat, final String aRequiredFormat) {
		String vReturn = null;
		if (aInputDateString != null && aInputDateFormat != null
				&& aRequiredFormat != null) {
			Date vInputDate = stringToDate(aInputDateString, aInputDateFormat);
			vReturn = dateToString(vInputDate, aRequiredFormat);
		}

		return vReturn;
	}
	
	public static String getDayOfWeekName(int dayNumber){
		
		switch (dayNumber){
			case Calendar.SATURDAY:
				return "Sat";
			case Calendar.SUNDAY:
				return "Sun";				
			case Calendar.MONDAY:
				return "Mon";				
			case Calendar.TUESDAY:
				return "Tue";				
			case Calendar.WEDNESDAY:
				return "Wed";				
			case Calendar.THURSDAY:
				return "Thu";				
			case Calendar.FRIDAY:
				return "Fri";				
		}
		
		return "Unknown";
	}
	
	public static String getQuarterName(int quarter){
		
		switch (quarter){
			case 0:
				return "Q1";
			case 1:
				return "Q2";				
			case 2:
				return "Q3";				
			case 3:
				return "Q4";				
		}
		
		return "Unknown";
	}
	
	public static String getMonthName(int monthNumber){
		switch (monthNumber){
		case Calendar.JANUARY:
			return "Jan";
		case Calendar.FEBRUARY:
			return "Feb";
		case Calendar.MARCH:
			return "Mar";
		case Calendar.APRIL:
			return "Apr";
		case Calendar.MAY:
			return "May";
		case Calendar.JUNE:
			return "Jun";
		case Calendar.JULY:
			return "Jul";
		case Calendar.AUGUST:
			return "Aug";
		case Calendar.SEPTEMBER:
			return "Sep";
		case Calendar.OCTOBER:
			return "Oct";
		case Calendar.NOVEMBER:
			return "Nov";
		case Calendar.DECEMBER:
			return "Dec";
		}
		return "Unknown";
	}
	
	public static Date endOfDay(Date date) {
		if (date == null)
			return null;

		Calendar cal = Calendar.getInstance();
		// here we must cater for null dates....??
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);

		return cal.getTime();
	}
	
	public static String getFormatedDate(Date date, String pattern){
		String vReturn = null;
		if (date != null && pattern != null) {
			SimpleDateFormat sdf = new SimpleDateFormat();
			sdf.applyPattern(pattern);
			vReturn = sdf.format(date);
		}
		return vReturn;
	}
	
	public static String getFriendlyFormatedDate(Date date){
		String vReturn = null;
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat();
			sdf.applyPattern("E MMM d,yyyy - kk:mm:ss");
			vReturn = sdf.format(date);
		}
		return vReturn;
	}
	
	/**
	 * Utility method for creating <code>Date</code> objects.
	 * 
	 * @param day
	 *            the date.
	 * @param month
	 *            the month.
	 * @param year
	 *            the year.
	 * 
	 * @return a date.
	 */
	public static Date date(final int day, final int month, final int year) {

		final Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);
		final Date result = calendar.getTime();
		return result;

	}
}
