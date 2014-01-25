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
@Table(name = "survey_scored_answer")
@NamedQueries({
	@NamedQuery(name = "ScoredAnswer.survey_scored_answer", query = "from ScoredAnswer")
})
public class ScoredAnswer extends BaseEntity  {

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "survey_question", referencedColumnName = "id")
	@ManyToOne
	private Question question;
	
	@Column(name = "lower")
	private Integer lower;
	
	@Column(name = "upper")
	private Integer upper;
	
	@Column(name = "range_description")
	private String rangeDescription;	
	
	
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getRangeDescription() {
		return rangeDescription;
	}

	public void setRangeDescription(String rangeDescription) {
		this.rangeDescription = rangeDescription;
	}

	public Integer getLower() {
		return lower;
	}

	public void setLower(Integer lower) {
		this.lower = lower;
	}

	public Integer getUpper() {
		return upper;
	}

	public void setUpper(Integer upper) {
		this.upper = upper;
	}

	@Override
	public String toString() {
		return rangeDescription + "(" + lower + " - " + upper;
	}


}
