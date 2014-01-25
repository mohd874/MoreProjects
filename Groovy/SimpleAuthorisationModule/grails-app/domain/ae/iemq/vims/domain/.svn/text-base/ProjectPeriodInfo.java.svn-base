package ae.iemq.vims.domain;

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
import org.hibernate.annotations.ForeignKey;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "project_period_info")
@NamedQueries( { @NamedQuery(name = "ProjectPeriodInfo.Project", query = "select projectPeriodInfo from ProjectPeriodInfo projectPeriodInfo "
		+ "where projectPeriodInfo.project = :project "
		+ "order by projectPeriodInfo.year") })
public class ProjectPeriodInfo extends BaseEntity{

	static Logger LOG = Logger.getLogger(ProjectPeriodInfo.class);
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)//READ_WRITE
	@JoinColumn(name = "project", referencedColumnName = "id")
	@ForeignKey(name="id")
	@ManyToOne
	private Project project;

	@Column(name = "project_year")
	private int year;

	@Column(name = "comment")
	private String comment;

	@OneToMany(mappedBy = "projectPeriodInfo", fetch = FetchType.EAGER, cascade = {
			CascadeType.PERSIST, CascadeType.ALL })
	@org.hibernate.annotations.OrderBy(clause="subperiod")
	private Set<ProjectPeriodValue> projectPeriodValues;
	
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


	public void addProjectPeriodValue(ProjectPeriodValue period) {
		if (projectPeriodValues== null)
			projectPeriodValues = new LinkedHashSet<ProjectPeriodValue>();

		projectPeriodValues.add(period);
	}
	
	public void addProjectPeriodValues(Set<ProjectPeriodValue> pv){
		if (projectPeriodValues== null)
			projectPeriodValues = new LinkedHashSet<ProjectPeriodValue>();
		projectPeriodValues.addAll(pv);
	}
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	
	
	
 /** Returns the value of the specified valueType for the given subperiod.
  * must be used in conjunction with isValueValidForMonth for validation
  * @param subperiod
  * @param valueType
  * @return
  */
	public double getValueForSubperiod(int subperiod, int dec,int valueType){
		for(ProjectPeriodValue p:getProjectPeriodValues()){
			if (p.getSubperiod()==subperiod && p.getValueType()==valueType && p.getDec()==dec) 
				return p.getValue();
		}
		return 0;
	}
	
	public ProjectPeriodValue getProjectPeriodValueForSubperiod(int subperiod, int dec,int valueType){
		for(ProjectPeriodValue p:getProjectPeriodValues()){
			if (p.getSubperiod()==subperiod && p.getValueType()==valueType && p.getDec()==dec) 
				return p;
		}
		return null;
	}
	
	public void setProjectPeriodValueForSubperiod(float value,boolean valid,int subperiod, int dec,int valueType){
		for(ProjectPeriodValue p:getProjectPeriodValues()){
			if (p.getSubperiod()==subperiod && p.getValueType()==valueType && p.getDec()==dec) {
				p.setValue(value);
				p.setValid(valid);
			}
		}
	}
	
	public boolean isValueValidForSubperiod(int subperiod, int dec){
		int count=0;
		for(ProjectPeriodValue p:getProjectPeriodValues()){
			if (p.getSubperiod()==subperiod && p.getDec()==dec ) 
				count++;
		}
		if (count>=2)return true;
		return false;
	}
	
	
	 /** Returns the value of the specified valueType for the given subperiod.
	  * must be used in conjunction with isValueValidForSubperiod for validation
	  * @param subperiod
	  * @param valueType
	 * @return 
	  * @return
	  */
		public Set<ProjectPeriodValue> getAllValuesForType(int valueType){
			Set<ProjectPeriodValue> all=new LinkedHashSet<ProjectPeriodValue>();
			String periodLenght=this.getProject().getReportingFrequency();
			int last=0;
			if (periodLenght.equalsIgnoreCase("Mth")){
				last=12;
			}else if (periodLenght.equalsIgnoreCase("QUARTERLY")){
				last=4;
			}
			for (int i=0;i<last;i++){
				for(ProjectPeriodValue p:getProjectPeriodValues()){
					if (p.getSubperiod()==i && p.getValueType()==valueType){
						all.add(p);
						LOG.debug("MONTH --->"+p.getSubperiod()+" TYPE---->"+p.getValueType()+" VALUE---->"+p.getValue() );
					}
				}
			}
			return all;
		}
	
		public Set<ProjectPeriodValue> getAllValuesForType(int dec,int valueType){
			Set<ProjectPeriodValue> all=new LinkedHashSet<ProjectPeriodValue>();
			String periodLenght=this.getProject().getReportingFrequency();
			int last=0;
			if (periodLenght.equalsIgnoreCase("Mth")){
				last=12;
			}else if (periodLenght.equalsIgnoreCase("QUARTERLY")){
				last=4;
			}
			for (int i=0;i<=last;i++){
				for(ProjectPeriodValue p:getProjectPeriodValues()){
					if (p.getSubperiod()==i && p.getValueType()==valueType && p.getDec()==dec){
						all.add(p);
						LOG.debug("SUBPERIOD --->"+p.getSubperiod()+" TYPE---->"+p.getValueType()+" DEC---->"+p.getDec()+" VALUE---->"+p.getValue() );
					}
				}
			}
			return all;
		}
		
		
		public int getLatestSubperiod(){
			String periodLenght=this.getProject().getReportingFrequency();
			int last=12;
			if (periodLenght.equalsIgnoreCase(Period.MONTHLY)){
				last=12;
			}else if (periodLenght.equalsIgnoreCase(Period.QUARTERLY)){
				last=4;
			}
			int aux=last;
		
			for (int i=0;i<aux;i++){
				ProjectPeriodValue p1=getProjectPeriodValueForSubperiod(i, 1,1);
				ProjectPeriodValue p2=getProjectPeriodValueForSubperiod(i, 1,2);
				ProjectPeriodValue p3=getProjectPeriodValueForSubperiod(i, 2,1);
				ProjectPeriodValue p4=getProjectPeriodValueForSubperiod(i, 2,2);
				ProjectPeriodValue p5=getProjectPeriodValueForSubperiod(i, 3,1);
				ProjectPeriodValue p6=getProjectPeriodValueForSubperiod(i, 3,2);
				if (p1.isValid()&&p2.isValid()&& p3.isValid()&& p4.isValid()&& p5.isValid()&& p6.isValid()){
					if (last==aux)last=p1.getSubperiod();
					else if (p1.getSubperiod()>last)last=p1.getSubperiod();
				}
			}
			if (aux==last) return 12;
			return last;
		}
//		
//		public boolean isPeriodInfoValidForSubperiod(int subperiod,int dec){
//				ProjectPeriodValue p1=getProjectPeriodValueForSubperiod(subperiod,dec, 1);
//				ProjectPeriodValue p2=getProjectPeriodValueForSubperiod(subperiod,dec, 2);
//				if (p1.isValid()&&p2.isValid()){
//					return true;
//				}
//				else
//					return false;
//		}
		
//		public int validSubperiods(){
//			int count=0;
//			for (int i=Calendar.JANUARY;i<=Calendar.DECEMBER;i++){	
//				ProjectPeriodValue p1=getProjectPeriodValueForSubperiod(i, 1);
//				ProjectPeriodValue p2=getProjectPeriodValueForSubperiod(i, 2);
//				ProjectPeriodValue p3=getProjectPeriodValueForSubperiod(i, 3);
//				if (p1.isValid()&&p2.isValid()&& p3.isValid()){
//					count++;
//				}
//			}
//			return count;
//	}
		
//		public String getStringLatestValueType(int valueType){
//			int last=12;
//			double value=0;
//			for (int i=Calendar.JANUARY;i<=Calendar.DECEMBER;i++){	
//				ProjectPeriodValue pv=getProjectPeriodValueForSubperiod(i, valueType);
//				if(pv.isValid()){
//					value=pv.getValue();
//					last=pv.getSubperiod();
//				}
//			}
//			if (last!=12)
//				return Double.toString(value);
//			return"";
//		}
		
		public double getDoubleLatestValueType(int dec,int valueType){
			String periodLenght=this.getProject().getReportingFrequency();
			int last=0;
			if (periodLenght.equalsIgnoreCase(Period.MONTHLY)){
				last=12;
			}else if (periodLenght.equalsIgnoreCase(Period.QUARTERLY)){
				last=4;
			}			
			double value=-1;
			for (int i=0;i<last;i++){	
				ProjectPeriodValue pv1=getProjectPeriodValueForSubperiod(i, dec,1);
				ProjectPeriodValue pv2=getProjectPeriodValueForSubperiod(i, dec,2);
				if(pv1.isValid()&&pv2.isValid()){
					value=getProjectPeriodValueForSubperiod(i, dec,valueType).getValue();
				}
			}

				return value;
		}

		public void setProjectPeriodValues(Set<ProjectPeriodValue> projectPeriodValues) {
			this.projectPeriodValues = projectPeriodValues;
		}

		public Set<ProjectPeriodValue> getProjectPeriodValues() {
			return projectPeriodValues;
		}

		public float getMaxMinDecValue(int dec,boolean max) {
			String periodLenght=this.getProject().getReportingFrequency();
			int last=0;
			if (periodLenght.equalsIgnoreCase(Period.MONTHLY)){
				last=12;
			}else if (periodLenght.equalsIgnoreCase(Period.QUARTERLY)){
				last=4;
			}
			float maxmin=0;
			if(max) maxmin=-1;
			else maxmin=Float.MAX_VALUE;
			for (int i=0;i<last;i++){	
				ProjectPeriodValue pv1=getProjectPeriodValueForSubperiod(i, dec,1);
				ProjectPeriodValue pv2=getProjectPeriodValueForSubperiod(i, dec,2);
				if(pv1.isValid()&&pv2.isValid()){
					if (max){
						if (pv1.getValue()>=pv2.getValue() && pv1.getValue()>maxmin) maxmin=pv1.getValue();
						else if (pv2.getValue()>pv1.getValue() && pv2.getValue()>maxmin) maxmin=pv2.getValue();
					}
					if (!max){
						if (pv1.getValue()<=pv2.getValue() && pv1.getValue()<maxmin) maxmin=pv1.getValue();
						else if (pv2.getValue()<pv1.getValue() && pv2.getValue()<maxmin) maxmin=pv2.getValue();
					}
			}
		}
			if (maxmin<Float.MAX_VALUE && maxmin >=0) return maxmin;
			return 0;
		}
		
	
}

