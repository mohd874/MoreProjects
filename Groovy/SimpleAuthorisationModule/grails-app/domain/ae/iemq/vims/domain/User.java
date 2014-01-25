package ae.iemq.vims.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "vims_user")
@NamedQueries( { @NamedQuery(name = "User.userByUsername", query = "select distinct user from User user left join fetch user.roleMemberships roleMemberships "
		+ "left join fetch roleMemberships.role where user.username = :username"),
		@NamedQuery(name = "User.username", query = "from User order by createDateTime"),
		@NamedQuery(name = "User.getUserByUsername", query = "from User user where user.username = :username")})
public class User extends BaseEntity {

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;

	//cascade is moved to hibernate cascade for delete orphan option. For better implementation.
	// Note: This is the hibernate specific
	@Cascade( {org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN} )
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private Set<RoleMembership> roleMemberships;
	
	public User(){
		setRoleMemberships(new HashSet<RoleMembership>());
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean authenticate(String password) {
		return this.password.equals(password);
	}

	public Set<RoleMembership> getRoleMemberships() {
		return roleMemberships;
	}

	public void setRoleMemberships(Set<RoleMembership> roleMemberships) {
		this.roleMemberships = roleMemberships;
	}

	@Override
	public String toString() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	public boolean hasRoleNamed(String roleName) {
		for (RoleMembership membership : roleMemberships) {
			if (membership.getRole().getDescription().equals(roleName))
				return true;
		}

		return false;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
}
