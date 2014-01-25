package ae.iemq.vims.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Generated;

//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "setting")
@NamedQueries( {
		@NamedQuery(name = "Setting.allSettings", query = "from Setting order by id"),
		@NamedQuery(name = "Setting.settingPropertyIs", query = "from Setting e where e.property is :property")})
public class Setting extends BaseEntity {

	
	@Column(name = "property")
	private String property;

	@Column(name = "value")
	private String value;




	public String getProperty() {
		return property;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String name) {
		this.value = name;
	}
	
	public void setProperty(String name) {
		this.property = name;
	}



	

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return property;
	}




}
