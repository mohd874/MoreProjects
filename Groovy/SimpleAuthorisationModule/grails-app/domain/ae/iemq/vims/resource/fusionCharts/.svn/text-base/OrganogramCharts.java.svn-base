/*
 * Copyright (c) IeMQ.
 * All rights reserved.
 */
package ae.iemq.vims.resource.fusionCharts;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import ae.iemq.vims.domain.OrgUnit;
import ae.iemq.vims.util.StringUtil;

/**
 * This class constructs an XML string used to populate Fusion Charts.
 */
public class OrganogramCharts {

	/** The internal logger. */
	static Logger LOG = Logger.getLogger(OrganogramCharts.class);

	/**
	 * Constructor for MeasureCharts.
	 */
	public OrganogramCharts() {
		super();
	}

	/**
	 * This Method constructs the XML for building an Organogram.
	 * 
	 * @return Sting The XML input to construct the chart.
	 */

	public static String generateOrganogramChart(OrgUnit rootOrgUnit,
			int maxWidth, int maxDepth) {

		StringBuffer sb = new StringBuffer();

		// rather create a little helper object and set all the relevant spacing
		// issues on it

		ArrayList<OrgUnit> chartOrgUnits = new ArrayList<OrgUnit>();
		populateOrgUnits(rootOrgUnit, chartOrgUnits);

		sb
				.append("<chart xAxisMinValue='0' xAxisMaxValue='100' yAxisMinValue='0' yAxisMaxValue='100' bubbleScale='3' is3D='1' numDivLines='0' showFormBtn='0'>");

		sb.append("<dataset plotborderAlpha='100'>");
		int level = 0;
		HashMap<Integer, Integer> xPlotMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> yPlotMap = new HashMap<Integer, Integer>();
		int xPlot = 10;
		int xPlotVariance = 100 / maxWidth;
		int yPlot = 90;
		int yPlotVariance = yPlot / maxDepth;
		for (OrgUnit chartOrg : chartOrgUnits) {
			LOG.debug("FINAL LIST -->" + chartOrg);

			level = chartOrg.getLevel();

			if (yPlotMap.get(level) == null) {
				// This should sort out the spacing between the levels
				if (yPlotMap.get(level - 1) != null) {
					yPlot = yPlotMap.get(level - 1) - yPlotVariance;
				}
				yPlotMap.put(level, yPlot);
			} else {
				yPlot = yPlotMap.get(level);
			}

			if (xPlotMap.get(level) == null) {
				xPlot = 10;
			} else {
				xPlot = xPlotMap.get(level) + xPlotVariance;
			}
			xPlotMap.put(level, xPlot);

			sb.append("<set x='" + xPlot + "' y='" + yPlot
					+ "' width='70' height='50' color='FFFFFF' name='"
					+ StringUtil.replaceXml(chartOrg.getName()) + "' alpha='100' toolText='"
					+ chartOrg.getLevel() + "' id='" + chartOrg.getId() + "' "
					+ setHyperlink(chartOrg.getId()) + "/>");
		}
		sb.append("</dataset>");

		sb.append("<connectors color='000000' stdThickness='8'>");
		int superId = -1;
		int thisId = -1;
		for (OrgUnit chartOrg : chartOrgUnits) {
			LOG.debug("FINAL LIST -->" + chartOrg);
			if (chartOrg.getSuperOrgUnit() != null) {
				superId = chartOrg.getSuperOrgUnit().getId();
				thisId = chartOrg.getId();
				sb.append("<connector strength='0.55' from='" + superId
						+ "' to='" + thisId
						+ "' color='33ccff' arrowAtStart='0' arrowAtEnd='0'/>");
			}
		}
		sb.append("</connectors>");

		sb.append("<styles>");

		sb.append("<definition>");
		sb.append("<style name='myHTMLFont' type='font' isHTML='1'/>");
		sb.append("</definition>");

		sb.append("<application>");
		sb.append("<apply toObject='DATALABELS' styles='myHTMLFont'/>");
		sb.append("<apply toObject='TOOLTIP' styles='myHTMLFont'/>");
		sb.append("</application>");

		sb.append("</styles>");

		sb.append("</chart>");
		String xmlString = sb.toString();

		if (LOG.isDebugEnabled()) {
			LOG.debug("generateOrganogramChart -->" + xmlString);
		}

		return xmlString;

	}

	private static void populateOrgUnits(OrgUnit rootOrgUnit,
			ArrayList<OrgUnit> chartOrgUnits) {

		// this is the root org unit
		LOG.debug("############### ROOT ORG UNIT --> " + rootOrgUnit.getName());
		chartOrgUnits.add(rootOrgUnit);
		populateSubOrgUnits(rootOrgUnit, chartOrgUnits);
	}

	private static void populateSubOrgUnits(OrgUnit orgUnit,
			ArrayList<OrgUnit> chartOrgUnits) {

		for (OrgUnit sub : orgUnit.getNextLevelOrgUnits()) {
			LOG.debug("###############" + orgUnit.getName() + " has child -->"
					+ sub.getName() + " child level -->" + sub.getLevel());
			chartOrgUnits.add(sub);
			populateSubOrgUnits(sub, chartOrgUnits);
		}
	}

	public static String setHyperlink(int id) {

		StringBuffer sb = new StringBuffer();

		// sb.append("link='www.iemq.ae'");
		sb.append("link='");
		sb.append("/VIMSWeb/pages/organogram/OrganogramPage/");
		// + id
		// + "' href='#'></a>");
		sb.append("'");
		return sb.toString();
	}
}