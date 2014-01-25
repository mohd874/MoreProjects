package ae.iemq.vims.resource.fusionCharts;

import java.util.Calendar;
import java.util.Collection;

import org.apache.log4j.Logger;

import ae.iemq.vims.domain.PeriodInfo;
import ae.iemq.vims.domain.PeriodValue;
import ae.iemq.vims.domain.Risk;
import ae.iemq.vims.resource.ViMSColorUtil;
import ae.iemq.vims.util.ColorUtil;
import ae.iemq.vims.util.DateUtil;
import ae.iemq.vims.util.StringUtil;

public class RiskCharts {

	public static final String PERSPECTIVE_1 = "Customer";
	public static final String PERSPECTIVE_2 = "Finance";
	public static final String PERSPECTIVE_3 = "Process";
	public static final String PERSPECTIVE_4 = "Growth %26 Learning";

	/** The internal logger. */
	static Logger LOG = Logger.getLogger(RiskCharts.class);

	/**
	 * Constructor for BostonSquareCharts.
	 */
	public RiskCharts() {
		super();
	}

	//////////////////////////////////////////
	/**
	 * This Method constructs the XML for building a Bulb Guage.
	 * 
	 * @return Sting The XML input to construct the guage.
	 */
	public static String getRiskPeriodRobot(PeriodInfo riskPeriod,int param,String bgcolor, boolean showValue, int formatType) {
		///param: Manageability=1,Probability=2,Impact=3,STATUS=0
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
		String color=getRiskPeriodRobotColour(riskPeriod,param);
		sb.append("<colorRange>");
		sb.append("<color minValue='0' maxValue='11' label='' code='"
				+ color
				+ "' alpha='100' />");
		sb.append(" </colorRange>");
		if (color == ViMSColorUtil.WHITE || param==0) {
			sb.append("<value>" + "0");
		} else  {
			sb.append("<value>" + (riskPeriod.getDoubleLatestValueType(param)));
		}
		sb.append("</value>");
		sb.append("</chart>");

		xmlString = sb.toString();
		LOG.debug("BULB xmlString--->" + xmlString);

		return xmlString;
	}
	

	public static String getRiskPeriodRobotColour(PeriodInfo riskPeriod, int valueType) {
		
		if (valueType==0){
			int last=riskPeriod.getLatestMonth();
			LOG.debug("LATEST VALID MONTH IS----->"+last);
			if (last==12)return ViMSColorUtil.WHITE;
			double calculated=(riskPeriod.getValueForMonth(last, 2)+riskPeriod.getValueForMonth(last, 3))/2;
			double manage=riskPeriod.getValueForMonth(last, 1);
			if (manage<5.5&& calculated>5.5) return ViMSColorUtil.ROBOT_RED;
			if (manage<5.5&&calculated<=5.5) return ViMSColorUtil.ROBOT_YELLOW;
			if (manage>=5.5&&calculated>5.5) return ViMSColorUtil.ROBOT_YELLOW;
			if (manage>=5.5&&calculated<=5.5) return ViMSColorUtil.ROBOT_GREEN;
		}else if (valueType==1){
			double value=riskPeriod.getDoubleLatestValueType(valueType);
			LOG.debug("LATEST VALID VALUE----->"+value);
			if (value>0){
				if (value >=6.5)return ViMSColorUtil.ROBOT_GREEN;
				if (value <6.5 && value>4.5)return ViMSColorUtil.ROBOT_YELLOW;
				if (value <=4.5)return ViMSColorUtil.ROBOT_RED;
			}
		}else if (valueType==2 || valueType==3){
			double value2=riskPeriod.getDoubleLatestValueType(valueType);
			LOG.debug("LATEST VALID VALUE----->"+value2);
			if (value2>0){
				if (value2 >=6.5)return ViMSColorUtil.ROBOT_RED;
				if (value2 <6.5 && value2>4.5)return ViMSColorUtil.ROBOT_YELLOW;
				if (value2 <=4.5)return ViMSColorUtil.ROBOT_GREEN;
			}
		}
		return ViMSColorUtil.WHITE;
			
		
	}
	
	public static String generateHistoryLineChartForRiskPeriod(PeriodInfo period){
		String xmlString = "";
		StringBuffer sb = new StringBuffer();
		
		//Chart tag
		sb.append("<chart palette='2' caption='History for "+StringUtil.replaceXml(period.getRisk().getDescription())+""
				+"' subcaption='"+period.getYear()+"' lineThickness='1' showValues='0' numDivLines='9'" 
				+"formatNumberScale='0'  divLineAlpha='20' divLineColor='06fff0' vDivLineIsDashed='1' vDivLineDashLen='2' vDivLineDashGap='2'"
				+"yAxisMaxValue='11' yAxisMinValue='0' divLineIsDashed='0' showAlternateVGridColor='1' "
				+" labelStep='1' showYAxisValues='1' numVDivLines='12'" //numVDivLines='"+(period.validMonths())+"'
				+"chartRightMargin='35' connectNullData='1'>");
		
		//categories
		sb.append("<categories>");
		sb.append("<category label=' '/>");
		int last=period.getLatestMonth();
		for (int i=Calendar.JANUARY;i<=Calendar.DECEMBER;i++) {
//			PeriodValue p1=period.getPeriodValueForMonth(i, 1);
//			PeriodValue p2=period.getPeriodValueForMonth(i, 2);
//			PeriodValue p3=period.getPeriodValueForMonth(i, 3);
//			if (p1.getIsValid()&&p2.getIsValid()&&p3.getIsValid()) {
				sb.append("<category label='"+DateUtil.getMonthName(Calendar.JANUARY+i)+"'/>");
//			}
		}
		sb.append("<category label='.'/>");
		sb.append("</categories>");
		
		//dataset
			//Manageability
		sb.append("<dataset seriesName='Manageability' renderAs='Line' color='2452fb' anchorBorderColor='2452fb'" +
				" anchorBgColor='2452fb' anchorSides='4' anchorRadius='6'>");
		sb.append("<set />");
		for(PeriodValue pv : period.getAllValuesForType(PeriodValue.MANAGEABLILITY)){
			if(pv.getIsValid()&& period.isPeriodInfoValidForMonth(pv.getMonth())){
				sb.append("<set value='"+pv.getValue()+"'/>");
			}
			else{
				sb.append("<set />");
			}
		}
		sb.append("<set />");
		sb.append("</dataset>");
		
			//Probability
		sb.append("<dataset seriesName='Probability' color='f606ff' anchorBorderColor='f606ff'" +
				" anchorBgColor='f606ff' anchorSides='3' anchorRadius='6'>");
		sb.append("<set />");
		for(PeriodValue pv : period.getAllValuesForType(PeriodValue.PROBABILITY)){
			if(pv.getIsValid()&& period.isPeriodInfoValidForMonth(pv.getMonth())){
				sb.append("<set value='"+pv.getValue()+"'/>");
			}
			else{
				sb.append("<set />");
			}
		}
		sb.append("<set />");
		sb.append("</dataset>");
		
			//Impact
		sb.append("<dataset seriesName='Impact' color='ffaa06' anchorBorderColor='ffaa06'" +
				" anchorBgColor='ffaa06' anchorRadius='4'>");
		sb.append("<set />");
		for(PeriodValue pv : period.getAllValuesForType(PeriodValue.IMPACT)){
			if(pv.getIsValid()&& period.isPeriodInfoValidForMonth(pv.getMonth())){
				sb.append("<set value='"+pv.getValue()+"'/>");
			}
			else{
				sb.append("<set />");
			}
		}
		sb.append("<set />");
		sb.append("</dataset>");
		
		//lines
//		sb.append("<trendlines>");
//		sb
//				.append("<line startValue='5.5' endValue='5.5' dashed='1' dashLen='2' dashGap='2'  isTrendZone='0' displayValue='0' color='CCCCCC' alpha='10'/>");
//		
//		sb.append("</trendlines>");
		
		
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
	
	
	
	public static String generateYearBostonSquare(Risk risk, PeriodInfo pi, int month) {
		String xmlString = "";
		StringBuffer sb = new StringBuffer();

		sb.append("<chart palette='2' is3D='1' animation='1' clipBubbles='1'  bubbleShadow='1'  negativeColor='000000' bubbleScale='0.5'  adjustDiv='0'  numDivLines='1'  divLineAlpha='10' legendMarkerCircle='1'"
						+ "xAxisMaxValue='-0.5' xAxisMinValue='-10.5' showPlotBorder='0' xAxisName='Manageability'  showLegend='0'"
						+ "canvasBgColor='ff3b3c,f4ff5b,0eb565' canvasBgRatio='0,50,50' canvasBgAlpha='30,20,40' canvasBgAngle='131'"
						+ "yAxisName='Risk' yAxisMaxValue='10.7' yAxisMinValue='0.3' chartRightMargin='10' showYAxisValues='0'  canvasBgSWF='../../images/bostonSquareBG.jpg'>");

		sb.append("<dataSet seriesName='" + PERSPECTIVE_1);
		if (risk.getObjective().getPerspective().getId() == 1)
			sb.append("' showValues='0' color='"+ColorUtil.PERSPECTIVE_1+"'>");
		if (risk.getObjective().getPerspective().getId() == 2)
			sb.append("' showValues='0' color='"+ColorUtil.PERSPECTIVE_2+"'>");
		if (risk.getObjective().getPerspective().getId() == 3)
			sb.append("' showValues='0' color='"+ColorUtil.PERSPECTIVE_3+"'>");
		if (risk.getObjective().getPerspective().getId() == 4) 
			sb.append("' showValues='0' color='"+ColorUtil.PERSPECTIVE_4+"'>");
		//int last=pi.getLatestMonth();
		for (int i=Calendar.JANUARY;i<=Calendar.DECEMBER;i++) {
			PeriodValue p1=pi.getPeriodValueForMonth(i, 1);
			PeriodValue p2=pi.getPeriodValueForMonth(i, 2);
			PeriodValue p3=pi.getPeriodValueForMonth(i, 3);
			if (p1.getIsValid()&&p2.getIsValid()&&p3.getIsValid()&&i==month) {
				sb.append("<set x='" + (-p1.getValue())
						+ "' y='" + (p2.getValue()+p3.getValue())/2
						+ "' z='1' name=' "+DateUtil.getMonthName(Calendar.JANUARY+i)+" "+pi.getYear()+"'");
			}
			
					sb.append(" alpha='100' />");
		
		}
		

		sb.append("</dataSet>");
		

		sb.append("<trendlines>");
		sb
				.append("<line startValue='5.5' endValue='10.7' isTrendZone='1' displayValue='High' color='ff3b3c' alpha='10' rotateLabels='1'/>");
		sb
		.append("<line startValue='0.3' endValue='5.5' isTrendZone='1' displayValue='Low' color='0eb565' alpha='10' rotateLabels='1'/>");
		sb.append("</trendlines>");
		sb.append("<vTrendlines>");
		sb
				.append("<line startValue='-10.5' endValue='-5.5' isTrendZone='1' displayValue='High' color='0eb565' alpha='10'/>");
		sb
				.append("<line startValue='-5.5' endValue='-0.5' isTrendZone='1' displayValue='Low' color='ff3b3c' alpha='10'/>");
		sb.append("</vTrendlines>");

		sb.append("</chart>");

		xmlString = sb.toString();
		LOG.debug("xmlString--->" + xmlString);
		return xmlString;

	}
	
	
	public static String generateYearIPBostonSquare(Risk risk, PeriodInfo pi, int month) {
		String xmlString = "";
		StringBuffer sb = new StringBuffer();

		sb.append("<chart palette='2' is3D='1' animation='1' clipBubbles='1'  bubbleShadow='1'  negativeColor='000000' bubbleScale='0.5'  adjustDiv='0'  numDivLines='1'  divLineAlpha='10' legendMarkerCircle='1'"
						+ "xAxisMaxValue='10.5' xAxisMinValue='0.5' showPlotBorder='0' xAxisName='Impact'  showLegend='0'"
						+ "canvasBgColor='ff3b3c,f4ff5b,0eb565' canvasBgRatio='0,50,50' canvasBgAlpha='30,20,40' canvasBgAngle='131'"
						+ "yAxisName='Probability' yAxisMaxValue='10.7' yAxisMinValue='0.3' chartRightMargin='10' showYAxisValues='0'  canvasBgSWF='../../images/bostonSquareBG.jpg'>");

		sb.append("<dataSet seriesName='" + PERSPECTIVE_1);
		if (risk.getObjective().getPerspective().getId() == 1)
			sb.append("' showValues='0' color='"+ColorUtil.PERSPECTIVE_1+"'>");
		if (risk.getObjective().getPerspective().getId() == 2)
			sb.append("' showValues='0' color='"+ColorUtil.PERSPECTIVE_2+"'>");
		if (risk.getObjective().getPerspective().getId() == 3)
			sb.append("' showValues='0' color='"+ColorUtil.PERSPECTIVE_3+"'>");
		if (risk.getObjective().getPerspective().getId() == 4) 
			sb.append("' showValues='0' color='"+ColorUtil.PERSPECTIVE_4+"'>");
		//int last=pi.getLatestMonth();
		for (int i=Calendar.JANUARY;i<=Calendar.DECEMBER;i++) {
			PeriodValue p2=pi.getPeriodValueForMonth(i, 2);
			PeriodValue p3=pi.getPeriodValueForMonth(i, 3);
			if (p2.getIsValid()&&p3.getIsValid()&&i==month) {
				sb.append("<set x='" + (p3.getValue())
						+ "' y='" + (p2.getValue())
						+ "' z='1' name=' "+(DateUtil.getMonthName(Calendar.JANUARY+i))+" "+pi.getYear()+"'");
			}
			
					sb.append(" alpha='100' />");
		
		}
		

		sb.append("</dataSet>");
		

		sb.append("<trendlines>");
		sb
				.append("<line startValue='5.5' endValue='10.7' isTrendZone='1' displayValue='High' color='ff3b3c' alpha='10' rotateLabels='1'/>");
		sb
		.append("<line startValue='0.3' endValue='5.5' isTrendZone='1' displayValue='Low' color='0eb565' alpha='10' rotateLabels='1'/>");
		sb.append("</trendlines>");
		sb.append("<vTrendlines>");
		sb
				.append("<line startValue='10.5' endValue='5.5' isTrendZone='1' displayValue='High' color='ff3b3c' alpha='10'/>");
		sb
				.append("<line startValue='5.5' endValue='0.5' isTrendZone='1' displayValue='Low' color='0eb565' alpha='10'/>");
		sb.append("</vTrendlines>");

		sb.append("</chart>");

		xmlString = sb.toString();
		LOG.debug("xmlString--->" + xmlString);
		return xmlString;

	}	
	
	public static String generateBostonSquareChartIxPForBostonSquarePage(Collection<Risk> risks){
		String xmlString = "";
		StringBuffer sb = new StringBuffer();

		sb.append("<chart palette='2' is3D='1' animation='1' clipBubbles='1'  bubbleShadow='1'  negativeColor='000000' bubbleScale='0.5'  adjustDiv='0'  numDivLines='1'  divLineAlpha='10' legendMarkerCircle='1'"
						+ "xAxisMaxValue='10.5' xAxisMinValue='0.5' showPlotBorder='0' xAxisName='Impact'  showLegend='1'"
						+ "canvasBgColor='ff3b3c,f4ff5b,0eb565' canvasBgRatio='0,50,50' canvasBgAlpha='30,20,40' canvasBgAngle='131'"
						+ "yAxisName='Probability' yAxisMaxValue='10.7' yAxisMinValue='0.3' chartRightMargin='10' showYAxisValues='0'  canvasBgSWF='../../images/bostonSquareBG.jpg'>");

		PeriodInfo lastPeriodInfo;
		
//		Customer perspective risks
		sb.append("<dataSet seriesName='" + PERSPECTIVE_1+"' showValues='0' color='"+ColorUtil.PERSPECTIVE_1+"'>");
			for(Risk risk : risks){
				if (risk.getObjective().getPerspective().getId() == 1){
					lastPeriodInfo = risk.getLastPeriodInfo();
					if(lastPeriodInfo != null){
					int last=lastPeriodInfo.getLatestMonth();
					for (int i=Calendar.JANUARY;i<=Calendar.DECEMBER;i++) {
						PeriodValue p1=lastPeriodInfo.getPeriodValueForMonth(i, 1);
						PeriodValue p2=lastPeriodInfo.getPeriodValueForMonth(i, 2);
						PeriodValue p3=lastPeriodInfo.getPeriodValueForMonth(i, 3);
						if (p1.getIsValid()&&p2.getIsValid()&&p3.getIsValid()&&i==last) {
							sb.append("<set x='" + (p3.getValue())
									+ "' y='" + (p2.getValue())
									+ "' z='1' name=' "+StringUtil.replaceXml(risk.getDescription())+" "+(DateUtil.getMonthName(Calendar.JANUARY+i))+" "+lastPeriodInfo.getYear()+"'");
						}
						if (i==last)
								sb.append(" alpha='100' />");
						else sb.append(" alpha='50' />");
					}
					}
				}
			}
		sb.append("</dataSet>");
		
//		Financial perspective risks
		sb.append("<dataSet seriesName='" + PERSPECTIVE_2+"' showValues='0' color='"+ColorUtil.PERSPECTIVE_2+"'>");
			for(Risk risk : risks){
				if (risk.getObjective().getPerspective().getId() == 2){
					lastPeriodInfo = risk.getLastPeriodInfo();
					if(lastPeriodInfo != null){
					int last=lastPeriodInfo.getLatestMonth();
					for (int i=Calendar.JANUARY;i<=Calendar.DECEMBER;i++) {
						PeriodValue p1=lastPeriodInfo.getPeriodValueForMonth(i, 1);
						PeriodValue p2=lastPeriodInfo.getPeriodValueForMonth(i, 2);
						PeriodValue p3=lastPeriodInfo.getPeriodValueForMonth(i, 3);
						if (p1.getIsValid()&&p2.getIsValid()&&p3.getIsValid()&&i==last) {
							sb.append("<set x='" + (p3.getValue())
									+ "' y='" + (p2.getValue())
									+ "' z='1' name=' "+StringUtil.replaceXml(risk.getDescription())+" "+(DateUtil.getMonthName(Calendar.JANUARY+i))+" "+lastPeriodInfo.getYear()+"'");
						}
						if (i==last)
								sb.append(" alpha='100' />");
						else sb.append(" alpha='50' />");
					}
					}
				}
			}
		sb.append("</dataSet>");
		
//		Process perspective risks
		sb.append("<dataSet seriesName='" + PERSPECTIVE_3+"' showValues='0' color='"+ColorUtil.PERSPECTIVE_3+"'>");
			for(Risk risk : risks){
				if (risk.getObjective().getPerspective().getId() == 3){
					lastPeriodInfo = risk.getLastPeriodInfo();
					if(lastPeriodInfo != null){
					int last=lastPeriodInfo.getLatestMonth();
					for (int i=Calendar.JANUARY;i<=Calendar.DECEMBER;i++) {
						PeriodValue p1=lastPeriodInfo.getPeriodValueForMonth(i, 1);
						PeriodValue p2=lastPeriodInfo.getPeriodValueForMonth(i, 2);
						PeriodValue p3=lastPeriodInfo.getPeriodValueForMonth(i, 3);
						if (p1.getIsValid()&&p2.getIsValid()&&p3.getIsValid()&&i==last) {
							sb.append("<set x='" + (p3.getValue())
									+ "' y='" + (p2.getValue())
									+ "' z='1' name=' "+StringUtil.replaceXml(risk.getDescription())+" "+(DateUtil.getMonthName(Calendar.JANUARY+i))+" "+lastPeriodInfo.getYear()+"'");
						}
						if (i==last)
								sb.append(" alpha='100' />");
						else sb.append(" alpha='50' />");
					}
					}
				}
			}
		sb.append("</dataSet>");
		
//		Growth & Learning perspective risks
		sb.append("<dataSet seriesName='" + PERSPECTIVE_4+"' showValues='0' color='"+ColorUtil.PERSPECTIVE_4+"'>");
			for(Risk risk : risks){
				if (risk.getObjective().getPerspective().getId() == 4){
					lastPeriodInfo = risk.getLastPeriodInfo();
					if(lastPeriodInfo != null){
					int last=lastPeriodInfo.getLatestMonth();
					for (int i=Calendar.JANUARY;i<=Calendar.DECEMBER;i++) {
						PeriodValue p1=lastPeriodInfo.getPeriodValueForMonth(i, 1);
						PeriodValue p2=lastPeriodInfo.getPeriodValueForMonth(i, 2);
						PeriodValue p3=lastPeriodInfo.getPeriodValueForMonth(i, 3);
						if (p1.getIsValid()&&p2.getIsValid()&&p3.getIsValid()&&i==last) {
							sb.append("<set x='" + (p3.getValue())
									+ "' y='" + (p2.getValue())
									+ "' z='1' name=' "+StringUtil.replaceXml(risk.getDescription())+" "+(DateUtil.getMonthName(Calendar.JANUARY+i))+" "+lastPeriodInfo.getYear()+"'");
						}
						if (i==last)
								sb.append(" alpha='100' />");
						else sb.append(" alpha='50' />");
					}
					}
				}
			}
		sb.append("</dataSet>");
		
		
		


		sb.append("<trendlines>");
		sb
				.append("<line startValue='5.5' endValue='10.7' isTrendZone='1' displayValue='High' color='ff3b3c' alpha='10' rotateLabels='1'/>");
		sb
		.append("<line startValue='0.3' endValue='5.5' isTrendZone='1' displayValue='Low' color='0eb565' alpha='10' rotateLabels='1'/>");
		sb.append("</trendlines>");
		sb.append("<vTrendlines>");
		sb
				.append("<line startValue='10.5' endValue='5.5' isTrendZone='1' displayValue='High' color='ff3b3c' alpha='10'/>");
		sb
				.append("<line startValue='5.5' endValue='0.5' isTrendZone='1' displayValue='Low' color='0eb565' alpha='10'/>");
		sb.append("</vTrendlines>");

		sb.append("</chart>");

		xmlString = sb.toString();
		LOG.debug("xmlString--->" + xmlString);
		return xmlString;
	}
	
	public static String generateBostonSquareChartMxIPForBostonSquarePage(Collection<Risk> risks){
		String xmlString = "";
		StringBuffer sb = new StringBuffer();

		sb.append("<chart palette='2' is3D='1' animation='1' clipBubbles='1'  bubbleShadow='1'  negativeColor='000000' bubbleScale='0.5'  adjustDiv='0'  numDivLines='1'  divLineAlpha='10' legendMarkerCircle='1'"
						+ "xAxisMaxValue='-0.5' xAxisMinValue='-10.5' showPlotBorder='0' xAxisName='Manageability'  showLegend='1'"
						+ "canvasBgColor='ff3b3c,f4ff5b,0eb565' canvasBgRatio='0,50,50' canvasBgAlpha='30,20,40' canvasBgAngle='131'"
						+ "yAxisName='Risk Factor' yAxisMaxValue='10.7' yAxisMinValue='0.3' chartRightMargin='10' showYAxisValues='0'  canvasBgSWF='../../images/bostonSquareBG.jpg'>");

		PeriodInfo lastPeriodInfo;
		
//		Customer perspective risks
		sb.append("<dataSet seriesName='" + PERSPECTIVE_1+"' showValues='0' color='"+ColorUtil.PERSPECTIVE_1+"'>");
			for(Risk risk : risks){
				if (risk.getObjective().getPerspective().getId() == 1){
					lastPeriodInfo = risk.getLastPeriodInfo();
					if(lastPeriodInfo != null){
						int last=lastPeriodInfo.getLatestMonth();
						for (int i=Calendar.JANUARY;i<=Calendar.DECEMBER;i++) {
							PeriodValue p1=lastPeriodInfo.getPeriodValueForMonth(i, 1);
							PeriodValue p2=lastPeriodInfo.getPeriodValueForMonth(i, 2);
							PeriodValue p3=lastPeriodInfo.getPeriodValueForMonth(i, 3);
							if (p1.getIsValid()&&p2.getIsValid()&&p3.getIsValid()) {
								
								sb.append("<set x='" + (-p1.getValue())
										+ "' y='" + (p2.getValue()+p3.getValue())/2
										+ "' z='1' name=' "+StringUtil.replaceXml(risk.getDescription())+" "+DateUtil.getMonthName(Calendar.JANUARY+i)+" "+lastPeriodInfo.getYear()+"'");
								if (i==last)
									sb.append(" alpha='100' />");
								else sb.append(" alpha='50' />");
							}else{
								LOG.debug("Risk "+risk.getDescription()+" is not valid in month #"+i);
//								LOG.debug("p1 is valid--->"+p1.getIsValid());
//								LOG.debug("p2 is valid--->"+p2.getIsValid());
//								LOG.debug("p3 is valid--->"+p3.getIsValid());
								
							}
						}
					}
				}
			}
		sb.append("</dataSet>");
		
//		Financial perspective risks
		sb.append("<dataSet seriesName='" + PERSPECTIVE_2+"' showValues='0' color='"+ColorUtil.PERSPECTIVE_2+"'>");
			for(Risk risk : risks){
				if (risk.getObjective().getPerspective().getId() == 2){
					lastPeriodInfo = risk.getLastPeriodInfo();
					if(lastPeriodInfo != null){
						int last=lastPeriodInfo.getLatestMonth();
						for (int i=Calendar.JANUARY;i<=Calendar.DECEMBER;i++) {
							PeriodValue p1=lastPeriodInfo.getPeriodValueForMonth(i, 1);
							PeriodValue p2=lastPeriodInfo.getPeriodValueForMonth(i, 2);
							PeriodValue p3=lastPeriodInfo.getPeriodValueForMonth(i, 3);
							if (p1.getIsValid()&&p2.getIsValid()&&p3.getIsValid()) {
								sb.append("<set x='" + (-p1.getValue())
										+ "' y='" + (p2.getValue()+p3.getValue())/2
										+ "' z='1' name=' "+StringUtil.replaceXml(risk.getDescription())+" "+DateUtil.getMonthName(Calendar.JANUARY+i)+" "+lastPeriodInfo.getYear()+"'");
								if (i==last)
									sb.append(" alpha='100' />");
								else sb.append(" alpha='50' />");
							}
						}
					}
				}
			}
		sb.append("</dataSet>");
		
//		Process perspective risks
		sb.append("<dataSet seriesName='" + PERSPECTIVE_3+"' showValues='0' color='"+ColorUtil.PERSPECTIVE_3+"'>");
			for(Risk risk : risks){
				if (risk.getObjective().getPerspective().getId() == 3){
					lastPeriodInfo = risk.getLastPeriodInfo();
					if(lastPeriodInfo != null){
						int last=lastPeriodInfo.getLatestMonth();
						for (int i=Calendar.JANUARY;i<=Calendar.DECEMBER;i++) {
							PeriodValue p1=lastPeriodInfo.getPeriodValueForMonth(i, 1);
							PeriodValue p2=lastPeriodInfo.getPeriodValueForMonth(i, 2);
							PeriodValue p3=lastPeriodInfo.getPeriodValueForMonth(i, 3);
							if (p1.getIsValid()&&p2.getIsValid()&&p3.getIsValid()) {
								sb.append("<set x='" + (-p1.getValue())
										+ "' y='" + (p2.getValue()+p3.getValue())/2
										+ "' z='1' name=' "+StringUtil.replaceXml(risk.getDescription())+" "+DateUtil.getMonthName(Calendar.JANUARY+i)+" "+lastPeriodInfo.getYear()+"'");
								if (i==last)
									sb.append(" alpha='100' />");
								else sb.append(" alpha='50' />");
							}
						}
					}
				}
			}
		sb.append("</dataSet>");
		
//		Growth & Learning perspective risks
		sb.append("<dataSet seriesName='" + PERSPECTIVE_4+"' showValues='0' color='"+ColorUtil.PERSPECTIVE_4+"'>");
			for(Risk risk : risks){
				if (risk.getObjective().getPerspective().getId() == 4){
					lastPeriodInfo = risk.getLastPeriodInfo();
					if(lastPeriodInfo != null){
						int last=lastPeriodInfo.getLatestMonth();
						for (int i=Calendar.JANUARY;i<=Calendar.DECEMBER;i++) {
							PeriodValue p1=lastPeriodInfo.getPeriodValueForMonth(i, 1);
							PeriodValue p2=lastPeriodInfo.getPeriodValueForMonth(i, 2);
							PeriodValue p3=lastPeriodInfo.getPeriodValueForMonth(i, 3);
							if (p1.getIsValid()&&p2.getIsValid()&&p3.getIsValid()) {
								sb.append("<set x='" + (-p1.getValue())
										+ "' y='" + (p2.getValue()+p3.getValue())/2
										+ "' z='1' name=' "+StringUtil.replaceXml(risk.getDescription())+" "+DateUtil.getMonthName(Calendar.JANUARY+i)+" "+lastPeriodInfo.getYear()+"'");
								if (i==last)
									sb.append(" alpha='100' />");
								else sb.append(" alpha='50' />");
							}
							
						}
					}
				}
			}
		sb.append("</dataSet>");
		
		
		


		sb.append("<trendlines>");
		sb
				.append("<line startValue='5.5' endValue='10.7' isTrendZone='1' displayValue='High' color='ff3b3c' alpha='10' rotateLabels='1'/>");
		sb
		.append("<line startValue='0.3' endValue='5.5' isTrendZone='1' displayValue='Low' color='0eb565' alpha='10' rotateLabels='1'/>");
		sb.append("</trendlines>");
		
		sb.append("<vTrendlines>");
		sb.append("<line startValue='-10.5' endValue='-5.5' isTrendZone='1' displayValue='High' color='0eb565' alpha='10'/>");
		sb.append("<line startValue='-5.5' endValue='-0.5' isTrendZone='1' displayValue='Low' color='ff3b3c' alpha='10'/>");
		sb.append("</vTrendlines>");

		sb.append("</chart>");

		xmlString = sb.toString();
		LOG.debug("xmlString--->" + xmlString);
		return xmlString;
	}
	
}
