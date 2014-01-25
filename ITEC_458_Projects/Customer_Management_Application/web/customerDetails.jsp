<%-- 
    Document   : customerDetails
    Created on : Mar 17, 2008, 7:20:03 PM
    Author     : Saeed
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Details</title>
    </head>
    <body>
        <table border="1" width="30%" cellspacing="2">
            <tr>
                <td colspan="2">
                    Customer: ${customer.firstName} ${customer.lastName}
                </td>
                
            </tr>
            <tr>
                <td>ID</td>
                <td>${customer.id}</td>
            </tr>
            <tr>
                <td>First Name</td>
                <td>${customer.firstName}</td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td>${customer.lastName}</td>
            </tr>
            <tr>
                <c:url var="localURL" value="custmanager">
                    <c:param name="action" value="edit" />
                    <c:param name="id" value="${customer.id}" />
                </c:url>
                <td colspan="2">
                    <a href="${localURL}">Edit Customer</a>
                </td>
            </tr>
        </table>
    </body>
</html>
