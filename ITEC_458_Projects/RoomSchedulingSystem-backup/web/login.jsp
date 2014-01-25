<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ include file="commonLayout/taglibs.jspf" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<tiles:insert page="/commonLayout/commonLayout.jsp" flush="true">
    <tiles:put name="title" type="string"
               value="Login" />
    <tiles:put name="header" value="/commonLayout/header.jsp" />
    <tiles:put name="footer" value="/commonLayout/footer.jsp" />
    <tiles:put name="content" direct="true">
        <html:form action="login">
            <div align="center" style="padding-top:25%;height:200px;background-image:url(images/hct-logo.gif); background-repeat: no-repeat; background-position: center center">
                <table width="300" border="0" align="center">
                <tr>
                    <td colspan="2">
                        <html:errors/>
                    </td>
                </tr>
                <tr> 
                    <td width="25%"><bean:message key="login.name" /></td>
                    <td width="50%"><html:text property="name" /></td>
                </tr>
                <tr> 
                    <td><bean:message key="login.password" /></td>
                    <td width="50%"><html:password property="password" /></td>
                </tr>
                <tr align="center"> 
                    <td colspan="2"><html:submit value="Login" />
                    <!--a href="OClassTable.htm">Officer</a> <a href="SClassTable.htm">Staff</a--></td>
                </tr>
            </table></div>
        </html:form>
    </tiles:put>
</tiles:insert>