package ae.iemq.vims.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "employee_competency")
@NamedQueries( { 
	
})
public class EmployeeCompetency extends BaseEntity {

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "competency", referencedColumnName = "id")
	@ManyToOne
	private Competency competency;

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "employee", referencedColumnName = "id")
	@ManyToOne
	private Employee employee;

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy = "employeeCompetency")
	private Set<EmployeeCompetencyRating> ratings;

	@Column(name = "weight")
	private Double weight;

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return employee + " <- " + competency;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Competency getCompetency() {
		return competency;
	}

	public void setCompetency(Competency competency) {
		this.competency = competency;
	}

	/**
	 * @return the ratings
	 */
	public Set<EmployeeCompetencyRating> getRatings() {
		return ratings;
	}

	/**
	 * @param ratings the ratings to set
	 */
	public void setRatings(Set<EmployeeCompetencyRating> ratings) {
		this.ratings = ratings;
	}
	
	public EmployeeCompetencyRating getRatingInPeriod(Period period) {
		for (EmployeeCompetencyRating rating : ratings) {
			if (rating.getPeriod().equals(period))
				return rating;
		}
		
		return new EmployeeCompetencyRating();
	}
	
	
}
