/*
 * Copyright (c) IeMQ.
 * All rights reserved.
 */
package ae.iemq.vims.resource.fusionCharts;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import ae.iemq.vims.domain.Activity;
import ae.iemq.vims.resource.ViMSColorUtil;

/**
 * This class constructs an XML string used to populate Fusion Charts.
 */
public class ActivityCharts {

	/** The internal logger. */
	static Logger LOG = Logger.getLogger(ActivityCharts.class);

	/**
	 * Constructor for MeasurePeriodCharts.
	 */
	public ActivityCharts() {
		super();
	}


	/**
	 * This Method constructs the XML for building a Bulb Guage.
	 * 
	 * @return Sting The XML input to construct the guage.
	 */
	public static String generateBulbChart(Activity activity, String bgcolor){
		String xmlString = "";
		StringBuffer sb = new StringBuffer();
		
		final int MAX_VALUE = 100;
		final int MID_VALUE = 50;
		final int MIN_VALUE = 0;
		final int EMPTY_VALUE=-100;

		

		
		sb.append("<chart upperLimit='"+MAX_VALUE+"' lowerLimit='"+MIN_VALUE+"' numberSuffix='%25' " +
				"placeValuesInside='1' showGaugeBorder='1' gaugeFillAlpha='100' gaugeBorderColor='666666' bgAlpha='100' borderAlpha='100' bgColor='"+bgcolor+"' borderColor='"+bgcolor+"'"+
				"gaugeBorderThickness='1' gaugeBorderAlpha='100' useColorNameAsValue='1'>");
		
		sb.append("<colorRange>");
		sb.append("<color minValue='"+(EMPTY_VALUE-1)+"' maxValue='"+(EMPTY_VALUE+1)+"' label='' code='"+ViMSColorUtil.WHITE+"' alpha='100'/>");
		sb.append("<color minValue='"+(MIN_VALUE-1)+"' maxValue='"+(MIN_VALUE+1)+"' label='' code='"+ViMSColorUtil.ROBOT_RED+"' alpha='100'/>");
		sb.append("<color minValue='"+(MID_VALUE-1)+"' maxValue='"+(MID_VALUE+1)+"' label='' code='"+ViMSColorUtil.ROBOT_YELLOW+"' alpha='100'/>");
		sb.append("<color minValue='"+(MAX_VALUE-1)+"' maxValue='"+(MAX_VALUE+1)+"' label='' code='"+ViMSColorUtil.ROBOT_GREEN+"' alpha='100'/>");
		sb.append("</colorRange>");
		switch (activity.computeStatus()) {
		case RED:
			sb.append("<value>"+MIN_VALUE+"</value>");
			break;

		case GREEN:
			sb.append("<value>"+MAX_VALUE+"</value>");
			break;

		case WHITE:
			sb.append("<value>"+EMPTY_VALUE+"</value>");
			break;
		case YELLOW:
			sb.append("<value>"+MID_VALUE+"</value>");			
			break;
		}
		sb.append("</chart>");
		
		xmlString = sb.toString();
		LOG.debug("xmlString--->"+xmlString);
		
		return xmlString;
	}
	
	public static String generateGanttChartXML(Activity act){
		String xmlString = "";
		StringBuffer sb = new StringBuffer();
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("MM/dd/yyyy");
		
//		create the title
		sb.append("<chart dateFormat='mm/dd/yyyy' dateInToolTip='0'"+
				" slackFillColor='FF3300' showPercentLabel='1' taskBarRoundRadius='5'>");
		
//		how many days to increment
//		int daysIncrement = 0;
		Date plannedStartDate = act.getPeriod().startDate;
		Date plannedEndDate = act.getPeriod().endDate;
		Date actualStartDate = act.getActualPeriod().startDate;
		Date actualEndDate = act.getActualPeriod().endDate;
//		
//		long duration = DateUtil.Duration(plannedStartDate, plannedEndDate);
//		
//		if(duration < 30){
//			//daily
//			daysIncrement = 1;
//			sb.append("ganttPaneDurationUnit='d' >");
//		}else if(duration >= 30 && duration < 180){
//			//weekly
//			daysIncrement = 7;
//			sb.append("ganttPaneDurationUnit='m' >");
//		}else if(duration >= 180){
//			//monthly
//			daysIncrement = 30;
//			sb.append("ganttPaneDurationUnit='m' >");
//		}
//		
		
//		create months label
//		Calendar calendarTime = Calendar.getInstance();
//		sb.append("<categories>");
//		final int DAILY 	= 1;
//		final int WEEKLY 	= 7;
//		final int MONTHLY = 30;
//		calendarTime.setTime(plannedStartDate);
//		calendarTime.setFirstDayOfWeek(Calendar.SUNDAY);
//		while(calendarTime.getTime().before(plannedEndDate)){
//	
//			switch(daysIncrement){
//				case DAILY:
//					sb.append("<category start='"+sdf.format(calendarTime.getTime())+"'");
//					sb.append("label='"+DateUtil.getDayOfWeekName(calendarTime.get(Calendar.DAY_OF_WEEK))+"/"+calendarTime.get(Calendar.DAY_OF_MONTH)+"'");
//					calendarTime.add(Calendar.DATE,daysIncrement);
//					sb.append("end='"+sdf.format(calendarTime.getTime())+"'  />");
//				break;
//				case WEEKLY:
//					calendarTime.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
//					sb.append("<category start='"+sdf.format(calendarTime.getTime())+"'");
//					sb.append("label='w-"+calendarTime.get(Calendar.WEEK_OF_YEAR)+"'");
//					calendarTime.add(Calendar.WEEK_OF_YEAR,1);
//					sb.append("end='"+sdf.format(calendarTime.getTime())+"'  />");					
//				break;
//				case MONTHLY:
//					calendarTime.set(Calendar.DAY_OF_MONTH,1);
//					sb.append("<category start='"+sdf.format(calendarTime.getTime())+"'");
//					sb.append("label='"+DateUtil.getMonthName(calendarTime.get(Calendar.MONTH))+"'");
//					calendarTime.add(Calendar.MONTH,1);
//					sb.append("end='"+sdf.format(calendarTime.getTime())+"'  />");	
//				break;
//			}
//		}
//		sb.append("</categories>");
		
		sb.append("<processes fontSize='11' isBold='1' align='left' headerText='Tasks' headerFontSize='18' headerVAlign='bottom' headerAlign='right'>");
		
		sb.append("<process label='Planned' id='1'/>");
		sb.append("<process label='Actual' id='2'/>");
		
		sb.append("</processes>");
	
//		create deliverables gantt chart bars
		sb.append("<tasks showLabels='1'>");
		SimpleDateFormat labelDateFormat = new SimpleDateFormat();
		labelDateFormat.applyPattern("dd MMM yy");
		if(plannedStartDate != null && plannedEndDate != null){
			sb.append("<task start='"+sdf.format(plannedStartDate)+"' " +
					"end='"+sdf.format(plannedEndDate)+"' label='"+labelDateFormat.format(plannedStartDate)+" - "+labelDateFormat.format(plannedEndDate)+"' " +
							"  color='4567aa' topPadding='65%25' processId='1'/>");
		}
		
		//in case the user did not input any actual dates
		if(actualStartDate != null & actualEndDate != null){
			sb.append("<task start='"+sdf.format(actualStartDate)+"' " +
					"end='"+sdf.format(actualEndDate)+"' label='"+labelDateFormat.format(actualStartDate)+" - "+labelDateFormat.format(actualEndDate)+"' " +
							"  color='EEEEEE' topPadding='65%25' processId='2'/>");
		}
		sb.append("</tasks>");
		
//		sb.append("<legend>");
//		sb.append("<item label='Planned' color='4567aa' />");
//		sb.append("<item label='Actual' color='EEEEEE' />");
//		sb.append("</legend>");
//		
		sb.append("</chart>");

		
		xmlString = sb.toString();
		LOG.debug("xmlString--->"+xmlString);
		
		return xmlString;
	}

}