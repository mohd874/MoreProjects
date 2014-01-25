package ae.iemq.vims.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "resource_user")
//@IdClass(ResourceUser.ResourceUserID.class)
@NamedQueries( {
	@NamedQuery(name = "ResourceUsers.getByResource", query = "select resourceUser.resourceUserID from ResourceUser resourceUser where resourceUser.resourceUserID.resourceGUID = :resourceGUID"),
	@NamedQuery(name = "ResourceUsers.getResourceByUser", query = "from ResourceUser resourceUser where resourceUser.resourceUserID.userId = :userId"),
	@NamedQuery(name = "ResourceUsers.getRolesByUserResource", query = "from ResourceUser resourceUser where resourceUser.resourceUserID.resourceGUID = :resourceGUID and resourceUser.resourceUserID.userId = :userId"),
	@NamedQuery(name = "ResourceUsers.getUserResouceByUserRole", query = "from ResourceUser resourceUser where resourceUser.resourceUserID.resourceGUID = :resourceGUID and resourceUser.resourceUserID.userId = :userId and resourceUser.resourceUserID.role = :role "),
	@NamedQuery(name = "ResourceUsers.getByUserResource", query = "from ResourceUser resourceUser where resourceUser.resourceUserID.resourceGUID = :resourceGUID and resourceUser.resourceUserID.userId = :userId"),
	@NamedQuery(name = "ResourceUsers.getUsersOnUserResource", query = "from User user where user.id in (select resourceUser.resourceUserID.userId from ResourceUser resourceUser where resourceUser.resourceUserID.resourceGUID = :resourceGUID group by resourceUser.resourceUserID.userId) order by user.username "),
	@NamedQuery(name = "ResourceUsers.getUsersByRole", query = "select resourceUser.resourceUserID.userId from ResourceUser resourceUser where resourceUser.resourceUserID.resourceGUID = :resourceGUID and resourceUser.resourceUserID.role = :role"),
	@NamedQuery(name = "ResourceUsers.deleteResourceUser", query = "delete from ResourceUser ru where ru.resourceUserID.resourceGUID = :guid and ru.resourceUserID.userId = :userId")
})
public class ResourceUser implements Serializable, Cloneable {
	@Id
	@AttributeOverrides({
		@AttributeOverride(name="resourceGUID",column=@Column(name = "resource_guid")),
		@AttributeOverride(name="userId",column=@Column(name = "user_id")),
		@AttributeOverride(name="role",column=@Column(name = "role"))
	})
	private ResourceUserID resourceUserID;
	
	@Column(name = "create_dt", insertable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDateTime;
	
	@Column(name = "last_updated_dt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdatedTime;

	public ResourceUser() {
		super();
	}

	public ResourceUser(String resourceGUID, String userId, String role) {
		this.resourceUserID = new ResourceUserID(resourceGUID, userId, role);
	}

	public ResourceUserID getResourceUserID() {
		return resourceUserID;
	}

	public void setResourceUserID(ResourceUserID resourceUserID) {
		this.resourceUserID = resourceUserID;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Date getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(Date lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}
	
	/**
	 * Equality of entities is determined by type and id.  Two entities are equal if and
	 * ony if they are of the same type and have the same (primary key) id.
	 */
	@Override
	public final boolean equals(Object obj) {

		// Both must be instances of BaseEntity
		if (!(obj instanceof ResourceUser))
			return false;

		ResourceUser other = (ResourceUser) obj;
		return resourceUserID.equals(other.getResourceUserID());
	}

	@Override
	public final int hashCode() {
		return resourceUserID.hashCode()*createDateTime.hashCode();
	}
}
