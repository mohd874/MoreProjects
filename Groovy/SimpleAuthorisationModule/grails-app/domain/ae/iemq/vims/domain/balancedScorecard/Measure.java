package ae.iemq.vims.domain.balancedScorecard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Where;

import ae.iemq.vims.domain.BaseEntity;
import ae.iemq.vims.domain.Comment;
import ae.iemq.vims.domain.Employee;
import ae.iemq.vims.domain.Initiative;
import ae.iemq.vims.domain.LibraryItem;
import ae.iemq.vims.domain.MeasureLibraryItem;
import ae.iemq.vims.domain.Objective;
import ae.iemq.vims.util.BaseEntityCreateDateComparetor;
import ae.iemq.vims.util.DateUtil;

@SqlResultSetMappings( {
		@SqlResultSetMapping(name = "Measure.getPerformanceByYear", columns = {
				@ColumnResult(name = "performance"),
				@ColumnResult(name = "year") }),
		@SqlResultSetMapping(name = "Measure.getPerformancePerOrgUnit", columns = {
				@ColumnResult(name = "performance"),
				@ColumnResult(name = "orgUnit") }) })
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "measure")
@NamedQueries( { @NamedQuery(name = "Measure.measure", query = "from Measure order by create_dt desc")})
public class Measure extends BaseEntity {

	/** Logger. */
	private static Logger LOG = Logger.getLogger(Measure.class);

	/**
	 * serialVersionUID long.
	 */
	private static final long serialVersionUID = 20071224L;

	/** Ytd Formula enum. */
	public static enum YtdFormula {
		Summed, Averaged, LastCaptured
	};

	/** Target Prefix. */
	public static enum TargetPrefix {
		LessThan("Less Than"), LessThanAndEqual("Less Than OR Equal"), GreaterThan("Greater Than"), 
		GreaterThanAndEqual("Greater Than OR Equal"), Equal("Equal"), Range("Range"), 
		InversedRange("Inversed Range");
		
		private final String value;
		TargetPrefix(String value){
			this.value = value;
		}
		public String getValue(){
			return this.value;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return getValue();
		}
		/**
		 * return String[] representing the TargetPrefix enum
		 */
		public String[] getStringValues(){
			String [] values = new String[TargetPrefix.values().length];
			TargetPrefix[] enumValues = TargetPrefix.values();
			for(int i=0;i<enumValues.length;i++){
				values[i] = enumValues[i].getValue();
			}
			return values;
		}
		/**
		 * Convert the value into TargetPrefix enum
		 * @param TargetPrefix
		 */
		public TargetPrefix getTargetPrefixFromValue(String value){
			TargetPrefix[] enumValues = TargetPrefix.values();
			for(int i=0;i<enumValues.length;i++){
				if(enumValues[i].getValue() == value){
					return enumValues[i];
				}
			}
			return null;
		}
	}

	/** Category. */
	public static enum Category {
		NOCATEGORY(""), ROUTINE("Routine"),NONROUTINE("Non-Routine"),BUSINESSIMPROVEMENT("Business-Improvement"),CONTRACT("Contract");
		
		private final String value;
		Category(String value){
			this.value = value;
		}
		public String getValue(){
			return this.value;
		}
		/**
		 * return String[] representing the Category enum
		 */
		public String[] getStringValues(){
			String [] values = new String[Category.values().length];
			Category[] enumValues = Category.values();
			for(int i=0;i<enumValues.length;i++){
				values[i] = enumValues[i].getValue();
			}
			return values;
		}
	}
	/** ytdFormula String. */
	@Column(name = "ytd_formula")
	@Enumerated(EnumType.STRING)
	private YtdFormula ytdFormula;

	/** basePrefix String. */
	@Column(name = "base_prefix")
	@Enumerated(EnumType.STRING)
	private TargetPrefix basePrefix;

	/** stretchPrefix String. */
	@Column(name = "stretch_prefix")
	@Enumerated(EnumType.STRING)
	private TargetPrefix stretchPrefix;

	/** description String. */
	@Column(name = "description")
	private String description;

	/** weight int. */
	@Column(name = "weight")
	private int weight;

	/** measureCode String. */
	@Column(name = "measure_code")
	private String measureCode;

	/** unit String. */
	@Column(name = "unit")
	private String unit;

	/** frequency String. */
	@Column(name = "frequency")
	private String frequency;

	/** base String. */
	@Column(name = "base")
	private String base;

	/** stretch String. */
	@Column(name = "stretch")
	private String stretch;

	/** formula String. */
	@Column(name = "formula")
	private String formula;

	
	/** notes String. */
	@Column(name = "notes")
	private String notes;
	
	/** notes String. */
	@Column(name = "category")
	private String category;

	/** sources String. */
	@Column(name = "sources")
	private String sources;

	/** intent String. */
	@Column(name = "intent")
	private String intent;

	/** available String. */
	@Column(name = "available")
	private String available;

	/** authStatus boolean. */
	@Column(name = "auth_status")
	private boolean authStatus;

	/** associated Objective. */
	@JoinColumn(name = "objective", referencedColumnName = "id")
	@ManyToOne
	private Objective objective;

	/** associated Employee - Data Owner. */
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "data_owner", referencedColumnName = "id")
	@ManyToOne
	private Employee dataOwner;
	
	/** associated MeasurePeriod's - One MP per year. */
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy = "measure", fetch = FetchType.EAGER, cascade = {
			CascadeType.PERSIST, CascadeType.MERGE })
	@OrderBy("year")
	private Set<MeasurePeriod> periods;

	/**
	 * associated Initiatives.
	 * 
	 * @todo keep the initiative and comments at the period values level
	 */
	@OneToMany(mappedBy = "measure", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Initiative> initiatives;

	@OneToMany(mappedBy = "measure", fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@Where(clause="record_status='Active'") 
	private Set<Initiative> activeInitiatives;

	@OneToMany(mappedBy = "measure", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@Where(clause="record_status='Archive'") 
	private Set<Initiative> archiveInitiatives;

	/**
	 * associated MeasureLibraryItem's - supporting documents.
	 * 
	 * @todo think about moving to period value??
	 */
	@OneToMany(mappedBy = "measure", fetch = FetchType.EAGER)
	@Cascade({org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	private Set<LibraryItem> libraryItems;

	@OneToMany(mappedBy = "measure", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Where(clause="record_status='Active'")
		private Set<Comment> comments;

	@OneToMany(mappedBy = "measure", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Where(clause="record_status='Active'")
	private Set<Comment> activeComments;
	
	@OneToMany(mappedBy = "measure", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Where(clause="record_status='Archive'")
	private Set<Comment> archiveComments;

	
	/* This is the Measure Constructor*/
	public Measure(){
		LOG.debug("ABOUT TO CREATE A NEW MEASURE");
		setComments(new HashSet<Comment>());
		setActiveComments(new HashSet<Comment>());
		setArchiveComments(new HashSet<Comment>());
		setInitiatives(new HashSet<Initiative>());
		setYtdFormula(YtdFormula.Averaged);
		setBasePrefix(TargetPrefix.GreaterThanAndEqual);
		setStretchPrefix(TargetPrefix.GreaterThanAndEqual);
	}
	
	@Override
	public String toString() {
		return description;
	}

	/**
	 * @return the authStatus
	 */
	public boolean isAuthStatus() {
		return authStatus;
	}

	/**
	 * @param authStatus
	 *            the authStatus to set
	 */
	public void setAuthStatus(boolean authStatus) {
		this.authStatus = authStatus;
	}

	/**
	 * @return the available
	 */
	public String getAvailable() {
		return available;
	}

	/**
	 * @param available
	 *            the available to set
	 */
	public void setAvailable(String available) {
		this.available = available;
	}

	/**
	 * @return the base
	 */
	public String getBase() {
		return base;
	}

	/**
	 * @param base
	 *            the base to set
	 */
	public void setBase(String base) {
		this.base = base;
	}

	public TargetPrefix getBasePrefix() {
		if (basePrefix == null) {
			setBasePrefix(Measure.TargetPrefix.GreaterThanAndEqual);
		}
		return basePrefix;
	}

	public void setBasePrefix(TargetPrefix basePrefix) {
		this.basePrefix = basePrefix;
		if (LOG.isDebugEnabled()) {
			LOG.debug("formatted base prefix = "
					+ getFormattedStringPrefix(basePrefix));
		}
	}

	/**
	 * @return the dataOwner
	 */
	public Employee getDataOwner() {
		return dataOwner;
	}

	/**
	 * @param dataOwner
	 *            the dataOwner to set
	 */
	public void setDataOwner(Employee dataOwner) {
		this.dataOwner = dataOwner;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the formula
	 */
	public String getFormula() {
		return formula;
	}

	/**
	 * @param formula
	 *            the formula to set
	 */
	public void setFormula(String formula) {
		this.formula = formula;
	}

	/**
	 * @return the frequency
	 */
	public String getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency
	 *            the frequency to set
	 */
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	/**
	 * @return the initiatives
	 */
	public Set<Initiative> getInitiatives() {
		return initiatives;
	}

	/**
	 * @param initiatives
	 *            the initiatives to set
	 */
	public void setInitiatives(Set<Initiative> initiatives) {
		this.initiatives = initiatives;
	}

	/**
	 * @return the intent
	 */
	public String getIntent() {
		return intent;
	}

	/**
	 * @param intent
	 *            the intent to set
	 */
	public void setIntent(String intent) {
		this.intent = intent;
	}

	/**
	 * @return the libraryItems
	 */
	public Set<LibraryItem> getLibraryItems() {
		return libraryItems;
	}

	/**
	 * @param libraryItems
	 *            the libraryItems to set
	 */
	public void setLibraryItems(Set<LibraryItem> libraryItems) {
		this.libraryItems = libraryItems;
	}

	/**
	 * @return the measureCode
	 */
	public String getMeasureCode() {
		return (getObjective().getCode() + "/M" + measureCode);
	}

	/**
	 * @param measureCode
	 *            the measureCode to set
	 */
	public void setMeasureCode(String measureCode) {
		this.measureCode = measureCode;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes
	 *            the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @return the objective
	 */
	public Objective getObjective() {
		return objective;
	}

	/**
	 * @param objective
	 *            the objective to set
	 */
	public void setObjective(Objective objective) {
		this.objective = objective;
	}

	/**
	 * @return the periods
	 */
	public Set<MeasurePeriod> getPeriods() {
		return periods;
	}

	/**
	 * @param periods
	 *            the periods to set
	 */
	public void setPeriods(Set<MeasurePeriod> periods) {
		this.periods = periods;
	}

	/**
	 * @return the sources
	 */
	public String getSources() {
		return sources;
	}

	/**
	 * @param sources
	 *            the sources to set
	 */
	public void setSources(String sources) {
		this.sources = sources;
	}

	/**
	 * @return the stretch
	 */
	public String getStretch() {
		return stretch;
	}

	/**
	 * @param stretch
	 *            the stretch to set
	 */
	public void setStretch(String stretch) {
		this.stretch = stretch;
	}

	public TargetPrefix getStretchPrefix() {
		if (stretchPrefix == null) {
			setStretchPrefix(Measure.TargetPrefix.GreaterThanAndEqual);
		}
		return stretchPrefix;
	}

	public void setStretchPrefix(TargetPrefix stretchPrefix) {
		this.stretchPrefix = stretchPrefix;
		if (LOG.isDebugEnabled()) {
			LOG.debug("formatted stretch prefix = "
					+ getFormattedStringPrefix(stretchPrefix));
		}
	}

	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @param unit
	 *            the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the ytdFormula
	 */
	public YtdFormula getYtdFormula() {
		return ytdFormula;
	}

	/**
	 * @param ytdFormula
	 *            the ytdFormula to set
	 */
	public void setYtdFormula(YtdFormula ytdFormula) {
		this.ytdFormula = ytdFormula;
	}

	// ********************** helper methods ********************* //

	/**
	 * @param period
	 *            the periods to add
	 */
	public void addPeriod(MeasurePeriod period) {
		if (periods == null)
			periods = new LinkedHashSet<MeasurePeriod>();
		else if (periods.contains(period)) {
			LOG.debug("About to replace existing measure meriod for year -->" + DateUtil.getMonthName(period.getYear()));
			periods.remove(period);
		}
		periods.add(period);
	}

	public boolean hasMeasurePeriodForYear(int year) {
		for (MeasurePeriod measurePeriod : periods)
			if (measurePeriod.getYear() == year)
				return true;

		return false;
	}

	/**
	 * This method calculates the Actual YTD value.
	 */
	public float calculateActualYtd(MeasurePeriod measurePeriod) {

		float actualYtd = getYtdValueForYtdFormula(getActualYtdValues(measurePeriod));
		LOG.debug("*** MEASURE *** --> calculateActualYtd -->" + actualYtd);
		return actualYtd;
	}

	private ArrayList<Float> getActualYtdValues(MeasurePeriod measurePeriod) {

		ArrayList<Float> arrayList = new ArrayList<Float>();
		TreeMap<Integer, Float> actualMap = (TreeMap<Integer, Float>) measurePeriod
				.getActualDataMap();
		for (Integer key : actualMap.keySet()) {
			arrayList.add(actualMap.get(key));
		}
		return arrayList;
	}

	/**
	 * This method calculates the Target YTD value.
	 */
	public float calculateTargetYtd(MeasurePeriod measurePeriod) {

		float targetYtd = getYtdValueForYtdFormula(getTargetYtdValues(measurePeriod));
		LOG.debug("*** MEASURE *** --> calculateTargetYtd -->" + targetYtd);
		return targetYtd;
	}

	private ArrayList<Float> getTargetYtdValues(MeasurePeriod measurePeriod) {

		ArrayList<Float> arrayList = new ArrayList<Float>();
		TreeMap<Integer, Float> targetMap = (TreeMap<Integer, Float>) measurePeriod
				.getTargetDataMap();
		int lastActualMonth = getLatestActualMonth(measurePeriod);
		for (Integer key : targetMap.keySet()) {
			if (key <= lastActualMonth) {
				arrayList.add(targetMap.get(key));
			}
		}
		return arrayList;
	}
	
	/**
	 * This method returns the latest actual month. Used to work out the
	 * responding target values when calculating the YTD totals.
	 * 
	 * @return
	 */
	private int getLatestActualMonth(MeasurePeriod measurePeriod) {
		int latestMonth = 0;
		for (Integer months : measurePeriod.getActualDataMap().keySet()) {
			if (months.intValue() > latestMonth) {
				latestMonth = months.intValue();
			}
		}
		return latestMonth;
	}

	public float getYtdValueForYtdFormula(final ArrayList<Float> values) {
		
		return getYtdValueForYtdFormula(values, getYtdFormula());
	}
	
	public float getYtdValueForYtdFormula(final ArrayList<Float> values, YtdFormula ytdFormula) {
		if (ytdFormula == null) {
			return 0;
		}
		switch (ytdFormula) {
		case Summed:
			return calculateSummed(values);
		case Averaged:
			if (values.size() == 0) {
				return 0;
			} else {
				return (calculateSummed(values) / (values.size()));
			}
		case LastCaptured:
			if (values.size() > 0) {
				return values.get(values.size() - 1);
			}
		}
		return 0;
	}

	/**
	 * This method calculates the summed total of the measurement values. Period
	 * frequency doesn't effect the result.
	 * 
	 * @param values
	 * @return
	 */
	public float calculateSummed(final ArrayList<Float> values) {

		float total = 0;
		for (Float f : values) {
			total = total + f;
		}

		return total;
	}

	/**
	 * This method will return the MeasurePeriod for a given year.
	 * 
	 * @param year
	 * @return
	 */
	public MeasurePeriod getMeasurePeriodByYear(String year) {
		try {
			int IntegerYear = Integer.parseInt(year);
			return getMeasurePeriodByYear(IntegerYear);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * This method will return the MeasurePeriod for a given year.
	 * 
	 * @param year
	 * @return
	 */
	public MeasurePeriod getMeasurePeriodByYear(int year) {
		MeasurePeriod measurePeriod = null;
		if (periods != null) {
			for (MeasurePeriod mp : periods) {
				if (mp == null) {
					LOG.debug("MEASURE PERIOD IS NULL!!");
				} else {
					LOG.debug("measure period is not null!!");
					LOG.debug("description -->" + mp.getYear());
					if (mp.getYear() == year) {
						measurePeriod = mp;
					}
				}

			}
		}
		return measurePeriod;
	}

	public void generateMeasureCode() {

		setMeasureCode(String.valueOf(getObjective().getMeasures().size()));
	}

	public String getFormattedStringPrefix(TargetPrefix enumPrefix) {
		String stringPrefix = null;
		switch (enumPrefix) {
		case LessThan:
			stringPrefix = "<";
			break;
		case LessThanAndEqual:
			stringPrefix = "<=";
			break;
		case GreaterThan:
			stringPrefix = ">";
			break;
		case GreaterThanAndEqual:
			stringPrefix = ">=";
			break;
		case Range:
			stringPrefix = ">=<";
			break;
		case InversedRange:
			stringPrefix = "<=>";
			break;
		default:
			stringPrefix = "NONE";
		}
		return stringPrefix;
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
			this.comments.add(comment);
			this.activeComments.add(comment);
		}
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

}