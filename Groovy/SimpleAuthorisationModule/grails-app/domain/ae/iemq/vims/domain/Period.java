package ae.iemq.vims.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import ae.iemq.vims.util.DateUtil;

@Embeddable
public class Period implements Serializable {
	
	public static String MONTHLY = "Mth";
	
	public static String QUARTERLY = "Qtr";
	
	public static String HALF_YEARLY = "HYr";
	
	public static String YEARLY = "Ann";

	public static final Period ALL_TIME = new Period(new Date(0),
			new Date(Long.MAX_VALUE), "All time");

/*Period Types are used for Creating PreiodSelectionModels*/
	public static enum PeriodType {
		/*WEEKLY,*/ MONTHLY, QUARTERLY, HALF_YEARLY, YEARLY , MONTHYEAR, QUARTERYEAR
	};

//	public static enum PeriodType {
//		/*WEEKLY,*/ Mth, Qtr, HYr, Ann
//	};

	public Period() {

	}

	public Period(Date startDate, Date endDate, String description) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
	}

	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)
	public Date startDate;

	@Column(name = "end_date")
	@Temporal(TemporalType.DATE)
	public Date endDate;

	@Transient
	public String description;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Period)){
//			System.out.println("obj is not a period");
			return false;
		}
		Period period = (Period) obj;
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("dd-MM-yyyy");

//		/*For testing the comparison between obj dates and this class dates*/
//		
//		System.out.println("obj  start time-->"+sdf.format(period.startDate));
//		System.out.println("obj  end   time-->"+sdf.format(period.endDate));
//		System.out.println("this start time-->"+sdf.format(this.startDate));
//		System.out.println("this end   time-->"+sdf.format(this.endDate));
//		
//		
//		System.out.println("obj is a period, the result of equal is-->"+(sdf.format(startDate).equals(sdf.format(period.startDate))
//				&& sdf.format(endDate).equals(sdf.format(period.endDate))));
		
		return sdf.format(startDate).equals(sdf.format(period.startDate))
				&& sdf.format(endDate).equals(sdf.format(period.endDate));
	}

	public static Period getPeriodForYear(int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, year);
		Date startDate = cal.getTime();
		
		cal.add(Calendar.YEAR, 1);
		cal.add(Calendar.MILLISECOND, -1);
		Date endDate = cal.getTime();
		
		return new Period(startDate, endDate, String.valueOf(year));
	}
	
	public static Period getPeriodForMonth(int month, int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.YEAR, year);
		Date startDate = cal.getTime();
		
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.MILLISECOND, -1);
		Date endDate = cal.getTime();
		
		return new Period(startDate, endDate, DateUtil.getMonthName(month)+" "+String.valueOf(year));
	}

	public static Period getPeriodForQuarter(int quarter, int year) {
		//quarter from 0 to 3
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.MONTH, (quarter*3));
		cal.set(Calendar.YEAR, year);
		Date startDate = cal.getTime();
		
		cal.add(Calendar.MONTH, 3);
		cal.add(Calendar.MILLISECOND, -1);
		Date endDate = cal.getTime();
		
		return new Period(startDate, endDate, DateUtil.getQuarterName(quarter)+" "+String.valueOf(year));
	}
	
	public static Period getPeriodForCurrentYear() {		
		return getPeriodForYear(Calendar.getInstance().get(Calendar.YEAR));				
	}
	public static Period getPeriodForCurrentMonth() {		
		return getPeriodForMonth(Calendar.getInstance().get(Calendar.MONTH),Calendar.getInstance().get(Calendar.YEAR));				
	}
	public static Period getPeriodForCurrentQuarter() {		
		return getPeriodForQuarter(Calendar.getInstance().get(Calendar.MONTH)% 3,Calendar.getInstance().get(Calendar.YEAR));				
	}
}
