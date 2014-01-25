<%-- 
    Document   : errorPage
    Created on : Feb 20, 2008, 6:15:01 PM
    Author     : Saeed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="site.css" />
        <title>Error</title>
    </head>
    <body>
        <h2>Error</h2>
        <!--
        <%=
        exception
        %>
        -->
        <p>
            There was an error somewhere
            <%@ include file="/WEB-INF/jspf/footer.jspf" %>
        </P>
    </body>
</html>
