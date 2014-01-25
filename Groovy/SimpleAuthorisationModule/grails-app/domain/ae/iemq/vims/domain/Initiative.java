package ae.iemq.vims.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import ae.iemq.vims.domain.balancedScorecard.Measure;
import ae.iemq.vims.domain.developprocess.Process;

@SuppressWarnings("serial")
@Entity
@Table(name = "initiative")
@NamedQueries( {

})
public class Initiative extends BaseEntity {

	@Column(name = "description")
	private String description;
	
	@Column(name = "status")
	private String status;

	@JoinColumn(name = "risk", referencedColumnName = "id")
	@ManyToOne
	private Risk risk;

	@JoinColumn(name = "activity", referencedColumnName = "id")
	@ManyToOne
	private Activity activity;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "owner", referencedColumnName = "id")
	@ManyToOne
	private Employee owner;

	@JoinColumn(name = "measure", referencedColumnName = "id")
	@ManyToOne
	private Measure measure;
	
	@JoinColumn(name = "project", referencedColumnName = "id")
	@ManyToOne
	private Project project;
	
	@JoinColumn(name = "process", referencedColumnName = "id")
	@ManyToOne
	private Process process;
	
	@Column(name = "due_date")
	@Temporal(TemporalType.DATE)
	private Date dueDate;
	
	@Override
	public String toString() {
		return description;
	}

	public Employee getOwner() {
		return owner;
	}

	public void setOwner(Employee owner) {
		this.owner = owner;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Risk getRisk() {
		return risk;
	}

	public void setRisk(Risk risk) {
		this.risk = risk;
	}

	public Measure getMeasure() {
		return measure;
	}

	public void setMeasure(Measure measure) {
		this.measure = measure;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
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
