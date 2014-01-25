<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title>Home</title>

        
        <style type="text/css" media="all">
            <!--
            @import url("CSS/hotel.css");
            -->
        </style>
    </head>

    <body onLoad="MM_preloadImages('../web_images/aftr_profile.gif','../web_images/aftr_service.gif','../web_images/aftr_registeration.gif','../web_images/hold_registration.gif','../web_images/hold_profile.gif','../web_images/hold_service.gif','../web_images/hold_bookroom.gif','../web_images/aftr_bookroom.gif','../web_images/hold_login.gif','../web_images/aftr_login.gif')">
        <table width="800" height="600" border="0" cellspacing="0">
            <tr>
                <th width="14%" height="102" scope="col"><div id="logo"></div></th>
                <th width="49%" scope="col"><div id="location">
                    <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="396" height="100">
                        <param name="movie" value="SWF/Head_Left_home.swf" />
                        <param name="quality" value="high" />
                        <embed src="../SWF/Head_Left_home.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="396" height="100"></embed>
                    </object>
                </div></th>
                <th width="37%" scope="col"><div id="menu">
                    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
                    <jsp:useBean id="tracing_bean" class="com.hotel.model.tracing_bean" scope="session" >
                        <jsp:setProperty name="tracing_bean" property="uname" value="Guest"/>
                        <jsp:setProperty name="tracing_bean" property="utype" value="5"/>
                    </jsp:useBean>
                    
                    <p>Welcome ${tracing_bean.uname}</p><br>
                    <a href="login.jsp">Login / Logout </a>
                </div></th>
            </tr>
            <tr>
                <th height="364" scope="row"><div id="navi">

                    <c:choose>
                        <c:when test="${tracing_bean.utype == '4'}">
                            <jsp:include page="common_pages/customer_navi_logout.html" />
                        </c:when>
                        <c:when test="${tracing_bean.utype == '3'}">
                            <jsp:include page="common_pages/navi_receptionist_logout.html" />
                        </c:when>
                        <c:when test="${tracing_bean.utype == '2'}">
                            <jsp:include page="common_pages/navi_officer_logout.html" />
                        </c:when>
                        <c:when test="${tracing_bean.utype == '1'}">
                            <jsp:include page="common_pages/navi_Admin_logout.html" />
                        </c:when>
                        <c:otherwise>
                            <jsp:include page="common_pages/customer_navi_login.html" />
                        </c:otherwise>
                    </c:choose>
    
                </div></th>
                <td colspan="2" rowspan="2"><div id="center">
                    <a href="reservation_confirmation.jsp"> reservation confermation </a>
                    
                </div></td>
            </tr>
            <tr>
                <th scope="row"><div id="clock">
                    <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="201" height="202">
                        <param name="movie" value="SWF/Clock.swf" />
                        <param name="quality" value="high" />
                        <embed src="../Clock.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="201" height="202"></embed>
                    </object>
                </div></th>
            </tr>
        </table>
    </body>
</html>
