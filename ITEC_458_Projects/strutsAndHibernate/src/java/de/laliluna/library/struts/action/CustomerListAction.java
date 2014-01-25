//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.4/xslt/JavaClass.xsl

package de.laliluna.library.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import de.laliluna.library.bl.LibraryManager;
import de.laliluna.library.struts.form.CustomerListForm;

/** 
 * MyEclipse Struts
 * Creation date: 07-27-2005
 * 
 * XDoclet definition:
 * @struts:action path="/custeromList" name="custeromListForm" input="/jsp/custeromList.jsp" scope="request"
 * @struts:action-forward name="showCustomerList" path="/jsp/customerList.jsp"
 */
public class CustomerListAction extends Action {

	// --------------------------------------------------------- Instance Variables

	// --------------------------------------------------------- Methods

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) {
		CustomerListForm custeromListForm = (CustomerListForm) form;
    CustomerListForm customerListForm = (CustomerListForm) form;
    // [laliluna] 29.11.2004 get business logic
    LibraryManager libraryManager = new LibraryManager();
    
    customerListForm.setCustomers(libraryManager.getAllCustomers());
    return mapping.findForward("showCustomerList");
	}

}

