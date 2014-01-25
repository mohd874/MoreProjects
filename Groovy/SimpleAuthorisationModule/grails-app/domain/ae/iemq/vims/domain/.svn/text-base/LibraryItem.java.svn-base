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
import ae.iemq.vims.domain.developprocess.Process;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "library_item")

@NamedQueries( {
	@NamedQuery(name = "LibraryItem.LibraryItem", query = "from LibraryItem order by description"),
	@NamedQuery(name = "LibraryItem.ProjectLibraryItemByFolder", query = "from LibraryItem p where p.folder =  :folder and p.project = :project order by subperiod")	
})
public class LibraryItem extends BaseEntity {

	@Column(name = "description")
	private String description;
	
	@Column(name = "binary_resource")
	private byte[] binaryResource;	
	
	@JoinColumn(name = "library_folder", referencedColumnName = "id")
	@ManyToOne
	private LibraryFolder folder;
	
	@JoinColumn(name = "project", referencedColumnName = "id")
	@ManyToOne
	private Project project;

	@JoinColumn(name = "measure", referencedColumnName = "id")
	@ManyToOne
	private Measure measure;

	@JoinColumn(name = "activity", referencedColumnName = "id")
	@ManyToOne
	private Activity activity;

	@JoinColumn(name = "risk", referencedColumnName = "id")
	@ManyToOne
	private Risk risk;

	@JoinColumn(name = "process", referencedColumnName = "id")
	@ManyToOne
	private Process process;

	//subperiod "100" for ProjectProposal, "400" for CloseOutReport, "500" for Others (Deafult)
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
	 * @return the folder
	 */
	public LibraryFolder getFolder() {
		return folder;
	}

	/**
	 * @param folder the folder to set
	 */
	public void setFolder(LibraryFolder folder) {
		this.folder = folder;
	}

	/**
	 * @return the measure
	 */
	public Measure getMeasure() {
		return measure;
	}

	/**
	 * @param measure the measure to set
	 */
	public void setMeasure(Measure measure) {
		this.measure = measure;
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

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * @return the risk
	 */
	public Risk getRisk() {
		return risk;
	}

	/**
	 * @param risk the risk to set
	 */
	public void setRisk(Risk risk) {
		this.risk = risk;
	}

	/**
	 * @return the subperiod
	 */
	public int getSubperiod() {
		return subperiod;
	}

	/**
	 * @param subperiod the subperiod to set
	 */
	public void setSubperiod(int subperiod) {
		this.subperiod = subperiod;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
