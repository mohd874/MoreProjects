<%-- 
    Document   : index
    Created on : Mar 12, 2008, 6:41:01 PM
    Author     : Saeed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
    </head>
    <body>
        <h1>Your cart</h1>
        
        <table border="1" cellpadding="5">
            <thead>
            <tr>
                <th>Quantity</th>
                <th>Description</th>
                <th>Price</th>
                <th>Amount</th>
                <th>&nbsp;</th>
            </tr>
            
            <c:forEach var="item" items="${cart.items}">
                <tr valign="top">
                    <td>
                        <form action="<c:url value='/cart' />">
                            <input type="hidden" name="productCode" value="${item.product.code}">
                            <input type="text" size="2" name="quentity" value="${item.quentity}">
                            <input type="submit" value="Update" />
                        </form>
                    </td>
                    <td>${item.product.description}</td>
                    <td>${item.product.currencyFormattedPrice}</td>
                    <td>${item.currencyFormattedPrice}</td>
                    <td>
                        <form action="<c:url value='/cart' />">
                            <input type="hidden" name="productCode" value="${item.product.code}">
                            <input type="hidden" name="quentity" value="0">
                            <input type="submit" value="Remove Item" />
                        </form>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="5">
                    <p><b>To change the quantity</b>, enter the new quantity and click on the Update button.</p>
                </td>
            </tr>
        </table>
        
        <br />
        
        <form action="<c:url value='/index.jsp' />" method="post">
            <input type="submit" value="Continue Shopping">
        </form>
        
        <form action="<c:url value='/checkout.jsp' />" method="post">
            <input type="submit" value="Checkout">
        </form>
        
    </body>
</html>
