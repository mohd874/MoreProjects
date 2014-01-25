package ae.iemq.vims.domain;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import ae.iemq.vims.util.DateUtil;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "perspective")
@NamedQueries( {
		@NamedQuery(name = "Perspective.allPerspectives", query = "select distinct pers from Perspective pers left join fetch pers.objectives order by pers.id"),
		@NamedQuery(name = "Perspective.countObjectives", query = "select count(*) from Objective where perspective = :perspective") })
public class Perspective extends BaseEntity {

	static Logger LOG = Logger.getLogger(Perspective.class);
	
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy = "perspective", fetch = FetchType.LAZY)
	@OrderBy("createDateTime")
	private Set<Objective> objectives;

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@ManyToMany
	@JoinTable(name = "aspect_perspective", joinColumns = @JoinColumn(name = "perspective", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "aspect", referencedColumnName = "id"))
	@OrderBy("name")
	private Set<Aspect> aspects;

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	@Column(name = "color")
	private String color;

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

	@Override
	public String toString() {
		return name + " (" + code + ")";
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

	public void addObjective(Objective objective) {
		objectives.add(objective);
	}

	/**
	 * @return the aspects
	 */
	public Set<Aspect> getAspects() {
		return aspects;
	}

	/**
	 * @param aspects
	 *            the aspects to set
	 */
	public void setAspects(Set<Aspect> aspects) {
		this.aspects = aspects;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Color getColorColor() {

		int r, g, b;
		StringTokenizer st = new StringTokenizer(this.color);
		r = Integer.parseInt(st.nextToken("."));
		g = Integer.parseInt(st.nextToken("."));
		b = Integer.parseInt(st.nextToken("."));
		Color c = new Color(r, g, b);

		return c;
	}

	public String getHexColor() {

		int r, g, b;
		StringTokenizer st = new StringTokenizer(this.color);
		r = Integer.parseInt(st.nextToken("."));
		g = Integer.parseInt(st.nextToken("."));
		b = Integer.parseInt(st.nextToken("."));
		Color c = new Color(r, g, b);
		String hex = Integer.toHexString(c.getRGB() & 0x00ffffff);
		if (hex.length() < 6)
			hex = "#0" + hex;
		else
			hex = "#" + hex;

		return hex.toUpperCase();
	}

	public List<Objective> getObjectivesFor(OrgUnit orgUnit, Period period) {
		List<Objective> result = new ArrayList<Objective>();
		LOG.debug("orgUnit.getName() in getObjectivesFor -->"
				+ orgUnit.getName());
		// LOG.debug("orgUnit.getSuperOrgUnit().getName() in
		// getObjectivesFor -->"+orgUnit.getSuperOrgUnit().getName());

		for (Objective objective : objectives) {
			LOG.debug("objective.getName() in getObjectivesFor -->"
					+ objective.getName());
			LOG.debug("objective.getOrgUnit() in getObjectivesFor -->"
					+ objective.getOrgUnit());
			LOG.debug("objective.getOrgUnit().getSuperOrgUnit() in getObjectivesFor -->"
							+ objective.getOrgUnit().getSuperOrgUnit());
			LOG.debug("------------------------------------");
			
			if (orgUnit.equals(objective.getOrgUnit())
					//|| orgUnit.equals(objective.getOrgUnit().getSuperOrgUnit())
					&& DateUtil.periodsIntersect(objective.getPeriod(), period)) {
				result.add(objective);
			}
			for (OrgUnit subOrg: orgUnit.getAllSubOrgUnits()){
				LOG.debug(subOrg.getName()+" IS A SUB ORG UNIT OF.... "+orgUnit);
				if (subOrg.equals(objective.getOrgUnit())&& DateUtil.periodsIntersect(objective.getPeriod(), period)){
					result.add(objective);
				}
			}
// TRYING TO GO DEEP INTO SUB ORG UNITS			
//			if (!orgUnit.equals(objective.getOrgUnit())){
//				OrgUnit origin=objective.getOrgUnit();
//				if (origin.equals(objective.getOrgUnit().getSuperOrgUnit())){
//				List <Objective> temp= getObjectivesFor(origin,period);
//				for (int i=0;i<temp.size();i++){
//					if (!result.contains(temp.get(i))){
//						result.add(temp.get(i));
//					}//if
//				}//for
//				}//if
//					
//			}

		}

		return result;
	}
}
