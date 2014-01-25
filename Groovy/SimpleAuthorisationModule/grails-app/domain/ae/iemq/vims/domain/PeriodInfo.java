package ae.iemq.vims.domain;

import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "period_info")
@NamedQueries( { @NamedQuery(name = "PeriodInfo.Risk", query = "select periodInfo from PeriodInfo periodInfo "
		+ "where periodInfo.risk = :risk "
		+ "order by year") })
public class PeriodInfo extends BaseEntity{

	static Logger LOG = Logger.getLogger(PeriodInfo.class);
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "risk", referencedColumnName = "id")
	@ManyToOne
	private Risk risk;

	@Column(name = "period_info_year")
	private int year;

	@Column(name = "comment")
	private String comment;

	@OneToMany(mappedBy = "periodInfo", fetch = FetchType.EAGER, cascade = {
			CascadeType.PERSIST, CascadeType.ALL })
	private Set<PeriodValue> periodsValue;
	
	public PeriodInfo() {
		setPeriodsValue(new HashSet<PeriodValue>());
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Set<PeriodValue> getPeriodsValue() {
		return periodsValue;
	}

	public void setPeriodsValue(Set<PeriodValue> periodsValue) {
		this.periodsValue = periodsValue;
	}

	public void addPeriodValue(PeriodValue period) {
		if (periodsValue== null)
			periodsValue = new LinkedHashSet<PeriodValue>();

		periodsValue.add(period);
	}
	
	public void addPeriodsValue(Set<PeriodValue> pv){
		if (periodsValue== null)
			periodsValue = new LinkedHashSet<PeriodValue>();
		periodsValue.addAll(pv);
	}
	
	public Risk getRisk() {
		return risk;
	}

	public void setRisk(Risk risk) {
		this.risk = risk;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	
	
	
 /** Returns the value of the specified valueType for the given month.
  * must be used in conjunction with isValueValidForMonth for validation
  * @param month
  * @param valueType
  * @return
  */
	public double getValueForMonth(int month, int valueType){
		for(PeriodValue p:getPeriodsValue()){
			if (p.getMonth()==month && p.getValueType()==valueType) 
				return p.getValue();
		}
		return 0;
	}
	
	public PeriodValue getPeriodValueForMonth(int month, int valueType){
		for(PeriodValue p:getPeriodsValue()){
			if (p.getMonth()==month && p.getValueType()==valueType) 
				return p;
		}
		return null;
	}
	
	public boolean isValueValidForMonth(int month, int valueType){
		for(PeriodValue p:getPeriodsValue()){
			if (p.getMonth()==month && p.getValueType()==valueType ) 
				return p.getIsValid();
		}
		return false;
	}
	
	
	 /** Returns the value of the specified valueType for the given month.
	  * must be used in conjunction with isValueValidForMonth for validation
	  * @param month
	  * @param valueType
	 * @return 
	  * @return
	  */
		public Set<PeriodValue> getAllValuesForType(int valueType){
			Set<PeriodValue> all=new LinkedHashSet<PeriodValue>();
			for (int i=Calendar.JANUARY;i<=Calendar.DECEMBER;i++){
				for(PeriodValue p:getPeriodsValue()){
					if (p.getMonth()==i && p.getValueType()==valueType){
						all.add(p);
						LOG.debug("MONTH --->"+p.getMonth()+" TYPE---->"+p.getValueType()+" VALUE---->"+p.getValue() );
					}
				}
			}
			return all;
		}
		
		
		
		public int getLatestMonth(){
			int last=12;
			for (int i=Calendar.JANUARY;i<=Calendar.DECEMBER;i++){
				PeriodValue p1=getPeriodValueForMonth(i, 1);
				PeriodValue p2=getPeriodValueForMonth(i, 2);
				PeriodValue p3=getPeriodValueForMonth(i, 3);
				if (p1.getIsValid()&&p2.getIsValid()&& p3.getIsValid()){
					if (last==12)last=p1.getMonth();
					else if (p1.getMonth()>last)last=p1.getMonth();
				}
			}
			return last;
		}
		
		public boolean isPeriodInfoValidForMonth(int month){
				PeriodValue p1=getPeriodValueForMonth(month, 1);
				PeriodValue p2=getPeriodValueForMonth(month, 2);
				PeriodValue p3=getPeriodValueForMonth(month, 3);
				if (p1.getIsValid()&&p2.getIsValid()&& p3.getIsValid()){
					return true;
				}
				else
					return false;
		}
		
		public int validMonths(){
			int count=0;
			for (int i=Calendar.JANUARY;i<=Calendar.DECEMBER;i++){	
				PeriodValue p1=getPeriodValueForMonth(i, 1);
				PeriodValue p2=getPeriodValueForMonth(i, 2);
				PeriodValue p3=getPeriodValueForMonth(i, 3);
				if (p1.getIsValid()&&p2.getIsValid()&& p3.getIsValid()){
					count++;
				}
			}
			return count;
	}
		
		public String getStringLatestValueType(int valueType){
			int last=12;
			double value=0;
			for (int i=Calendar.JANUARY;i<=Calendar.DECEMBER;i++){	
				PeriodValue pv=getPeriodValueForMonth(i, valueType);
				if(pv.getIsValid()){
					value=pv.getValue();
					last=pv.getMonth();
				}
			}
			if (last!=12)
				return Double.toString(value);
			return"";
		}
		
		public double getDoubleLatestValueType(int valueType){
			int last=12;
			double value=0;
			for (int i=Calendar.JANUARY;i<=Calendar.DECEMBER;i++){	
				PeriodValue pv=getPeriodValueForMonth(i, valueType);
				if(pv.getIsValid()){
					value=pv.getValue();
					last=pv.getMonth();
				}
			}

				return value;
		}
		
	
}
