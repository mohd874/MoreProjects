<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <title>
            <tiles:getAsString name="title" ignore="true"/>
        </title>
        <link href="/css/site.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <!--Presented by developerWorks, your source for great tutorials ibm.com/developerWorks
        Master the Tiles framework Page 13 of 44-->
        <table width="75%" border="1" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="68" width="48%" colspan="2">
                    <div align="left">
                        <img src="images/logo.gif"
                             width="220" height="74">
                    </div>
                </td>
            </tr>
            <tr>
                <td height="68" width="2000" colspan="2">
                    <tiles:insert attribute="header" ignore="true">
                        <tiles:put name="title"
                                   beanName="title" beanScope="tile"/>
                    </tiles:insert>
                </td>
            </tr>
            <tr>
                <td colspan="2">Tab Navigation</td>
            </tr>
            <tr>
                <td rowspan="2" width="20%">Action</td>
                <td width="80%">
                    <div align="center">
                        <tiles:insert attribute="content"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td width="20%">
                <tiles:insert attribute="footer" ignore="true"/>                </td>
            </tr>
        </table>
    </body>
</html>