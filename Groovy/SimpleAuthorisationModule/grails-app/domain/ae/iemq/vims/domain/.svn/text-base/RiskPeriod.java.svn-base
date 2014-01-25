package ae.iemq.vims.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "risk_period")
@NamedQueries( { @NamedQuery(name = "RiskPeriod.measurePeriodByYear", query = "select riskPeriod from RiskPeriod riskPeriod "
		+ "where riskPeriod.year = :year "
		+ "and riskPeriod.risk = :risk") })
		
public class RiskPeriod extends BaseEntity{

	static Logger LOG = Logger.getLogger(RiskPeriod.class);
	
	@Column(name = "risk_year")
	private int year;
	
	@Column(name = "risk")
	private Risk risk;
	
	@Column(name = "manageability_jan")
	private float manageabilityJan;

	@Column(name = "manageability_feb")
	private float manageabilityFeb;

	@Column(name = "manageability_march")
	private float manageabilityMarch;

	@Column(name = "manageability_april")
	private float manageabilityApril;

	@Column(name = "manageability_may")
	private float manageabilityMay;

	@Column(name = "manageability_june")
	private float manageabilityJune;

	@Column(name = "manageability_july")
	private float manageabilityJuly;

	@Column(name = "manageability_aug")
	private float manageabilityAug;

	@Column(name = "manageability_sept")
	private float manageabilitySept;

	@Column(name = "manageability_oct")
	private float manageabilityOct;

	@Column(name = "manageability_nov")
	private float manageabilityNov;

	@Column(name = "manageability_dec")
	private float manageabilityDec;

	@Column(name = "impact_jan")
	private float impactJan;

	@Column(name = "impact_feb")
	private float impactFeb;

	@Column(name = "impact_march")
	private float impactMarch;

	@Column(name = "impact_april")
	private float impactApril;

	@Column(name = "impact_may")
	private float impactMay;

	@Column(name = "impact_june")
	private float impactJune;

	@Column(name = "impact_july")
	private float impactJuly;

	@Column(name = "impact_aug")
	private float impactAug;

	@Column(name = "impact_sept")
	private float impactSept;

	@Column(name = "impact_oct")
	private float impactOct;

	@Column(name = "impact_nov")
	private float impactNov;

	@Column(name = "impact_dec")
	private float impactDec;

	@Column(name = "probabilty_jan")
	private float probabiltyJan;

	@Column(name = "probabilty_feb")
	private float probabiltyFeb;

	@Column(name = "probabilty_march")
	private float probabiltyMarch;

	@Column(name = "probabilty_april")
	private float probabiltyApril;

	@Column(name = "probabilty_may")
	private float probabiltyMay;

	@Column(name = "probabilty_june")
	private float probabiltyJune;

	@Column(name = "probabilty_july")
	private float probabiltyJuly;

	@Column(name = "probabilty_aug")
	private float probabiltyAug;

	@Column(name = "probabilty_sept")
	private float probabiltySept;

	@Column(name = "probabilty_oct")
	private float probabiltyOct;

	@Column(name = "probabilty_nov")
	private float probabiltyNov;

	@Column(name = "probabilty_dec")
	private float probabiltyDec;

	@Column(name = "comment")
	private String comment;
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public float getImpactApril() {
		return impactApril;
	}

	public void setImpactApril(float impactApril) {
		this.impactApril = impactApril;
	}

	public float getImpactAug() {
		return impactAug;
	}

	public void setImpactAug(float impactAug) {
		this.impactAug = impactAug;
	}

	public float getImpactDec() {
		return impactDec;
	}

	public void setImpactDec(float impactDec) {
		this.impactDec = impactDec;
	}

	public float getImpactFeb() {
		return impactFeb;
	}

	public void setImpactFeb(float impactFeb) {
		this.impactFeb = impactFeb;
	}

	public float getImpactJan() {
		return impactJan;
	}

	public void setImpactJan(float impactJan) {
		this.impactJan = impactJan;
	}

	public float getImpactJuly() {
		return impactJuly;
	}

	public void setImpactJuly(float impactJuly) {
		this.impactJuly = impactJuly;
	}

	public float getImpactJune() {
		return impactJune;
	}

	public void setImpactJune(float impactJune) {
		this.impactJune = impactJune;
	}

	public float getImpactMarch() {
		return impactMarch;
	}

	public void setImpactMarch(float impactMarch) {
		this.impactMarch = impactMarch;
	}

	public float getImpactMay() {
		return impactMay;
	}

	public void setImpactMay(float impactMay) {
		this.impactMay = impactMay;
	}

	public float getImpactNov() {
		return impactNov;
	}

	public void setImpactNov(float impactNov) {
		this.impactNov = impactNov;
	}

	public float getImpactOct() {
		return impactOct;
	}

	public void setImpactOct(float impactOct) {
		this.impactOct = impactOct;
	}

	public float getImpactSept() {
		return impactSept;
	}

	public void setImpactSept(float impactSept) {
		this.impactSept = impactSept;
	}

	public float getManageabilityApril() {
		return manageabilityApril;
	}

	public void setManageabilityApril(float manageabilityApril) {
		this.manageabilityApril = manageabilityApril;
	}

	public float getManageabilityAug() {
		return manageabilityAug;
	}

	public void setManageabilityAug(float manageabilityAug) {
		this.manageabilityAug = manageabilityAug;
	}

	public float getManageabilityDec() {
		return manageabilityDec;
	}

	public void setManageabilityDec(float manageabilityDec) {
		this.manageabilityDec = manageabilityDec;
	}

	public float getManageabilityFeb() {
		return manageabilityFeb;
	}

	public void setManageabilityFeb(float manageabilityFeb) {
		this.manageabilityFeb = manageabilityFeb;
	}

	public float getManageabilityJan() {
		return manageabilityJan;
	}

	public void setManageabilityJan(float manageabilityJan) {
		this.manageabilityJan = manageabilityJan;
	}

	public float getManageabilityJuly() {
		return manageabilityJuly;
	}

	public void setManageabilityJuly(float manageabilityJuly) {
		this.manageabilityJuly = manageabilityJuly;
	}

	public float getManageabilityJune() {
		return manageabilityJune;
	}

	public void setManageabilityJune(float manageabilityJune) {
		this.manageabilityJune = manageabilityJune;
	}

	public float getManageabilityMarch() {
		return manageabilityMarch;
	}

	public void setManageabilityMarch(float manageabilityMarch) {
		this.manageabilityMarch = manageabilityMarch;
	}

	public float getManageabilityMay() {
		return manageabilityMay;
	}

	public void setManageabilityMay(float manageabilityMay) {
		this.manageabilityMay = manageabilityMay;
	}

	public float getManageabilityNov() {
		return manageabilityNov;
	}

	public void setManageabilityNov(float manageabilityNov) {
		this.manageabilityNov = manageabilityNov;
	}

	public float getManageabilityOct() {
		return manageabilityOct;
	}

	public void setManageabilityOct(float manageabilityOct) {
		this.manageabilityOct = manageabilityOct;
	}

	public float getManageabilitySept() {
		return manageabilitySept;
	}

	public void setManageabilitySept(float manageabilitySept) {
		this.manageabilitySept = manageabilitySept;
	}

	public float getProbabiltyApril() {
		return probabiltyApril;
	}

	public void setProbabiltyApril(float probabiltyApril) {
		this.probabiltyApril = probabiltyApril;
	}

	public float getProbabiltyAug() {
		return probabiltyAug;
	}

	public void setProbabiltyAug(float probabiltyAug) {
		this.probabiltyAug = probabiltyAug;
	}

	public float getProbabiltyDec() {
		return probabiltyDec;
	}

	public void setProbabiltyDec(float probabiltyDec) {
		this.probabiltyDec = probabiltyDec;
	}

	public float getProbabiltyFeb() {
		return probabiltyFeb;
	}

	public void setProbabiltyFeb(float probabiltyFeb) {
		this.probabiltyFeb = probabiltyFeb;
	}

	public float getProbabiltyJan() {
		return probabiltyJan;
	}

	public void setProbabiltyJan(float probabiltyJan) {
		this.probabiltyJan = probabiltyJan;
	}

	public float getProbabiltyJuly() {
		return probabiltyJuly;
	}

	public void setProbabiltyJuly(float probabiltyJuly) {
		this.probabiltyJuly = probabiltyJuly;
	}

	public float getProbabiltyJune() {
		return probabiltyJune;
	}

	public void setProbabiltyJune(float probabiltyJune) {
		this.probabiltyJune = probabiltyJune;
	}

	public float getProbabiltyMarch() {
		return probabiltyMarch;
	}

	public void setProbabiltyMarch(float probabiltyMarch) {
		this.probabiltyMarch = probabiltyMarch;
	}

	public float getProbabiltyMay() {
		return probabiltyMay;
	}

	public void setProbabiltyMay(float probabiltyMay) {
		this.probabiltyMay = probabiltyMay;
	}

	public float getProbabiltyNov() {
		return probabiltyNov;
	}

	public void setProbabiltyNov(float probabiltyNov) {
		this.probabiltyNov = probabiltyNov;
	}

	public float getProbabiltyOct() {
		return probabiltyOct;
	}

	public void setProbabiltyOct(float probabiltyOct) {
		this.probabiltyOct = probabiltyOct;
	}

	public float getProbabiltySept() {
		return probabiltySept;
	}

	public void setProbabiltySept(float probabiltySept) {
		this.probabiltySept = probabiltySept;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	public Risk getRisk() {
		return risk;
	}

	public void setRisk(Risk risk) {
		this.risk = risk;
	}

}
