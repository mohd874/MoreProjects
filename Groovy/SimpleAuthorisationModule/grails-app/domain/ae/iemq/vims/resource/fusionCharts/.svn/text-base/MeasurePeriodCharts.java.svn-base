/*
 * Copyright (c) IeMQ.
 * All rights reserved.
 */
package ae.iemq.vims.resource.fusionCharts;

import java.util.List;

import org.apache.log4j.Logger;

import ae.iemq.vims.domain.Period;
import ae.iemq.vims.domain.balancedScorecard.Measure;
import ae.iemq.vims.domain.balancedScorecard.MeasurePeriod;
import ae.iemq.vims.domain.balancedScorecard.Measure.TargetPrefix;
import ae.iemq.vims.resource.ViMSColorUtil;
import ae.iemq.vims.util.StringUtil;

/**
 * This class constructs an XML string used to populate Fusion Charts.
 */
public class MeasurePeriodCharts {

	/** The internal logger. */
	static Logger LOG = Logger.getLogger(MeasurePeriodCharts.class);

	/**
	 * Constructor for MeasurePeriodCharts.
	 */
	public MeasurePeriodCharts() {
		super();
	}

	/**
	 * This Method constructs the XML for building a Measure Bar Guage.
	 * 
	 * @return Sting The XML input to construct the guage.
	 */
	public static String generateMeasurePeriodPercentageBarGuage(
			MeasurePeriod measurePeriod) {

		float targetValue = 100;
		float actualValue = (measurePeriod.barGraphFraction() * 100);
		float lowerValue = 0;
		float upperValue = 200;
		float majorNumberTics = 10;
		float minorNumberTics = 5;

		return constructMeasureBarGuage(measurePeriod, targetValue,
				actualValue, lowerValue, upperValue, majorNumberTics,
				minorNumberTics);

	}

	/**
	 * This Method constructs the XML for building a Measure Bar Guage.
	 * 
	 * @return Sting The XML input to construct the guage.
	 */
	public static String generateMeasurePeriodActualBarGuage(
			MeasurePeriod measurePeriod) {

		float majorNumberTics = 10;
		float minorNumberTics = 5;
		float targetValue = measurePeriod.getTargetYtdTotal();
		float actualValue = measurePeriod.getActualYtdTotal();
		float lowerValue = 0;
		float upperValue = targetValue * 2;
		if (targetValue == 0) {
			lowerValue = -1;
			upperValue = 2;
		}
		if (targetValue >= 10000) {
			majorNumberTics = 5;
			minorNumberTics = 0;
		}		

		return constructMeasureBarGuage(measurePeriod, targetValue,
				actualValue, lowerValue, upperValue, majorNumberTics,
				minorNumberTics);

	}

	private static String constructMeasureBarGuage(MeasurePeriod measurePeriod,
			float targetValue, float actualValue, float lowerValue,
			float upperValue, float majorNumberTics, float minorNumberTics) {
		StringBuffer sb = new StringBuffer();

		sb
				.append("<chart upperLimit='"
						+ upperValue
						+ "' lowerLimit='"
						+ lowerValue
						+ "' palette='2' gaugeBorderColor='{dark-30}' gaugeRoundRadius='5' majorTMNumber='"
						+ majorNumberTics + "' minorTMNumber='"
						+ minorNumberTics + "' showBorder='1'>");

		sb.append("<pointers>");
		// actual / target ytd
		sb.append("<pointer value='" + actualValue + "' bgColor='000000'/>");
		sb.append("</pointers>");

		sb.append("<trendpoints>");
		sb
				.append("<point startValue='"
						+ targetValue
						+ "' displayValue=' ' color='000000' thickness='2' alpha='100' showOnTop='0' useMarker='1' markerColor='F1f1f1' markerBorderColor='666666' markerRadius='7' markerTooltext='"
						+ targetValue + "'/>");
		sb.append("</trendpoints>");

		sb.append(paintBarGuageColourRange(measurePeriod, lowerValue,
				targetValue, upperValue));

		sb.append("</chart>");

		String xmlString = sb.toString();

		if (LOG.isDebugEnabled()) {
			LOG.debug(xmlString);
		}

		return xmlString;
	}

	private static String paintBarGuageColourRange(MeasurePeriod measurePeriod,
			double lowerValue, double targetValue, double upperValue) {

		// default values
		String firstColourCode;
		String secondColourCode;
		String thirdColourCode = null;
		double firstMaxValue = targetValue;
		double secondMinValue = targetValue;
		double secondMaxValue = 0;
		double thirdMinValue = 0;
		double thirdMaxValue = 0;

		TargetPrefix prefix = measurePeriod.getMeasure().getBasePrefix();

		StringBuffer sb = new StringBuffer();
		sb.append("<colorRange>");
		// WARNING the order is important
		if (prefix == Measure.TargetPrefix.Range
				|| prefix == Measure.TargetPrefix.InversedRange || prefix == Measure.TargetPrefix.Equal) {
			String baseStr = StringUtil
					.getNumericValueIncludingDecimal(measurePeriod.getMeasure()
							.getBase());
			double baseValue = 0.01;
			if (!(prefix == Measure.TargetPrefix.Equal)) {
				try {
					baseValue = Double.valueOf(baseStr).doubleValue();
				} catch (Exception e) {
					LOG
							.error("The base target contains more than one decimal point!!");
				}
			}

			if (prefix == Measure.TargetPrefix.InversedRange) {
				firstColourCode = ViMSColorUtil.ROBOT_GREEN;
				secondColourCode = ViMSColorUtil.ROBOT_RED;
				thirdColourCode = ViMSColorUtil.ROBOT_GREEN;
				firstMaxValue = (targetValue - baseValue);
				secondMinValue = (targetValue - baseValue);
				secondMaxValue = (targetValue + baseValue);
				thirdMinValue = (targetValue + baseValue);
				thirdMaxValue = upperValue;
			} else {
				firstColourCode = ViMSColorUtil.ROBOT_RED;
				secondColourCode = ViMSColorUtil.ROBOT_GREEN;
				thirdColourCode = ViMSColorUtil.ROBOT_RED;
				firstMaxValue = (targetValue - baseValue);
				secondMinValue = (targetValue - baseValue);
				secondMaxValue = (targetValue + baseValue);
				thirdMinValue = (targetValue + baseValue);
				thirdMaxValue = upperValue;
			}
		} else if (prefix == Measure.TargetPrefix.Equal) {
			String colour = getMeasurePeriodRobotColour(measurePeriod);
			firstColourCode = colour;
			secondColourCode = colour;
		} else if (prefix == Measure.TargetPrefix.LessThan
				|| prefix == Measure.TargetPrefix.LessThanAndEqual) {
			firstColourCode = ViMSColorUtil.ROBOT_GREEN;
			secondColourCode = ViMSColorUtil.ROBOT_RED;
		} else {
			firstColourCode = ViMSColorUtil.ROBOT_RED;
			secondColourCode = ViMSColorUtil.ROBOT_GREEN;
		}

		sb.append("<color minValue='" + lowerValue + "' maxValue='"
				+ firstMaxValue + "' code='" + firstColourCode + "'/>");
		sb.append("<color minValue='" + secondMinValue + "' maxValue='"
				+ secondMaxValue + "'code='" + secondColourCode + "'/>");
		if (thirdColourCode != null) {
			sb.append("<color minValue='" + thirdMinValue + "' maxValue='"
					+ thirdMaxValue + "'code='" + thirdColourCode + "'/>");
		}

		sb.append("</colorRange>");

		if (LOG.isDebugEnabled()) {
			LOG.debug("firstColourCode-->" + firstColourCode);
			LOG.debug("secondColourCode-->" + secondColourCode);
			LOG.debug("thirdColourCode-->" + thirdColourCode);
			LOG.debug("firstMinValue-->" + lowerValue);
			LOG.debug("firstMaxValue-->" + firstMaxValue);
			LOG.debug("secondMinValue-->" + secondMinValue);
			LOG.debug("secondMaxValue-->" + secondMaxValue);
			LOG.debug("thirdMinValue-->" + thirdMinValue);
			LOG.debug("thirdMaxValue-->" + thirdMaxValue);
		}

		return sb.toString();
	}

//	/**
//	 * This Method constructs the XML for building a Horizontal bullet.
//	 * 
//	 * @return Sting The XML input to construct the guage.
//	 */
//	public static String generateMeasureHorizontalBullet(
//			MeasurePeriod measurePeriod) {
//
//		float ytdFraction = measurePeriod.barGraphFraction();
//		float actualYTD = measurePeriod.getActualYtdTotal();
//		float targetYTD = measurePeriod.getTargetYtdTotal();
//		float upperLimit = targetYTD;
//		if (actualYTD > targetYTD) {
//			upperLimit = actualYTD;
//		}
//		double absUpperLimit = Math.abs(upperLimit * 1.1);
//		long longUpperLimit = Math.round(absUpperLimit);
//		String fixedUpperLimit = Long.toString(longUpperLimit);
//
//		if (LOG.isDebugEnabled()) {
//			LOG.debug("Fraction -->" + ytdFraction);
//			LOG.debug("actualYTD -->" + actualYTD);
//			LOG.debug("targetYTD -->" + targetYTD);
//			LOG.debug("upperLimit -->" + upperLimit);
//			LOG.debug("fixedUpperLimit -->" + fixedUpperLimit);
//		}
//
//		StringBuffer sb = new StringBuffer();
//		int isInversed = measurePeriod.getInversed();
//		String plotColour = "669933";
//		if ((isInversed == 1 && (actualYTD > targetYTD))
//				|| ((isInversed == 0) && (actualYTD < targetYTD))) {
//			// bad news keep it red
//			plotColour = "FF654F";
//		} else {
//			plotColour = "8BBA00";
//		}
//		sb
//				.append("<chart plotFillColor='"
//						+ plotColour
//						+ "' plotFillAlpha='90' targetColor='3F3F3F' targetThickness='4' palette='2' animation='1' lowerLimit='0' upperLimit='"
//						+ fixedUpperLimit
//						+ "' showShadow='1' caption='' colorRangeFillRatio='0,10,80,10' showColorRangeBorder='0' roundRadius='0' showValue='1'>");
//
//		sb.append("<colorRange>");
//		sb.append("<color minValue='0' maxValue='" + targetYTD + "'/>");
//		sb.append("<color minValue='" + targetYTD + "' maxValue='"
//				+ fixedUpperLimit + "'/>");
//		sb.append("</colorRange>");
//		sb.append("<value>" + actualYTD + "</value>");
//		sb.append("<target>" + targetYTD + "</target>");
//
//		sb.append("</chart>");
//
//		String xmlString = sb.toString();
//
//		if (LOG.isDebugEnabled()) {
//			LOG.debug(xmlString);
//		}
//
//		return xmlString;
//
//	}

	/**
	 * This Method constructs the XML for building a Measure 2D Column chart.
	 * 
	 * @return Sting The XML input to construct the guage.
	 */
	public static String generateMeasureMulti2DColumnChart(
			MeasurePeriod measurePeriod) {

		StringBuffer sb = new StringBuffer();
		String measureFrequency = getMeasurePeriodFrequency(measurePeriod);

		String unit = measurePeriod.getMeasure().getUnit();
		if (unit == null) {
			unit = "";
		}

		sb
				.append("<chart palette='2' caption='Actual vs. Target' shownames='1' showvalues='0' decimals='0' useRoundEdges='1' legendBorderAlpha='0'>");
		// sb.append("<chart palette='2' caption='Actual vs. Target'
		// shownames='1' showvalues='0' decimals='0' numberPrefix='$'
		// useRoundEdges='1' legendBorderAlpha='0'>");
		// sb.append("<chart palette='2' caption='Actual vs. Target'
		// shownames='1' showvalues='0' decimals='0' numberPrefix='" + unit + "'
		// useRoundEdges='1' legendBorderAlpha='0'>");

		sb.append(FusionChartElementUtil
				.getMonthlyCategoriesByPeriodFrequency(measurePeriod
						.getMeasure().getFrequency()));

		sb
				.append("<dataset seriesName='Actual' color='AFD8F8' showValues='0'>");
		if (measureFrequency.equalsIgnoreCase(Period.MONTHLY)) {
			sb.append("<set value='" + measurePeriod.getActualMonthlyFigure(0) + "'/>");
			sb.append("<set value='" + measurePeriod.getActualMonthlyFigure(1) + "'/>");
		}
		if (measureFrequency.equalsIgnoreCase(Period.MONTHLY)
				|| measureFrequency.equalsIgnoreCase(Period.QUARTERLY)) {
			sb.append("<set value='" + measurePeriod.getActualMonthlyFigure(2) + "'/>");
		}
		if (measureFrequency.equalsIgnoreCase(Period.MONTHLY)) {
			sb.append("<set value='" + measurePeriod.getActualMonthlyFigure(3) + "'/>");
			sb.append("<set value='" + measurePeriod.getActualMonthlyFigure(4) + "'/>");
		}
		if (!measureFrequency.equalsIgnoreCase(Period.YEARLY)) {
			sb.append("<set value='" + measurePeriod.getActualMonthlyFigure(5) + "'/>");
		}
		if (measureFrequency.equalsIgnoreCase(Period.MONTHLY)) {
			sb.append("<set value='" + measurePeriod.getActualMonthlyFigure(6) + "'/>");
			sb.append("<set value='" + measurePeriod.getActualMonthlyFigure(7) + "'/>");
		}
		if (measureFrequency.equalsIgnoreCase(Period.MONTHLY)
				|| measureFrequency.equalsIgnoreCase(Period.QUARTERLY)) {
			sb.append("<set value='" + measurePeriod.getActualMonthlyFigure(8) + "'/>");
		}
		if (measureFrequency.equalsIgnoreCase(Period.MONTHLY)) {
			sb.append("<set value='" + measurePeriod.getActualMonthlyFigure(9) + "'/>");
			sb.append("<set value='" + measurePeriod.getActualMonthlyFigure(10) + "'/>");
		}
		sb.append("<set value='" + measurePeriod.getActualMonthlyFigure(11) + "'/>");
		sb.append("</dataset>");

		sb
				.append("<dataset seriesName='Target' color='F6BD0F' showValues='0'>");
		if (measureFrequency.equalsIgnoreCase(Period.MONTHLY)) {
			sb.append("<set value='" + measurePeriod.getTargetMonthlyFigure(0) + "'/>");
			sb.append("<set value='" + measurePeriod.getTargetMonthlyFigure(1) + "'/>");
		}
		if (measureFrequency.equalsIgnoreCase(Period.MONTHLY)
				|| measureFrequency.equalsIgnoreCase(Period.QUARTERLY)) {
			sb.append("<set value='" + measurePeriod.getTargetMonthlyFigure(2) + "'/>");
		}
		if (measureFrequency.equalsIgnoreCase(Period.MONTHLY)) {
			sb.append("<set value='" + measurePeriod.getTargetMonthlyFigure(3) + "'/>");
			sb.append("<set value='" + measurePeriod.getTargetMonthlyFigure(4) + "'/>");
		}
		if (!measureFrequency.equalsIgnoreCase(Period.YEARLY)) {
			sb.append("<set value='" + measurePeriod.getTargetMonthlyFigure(5) + "'/>");
		}
		if (measureFrequency.equalsIgnoreCase(Period.MONTHLY)) {
			sb.append("<set value='" + measurePeriod.getTargetMonthlyFigure(6) + "'/>");
			sb.append("<set value='" + measurePeriod.getTargetMonthlyFigure(7) + "'/>");
		}
		if (measureFrequency.equalsIgnoreCase(Period.MONTHLY)
				|| measureFrequency.equalsIgnoreCase(Period.QUARTERLY)) {
			sb.append("<set value='" + measurePeriod.getTargetMonthlyFigure(8) + "'/>");
		}
		if (measureFrequency.equalsIgnoreCase(Period.MONTHLY)) {
			sb.append("<set value='" + measurePeriod.getTargetMonthlyFigure(9) + "'/>");
			sb.append("<set value='" + measurePeriod.getTargetMonthlyFigure(10) + "'/>");
		}
		sb.append("<set value='" + measurePeriod.getTargetMonthlyFigure(11) + "'/>");
		sb.append("</dataset>");

		sb.append("</chart>");
		String xmlString = sb.toString();

		if (LOG.isDebugEnabled()) {
			LOG.debug(xmlString);
		}

		return xmlString;

	}

	/**
	 * This Method constructs the XML for building a Measure 2D Column chart.
	 * 
	 * @return Sting The XML input to construct the guage.
	 */
	public static String generateMeasurePieChart(MeasurePeriod measurePeriod) {

		StringBuffer sb = new StringBuffer();
		String measureFrequency = measurePeriod.getMeasure().getFrequency();

		sb.append("<chart palette='4' defaultAnimation='1'>");
		if (Period.MONTHLY.equalsIgnoreCase(measureFrequency)) {
			sb.append("<set label='Jan' value='" + measurePeriod.getActualMonthlyFigure(0)
					+ "' isSliced='1'/>");
			sb.append("<set label='Feb' value='" + measurePeriod.getActualMonthlyFigure(1)
					+ "' isSliced='1'/>");
		}
		if (Period.MONTHLY.equalsIgnoreCase(measureFrequency)
				|| Period.QUARTERLY.equalsIgnoreCase(measureFrequency)) {
			sb.append("<set label='Mar' value='"
					+ measurePeriod.getActualMonthlyFigure(2) + "' isSliced='1'/>");
		}
		if (Period.MONTHLY.equalsIgnoreCase(measureFrequency)) {
			sb.append("<set label='Apr' value='"
					+ measurePeriod.getActualMonthlyFigure(3) + "' isSliced='1'/>");
			sb.append("<set label='May' value='" + measurePeriod.getActualMonthlyFigure(4)
					+ "' isSliced='1'/>");
		}
		if (!Period.YEARLY.equalsIgnoreCase(measureFrequency)) {
			sb.append("<set label='Jun' value='"
					+ measurePeriod.getActualMonthlyFigure(5) + "' isSliced='1'/>");
		}
		if (Period.MONTHLY.equalsIgnoreCase(measureFrequency)) {
			sb.append("<set label='Jul' value='"
					+ measurePeriod.getActualMonthlyFigure(6) + "' isSliced='1'/>");
			sb.append("<set label='Aug' value='" + measurePeriod.getActualMonthlyFigure(7)
					+ "' isSliced='1'/>");
		}
		if (Period.MONTHLY.equalsIgnoreCase(measureFrequency)
				|| measureFrequency.equalsIgnoreCase(Period.QUARTERLY)) {
			sb.append("<set label='Sep' value='"
					+ measurePeriod.getActualMonthlyFigure(8) + "' isSliced='1'/>");
		}
		if (Period.MONTHLY.equalsIgnoreCase(measureFrequency)) {
			sb.append("<set label='Oct' value='" + measurePeriod.getActualMonthlyFigure(9)
					+ "' isSliced='1'/>");
			sb.append("<set label='Nov' value='" + measurePeriod.getActualMonthlyFigure(10)
					+ "' isSliced='1'/>");
		}
		sb.append("<set label='Dec' value='" + measurePeriod.getActualMonthlyFigure(11)
				+ "' isSliced='1'/>");
		sb.append("</chart>");

		String xmlString = sb.toString();

		if (LOG.isDebugEnabled()) {
			LOG.debug(xmlString);
		}

		return xmlString;

	}

	private static String getMeasurePeriodFrequency(MeasurePeriod mp) {
		String measureFrequency = mp.getMeasure().getFrequency();
		if (measureFrequency == null) {
			measureFrequency = Period.MONTHLY;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("measureFrequency-->" + measureFrequency);
		}

		return measureFrequency;
	}

	/**
	 * This Method constructs the XML for building a Bulb Guage.
	 * 
	 * @return Sting The XML input to construct the guage.
	 */
	public static String generateBulbChart(MeasurePeriod measurePeriod,
			String color) {

		return getMeasurePeriodRobot(measurePeriod, color, false, 1);
	}

	/**
	 * This Method constructs the XML for building a Bulb Guage.
	 * 
	 * @return Sting The XML input to construct the guage.
	 */
	public static String generateMeasurePeriodRobot(MeasurePeriod measurePeriod) {

		return getMeasurePeriodRobot(measurePeriod, "#FFFFFF", false, 2);
	}

	/**
	 * This Method constructs the XML for building a Bulb Guage.
	 * 
	 * @return Sting The XML input to construct the guage. formatType used for
	 *         custom cosmetics
	 */
	private static String getMeasurePeriodRobot(MeasurePeriod measurePeriod,
			String bgcolor, boolean showValue, int formatType) {

		String xmlString = "";
		StringBuffer sb = new StringBuffer();

		sb.append("<chart lowerLimit='" + Integer.MIN_VALUE + "' upperLimit='"
				+ Integer.MAX_VALUE + "'");
		if (showValue) {
			sb.append(" numberSuffix='%30' placeValuesInside='" + 1 + "'");
		} else {
			sb.append(" showValue='0'");
		}

		if (formatType == 1) {//formatType 1 refers to the bulb in the measure Matrix Page
			sb
					.append(" gaugeFillAlpha='100' showGaugeBorder='1' gaugeBorderColor='666666' "
							+ "gaugeBorderThickness='1' gaugeBorderAlpha='100'"
							+ "bgAlpha='100' borderAlpha='100' bgColor='"
							+ bgcolor + "' borderColor='"+bgcolor+"'>");
		}

		if (formatType == 2) {//formatType 2 refers to the bulb inside the measure Period Page
			sb
					.append("palette='2' gaugeBorderColor='{dark-30}' showBorder='1' >");

		}

		sb.append("<colorRange>");
		sb.append("<color minValue='" + Integer.MIN_VALUE + "' maxValue='"
				+ Integer.MAX_VALUE + "' label='' code='"
				+ getMeasurePeriodRobotColour(measurePeriod)
				+ "' alpha='100' />");
		sb.append(" </colorRange>");
		if (getMeasurePeriodRobotColour(measurePeriod) == ViMSColorUtil.WHITE) {
			sb.append("<value>" + "0");
		} else {
			sb.append("<value>" + (measurePeriod.barGraphFraction() * 100));
		}
		sb.append("</value>");
		sb.append("</chart>");

		xmlString = sb.toString();
		LOG.debug("BULB xmlString--->" + xmlString);

		return xmlString;
	}

	public static String getMeasurePeriodRobotColour(
			MeasurePeriod measurePeriod) {
		String robotColour = null;
		if (measurePeriod == null || !measurePeriod.hasChildValues()) {
			return ViMSColorUtil.WHITE;
		}

		float actualYtd = measurePeriod.getActualYtdTotal();
		float targetYtd = measurePeriod.getTargetYtdTotal();
		TargetPrefix prefix = measurePeriod.getMeasure().getBasePrefix();
		// WARNING the order is important
		if (prefix == Measure.TargetPrefix.Equal && (actualYtd == targetYtd)) {
			robotColour = ViMSColorUtil.ROBOT_GREEN;
		} else if (prefix == Measure.TargetPrefix.LessThan && (actualYtd < targetYtd)) {
				robotColour = ViMSColorUtil.ROBOT_GREEN;
		} else if (prefix == Measure.TargetPrefix.LessThanAndEqual
				&& (actualYtd <= targetYtd)) {
			robotColour = ViMSColorUtil.ROBOT_GREEN;
		} else if (prefix == Measure.TargetPrefix.GreaterThan
				&& (actualYtd > targetYtd)) {
			robotColour = ViMSColorUtil.ROBOT_GREEN;
		} else if (prefix == Measure.TargetPrefix.GreaterThanAndEqual
				&& (actualYtd >= targetYtd)) {
			robotColour = ViMSColorUtil.ROBOT_GREEN;
		}

		if (robotColour == null) {
			String baseStr = StringUtil
					.getNumericValueIncludingDecimal(measurePeriod.getMeasure()
							.getBase());
			double baseValue = 0.00001;
			try {
				baseValue = Double.valueOf(baseStr).doubleValue();
			} catch (Exception e) {
				LOG
						.error("The base target contains more than one decimal point!!");
				return ViMSColorUtil.ROBOT_RED;
			}
			if (prefix == Measure.TargetPrefix.Range) {
				if (actualYtd >= targetYtd * ((100 - baseValue) / 100)
						&& actualYtd <= targetYtd * (100 + baseValue)) {
					robotColour = ViMSColorUtil.ROBOT_GREEN;
				}

			} else if (prefix == Measure.TargetPrefix.InversedRange) {
				if (actualYtd <= targetYtd * ((100 - baseValue) / 100)
						|| actualYtd >= targetYtd * (100 + baseValue)) {
					robotColour = ViMSColorUtil.ROBOT_GREEN;
				}
			}
		}
		// the method only sets green if not green then its red
		// white is checked up front
		if (robotColour == null) {
			robotColour = ViMSColorUtil.ROBOT_RED;
			LOG.debug("ROBOT COLOUR IS NULL,SET TO RED");
		}

		return robotColour;
	}

	/**
	 * This Method constructs the XML for building a Line Chart.
	 * 
	 * @return Sting The XML input to construct the guage.
	 */
	public static String generateLineChart(List<Object[]> annualAvgMeasures) {

		String xmlString = "";
		StringBuffer sb = new StringBuffer();

		// creating the chart title and some basic propirties
		sb
				.append("<chart caption='Performance Rate' xAxisName='Year' yAxisName='Performace' showValues='0'>");

		// adding values and years

		Integer tempYear = null;
		double tempAvgMeasures;

		for (int i = 0; i < annualAvgMeasures.size(); i++) {
			Object[] fields = annualAvgMeasures.get(i);
			tempYear = Integer.valueOf(fields[0].toString());
			tempAvgMeasures = Double.valueOf(fields[1].toString());
			sb.append("<set label='" + tempYear + "' value='" + tempAvgMeasures
					+ "' />");
		}

		// adding animation style to the graph
		sb.append("<styles>");

		sb.append("<definition>");
		sb
				.append("<style name='CanvasAnim' type='animation' param='_xScale' start='0' duration='1' />");
		sb.append("</definition>");

		sb.append("<application>");
		sb.append("<apply toObject='Canvas' styles='CanvasAnim' />");
		sb.append("</application>");

		sb.append("</styles>");

		sb.append("</chart>");

		xmlString = sb.toString();
		LOG.debug("xmlString--->" + xmlString);
		return xmlString;
	}

	/*
	 * @todo finnish this graph for the measure period screen
	 * 
	 * this must be a 2d single y combo chart with two trends
	 * 
	 */
	/*
	 * public static String generatePlottedLineForPeriod( MeasurePeriod
	 * measurePeriod) { }
	 */
}