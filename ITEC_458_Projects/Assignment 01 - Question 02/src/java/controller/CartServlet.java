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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Saeed
 */
public class CartServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        String action = req.getParameter("action");
        String url = "/index.jsp";

        ServletContext sc = getServletContext();
        String productsFilePath = sc.getRealPath("/WEB-INF/products.txt");

        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        if (action == null) {
            displayItems(req, ProductIO.CATEGORY_SYSTEMS);
        } else if ("Update".equalsIgnoreCase(action) || "Remove Item".equalsIgnoreCase(action)) {
            updateCart(req, cart);
            url = "/cart.jsp";
        } else if ("displayItems".equalsIgnoreCase(action)) {
            displayItems(req);
        }

        req.getRequestDispatcher(url).forward(req, resp);
    }

    private void displayItems(HttpServletRequest req) {
        String category = req.getParameter("category");
        displayItems(req, category);
    }

    private void displayItems(HttpServletRequest req, String category) {
        ServletContext sc = getServletContext();
        String productsFilePath = sc.getRealPath("/WEB-INF/products.txt");

        List<Product> productsList = ProductIO.getProductsByCategory(category, productsFilePath);
        req.setAttribute("productsList", productsList);
        req.setAttribute("category", category);
    }

    private void updateCart(HttpServletRequest req, Cart cart) {
        ServletContext sc = getServletContext();
        String productsFilePath = sc.getRealPath("/WEB-INF/products.txt");
        
            String productCode = req.getParameter("productCode");
            String quantityString = req.getParameter("quantity");

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

            Product product = ProductIO.getProductByCode(productCode, productsFilePath);

            LineItem lineItem = new LineItem();
            lineItem.setProduct(product);
            lineItem.setQuentity(quantity);
            if (quantity > 0) {
                cart.addItem(lineItem);
            } else if (quantity == 0) {
                cart.removeItem(lineItem);
            }
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
