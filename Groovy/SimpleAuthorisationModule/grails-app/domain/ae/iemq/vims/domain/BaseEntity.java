package ae.iemq.vims.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ae.iemq.vims.util.DateUtil;
import ae.iemq.vims.util.GuidGenerator;

/**
 * Abstract superclass for all Vims persistent entities.  All entities have an auto-generated
 * integer primary key and audit fields as declared in this class. 
 *
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable, Cloneable{

	public static final String DATA_COORDINATOR = "DATA_COORDINATOR";
	public static final String OBJECTIVE_OWNER = "OBJECTIVE_OWNER";
	
	public static enum EnumRecordStatus {
		Active("Active"),
		Pending("Pending"),
		Archive("Archive"),
		All("%");
		
		private final String whereCalse;
		
		EnumRecordStatus(String string){
			this.whereCalse = string;
		}
		
		public String getWhereCalse(){
			return this.whereCalse;
		}
	}
	
	public static final String activeRecordStatus = "Active";
	public static final String archiveRecordStatus = "Archive";
	public static final String pendingRecordStatus = "Pending";
	public static final String allRecordStatus = "%";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "create_dt", insertable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDateTime;

	@JoinColumn(name = "create_user", referencedColumnName = "id", nullable = true)
	@ManyToOne
	private User createUser;

	@JoinColumn(name = "last_updated_user", referencedColumnName = "id", nullable = true)
	@ManyToOne
	private User archiveUser;

	@Column(name = "last_updated_dt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date archiveDateTime;
	
	/**
	 * The record status is set to active by default.
	 * A named query is needed to retrieve not active records.
	 */
	@Column(name = "record_status")
	@Enumerated(EnumType.STRING)
//	@Where(clause = "record_status = 'Active'")
	private EnumRecordStatus recordStatus;
	
	@Column(name = "resource_id")
	private String resourceGUID;
	
	public BaseEntity(){
		recordStatus = EnumRecordStatus.Active;
		resourceGUID = GuidGenerator.getInstance().generateGUID(this);
	}
	
	public final Date getCreateDateTime() {
		return createDateTime;
	}

	public final void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public final User getCreateUser() {
		return createUser;
	}

	public final void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Equality of entities is determined by type and id.  Two entities are equal if and
	 * ony if they are of the same type and have the same (primary key) id.
	 */
	@Override
	public final boolean equals(Object obj) {

		// Both must be instances of BaseEntity
		if (!(obj instanceof BaseEntity))
			return false;

		BaseEntity other = (BaseEntity) obj;

		// One type must be assignable from the other
		if (!(this.getClass().isInstance(other) || other.getClass().isInstance(
				this)))
			return false;

		// In the abscence of ids, instance equality must hold
		if (getId() == null || other.getId() == null)
			return super.equals(other);

		// For indentified entities, equality is determined by equality of ids.
		return getId().equals(other.getId());
	}

	@Override
	public final int hashCode() {
		return id != null ? id : super.hashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public abstract String toString();

	/**
	 * @return the archiveDateTime
	 */
	public final Date getArchiveDateTime() {
		return archiveDateTime;
	}

	/**
	 * @param archiveDateTime
	 *            the archiveDateTime to set
	 */
	public final void setArchiveDateTime(Date archiveDateTime) {
		this.archiveDateTime = archiveDateTime;
	}

	/**
	 * @return the archiveUser
	 */
	public final User getArchiveUser() {
		return archiveUser;
	}

	/**
	 * @param archiveUser
	 *            the archiveUser to set
	 */
	public final void setArchiveUser(User archiveUser) {
		this.archiveUser = archiveUser;
	}	
	
	/**
	 * @return friendly date format
	 */
	public String getFriendlyCreatDate(){
		return DateUtil.getFormatedDate(createDateTime, "E MMM d,yyyy - kk:mm:ss");
	}

	/**
	 * @return the recordStatus
	 */
	public EnumRecordStatus getRecordStatus() {
		return recordStatus;
	}

	/**
	 * @param recordStatus the recordStatus to set
	 */
	public void setRecordStatus(EnumRecordStatus recordStatus) {
		this.recordStatus = recordStatus;
	}
	
	public void updateMe(BaseEntity.EnumRecordStatus status){
		this.recordStatus = status;
	}

	public String getResourceGUID() {
		return resourceGUID;
	}

	public void setResourceGUID(String resourceGUID) {
		this.resourceGUID = resourceGUID;
	}
}
