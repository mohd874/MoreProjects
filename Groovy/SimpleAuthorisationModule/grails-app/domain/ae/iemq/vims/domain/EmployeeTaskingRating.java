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
@Table(name = "employee_tasking_rating")
@NamedQueries( { 
	
})
public class EmployeeTaskingRating extends BaseEntity {

	@Embedded
	private Period period;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "rating", referencedColumnName = "id")
	@ManyToOne
	private IndividualRating ratingValue;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "employee_tasking", referencedColumnName = "id")
	@ManyToOne
	private EmployeeTasking employeeTasking;
	
	@Override
	public String toString() {
		return employeeTasking+" / "+period.startDate+" - "+period.endDate+" / "+ratingValue;
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
	 * @return the tasking
	 */
	public EmployeeTasking getEmployeeTasking() {
		return employeeTasking;
	}

	/**
	 * @param tasking the tasking to set
	 */
	public void setEmployeeTasking(EmployeeTasking tasking) {
		this.employeeTasking = tasking;
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
