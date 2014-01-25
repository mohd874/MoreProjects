package ae.iemq.vims.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "employee_competency_rating")
@NamedQueries( { 
	
})
public class EmployeeCompetencyRating extends BaseEntity {

	@Embedded
	private Period period;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "rating", referencedColumnName = "id")
	@ManyToOne
	private IndividualRating ratingValue;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "employee_competency", referencedColumnName = "id")
	@ManyToOne
	private EmployeeCompetency employeeCompetency;
	
	@Override
	public String toString() {
		return employeeCompetency+" / "+period.startDate+" - "+period.endDate+" / "+ratingValue;
	}

	/**
	 * @return the employeeCompetency
	 */
	public EmployeeCompetency getEmployeeCompetency() {
		return employeeCompetency;
	}

	/**
	 * @param employeeCompetency the employeeCompetency to set
	 */
	public void setEmployeeCompetency(EmployeeCompetency employeeCompetency) {
		this.employeeCompetency = employeeCompetency;
	}
	
	/**
	 * @return the rating
	 */
	public IndividualRating getRatingValue() {
		return ratingValue;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRatingValue(IndividualRating rating) {
		this.ratingValue = rating;
	}

	/**
	 * @return the period
	 */
	public Period getPeriod() {
		return period;
	}

	/**
	 * @param period the period to set
	 */
	public void setPeriod(Period period) {
		this.period = period;
	}

}
