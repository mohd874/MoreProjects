<%-- 
    Document   : usingex
    Created on : Mar 5, 2008, 5:31:25 PM
    Author     : Saeed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmatics Operators</title>
    </head>
    <body>
        <h2>Arithmatics Operators</h2>
        
        <p>
            There are ${1 + 2 * 4 - 6 / 2} apples on the table<br/>
            It feels like ${-4-8} degrees today<br/>
        
        <%
        pageContext.setAttribute("grade", 80);
        %>
        
            The average grade is ${grade >= 95 ? "perfect" : "good"}. <br/>
            There are ${23 / 54} apples on the table.<br/>
            There are ${6 div 2} apples on the table.<br/>
            There are ${2008 mod 3} apples on the table.<br/>
            There are ${2008 % 3} apples on the table.<br/>
            
        </p>
        
        <h2>Logical Operators</h2>
        
        <p>
            You are passing: ${grade >= 60 &&  grade <= 100}<br/>
            You are passing: ${grade >= 60 and grade <= 100}<br/>
            
        </P>
        
        <h2>Comparoson Operaators</h2>
        
        <p>
            4 > '3' ==> ${4 > '3'}<br/>
            '4' > 3 ==> ${'4' > 3 }<br/>
            '4' < '3' ==> ${'4' < '3'}<br/>
            4 >= 3 ==> ${4 >= 3}<br/>
            4 <= 3 ==> ${4 <= 3}<br/>
            4 == '4' ==> ${4 == '4'}<br/>
            
        <p/>
        
        <h2>empty Operator</h2>
        <p>
            empty "" ==> ${ empty "" }<br/>
            empty "something" ==> ${ empty "something" }<br/>
            empty Junk ==> ${ empty Junk }<br/>
            empty grade ==> ${ empty grade }<br/>
            
        </p>
        
        <h2>Null Values</h2>
        <p>
            null == null ==>${ null == null }<br/>
            null == "null" ==>${ null == "null" }<br/>
            
        </p>
        
        
    </body>
</html>
