package ae.iemq.vims.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "deliverable_resource")
@NamedQueries( {
	

})
public class DeliverableResource extends BaseEntity {

	
	@Column(name = "scheduled_cost")
	private double scheduledCost;

	@Column(name = "actual_cost")
	private double actualCost;

	@Column(name = "actual_effort")
	private double actualEffort;

	@Column(name = "scheduled_effort")
	private double scheduledEffort;

	@Column(name = "projected_effort")
	private double projectedEffort;
	
	@JoinColumn(name = "deliverable", referencedColumnName = "id")
	@ManyToOne
	private Deliverable deliverable;	
	
	@JoinColumn(name = "resource", referencedColumnName = "id")
	@ManyToOne
	private Employee resource;
	
	


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	public Deliverable getDeliverable() {
		return deliverable;
	}

	public void setDeliverable(Deliverable deliverable) {
		this.deliverable = deliverable;
	}

	public Employee getResource() {
		return resource;
	}

	public void setResource(Employee resource) {
		this.resource = resource;
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
		//getDeliverable().setEfforts();
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
		if (getDeliverable()==null)
			System.out.println("DELIVERABLE IS------------>null");
		//getDeliverable().setScheduledEffort();
	}

	public double getProjectedEffort() {
		return projectedEffort;
	}

	public void setProjectedEffort(double projectedEffort) {
		this.projectedEffort = projectedEffort;
		//getDeliverable().setEfforts();
	}

	
}
