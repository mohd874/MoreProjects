<%@ include file="WEB-INF/jspf/top.jspf" %>
<div id="content">
    <%@ include file="WEB-INF/jspf/errorViewer.jspf" %>
    <form method="post" action="<c:url value="/login" />">
        <c:if test="${userBean.id == -1}">
            <input type="hidden" value="login" name="action" />
        </c:if>
        <c:if test="${userBean.id != -1}">
            <jsp:forward page="/login?action=logout"/>
        </c:if>
        <table width="250" border="0" align="center">
            <tr>
                <th scope="row" align="right">User Name: </th>
                <td><input type="text" name="username" value="${username}"/></td>
            </tr>
            <tr>
                <th scope="row" align="right">Password:</th>
                <td><input type="password" name="password" value="${password}"/></td>
            </tr>
            <tr>
                <th colspan="2" scope="row">
                    <center>
                        <input type="submit" name="Submit" value="Login" />
                    </center>
                </th>
            </tr>
            <tr>
                <td colspan="2" scope="row">
                    <center>
                        Not Registred? <a href="<c:url value="/register.jsp"/>">Register NOW!</a> 
                </center></td>
            </tr>
        </table>
    </form>
</div>
<%@ include file="WEB-INF/jspf/bottom.jspf" %>

