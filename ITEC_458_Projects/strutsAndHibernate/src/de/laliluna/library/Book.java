/*
 * Created Wed Dec 21 00:12:14 CET 2005 by MyEclipse Hibernate Tool.
 */ 
package de.laliluna.library;

import java.io.Serializable;

/**
 * A class that represents a row in the 'book' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Book
    extends AbstractBook
    implements Serializable
{
	
	private Customer customer; 
    @Override
	public String toString() {
		
		return "Book:  " + getId()+" title: "+getTitle()+" author: "+getAuthor() + " borrowed to: "+getCustomer(); 
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
     * Simple constructor of Book instances.
     */
    public Book()
    {
    }

    /**
     * Constructor of Book instances given a simple primary key.
     * @param id
     */
    public Book(java.lang.Integer id)
    {
        super(id);
    }

    /* Add customized code below */

}
