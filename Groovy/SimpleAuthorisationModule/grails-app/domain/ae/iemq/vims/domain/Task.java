package ae.iemq.vims.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "task")
@NamedQueries({
	@NamedQuery(name = "Task.allTasks", query = "from Task")
})
public class Task extends BaseEntity {

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "task_category", referencedColumnName = "id")
	@ManyToOne
	private TaskCategory category;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	private Set<EmployeeTasking> taskings;
	
	@Column(name = "description")
	private String description;
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return description;
	}

	public TaskCategory getCategory() {
		return category;
	}

	public void setCategory(TaskCategory category) {
		this.category = category;
	}

	public Set<EmployeeTasking> getTaskings() {
		return taskings;
	}

	public void setTaskings(Set<EmployeeTasking> taskings) {
		this.taskings = taskings;
	}

}
