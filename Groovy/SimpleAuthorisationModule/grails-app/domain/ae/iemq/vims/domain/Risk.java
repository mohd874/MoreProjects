package ae.iemq.vims.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.FilterJoinTable;
import org.hibernate.annotations.Where;

import ae.iemq.vims.domain.Aspect.Status;
import ae.iemq.vims.util.BaseEntityCreateDateComparetor;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity

@Table(name = "risk")
@NamedQueries( {
	@NamedQuery(name = "Risk.risk", query = "from Risk order by createDateTime"),
	@NamedQuery(name = "Risk.getRisksForObjective", query = "from Risk r where r.objective = :obj and r.recordStatus = 'Active' order by createDateTime"),
	@NamedQuery(name = "Risk.risksForObjective", query = "from Risk where objective = :objective order by createDateTime")
})



public class Risk extends BaseEntity {
	
	private static final String HIGH = "H";

	private static final String MEDIUM = "M";

	private static final String LOW = "L";

	@Column(name = "description")
	private String description;
	
	@Column(name = "risk_timing")
	@Temporal(TemporalType.DATE)
	private Date riskTiming;
	
//	@Column(name = "risk_impact")
//	private Integer riskImpact;
//	
//	@Column(name = "risk_probability")
//	private Integer riskProbability;
//	
//	@Column(name = "risk_manageability")
//	private Integer riskManageability;
//	
//	@Column(name = "calculated_risk")
//	private Integer calculatedRisk;
	
	@Column(name = "frequency")
	private String frequency;

	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "objective", referencedColumnName = "id")
	@ManyToOne
	@FilterJoinTable(name="withoutArchive", condition="archiveDateTime is null")
	private Objective objective;

	
	@OneToMany(mappedBy = "risk", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Initiative> initiatives;

	@OneToMany(mappedBy = "risk", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@Where(clause="record_status='Active'") 
	private Set<Initiative> activeInitiatives;

	@OneToMany(mappedBy = "risk", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@Where(clause="record_status='Archive'") 
	private Set<Initiative> archiveInitiatives;

	@OneToMany(mappedBy = "risk", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Comment> comments;

	@OneToMany(mappedBy = "risk", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Where(clause="record_status='Active'")
	private Set<Comment> activeComments;
	
	@OneToMany(mappedBy = "risk", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Where(clause="record_status='Archive'")
	private Set<Comment> archiveComments;

	@OneToMany(mappedBy = "risk", fetch = FetchType.LAZY)
	@Cascade({org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	private Set<LibraryItem> libraryItems;

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "risk_owner", referencedColumnName = "id")
	@ManyToOne
	private Employee owner;
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy = "risk", fetch = FetchType.EAGER, cascade = {
			CascadeType.ALL })
	@OrderBy("year")
	private Set<PeriodInfo> periodsInfo;
	
	public Risk(){
		setActiveComments(new HashSet<Comment>());
		setArchiveComments(new HashSet<Comment>());
		setComments(new HashSet<Comment>());
		setInitiatives(new HashSet<Initiative>());
		setActiveInitiatives(new HashSet<Initiative>());
		setArchiveInitiatives(new HashSet<Initiative>());
		setLibraryItems(new HashSet<LibraryItem>());
		setPeriodsInfo(new HashSet<PeriodInfo>());
	}
	
	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Objective getObjective() {
		return objective;
	}



	public void setObjective(Objective objective) {
		this.objective = objective;
	}

	@Override
	public String toString() {
		return description;
	}



	public Set<Initiative> getInitiatives() {
		return initiatives;
	}



	public void setInitiatives(Set<Initiative> Initiatives) {
		this.initiatives = Initiatives;
	}	


	public void addInitiative(Initiative initiative) {
		
		if (initiatives == null)
			initiatives = new LinkedHashSet<Initiative>();
		if (activeInitiatives == null)
			activeInitiatives = new LinkedHashSet<Initiative>();
		
	
		initiatives.add(initiative);
		activeInitiatives.add(initiative);
	}



	public Employee getOwner() {
		return owner;
	}



	public void setOwner(Employee owner) {
		this.owner = owner;
	}

	/**
	 * @return the riskTiming
	 */
	public Date getRiskTiming() {
		return riskTiming;
	}



	/**
	 * @param riskTiming the riskTiming to set
	 */
	public void setRiskTiming(Date riskTiming) {
		this.riskTiming = riskTiming;
	}



//	/**
//	 * @return the riskImpact
//	 */
//	public Integer getRiskImpact() {
//		return riskImpact;
//	}
//
//	public String getRiskImpactDesc() {
//		return computeDescription(riskImpact);
//	}
//
//	/**
//	 * @param riskImpact the riskImpact to set
//	 */
//	public void setRiskImpact(Integer riskImpact) {
//		this.riskImpact = riskImpact;
//	}



	/**
	 * @return the riskManageability
	 */
//	public Integer getRiskManageability() {
//		return riskManageability;
//	}
//
//	public String getRiskManageabilityDesc() {
//		return computeDescription(riskManageability);
//	}
//	
//	/**
//	 * @param riskManageability the riskManageability to set
//	 */
//	public void setRiskManageability(Integer riskManageability) {
//		this.riskManageability = riskManageability;
//	}
//


	/**
	 * @return the riskProbability
	 */
//	public Integer getRiskProbability() {
//		return riskProbability;
//	}
//
//	public String getRiskProbabilityDesc() {
//		return computeDescription(riskProbability);
//	}
	/**
	 * Computes if a value is low, medium or high on a scale from 1-10
	 * @param value
	 * @return string
	 */
	private String computeDescription(int value) {
		if (value <= 3)
			return LOW;
		
		if (value <= 6)
			return MEDIUM;
		
		return HIGH;
	}

	/**
	 * @param riskProbability the riskProbability to set
	 */
//	public void setRiskProbability(Integer riskProbability) {
//		this.riskProbability = riskProbability;
//	}
//
//
//
//	/**
//	 * @return the calculatedRisk
//	 */
//	public Integer getCalculatedRisk() {
//		return calculatedRisk;
//	}
//
//	public String getCalculatedRiskDesc() {
//		return computeDescription(calculatedRisk);
//	}
//	
//	/**
//	 * @param calculatedRisk the calculatedRisk to set
//	 */
//	public void setCalculatedRisk(Integer calculatedRisk) {
//		this.calculatedRisk = calculatedRisk;
//	}
//
//	public void calculateRisk() {
//		this.calculatedRisk = (riskImpact + riskProbability) / 2;
//	}
//	
//	public Status computeStatus() {
//		if (calculatedRisk >5.5 && riskManageability < 5.5)
//			return Status.RED;
//		
//		if (calculatedRisk <5.5 && riskManageability >5.5)
//			return Status.GREEN;
//	
//		return Status.YELLOW;		
//	}
	
	public Set<PeriodInfo> getPeriodsInfo(){
		return periodsInfo;
	}
	
	public void setPeriodsInfo(Set<PeriodInfo> info){
		this.periodsInfo = info;
	}
	
	public void addPeriodInfo(PeriodInfo period) {
		if (periodsInfo == null)
			periodsInfo = new LinkedHashSet<PeriodInfo>();

		periodsInfo.add(period);
	}
	
	public PeriodInfo getLastPeriodInfo(){
		int year = 0;
		PeriodInfo lastPeriodInfo = null;
		for(PeriodInfo pi : getPeriodsInfo()){
			if(pi.getYear() > year){
				year = pi.getYear();
				lastPeriodInfo = pi;
			}
		}
		return lastPeriodInfo;
	}
	
	public PeriodInfo getPeriodInfoByYear(int year){
		if (periodsInfo!=null){
			for (PeriodInfo p:periodsInfo){
				if (p.getYear()==year)
					return p;
			}
		}
		return null;
	}



	public String getFrequency() {
		return frequency;
	}



	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}



	/**
	 * @return the comments
	 */
	public Set<Comment> getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
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

	/**
	 * @return the activeComments
	 */
	public Set<Comment> getActiveComments() {
		return activeComments;
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
		TreeSet<Comment> ts = new TreeSet<Comment>(new BaseEntityCreateDateComparetor());
		ts.addAll(this.activeComments);
		return ts;
	}

	/**
	 * @param archiveComments the archiveComments to set
	 */
	public void setArchiveComments(Set<Comment> archiveComments) {
		this.archiveComments = archiveComments;
	}

	public void removeComment(Comment comment) {
		if(comment != null){
			this.comments.remove(comment);
			this.activeComments.remove(comment);
		}
	}

	/**
	 * @return the libraryItems
	 */
	public Set<LibraryItem> getLibraryItems() {
		return libraryItems;
	}

	/**
	 * @param libraryItems the libraryItems to set
	 */
	public void setLibraryItems(Set<LibraryItem> libraryItems) {
		this.libraryItems = libraryItems;
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
}
