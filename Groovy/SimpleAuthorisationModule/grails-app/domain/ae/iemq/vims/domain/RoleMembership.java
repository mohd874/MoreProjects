package ae.iemq.vims.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "role_membership")
public class RoleMembership extends BaseEntity  {
	
	@JoinColumn(name = "vims_user", referencedColumnName = "id")
	@ManyToOne
	private User user;
	
	@JoinColumn(name = "role", referencedColumnName = "id")
	@ManyToOne
	private Role role;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return user + " member of " +role;
	}
}
