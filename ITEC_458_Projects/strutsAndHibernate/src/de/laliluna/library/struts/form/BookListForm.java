//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.4/xslt/JavaClass.xsl

package de.laliluna.library.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import de.laliluna.library.Book;

/**
 * MyEclipse Struts Creation date: 07-27-2005
 * 
 * XDoclet definition:
 * 
 * @struts:form name="bookListForm"
 */
public class BookListForm extends ActionForm {

	private Book[] book = new Book[0];

	/**
	 * @return Returns the book.
	 */
	public Book[] getBooks() {
		return book;
	}

	/**
	 * @param book
	 *          The book to set.
	 */
	public void setBooks(Book[] bookValues) {
		this.book = bookValues;
	}

	/**
	 * Method reset
	 * 
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		book = new Book[0];
	}

}
