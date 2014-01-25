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
@Table(name = "org_unit")
@NamedQueries( {
		@NamedQuery(name = "OrgUnit.allOrgUnits", query = "from OrgUnit order by level asc name"),
		@NamedQuery(name = "OrgUnit.allOrgUnitsByID", query = "from OrgUnit order by id"),
		@NamedQuery(name = "OrgUnit.rootOrgUnit", query = "from OrgUnit where superOrgUnit = null"),
		@NamedQuery(name = "OrgUnit.orgUnitById", query = "from OrgUnit o where o.id = :id"), 
		@NamedQuery(name = "OrgUnit.orgUnitByName", query = "from OrgUnit o where o.name = :name"), 
		@NamedQuery(name = "OrgUnit.maxOrgUnitSize", query = "select count(*) from OrgUnit group by level"),
		@NamedQuery(name = "OrgUnit.maxOrgUnitDepth", query = "select max(level) from OrgUnit group by level")})
public class OrgUnit extends BaseEntity implements Comparable {
	// Added Comparable Interface to use SortedSet
	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "super_org_unit", referencedColumnName = "id")
	@ManyToOne
	private OrgUnit superOrgUnit;

	@Column(name = "level")
	private int level;

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy = "superOrgUnit", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<OrgUnit> subOrgUnits;

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy = "orgUnit", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// cascade
	private Set<Objective> objectives;

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

	public OrgUnit getSuperOrgUnit() {
		return superOrgUnit;
	}

	public void setSuperOrgUnit(OrgUnit superOrgUnut) {
		this.superOrgUnit = superOrgUnut;
	}

	/**
	 * @return the subOrgUnits
	 */
	public Set<OrgUnit> getSubOrgUnits() {

		// this.subOrgUnits.remove(this);
		return this.subOrgUnits;// return subOrgUnits;
	}

	/**
	 * @param subOrgUnits
	 *            the subOrgUnits to set
	 */
	public void setSubOrgUnits(Set<OrgUnit> subOrgUnits) {
		this.subOrgUnits = subOrgUnits;
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

	public Set<Objective> getRolledUpObjectivesIn(Perspective perspective,
			Date startDate, Date endDate) {
		assert perspective != null;
		assert startDate != null;
		assert endDate != null;

		Set<Objective> rolledUpObjectives = new LinkedHashSet<Objective>();

		for (Objective objective : objectives)
			if (objective.getPerspective().equals(perspective)
					&& DateUtil.intervalsIntersect(startDate, endDate,
							objective.getPeriod().startDate, objective
									.getPeriod().endDate))

				rolledUpObjectives.add(objective);

		for (OrgUnit subOrgUnit : subOrgUnits)
			rolledUpObjectives.addAll(subOrgUnit.getRolledUpObjectivesIn(
					perspective, startDate, endDate));

		return rolledUpObjectives;
	}

	public Set<Objective> getRolledUpObjectivesIn(Date startDate, Date endDate) {

		assert startDate != null;
		assert endDate != null;

		Set<Objective> rolledUpObjectives = new LinkedHashSet<Objective>();

		for (Objective objective : objectives)
			if (DateUtil.intervalsIntersect(startDate, endDate, objective
					.getPeriod().startDate, objective.getPeriod().endDate))

				rolledUpObjectives.add(objective);

		for (OrgUnit subOrgUnit : subOrgUnits)
			rolledUpObjectives.addAll(subOrgUnit.getRolledUpObjectivesIn(
					startDate, endDate));

		return rolledUpObjectives;
	}

	/**
	 * @return the objectives
	 */
	public Set<Objective> getObjectives() {
		return objectives;
	}

	/**
	 * @param objectives
	 *            the objectives to set
	 */
	public void setObjectives(Set<Objective> objectives) {
		this.objectives = objectives;
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

	public Set<OrgUnit> getAllSubOrgUnits() {
		SortedSet<OrgUnit> result = new TreeSet<OrgUnit>();
		for (OrgUnit subOrg : this.getSubOrgUnits()) {
			// result.remove(this); //just added
			result.add(subOrg);
			result.addAll(subOrg.getAllSubOrgUnits());
		}
		// Arrange the results from the deepest in the Org Structure First
		Set<OrgUnit> finalresult = new LinkedHashSet<OrgUnit>();

		while (!result.isEmpty()) {
			// Get element
			finalresult.add(result.last());
			result.remove(result.last());

		}
		return finalresult;

	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		OrgUnit b = (OrgUnit) o;
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
	public Set<OrgUnit> getOrgUnitsFromLevel(int level) {
		SortedSet<OrgUnit> result = new TreeSet<OrgUnit>();
		for (OrgUnit subOrg : this.getAllSubOrgUnits()) {
			// result.remove(this); //just added
			if (subOrg.getLevel() == level) {
				result.add(subOrg);
			}
		}
		// Arrange the results from the deepest in the Org Structure First
		Set<OrgUnit> finalresult = new LinkedHashSet<OrgUnit>();

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
		for (OrgUnit subOrg : this.getAllSubOrgUnits()) {
			if (subOrg.getLevel() >= deepest) {
				deepest = subOrg.getLevel();
			}
		}
		return deepest;
	}

	public Set<OrgUnit> getOrgUnitsFromLevel(int level, Set<OrgUnit> orgs) {
		SortedSet<OrgUnit> result = new TreeSet<OrgUnit>();
		for (OrgUnit subOrg : orgs) {
			if (subOrg.getLevel() == level) {
				result.add(subOrg);
			}
		}
		// Arrange the results from the deepest in the Org Structure First
		Set<OrgUnit> finalresult = new LinkedHashSet<OrgUnit>();

		while (!result.isEmpty()) {
			// Get element
			finalresult.add(result.last());
			result.remove(result.last());

		}
		return finalresult;
	}

	public Set<OrgUnit> getNextLevelOrgUnits() {

		SortedSet<OrgUnit> result = new TreeSet<OrgUnit>();
		for (OrgUnit subOrg : getSubOrgUnits()) {
			if (subOrg.getLevel() == getLevel() + 1) {
				result.add(subOrg);
			}
		}
		return result;
	}

}
