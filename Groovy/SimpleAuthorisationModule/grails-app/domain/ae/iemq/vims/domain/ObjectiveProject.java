package ae.iemq.vims.domain;

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
@Table(name = "objective_project")
@NamedQueries( {
	
})
public class ObjectiveProject extends BaseEntity{

	
	@JoinColumn(name = "objective", referencedColumnName = "id")
	@ManyToOne
	private Objective objective;	
	
	@JoinColumn(name = "project", referencedColumnName = "id")
	@ManyToOne
	private Project project;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ObjectiveProject(Objective objective, Project project) {
		this.objective = objective;
		this.project = project;
	}
	public Objective getObjective() {
		return objective;
	}
	public void setObjective(Objective objective) {
		this.objective = objective;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}

}
