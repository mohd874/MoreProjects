package ae.iemq.vims.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class ResourceUserID implements Serializable, Cloneable {

	private String resourceGUID;

	private String userId;
	
	private String role;
	
	public ResourceUserID() {
		super();
	}

	public ResourceUserID(String resourceGUID, String user, String role) {
		super();
		this.resourceGUID = resourceGUID;
		this.userId = user;
		this.role = role;
	}

	public String getResourceGUID() {
		return resourceGUID;
	}

	public void setResourceGUID(String resourceGUID) {
		this.resourceGUID = resourceGUID;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String user) {
		this.userId = user;
	}

	@Override
	public boolean equals(final Object rui) {
		return rui instanceof ResourceUserID
				&& ((ResourceUserID) rui).resourceGUID.equals(resourceGUID)
				&& ((ResourceUserID) rui).userId.equals(userId)
				&& ((ResourceUserID) rui).role.equals(role);
	}

	@Override
	public int hashCode() {
		return userId.hashCode()*resourceGUID.hashCode();
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
