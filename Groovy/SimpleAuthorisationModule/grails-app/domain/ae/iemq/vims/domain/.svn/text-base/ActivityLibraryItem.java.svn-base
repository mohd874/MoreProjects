package ae.iemq.vims.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "activity_library_item")
@NamedQueries( {
	@NamedQuery(name = "ActivityLibraryItem.activityLibraryItem", query = "from ActivityLibraryItem order by description"),
	@NamedQuery(name = "ActivityLibraryItem.activityItems", query = "from ActivityLibraryItem where activity is :activityId")
})
public class ActivityLibraryItem extends BaseEntity {

	@Column(name = "description")
	private String description;
	
	@Column(name = "binary_resource")
	private byte[] binaryResource;	
	
	@JoinColumn(name = "activity", referencedColumnName = "id")
	@ManyToOne
	private Activity activity;

	@Override
	public String toString() {
		return description;
	}

	/**
	 * @return the activity
	 */
	public Activity getActivity() {
		return activity;
	}

	/**
	 * @param activity the activity to set
	 */
	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	/**
	 * @return the binaryResource
	 */
	public byte[] getBinaryResource() {
		return binaryResource;
	}

	/**
	 * @param binaryResource the binaryResource to set
	 */
	public void setBinaryResource(byte[] binaryResource) {
		this.binaryResource = binaryResource;
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

}
