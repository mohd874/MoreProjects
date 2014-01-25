//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.4/xslt/JavaClass.xsl

package de.laliluna.library.struts.form;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import de.laliluna.library.Customer;

/** 
 * MyEclipse Struts
 * Creation date: 07-27-2005
 * 
 * XDoclet definition:
 * @struts:form name="customerEditForm"
 */
public class CustomerEditForm extends ActionForm {

	// --------------------------------------------------------- Instance Variables
	private Customer customer;
	// --------------------------------------------------------- Methods

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public boolean equals(Object rhs) {
		return customer.equals(rhs);
	}

	public Integer getAge() {
		return customer.getAge();
	}

	public Integer getId() {
		return customer.getId();
	}

	public String getLastname() {
		return customer.getLastname();
	}

	public String getFirstname() {
		return customer.getFirstname();
	}

	public int hashCode() {
		return customer.hashCode();
	}

	public void setAge(Integer age) {
		customer.setAge(age);
	}

	public void setId(Integer id) {
		customer.setId(id);
	}

	public void setLastname(String lastname) {
		customer.setLastname(lastname);
	}

	public void setFirstname(String firstName) {
		customer.setFirstname(firstName);
	}

	public Set getBooks() {
		return customer.getBooks();
	}

	public void setBooks(Set books) {
		customer.setBooks(books);
	}

	public String toString() {
		return customer.toString();
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {

		customer = new Customer();
	}

}

