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
@Table(name = "survey_desc_answer")
@NamedQueries({
	
})
public class DescAnswer extends BaseEntity{

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "question", referencedColumnName = "id")
	@ManyToOne
	private Question question;
	
	@Column(name = "score")
	private int score;
	
	@Column(name = "description")
	private String description;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
