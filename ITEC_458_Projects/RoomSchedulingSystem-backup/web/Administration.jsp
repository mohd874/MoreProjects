<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ include file="commonLayout/taglibs.jspf" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<tiles:insert page="/commonLayout/commonLayout.jsp" flush="true">
    <tiles:put name="title" type="string"
               value="Administration Panel" />
    <tiles:put name="header" value="/commonLayout/header.jsp" />
    <tiles:put name="footer" value="/commonLayout/footer.jsp" />
    <tiles:put name="content" direct="true">
        <table width="40%" border="0" align="center">
            <tr>
                <th colspan="2" scope="col">Administration Panel </th>
            </tr>
            <tr>
                <td width="50%">
                    <div align="center">
                        <a href="<c:url value="administration.do?action=room"/>">Rooms</a> 
                    </div>
                </td>
                <td width="50%">
                    <div align="center">
                        <a href="<c:url value="administration.do?action=block"/>">Blocks</a>                         
                    </div>
                </td>
            </tr>
            <tr>
                <td width="50%">
                    <div align="center">
                        <a href="<c:url value="administration.do?action=semesters"/>">Semesters</a> 
                    </div>
                </td>
                <td width="50%">
                    <div align="center">
                        <a href="<c:url value="administration.do?action=courses"/>">Courses</a> 
                    </div>
                </td>
            </tr>
            <tr>
                <td width="50%">
                    <div align="center">
                        <a href="<c:url value="administration.do?action=events"/>">Events</a> 
                    </div>
                </td>
                <td width="50%">
                    <div align="center">
                        <a href="<c:url value="administration.do?action=users"/>">Users</a> 
                    </div>
                </td>
            </tr>
        </table>
    </tiles:put>
</tiles:insert>