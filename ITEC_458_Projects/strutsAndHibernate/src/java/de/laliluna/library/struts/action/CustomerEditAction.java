//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.4/xslt/JavaClass.xsl

package de.laliluna.library.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import de.laliluna.library.bl.LibraryManager;
import de.laliluna.library.struts.form.CustomerEditForm;

/**
 * MyEclipse Struts Creation date: 07-27-2005
 * 
 * XDoclet definition:
 * 
 * @struts:action path="/customerEdit" name="customerEditForm"
 *                input="/jsp/customerEdit.jsp" parameter="do" scope="request"
 * @struts:action-forward name="customerList" path="/customerList.do"
 *                        redirect="true"
 * @struts:action-forward name="addCustomer" path="/jsp/editCustomer.jsp"
 * @struts:action-forward name="editCustomer" path="/jsp/editCustomer.jsp"
 */
public class CustomerEditAction extends DispatchAction {

	// --------------------------------------------------------- Instance
	// Variables

	// --------------------------------------------------------- Methods

	/**
	 * loads customer from the db and forwards to the edit form
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward prepareEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		CustomerEditForm customerEditForm = (CustomerEditForm) form;

		Integer id = Integer.valueOf(request.getParameter("id"));
		LibraryManager libraryManager = new LibraryManager();

		customerEditForm.setCustomer(libraryManager.getCustomerByPrimaryKey(id));

		return mapping.findForward("editCustomer");
	}

	/**
	 * prepares the add form (actually only forwards to it)
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward prepareAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("editCustomer");

	}

	/**
	 * saves the customers and forwards to the list
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward saveCustomer(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		CustomerEditForm customerEditForm = (CustomerEditForm) form;
		LibraryManager libraryManager = new LibraryManager();
		libraryManager.saveCustomer(customerEditForm.getCustomer());

		return mapping.findForward("customerList");
	}

	/**
	 * deletes the customers and forwards to the list
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward deleteCustomer(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		CustomerEditForm customerEditForm = (CustomerEditForm) form;
		LibraryManager libraryManager = new LibraryManager();
		libraryManager.removeCustomerByPrimaryKey(customerEditForm.getCustomer()
				.getId());

		return mapping.findForward("customerList");
	}
}
