package ae.iemq.vims.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "project_project")

public class ProjectProject extends BaseEntity {

	@JoinColumn(name = "project", referencedColumnName = "id")
	@ManyToOne
	private Project project;	
	
	@JoinColumn(name = "associated_project", referencedColumnName = "id")
	@ManyToOne
	private Project associatedProject;
	
	public ProjectProject(Project project, Project associatedProject) {
		this.project = project;
		this.associatedProject = associatedProject;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MeetingAtendee";
	}



	public Project getAssociatedproject() {
		return associatedProject;
	}



	public void setAssociatedproject(Project associatedproject) {
		this.associatedProject = associatedproject;
	}



	public Project getProject() {
		return project;
	}



	public void setProject(Project project) {
		this.project = project;
	}


	

}
