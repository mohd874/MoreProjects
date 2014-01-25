package ae.iemq.vims.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@SuppressWarnings("serial")
@Entity
@Table(name = "statement_type")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NamedQueries({
	@NamedQuery(name = "StatementType.statementTypes", query = "select distinct st from StatementType st left join fetch st.statements")	
})
public class StatementType extends BaseEntity {
		
	@Column(name = "description", nullable = false)
	private String description;
	
	public StatementType() {
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToMany(mappedBy = "statementType", cascade=CascadeType.PERSIST)
	private Set<Statement> statements;


	public Set<Statement> getStatements() {
		return statements;
	}

	public void setStatements(Set<Statement> statements) {
		this.statements = statements;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return description;
	}		
}
