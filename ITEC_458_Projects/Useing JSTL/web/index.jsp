<%-- 
    Document   : index
    Created on : Feb 27, 2008, 4:59:35 PM
    Author     : Saeed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.List;"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Calculator</title>
    </head>
    <body>
        <h1>Simple Calculator</h1>
        
        <form action="calc" method="post">
            A:<input type="text" name="txtA" value="${a}"/><br/>
            B:<input type="text" name="txtB" value="${b}"/>
            
            <br/>
            <br/>
            
            <input type="radio" name="rdOperation" value="add" ${c[0]} />Add
            <input type="radio" name="rdOperation" value="subtract" ${c[1]} />Subtract
            <input type="radio" name="rdOperation" value="multiply" ${c[2]} />Multiply
            <input type="radio" name="rdOperation" value="divide" ${c[3]} />Divide
            
            <br/>
            <br/>
            Result: ${result}
            
            <br/>
            <br/>
            
            <input type="submit" value="Calculate"/>
            
            <br/>
            <br/>
            <div style="color:red">
                <c:forEach var="error" items="${errors}">
                    ${error} <br />
                </c:forEach>
            </div>
        </form>
    </body>
</html>
