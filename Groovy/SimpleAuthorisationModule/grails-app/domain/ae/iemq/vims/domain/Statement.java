package ae.iemq.vims.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "statement")
@NamedQueries ({
		@NamedQuery(name = "Statement.currentStatement", query = "from Statement where statementType = :statementType and archiveUser is null"),
		@NamedQuery(name = "Statement.archivedStatements", query = "from Statement where statementType = :statementType and archiveUser is not null order by createDateTime"),
		@NamedQuery(name = "Statement.AllStatements", query = "from Statement where archiveUser is null order by createDateTime")
})

public class Statement extends BaseEntity  {	
	@Column(name = "statement")
	private String statementText;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "statement_type", referencedColumnName = "id")
	@ManyToOne
	private StatementType statementType;
	

	public Statement() {
		// TODO Auto-generated constructor stub
	}
	
	public Statement(String text, StatementType type){
		this();
		setStatementText(text);
		setStatementType(type);
	}
	
	public Statement(String statementText) {
		this.statementText = statementText;
	}

	public String getStatementText() {
		return statementText;
	}

	public void setStatementText(String statement) {
		this.statementText = statement;
	}

	public StatementType getStatementType() {
		return statementType;
	}

	public void setStatementType(StatementType statementType) {
		this.statementType = statementType;
	}

	@Override
	public String toString() {
		return statementText;
	}	
}
