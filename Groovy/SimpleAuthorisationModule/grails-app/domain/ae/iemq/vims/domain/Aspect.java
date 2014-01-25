package ae.iemq.vims.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Objectives are monitored by means of aspects.  To date the four aspects that have been
 * identified are Risk, Process, Business Plan, Performance Measurement.  These aspects
 * each have a corresponsding "module" in Vims.  
 *
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "aspect")
@NamedQueries( {

})
public class Aspect extends BaseEntity  {

	/**
	 * The status of an aspect may take on one of the following values.  The value
	 * WHITE indicates that the status of the aspect is unknown.
	 *
	 */
	public static enum Status { WHITE, GREEN, YELLOW, RED }
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@Override
	public String toString() {
		return "("+code+") "+name;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
