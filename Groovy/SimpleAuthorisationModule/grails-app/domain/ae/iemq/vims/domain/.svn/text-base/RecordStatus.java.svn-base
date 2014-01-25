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
@Table(name = "record_status")
@NamedQueries( { @NamedQuery(name = "RecordStatus.getActiveStatus", query = "from RecordStatus rs where rs.description = 'ACTIVE'"),
				 @NamedQuery(name = "RecordStatus.getPendingStatus", query = "from RecordStatus rs where rs.description = 'PENDING'"),
				 @NamedQuery(name = "RecordStatus.getArchiveStatus", query = "from RecordStatus rs where rs.description = 'ARCHIVE'")})
public class RecordStatus extends BaseEntity {

	public static String ACTIVE = "Active";
	
	@Column(name = "description")
	private String description;

	public RecordStatus(){
		setDescription(ACTIVE);
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
