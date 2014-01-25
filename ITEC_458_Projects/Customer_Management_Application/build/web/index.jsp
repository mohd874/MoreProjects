<%-- 
    Document   : index
    Created on : Mar 17, 2008, 5:50:29 PM
    Author     : Saeed
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers List</title>
    </head>
    <body>
        <table border='1' cellspacing='2' width='50%'>
            <tr>
                <td colspan='3'>Customer List</td>
            </tr>
            <tr>
                <td>ID</td>
                <td>First Name</td>
                <td>Last Name</td>
            </tr>
            <c:forEach var="customer" items="${customers}">
                <tr>
                    <c:url var="url" value="/custmanager">
                        <c:param name="action" value="displayCustomer" />
                        <c:param name="id" value="${customer.id}" />
                    </c:url>
                    <td>
                        <a href="${url}">${customer.id}</a>
                    </td>
                    <td>
                        ${customer.firstName}
                    </td>
                    <td>
                        ${customer.lastName}
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
