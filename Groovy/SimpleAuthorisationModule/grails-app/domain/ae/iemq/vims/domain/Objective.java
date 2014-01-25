package ae.iemq.vims.domain;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.Where;

import ae.iemq.vims.domain.Aspect.Status;
import ae.iemq.vims.domain.balancedScorecard.Measure;
import ae.iemq.vims.domain.developprocess.Process;
import ae.iemq.vims.resource.ViMSColorUtil;
import ae.iemq.vims.resource.fusionCharts.MeasurePeriodCharts;
import ae.iemq.vims.resource.fusionCharts.ProjectCharts;
import ae.iemq.vims.resource.fusionCharts.RiskCharts;
import ae.iemq.vims.util.DateUtil;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@FilterDef(name = "getRiskWithoutArchiveDateSet")
@Filters( { @Filter(name = "withoutArchive", condition = "archiveDateTime is null")

})
@Table(name = "objective")
@NamedQueries( {
		@NamedQuery(name = "Objective.allObjectives", query = "from Objective obj where obj.recordStatus = '" +BaseEntity.activeRecordStatus+ "'"+
				" order by perspective, obj.id"),
		@NamedQuery(name = "Objective.objective", query = "from Objective where id is :objectiveId"),
		@NamedQuery(name = "Objective.allObjectivesWithActivities", query = "from Objective obj left join fetch obj.activities act " +
				"where act.recordStatus = 'Active' or obj.recordStatus = '" +BaseEntity.activeRecordStatus+ "' " +
				"order by perspective, obj.code"),
		@NamedQuery(name = "Objective.OrgUnitPerspective", query = "from Objective obj where obj.orgUnit = :orgUnit and obj.perspective = :perspective")})
public class Objective extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@Embedded
	private Period period;

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "owner", referencedColumnName = "id")
	@ManyToOne
	private Employee owner;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "org_unit", referencedColumnName = "id")
	@ManyToOne
	private OrgUnit orgUnit;

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "perspective", referencedColumnName = "id")
	@ManyToOne
	private Perspective perspective;

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy = "objective", fetch = FetchType.LAZY)
	@OrderBy("period.startDate, name")
	@Where(clause="record_status='Active'") 
	private Set<Activity> activities;

	@Cache(usage = CacheConcurrencyStrategy.NONE)/*NONE is not the right choice...we need to look more and understand hibernate caching because the NONE option will affect the application efficiency negatively */
	@OneToMany(mappedBy = "objective", fetch = FetchType.LAZY)
	@OrderBy("measureCode")
	@Where(clause="record_status='Active'") 
	private Set<Measure> measures;

	@Cache(usage = CacheConcurrencyStrategy.NONE)
	@OneToMany(mappedBy = "objective", fetch = FetchType.LAZY)
	@Where(clause="record_status='Active'") 
	private Set<Risk> risks;

	@Cache(usage = CacheConcurrencyStrategy.NONE)
	@OneToMany (mappedBy = "objective", fetch = FetchType.LAZY)
	@org.hibernate.annotations.OrderBy(clause="start_date desc")
	@Where(clause="record_status='Active'") 
	private Set<Project> projects;

	@Cache(usage = CacheConcurrencyStrategy.NONE)
	@OneToMany(mappedBy = "objective", fetch = FetchType.LAZY)
	@OrderBy("name")
	@Where(clause="record_status='Active'") 
	private Set<Process> processes;
	
	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		if (code == null) {
			generateCode();
		}
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		System.out.println("set code to " + code);
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the perspective
	 */
	public Perspective getPerspective() {
		return perspective;
	}

	/**
	 * @param perspective
	 *            the perspective to set
	 */
	public void setPerspective(Perspective perspective) {
		this.perspective = perspective;
	}

	/**
	 * @return the activities
	 */
	public Set<Activity> getActivities() {
		return activities;
	}

	/**
	 * @param activities
	 *            the activities to set
	 */
	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

	public Set<Risk> getRisks() {
		return risks;
	}

	public void setRisks(Set<Risk> risks) {
		this.risks = risks;
	}

	@Override
	public String toString() {
		return "(" + code + ") " + name;
	}

	/**
	 * @return the orgUnit
	 */
	public OrgUnit getOrgUnit() {
		return orgUnit;
	}

	/**
	 * @param orgUnit
	 *            the orgUnit to set
	 */
	public void setOrgUnit(OrgUnit orgUnit) {
		this.orgUnit = orgUnit;
	}

	public void addRisk(Risk risk) {
		if (risks == null)
			risks = new LinkedHashSet<Risk>();

		risks.add(risk);
	}

	public Set<Measure> getMeasures() {
		return measures;
	}

	public void setMeasures(Set<Measure> measures) {
		this.measures = measures;
	}

	/**
	 * @return the owner
	 */
	public Employee getOwner() {
		return owner;
	}

	/**
	 * @param owner
	 *            the owner to set
	 */
	public void setOwner(Employee owner) {
		this.owner = owner;
	}

	public void generateCode() {

		if (perspective == null || orgUnit == null) {
			this.code = "?";
			return;
		}
//		int count = perspective.getObjectives().size();
		int id;
		if(this.getId() == null){
			id = 0;
		}else{
			id = this.getId();
		}
//		this.code = orgUnit.getCode() + "/" + perspective.getCode() + "/"
//		+ (count + 1);
		this.code = orgUnit.getCode() + "/" + perspective.getCode() + "/"
			+ id;
		System.out.println("Generated code " + this.code);
	}

	public Status getStatusOfAspect(Aspect aspect, Period period) {
		switch (aspect.getId()) {
		case 1:
			return riskStatusIn(period);
		case 2:
			return measureStatusIn(period);
		case 3:
			return processStatusIn(period);
		case 4:
			return busPlanStatusIn(period);
		case 5:
			return projectStatusIn(period);
		default:
			throw new IllegalStateException("Unrecognised aspect code");
		}
	}

	private Status processStatusIn(Period period2) {
		if(processes != null){
			if(processes.size() > 0){
				return Status.GREEN;
			}else{
				return Status.WHITE;
			}
		}else{
			return Status.WHITE;
		}
	}

	private Status riskStatusIn(Period period) {
		int year = Integer.parseInt(period.description);
		int sumRED=0;
		int sumGREEN=0;
		int sumWHITE=0;
		int sumYELLOW=0;
		int size=risks.size();
		
		for (Risk r : risks) {
			if (r.getPeriodInfoByYear(year) != null) {
				String color=RiskCharts.getRiskPeriodRobotColour(r.getPeriodInfoByYear(year),0);
				if (ViMSColorUtil.ROBOT_GREEN.equalsIgnoreCase(color))
					sumGREEN++;
				if (ViMSColorUtil.ROBOT_RED.equalsIgnoreCase(color))
					sumRED++;
				if (ViMSColorUtil.ROBOT_YELLOW.equalsIgnoreCase(color))	
					sumYELLOW++;
				if (ViMSColorUtil.WHITE.equalsIgnoreCase(color))	
					sumWHITE++;
			}

		}
		if (sumGREEN>sumRED) return Status.GREEN;
		if (sumRED>sumGREEN) return Status.RED;
		else if ((sumRED==sumGREEN&&sumRED!=0) || sumWHITE!=size || (sumYELLOW==size&&sumWHITE!=0)) return Status.YELLOW;


		else return Status.WHITE;
	}

	private Status measureStatusIn(Period period) {

		int year = Integer.parseInt(period.description);
		int sumRED=0;
		int sumGREEN=0;
		int sumWHITE=0;
		int size=measures.size();
		
		for (Measure m : measures) {
			if (m.getMeasurePeriodByYear(year) != null) {
				String color=MeasurePeriodCharts.getMeasurePeriodRobotColour(m.getMeasurePeriodByYear(year));
				if (ViMSColorUtil.ROBOT_GREEN.equalsIgnoreCase(color))
					sumGREEN+=Math.max(1,m.getWeight()*1);
				if (ViMSColorUtil.ROBOT_RED.equalsIgnoreCase(color))
					sumRED+=Math.max(1,m.getWeight()*1);
				if (ViMSColorUtil.WHITE.equalsIgnoreCase(color))	
					sumWHITE++;
			}
		}
		if (sumGREEN>sumRED) {
			return Status.GREEN;
		} else if (sumRED>sumGREEN) {
			return Status.RED;
		} else if ((sumRED==sumGREEN&&sumRED!=0) || sumWHITE!=size){
			return Status.YELLOW;
		} else {
			return Status.WHITE;
		}
	}

	
	
	private Status projectStatusIn(Period period) {

		int year = Integer.parseInt(period.description);
		float sumRED=0;
		float sumGREEN=0;
		float sumWHITE=0;
		int size=0;
		
		for (Project p : projects) {
			for (int i=1;i<=3;i++){
				if (p.getPeriodInfoByYear(year) != null) {
					String color=ProjectCharts.getProjectPeriodRobotColour(p.getPeriodInfoByYear(year),i);
					if (ViMSColorUtil.ROBOT_GREEN.equalsIgnoreCase(color)){
						sumGREEN++;
						size++;
					}else if (ViMSColorUtil.ROBOT_RED.equalsIgnoreCase(color)){
						sumRED++;
						size++;
					}else if (ViMSColorUtil.WHITE.equalsIgnoreCase(color))	
						sumWHITE++;
				}
			}

		}
		if (size>0){
			if (sumGREEN/size>=0.89) return Status.GREEN;
			else if (((sumGREEN/size)<0.89)&&((sumGREEN/size)>=0.66)) return Status.YELLOW;
			else if ((sumGREEN/size)<0.66) return Status.RED;
		}
		return Status.WHITE;

	}
	
	private Status busPlanStatusIn(Period period) {

		float numerator = 0, denominator = 0;
		
		for (Activity activity : activities) {
			if (!DateUtil.periodsIntersect(activity.getPeriod(), period))
				continue;

			Status status = activity.computeStatus();

			if (status != Status.WHITE){
				denominator += activity.getPriority().getValue();
			}
			if (status == Status.GREEN){
				numerator+= activity.getPriority().getValue();
			}
		}
		
		float perf = numerator / denominator;
		
		if (perf < 1 / 3f)
			return Status.RED;

		if (perf < 2 / 3f)
			return Status.YELLOW;

		if (perf <= 1f)
			return Status.GREEN;

		return Status.WHITE;
	}

	/**
	 * @return the period
	 */
	public Period getPeriod() {
		return period;
	}

	/**
	 * @param period
	 *            the period to set
	 */
	public void setPeriod(Period period) {
		this.period = period;
	}

	/**
	 * @return the processes
	 */
	public Set<Process> getProcesses() {
		return processes;
	}

	/**
	 * @param processes the processes to set
	 */
	public void setProcesses(Set<Process> processes) {
		this.processes = processes;
	}
	
	public Set<Process> getParentProcesses(){
		Set<Process> parentProcesses = new HashSet<Process>();
		
		for(Process p : processes){
			if(p.getParentProcess()==null){
				parentProcesses.add(p);
			}
		}
		
		return parentProcesses;
	}
	
	public Set<Measure> getMeasuresWithInitiatives(){
		Set<Measure> m = new HashSet<Measure>();
		
		for(Measure measure : getMeasures()){
			if(measure.getActiveInitiatives().size() > 0){
				m.add(measure);
			}
		}
		
		return m;
	}
	
	public Set<Activity> getActivitiesWithInitiatives(){
		Set<Activity> act = new HashSet<Activity>();
		
		for(Activity activity : getActivities()){
			if(activity.getActiveInitiatives().size() > 0){
				act.add(activity);
			}
		}
		
		return act;
	}
	
	public Set<Process> getParentProcessesWithInitiatives(){
		Set<Process> prc = new HashSet<Process>();
		
		for(Process process : getParentProcesses()){
			if(process.getActiveInitiatives().size() > 0){
				prc.add(process);
			}
		}
		
		return prc;
	}
	
	public Set<Project> getProjectsWithInitiatives(){
		Set<Project> prj = new HashSet<Project>();
		
		for(Project project : getProjects()){
			if(project.getActiveInitiatives().size() > 0){
				prj.add(project);
			}
		}
		
		return prj;
	}
	
	public Set<Risk> getRisksWithInitiatives(){
		Set<Risk> rsk = new HashSet<Risk>();
		
		for(Risk risk : getRisks()){
			if(risk.getActiveInitiatives().size() > 0){
				rsk.add(risk);
			}
		}
		
		return rsk;
	}
	
}
