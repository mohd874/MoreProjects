/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import business.*;
import dao.*;

/**
 *
 * @author Saeed
 */
public class CartServlet extends HttpServlet{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String productCode = request.getParameter("productCode");
        String quantityString = request.getParameter("quentity");
        
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        
        //if the user enters a negative or invalid quantity,
        //the quantity is automatically reset to 1.
        int quantity = 1;
        try {
            quantity = Integer.parseInt(quantityString);
            if (quantity < 0) {
                quantity = 1;
            }
        } catch (NumberFormatException nfe) {
            quantity = 1;
        }
        
        ServletContext sc = getServletContext();
        String path = sc.getRealPath("/WEB-INF/products.txt");
        Product product = ProductIO.getProduct(productCode, path);
        
        LineItem lineItem = new LineItem();
        lineItem.setProduct(product);
        lineItem.setQuentity(quantity);
        if (quantity > 0) {
            cart.addItem(lineItem);
        } else if (quantity == 0) {
            cart.removeItem(lineItem);
        }
        
        String url = "/cart.jsp";
        request.getRequestDispatcher(url).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
    * Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
