package ae.iemq.vims.domain;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import ae.iemq.vims.domain.balancedScorecard.Measure;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "employee")
@NamedQueries( {
	@NamedQuery(name = "Employee.employeeById", query = "from Employee e where e.id = :id"),
	@NamedQuery(name = "Employee.employeesWithNameLike", query = "from Employee e where e.name like :name"),
	@NamedQuery(name = "Employee.employee", query = "from Employee order by name"),
	@NamedQuery(name = "Employee.employeeLastFirst", query = "from Employee order by create_dt desc")
})
public class Employee extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	private Set<EmployeeCompetency> competencies;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	private Set<EmployeeTasking> taskings;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Initiative> intiative;
		
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy = "resource", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<DeliverableResource> deliverables;

	//OLD Implementation of employee_measure table never used!
//	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
//	@ManyToMany
//	@JoinTable(name = "employee_measure", 
//			joinColumns = @JoinColumn(name = "employee", referencedColumnName = "id"), 
//			inverseJoinColumns = @JoinColumn(name = "measure", referencedColumnName = "id"))
//	private Set<Measure> measures;
	
	@JoinColumn(name = "job_title", referencedColumnName = "id")
	@ManyToOne
	private JobTitle jobTitle;
	
	@OneToMany(mappedBy = "attendee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<MeetingAttendee> meetings;

	@OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Activity> activities;
	
	@OneToOne(mappedBy = "employee")
	private User user;
	
	public Set<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Set<Activity> meetings) {
		this.activities = meetings;
	}
	
	@OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Objective> objectives;
	
	public Set<Objective> getObjectives() {
		return objectives;
	}

	public void setObjectives(Set<Objective> meetings) {
		this.objectives = meetings;
	}
	
	@OneToMany(mappedBy = "manager", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Project> projects;
	
	
	@OneToMany(mappedBy = "dataOwner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Measure> measures;
	
	@JoinColumn(name = "org_unit", referencedColumnName = "id")
	@ManyToOne
	private OrgUnit orgUnit;
	
	public JobTitle getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}

	public OrgUnit getOrgUnit() {
		return orgUnit;
	}

	public void setOrgUnit(OrgUnit orgUnit) {
		this.orgUnit = orgUnit;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<EmployeeTasking> getTaskings() {
		return taskings;
	}

	public void setTaskings(Set<EmployeeTasking> taskings) {
		this.taskings = taskings;
	}

	public Set<MeetingAttendee> getMeetings() {
		return meetings;
	}

	public void setMeetings(Set<MeetingAttendee> meetings) {
		this.meetings = meetings;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<EmployeeCompetency> getCompetencies() {
		return competencies;
	}

	public void setCompetencies(Set<EmployeeCompetency> competencies) {
		this.competencies = competencies;
	}

	public Set<DeliverableResource> getDeliverables() {
		return deliverables;
	}

	public void setDeliverables(Set<DeliverableResource> deliverables) {
		this.deliverables = deliverables;
	}

	/**
	 * @return the measures
	 */
	public Set<Measure> getMeasures() {
		return measures;
	}

	/**
	 * @param measures the measures to set
	 */
	public void setMeasures(Set<Measure> measures) {
		this.measures = measures;
	}

	/**
	 * @return the intiative
	 */
	public Set<Initiative> getIntiative() {
		return intiative;
	}

	/**
	 * @param intiative the intiative to set
	 */
	public void setIntiative(Set<Initiative> intiative) {
		this.intiative = intiative;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}


}
