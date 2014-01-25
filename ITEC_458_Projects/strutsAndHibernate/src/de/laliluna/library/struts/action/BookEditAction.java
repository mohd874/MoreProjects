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
import de.laliluna.library.struts.form.BookEditForm;

/** 
 * MyEclipse Struts
 * Creation date: 07-27-2005
 * 
 * XDoclet definition:
 * @struts:action path="/bookEdit" name="bookEditForm" input="/jsp/bookEdit.jsp" parameter="do" scope="request" validate="true"
 * @struts:action-forward name="showBorrow" path="/jsp/borrowBook.jsp"
 * @struts:action-forward name="showEdit" path="/jsp/bookEdit.jsp"
 * @struts:action-forward name="showList" path="/bookList.do" redirect="true"
 * @struts:action-forward name="showAdd" path="/jsp/bookAdd.jsp"
 */
	public class BookEditAction extends DispatchAction {
    /** 
     * loads the book specified by the id from the database and forwards to the edit form
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     */
    public ActionForward editBook(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) {
      System.out.println("editBook");
            BookEditForm bookEditForm = (BookEditForm) form;
            
            /* lalinuna.de 04.11.2004
             * get id of the book from request
             */
            Integer id = Integer.valueOf(request.getParameter("id"));
                    // [laliluna] 28.11.2004  get business logic
            LibraryManager libraryManager = new LibraryManager();
            bookEditForm.setBook(libraryManager.getBookByPrimaryKey(id));
            return mapping.findForward("showEdit");
    }
    
    /** 
     * loads a book from the db and forwards to the borrow book form
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     */
    public ActionForward borrowBook(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) {
      System.out.println("borrowBook");
            
      BookEditForm bookEditForm = (BookEditForm) form;
            
            /* lalinuna.de 04.11.2004
             * get id of the book from request
             */
            Integer id = Integer.valueOf(request.getParameter("id"));
            
            /* lalinuna.de 16.11.2004
             * load the session facade for book and user 
             * get the book information and get all users
             */
            LibraryManager libraryManager = new LibraryManager();
            
            // [laliluna] 28.11.2004 save book in the form
            bookEditForm.setBook(libraryManager.getBookByPrimaryKey(id));
            // [laliluna] 28.11.2004 save customers in the reqest
            request.setAttribute("customers", libraryManager.getAllCustomers());
                    
            return mapping.findForward("showBorrow");
    }
    
    /** 
     * return a book from a customer
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     */
    public ActionForward returnBook(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) {
      System.out.println("returnBook");
            
      BookEditForm bookEditForm = (BookEditForm) form;
            
            /* lalinuna.de 04.11.2004
             * get id of the book from request
             */
            Integer id = Integer.valueOf(request.getParameter("id"));
            
            // [laliluna] 28.11.2004 get business logic
            LibraryManager libraryManager = new LibraryManager();
            
            libraryManager.returnBook(id);
            
            return mapping.findForward("showList");
    }
    
    /** 
     * deletes a book from the database
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     */
    public ActionForward deleteBook(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) {
      System.out.println("deleteBook");
            
      BookEditForm bookEditForm = (BookEditForm) form;
            
            /* lalinuna.de 04.11.2004
             * get id of the book from request
             */
            Integer id = Integer.valueOf(request.getParameter("id"));
            
            // [laliluna] 28.11.2004 get business logic
            LibraryManager libraryManager = new LibraryManager();
            
            libraryManager.removeBookByPrimaryKey(id);
            
            return mapping.findForward("showList");
    }
    /** 
     * forwards to the add book form
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     */
    public ActionForward addBook(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) {
      System.out.println("addBook");
            
      BookEditForm bookEditForm = (BookEditForm) form;
            
            return mapping.findForward("showAdd");
            
    }
    
    /** 
     * saves the borrow assigned in the form in the database
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     */
    public ActionForward saveBorrow(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) {
            BookEditForm bookEditForm = (BookEditForm) form;
            
            // [laliluna] 28.11.2004 get business logc
            LibraryManager libraryManager = new LibraryManager();
            libraryManager.borrowBook(bookEditForm.getId(), bookEditForm.getCustomerId());
            
            return mapping.findForward("showList");
    }
    
    /** 
     * updates or creates the book in the database
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     */
    public ActionForward saveBook(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) {
            BookEditForm bookEditForm = (BookEditForm) form;
            
            // [laliluna] 28.11.2004 get business logic
            LibraryManager libraryManager = new LibraryManager();
            libraryManager.saveBook(bookEditForm.getBook());
            return mapping.findForward("showList");
    }

}

