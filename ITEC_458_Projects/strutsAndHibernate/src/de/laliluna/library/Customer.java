/*
 * Created Wed Dec 21 00:12:18 CET 2005 by MyEclipse Hibernate Tool.
 */
package de.laliluna.library;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A class that represents a row in the 'customer' table. This class may be
 * customized as it is never re-generated after being created.
 */
public class Customer extends AbstractCustomer implements Serializable {

	private Set books;

	/**
	 * Simple constructor of Customer instances.
	 */
	public Customer() {
		books = new HashSet();
	}

	/**
	 * Constructor of Customer instances given a simple primary key.
	 * 
	 * @param id
	 */
	public Customer(java.lang.Integer id) {
		super(id);
		books = new HashSet();
	}

	public Set getBooks() {
		return books;
	}

	public void setBooks(Set books) {
		this.books = books;
	}

	/* Add customized code below */
	@Override
	public String toString() {

		return "Customer  " + getId() + " firstname: " + getFirstname()
				+ " lastname: " + getLastname();
	}

}
