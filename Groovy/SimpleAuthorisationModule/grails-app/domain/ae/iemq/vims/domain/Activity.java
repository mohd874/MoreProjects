package ae.iemq.vims.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Where;
import org.hibernate.annotations.WhereJoinTable;

import ae.iemq.vims.domain.Aspect.Status;
import ae.iemq.vims.util.BaseEntityCreateDateComparetor;
import ae.iemq.vims.util.WeightUtil;
import ae.iemq.vims.util.WeightUtil.Weight;

/**
 * Activities are managed on a per-objective basis in the "Business Plan"
 * module.
 * 
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "activity")
@SqlResultSetMapping(name = "Activity.completionByPeriod", columns = {
		@ColumnResult(name = "count"), @ColumnResult(name = "period") })
@NamedQueries(  {@NamedQuery(name = "Activity.getActivityById", query = "from Activity act where act.id = :id"),
			     @NamedQuery(name = "Activity.getActivitiesForObjective", query = "from Activity act where act.objective = :obj")})
public class Activity extends BaseEntity {

//	public static enum Priority {
//		ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9),TEN(10);
//		
//		private final int value;
//		Priority(int value){
//			this.value = value;
//		}
//		public int getValue(){
//			return this.value;
//		}
//		/**
//		 * return int[] representing the Priority enum
//		 */
//		public int[] getIntValues(){
//			int [] values = new int[Priority.values().length];
//			Priority[] enumValues = Priority.values();
//			for(int i=0;i<enumValues.length;i++){
//				values[i] = enumValues[i].getValue();
//			}
//			return values;
//		}
//		/**
//		 * Convert the value into Priority enum
//		 * @param priority
//		 */
//		public Priority getPriorityFromValue(int value){
//			Priority[] enumValues = Priority.values();
//			for(int i=0;i<enumValues.length;i++){
//				if(enumValues[i].getValue() == value){
//					return enumValues[i];
//				}
//			}
//			return null;
//		}
//	}

	/**
	 * @return the archiveInitiatives
	 */
	public Set<Initiative> getArchiveInitiatives() {
		return archiveInitiatives;
	}

	/**
	 * @param archiveInitiatives the archiveInitiatives to set
	 */
	public void setArchiveInitiatives(Set<Initiative> archiveInitiatives) {
		this.archiveInitiatives = archiveInitiatives;
	}

	public Activity() {
		setPeriod(new Period());
		setActualPeriod(new Period());
		impact = true;
		setComments(new HashSet<Comment>());
		setActiveComments(new HashSet<Comment>());
		setArchiveComments(new HashSet<Comment>());
		setInitiatives(new HashSet<Initiative>());
		setPriority(WeightUtil.Weight.FIVE);
	}

	@Column(name = "name")
	private String name;

	// @Column(name = "comments")
	// private String comments;

	@Embedded
	@AttributeOverrides( {
			@AttributeOverride(name = "startDate", column = @Column(name = "actual_start_date")),
			@AttributeOverride(name = "endDate", column = @Column(name = "actual_end_date")) })
	private Period actualPeriod;

	@Column(name = "priority")
	@Enumerated(EnumType.STRING)
	private Weight priority;

	@Embedded
	private Period period;

	@JoinColumn(name = "owner", referencedColumnName = "id")
	@ManyToOne
	private Employee owner;

	@JoinColumn(name = "accountability", referencedColumnName = "id")
	@ManyToOne
	private OrgUnit accountability;

	@JoinColumn(name = "objective", referencedColumnName = "id")
	@ManyToOne
	private Objective objective;

	@Column(name = "impact")
	private boolean impact;

	@OneToMany(mappedBy = "activity", fetch = FetchType.LAZY)
	@Cascade({org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	private Set<LibraryItem> libraryItems;

//	@OneToMany(mappedBy = "activity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<ActivityLibraryItem> libraryItems;

	@OneToMany(mappedBy = "activity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ActivityComment> activityComments;

	@OneToMany(mappedBy = "activity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Initiative> initiatives;
	
	@OneToMany(mappedBy = "activity", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@Where(clause="record_status='Active'") 
	private Set<Initiative> activeInitiatives;

	@OneToMany(mappedBy = "activity", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@Where(clause="record_status='Archive'") 
	private Set<Initiative> archiveInitiatives;

	@OneToMany(mappedBy = "activity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy(clause="create_dt desc")
	private Set<Comment> comments;

	@OneToMany(mappedBy = "activity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Where(clause="record_status='Active'")
	private Set<Comment> activeComments;
	
	@OneToMany(mappedBy = "activity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Where(clause="record_status='Archive'")
	private Set<Comment> archiveComments;
	
	/**
	 * @return the accountability
	 */
	public OrgUnit getAccountability() {
		return accountability;
	}

	/**
	 * @param accountability
	 *            the accountability to set
	 */
	public void setAccountability(OrgUnit accountability) {
		this.accountability = accountability;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the objective
	 */
	public Objective getObjective() {
		return objective;
	}

	/**
	 * @param objective
	 *            the objective to set
	 */
	public void setObjective(Objective objective) {
		this.objective = objective;
	}

	/**
	 * @return the owner
	 */
	public Employee getOwner() {
		return owner;
	}

	/**
	 * @param owner
	 *            the owner to set
	 */
	public void setOwner(Employee owner) {
		this.owner = owner;
	}

	/**
	 * @return the priority
	 */
	public Weight getPriority() {
		return priority;
	}

	/**
	 * @param priority
	 *            the priority to set
	 */
	public void setPriority(Weight priority) {
		this.priority = priority;
	}

	/**Covert the integer to Priority enum. Priority will be null incase that the integer in not defined
	 * @param priority
	 *            the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = Weight.ONE.getWeightFromValue(priority);
	}

	@Override
	public String toString() {
		return name;
	}

	// public String getComments() {
	// return comments;
	// }
	//
	// public void setComments(String comments) {
	// this.comments = comments;
	// }

	/**
	 * The status of an activity is determined by whether or not it is known to
	 * have run past its planned end date.
	 * 
	 * @return the status
	 */
	public Status computeStatus() {
		if (!isImpact()) {
			return Status.GREEN;
		}
		if (getActualPeriod().endDate != null) {
			if (getActualPeriod().endDate.after(period.endDate)) {
				return Status.RED;
			} else {
				return Status.GREEN;
			}
		} else {
			Date currentDate = new Date();

			if (currentDate.after(period.endDate)) {
				return Status.RED;
			} else {
				if (getActualPeriod().startDate != null) {
					if (getActualPeriod().startDate.after(period.startDate)) {
						return Status.RED;
					} else {
						return Status.GREEN;
					}
				} else {
					if (currentDate.after(period.startDate)) {
						return Status.RED;
					}
				}
			}
		}
		return Status.WHITE;
	}

	/**
	 * @return the period
	 */
	public Period getPeriod() {
		return period != null ? period : (period = new Period());
	}

	/**
	 * @param period
	 *            the period to set
	 */
	public void setPeriod(Period period) {
		this.period = period;
	}

	/**
	 * @return the actualPeriod
	 */
	public Period getActualPeriod() {
		return actualPeriod != null ? actualPeriod
				: (actualPeriod = new Period());
	}

	/**
	 * @param actualPeriod
	 *            the actualPeriod to set
	 */
	public void setActualPeriod(Period actualPeriod) {
		this.actualPeriod = actualPeriod;
	}

	/**
	 * @return the libraryItems
	 */
	public Set<LibraryItem> getLibraryItems() {
		return libraryItems;
	}

	/**
	 * @param libraryItems
	 *            the libraryItems to set
	 */
	public void setLibraryItems(Set<LibraryItem> libraryItems) {
		this.libraryItems = libraryItems;
	}

	/**
	 * @return the activityComments
	 */
	public List<ActivityComment> getActivityComments() {
		if (this.activityComments == null) {
			this.activityComments = new ArrayList<ActivityComment>();
		}
		return activityComments;
	}

	/**
	 * @param activityComments
	 *            the activityComments to set
	 */
	public void setActivityComments(List<ActivityComment> activityComments) {
		this.activityComments = activityComments;
	}

	/**
	 * Add a ActivityComment object to ActivityComments list
	 * 
	 * @param Comment
	 */
	public void addActivityComment(ActivityComment comment) {
		if (comment != null) {
			this.activityComments.add(comment);
		}
	}

	/**
	 * @return the impact
	 */
	public boolean isImpact() {
		return impact;
	}

	/**
	 * @param impact
	 *            the impact to set
	 */
	public void setImpact(boolean impact) {
		this.impact = impact;
	}

	/**
	 * @return the initiatives
	 */
	public Set<Initiative> getInitiatives() {
		return initiatives;
	}

	/**
	 * @param initiatives
	 *            the initiatives to set
	 */
	public void setInitiatives(Set<Initiative> initiatives) {
		this.initiatives = initiatives;
	}

//	/**
//	 * @return the activeInitiatives
//	 */
//	public Set<Initiative> getActiveInitiatives() {
//		return activeInitiatives;
//	}
//
//	/**
//	 * @param activeInitiatives the activeInitiatives to set
//	 */
//	public void setActiveInitiatives(Set<Initiative> activeInitiatives) {
//		this.activeInitiatives = activeInitiatives;
//	}

	public void addInitiative(Initiative initiative) {
		if (initiatives == null)
			initiatives = new LinkedHashSet<Initiative>();

		initiatives.add(initiative);
	}

	/**
	 * @return the comments
	 */
	public Set<Comment> getComments() {
		if (this.comments == null) {
			this.comments = new HashSet<Comment>();
		}
		return comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	/**Add a Comment object to Comments Set
	 * 
	 * @param Comment
	 */
	public void addComment(Comment comment) {
		if (comment != null) {
			this.comments.add(comment);
			this.activeComments.add(comment);
		}
	}

	public void removeComment(Comment comment){
		if(comment != null){
			this.comments.remove(comment);
			this.activeComments.remove(comment);
		}
	}
	
	public void updateMe(EnumRecordStatus status) {
		
		for(ActivityComment activityComment : activityComments)activityComment.updateMe(status);
		for(Comment comment : comments)comment.updateMe(status);
		for(Initiative initiative : initiatives)initiative.updateMe(status);
//		for(ActivityLibraryItem item : libraryItems)item.updateMe(status);
		
		super.updateMe(status);
	}

	/**
	 * @return the activeComments
	 */
	public Set<Comment> getActiveComments() {
		TreeSet<Comment> ts = new TreeSet<Comment>(new BaseEntityCreateDateComparetor());
		ts.addAll(this.activeComments);
		return ts;
	}

	/**
	 * @param activeComments the activeComments to set
	 */
	public void setActiveComments(Set<Comment> activeComments) {
		this.activeComments = activeComments;
	}

	/**
	 * @return the archiveComments
	 */
	public Set<Comment> getArchiveComments() {
		return archiveComments;
	}

	/**
	 * @param archiveComments the archiveComments to set
	 */
	public void setArchiveComments(Set<Comment> archiveComments) {
		this.archiveComments = archiveComments;
	}

	/**
	 * @return the activeInitiatives
	 */
	public Set<Initiative> getActiveInitiatives() {
		return activeInitiatives;
	}

	/**
	 * @param activeInitiatives the activeInitiatives to set
	 */
	public void setActiveInitiatives(Set<Initiative> activeInitiatives) {
		this.activeInitiatives = activeInitiatives;
	}
}
