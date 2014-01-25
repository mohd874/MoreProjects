<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<tiles:insert page="/commonLayout/commonLayout.jsp" flush="true">
    <tiles:put name="title" type="string"
               value="Login" />
    <tiles:put name="header" value="/commonLayout/header.jsp" />
    <tiles:put name="footer" value="/commonLayout/footer.jsp" />
    <tiles:put name="content" type="string">
        <table width="75%" border="1">
            <tr> 
                <td>Name</td>
                <td>Section</td>
                <td>Short Description</td>
            </tr>
            <tr> 
                <td><input type="checkbox" name="checkbox" value="checkbox">
                T001</td>
                <td>T wing</td>
                <td>Normal class</td>
            </tr>
            <tr> 
                <td><a href="OW115.htm">
                        <input type="checkbox" name="checkbox2" value="checkbox">
                W115</a></td>
                <td><a href="OW115.htm">W wing</a></td>
                <td><a href="OW115.htm">Fitts 21 students</a></td>
            </tr>
            <tr> 
                <td><input type="checkbox" name="checkbox3" value="checkbox">
                M001</td>
                <td>M wing</td>
                <td>Mecanical classes</td>
            </tr>
            <tr> 
                <td><input type="checkbox" name="checkbox4" value="checkbox">
                J006</td>
                <td>J block</td>
                <td>Foundation</td>
            </tr>
        </table>
    </tiles:put>
</tiles:insert>