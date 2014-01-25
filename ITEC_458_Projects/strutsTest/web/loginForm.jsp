<%-- 
    Document   : loginForm
    Created on : Apr 2, 2008, 6:36:12 PM
    Author     : Saeed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h2>Login Page</h2>
        <html:form action="login">
            <html:errors />
            <table border="1">
                <thead>
                    <tr>
                        <th><bean:message key="login.name" /></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><html:text property="name" /></td>
                    </tr>
                </tbody>
            </table>
            <html:submit value="Login"/>
        </html:form>
    </body>
</html>
