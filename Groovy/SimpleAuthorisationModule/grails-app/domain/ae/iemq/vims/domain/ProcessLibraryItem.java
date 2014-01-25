package ae.iemq.vims.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import ae.iemq.vims.domain.developprocess.Process;
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "process_library_item")
public class ProcessLibraryItem extends BaseEntity{

	@Column(name = "description")
	private String description;
	
	@Column(name = "binary_resource")
	private byte[] binaryResource;	
	
	@JoinColumn(name = "process", referencedColumnName = "id")
	@ManyToOne
	private Process process;
	
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

	/**
	 * @return the process
	 */
	public Process getProcess() {
		return process;
	}

	/**
	 * @param process the process to set
	 */
	public void setProcess(Process process) {
		this.process = process;
	}

}
