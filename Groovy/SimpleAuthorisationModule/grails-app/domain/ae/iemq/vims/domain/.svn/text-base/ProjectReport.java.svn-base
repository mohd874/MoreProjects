package ae.iemq.vims.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.FilterJoinTable;
import org.hibernate.annotations.Where;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)


@SuppressWarnings("serial")
@Entity
@Table(name = "project_report")
@NamedQueries( {
	
})
public class ProjectReport extends BaseEntity {

	
	
	@Column(name = "feedback")
	private String feedback;
	
	@Column(name = "limits")
	private String limits;
	
	@Column(name = "conclusion")
	private String conclusion;
	
	
	@JoinColumn(name = "project", referencedColumnName = "id")
	@OneToOne
	private Project project;

	@Override
	public String toString() {
		return "Final Report";
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getLimits() {
		return limits;
	}

	public void setLimits(String limits) {
		this.limits = limits;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}
	

	
	
	

	
	


	
	
	
	
	


}
