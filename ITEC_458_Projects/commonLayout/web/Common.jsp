<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<html>
    <head>
        <title>
            <tiles:getAsString name="title" ignore="true"/>
        </title>
    </head>
    <body>
        Presented by developerWorks, your source for great tutorials ibm.com/developerWorks
        Master the Tiles framework Page 13 of 44
        <table width="500" border="0" cellspacing="0" cellpadding="0">
            <tr bgcolor="#36566E">
                <td height="68" width="48%">
                    <div align="left">
                        <!--img src="images/hp_logo_rickhightower.gif"
                             width="220" height="74"-->Image
                    </div>
                </td>
            </tr>
            <tr>
                <td height="68" width="2000">
                    <tiles:insert attribute="header" ignore="true">
                        <tiles:put name="title"
                                   beanName="title" beanScope="tile"/>
                    </tiles:insert>
                </td>
            </tr>
            <tr>
                <td>
                    <div align="center">
                        <tiles:insert attribute="content"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <tiles:insert attribute="footer" ignore="true"/>
                </td>
            </tr>
        </table>
    </body>
</html>