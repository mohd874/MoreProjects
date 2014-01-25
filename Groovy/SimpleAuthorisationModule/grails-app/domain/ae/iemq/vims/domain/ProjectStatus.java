package ae.iemq.vims.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "project_status")
@NamedQueries( {

})
public class ProjectStatus  extends BaseEntity {

	
	@JoinColumn(name = "project", referencedColumnName = "id")
	@ManyToOne
	private Project project;
	
	@Column(name = "comments")
	private String comments;
	
	
	@Column(name = "justification")
	private String justification;
	
	@Column(name = "events")
	private String events;
	
	@Column(name = "recommendation")
	private String recommendation;
	
	@Column(name = "period_cost")
	private double periodCost;
	
	@Column(name = "period_effort")
	private double periodEffort;
	
	
	
	@Column(name = "planned_cost_per_period")
	private double plannedCostPerPeriod;
	
	@Column(name = "planned_effort_per_period")
	private double plannedEffortPerPeriod;
	
	@Column(name = "planned_duration_per_period")
	private int plannedDurationPerPeriod;
	
	@Column(name = "period_duration")
	private long periodDuration;
	
	@Column(name = "costKPI")
	private String costKPI;
	
	@Column(name = "effortKPI")
	private String effortKPI;
	
	@Column(name = "durationKPI")
	private String durationKPI;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getEvents() {
		return events;
	}
	public void setEvents(String events) {
		this.events = events;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public String getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
	public String getCostKPI() {
		return costKPI;
	}
	public void setCostKPI(String costKPI) {
		this.costKPI = costKPI;
	}
	public String getDurationKPI() {
		return durationKPI;
	}
	public void setDurationKPI(String durationKPI) {
		this.durationKPI = durationKPI;
	}
	public String getEffortKPI() {
		return effortKPI;
	}
	public void setEffortKPI(String effortKPI) {
		this.effortKPI = effortKPI;
	}
	public long getPeriodDuration() {
		return periodDuration;
	}
	public void setPeriodDuration(long periodDuration) {
		this.periodDuration = periodDuration;
	}
	
	public double getPeriodEffort() {
		return periodEffort;
	}
	public void setPeriodEffort(double periodEffort) {
		this.periodEffort = periodEffort;
	}
	public double getPeriodCost() {
		return periodCost;
	}
	public void setPeriodCost(double periodCost) {
		this.periodCost = periodCost;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public double getPlannedCostPerPeriod() {
		return plannedCostPerPeriod;
	}
	public void setPlannedCostPerPeriod(double plannedCostPerPeriod) {
		this.plannedCostPerPeriod = plannedCostPerPeriod;
	}
	
	public double getPlannedEffortPerPeriod() {
		return plannedEffortPerPeriod;
	}
	public void setPlannedEffortPerPeriod(double plannedEffortPerPeriod) {
		this.plannedEffortPerPeriod = plannedEffortPerPeriod;
	}
	public int getPlannedDurationPerPeriod() {
		return plannedDurationPerPeriod;
	}
	public void setPlannedDurationPerPeriod(int plannedDurationPerPeriod) {
		this.plannedDurationPerPeriod = plannedDurationPerPeriod;
	}
	


	

}
