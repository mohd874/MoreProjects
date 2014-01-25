//Created by MyEclipse Struts
//XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.4/xslt/JavaClass.xsl

package de.laliluna.library.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import de.laliluna.library.Book;
import de.laliluna.library.Customer;

/**
 * MyEclipse Struts Creation date: 07-27-2005
 * 
 * XDoclet definition:
 * 
 * @struts:form name="bookEditForm"
 */
public class BookEditForm extends ActionForm {

	// --------------------------------------------------------- Instance
	// Variables
	private Integer customerId;

	private Book book;

	public String getAuthor() {
		return book.getAuthor();
	}

	public Boolean getBorrowallowed() {
		return book.getBorrowallowed();
	}

	public Customer getCustomer() {
		return book.getCustomer();
	}

	public Integer getId() {
		return book.getId();
	}

	public String getTitle() {
		return book.getTitle();
	}

	public void setAuthor(String author) {
		book.setAuthor(author);
	}

	public void setBorrowallowed(Boolean borrowallowed) {
		book.setBorrowallowed(borrowallowed);
	}

	public void setCustomer(Customer customer) {
		book.setCustomer(customer);
	}

	public void setId(Integer id) {
		book.setId(id);
	}

	public void setTitle(String title) {
		book.setTitle(title);
	}

	// --------------------------------------------------------- Methods
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		book =new Book();
		book.setBorrowallowed(false);
	}
}
