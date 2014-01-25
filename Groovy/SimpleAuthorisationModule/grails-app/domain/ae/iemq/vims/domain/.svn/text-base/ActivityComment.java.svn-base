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
@Table(name = "activity_comment")
@NamedQueries( {
	@NamedQuery(name = "ActivityComment.activityComments", query = "from ActivityComment order by createDateTime desc"),
	@NamedQuery(name = "ActivityComment.activityCommentsByActivity", query = "from ActivityComment where activity is :activityId order by createDateTime desc")
})
public class ActivityComment extends BaseEntity {

	@Column(name = "activity_comment")
	private String activityComment;
	
	@JoinColumn(name = "activity", referencedColumnName = "id")
	@ManyToOne
	private Activity activity;
	
	/**
	 * @return the activity
	 */
	public Activity getActivity() {
		return activity;
	}

	/**
	 * @param activity the activity to set
	 */
	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	/**
	 * @return the activityComment
	 */
	public String getActivityComment() {
		return activityComment;
	}

	/**
	 * @param activityComment the activityComment to set
	 */
	public void setActivityComment(String activityComment) {
		this.activityComment = activityComment;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
