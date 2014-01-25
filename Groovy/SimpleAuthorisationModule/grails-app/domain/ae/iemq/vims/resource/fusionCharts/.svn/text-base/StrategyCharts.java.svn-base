package ae.iemq.vims.resource.fusionCharts;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import ae.iemq.vims.domain.Aspect;
import ae.iemq.vims.domain.OrgUnit;
import ae.iemq.vims.domain.Question;
import ae.iemq.vims.domain.SurveyResponse;
import ae.iemq.vims.resource.ViMSColorUtil;
import ae.iemq.vims.util.StringUtil;


public class StrategyCharts {

	public static final int MINY_SPACING = 4;
	public static final int MINX_SPACING = 8;
	public static final int WIDTH = 60;// Half the width
	public static final int HEIGHT = 40;// Full the height
	public static final int MAX_X = 100;
	public static final int MAX_Y = 100;


	
	// public static int level=0;
	// public static final int PERSPECTIVE_4 = "Growth %26 Learning";

	/** The internal logger. */
	static Logger LOG = Logger.getLogger(StrategyCharts.class);

	/**
	 * Constructor for BostonSquareCharts.
	 */
	public StrategyCharts() {
		super();
	}

	/**
	 * This Method constructs the XML for building a Bubble Chart.
	 * 
	 * @return Sting The XML input to construct the guage.
	 */
	public static String generateOrgUnitChart(OrgUnit rootOrg, Set<OrgUnit> orgs) {

		String xmlString = "";
		StringBuffer sb = new StringBuffer();

		sb
				.append("<chart xAxisMinValue='0' xAxisMaxValue='100' yAxisMinValue='0' yAxisMaxValue='100' bubbleScale='3' "
						+ "is3D='1' numDivLines='0' showFormBtn='0'>");

		sb.append("<dataset plotborderAlpha='100'>");
		sb = drawOrgAndSubs(sb, rootOrg, MAX_X / 2, MAX_Y - MINY_SPACING,orgs);
		System.out.println(rootOrg.getSubOrgUnits().size());
		sb.append("</dataset>");

		sb.append("<connectors color='FE9191' stdThickness='8'>");
		sb = drawConnections(sb, rootOrg);
		sb.append("</connectors>");

		sb.append("<styles>" + "<definition>"
				+ "<style name='myHTMLFont' type='font' isHTML='1'/>"
				+ "</definition>" + "<application>"
				+ "<apply toObject='DATALABELS' styles='myHTMLFont'/>"
				+ "<apply toObject='TOOLTIP' styles='myHTMLFont'/>"
				+ "</application>" + "</styles>");
		sb.append("</chart>");

		xmlString = sb.toString();
		LOG.debug("xmlString--->" + xmlString);
		return xmlString;

	}

	public static StringBuffer drawOrgAndSubs(StringBuffer sb, OrgUnit org,
			float xpos, float ypos, Set<OrgUnit> orgs) {
		sb.append("<set x='"
						+ (xpos)
						+ "' y='"
						+ (ypos)
						+ "' width='60' height='40' name='"
						+ StringUtil.replaceXml(org.getName())
						+ "' color='FE9191' link='n-http://www.InfoSoftGlobal.com' id='"
						+ org.getId() + "'/>");
		LOG.debug("xpos->" + xpos);
		orgs.remove(org);
		int levels = org.getDeepestLevel();
		for (int i = 2; i <= levels; i++) {
			ypos=ypos- (4 * MINY_SPACING);
			int levelsize=org.getOrgUnitsFromLevel(i,orgs).size();
			float xoffset = MAX_X/(levelsize+1);
			float aux = 1;
			for (OrgUnit orgUnit : org.getOrgUnitsFromLevel(i,orgs)) {
				float xspace=aux*xoffset;
				sb.append("<set x='"
						+ (xspace)
						+ "' y='"
						+ (ypos)
						+ "' width='60' height='40' name='"
						+ orgUnit.getId()
						+ "' color='FE9191' link='n-http://www.InfoSoftGlobal.com' id='"
						+ orgUnit.getId() + "'/>");

				LOG.debug(aux);
				aux++;

			}
		}
		return sb;
	}

	public static StringBuffer drawConnections(StringBuffer sb, OrgUnit org) {
		for (OrgUnit orgUnit : org.getSubOrgUnits()) {
			sb.append("<connector strength='0.45' from='" + org.getId()
					+ "' to='" + orgUnit.getId()
					+ "' arrowAtStart='0' arrowAtEnd='0'/>");
			drawConnections(sb, orgUnit);
		}
		return sb;
	}

	public int orgLevels(OrgUnit root) {
		int lev = 1;
		for (OrgUnit org : root.getAllSubOrgUnits()) {
			int aux = 0;
			while (org.getSuperOrgUnit() != null) {
				org = org.getSuperOrgUnit();
				aux++;
			}
			lev = Math.max(lev, aux);
		}
		return lev;
	}
	
	/**
	 * This Method constructs the XML for building a Bulb Guage.
	 * 
	 * @return Sting The XML input to construct the guage.
	 */
	public static String surveyNeedleGauge(SurveyResponse response,
			String bgcolor) {
		String xmlString = "";
		StringBuffer sb = new StringBuffer();
		double percentage = 0;
		percentage=((double)response.getScore()
		/ response.getQuestion().getMaxScore())*100;
		LOG.debug("PERCENTAGE IS---->"+percentage);
		sb.append("<chart lowerLimit='0' upperLimit='100' gaugeStartAngle='180' gaugeEndAngle='0' palette='3' numberSuffix='%25' tickValueDistance='20' showValue='0'>");
		sb.append("<colorRange>");
		sb.append("<color minValue='0' maxValue='33.33' code='FF654F'/>");
		sb.append("<color minValue='33.33' maxValue='66.66' code='F6BD0F'/>");
		sb.append("<color minValue='66.66' maxValue='100' code='8BBA00'/>");
		sb.append(" </colorRange>");
		sb.append("<dials>");
		sb.append(" <dial value='"+percentage+"' rearExtension='10' showValue='0'/>");
		sb.append(" </dials>");
		sb.append("</chart>");

		xmlString = sb.toString();
		LOG.debug("xmlString--->" + xmlString);

		return xmlString;
	}

	/**
	 * This Method constructs the XML for building a Bulb Guage.
	 * 
	 * @return Sting The XML input to construct the guage.
	 */
	public static String historicalSurveyNeedleGauge(Question question,
			String bgcolor) {
		String xmlString = "";
		StringBuffer sb = new StringBuffer();
		double percentage =  0;
		percentage=((double) question.getAverageResponse()
				/ question.getMaxScore())*100;	
		sb.append("<chart lowerLimit='0' upperLimit='100' gaugeStartAngle='180' gaugeEndAngle='0' palette='3' numberSuffix='%25' tickValueDistance='20'  showValue='0'>");
		sb.append("<colorRange>");
		sb.append("<color minValue='0' maxValue='33.33' code='FF654F'/>");
		sb.append("<color minValue='33.33' maxValue='66.66' code='F6BD0F'/>");
		sb.append("<color minValue='66.66' maxValue='100' code='8BBA00'/>");
		sb.append(" </colorRange>");
		sb.append("<dials>");
		sb.append(" <dial value='"+percentage+"' rearExtension='10' showValue='0'/>");
		sb.append(" </dials>");
		sb.append("</chart>");

		xmlString = sb.toString();
		LOG.debug("xmlString--->" + xmlString);

		return xmlString;
	}
	
	
	public static String generateSurveyAnnualColumnChart(int totalScore, List<Object[]> survey2dArray) {

			String xmlString = "";
			StringBuffer sb = new StringBuffer();
			SimpleDateFormat sdf = new SimpleDateFormat();
			sdf.applyPattern("yyyy");
			int nowYear = Calendar.getInstance().get(Calendar.YEAR);

			//Use this service to call the method from page. 
			//survey2dArray = getSurveyService.getHistoricalData(survey);
			
			sb
			.append("<chart palette='3'  yAxisMinValue='0' yAxisMaxValue='1000' caption='Current survey score vs. past surveys average' shownames='1' showvalues='1' decimals='0' useRoundEdges='1'  showLegend='0'  yAxisName='Score'  showAlternateHGridColor='0' alternateHGridAlpha='0'>");
			
			LOG.debug("CURRENT SCORE IS--->"+totalScore);
			LOG.debug("HISTORIC SURVEYS RECOVERED--->"+survey2dArray.size());
			for (int i = 0; i < survey2dArray.size(); i++) {
				
				Object[] fields = survey2dArray.get(i);

				double score = Double.valueOf(fields[0].toString());
				String year = fields[1].toString();
				LOG.debug("SURVEY"+i+"SCORE IS--->"+score);
				LOG.debug("SURVEY"+i+"YEAR IS--->"+year);
			if (year.equalsIgnoreCase(nowYear+"")) {
					sb.append("<set value='" + totalScore + "' label='survey'/>");
				}
				else{
				sb.append("<set value='" + score + "' label='" + year + "' alpha='50'/>");	
				}
			}

			sb.append("<trendLines>"+
			"<line startValue='0' endValue='300' color='FF654F'  isTrendZone='1' displayvalue='Bad'  valueOnRight='1' alpha='50'/>"+
			"<line startValue='300' endValue='600' color='F6BD0F' isTrendZone='1' displayvalue='Good' valueOnRight='1' alpha='50'/>"+
			"<line startValue='600' endValue='1000' color='8BBA00' isTrendZone='1' displayvalue='Excelent' valueOnRight='1' alpha='50'/>"+
			"</trendLines>");
			


		sb.append("</chart>");
		xmlString = sb.toString();

		if (LOG.isDebugEnabled()) {
			LOG.debug(xmlString);
		}

		return xmlString;

	}
	
	public static String generateSurveyHistoricalColumnChart(List<Object[]> survey2dArray) {

		String xmlString = "";
		StringBuffer sb = new StringBuffer();
		//Use this service to call the method from page. 
		//survey2dArray = getSurveyService.getHistoricalData(survey);
		
		sb
		.append("<chart palette='3'  yAxisMinValue='0' yAxisMaxValue='1000' caption='Average Survey Score by year' shownames='1' showvalues='1' decimals='0' useRoundEdges='1'  showLegend='0'  yAxisName='Score'  showAlternateHGridColor='0' alternateHGridAlpha='0'>");
		

		for (int i = 0; i < survey2dArray.size(); i++) {
			
			Object[] fields = survey2dArray.get(i);

			double score = Double.valueOf(fields[0].toString());
			String year = fields[1].toString();
			sb.append("<set value='" + score + "' label='" + year + "'/>");	
			
		}

		sb.append("<trendLines>"+
				"<line startValue='0' endValue='300' color='FF654F'  isTrendZone='1' displayvalue='Bad'  valueOnRight='1' alpha='50'/>"+
				"<line startValue='300' endValue='600' color='F6BD0F' isTrendZone='1' displayvalue='Good' valueOnRight='1' alpha='50'/>"+
				"<line startValue='600' endValue='1000' color='8BBA00' isTrendZone='1' displayvalue='Excelent' valueOnRight='1' alpha='50'/>"+
				"</trendLines>");


	sb.append("</chart>");
	xmlString = sb.toString();

	if (LOG.isDebugEnabled()) {
		LOG.debug(xmlString);
	}

	return xmlString;

}
	
	public static String generateBulbChart(Aspect.Status status,String bgColor){
		String xmlString = "";
		StringBuffer sb = new StringBuffer();
		
		final int MAX_VALUE = 100;
		final int GREEN_VALUE = 75;
		final int YELLOW_VALUE = 50;
		final int RED_VALUE = 25;
		final int WHITE_VALUE=0;

		sb.append("<chart upperLimit='"+MAX_VALUE+"' lowerLimit='"+WHITE_VALUE+"' numberSuffix='%25' " +
				"placeValuesInside='1' showGaugeBorder='1' gaugeFillAlpha='100' gaugeBorderColor='666666' bgAlpha='100' borderAlpha='100' bgColor='"+bgColor+"' borderColor='"+bgColor+"' "+
				"gaugeBorderThickness='1' gaugeBorderAlpha='100' useColorNameAsValue='1'>");
		
		sb.append("<colorRange>");
		sb.append("<color minValue='"+(WHITE_VALUE)+"' maxValue='"+(RED_VALUE)+"' label='' code='"+ViMSColorUtil.WHITE+"' alpha='100'/>");
		sb.append("<color minValue='"+(RED_VALUE)+"' maxValue='"+(YELLOW_VALUE)+"' label='' code='"+ViMSColorUtil.ROBOT_RED+"' alpha='100'/>");
		sb.append("<color minValue='"+(YELLOW_VALUE)+"' maxValue='"+(GREEN_VALUE)+"' label='' code='"+ViMSColorUtil.ROBOT_YELLOW+"' alpha='100'/>");
		sb.append("<color minValue='"+(GREEN_VALUE)+"' maxValue='"+(MAX_VALUE)+"' label='' code='"+ViMSColorUtil.ROBOT_GREEN+"' alpha='100'/>");
		sb.append("</colorRange>");
		
		if (status == Aspect.Status.WHITE){
			sb.append("<value>"+WHITE_VALUE+"</value>");
		}
		else if (status == Aspect.Status.RED){
			sb.append("<value>"+RED_VALUE+"</value>");
		}
		else if (status == Aspect.Status.YELLOW){
			sb.append("<value>"+YELLOW_VALUE+"</value>");
		}
		else if (status == Aspect.Status.GREEN){
			sb.append("<value>"+GREEN_VALUE+"</value>");
		}
		
		sb.append("</chart>");
		
		xmlString = sb.toString();
		LOG.debug("xmlString--->"+xmlString);
		
		return xmlString;
	}
	
}
