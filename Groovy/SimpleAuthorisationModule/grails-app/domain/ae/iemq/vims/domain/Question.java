package ae.iemq.vims.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import ae.iemq.vims.util.DateUtil;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "survey_question")
@NamedQueries({
	@NamedQuery(name = "Question.questions", query = "from Question")
})
public class Question extends BaseEntity  {
	
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "survey", referencedColumnName = "id")
	@ManyToOne
	private Survey survey;
	
	
	
	
	@Column(name = "weighting")
	private int weighting;
	
	@Column(name = "question")
	private String questionText;	
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
	@OrderBy("lower")
	private Set<ScoredAnswer> answers;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy("score")
	private Set<DescAnswer> descAnswers;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy = "question", fetch = FetchType.LAZY)	
	@OrderBy("question")
	private Set<SurveyResponse> responses;
	
	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public  Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public Set<ScoredAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<ScoredAnswer> answers) {
		this.answers = answers;
	}
	

	

	public int getWeighting() {
		return weighting;
	}

	public void setWeighting(int weighting) {
		this.weighting = weighting;
	}

	@Override
	public String toString() {
		return questionText;
	}

	public Set<SurveyResponse> getResponses() {
		return responses;
	}

	public void setResponses(Set<SurveyResponse> responses) {
		this.responses = responses;
	}
	/**
	 * This calculates the maximum score for each question
	 * For unique surveys such as self assessment surveys
	 * The max score is calculated by finding the upper score from the scoredAnswer
	 * class and the multiplying this by the question's weight. 
	 * 
	 * Normal stakeholder surveys have a max score of 4 but have different weighting.
	 * @return maxScore*weighting
	 */
	public int getMaxScore() {
		int maxScore = 4;
		
		if(this.getSurvey().isUnique())
		{
			System.out.println(this.getSurvey().isUnique());
		for (ScoredAnswer answer : answers) {
			Integer upper = answer.getUpper();
			if (upper > maxScore)
				maxScore = upper;
		}
	
		return maxScore*weighting;
		}
		else
		{
			
		
			return maxScore*weighting ;
		}
	}
	
	/**
	 * Finds the average score of each question taken by all users
	 * for the previous years.
	 * @return total / size;
	 */
	public float getAverageResponse() {
		float total = 0;
		int size = 0;
		DateUtil dateUtil = new DateUtil();
		for (SurveyResponse response : responses)
		{
			Calendar cal = Calendar.getInstance();
			cal.setTime(response.getCreateDateTime());
			int responseCreationYear = cal.get(Calendar.YEAR);
			Date now = new Date();
			cal.setTime(now);
			int currentYear = cal.get(Calendar.YEAR);
			if(responseCreationYear <=currentYear )//modified testing
			{
				System.out.println(responseCreationYear);
				total += response.getScore();
				size++;
			}
			
		}
		
		if (size==0)
			return 0;
		return total / size;
	}
	
	/**
	 * Finds the average score of each question taken by all users
	 * for the previous years.
	 * @return total / size;
	 */
	public int getIntAverageResponse()  {
		float total = 0;
		int size = 0;
		DateUtil dateUtil = new DateUtil();
		System.out.println("GETTING RESPONSES");
		for (SurveyResponse response : responses)
		{
			Calendar cal = Calendar.getInstance();
			cal.setTime(response.getCreateDateTime());
			int responseCreationYear = cal.get(Calendar.YEAR);
			System.out.println("YEAR FOR RESPONSE IS-----> "+responseCreationYear);
			Date now = new Date();
			cal.setTime(now);
			int currentYear = cal.get(Calendar.YEAR);
			/*GET AVERAGES FROM CURRENT YEAR BACK*/
			if(responseCreationYear <= currentYear )
			{
				System.out.println(responseCreationYear);
				total += response.getScore();
				size++;
			}
			
		}
		
		
		return (int) (total / size);
	}
	
	public Set<DescAnswer> getDescAnswers() {
		return descAnswers;
	}

	public void setDescAnswers(Set<DescAnswer> descAnswers) {
		this.descAnswers = descAnswers;
	}
	
	
}
