<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    </head>
    <body>
        <h1>Join our email list</h1>
        <p>To join our email list, enter your name and email address below.</p>
        <p>Then, click on the "Submit" button</p>
        <form action="<c:url value="/addToMail" />">
            <table width="100%" border="0">
                <tr>
                    <td>First Name: </td>
                    <td><input type="text" name="firstName" /></td>
                </tr>
                <tr>
                    <td>Last Name: </td>
                    <td><input type="text" name="lastName" /></td>
                </tr>
                <tr>
                    <td>Email address: </td>
                    <td><input type="text" name="email" /></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" name="Submit" value="Submit" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
