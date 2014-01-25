package ae.iemq.vims.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


/**
 * Public Holidays Dates. Fixed set to 1 indicates the date is recursive throughout the years
 * set to 0 indicates the holiday is valid only on the specified year
 */
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@SqlResultSetMappings( {
	@SqlResultSetMapping(name = "PublicHolidays.getHolidaysBetweenDates", columns = {
			@ColumnResult(name = "totalHolidays")  })
})

@NamedQueries( {@NamedQuery(name = "PublicHolidays.allHolidays", query = "from PublicHolidays"),
	@NamedQuery(name = "PublicHolidays.fixed", query = "from PublicHolidays where fixed=1"),
	@NamedQuery(name = "PublicHolidays.notFixed", query = "from PublicHolidays where fixed=0")
})

@Table(name = "public_holidays")
public class PublicHolidays extends BaseEntity {

	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	private Date date;		
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "fixed")
	private boolean fixed;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return date.toString()+" - "+description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isFixed() {
		return fixed;
	}

	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}



	
}
