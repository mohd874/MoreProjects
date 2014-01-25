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

import ae.iemq.vims.domain.balancedScorecard.Measure;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "measure_library_item")
@NamedQueries( {
	@NamedQuery(name = "MeasureLibraryItem.measureLibraryItem", query = "from MeasureLibraryItem order by description"),
	@NamedQuery(name = "MeasureLibraryItem.measureItems", query = "from MeasureLibraryItem where measure is :measureId")
})
public class MeasureLibraryItem extends BaseEntity {
		
	@Column(name = "description")
	private String description;
	
	@Column(name = "binary_resource")
	private byte[] binaryResource;	
	
	@JoinColumn(name = "measure", referencedColumnName = "id")
	@ManyToOne
	private Measure measure;

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description.replace(" ", "_");//Replace spaces with underscores for Firefox/Opera compatibility
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the folder
	 */
	public Measure getMeasure() {
		return measure;
	}

	/**
	 * @param folder the folder to set
	 */
	public void setMeasure(Measure measure) {
		this.measure  = measure;
	}

	@Override
	public String toString() {
		return description;
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
	
}

