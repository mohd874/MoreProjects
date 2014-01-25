/*
 * Copyright (c) IeMQ.
 * All rights reserved.
 */
package ae.iemq.vims.resource.fusionCharts;

import org.apache.log4j.Logger;

import ae.iemq.vims.domain.Period;

/**
 * This class provides utility methods for populating Fusion Chart elements.
 */
public class FusionChartElementUtil {

	/** The internal logger. */
	static Logger LOG = Logger.getLogger(FusionChartElementUtil.class);

	/**
	 * Constructor for FusionChartElementUtil.
	 */
	public FusionChartElementUtil() {
		super();
	}

	public static String getMonthlyCategoriesByPeriodFrequency(String frequency) {

		StringBuffer sb = new StringBuffer();

		sb.append("<categories>");
		if (frequency != null) {
			if (Period.MONTHLY.equalsIgnoreCase(frequency)) {
				sb.append("<category label='Jan'/>");
				sb.append("<category label='Feb'/>");
				sb.append("<category label='Mar'/>");
				sb.append("<category label='Apr'/>");
				sb.append("<category label='May'/>");
				sb.append("<category label='Jun'/>");
				sb.append("<category label='Jul'/>");
				sb.append("<category label='Aug'/>");
				sb.append("<category label='Sep'/>");
				sb.append("<category label='Oct'/>");
				sb.append("<category label='Nov'/>");
			} else if (Period.QUARTERLY.equalsIgnoreCase(frequency)) {
				sb.append("<category label='Mar'/>");
				sb.append("<category label='Jun'/>");
				sb.append("<category label='Sep'/>");
			} else if (Period.HALF_YEARLY.equalsIgnoreCase(frequency)) {
				sb.append("<category label='Jun'/>");
			}
			sb.append("<category label='Dec'/>");
		}
		sb.append("</categories>");

		return sb.toString();

	}
}