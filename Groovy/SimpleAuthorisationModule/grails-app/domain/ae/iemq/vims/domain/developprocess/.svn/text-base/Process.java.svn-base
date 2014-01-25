package ae.iemq.vims.domain.developprocess;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Where;

import ae.iemq.vims.domain.BaseEntity;
import ae.iemq.vims.domain.Comment;
import ae.iemq.vims.domain.Employee;
import ae.iemq.vims.domain.Initiative;
import ae.iemq.vims.domain.LibraryItem;
import ae.iemq.vims.domain.Objective;
import ae.iemq.vims.domain.OrgUnit;
import ae.iemq.vims.domain.ProcessLibraryItem;
import ae.iemq.vims.domain.BaseEntity.EnumRecordStatus;
import ae.iemq.vims.util.BaseEntityCreateDateComparetor;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "process")
@NamedQueries({
	@NamedQuery(name = "Process.getProcessesForObjective",
			query = "from Process prc where prc.objective = :obj")
})
public class Process extends BaseEntity {

	public static enum ProcessType {Core, Management, Support};
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "process_type")
	@Enumerated(EnumType.STRING)
	private ProcessType type;	
	
	@JoinColumn(name = "accountability", referencedColumnName = "id")
	@ManyToOne
	private OrgUnit accountability;
	
	@JoinColumn(name = "owner", referencedColumnName = "id")
	@ManyToOne
	private Employee owner;
	
	@JoinColumn(name = "objective", referencedColumnName = "id")
	@ManyToOne
	private Objective objective;
	
	@Column(name = "last_modified")
	private Date lastModified;
	
	@Column(name = "creation_date")
	private Date creationDate;
	
	@Column(name = "graph_xml")
	private String graphXml;
	
	@OneToMany(mappedBy = "process", fetch = FetchType.LAZY)
	@Cascade({org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	private Set<LibraryItem> libraryItems;

	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "parent_process", referencedColumnName = "id")
	@ManyToOne
	private Process parentProcess;

	@Column(name = "process_level")
	private int processLevel;

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy = "parentProcess", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Process> childProcesses;
	
	@OneToMany(mappedBy = "process", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy(clause="create_dt desc")
	private Set<Comment> comments;

	@OneToMany(mappedBy = "process", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Where(clause="record_status='Active'")
	private Set<Comment> activeComments;
	
	@OneToMany(mappedBy = "process", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Where(clause="record_status='Archive'")
	private Set<Comment> archiveComments;

	
	@OneToMany(mappedBy = "process", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Initiative> initiatives;

	@OneToMany(mappedBy = "process", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@Where(clause="record_status='Active'") 
	private Set<Initiative> activeInitiatives;

	@OneToMany(mappedBy = "process", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@Where(clause="record_status='Archive'") 
	private Set<Initiative> archiveInitiatives;

	public Process(){
		setLibraryItems(new HashSet<LibraryItem>());
		setChildProcesses(new HashSet<Process>());
		setComments(new HashSet<Comment>());
		setActiveComments(new HashSet<Comment>());
		setArchiveComments(new HashSet<Comment>());
		setInitiatives(new HashSet<Initiative>());
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the accountability
	 */
	public OrgUnit getAccountability() {
		return accountability;
	}

	/**
	 * @param accountability the accountability to set
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
	 * @param name the name to set
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
	 * @param objective the objective to set
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
	 * @param owner the owner to set
	 */
	public void setOwner(Employee owner) {
		this.owner = owner;
	}

	/**
	 * @return the priority
	 */
	public ProcessType getType() {
		return type;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setType(ProcessType type) {
		this.type = type;
	}

	/**
	 * @return the lastModified
	 */
	public Date getLastModified() {
		return lastModified;
	}

	/**
	 * @param lastModified the lastModified to set
	 */
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public String getFriendlyLastModified(){
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("MMM-yyyy");
		return sdf.format(lastModified);
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
	
	public void addLibraryItem(LibraryItem libraryItem){
		this.libraryItems.add(libraryItem);
	}

	/**
	 * @return the childProcesses
	 */
	public Set<Process> getChildProcesses() {
		return childProcesses;
	}

	/**
	 * @param childProcess the childProcess to set
	 */
	public void setChildProcesses(Set<Process> childProcesses) {
		this.childProcesses = childProcesses;
	}

	/**
	 * @return the parentProcess
	 */
	public Process getParentProcess() {
		return parentProcess;
	}

	/**
	 * @param parentProcess the parentProcess to set
	 */
	public void setParentProcess(Process parentProcess) {
		this.parentProcess = parentProcess;
	}

	/**
	 * @return the processLevel
	 */
	public int getProcessLevel() {
		return processLevel;
	}

	/**
	 * @param processLevel the processLevel to set
	 */
	public void setProcessLevel(int processLevel) {
		this.processLevel = processLevel;
	}
	
	public void addChildProcess(Process childProcess){
		this.childProcesses.add(childProcess);
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public String getFriendlyCreationDate(){
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("MMM-yyyy");
		return sdf.format(creationDate);
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
			System.out.println("--1--comments.size--->"+this.comments.size());
			System.out.println("--1--activeComments.size--->"+this.activeComments.size());
			
			this.comments.add(comment);
			this.activeComments.add(comment);
			
			System.out.println("--2--comments.size--->"+this.comments.size());
			System.out.println("--2--activeComments.size--->"+this.activeComments.size());
			
		}
	}

	/**
	 * @return the initiatives
	 */
	public Set<Initiative> getInitiatives() {
		return initiatives;
	}

	/**
	 * @param initiatives the initiatives to set
	 */
	public void setInitiatives(Set<Initiative> initiatives) {
		this.initiatives = initiatives;
	}
	
	public void addInitiative(Initiative initiative) {
		if (initiatives == null)
			initiatives = new LinkedHashSet<Initiative>();

		initiatives.add(initiative);
	}

	/**
	 * @return the graphXml
	 */
	public String getGraphXml() {
		return graphXml;
	}

	/**
	 * @param graphXml the graphXml to set
	 */
	public void setGraphXml(String graphXml) {
		this.graphXml = graphXml;
	}

	@Override
	public void updateMe(EnumRecordStatus status) {
		for(Process process : childProcesses)process.updateMe(status);
		for(Comment comment : comments)comment.updateMe(status);
		for(Initiative initiative : initiatives)initiative.updateMe(status);
//		for(ProcessLibraryItem item : libraryItems)item.updateMe(status);
		
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

	public void removeComment(Comment comment) {
		if(comment != null){
			this.comments.remove(comment);
			this.activeComments.remove(comment);
		}
	}
}
