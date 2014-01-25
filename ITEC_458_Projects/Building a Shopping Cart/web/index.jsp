<%-- 
    Document   : index
    Created on : Mar 10, 2008, 5:57:12 PM
    Author     : Saeed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E-Store</title>
    </head>
    <body>
        <h2>CD list</h2>
        <table border="1">
            <tr>
                <td align="left">Description</td>
                <td align="left">Price</td>
                <td align="left">&nbsp;</td>
            </tr>
            <tr>
                <td>86 (the band) - True Life Songs and Pictures</td>
                <td>$14.95</td>
                <td><a href="<c:url value='/cart?productCode=8601' />">Add To Cart</a></td>
            </tr>
            <tr>
                <td>Paddlefoot - The first CD</td>
                <td>$12.95</td>
                <td><a href="<c:url value='/cart?productCode=pf01' />">Add To Cart</a></td>
            </tr>
            <tr>
                <td>Paddlefoot - The seconf CD</td>
                <td>$14.95</td>
                <td><a href="<c:url value='/cart?productCode=pf02' />">Add To Cart</a></td>
            </tr>
            <tr>
                <td>Joe Rut - Genuine Wood Graind Finish</td>
                <td>$14.95</td>
                <td><a href="<c:url value='/cart?productCode=jr01' />">Add To Cart</a></td>
            </tr>
        </table>
    </body>
</html>
