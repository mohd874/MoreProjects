<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="com.hotel.model.*, java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
        <title>Login</title>
        <style type="text/css" media="all">
            <!--
            @import url("CSS/hotel.css");
            -->
        </style>
    </head>

    <body>
        <%
            //tracing_bean tb = (tracing_bean)request.getSession().getAttribute("tracing_bean");
            //if(tb != null){
            //out.println(tb.getUname());
            //out.println(tb.getUtype());
            //out.println(tb.getDefult_name());
            //}
        %>
        
        <table width="800" height="600" border="0" cellspacing="0">
            <tr>
                <th width="200" height="100" scope="col"><div id="logo"></div></th>
                <th width="300" height="100" scope="col"><div id="location">
                    <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="396" height="100">
                        <param name="movie" value="SWF/Head_Left_login.swf" />
                        <param name="quality" value="high" />
                        <embed src="SWF/Head_Left_login.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="396" height="100"></embed>
                    </object>
                </div></th>
                <th width="300" height="100" scope="col"><div id="menu"></div></th>
            </tr>
            <tr>
                <th height="300" width="200" scope="row"><div id="navi"></div></th>
                <td colspan="2" rowspan="2"><div id="center"></br></br>
                    <jsp:useBean id="tracing_bean" class="com.hotel.model.tracing_bean" scope="session" />
        
                    <c:if test="${tracing_bean.uname != tracing_bean.defult_name}">
                        <jsp:setProperty name="tracing_bean" property="uname" value="${tracing_bean.defult_name}"/>            
                        <jsp:setProperty name="tracing_bean" property="utype" value="5"/>
                        <jsp:forward page="home.jsp"/>
                    </c:if>
        
                    <jsp:getProperty name="tracing_bean" property="uname"/>
                    
                    <form id="form1" name="form1" method="post" action="login.page">                    
                    
                        <p align="center"><strong><span class="style6">User Name</span>: 
                            <label>
                                <input type="text" name="uname" id="uname"/>
                            </label>
                        </strong></p>
                        <p align="center"><strong> Password:  
                            <label>
                                <input type="password" name="pass" id="pass"/>
                            </label>
                        </strong></p>
                        <p align="center">
                            <input type="submit" name="Submit" value="Login">
                            <input name="reset" type="reset" id="reset" value="Reset">
                        </p>
                        <p align="center">register as new customer <a href="www.google.com">here</a> </p>
                    </form>
                    ${errors}
                
                </div></td>
            </tr>
            <tr>
                <th height="200" width="200" scope="row"><div id="clock">
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
