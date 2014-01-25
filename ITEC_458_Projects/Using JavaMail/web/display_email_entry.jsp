<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>Thanks for joining our email list</h1>
    <p>Here is the information that you entered:</p>
    
    <table>
        <tr>
            <td>First Name:</td>
            <td>${user.firstName}</td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td>${user.lastName}</td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>${user.email}</td>
        </tr>
    </table>
    
    <p>To enter another email address, click on the back button<br>
        in your browser or the Return button shown<br>
        below.</p>
        
        <form action="join_email_list.jsp" method="post">
            <input type="submit" value="Return" />
        </form>
        
        <p>
            <i>${requestScope.errorMessage}</i>
        </p>
    </body>
</html>
