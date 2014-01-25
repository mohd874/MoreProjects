<%-- 
    Document   : registrationForm
    Created on : Feb 20, 2008, 6:46:46 PM
    Author     : Saeed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Registration Form</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="site.css" />
    </head>
    <body>
        <form name="registrationForm" action="registration.jsp" method="POST">
            <fieldset>
                <legend>User Registration</legend>
                <table border="0">
                    <tr>
                        <td>First Name:</td>
                        <td><input type="text" name="firstName" value="" /></td>
                    </tr>
                    <tr>
                        <td>Last Name:</td>
                        <td><input type="text" name="lastName" value="" /></td>
                    </tr>
                    <tr>
                        <td>Login:</td>
                        <td><input type="text" name="login" value="" /></td>
                    </tr>
                    <tr>
                        <td>Age:</td>
                        <td><input type="text" name="age" value="" /></td>
                    </tr>
                </table>
                <p>
                    Which topics are you interested in?<br />
                    <input type="checkbox" name="topics" value="Dates and Times" /> 
                    Dates and Times<br />
                    <input type="checkbox" name="topics" value="Strings and StringBuffers" /> 
                    Strings and StringBuffers<br />
                    <input type="checkbox" name="topics" value="Threading" /> 
                    Threading<br />
                </p>      
                <input type="submit" value="Submit" name="Submit" />
            </fieldset>
        </form>
        <%@ include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>