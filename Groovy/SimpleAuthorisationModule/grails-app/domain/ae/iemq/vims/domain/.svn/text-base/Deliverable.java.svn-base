package ae.iemq.vims.domain;

import java.util.Calendar;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import ae.iemq.vims.resource.DateDifferenceUtil;
import ae.iemq.vims.util.DateUtil;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "deliverable")
@NamedQueries( {
		@NamedQuery(name = "Deliverable.actualEffort", query = "select sum(del.actualEffort) from Deliverable del where del.project = :project group by del.project"),
		@NamedQuery(name = "Deliverable.actualCost", query = "select sum(del.actualCost) from Deliverable del where del.project = :project group by del.project"),
		@NamedQuery(name = "Deliverable.plannedEffort", query = "select sum(del.scheduledEffort) from Deliverable del where del.project = :project group by del.project"),
		@NamedQuery(name = "Deliverable.plannedCost", query = "select sum(del.scheduledCost) from Deliverable del where del.project = :project group by del.project"),
		@NamedQuery(name = "Deliverable.deliverable", query = "select distinct del from Deliverable del left join fetch del.resources delres left join fetch delres.resource where del.project = :project order by del.scheduledStartDate"),
		@NamedQuery(name = "Deliverable.deliverableDesc", query = "select distinct del from Deliverable del left join fetch del.resources delres left join fetch delres.resource where del.project = :project order by del.description"),
		@NamedQuery(name = "Deliverable.deliverablesByPeriod", query = "from Deliverable deliverable "
				+ "where deliverable.scheduledStartDate <= :endDate and deliverable.scheduledEndDate >= :startDate and deliverable.project = :project order by deliverable.scheduledStartDate") })
public class Deliverable extends BaseEntity {
	@Column(name = "description")
	private String description;

	@Column(name = "actual_start_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date actualStartDate;

	@OneToMany(mappedBy = "deliverable", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<DeliverableResource> resources;

	@Column(name = "actual_end_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date actualEndDate;

	@Column(name = "projected_end_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date projectedEndDate;

	@Column(name = "scheduled_start_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date scheduledStartDate;

	@Column(name = "scheduled_end_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date scheduledEndDate;

	@Column(name = "scheduled_cost")
	private double scheduledCost;

	@Column(name = "projected_cost")
	private double projectedCost;

	@Column(name = "actual_cost")
	private double actualCost;

	// ActualEffort refers to the deliverable duration
	@Column(name = "actual_effort")
	private double actualEffort;

	// ScheduledEffort refers to the deliverable duration
	@Column(name = "scheduled_effort")
	private double scheduledEffort;

	// ScheduledEffort refers to the deliverable duration
	@Column(name = "projected_effort")
	private double projectedEffort;

	@Column(name = "color")
	private String color;

	@Column(name = "completed")
	private double completed;

	@JoinColumn(name = "owner", referencedColumnName = "id")
	@ManyToOne
	private Employee owner;

	@JoinColumn(name = "project", referencedColumnName = "id")
	@ManyToOne
	private Project project;

	@Column(name = "percentage_complete")
	private double percentageComplete;

	@Column(name = "scheduled_duration")
	private int scheduledDuration;

	@Column(name = "actual_duration")
	private int actualDuration;

	@Column(name = "projected_duration")
	private int projectedDuration;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Employee getOwner() {
		return owner;
	}

	public void setOwner(Employee owner) {
		this.owner = owner;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Date getActualEndDate() {
		return actualEndDate;
	}

	public Date getProjectedEndDate() {
		return projectedEndDate;
	}

	public void setActualEndDate(Date actualEndDate) {
		this.actualEndDate = DateUtil.endOfDay(actualEndDate);

	}

	public void setProjectedEndDate(Date projectedEndDate) {
		this.projectedEndDate = DateUtil.endOfDay(projectedEndDate);

	}

	public Date getActualStartDate() {
		return actualStartDate;
	}

	public Date getScheduledEndDate() {
		return scheduledEndDate;
	}

	public void setScheduledEndDate(Date scheduledEndDate) {
		this.scheduledEndDate = DateUtil.endOfDay(scheduledEndDate);

	}

	public Date getScheduledStartDate() {
		return scheduledStartDate;
	}

	public void setScheduledStartDate(Date scheduledStartDate) {
		this.scheduledStartDate = scheduledStartDate;
	}

	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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

	public void setActualEffort() {
		double aeff = 0;
		for (DeliverableResource resource : this.getResources()) {
			aeff += resource.getActualEffort();
		}
		setActualEffort(aeff);
	}

	public double getCompleted() {
		return completed;
	}

	public void setCompleted(double completed) {
		this.completed = completed;
	}

	public double getScheduledCost() {
		return scheduledCost;
	}

	public void setScheduledCost(double scheduledCost) {
		this.scheduledCost = scheduledCost;
	}

	public double getScheduledEffort() {
		return scheduledEffort;
	}

	public void setScheduledEffort(double scheduledEffort) {
		this.scheduledEffort = scheduledEffort;
	}

	public void setScheduledEffort() {
		double seff = 0;
		for (DeliverableResource resource : this.getResources()) {
			seff += resource.getScheduledEffort();
		}
		setScheduledEffort(seff);
	}

	public Set<DeliverableResource> getResources() {
		return resources;
	}

	public void setResources(Set<DeliverableResource> resources) {
		this.resources = resources;
	}

	public double getPercentageComplete() {
		return percentageComplete;
	}

	public void setPercentageComplete(double percentageComplete) {
		this.percentageComplete = percentageComplete;
	}

	private int computeDuration(Date startDate, Date endDate) {
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		if (endDate.after(startDate) || endDate.equals(startDate)) {// Checks
			// end
			// date
			// in
			// after
			// start
			// date
			start.setTime(startDate);
			end.setTime(endDate);

			float startYear = start.get(Calendar.YEAR);
			float startDayInYear = start.get(Calendar.DAY_OF_YEAR);
			float endYear = end.get(Calendar.YEAR);
			float endDayInYear = end.get(Calendar.DAY_OF_YEAR);
			float days = (((endYear - startYear) * 353) + (endDayInYear - startDayInYear)) + 1;
			// this.actualEffort = days;

			// calculating the working days
			days = (float) DateDifferenceUtil
					.getDateDifferenceInDaysExcludingSatSun(start.getTime(),
							end.getTime());

			// taking out the public holidays
			int publicHolidays = getPublicHolidaysBetweenDates(start.getTime(),
					end.getTime());

			if (days > publicHolidays) {
				days = days - publicHolidays;
			} else {
				days = 0;
			}

			/*
			 * //calculating the weekends System.out.println("days before
			 * calculation-->"+days); int remainingDays = (int)days%7;
			 * System.out.println("remaining days-->"+remainingDays); float
			 * daysDividableBySeven = days - remainingDays;
			 * System.out.println("daysDividableBySeven-->"+daysDividableBySeven);
			 * days -= (daysDividableBySeven / 7)*2; System.out.println("days
			 * after calculation-->"+days);
			 * 
			 * //calculation weekends in remain days --not complete float
			 * weekDays[] = new float[remainingDays]; Calendar tempEnd =
			 * Calendar.getInstance();
			 * 
			 * 
			 * for(int i =0; i<weekDays.length ; i++){
			 * weekDays[i]=end.get(Calendar.DAY_OF_WEEK); }
			 */

			return (int) days;
		} else
			return 0;

	}

	private int getPublicHolidaysBetweenDates(Date time, Date time2) {
		// TODO Auto-generated method stub
		return 0;
	}


	public double getActualEffortFromResources() {
		double effort = 0.0;

		for (DeliverableResource resource : this.getResources()) {
			effort += resource.getActualEffort();
		}
		return effort;
	}

	public double getScheduledEffortFromResources() {
		double effort = 0.0;

		for (DeliverableResource resource : this.getResources()) {
			effort += resource.getScheduledEffort();
		}
		return effort;
	}

	public double getActualDuration() {
		return actualDuration;
	}

	public void setActualDuration(int actualDuration) {
		this.actualDuration = actualDuration;
	}

	public void setActualDuration() {
		if (getActualStartDate() != null && getActualEndDate() != null)
			this.actualDuration = computeDuration(getActualStartDate(),
					DateUtil.endOfDay(getActualEndDate()));
		else if (getActualStartDate() != null && getProjectedEndDate() != null)
			this.actualDuration = computeDuration(getScheduledStartDate(),
					DateUtil.endOfDay(Calendar.getInstance().getTime()));
	}

	public double getProjectedCost() {
		return projectedCost;
	}

	public void setProjectedCost(double projectedCost) {
		this.projectedCost = projectedCost;
	}

	public double getProjectedDuration() {
		return projectedDuration;
	}

	public void setProjectedDuration(int projectedDuration) {
		this.projectedDuration = projectedDuration;
	}

	public void setProjectedDuration() {
		if (getActualStartDate() != null && getProjectedEndDate() != null)
			this.projectedDuration = computeDuration(getActualStartDate(),
					DateUtil.endOfDay(getProjectedEndDate()));
		else if (getScheduledStartDate() != null
				&& getProjectedEndDate() != null)
			this.projectedDuration = computeDuration(getScheduledStartDate(),
					DateUtil.endOfDay(getProjectedEndDate()));
	}

	public double getProjectedEffort() {
		return projectedEffort;
	}

	public void setProjectedEffort(double projectedEffort) {
		this.projectedEffort = projectedEffort;
	}

	public void setProjectedEffort() {
		double peff = 0;
		boolean isComplete = isActualEffortComplete();
		for (DeliverableResource resource : this.getResources()) {
			if (isComplete) {
				peff += resource.getProjectedEffort();
			} else {
				if (resource.getActualEffort() > 0)
					peff += resource.getActualEffort();
				else
					peff += resource.getProjectedEffort();
			}
		}
		setProjectedEffort(peff);
	}

	public boolean isActualEffortComplete() {
		int resCount = 0, effCount = 0;
		for (DeliverableResource resource : this.getResources()) {
			resCount++;
			if (resource.getActualEffort() > 0)
				effCount++;
		}
		if (resCount == effCount)
			return true;
		return false;
	}

	public double getScheduledDuration() {
		return scheduledDuration;
	}

	public void setScheduledDuration(int scheduledDuration) {
		this.scheduledDuration = scheduledDuration;
	}

	public void setScheduledDuration() {
		if (getScheduledStartDate() != null && getScheduledEndDate() != null)
			this.scheduledDuration = computeDuration(getScheduledStartDate(),
					DateUtil.endOfDay(getScheduledEndDate()));
	}

	public void setEfforts() {
		setScheduledEffort();
		setActualEffort();
		setProjectedEffort();
	}



}// class
