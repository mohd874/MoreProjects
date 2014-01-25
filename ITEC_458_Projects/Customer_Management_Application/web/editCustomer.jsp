<%-- 
    Document   : editCustomer
    Created on : Mar 17, 2008, 6:30:28 PM
    Author     : Saeed
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Customer Details</title>
    </head>
    <body>
        <form method="post" action="<c:url value='/custmanager' />">
            <table border="1" width="40%" cellspacing="2" >
                <input type="hidden" name="id" value="${customer.id}">
                <tr>
                    <td colspan="2">Customer ID: ${customer.id}</td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td>
                    <input type="text" name="firstName" value="${customer.firstName}"
                           </td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td>
                    <input type="text" name="lastName" value="${customer.lastName}"
                           </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="    Save    ">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>