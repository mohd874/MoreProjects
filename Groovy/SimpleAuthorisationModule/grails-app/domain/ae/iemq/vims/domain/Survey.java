package ae.iemq.vims.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SqlResultSetMappings( {
		@SqlResultSetMapping(name = "Survey.getAverageResponseByYear", columns = {
				@ColumnResult(name = "averageScore"),
				@ColumnResult(name = "year") }),
		@SqlResultSetMapping(name = "Survey.getAverageResponseByYearAndByUserID", columns = {
				@ColumnResult(name = "averageScore"),
				@ColumnResult(name = "year") }) })
@SuppressWarnings("serial")
@Entity
@Table(name = "survey")
@NamedQueries( {
		@NamedQuery(name = "Survey.survey", query = "from Survey order by createDateTime"),
		@NamedQuery(name = "Survey.surveyByName", query = "from Survey s where s.surveyName =:name order by createDateTime"),
		@NamedQuery(name = "Survey.scoredSurvey", query = "from Survey s where s.unique = :isUnique order by createDateTime")

})
public class Survey extends BaseEntity {

	public static final String DESC = new String("desc");

	public static final String SCORED = new String("scored");

	public Survey() {
	}

	@Column(name = "survey_name")
	private String surveyName;

	@Column(name = "survey_type")
	private String surveyType;

	@Column(name = "survey_description")
	private String surveyDescription;

	@Column(name = "unique_survey")
	private boolean unique;

	@OneToMany(mappedBy = "survey", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Set<Question> questions;

	public String getSurveyDescription() {
		return surveyDescription;
	}

	public void setSurveyDescription(String surveyDescription) {
		this.surveyDescription = surveyDescription;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public String getSurveyType() {
		return surveyType;
	}

	public void setSurveyType(String surveyType) {
		this.surveyType = surveyType;
	}

	@Override
	public String toString() {
		return surveyName;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public boolean isUnique() {
		return unique;
	}

	public void setUnique(boolean unique) {
		this.unique = unique;
	}
	/**
	 * Returns the survey total maximum score. 
	 * @return
	 */
	public int getTotalMaxScore() {
		int maxScore = 4;
		int totalMaxScore = 0;
		for (Question question : this.getQuestions()) {
			if (question.getSurvey().isUnique()) {
				
				for (ScoredAnswer answer : question.getAnswers()) {
					Integer upper = answer.getUpper();
					if (upper > maxScore)
						maxScore = upper;
				}
				totalMaxScore = totalMaxScore + maxScore * question.getWeighting();
				
			} else {
				
				 totalMaxScore = totalMaxScore +maxScore* question.getWeighting();
			}
		}
		return totalMaxScore;

	}
}