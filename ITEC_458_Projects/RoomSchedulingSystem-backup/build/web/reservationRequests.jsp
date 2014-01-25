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
        
        <table width="75%" border="1">
            <tr> 
                <td>Request #</td>
                <td>Room</td>
                <td>Block</td>
                <td>Reserver</td>
                <td>Course</td>
            </tr>
            <c:forEach var="req" items="${requestScope.resevationRequests}" varStatus="index">
                <tr> 
                    <td>
                        ${index.count}
                    </td>
                    <td>                            <!--bean name--> <!--bean.attribute name--><!--html name-->
                        <html:link action="roomSchedule" paramName="req" paramProperty="room.id" paramId="room">
                           ${req.room.name}
                        </html:link>
                    </td>
                    <td>${req.room.block.name}</td>
                    <td>${req.reserver.loginName}</td>
                    <td>${req.course.code}</td>
                </tr>
            </c:forEach>
        </table>
    </tiles:put>
</tiles:insert>