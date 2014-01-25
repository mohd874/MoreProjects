package ae.iemq.vims.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
@Entity
@Table(name = "library_folder")
@NamedQueries( {
	@NamedQuery(name = "LibraryFolder.byId", query = "from LibraryFolder f where f.id = :id order by description")
})
public class LibraryFolder extends BaseEntity {

	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "folder", fetch = FetchType.LAZY, cascade = {
			CascadeType.PERSIST, CascadeType.ALL })
//	@org.hibernate.annotations.OrderBy(clause="project")
	private Set<LibraryItem> LibraryItems;

	
	@Override
	public String toString() {
		return description;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the libraryItems
	 */
	public Set<LibraryItem> getLibraryItems() {
		return LibraryItems;
	}


	/**
	 * @param libraryItems the libraryItems to set
	 */
	public void setLibraryItems(Set<LibraryItem> libraryItems) {
		LibraryItems = libraryItems;
	}

}
