<%-- 
    Document   : registration
    Created on : Feb 20, 2008, 6:50:55 PM
    Author     : Saeed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
         <title>User Registration</title>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="site.css" />
  </head>
    <body>
        <jsp:useBean id="user" class="com.me.User" scope="session">
            <jsp:setProperty name="user" property="*" />
        </jsp:useBean>
        <p>
            Welcome new user: These are the values you submitted:<br />
            Your first name: <%= user.getFirstName() %>
            <br />
            Your last name: <jsp:getProperty name="user" property="lastName" />
            <br />
            Your age: <jsp:getProperty name="user" property="age" />
            <br />
            Your login name: <jsp:getProperty name="user" property="login" />
            <br />
            You selected these topics:<br />
            <%
            String[] topics = request.getParameterValues("topics");
            if (topics == null) {
                topics = new String[]{"No topic was selected"};
            }
            for (String s : topics) {
                out.println(s + "<br />");
            }
            %>
        </p>
        <p>
            Go to <a href="welcome.jsp">Topics List Page</a>
        </p>
        <br />
        <%@ include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
