<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Attendee Management Application</title>
    </head>
    <body>
        <h2>Attendee Management Application</h2>
        <form name="form1" action="<c:url value='/manage' />" method="POST">
            <table border="1" cellspacing="2" width="50%">
                <tr>
                    <td>&nbsp;</td>
                    <td>Name</td>
                    <td>Login</td>
                    <td>Password</td>
                    <td>Emails</td>
                </tr>
                <c:forEach var="attendee" items="${attendees}">
                    <tr>
                        <td><input type="radio" name="id" value="${attendee.id}"></td>
                        <td>${attendee.name}</td>
                        <td>${attendee.login}</td>
                        <td>${"***"}</td>
                        <td>
                            <c:forEach var="email" items="${attendee.emails}" varStatus="i">
                            ${email}
                                <c:if test="${not empty attendee.emails[i.count]}" >
                                    <br />
                                </c:if>
                            </c:forEach>
                            &nbsp;
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <input type="text" name="email" value="">
            <input type="submit" name="action" value="Add Email">
            <span style="color:red">${error}</span>
        </form>
        <form name="form2" action="<c:url value='/manage' />" method="POST">
            <table>
                <tr>
                    <td>Name</td>
                    <td>Login</td>
                    <td>Password</td>
                </tr>
                <tr>
                    <td><input type="text" name="name" value=""></td>
                    <td><input type="text" name="login" value=""></td>
                    <td><input type="password" name="password" value=""></td>
                    <input type="submit" name="action" value="Add Attendee">
                </tr>
            </table>
        </form>
        
    </body>
</html>
