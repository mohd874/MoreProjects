//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.4/xslt/JavaClass.xsl

package de.laliluna.library.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import de.laliluna.library.Customer;

/** 
 * MyEclipse Struts
 * Creation date: 07-27-2005
 * 
 * XDoclet definition:
 * @struts:form name="custeromListForm"
 */
public class CustomerListForm extends ActionForm {

	 private Customer[] customers;
	 /**
	 * @return Returns the customers.
	 */
	 public Customer[] getCustomers() {
	  return customers;
	 }
	 /**
	 * @param customers The customers to set.
	 */
	 public void setCustomers(Customer[] customers) {
	  this.customers = customers;
	 }
	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {

		customers = new Customer[0];
	}

}

