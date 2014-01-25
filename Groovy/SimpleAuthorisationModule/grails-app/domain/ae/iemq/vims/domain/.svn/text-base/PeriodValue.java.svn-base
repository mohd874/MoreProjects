package ae.iemq.vims.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings({ "serial", "unchecked" })
@Entity
@Table(name = "period_value")
@NamedQueries( { @NamedQuery(name = "PeriodValue.Year", query = "select periodValue from PeriodValue periodValue "
		+ "where periodValue.periodInfo = :periodInfo "
		+ "and periodValue.valueType = :type "
		+ "order by month") })
public class PeriodValue extends BaseEntity {

	static Logger LOG = Logger.getLogger(PeriodValue.class);
	
	public static int MANAGEABLILITY = 1;
	
	public static int PROBABILITY = 2;
	
	public static int IMPACT = 3; 
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "period", referencedColumnName = "id")
	@ManyToOne
	private PeriodInfo periodInfo;

	@Column(name = "value")
	private float value;

	@Column(name = "month")
	private int month;
	
	@Column(name = "value_type")
	private int valueType;
	
	@Column(name = "is_valid")
	private boolean isValid;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public PeriodInfo getPeriodInfo() {
		return periodInfo;
	}

	public void setPeriodInfo(PeriodInfo periodInfo) {
		this.periodInfo = periodInfo;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public int getValueType() {
		return valueType;
	}

	public void setValueType(int valueType) {
		this.valueType = valueType;
	}

	public boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public PeriodValue(PeriodInfo periodInfo, int month, int valueType) {
		super();
		this.periodInfo = periodInfo;
		this.month = month;
		this.valueType = valueType;
	}
	
	public PeriodValue(){
		super();
	}



}
