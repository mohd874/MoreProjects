<%-- 
    Document   : welcome
    Created on : Feb 20, 2008, 6:52:42 PM
    Author     : Saeed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="com.me.*,java.util.ArrayList"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Welcome</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="site.css" />
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
            if (user == null) {
        %>
        You are not registered yet, please
        <a href="registrationForm.jsp">register</a>
        <%
        } else {
        %>
        <h2>Welcome to the Java Faq</h2>
        
        <%! FaqCategories faqcats = new FaqCategories(); %>
        
        <p>
            Click on a link below for answers to the given topic<br />
            <%
            ArrayList<String> cats = faqcats.getCategories();
            //cats = null;
            for (String s : cats) {
            %>
            <a href="<%= replaceWhiteSpace( s ) %>.jsp"><%= s %></a><br />
            <%
                }
            }
            %>
        </p>
        <%@ include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
<%!
    public String replaceWhiteSpace(String s) {
        return s.replace(" ", "_");
    }
%>
