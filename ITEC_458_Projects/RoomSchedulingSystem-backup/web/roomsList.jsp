<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ include file="commonLayout/taglibs.jspf" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<tiles:insert page="/commonLayout/commonLayout.jsp" flush="true">
    <tiles:put name="title" type="string"
               value="Rooms" />
    <tiles:put name="header" value="/commonLayout/header.jsp" />
    <tiles:put name="footer" value="/commonLayout/footer.jsp" />
    <tiles:put name="content" type="string">
        Welcome ${sessionScope.userSession.loginName}
        
        <table width="75%" border="1">
            <tr> 
                <td>Name</td>
                <td>Section</td>
                <td>Type</td>
                <td>Short Description</td>
            </tr>
            <c:forEach var="room" items="${requestScope.rooms}">
                <tr> 
                    <td>                            <!--bean name--> <!--bean.attribute name--><!--html name-->
                        <html:link action="roomSchedule" paramName="room" paramProperty="id" paramId="room">
                           ${room.name}
                        </html:link>
                    </td>
                    <td>${room.block.name}</td>
                    <td>${room.type.type}</td>
                    <td>${room.description}</td>
                </tr>
            </c:forEach>
        </table>
    </tiles:put>
</tiles:insert>