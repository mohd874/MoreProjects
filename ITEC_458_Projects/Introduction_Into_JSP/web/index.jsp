<%-- 
    Document   : index
    Created on : Feb 18, 2008, 5:25:50 PM
    Author     : Saeed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="com.me.Car" errorPage="/WEB-INF/errorPage.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%!
    Car car2 = new Car("Camry",2);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Car Information</h2>
        <%-- Using scriptlet --%>
        <%
            Car car1 = new Car("Corolla", 1);
            out.println(car1);
        %>
        <br/>
        <%-- You can output information using scriplet --%>
        <%
            //car2 = null;
            out.println(car2.toString());
        %>
        <br/>
        <%-- or you can use expression as shown below --%>
        <%= car2 %>
        <%@ include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
