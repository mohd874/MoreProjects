<%@ include file="WEB-INF/jspf/top.jspf" %>
<div id="content">
    <%@ include file="WEB-INF/jspf/errorViewer.jspf" %>
    <c:if test="${userBean.id != -1}">
        <jsp:forward page="/main.jsp"/>
    </c:if>
    <form method="post" action="<c:url value="/register" />">
        <input type="hidden" value="register" name="action" />
        <table width="250" border="0" align="center">
            <tr>
                <td scope="row" align="center" colspan="2">All Fields are required </td>
            </tr>
            <tr>
                <th scope="row" align="right">Name: </th>
                <td><input type="text" name="name" value="${name}"/></td>
            </tr>
            <tr>
                <th scope="row" align="right">User Name: </th>
                <td><input type="text" name="username" value="${username}"/></td>
            </tr>
            <tr>
                <th scope="row" align="right">Password: </th>
                <td><input type="password" name="password" /></td>
            </tr>
            <tr>
            <tr>
                <th scope="row" align="right">Confirm Password: </th>
                <td><input type="password" name="cpassword" /></td>
            </tr>
            <tr>
                <th scope="row" align="right">Date of Birth: (dd-mm-yyyy)</th>
                <td>
                    <input type="text" name="dob" readonly="true" value="${dob}" />
                    <input type=button value="select" onclick="displayDatePicker('dob', false, 'dmy', '-');">
                </td>
            </tr>
            <tr>
            <tr>
                <th scope="row" align="right">License No.: </th>
                <td><input type="text" name="license" value="${license}"/></td>
            </tr>
            <tr>
                <th scope="row" align="right">Gender:</th>
                <td>
                    <input type="radio" name="gender" value="male" ${gender}>Male</input>
                    <input type="radio" name="gender" value="female" ${gender}>Female</input>
                </td>
            </tr>
            <tr>
                <th scope="row" align="right">Email: </th>
                <td><input type="text" name="email" value="${email}"/></td>
            </tr>
            <tr>
                <th scope="row" align="right">Telephone: </th>
                <td><input type="text" name="telephone" value="${telephone}"/></td>
            </tr>
            <tr>
                <th colspan="2" scope="row">
                    <center>
                        <input type="submit" name="Submit" value="Submit" />
                    </center>
                </th>
            </tr>
        </table>
    </form>
</div>
<%@ include file="WEB-INF/jspf/bottom.jspf" %>

