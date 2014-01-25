<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Employee</title>
        <style type="text/css">
            <!--
            .style1 {
                font-size: xx-large;
                font-weight: bold;
                font-family: Arial, Helvetica, sans-serif;
            }
            
            .error{
                color:#FF0000;
            }
            -->
        </style>
    </head>
    <body>
        <%--c:if test="${departmentsList == null}">
            <jsp:forward page="/addEmployee" />
        </c:if--%>
        <span class="style1">Add Employees</span>
        <hr />
        <form id="form1" name="form1" method="post" action="">
            <ul>
                <c:forEach var="err" items="${errors}">
                    <li class="error">
                        ${err}
                    </li>
                </c:forEach>
            </ul>
            <table width="40%" border="0">
                <tr>
                    <th scope="row">Employee id: </th>
                    <td>
                        <input type="text" name="id" value="${requestScope.id}"/>
                    </td>
                </tr>
                <tr>
                    <th scope="row">First Name: </th>
                    <td><input type="text" name="fName" value="${requestScope.fName}"/></td>
                </tr>
                <tr>
                    <th scope="row">Last Name: </th>
                    <td><input type="text" name="lName" value="${requestScope.lName}"/></td>
                </tr>
                <tr>
                    <th scope="row">Email:</th>
                    <td><input type="text" name="email" value="${requestScope.email}"/></td>
                </tr>
                <tr>
                    <th scope="row">Address:</th>
                    <td><textarea name="address" rows="5">${requestScope.address}</textarea></td>
                </tr>
                <tr>
                    <th scope="row">Mobile:</th>
                    <td><input type="text" name="mobile" value="${requestScope.mobile}"/></td>
                </tr>
                <tr>
                    <th scope="row">Department:</th>
                    <td>
                        <select name="department">
                            <c:forEach var="depart" items="${departmentsList}">
                                <option value="${depart.id}">${depart.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th scope="row"><input type="submit" name="action" value="   Add   " /></th>
                    <td>${requestScope.msg}</td>
                </tr>
            </table>
        </form>    
    </body>
</html>
