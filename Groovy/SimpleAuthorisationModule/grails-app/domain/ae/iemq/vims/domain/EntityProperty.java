package ae.iemq.vims.domain;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "entity_property")
@NamedQueries( {
		@NamedQuery(name = "EntityProperty.keyEquals", query = "from EntityProperty p where p.key like :key order by p.value"),
		@NamedQuery(name = "EntityProperty.all", query = "from EntityProperty p order by p.createDateTime desc"),
		@NamedQuery(name = "EntityProperty.distinctKey", query = "select p.key from EntityProperty p group by p.key")})
public class EntityProperty extends BaseEntity{

	
	@Column(name = "property_key")
	private String key;

	@Column(name = "property_value")
	private String value;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
