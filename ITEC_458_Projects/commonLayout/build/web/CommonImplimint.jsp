<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<tiles:insert page="/Common.jsp" flush="true">
    <tiles:put name="title" type="string"
               value="Get Rick Hightower Stock Quote" />
    <tiles:put name="header" value="/header.jsp" />
    <tiles:put name="footer" value="/footer.jsp" />
    <tiles:put name="content" type="string">
        Content
    </tiles:put>
</tiles:insert>