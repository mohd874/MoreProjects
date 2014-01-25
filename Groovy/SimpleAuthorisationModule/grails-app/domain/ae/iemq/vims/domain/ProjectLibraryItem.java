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
@Table(name = "project_library_item")
@NamedQueries( {
	@NamedQuery(name = "ProjectLibraryItem.projectLibraryItem", query = "from ProjectLibraryItem order by description"),
	@NamedQuery(name = "ProjectLibraryItem.byFolder", query = "from ProjectLibraryItem p where p.folder =  :folder and p.project = :project order by subperiod")	
})
public class ProjectLibraryItem extends BaseEntity {
		
	@Column(name = "description")
	private String description;
	
	@Column(name = "binary_resource")
	private byte[] binaryResource;	
	
	@JoinColumn(name = "project_library_folder", referencedColumnName = "id")
	@ManyToOne
	private ProjectLibraryFolder folder;
	
	@JoinColumn(name = "project", referencedColumnName = "id")
	@ManyToOne
	private Project project;

	//subperiod "100" for ProjectProposal, "400" for CloseOutReport
	@Column(name = "item_subperiod")
	private int subperiod;	
	
	//year "0" will be assigned to items not belonging to project plan or Status Report.
	@Column(name = "item_year")
	private int year;	
	
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
	 * @return the folder
	 */
	public ProjectLibraryFolder getFolder() {
		return folder;
	}

	/**
	 * @param folder the folder to set
	 */
	public void setFolder(ProjectLibraryFolder folder) {
		this.folder = folder;
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public int getSubperiod() {
		return subperiod;
	}

	public void setSubperiod(int subperiod) {
		this.subperiod = subperiod;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
}

