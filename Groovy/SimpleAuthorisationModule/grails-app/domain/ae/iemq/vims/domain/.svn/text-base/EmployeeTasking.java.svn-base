package ae.iemq.vims.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "employee_tasking")
@NamedQueries( {
	@NamedQuery(name = "EmployeeTasking.taskingsByCategory", query = "select distinct cat from " +
			"TaskCategory cat join fetch cat.tasks task join fetch task.taskings tasking left join fetch " +
			"tasking.ratings ratings left join fetch ratings.ratingValue where tasking.employee = :employee")
})
public class EmployeeTasking extends BaseEntity {

	@Column(name = "targeted_date")
	@Temporal(TemporalType.DATE)
	private Date targetedDate;

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "task", referencedColumnName = "id")
	@ManyToOne
	private Task task;

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "employee", referencedColumnName = "id")
	@ManyToOne
	private Employee employee;

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)	
	@OneToMany(mappedBy = "employeeTasking")
	private Set<EmployeeTaskingRating> ratings;

	@Column(name = "weight")
	private Double weight;

	@Column(name = "status")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return employee + " <- " + task;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Date getTargetedDate() {
		return targetedDate;
	}

	public void setTargetedDate(Date targetedDate) {
		this.targetedDate = targetedDate;
	}

	/**
	 * @return the ratings
	 */
	public Set<EmployeeTaskingRating> getRatings() {
		return ratings;
	}

	/**
	 * @param ratings the ratings to set
	 */
	public void setRatings(Set<EmployeeTaskingRating> ratings) {
		this.ratings = ratings;
	}

	
}
