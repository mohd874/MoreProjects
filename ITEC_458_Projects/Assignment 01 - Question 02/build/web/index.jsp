<%-- 
    Document   : index
    Created on : Mar 10, 2008, 5:57:12 PM
    Author     : Saeed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="dao.ProductIO"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bin Batota Mall</title>
    </head>
    <body>
        <c:if test="${productsList == null}">
            <jsp:forward page="/cart" />
        </c:if>
        <%@ include file="WEB-INF/jspf/header.jspf" %>
        <table border="0" width="100%">
            <tr>
                <td>
                    <li>
                        <c:url var="url" value="/cart" >
                            <c:param name="action" value="displayItems"/>
                            <c:param name="category" value="System"/>
                        </c:url>
                        <a href="${url}">Systems</a>
                    </li>
                    <li>
                        <c:url var="url" value="/cart" >
                            <c:param name="action" value="displayItems"/>
                            <c:param name="category" value="Software"/>
                        </c:url>
                        <a href="${url}">Software</a>
                    </li>
                    <li>
                        <c:url var="url" value="/cart" >
                            <c:param name="action" value="displayItems"/>
                            <c:param name="category" value="Books"/>
                        </c:url>
                        <a href="${url}">Books</a>
                    </li>
                </td>
                <td>
                    <fieldset>
                        <legend>&nbsp;&nbsp;${category}&nbsp;&nbsp;</legend>
                        <table>
                            <tr>
                                <th align="left">Product</th>
                                <th align="left"></th>
                                <th align="left">Price</th>
                                <th align="left"></th>
                            </tr>
                            <c:forEach items="${productsList}" var="product">
                                <c:url var="url" value="/cart">
                                    <c:param name="action" value="Update"/>
                                    <c:param name="productCode" value="${product.code}"/>
                                </c:url>
                                <tr>
                                    <td>${product.description}</td>
                                    <td></td>
                                    <td>${product.currencyFormattedPrice}</td>
                                    <td></td>
                                    <td><a href="${url}">Add to Cart</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </fieldset>
                </td>
                
            </tr>
            
        </table>
    </body>
</html>
