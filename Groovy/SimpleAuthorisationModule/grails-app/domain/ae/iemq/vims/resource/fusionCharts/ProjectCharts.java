package ae.iemq.vims.resource.fusionCharts;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import ae.iemq.vims.domain.Deliverable;
import ae.iemq.vims.domain.Period;
import ae.iemq.vims.domain.Project;
import ae.iemq.vims.domain.ProjectPeriodInfo;
import ae.iemq.vims.domain.ProjectPeriodValue;
import ae.iemq.vims.resource.ViMSColorUtil;
import ae.iemq.vims.util.DateUtil;
import ae.iemq.vims.util.StringUtil;

public class ProjectCharts {
	
	/** The internal logger. */
	static Logger LOG = Logger.getLogger(ProjectCharts.class);

	/**
	 * Constructor for ProjectCharts.
	 */
	public ProjectCharts(){
		super();
	}

	/**
	 * This Method constructs the XML for building a Gantt Chart.
	 * 
	 * @return Sting The XML input to construct the Gantt Chart.
	 */	
	public static String generateGanttChart(List<Deliverable> deliverables){
		String xmlString = "";
		LOG.debug("Generating gantt chart for project"); 
		
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("MM/dd/yyyy");
		
//		get the first task start date and last task end date
		Date startDate = new Date();
		Date endDate = new Date(0);
		
		for(Deliverable d : deliverables){
			if(d.getScheduledStartDate().before(startDate)){
				startDate.setTime(d.getScheduledStartDate().getTime() - (1000 * 60 * 60 * 24));
			}
			if(d.getScheduledEndDate().after(endDate)){
				endDate.setTime(d.getScheduledEndDate().getTime());
			}
		}
		
		LOG.debug("Start Date ----->"+sdf.format(startDate));
		LOG.debug("End Date ----->"+sdf.format(endDate));
		
		
		//create the title
		sb.append("<chart dateFormat='mm/dd/yyyy'"+
				"ganttPaneDuration='8' slackFillColor='FF3300' showPercentLabel='1' taskBarRoundRadius='5'");
		
		//how many days to increment
		int daysIncrement = 0;
		long duration = DateUtil.Duration(startDate, endDate);
		
		if(duration < 30){
			//daily
			daysIncrement = 1;
			sb.append("ganttPaneDurationUnit='d' >");
		}else if(duration >= 30 && duration < 180){
			//weekly
			daysIncrement = 7;
			sb.append("ganttPaneDurationUnit='m' >");
		}else if(duration >= 180){
			//monthly
			daysIncrement = 30;
			sb.append("ganttPaneDurationUnit='m' >");
		}
		
		//create months label
		Calendar calendarTime = Calendar.getInstance();
		sb.append("<categories>");
		final int DAILY 	= 1;
		final int WEEKLY 	= 7;
		final int MONTHLY = 30;
		calendarTime.setTime(startDate);
		calendarTime.setFirstDayOfWeek(Calendar.SUNDAY);
		while(calendarTime.getTime().before(endDate)){
	
			switch(daysIncrement){
				case DAILY:
					sb.append("<category start='"+sdf.format(calendarTime.getTime())+"'");
					sb.append("label='"+DateUtil.getDayOfWeekName(calendarTime.get(Calendar.DAY_OF_WEEK))+"/"+calendarTime.get(Calendar.DAY_OF_MONTH)+"'");
					calendarTime.add(Calendar.DATE,daysIncrement);
					sb.append("end='"+sdf.format(calendarTime.getTime())+"'  />");
				break;
				case WEEKLY:
					calendarTime.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
					sb.append("<category start='"+sdf.format(calendarTime.getTime())+"'");
					sb.append("label='w-"+calendarTime.get(Calendar.WEEK_OF_YEAR)+"'");
					calendarTime.add(Calendar.WEEK_OF_YEAR,1);
					sb.append("end='"+sdf.format(calendarTime.getTime())+"'  />");					
				break;
				case MONTHLY:
					calendarTime.set(Calendar.DAY_OF_MONTH,1);
					sb.append("<category start='"+sdf.format(calendarTime.getTime())+"'");
					sb.append("label='"+DateUtil.getMonthName(calendarTime.get(Calendar.MONTH))+"'");
					calendarTime.add(Calendar.MONTH,1);
					sb.append("end='"+sdf.format(calendarTime.getTime())+"'  />");	
				break;
			}
		}
		sb.append("</categories>");
		
		sb.append("<processes fontSize='12' isBold='1' align='left' headerText='Tasks' headerFontSize='18' headerVAlign='bottom' headerAlign='right'>");
		for (Deliverable d : deliverables) {
			sb.append("<process label='"+StringUtil.replaceXml(d.getDescription())+"' id='"+d.getId()+"'/>");
		}
		sb.append("</processes>");
		
		//create deliverables gantt chart bars
		sb.append("<tasks showLabels='0'>");
		StringBuffer mileStoneSb = new StringBuffer();
		
		for (Deliverable d : deliverables) {
			LOG.debug("Deliverable "+StringUtil.replaceXml(d.getDescription())+" - Start date: "+d.getScheduledStartDate()
					+" End date: "+d.getScheduledEndDate());
			
			sb.append("<task start='"+sdf.format(d.getScheduledStartDate())+"' " +
					"end='"+sdf.format(d.getScheduledEndDate())+"' label='Planned' " +
							"  color='4567aa' height='20%25' topPadding='20%25' processId='"+d.getId()+"' id='"+d.getId()+"-1'/>");

			//check if this deliverable is a milestone (Planned)
			if(DateUtil.dateToString(d.getScheduledStartDate())
					.equals(DateUtil.dateToString(d.getScheduledEndDate()))){
				mileStoneSb.append("<milestone date='"+DateUtil.dateToString(d.getScheduledEndDate()
						, "MM-dd-yyyy")+"' taskId='"+d.getId()+"-1' shape='star' " +
								"toolText='"+StringUtil.replaceXml(d.getDescription())+" - "+DateUtil.dateToString(d.getScheduledEndDate(), "MM-dd-yyyy")+"' color='456766'/>");
			}
			
			if (d.getActualStartDate() != null && (d.getActualEndDate()!=null || d.getProjectedEndDate()!=null)) {
				if (d.getActualEndDate()!=null){
				sb.append("<task start='"+sdf.format(d.getActualStartDate())+"' " +
						"end='"+sdf.format(d.getActualEndDate())+"' label='Actual' " +
								" color='EEEEEE' height='20%25' topPadding='55%25' processId='"+d.getId()+"' id='"+d.getId()+"-2'/>");
				}
				if (d.getProjectedEndDate()!=null){
					sb.append("<task start='"+sdf.format(d.getActualStartDate())+"' " +
							"end='"+sdf.format(d.getProjectedEndDate())+"' label='Projected' " +
									" color='EEE000' height='20%25' topPadding='55%25' processId='"+d.getId()+"' id='"+d.getId()+"-2'/>");
				}
	
				//check if this deliverable is a milestone (Actual)
				if(d.getActualEndDate()!=null && DateUtil.dateToString(d.getActualStartDate()).equals(DateUtil.dateToString(d.getActualEndDate()))){
					mileStoneSb.append("<milestone date='"+DateUtil.dateToString(d.getActualEndDate()
							, "MM-dd-yyyy")+"' taskId='"+d.getId()+"-2' shape='star' " +
									"toolText='"+StringUtil.replaceXml(d.getDescription())+" - "+DateUtil.dateToString(d.getActualEndDate(), "MM-dd-yyyy")+"' color='999999' showLabel='1' label='Milestone'/>");
				}
			}
			
		}
		sb.append("</tasks>");
		
		sb.append("<legend>");
		sb.append("<item label='Planned' color='4567aa' />");
		sb.append("<item label='Actual' color='EEEEEE' />");
		sb.append("<item label='Projected' color='EEE000' />");
		sb.append("</legend>");
		
		sb.append("<milestones>");
		sb.append(mileStoneSb.toString());
		sb.append("</milestones>");
		
		sb.append("</chart>");
		
		xmlString = sb.toString();
		
		LOG.debug("xmlString--->"+xmlString);
		
		return xmlString;
	}
	

///////////////////////////////////////

	
	
	/**
	 * This Method constructs the XML for building a Timeline Chart.
	 * 
	 * @return Sting The XML input to construct the Timeline Chart.
	 */	
	public static String generateTimelineChart(Project project){
		//Set<Deliverable> deliverables=project.getDeliverables();
		
		String xmlString = "";
		LOG.debug("Generating Timeline chart for project");
	
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("dd/MM/yyyy");
		
		Date schStart = null;
		Date schEnd =null;
		Date now = new Date();
		Date start = null;
		Date end = null;
		boolean isDelayed=false;

		if (project.isImported()){
			if (project.getStartDate()!=null)
				schStart=project.getStartDate();
			if (project.getEndDate()!=null)
				schEnd=project.getEndDate();
			if (project.getCurrentStartDate()!=null)
				start=project.getCurrentStartDate();
			if (project.getCurrentEndDate()!=null)
				end=project.getCurrentEndDate();
			if (project.getEndDate()!=null &&end!=null&& project.getEndDate().after(end)){
				isDelayed=true;
				LOG.debug("PROJECT "+StringUtil.replaceXml(project.getName())+" IS DELAYED!!!!!");
			}
		} else {
			if (project.getScheduledStartDate()!=null){
				schStart=project.getScheduledStartDate();	
				LOG.debug("Scheduled Start Date ----->"+sdf.format(schStart));
			}
			if (project.getScheduledEndDate()!=null){
				schEnd=project.getScheduledEndDate();
				LOG.debug("Scheduled End Date ----->"+sdf.format(schEnd));
			}
			if(project.getActualStartDate()!=null){
				start=project.getActualStartDate();
				if(project.getActualEndDate()!=null)
					end=project.getActualEndDate();
				else if (project.getProjectedEndDate()!=null &&
						project.getProjectedEndDate().after(now))
					end=project.getProjectedEndDate();
			}
			if (project.getScheduledEndDate()!=null&& end!=null&& project.getScheduledEndDate().after(end)){
				isDelayed=true;
				LOG.debug("PROJECT "+StringUtil.replaceXml(project.getName())+" IS DELAYED!!!!!");
			}
		}
		//create the title
		sb.append("<chart dateFormat='dd/mm/yyyy' dateInToolTip='0'"+
				"slackFillColor='FF3300' showPercentLabel='1' taskBarRoundRadius='5' chartTopMargin='0'"+
				" chartLeftMargin='0' chartRightMargin='1' chartBottomMargin='1' taskDatePadding='2' >");

		
		sb.append("<processes fontSize='12' isBold='1' align='left' headerText='Timeline' headerFontSize='18' headerVAlign='bottom' headerAlign='right'>");
		sb.append("<process label='Planned' id='1'/>");
		sb.append("<process label='Actual' id='2'/>");
		sb.append("</processes>");
		
		//create deliverables gantt chart bars
		if(schStart!=null&&schEnd!=null){
			sb.append("<tasks showLabels='1'>");
				sb.append("<task start='"+sdf.format(schStart)+"' " +
					"end='"+sdf.format(schEnd)+"' topPadding='65%25' height='35%25'label='" +
					sdf.format(schStart)+" to "+sdf.format(schEnd)+"' " +
					"  color='003F87' processId='1' />");
			if(start!=null&&end!=null){
				if (isDelayed){//Colour should be red
					sb.append("<task start='"+sdf.format(start)+"' " +
					"end='"+sdf.format(end)+"' topPadding='65%25' height='35%25' label='" +
					sdf.format(start)+" to "+sdf.format(end)+"' " +		
					"  color='"+ViMSColorUtil.ROBOT_RED+"' processId='2'  />");
				}else{//Colour should be green
					sb.append("<task start='"+sdf.format(start)+"' " +
						"end='"+sdf.format(end)+"' topPadding='65%25' height='35%25' label='" +
						sdf.format(start)+" to "+sdf.format(end)+"' " +		
						"  color='"+ViMSColorUtil.ROBOT_GREEN+"' processId='2' />");
				}
			}else{
				sb.append("<task start='"+sdf.format(schStart)+"' " +
					"end='"+sdf.format(schEnd)+"' topPadding='100%25' height='0%25'label='" +
					" No Actual Date Information' " +
							"  color='FFFFFF' processId='2' />");
		}
			sb.append("</tasks>");
		}
		sb.append("</chart>");
		
		xmlString = sb.toString();
		
		LOG.debug("xmlString--->"+xmlString);
		
		return xmlString;
	}
	
	
	/////////////////////////////////////////
	public static String generateDECLineChartForPeriod(ProjectPeriodInfo period, int dec){
		String xmlString = "";
		StringBuffer sb = new StringBuffer();
		String title="";
		switch (dec){
		case 1:
			title="Duration";
			break;
		case 2:
			title="Effort";
			break;
		case 3:
			title="Cost";
			break;
		}
		//Scaling Max and min  values for yAXIS
		float maxDEC=period.getMaxMinDecValue(dec,true);
		float minDEC=period.getMaxMinDecValue(dec,false);;
		double diff=Math.round(maxDEC-minDEC);
		LOG.debug("MAX/MIN FROM PERIOD IS------->"+maxDEC);
		LOG.debug("MAX/MIN FROM PERIOD IS------->"+minDEC);
		
		double max=Math.round(maxDEC+(diff*0.15));
		max-=max%5;
		double min=Math.round(minDEC-(diff*0.15));
		min-=min%5;
		if (diff==0 && maxDEC<=5){
			max=10;
		}else if (diff==0 && minDEC>5) {
			max=(Math.round(maxDEC)+5)-((Math.round(maxDEC)+5)%5);
			min=(Math.round(minDEC)-5)-((Math.round(minDEC)-5)%5);
		}
		if(min<0) min=0;
		LOG.debug("CHART MAX IS--------------->"+max);
		LOG.debug("CHART MIN IS--------------->"+min);
		//END Scaling Max and min  values for yAXIS
		//Chart tag
		sb.append("<chart palette='"+(dec+1)+"' caption='"+title+""
				+"' lineThickness='1' showValues='0' yAxisMaxValue='"+max+"' yAxisMinValue='"+min+"' numDivLines='5'" 
				+"formatNumberScale='0'  divLineAlpha='20' divLineColor='06fff0' vDivLineIsDashed='1' vDivLineDashLen='2' vDivLineDashGap='2'"
				+"divLineIsDashed='0' showAlternateVGridColor='1' "
				+" labelStep='1' showYAxisValues='1' numVDivLines='"+period.getProjectPeriodValues().size()/6+"'" //numVDivLines='"+(period.validMonths())+"'
				+"chartRightMargin='35' connectNullData='1'>");
		
		//categories
		sb.append("<categories>");
		sb.append("<category label=' '/>");
		for (int i=0;i<period.getProjectPeriodValues().size()/6;i++) {
				if(period.getProject().getReportingFrequency().equalsIgnoreCase(Period.MONTHLY)){
					sb.append("<category label='"+DateUtil.getMonthName(i).substring(0,1)+"'/>");
				}else if(period.getProject().getReportingFrequency().equalsIgnoreCase(Period.QUARTERLY)){
					sb.append("<category label='"+DateUtil.getQuarterName(i)+"'/>");
				}
		}
		sb.append("<category label='.'/>");
		sb.append("</categories>");
		
		//dataset
			//BASELINE
		sb.append("<dataset seriesName='Baseline' renderAs='Line' color='2452fb' ");
		//Check if Period has valid values for baseline
		boolean hasValid=false;
		for(ProjectPeriodValue pv : period.getAllValuesForType(dec,ProjectPeriodValue.BASELINE)){
			if(pv.isValid()){
				hasValid=true;
			}
		}
		//If it doesnt have valid values do not display anchors
		if (hasValid){
			sb.append(">");
		}else {
			sb.append("drawAnchors='0'>");
		}
		//End Checking if Period has valid values for baseline
		
		sb.append("<set />");
		for(ProjectPeriodValue pv : period.getAllValuesForType(dec,ProjectPeriodValue.BASELINE)){
			if(pv.isValid()){
				sb.append("<set value='"+pv.getValue()+"'/>");//' anchorBorderColor='2452fb' anchorBgColor='2452fb' anchorSides='4' anchorRadius='4'/>");
			}
			else{
				sb.append("<set value='"+pv.getValue()+"'  drawAnchors='0' />");
			}
		}
		sb.append("<set />");
		sb.append("</dataset>");
		
			//ACTUAL
		sb.append("<dataset seriesName='Actual' color='f606ff' anchorBorderColor='f606ff'" +
				" anchorBgColor='f606ff'>");
		sb.append("<set />");
		for(ProjectPeriodValue pv : period.getAllValuesForType(dec,ProjectPeriodValue.ACTUAL)){
			if(pv.isValid()){
				sb.append("<set value='"+pv.getValue()+"'/>");
			}
			else{
				sb.append("<set />");
			}
		}
		sb.append("<set />");
		sb.append("</dataset>");
		
		//style
		sb.append("<styles><definition><style name='CaptionFont' type='font' size='12'/></definition>"
                 +"<application><apply toObject='CAPTION' styles='CaptionFont'/>"
                 +"<apply toObject='SUBCAPTION' styles='CaptionFont'/>"
                 +"</application></styles>");
		
		//Chart tag end
		sb.append("</chart>");
		
		
		xmlString = sb.toString();
		LOG.debug("xmlString--->"+xmlString);
		return xmlString;
	}
	
	
	
	//////////////////////////////////////////
	/**
	 * This Method constructs the XML for building a Bulb Guage.
	 * 
	 * @return Sting The XML input to construct the guage.
	 */
	public static String getProjectPeriodRobot(ProjectPeriodInfo projectPeriod,int dec,String bgcolor, boolean showValue, int formatType) {
		///param: Duration=1,Effort=2,Impact=3,STATUS(overall)=0
		//formatType 1: BIG , 2: Normal(matrixpage)
		String xmlString = "";
		StringBuffer sb = new StringBuffer();

		sb.append("<chart lowerLimit='" + Integer.MIN_VALUE + "' upperLimit='"
				+ Integer.MAX_VALUE + "'");
		if (showValue) {
			sb.append(" numberSuffix='%30' placeValuesInside='" + 1 + "'");
		} else {
			sb.append(" showValue='0'");
		}

		if (formatType == 1) {
			sb
					.append(" gaugeFillAlpha='100' showGaugeBorder='1' gaugeBorderColor='666666' "
							+ "gaugeBorderThickness='1' gaugeBorderAlpha='100'"
							+ "bgAlpha='100' borderAlpha='100' bgColor='"
							+ bgcolor + "' borderColor='" + bgcolor + "'>");
		}

		if (formatType == 2) {// Inside the measure Period Page
			sb
					.append("palette='2' gaugeBorderColor='{dark-30}' showBorder='0' >");

		}
		String color="";
		if (dec>0)
			color=getProjectPeriodRobotColour(projectPeriod,dec);
		else if (dec==0)
			color=getProjectPeriodRobotColour(projectPeriod);
		sb.append("<colorRange>");
		sb.append("<color minValue='0' maxValue='11' label='' code='"
				+ color
				+ "' alpha='100' />");
		sb.append(" </colorRange>");
		if (color == ViMSColorUtil.WHITE || dec==0) {
			sb.append("<value>" + "");
		} else  {
			sb.append("<value>" + (projectPeriod.getDoubleLatestValueType(dec,ProjectPeriodValue.ACTUAL)));
		}
		sb.append("</value>");
		sb.append("</chart>");

		xmlString = sb.toString();
		LOG.debug("BULB xmlString--->" + xmlString);

		return xmlString;
	}
	

	public static String getProjectPeriodRobotColour(ProjectPeriodInfo projectPeriod, int dec) {
		
		if (dec>0){
			double baseline=projectPeriod.getDoubleLatestValueType(dec,ProjectPeriodValue.BASELINE);
			double actual=projectPeriod.getDoubleLatestValueType(dec,ProjectPeriodValue.ACTUAL);
			LOG.debug("LATEST VALID VALUES: BASELINE--->"+baseline+"ACTUAL--->"+actual);
			if (actual>=0 && baseline>=0){
				if (baseline>=actual)return ViMSColorUtil.ROBOT_GREEN;
				else if (baseline<actual)return ViMSColorUtil.ROBOT_RED;
			} 
			
		}
		return ViMSColorUtil.WHITE;
			
		
	}
	
	public static String getProjectPeriodRobotColour(ProjectPeriodInfo projectPeriod) {
		float sumRED=0;
		float sumGREEN=0;
		float sumWHITE=0;
		int size=0;
		for (int i=1;i<=3;i++){
			if (projectPeriod != null) {
				String color=ProjectCharts.getProjectPeriodRobotColour(projectPeriod,i);
				if (ViMSColorUtil.ROBOT_GREEN.equalsIgnoreCase(color)){
					sumGREEN++;
					size++;
				}else if (ViMSColorUtil.ROBOT_RED.equalsIgnoreCase(color)){
					sumRED++;
					size++;
				}else if (ViMSColorUtil.WHITE.equalsIgnoreCase(color))	
					sumWHITE++;
			}
			
		}	
		if (size>0){
			if (sumGREEN/size>=0.89) return ViMSColorUtil.ROBOT_GREEN;
			else if (((sumGREEN/size)<0.89)&&((sumGREEN/size)>=0.66)) return ViMSColorUtil.ROBOT_YELLOW;
			else if ((sumGREEN/size)<0.66) return ViMSColorUtil.ROBOT_RED;
		}
		 return ViMSColorUtil.WHITE;
	}



	
	/**
	 * This Method constructs the XML for building a Measure 2D Column chart.
	 * 
	 * @return Sting The XML input to construct the guage.
	 */
	public static String generatePieChart(List<String[]> info, String title) {

		StringBuffer sb = new StringBuffer();
		if (title==null||title.trim()=="") title="Untitled Chart";
		sb.append("<chart decimals='0' enableSmartLabels='1' enableRotation='0' bgColor='99CCFF,FFFFFF' " +
				"bgAlpha='40,100' bgRatio='0,100' bgAngle='360' showBorder='1' startingAngle='70'"+
				"caption='"+StringUtil.replaceXml(title)+"'>");
		
		for (String[] item:info){
			sb.append("<set label='"+StringUtil.replaceXml(item[0])+"' value='"+item[1]+"'/>");
		}

		sb.append("</chart>");

		String xmlString = sb.toString();

		if (LOG.isDebugEnabled()) {
			LOG.debug(xmlString);
		}

		return xmlString;

	}
	
	
}
