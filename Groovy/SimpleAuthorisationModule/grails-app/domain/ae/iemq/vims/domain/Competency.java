package ae.iemq.vims.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "competency")
@NamedQueries({
	@NamedQuery(name = "Competency.allCompetencys", query = "from Competency")
})
public class Competency extends BaseEntity {

	@Column(name = "description")
	private String description;
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return description;
	}

}
