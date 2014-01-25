package ae.iemq.vims.domain;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Where;

import ae.iemq.vims.util.DateUtil;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "team")
@NamedQueries( {
		@NamedQuery(name = "Team.allTeams", query = "from Team"),
		@NamedQuery(name = "Team.allTeamsByID", query = "from Team order by id"),
		@NamedQuery(name = "Team.rootTeam", query = "from Team where superTeam = null"),
		@NamedQuery(name = "Team.orgUnitById", query = "from Team o where o.id = :id"), 
		@NamedQuery(name = "Team.maxTeamSize", query = "select count(*) from Team group by level"),
		@NamedQuery(name = "Team.maxTeamDepth", query = "select max(level) from Team group by level")})
public class Team extends BaseEntity implements Comparable {
	// Added Comparable Interface to use SortedSet
	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "super_team", referencedColumnName = "id")
	@ManyToOne
	private Team superTeam;

	@Column(name = "level")
	private int level;

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy = "superTeam", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Team> subTeams;


	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy = "orgUnit", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// cascaded
	@OrderBy("id")
	private Set<Employee> employees;

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Team getSuperTeam() {
		return superTeam;
	}

	public void setSuperTeam(Team superOrgUnut) {
		this.superTeam = superOrgUnut;
	}

	/**
	 * @return the subTeams
	 */
	public Set<Team> getSubTeams() {

		// this.subTeams.remove(this);
		return this.subTeams;// return subTeams;
	}

	/**
	 * @param subTeams
	 *            the subTeams to set
	 */
	public void setSubTeams(Set<Team> subTeams) {
		this.subTeams = subTeams;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	public Employee getEmployeeByName(String name) {
		Employee ret = null;

		for (Employee emp : employees) {
			if (emp.getName().equalsIgnoreCase(name)) {
				if (ret == null)
					ret = emp;
				else
					throw new RuntimeException("Name '" + name
							+ "' does not uniquely identify an employee in "
							+ this);
			}
		}

		return ret;
	}

	public Set<Team> getAllSubTeams() {
		SortedSet<Team> result = new TreeSet<Team>();
		for (Team subOrg : this.getSubTeams()) {
			// result.remove(this); //just added
			result.add(subOrg);
			result.addAll(subOrg.getAllSubTeams());
		}
		// Arrange the results from the deepest in the Org Structure First
		Set<Team> finalresult = new LinkedHashSet<Team>();

		while (!result.isEmpty()) {
			// Get element
			finalresult.add(result.last());
			result.remove(result.last());

		}
		return finalresult;

	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Team b = (Team) o;
		return this.getId().toString()
				.compareToIgnoreCase(b.getId().toString());
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	// This Method should be a service but its placed here for accesibility
	public Set<Team> getTeamsFromLevel(int level) {
		SortedSet<Team> result = new TreeSet<Team>();
		for (Team subOrg : this.getAllSubTeams()) {
			// result.remove(this); //just added
			if (subOrg.getLevel() == level) {
				result.add(subOrg);
			}
		}
		// Arrange the results from the deepest in the Org Structure First
		Set<Team> finalresult = new LinkedHashSet<Team>();

		while (!result.isEmpty()) {
			// Get element
			finalresult.add(result.last());
			result.remove(result.last());

		}
		return finalresult;
	}

	// This Method should be a service but its placed here for accesibility
	public int getDeepestLevel() {
		int deepest = 1;
		for (Team subOrg : this.getAllSubTeams()) {
			if (subOrg.getLevel() >= deepest) {
				deepest = subOrg.getLevel();
			}
		}
		return deepest;
	}

	public Set<Team> getTeamsFromLevel(int level, Set<Team> orgs) {
		SortedSet<Team> result = new TreeSet<Team>();
		for (Team subOrg : orgs) {
			if (subOrg.getLevel() == level) {
				result.add(subOrg);
			}
		}
		// Arrange the results from the deepest in the Org Structure First
		Set<Team> finalresult = new LinkedHashSet<Team>();

		while (!result.isEmpty()) {
			// Get element
			finalresult.add(result.last());
			result.remove(result.last());

		}
		return finalresult;
	}

	public Set<Team> getNextLevelTeams() {

		SortedSet<Team> result = new TreeSet<Team>();
		for (Team subOrg : getSubTeams()) {
			if (subOrg.getLevel() == getLevel() + 1) {
				result.add(subOrg);
			}
		}
		return result;
	}

}

