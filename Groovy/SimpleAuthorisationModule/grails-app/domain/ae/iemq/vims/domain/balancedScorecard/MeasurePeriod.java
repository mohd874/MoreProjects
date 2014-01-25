/* Copyright TRANSCODE 2007.*/
package ae.iemq.vims.domain.balancedScorecard;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.log4j.Logger;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import ae.iemq.vims.domain.BaseEntity;
import ae.iemq.vims.domain.Period;

@SqlResultSetMappings( { @SqlResultSetMapping(name = "MeasurePeriod.getAverageMeasuresByYear", columns = {
		@ColumnResult(name = "distinctYear"),
		@ColumnResult(name = "avgMeasures") }) })
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "measure_period")
@NamedQueries( { @NamedQuery(name = "MeasurePeriod.measurePeriodByYear", query = "select measurePeriod from MeasurePeriod measurePeriod "
		+ "where measurePeriod.year = :year "
		+ "and measurePeriod.measure = :measure") })
public class MeasurePeriod extends BaseEntity {

	private static Logger LOG = Logger.getLogger(MeasurePeriod.class);

	/** ACTUAL_VALUE int. */
	public static final int ACTUAL_VALUE = 1;

	/** TARGET_VALUE int. */
	public static final int TARGET_VALUE = 2;

	/**
	 * serialVersionUID long.
	 */
	// private static final long serialVersionUID = -20071223L;
	/** YEAR_TO_DATE. */
	public static final int YEAR_TO_DATE = Calendar.YEAR;

	/** measure Measure. */
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "measure", referencedColumnName = "id")
	@ManyToOne
	private Measure measure;

	@Column(name = "measure_period_year")
	private int year;

	/** actualYtdTotal. */
	@Column(name = "actual_ytd_total")
	private float actualYtdTotal;

	/** targetYtdTotal. */
	@Column(name = "target_ytd_total")
	private float targetYtdTotal;

	/** ytdActualTotalAsString. */
	@Transient
	private String ytdActualTotalAsString;

	/** ytdTargetTotalAsString. */
	@Transient
	private String ytdTargetTotalAsString;

	/**
	 * comment String.
	 * 
	 * @todo move comment to period values
	 */
	@Column(name = "comment")
	private String comment;

	/** prefix String. */
	@Column(name = "prefix")
	private String prefix;

	/** decimalPoints boolean. */
	@Column(name = "has_decimals")
	private boolean decimalPoints;

	/** datasourceLink boolean. */
	@Column(name = "has_datasource")
	private boolean datasourceLink;

	/** calc engine reference String. */
	@Column(name = "calc_engine_ref")
	private String calcEngineRef;

	/** calc engine reference String. */
	@Column(name = "control_xml_file")
	private String controlXmlFile;

	/** associated MeasurePeriodValues. */
	@OneToMany(mappedBy = "measurePeriod", fetch = FetchType.EAGER, cascade = {
			CascadeType.PERSIST, CascadeType.ALL })
	@OrderBy("month")
	private Set<MeasurePeriodValues> values;

	/** additionalDataCollection Collection<Object>. */
	@Transient
	private Collection<Object> additionalDataCollection = new ArrayList<Object>();

	/** calc engine reference String. */
	@Column(name = "additional_data")
	private String additionalData;

	/**
	 * getMeasure method.
	 * 
	 * @return the measure of type Measure.
	 */
	public Measure getMeasure() {
		return measure;
	}

	/**
	 * setMeasure method
	 * 
	 * @param measure
	 *            the measure of type Measure to set.
	 */
	public void setMeasure(Measure measure) {
		this.measure = measure;
	}

	/**
	 * getPrefix method.
	 * 
	 * @return the prefix of type String.
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * setPrefix method
	 * 
	 * @param prefix
	 *            the prefix of type String to set.
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * getValues method.
	 * 
	 * @return the values of type Map.
	 */
	public Set<MeasurePeriodValues> getValues() {
		return values;
	}

	/**
	 * setValues method
	 * 
	 * @param values
	 *            the values of type Map to set.
	 */
	public void setValues(Set<MeasurePeriodValues> values) {
		this.values = values;
	}

	/**
	 * getYear method.
	 * 
	 * @return the year of type int.
	 */
	public int getYear() {
		return year;
	}

	/**
	 * setYear method
	 * 
	 * @param year
	 *            the year of type int to set.
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * getAdditionalData method.
	 * 
	 * @return the additionalData of type String.
	 */
	public String getAdditionalData() {
		return additionalData;
	}

	/**
	 * setAdditionalData method
	 * 
	 * @param additionalData
	 *            the additionalData of type String to set.
	 */
	public void setAdditionalData(String additionalData) {
		this.additionalData = additionalData;
	}

	/**
	 * getAdditionalData method.
	 * 
	 * @return the additionalData of type String.
	 */
	public Collection<Object> getAdditionalDataCollection() {
		return additionalDataCollection;
	}

	/**
	 * setAdditionalData method
	 * 
	 * @param additionalData
	 *            the additionalData of type String to set.
	 */
	public void setAdditionalData(Collection<Object> additionalDataCollection) {
		this.additionalDataCollection = additionalDataCollection;
	}

	public float getActualYtdTotal() {
		float actualYtd = getMeasure().calculateActualYtd(this);
		LOG.debug("ABOUT TO SET ACTUAL YTD TOTAL TO-----> " + actualYtd);
		setActualYtdTotal(actualYtd);
		DecimalFormat decimalFormat = getDecimalFormat();
		float ytdActual = Float.valueOf(decimalFormat.format(actualYtdTotal));
		LOG.debug("*** YTD ACTUAL TOTAL *** IS *** -->" + ytdActual);
		return ytdActual;
	}

	public float getForcedActualYtdTotal() {
		return this.actualYtdTotal;
	}

	public void setActualYtdTotal(float actualYtdTotal) {
		if (this.getId() == null) {
			this.actualYtdTotal = actualYtdTotal;
		} else {
			actualYtdTotal = getMeasure().calculateActualYtd(this);
			this.actualYtdTotal = actualYtdTotal;
		}
	}

	public float getTargetYtdTotal() {
		assert getMeasure() != null;
		float targetYtd = getMeasure().calculateTargetYtd(this);
		setTargetYtdTotal(targetYtd);
		assert this.targetYtdTotal == targetYtd;
		DecimalFormat decimalFormat = getDecimalFormat();
		float ytdTarget = Float.valueOf(decimalFormat.format(targetYtdTotal));
		LOG.debug("*** YTD TARGET TOTAL *** IS *** -->" + ytdTarget);
		return ytdTarget;
	}

	public float getForcedTargetYtdTotal() {
		return this.targetYtdTotal;
	}

	public void setTargetYtdTotal(float targetYtdTotal) {
		if (this.getId() == null) {
			LOG.debug("Measure period is NEW");
			this.targetYtdTotal = targetYtdTotal;
		} else {
			LOG.debug("getCreateDateTime() WAS NOT NULL");
			targetYtdTotal = getMeasure().calculateTargetYtd(this);
			this.targetYtdTotal = targetYtdTotal;
		}
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the calcEngineRef
	 */
	public String getCalcEngineRef() {
		return calcEngineRef;
	}

	/**
	 * @param calcEngineRef
	 *            the calcEngineRef to set
	 */
	public void setCalcEngineRef(String calcEngineRef) {
		this.calcEngineRef = calcEngineRef;
	}

	/**
	 * @return the controlXmlFile
	 */
	public String getControlXmlFile() {
		return controlXmlFile;
	}

	/**
	 * @param controlXmlFile
	 *            the controlXmlFile to set
	 */
	public void setControlXmlFile(String controlXmlFile) {
		this.controlXmlFile = controlXmlFile;
	}

	/**
	 * @return the datasourceLink
	 */
	public boolean isDatasourceLink() {
		return datasourceLink;
	}

	/**
	 * @param datasourceLink
	 *            the datasourceLink to set
	 */
	public void setDatasourceLink(boolean datasourceLink) {
		this.datasourceLink = datasourceLink;
	}

	/**
	 * @return the decimalPoints
	 */
	public boolean isDecimalPoints() {
		return decimalPoints;
	}

	/**
	 * @param decimalPoints
	 *            the decimalPoints to set
	 */
	public void setDecimalPoints(boolean decimalPoints) {
		this.decimalPoints = decimalPoints;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("measure:").append(measure).append("\n");
		buffer.append("year:").append(year).append("\n");
		buffer.append("prefix:").append(prefix).append("\n");
		buffer.append("=========== Child values ============").append("\n");
		int vCnt = 0;
		if (getValues() != null) {
			Iterator<MeasurePeriodValues> valueIterator = values.iterator();
			while (valueIterator.hasNext()) {
				MeasurePeriodValues element = valueIterator.next();
				buffer.append(vCnt).append(": value : ").append(element)
						.append("\n");
				vCnt++;
			}
		}
		buffer.append("=========== Additional values ============")
				.append("\n");
		vCnt = 0;
		Iterator iterator = additionalDataCollection.iterator();
		while (iterator.hasNext()) {
			Object element = iterator.next();
			buffer.append(vCnt).append(": add value : ").append(element)
					.append("\n");
			vCnt++;
		}
		return buffer.toString();
	}

	/**
	 * setActualMonthlyFigure method.
	 * 
	 * @param month
	 *            month (java calendar).
	 * @param value
	 *            decimal value.
	 */
	public void setActualMonthlyFigure(final int month, final BigDecimal value) {
		boolean isFound = false;
		if (values == null) {
			values = new HashSet<MeasurePeriodValues>();
		}
		Iterator<MeasurePeriodValues> iterator = values.iterator();
		while (iterator.hasNext()) {
			MeasurePeriodValues element = iterator.next();
			if (element.getMonth() == month) {
				isFound = true;
				element.setActualValue(value);
			}
		}
		if (!isFound) {
			MeasurePeriodValues element = getNewMeasurePeriodValue(value, null);
			element.setMonth(month);
			element.setMeasurePeriod(this);
			values.add(element);
		}
	}

	private MeasurePeriodValues getNewMeasurePeriodValue(
			final BigDecimal actual, final BigDecimal target) {
		MeasurePeriodValues element = new MeasurePeriodValues(actual, target);
		return element;
	}

	/**
	 * setTargetMonthlyFigure method.
	 * 
	 * @param month
	 * @param value
	 */
	public void setTargetMonthlyFigure(final int month, final BigDecimal value) {
		boolean isFound = false;
		if (values == null) {
			values = new HashSet<MeasurePeriodValues>();
		}
		Iterator<MeasurePeriodValues> iterator = values.iterator();
		while (iterator.hasNext()) {
			MeasurePeriodValues element = iterator.next();
			if (element.getMonth() == month) {
				isFound = true;
				element.setTargetValue(value);
			}
		}
		if (!isFound) {
			MeasurePeriodValues element = getNewMeasurePeriodValue(null, value);
			element.setMonth(month);
			element.setMeasurePeriod(this);
			values.add(element);
		}
	}

	/**
	 * setMonthlyFigure method.
	 * 
	 * @param type
	 *            Actual or Target.
	 * @param month
	 *            Month.
	 * @param value
	 *            Value to set.
	 */
	public void setMonthlyFigure(final int type, final int month,
			final BigDecimal value) {
		switch (type) {
		case 1: // Actual
			setActualMonthlyFigure(month, value);
		case 2: // /Target
			setTargetMonthlyFigure(month, value);
		}
	}

	/**
	 * getTargetMonthlyFigure method.
	 * 
	 * @param month
	 *            month.
	 * @return Value.
	 */
	public BigDecimal getTargetMonthlyFigure(final int month) {
		BigDecimal returnValue = null;
		if (values == null) {
			returnValue = null;
		} else {
			Iterator<MeasurePeriodValues> iterator = values.iterator();
			while (iterator.hasNext()) {
				MeasurePeriodValues element = iterator.next();
				if (element.getMonth() == month) {
					returnValue = element.getTargetValue();
				}
			}
		}
		return returnValue;
	}

	/**
	 * getActualMonthlyFigure method.
	 * 
	 * @param month
	 *            month.
	 * @return figure.
	 */
	public BigDecimal getActualMonthlyFigure(final int month) {
		BigDecimal returnValue = null;

		if (values == null) {
			returnValue = null;
		} else {
			Iterator<MeasurePeriodValues> iterator = values.iterator();
			while (iterator.hasNext()) {
				MeasurePeriodValues element = iterator.next();
				if (element.getMonth() == month) {
					// markb - changed from get target to get actual
					returnValue = element.getActualValue();
				}
			}
		}

		return returnValue;
	}

	/**
	 * getValue method.
	 * 
	 * @param type
	 *            actual or target.
	 * @param month
	 *            month.
	 * @return Value.
	 */
	public BigDecimal getValue(int type, int month) {
		BigDecimal value = null;
		switch (type) {
		case ACTUAL_VALUE: // Actual
			value = getActualMonthlyFigure(month);
		case TARGET_VALUE: // /Target
			value = getTargetMonthlyFigure(month);
		}
		return value;
	}

	/**
	 * addValue method .
	 * 
	 * @param aMonth
	 *            Month from calendar ie values.get(Calendar.JANUARY)
	 * @param aValue
	 *            Value.
	 */
	public void addValue(final MeasurePeriodValues values) {
		if (this.values == null) {
			this.values = new HashSet<MeasurePeriodValues>();
		}
		this.values.add(values);
	}

	/**
	 * putValue method .
	 * 
	 * @param aMonth
	 *            Month from calendar ie values.get(Calendar.JANUARY)
	 * @param aValue
	 *            Value.
	 */
	public void putValue(final MeasurePeriodValues values) {
		boolean isFound = false;
		if (this.values == null) {
			this.values = new HashSet<MeasurePeriodValues>();
		}
		Iterator iterator = this.values.iterator();
		while (iterator.hasNext()) {
			MeasurePeriodValues element = (MeasurePeriodValues) iterator.next();
			if (element.getMonth() == values.getMonth()) {
				if (values.getActualValue() != null) {
					element.setActualValue(values.getActualValue());
				}
				if (values.getTargetValue() != null) {
					element.setTargetValue(values.getTargetValue());
				}
				isFound = true;
			}
		}
		if (!isFound) {
			addValue(values);
		}
	}

	/**
	 * putValue method .
	 * 
	 * @param aMonth
	 *            Month from calendar ie values.get(Calendar.JANUARY)
	 * @param aValue
	 *            Value.
	 */
	public MeasurePeriodValues getValue(final int month) {
		MeasurePeriodValues returnValue = null;
		if (values == null) {
			values = new HashSet<MeasurePeriodValues>();
		}
		Iterator iterator = values.iterator();
		while (iterator.hasNext()) {
			MeasurePeriodValues element = (MeasurePeriodValues) iterator.next();
			if (element.getMonth() == month) {
				returnValue = element;
			}
		}
		return returnValue;
	}

	public float barGraphFraction() {
		// Warning Cannot divide by zero!!
		float fraction = 0;
		if (getTargetYtdTotal() == 0 && getActualYtdTotal() == 0) {
			fraction = 1;
		} else if (getTargetYtdTotal() == 0) {
			fraction = 0;
		} else {
			fraction = getActualYtdTotal() / getTargetYtdTotal();
		}
		return fraction;
	}

	public Map<Integer, Float> getActualDataMap() {
		return getActualDataMap(getMeasure().getFrequency());
	}

	public Map<Integer, Float> getActualDataMap(String frequency) {

		Map<Integer, Float> actualMonthlyMap = new TreeMap<Integer, Float>();
		if (frequency == null || getValues() == null) {
			return actualMonthlyMap;
		} else {
			for (MeasurePeriodValues mpv : getValues()) {
				if (mpv.getActualValue() != null) {
					int month = mpv.getMonth();
					if (frequency.equalsIgnoreCase(Period.MONTHLY)) {
						actualMonthlyMap.put(Integer.valueOf(month), mpv
								.getActualValue().floatValue());
					} else if (frequency.equalsIgnoreCase(Period.QUARTERLY)) {
						if (month == Calendar.MARCH || month == Calendar.JUNE
								|| month == Calendar.SEPTEMBER
								|| month == Calendar.DECEMBER) {
							actualMonthlyMap.put(Integer.valueOf(month), mpv
									.getActualValue().floatValue());
						}
					} else if (frequency.equalsIgnoreCase(Period.HALF_YEARLY)) {
						if (month == Calendar.JUNE
								|| month == Calendar.DECEMBER) {
							actualMonthlyMap.put(Integer.valueOf(month), mpv
									.getActualValue().floatValue());
						}
					} else if (frequency.equalsIgnoreCase(Period.HALF_YEARLY)) {
						if (month == Calendar.DECEMBER) {
							actualMonthlyMap.put(Integer.valueOf(month), mpv
									.getActualValue().floatValue());
						}
					}
				}
			}

			return actualMonthlyMap;
		}
	}

	public Map<Integer, Float> getTargetDataMap() {

		String frequency = getMeasure().getFrequency();
		Map<Integer, Float> targetMonthlyMap = new TreeMap<Integer, Float>();
		if (frequency == null || getValues() == null) {
			return targetMonthlyMap;
		} else {
			for (MeasurePeriodValues mpv : getValues()) {
				if (mpv.getTargetValue() != null) {
					int month = mpv.getMonth();
					if (frequency.equalsIgnoreCase(Period.MONTHLY)) {
						targetMonthlyMap.put(Integer.valueOf(month), mpv
								.getTargetValue().floatValue());
					} else if (frequency.equalsIgnoreCase(Period.QUARTERLY)) {
						if (month == Calendar.MARCH || month == Calendar.JUNE
								|| month == Calendar.SEPTEMBER
								|| month == Calendar.DECEMBER) {
							targetMonthlyMap.put(Integer.valueOf(month), mpv
									.getTargetValue().floatValue());
						}
					} else if (frequency.equalsIgnoreCase(Period.HALF_YEARLY)) {
						if (month == Calendar.JUNE
								|| month == Calendar.DECEMBER) {
							targetMonthlyMap.put(Integer.valueOf(month), mpv
									.getTargetValue().floatValue());
						}
					} else if (frequency.equalsIgnoreCase(Period.HALF_YEARLY)) {
						if (month == Calendar.DECEMBER) {
							targetMonthlyMap.put(Integer.valueOf(month), mpv
									.getTargetValue().floatValue());
						}
					}
				}
			}

			return targetMonthlyMap;
		}
	}

	public ArrayList<String> valuesToString(int valueType) {
		ArrayList<String> values = new ArrayList<String>();
		Map<Integer, Float> map = null;
		if (MeasurePeriod.ACTUAL_VALUE == valueType) {
			map = getActualDataMap();
		} else if (MeasurePeriod.TARGET_VALUE == valueType) {
			map = getTargetDataMap();
		}

		DecimalFormat decimalFormat = getDecimalFormat();
		for (int i = Calendar.JANUARY; i <= Calendar.DECEMBER; i++) {
			if (map.get(i) == null) {
				values.add("");
			} else {
				values.add(decimalFormat.format(map.get(i).floatValue()));
			}
		}

		return values;
	}

	public void stringsToValues(ArrayList<String> alist, int valueType) {

		if (MeasurePeriod.ACTUAL_VALUE == valueType) {
			for (int i = Calendar.JANUARY; i <= Calendar.DECEMBER; i++) {
				try {
					setActualMonthlyFigure(i, new BigDecimal(alist.get(i)));
				} catch (Exception e) {
					LOG.warn("Not a valid ACTUAL value!! for month -->" + i);
				}
			}
		} else if (MeasurePeriod.TARGET_VALUE == valueType) {
			for (int i = Calendar.JANUARY; i <= Calendar.DECEMBER; i++) {
				try {
					setTargetMonthlyFigure(i, new BigDecimal(alist.get(i)));
				} catch (Exception e) {
					// setTargetMonthlyFigure(i, null);
					LOG.warn("Not a valid TARGET value!! for month -->" + i);
				}
			}
		}
	}

	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// This should never happen
			throw new InternalError(e.getMessage());
		}
	}

	private DecimalFormat getDecimalFormat() {
		DecimalFormat df = null;
		if (isDecimalPoints()) {
			df = new DecimalFormat("#0.00");
		} else {
			df = new DecimalFormat("#0");
		}
		return df;
	}

	public String getYtdActualTotalAsString() {
		return getYtdTotalAsString(getActualYtdTotal());
	}

	public String getYtdTargetTotalAsString() {
		return getYtdTotalAsString(getTargetYtdTotal());
	}

	private String getYtdTotalAsString(Float ytdValue) {
		String returnValue = null;
		if (isDecimalPoints()) {
			returnValue = ytdValue.toString();
		} else {
			returnValue = Integer.toString(Math.round(ytdValue));
		}
		return returnValue;
	}

	/**
	 * @param ytdActualTotalAsString
	 *            the ytdActualTotalAsString to set
	 */
	public void setYtdActualTotalAsString(String ytdActualTotalAsString) {
		this.ytdActualTotalAsString = ytdActualTotalAsString;
	}

	/**
	 * @param ytdTargetTotalAsString
	 *            the ytdTargetTotalAsString to set
	 */
	public void setYtdTargetTotalAsString(String ytdTargetTotalAsString) {
		this.ytdTargetTotalAsString = ytdTargetTotalAsString;
	}

	/**
	 * This month returns a String representation of the associated value for a
	 * given QPR month. i.e. If it is the second quarter then the quarterMonth
	 * parm will be Calendar.June
	 * 
	 * @param quarterMonth
	 * @return
	 */
	public String getQPRActualValue(int quarterMonth) {
		float floatValue = 0.0f;
		if (Period.MONTHLY.equalsIgnoreCase(getMeasure().getFrequency())) {
			floatValue = getQPRValueForMonthlyFrequency(getActualDataMap(),
					quarterMonth);
		} else {
			if (getValue(quarterMonth) != null
					&& getValue(quarterMonth).getActualValue() != null) {
				floatValue = getValue(quarterMonth).getActualValue()
						.floatValue();
			}
		}
		DecimalFormat decimalFormat = getDecimalFormat();
		return decimalFormat.format(floatValue) + "";
	}

	/**
	 * This month returns a String representation of the associated value for a
	 * given QPR month. i.e. If it is the second quarter then the quarterMonth
	 * parm will be Calendar.June
	 * 
	 * @param quarterMonth
	 * @return
	 */
	public String getQPRTargetValue(int quarterMonth) {
		String returnValue = "";
		Float floatValue = null;
		LOG.debug("ENTERED getQPRTargetValue with month= " + quarterMonth
				+ "  "
				+ Period.MONTHLY.equalsIgnoreCase(getMeasure().getFrequency()));
		if (Period.MONTHLY.equalsIgnoreCase(getMeasure().getFrequency())) {
			floatValue = getQPRValueForMonthlyFrequency(getTargetDataMap(),
					quarterMonth);
		} else {
			if (getValue(quarterMonth) != null
					&& getValue(quarterMonth).getActualValue() != null) {
				floatValue = getValue(quarterMonth).getTargetValue()
						.floatValue();
			}
		}
		if (floatValue != null) {
			DecimalFormat decimalFormat = getDecimalFormat();
			System.out.println("FORMATED TARGET QPR VALUE IS ----->"
					+ decimalFormat.format(floatValue));
			returnValue = decimalFormat.format(floatValue) + "";
		}
		return returnValue;
	}

	private Float getQPRValueForMonthlyFrequency(Map<Integer, Float> values,
			int quarter) {
		System.out.println("getQPRValueForMonthlyFrequency quarter is ----->"
				+ quarter);
		Float returnValue = null;
		ArrayList<Float> arrayList = new ArrayList<Float>();

		for (int i = 0; i < 12; i++) {
			switch (quarter) {
			case Calendar.MARCH:
				if ((i == 0 || i == 1 || i == 2) && values.get(i) != null) {
					arrayList.add(values.get(i));
				}
				break;
			case Calendar.JUNE:
				if ((i == 3 || i == 4 || i == 5) && values.get(i) != null) {
					arrayList.add(values.get(i));
				}
				break;
			case Calendar.SEPTEMBER:
				if ((i == 6 || i == 7 || i == 8) && values.get(i) != null) {
					arrayList.add(values.get(i));
				}
				break;
			case Calendar.DECEMBER:
				if ((i == Calendar.OCTOBER || i == Calendar.NOVEMBER || i == Calendar.DECEMBER)
						&& values.get(i) != null) {
					arrayList.add(values.get(i));
				}
				break;
			}
		}
		if (arrayList.size() > 0) {
			returnValue = getMeasure().getYtdValueForYtdFormula(arrayList);
		}

		return returnValue;
	}
	
	public boolean hasChildValues() {
		if (getValues() != null && getValues().size() > 0) {
			for (MeasurePeriodValues mpv : getValues()) {
				if (mpv.getActualValue() != null || mpv.getTargetValue() != null) {
					return true;
				}
			}
		}
		return false;
	}
}