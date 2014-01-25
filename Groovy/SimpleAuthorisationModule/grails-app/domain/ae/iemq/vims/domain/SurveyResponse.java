package ae.iemq.vims.domain;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

@SuppressWarnings("serial")
@Entity
@Table(name = "survey_response")
@NamedQueries({

	@NamedQuery(name = "SurveyRepsonse.score", query = "from SurveyResponse s where s.createUser = :user order by createDateTime")
})
public class SurveyResponse extends BaseEntity  {

	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "survey_question", referencedColumnName = "id")
	@ManyToOne
	private Question question;
	
	@Column(name = "score")
	private Integer score;
	
	
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}


	
	
	
	
	
	
	
}