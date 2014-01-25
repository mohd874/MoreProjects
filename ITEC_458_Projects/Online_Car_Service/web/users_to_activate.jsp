<%@ include file="WEB-INF/jspf/top.jspf" %>
<c:if test="${userBean.id == -1 || userBean.type == 'user'}">
    <jsp:forward page="login.jsp"/>
</c:if>
<div id="content">
    <form action="<c:url value="/activateUsers" />" >
    <input type="hidden" value="activateUsers" name="action" />
    <table width="350" border="0" align="center">
  <tr>
    <th scope="col">Select</th>
    <th scope="col">Name</th>
    <th scope="col">User Name </th>
    <th scope="col">Date Of Birth </th>
    <th scope="col">Gender</th>
    <th scope="col">Telephone</th>
    <th scope="col">License No. </th>
    <th scope="col">Email</th>
  </tr>
  <c:forEach var="user" items="${users}">
  <tr>
    <td><input type="checkbox" name="selectedUsers" value="${user.id}" /></td>
    <td>${user.name}</td>
    <td>${user.userName}</td>
    <td>${user.dateOfBirth}</td>
    <td>${user.gender}</td>
    <td>${user.phoneNumber}</td>
    <td>${user.licenseNumber}</td>
    <td>${user.email}</td>
  </tr>
</c:forEach>
  <tr>
    <td>&nbsp;</td>
    <td><input type="submit" name="Submit" value="Activate Selected User(s)" /></td>
    <td><input type="submit" name="Submit2" value="Decline" /></td>
    <td><input type="reset" name="Submit22" value="Reset" /></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
</form>
</div>
<%@ include file="WEB-INF/jspf/bottom.jspf" %>

