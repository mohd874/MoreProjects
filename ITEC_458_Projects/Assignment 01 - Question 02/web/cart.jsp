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
        <%@ include file="WEB-INF/jspf/header.jspf" %>
        <fieldset>
            <legend>&nbsp;&nbsp;You Shopping cart&nbsp;&nbsp;</legend>
            <c:if test="${cart.count > 0}">
                <table border="0" cellpadding="5" >
                    <tr>
                        <th align="left">Item</th>
                        <th align="left">Quantity</th>
                        <th align="right">Unit Price</th>
                        <th align="right">Sub Total</th>
                        <th>&nbsp;</th>
                    </tr>
                    
                    <c:forEach var="item" items="${cart.items}">
                        <tr valign="top">
                            <td>
                                ${item.product.description}
                            </td>
                            <td>
                                <form action="<c:url value='/cart' />">
                                    <input type="hidden" name="productCode" value="${item.product.code}">
                                    <input type="text" size="2" name="quantity" value="${item.quentity}">
                                    <input type="submit" name="action" value="Update" />
                                </form>
                            </td>
                            <td align="right">${item.product.currencyFormattedPrice}</td>
                            <td align="right">${item.currencyFormattedPrice}</td>
                            <td>
                                <form action="<c:url value='/cart' />">
                                    <input type="hidden" name="productCode" value="${item.product.code}">
                                    <input type="hidden" name="quantity" value="0">
                                    <input type="submit" name="action" value="Remove Item" />
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="5">
                            
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            
                        </td>
                        <td align="right">
                            <b>Total:</b>
                        </td>
                        <td align="right">
                            <b>${cart.grandTotal}</b>
                        </td>
                        <td>
                            
                        </td>
                    </tr>
                </table>
            </c:if>
            <c:if test="${cart.count == 0}">
                Your shopping cart is empty
            </c:if>
        </fieldset>
        <br />
        <a href="<c:url value='/index.jsp' />">Return to shopping</a>
        <%--
        <form action="<c:url value='/checkout.jsp' />" method="post">
            <input type="submit" value="Checkout">
        </form>
        --%>
        
    </body>
</html>
