/* Copyright TRANSCODE 2007.*/
package ae.iemq.vims.domain.balancedScorecard;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import ae.iemq.vims.domain.BaseEntity;
import ae.iemq.vims.util.DateUtil;

/**
 * Holder for actual vs target values.
 * 
 * @author donovan
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings( { "serial", "unchecked" })
@Entity
@Table(name = "measure_period_values")
@NamedQueries( {})
public class MeasurePeriodValues extends BaseEntity {

	/**
	 * serialVersionUID long.
	 */
	//private static final long serialVersionUID = -20071222L;

	/** measurePeriod MeasurePeriod. */
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "measure_period", referencedColumnName = "id")
	@ManyToOne
	private MeasurePeriod measurePeriod;

	/**
	 * month int.
	 */
	@Column(name = "month")
	private int month;

	/**
	 * actualValue BigDecimal.
	 */
	@Column(name = "actual_value")
	private BigDecimal actualValue;

	/**
	 * targetValue BigDecimal.
	 */
	@Column(name = "target_value")
	private BigDecimal targetValue;

	/**
	 * Constructor.
	 */
	public MeasurePeriodValues() {
	}

	/**
	 * Constructor.
	 * 
	 * @param actual
	 *            value.
	 * @param target
	 *            value.
	 */
	public MeasurePeriodValues(BigDecimal actual, BigDecimal target) {
		actualValue = actual;
		targetValue = target;
	}

	/**
	 * @return the measurePeriod
	 */
	public MeasurePeriod getMeasurePeriod() {
		return measurePeriod;
	}

	/**
	 * @param measurePeriod
	 *            the measurePeriod to set
	 */
	public void setMeasurePeriod(MeasurePeriod measurePeriod) {
		this.measurePeriod = measurePeriod;
	}

	/**
	 * getActualValue method.
	 * 
	 * @return the actualValue of type BigDecimal.
	 */
	public BigDecimal getActualValue() {
		return actualValue;
	}

	/**
	 * setActualValue method
	 * 
	 * @param actualValue
	 *            the actualValue of type BigDecimal to set.
	 */
	public void setActualValue(BigDecimal actualValue) {
		this.actualValue = actualValue;
		if (getTargetValue() == null) {
			setTargetValue(new BigDecimal(0));
		}
	}

	/**
	 * getTargetValue method.
	 * 
	 * @return the targetValue of type BigDecimal.
	 */
	public BigDecimal getTargetValue() {
		return targetValue;
	}

	/**
	 * setTargetValue method
	 * 
	 * @param targetValue
	 *            the targetValue of type BigDecimal to set.
	 */
	public void setTargetValue(BigDecimal targetValue) {
		this.targetValue = targetValue;
	}

	/**
	 * getMonth method.
	 * 
	 * @return the month of type String.
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * setMonth method
	 * 
	 * @param month
	 *            the month of type String to set.
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("MeasurePeriodValues toString()").append("\n");
		if (measurePeriod == null) {
			buffer.append("MeasurePeriod is NULL!!!").append("\n");
		} else {
			buffer.append("MeasurePeriod id:").append(measurePeriod.getId()).append("\n");
		}
		
		buffer.append("month:").append(month).append("\n");
		buffer.append("month:").append(DateUtil.getMonthName(month)).append(
				"\n");
		buffer.append("actualValue:").append(actualValue).append("\n");
		buffer.append("targetValue:").append(targetValue).append("\n");
		return buffer.toString();
	}
}
