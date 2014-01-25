package ae.iemq.vims.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Where;

import ae.iemq.vims.resource.DateDifferenceUtil;
import ae.iemq.vims.util.BaseEntityCreateDateComparetor;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SqlResultSetMappings( {
		@SqlResultSetMapping(name = "Project.getSumProjectCostByTime", columns = {
				@ColumnResult(name = "sumCost"), @ColumnResult(name = "time") }),
		@SqlResultSetMapping(name = "Project.getSumProjectEffortByTime", columns = {
				@ColumnResult(name = "sumEffort"), @ColumnResult(name = "time")}),
		@SqlResultSetMapping(name = "Project.getProjectResourcesReport", columns = {
				@ColumnResult(name = "empName"), @ColumnResult(name = "totalEffort") }
		)
})
@SuppressWarnings("serial")
@Entity
@Table(name = "project")
@NamedQueries( {
		@NamedQuery(name = "Project.project", query = "from Project order by startDate"),
		@NamedQuery(name = "Project.projectsForObjective", query = "from Project p where p.objective = :obj and p.recordStatus = 'Active' order by startDate"),
		@NamedQuery(name = "Project.projectsInPeriod", query = "from Project p where p.startDate <= :endDate and p.endDate >= :startDate and  p.complete is 0"),
		@NamedQuery(name = "Project.completed", query = "from Project p where p.complete is 0 order by p.startDate"),
		@NamedQuery(name = "Project.approved", query = "from Project p where p.approval is 1 order by p.startDate"), 
		@NamedQuery(name = "Project.associatedProjects", query = "from Project p where p.id in(select p_p.associatedProject from Project p,ProjectProject p_p where p.id = p_p.project and p.id = :id) and p.id != :id order by p.startDate"), 
		@NamedQuery(name = "Project.nonAssociatedProjects", query = "from Project p where p.id not in(select p_p.associatedProject from Project p,ProjectProject p_p where p.id = p_p.project and p.id = :id) and p.id != :id order by p.startDate"),
		@NamedQuery(name = "Project.projectsWithNameLike", query = "from Project p where p.name like :name")})
public class Project extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "reporting_frequency")
	private String reportingFrequency;

	@Column(name = "duration")
	private long duration;

	@Column(name = "initial_deliverables")
	private String initialDeliverables;

	@Column(name = "status")
	private int status;

	@Column(name = "goal")
	private String goal;

	@Column(name = "scope")
	private String scope;

	@Column(name = "approval")
	private boolean approval;

	@Column(name = "complete")
	private boolean complete;

	@Column(name = "benefits")
	private String benefits;

	@Column(name = "actual_cost")
	private double actualCost;

	@Column(name = "actual_effort")
	private double actualEffort;

	@Column(name = "baseline_cost")
	private double baselineCost;

	@Column(name = "baseline_effort")
	private double baselineEffort;

	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column(name = "end_date")
	@Temporal(TemporalType.DATE)
	private Date endDate;

	@Column(name = "actual_start_date")
	@Temporal(TemporalType.DATE)
	private Date currentStartDate;
	
	@Column(name = "actual_end_date")
	@Temporal(TemporalType.DATE)
	private Date currentEndDate;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Initiative> initiatives;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@Where(clause="record_status='Active'") 
	private Set<Initiative> activeInitiatives;

	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@Where(clause="record_status='Archive'") 
	private Set<Initiative> archiveInitiatives;

	@OneToMany(mappedBy = "project", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Comment> comments;

	@OneToMany(mappedBy = "project", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Where(clause="record_status='Active'")
	private Set<Comment> activeComments;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Where(clause="record_status='Archive'")
	private Set<Comment> archiveComments;

	
	@Column(name = "imported")
	private boolean isImported;
	
	@Column(name = "delay_impact")
	private boolean delayImpact;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@OrderBy("description")
	private Set<Deliverable> deliverables;

	@OneToOne(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private ProjectReport projectReport;

	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@OrderBy("createDateTime")
	//@Where(clause = "archive_dt is null")
	private Set<ProjectStatus> projectStatus;

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "project_project", joinColumns = @JoinColumn(name = "project", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "associated_project", referencedColumnName = "id"))
	private Set<Project> associatedProjects;

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "manager", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Employee manager;
	
	@JoinColumn(name = "team", referencedColumnName = "id")
	@ManyToOne
	private Team team;

	@JoinColumn(name = "objective", referencedColumnName = "id")
	@ManyToOne
	private Objective objective;

	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "category", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private EntityProperty category;
	
	public static enum ProjectCondition {
		Planned, Ongoing, Closed
	};
	
	@Column(name = "condition_status")
	//@Enumerated(EnumType.STRING)
	private String condition;

	@Column(name = "project_state")
	private String state;
	
	@Column(name = "baseline_updates")
	private int baselineUpdates;
	
	@Column(name = "currency")
	private String currency;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy = "project", fetch = FetchType.EAGER, cascade = {
			CascadeType.ALL })
	@org.hibernate.annotations.OrderBy(clause="project_year")
	private Set<ProjectPeriodInfo> projectPeriodsInfo;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	@org.hibernate.annotations.OrderBy(clause="item_subperiod")
	@Cascade({org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	private Set<ProjectLibraryItem> projectLibraryItems;
	
	public Project(){
		setProjectStatus(new HashSet<ProjectStatus>());
		setProjectPeriodsInfo(new HashSet<ProjectPeriodInfo>());
		setProjectLibraryItems(new HashSet<ProjectLibraryItem>());
		setInitiatives(new HashSet<Initiative>());
		setDeliverables(new HashSet<Deliverable>());
		setAssociatedProjects(new HashSet<Project>());
		setComments(new HashSet<Comment>());
		setActiveComments(new HashSet<Comment>());
		setArchiveComments(new HashSet<Comment>());
	}
	
	public Set<ProjectLibraryItem> getProjectLibraryItems() {
		return projectLibraryItems;
	}

	public void setProjectLibraryItems(Set<ProjectLibraryItem> projectLibraryItems) {
		this.projectLibraryItems = projectLibraryItems;
	}

	public void addLibraryItem(ProjectLibraryItem item){
		this.projectLibraryItems.add(item);
	}
	
	public int getBaselineUpdates() {
		return baselineUpdates;
	}

	public void setBaselineUpdates(int baselineUpdates) {
		this.baselineUpdates = baselineUpdates;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public double getProjectPlannedEffort() {
		double projectPlannedEffort = 0.0;

		for (Deliverable deliverable : this.getDeliverables()) {
			projectPlannedEffort += deliverable.getScheduledEffort();
		}
		return projectPlannedEffort;
	}

	public double getProjectActualCostForMonitoring() {

		double projectActualCost = 0.0;

		for (Deliverable deliverable : this.getDeliverables()) {
			if (deliverable.getActualEndDate()!=null){
				projectActualCost += deliverable.getActualCost();
			}else if (deliverable.getActualStartDate()!=null&&deliverable.getActualEndDate()==null){
				projectActualCost += deliverable.getProjectedCost();
			}else{
				projectActualCost += deliverable.getScheduledCost();
			}
		}
		return projectActualCost;
	}
	
	public double getProjectActualCost() {
		double projectActualCost = 0.0;
		for (Deliverable deliverable : this.getDeliverables()) {
			projectActualCost += deliverable.getActualCost();
		}
		return projectActualCost;
	}
	
	public double getProjectProjectedCost() {

		double projectProjectedCost = 0.0;

		for (Deliverable deliverable : this.getDeliverables()) {
			projectProjectedCost += deliverable.getProjectedCost();
		}
		return projectProjectedCost;
	}

	public double getProjectActualEffort() {

		double projectActualEffort = 0.0;

		for (Deliverable deliverable : this.getDeliverables()) {
			projectActualEffort += deliverable.getActualEffort();
		}
		return projectActualEffort;
	}
	
	public double getProjectActualEffortForMonitoring() {

		double projectActualEffort = 0.0;

		for (Deliverable deliverable : this.getDeliverables()) {
			if (deliverable.getActualEndDate()!=null){
				projectActualEffort += deliverable.getActualEffort();
			}else if (deliverable.getActualStartDate()!=null&&deliverable.getActualEndDate()==null){
				projectActualEffort += deliverable.getProjectedEffort();
			}else{
				projectActualEffort += deliverable.getScheduledEffort();
			}
		}
		return projectActualEffort;
	}
	
	public double getProjectProjectedEffort() {

		double projectProjectedEffort = 0.0;

		for (Deliverable deliverable : this.getDeliverables()) {
			projectProjectedEffort += deliverable.getProjectedEffort();
		}
		return projectProjectedEffort;
	}
	//Calculates the project duration from the deliverables actual start and end dates
	public int getProjectActualDuration() {
		Date start=null;
		Date temp=null;
		Date end=null;

		for (Deliverable deliverable : this.getDeliverables()) {
			if (deliverable.getActualStartDate()!=null){
				temp= deliverable.getActualStartDate();
				System.out.println("START DATE WORKING-------------------.");
				if (start==null || temp.before(start)) start=temp;
			}
			if (deliverable.getActualEndDate()!=null){
				temp=deliverable.getActualEndDate();
				System.out.println("END DATE WORKING-------------------.");
				if (end==null ||
						temp.after(end)) end=temp;
			}
		}
		if (start!=null && end!=null)  return DateDifferenceUtil.getDateDifferenceInDays(start, end);
		if (start!=null && end==null)  return DateDifferenceUtil.getDateDifferenceInDays(start, new Date());
		return 0;
	}
	
	public int getProjectActualDurationForMonitoring() {
		Date start=null;
		Date temp=null;
		Date end=null;

		for (Deliverable deliverable : this.getDeliverables()) {
			if (deliverable.getActualStartDate()!=null){
				temp= deliverable.getActualStartDate();
				System.out.println("START DATE WORKING-------------------.");
				if (start==null || temp.before(start)) start=temp;
				
				if (deliverable.getProjectedEndDate()!=null){
					temp=deliverable.getProjectedEndDate();
					System.out.println("END DATE WORKING-------------------.");
					if (end==null ||
							temp.after(end)) end=temp;
				}else if (deliverable.getActualEndDate()!=null){
					temp=deliverable.getActualEndDate();
					System.out.println("END DATE WORKING-------------------.");
					if (end==null ||
							temp.after(end)) end=temp;
				}
			}else {
				if (deliverable.getScheduledStartDate()!=null){
					temp= deliverable.getScheduledStartDate();
					System.out.println("START DATE WORKING-------------------.");
					if (start==null || temp.before(start)) start=temp;
				}
				if (deliverable.getScheduledEndDate()!=null){
					temp=deliverable.getScheduledEndDate();
					System.out.println("END DATE WORKING-------------------.");
					if (end==null ||
							temp.after(end)) end=temp;
				}
			}
		}
		if (start!=null && end!=null)  return DateDifferenceUtil.getDateDifferenceInDays(start, end);
		return 0;
	}
	
	
	public int getProjectScheduledDuration() {
		Date start=null;
		Date temp=null;
		Date end=null;

		for (Deliverable deliverable : this.getDeliverables()) {
			if (deliverable.getScheduledStartDate()!=null){
				temp= deliverable.getScheduledStartDate();
				System.out.println("START DATE WORKING-------------------.");
				if (start==null || temp.before(start)) start=temp;
			}
			if (deliverable.getScheduledEndDate()!=null){
				temp=deliverable.getScheduledEndDate();
				System.out.println("END DATE WORKING-------------------.");
				if (end==null ||
						temp.after(end)) end=temp;
			}
		}
		if (start!=null && end!=null)  return DateDifferenceUtil.getDateDifferenceInDays(start, end);
		if (start!=null && end==null)  return DateDifferenceUtil.getDateDifferenceInDays(start, new Date());
		return 0;
	}
	
	//TODO Rename to getScheduledCost or other compliant convention
	public double getProjectPlannedCost() {
		double projectPlannedCost = 0.0;

		for (Deliverable deliverable : this.getDeliverables()) {
			projectPlannedCost += deliverable.getScheduledCost();
		}
		return projectPlannedCost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public String getBenefits() {
		return benefits;
	}

	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public double getBaselineCost() {
		return baselineCost;
	}

	public void setBaselineCost(double baselineCost) {
		this.baselineCost = baselineCost;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {

		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Set<Deliverable> getDeliverables() {
		return deliverables;
	}

	public void setDeliverables(Set<Deliverable> deliverables) {
		this.deliverables = deliverables;
	}

	public Set<Project> getAssociatedProjects() {
		return associatedProjects;
	}

	public void setAssociatedProjects(Set<Project> associatedProjects) {
		this.associatedProjects = associatedProjects;
	}

//	public Set<Objective> getObjectives() {
//		return objectives;
//	}
//
//	public void setObjectives(Set<Objective> objectives) {
//		this.objectives = objectives;
//	}

	public boolean isApproval() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public String getReportingFrequency() {
		return reportingFrequency;
	}

	public void setReportingFrequency(String reportingFrequency) {
		this.reportingFrequency = reportingFrequency;
	}

	public double getActualCost() {
		return actualCost;
	}

	public void setActualCost(double actualCost) {
		this.actualCost = actualCost;
	}

	public double getActualEffort() {
		return actualEffort;
	}

	public void setActualEffort(double actualEffort) {
		this.actualEffort = actualEffort;
	}

	public double getBaselineEffort() {
		return baselineEffort;
	}

	public void setBaselineEffort(double baselineEffort) {
		this.baselineEffort = baselineEffort;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public String getInitialDeliverables() {
		return initialDeliverables;
	}

	public void setInitialDeliverables(String initialDeliverables) {
		this.initialDeliverables = initialDeliverables;
	}

	public ProjectReport getProjectReport() {
		return projectReport;
	}

	public void setProjectReport(ProjectReport projectReport) {
		this.projectReport = projectReport;
	}
	
	public Set<ProjectStatus> getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(Set<ProjectStatus> projectStatus) {
		this.projectStatus = projectStatus;
	}

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public boolean isImported() {
		return isImported;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}

public double getProjectPeriodPlannedCost (Period period){
	double periodPlannedCost = 0.0;
	for (Deliverable deliverable : this.getDeliverables()) {
		if (deliverable.getScheduledEndDate()!=null){
		if (DateDifferenceUtil.isBetween(deliverable.getScheduledStartDate(), period)&&
				DateDifferenceUtil.isBetween(deliverable.getScheduledEndDate(), period))
		periodPlannedCost += deliverable.getScheduledCost();
		if (DateDifferenceUtil.isBetween(deliverable.getScheduledStartDate(), period)&&
				deliverable.getScheduledEndDate().after(period.endDate))
			periodPlannedCost += deliverable.getScheduledCost()*((period.endDate.getTime()-deliverable.getScheduledStartDate().getTime())/(deliverable.getScheduledEndDate().getTime()-deliverable.getScheduledStartDate().getTime()));
		if (DateDifferenceUtil.isBetween(deliverable.getScheduledEndDate(), period)&&
				deliverable.getScheduledStartDate().before(period.startDate))
			periodPlannedCost += deliverable.getScheduledCost()*((deliverable.getScheduledEndDate().getTime()-period.startDate.getTime())/(deliverable.getScheduledEndDate().getTime()-deliverable.getScheduledStartDate().getTime()));
		}
	}
	return periodPlannedCost;
}

/*
 *This Methods Calculate the Cost or Efforts (actual or Planned) within a given period by fetching
 * all the deliverables in the project 
 * Used in the ProjectMonitoringOfficePage
 */
public double getProjectPeriodActualCost (Period period){
	double periodActualCost = 0.0;

	for (Deliverable deliverable : this.getDeliverables()) {
		if (deliverable.getActualEndDate()!=null){
		if (DateDifferenceUtil.isBetween(deliverable.getActualStartDate(), period)&&
				DateDifferenceUtil.isBetween(deliverable.getActualEndDate(), period))
		periodActualCost += deliverable.getActualCost();
		if (DateDifferenceUtil.isBetween(deliverable.getActualStartDate(), period)&&
				deliverable.getActualEndDate().after(period.endDate))
			periodActualCost += deliverable.getActualCost()*((period.endDate.getTime()-deliverable.getActualStartDate().getTime())/(deliverable.getActualEndDate().getTime()-deliverable.getActualStartDate().getTime()));
		if (DateDifferenceUtil.isBetween(deliverable.getActualEndDate(), period)&&
				deliverable.getActualStartDate().before(period.startDate))
			periodActualCost += deliverable.getActualCost()*((deliverable.getActualEndDate().getTime()-period.startDate.getTime())/(deliverable.getActualEndDate().getTime()-deliverable.getActualStartDate().getTime()));
		}
	}
	return periodActualCost;
}
	
	public double getProjectPeriodPlannedEffort (Period period){
		double periodPlannedEffort = 0.0;
		for (Deliverable deliverable : this.getDeliverables()) {
			System.out.println("Calcuating Planned Effort for PERIOD-----> "+period.description+", PROJECT--->"+this.name);
			if (deliverable.getScheduledEndDate()!=null){
			if (DateDifferenceUtil.isBetween(deliverable.getScheduledStartDate(), period)&&
					DateDifferenceUtil.isBetween(deliverable.getScheduledEndDate(), period))
			periodPlannedEffort += deliverable.getScheduledEffort();
			if (DateDifferenceUtil.isBetween(deliverable.getScheduledStartDate(), period)&&
					deliverable.getScheduledEndDate().after(period.endDate))
				periodPlannedEffort += deliverable.getScheduledEffort()*((period.endDate.getTime()-deliverable.getScheduledStartDate().getTime())/(deliverable.getScheduledEndDate().getTime()-deliverable.getScheduledStartDate().getTime()));
			if (DateDifferenceUtil.isBetween(deliverable.getScheduledEndDate(), period)&&
					deliverable.getScheduledStartDate().before(period.startDate))
				periodPlannedEffort += deliverable.getScheduledEffort()*((deliverable.getScheduledEndDate().getTime()-period.startDate.getTime())/(deliverable.getScheduledEndDate().getTime()-deliverable.getScheduledStartDate().getTime()));
			}
		}
		return periodPlannedEffort;
	}

	public double getProjectPeriodActualEffort (Period period){
		double periodActualEffort = 0.0;

		for (Deliverable deliverable : this.getDeliverables()) {
			if (deliverable.getActualEndDate()!=null){
			if (DateDifferenceUtil.isBetween(deliverable.getActualStartDate(), period)&&
					DateDifferenceUtil.isBetween(deliverable.getActualEndDate(), period))
			periodActualEffort += deliverable.getActualEffort();
			if (DateDifferenceUtil.isBetween(deliverable.getActualStartDate(), period)&&
					deliverable.getActualEndDate().after(period.endDate))
				periodActualEffort += deliverable.getActualEffort()*((period.endDate.getTime()-deliverable.getActualStartDate().getTime())/(deliverable.getActualEndDate().getTime()-deliverable.getActualStartDate().getTime()));
			if (DateDifferenceUtil.isBetween(deliverable.getActualEndDate(), period)&&
					deliverable.getActualStartDate().before(period.startDate))
				periodActualEffort += deliverable.getActualEffort()*((deliverable.getActualEndDate().getTime()-period.startDate.getTime())/(deliverable.getActualEndDate().getTime()-deliverable.getActualStartDate().getTime()));
			}
		}
		return periodActualEffort;	
	
}
	
	public Project setProjectStatus(Period period)
	{
		
		double effort = getProjectPeriodActualEffort(period);
		double cost = getProjectPeriodActualCost(period);
		/*for(Deliverable del : deliverables){
			 effort +=  del.getActualEffort();
			 cost += del.getActualCost();
		}*/
		
		long duration = DateDifferenceUtil.getDateDifferenceInDays(getStartDate(), new Date());
		
		
		System.out.println("deliverables cost-->"+cost);
		System.out.println("deliverables effort-->"+effort);
		System.out.println("project cost-->"+getBaselineCost());
		System.out.println("project effort-->"+getBaselineEffort());
		
		/*Set the status of the project for project monitoring office*/
		int status = 0;

		
		if (isAllTaskCompleted()) {
			if (getProjectPlannedCost() >= getProjectActualCost())
				status++;
			if (getProjectPlannedEffort() >= getProjectActualEffort())
				status++;
			if (!isDateCompromised())
				status++;
		}
		else{
			if (getProjectPlannedCost() >= getProjectProjectedCost())
				status++;
			if (getProjectPlannedEffort() >= getProjectProjectedEffort())
				status++;
			if (!isDateCompromised())
				status++;
		}
		
		System.out.println("project status-->"+status);
		setStatus(status);
		
		//calculatePlannedPerPeriod(projectStatus);
		//setProjectStatus(projStatus);
		
		return this;
	}


	//Calculates the project scheduled startdate
	public Date getScheduledStartDate() {
		Date start=null;
		Date temp=null;
		if (getDeliverables()!=null){
		for (Deliverable deliverable : this.getDeliverables()) {
			if (deliverable.getScheduledStartDate()!=null){
				temp= deliverable.getScheduledStartDate();
				if (start==null || temp.before(start)) start=temp;
			}
		}
		}
		return start;
	}
	
	//Calculates the project scheduled enddate
	public Date getScheduledEndDate() {
		Date end=null;
		Date temp=null;
		if (getDeliverables()!=null){
		for (Deliverable deliverable : this.getDeliverables()) {
			if (deliverable.getScheduledEndDate()!=null){
				temp= deliverable.getScheduledEndDate();
				if (end==null || temp.after(end)) end=temp;
			}
		}
		}
		return end;
	}
	
	//Calculates the project actual startdate
	public Date getActualStartDate() {
		Date start=null;
		Date temp=null;
		if (getDeliverables()!=null){
		for (Deliverable deliverable : this.getDeliverables()) {
			if (deliverable.getActualStartDate()!=null){
				temp= deliverable.getActualStartDate();
				if (start==null || temp.before(start)) start=temp;
			}
		}
		}
		return start;
	}
	
	//Calculates the project actual enddate
	public Date getActualEndDate() {
		Date end=null;
		Date temp=null;
		if (getDeliverables()!=null){
		for (Deliverable deliverable : this.getDeliverables()) {
			if (deliverable.getActualEndDate()!=null){
				temp= deliverable.getActualEndDate();
				if (end==null || temp.after(end)) end=temp;
			}
		}
		}
		if (isAllTaskCompleted()) return end;
		else return null;
	}

	//Calculates the project projected enddate
	public Date getProjectedEndDate() {
		Date proj=null;
		Date temp=null;
		if (isAllTaskCompleted()){
		for (Deliverable deliverable : this.getDeliverables()) {
			if (deliverable.getProjectedEndDate()!=null){
				temp= deliverable.getProjectedEndDate();
				if (proj==null || temp.after(proj)) proj=temp;
			}
		}
		}
		else{
			for (Deliverable deliverable : this.getDeliverables()) {
				if (deliverable.getActualEndDate()!=null){
					temp= deliverable.getActualEndDate();
					if (proj==null || temp.after(proj)) proj=temp;
				}
				else if (deliverable.getProjectedEndDate()!=null){
					temp= deliverable.getProjectedEndDate();
					if (proj==null || temp.after(proj)) proj=temp;
				}
			}
		}
		return proj;
	}
	
	//Calculates the project projected or Actual enddate
	public Date getActualOrProjectedEndDate() {
		Date proj=null;
		Date temp=null;
		if (isAllTaskCompleted()){
		return getActualEndDate();
		}
		else{
			for (Deliverable deliverable : this.getDeliverables()) {
				if (deliverable.getActualEndDate()!=null){
					temp= deliverable.getActualEndDate();
					if (proj==null || temp.after(proj)) proj=temp;
				}
				else if (deliverable.getProjectedEndDate()!=null){
					temp= deliverable.getProjectedEndDate();
					if (proj==null || temp.after(proj)) proj=temp;
				}
			}
			
		}
		if (proj!=null&&proj.before(getScheduledEndDate())){
			proj=getScheduledEndDate();
		}
		return proj;
	}
	
	public boolean isAllTaskCompleted(){
		int count=0,comp=0;
		if (getDeliverables()!=null){
		for (Deliverable deliverable : this.getDeliverables()) {
			count++;
			if (deliverable.getActualEndDate()!=null)
				comp++;				
			}
		}
		if (count==comp) return true;
		else return false;
	}
	
	/**
	 * @author Ricardo Alejandro
	 * @return true if Project End Date estimated to be after Scheduled End Date
	 * or if there is no sufficent information for estimation
	 */	
	public boolean isDateCompromised(){
		Date now=new Date();
		if (getDeliverables().size()<=0){
			return true;
		}
			
		if(getActualStartDate()==null && now.after(getScheduledStartDate())){
			return true;
		}
		else if (getActualStartDate()!=null && !isAllTaskCompleted()){
			if (getProjectedEndDate()!=null && getProjectedEndDate().after(getScheduledEndDate()))
				return true;
			if (getProjectedEndDate()!=null && now.after(getScheduledEndDate()))
				return true;
		}
		if (checkActualTaskDates()>0){
			return true;
		}
		return false;
	}

	/**
	 * @author Ricardo Quintana
	 * @return 0 if All Task with Actual Start Date have either a 
	 * Projected End Date or an Actual End Date. 1 if Actual or Projected End dates are 
	 * missing. 2 if Actual or Projected End Dates are set but later than current date.
	 */
	public int checkActualTaskDates(){
		Date now=new Date();
		if (getScheduledStartDate().before(now)){
		for (Deliverable deliverable : getDeliverables()){
			if (deliverable.getActualStartDate()!=null){
				if (deliverable.getProjectedEndDate()==null && 
						deliverable.getActualEndDate()==null)
					return 1;
				else if (deliverable.getProjectedEndDate()!=null && deliverable.getActualEndDate()==null){
					if (deliverable.getProjectedEndDate().after(getScheduledEndDate()))
						return 2;
				}
				else if (deliverable.getActualEndDate()!=null){
					if (deliverable.getActualEndDate().after(getScheduledEndDate()))
						return 2;
				}
			}//if
		}//for
		}//if
		if (getScheduledEndDate().before(now)){
			for (Deliverable deliverable : getDeliverables()){
			if (deliverable.getProjectedEndDate()==null && 
					deliverable.getActualEndDate()==null)
				return 1;
			else if (deliverable.getActualEndDate()!=null)
					if (deliverable.getActualEndDate().after(getScheduledEndDate()))
						return 2;
			}//for
		}//if

		return 0;
	}

	public Objective getObjective() {
		return objective;
	}

	public void setObjective(Objective objective) {
		this.objective = objective;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Set<ProjectPeriodInfo> getProjectPeriodsInfo() {
		return projectPeriodsInfo;
	}

	public void setProjectPeriodsInfo(Set<ProjectPeriodInfo> periodsInfo) {
		this.projectPeriodsInfo = periodsInfo;
	}
	
	public void addPeriodInfo(ProjectPeriodInfo period) {
		if (projectPeriodsInfo == null)
			projectPeriodsInfo = new LinkedHashSet<ProjectPeriodInfo>();

		projectPeriodsInfo.add(period);
	}
	
	public ProjectPeriodInfo getLastPeriodInfo(){
		int year = 0;
		ProjectPeriodInfo lastPeriodInfo = null;
		for(ProjectPeriodInfo pi : getProjectPeriodsInfo()){
			if(pi.getYear() > year){
				year = pi.getYear();
				lastPeriodInfo = pi;
			}
		}
		return lastPeriodInfo;
	}
	
	public ProjectPeriodInfo getPeriodInfoByYear(int year){
		if (projectPeriodsInfo!=null){
			for (ProjectPeriodInfo p:projectPeriodsInfo){
				if (p.getYear()==year)
					return p;
			}
		}
		return null;
	}
	
	public Set<ProjectLibraryItem> getProjectFolderItems(ProjectLibraryFolder plb) {
		Set<ProjectLibraryItem> items=new LinkedHashSet<ProjectLibraryItem>();
		if(projectLibraryItems != null){
			for (ProjectLibraryItem item:projectLibraryItems){
				if(item.getFolder()==plb){
					items.add(item);
				}
			}
		}
		return items;
	}

	public Set<ProjectLibraryItem> getLibraryItemsForYear(int year) {
		Set<ProjectLibraryItem> items=new LinkedHashSet<ProjectLibraryItem>();
		if(projectLibraryItems != null){
			for (ProjectLibraryItem item:projectLibraryItems){
				if(item.getYear()==year){
					items.add(item);
				}
			}
		}
		return items;
	}
	
	public Set<ProjectLibraryItem> getLibraryItemsForYear(int year,ProjectLibraryFolder plf) {
		Set<ProjectLibraryItem> items=new LinkedHashSet<ProjectLibraryItem>();
		if(projectLibraryItems != null){
			for (ProjectLibraryItem item:projectLibraryItems){
				if(item.getYear()==year && item.getFolder()==plf){
					items.add(item);
				}
			}
		}
		return items;
	}
	
	public ProjectLibraryItem getLibraryItemForPeriod(int year,int subperiod){
		if(projectLibraryItems != null){
			for (ProjectLibraryItem pli:getProjectLibraryItems()){
				if (pli.getYear()==year && pli.getSubperiod()==subperiod){
					return pli;
				}
			}
		}
		return null;
	}
	
	public ProjectLibraryItem getLibraryItemForPeriod(int year,int subperiod, ProjectLibraryFolder plf){
		if(projectLibraryItems != null){
			for (ProjectLibraryItem pli:projectLibraryItems){
				if (pli.getYear()==year && pli.getSubperiod()==subperiod && pli.getFolder()==plf){
					return pli;
				}
			}
		}
		return null;
	}
	
	

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Set<Initiative> getInitiatives() {
		return initiatives;
	}

	public void setInitiatives(Set<Initiative> initiatives) {
		this.initiatives = initiatives;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the comments
	 */
	public Set<Comment> getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public EntityProperty getCategory() {
		return category;
	}

	public void setCategory(EntityProperty category) {
		this.category = category;
	}
	
	/**Add a Comment object to Comments Set
	 * 
	 * @param Comment
	 */
	public void addComment(Comment comment) {
		if (comment != null) {
			this.comments.add(comment);
			this.activeComments.add(comment);
		}
	}

	public boolean isDelayImpact() {
		return delayImpact;
	}

	public void setDelayImpact(boolean delayImpact) {
		this.delayImpact = delayImpact;
	}

	public Date getCurrentStartDate() {
		return currentStartDate;
	}

	public void setCurrentStartDate(Date currentStartDate) {
		this.currentStartDate = currentStartDate;
	}

	public Date getCurrentEndDate() {
		return currentEndDate;
	}

	public void setCurrentEndDate(Date currentEndDate) {
		this.currentEndDate = currentEndDate;
	}

	/**
	 * @return the activeComments
	 */
	public Set<Comment> getActiveComments() {
		TreeSet<Comment> ts = new TreeSet<Comment>(new BaseEntityCreateDateComparetor());
		ts.addAll(this.activeComments);
		return ts;
	}

	/**
	 * @param activeComments the activeComments to set
	 */
	public void setActiveComments(Set<Comment> activeComments) {
		this.activeComments = activeComments;
	}

	/**
	 * @return the archiveComments
	 */
	public Set<Comment> getArchiveComments() {
		return archiveComments;
	}

	/**
	 * @param archiveComments the archiveComments to set
	 */
	public void setArchiveComments(Set<Comment> archiveComments) {
		this.archiveComments = archiveComments;
	}

	public void removeComment(Comment comment) {
		if(comment != null){
			this.comments.remove(comment);
			this.activeComments.remove(comment);
		}
	}

	/**
	 * @return the activeInitiatives
	 */
	public Set<Initiative> getActiveInitiatives() {
		return activeInitiatives;
	}

	/**
	 * @param activeInitiatives the activeInitiatives to set
	 */
	public void setActiveInitiatives(Set<Initiative> activeInitiatives) {
		this.activeInitiatives = activeInitiatives;
	}

	/**
	 * @return the archiveInitiatives
	 */
	public Set<Initiative> getArchiveInitiatives() {
		return archiveInitiatives;
	}

	/**
	 * @param archiveInitiatives the archiveInitiatives to set
	 */
	public void setArchiveInitiatives(Set<Initiative> archiveInitiatives) {
		this.archiveInitiatives = archiveInitiatives;
	}

}


