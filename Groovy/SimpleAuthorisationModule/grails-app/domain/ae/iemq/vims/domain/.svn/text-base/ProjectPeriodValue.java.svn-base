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
@Table(name = "project_period_value")
@NamedQueries( { @NamedQuery(name = "ProjectPeriodValue.Year", query = "select projectPeriodValue from ProjectPeriodValue projectPeriodValue "
		+ "where projectPeriodValue.projectPeriodInfo = :periodInfo "
		+ "and projectPeriodValue.dec = :dec "
		+ "order by valueType,subperiod") })
public class ProjectPeriodValue extends BaseEntity {
	
	static Logger LOG = Logger.getLogger(ProjectPeriodValue.class);

	//Value_Type
	public static int BASELINE = 1;
	public static int ACTUAL = 2;
	//dec
	public static int DURATION = 1;
	public static int EFFORT = 2;
	public static int COST = 3;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "project_period", referencedColumnName = "id")
	@ManyToOne
	private ProjectPeriodInfo projectPeriodInfo;

	@Column(name = "value")
	private float value;

	@Column(name = "subperiod")
	private int subperiod;
	
	@Column(name = "value_type")
	private int valueType;
	
	@Column(name = "dec_type")
	private int dec;
	
	@Column(name = "is_valid")
	private boolean isValid;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getSubperiod() {
		return subperiod;
	}

	public void setSubperiod(int subperiod) {
		this.subperiod = subperiod;
	}

	public ProjectPeriodInfo getProjectPeriodInfo() {
		return projectPeriodInfo;
	}

	public void setProjectPeriodInfo(ProjectPeriodInfo periodInfo) {
		this.projectPeriodInfo = periodInfo;
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

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ProjectPeriodValue(ProjectPeriodInfo periodInfo, int subperiod, int dec,int valueType,boolean isValid) {
		super();
		this.projectPeriodInfo = periodInfo;
		this.subperiod = subperiod;
		this.valueType = valueType;
		this.isValid=isValid;
		this.dec=dec;
	}
	
	public ProjectPeriodValue(){
		super();
	}

	public int getDec() {
		return dec;
	}

	public void setDec(int dec) {
		this.dec = dec;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public boolean isValid() {
		return isValid;
	}



}
