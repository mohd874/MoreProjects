<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*, com.hotel.model.tracing_bean"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Reservation Check</title>
        <style type="text/css">
            <!--
            @import url("CSS/ndesign.css");
            -->
        </style>
    </head>

    <body>
        <div class="ndesign" id="cssall">
            <div class="ndesign" id="nlocation">
                <div align="center">
                    <p>&nbsp;</p>
                    <p><img src="location gif/Home.gif" width="295" height="100"></p>
                </div>
            </div>
            <%@include file="trace_n_taglib2.jsp"%>
            <div class="ndesign" id="nwelcome">
                <div align="center"> ${tracing_bean.title} ${tracing_bean.name} </div>
            </div>
            <div class="ndesign" id="nclock">
                <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="100" height="100">
                    <param name="movie" value="SWF/Clock.swf">
                    <param name="quality" value="high">
                    <embed src="SWF/Clock.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="100" height="100"></embed>
                </object>
            </div>
            <div class="ndesign" id="ncenter">
                
                <c:if test="${tracing_bean.utype == '3'}">
                    <sql:setDataSource url="jdbc:mysql://localhost:3306/dph_db_test" driver="com.mysql.jdbc.Driver" user="root" password="7710072" var="myDB"/>
                
                    <sql:transaction dataSource="${myDB}">
                        <sql:query var="customer">
                            select user_name from sysuser where user_id = '${tracing_bean.customer_id}'
                        </sql:query>
                    </sql:transaction>
                </c:if>
                
                
                <form id="form1" name="form1" method="post" action="reservation_update.page">
                    Please check if all the information are correct:
                    <table>
                        <tr>
                            <td><h1><font color="blue" style="italic" >Personal Information: </font></h1></td>
                            <td></td>
                        </tr>
                        <c:choose>
                            <c:when test="${tracing_bean.utype == '4'}">
                                <tr>
                                    <td>User name: </td>
                                    <td>${tracing_bean.uname}</td>
                                </tr>
                            </c:when>
                            
                            <c:when test="${tracing_bean.utype == '3'}">
                                <c:forEach var="record" items="${customer.rows}">
                                    <tr>
                                        <td>Login name: </td>
                                        <td>${record.user_name}</td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                        </c:choose>
                        <tr>
                            <td>Arrival date: </td>
                            <td>${tracing_bean.ard}</td>
                        </tr>
                        <tr>
                            <td>Departure date: </td>
                            <td>${tracing_bean.dpd}</td>
                        </tr>
                        <tr>
                            <td>Flight: </td>
                            <td>${tracing_bean.flight}</td>
                        </tr>
                        <tr>
                            <td>Credit Card #:</td>
                            <td>${tracing_bean.ccn}</td>
                        </tr>
                        <tr>
                            <td>Credit Card type: </td>
                            <td>${tracing_bean.cct}</td>
                        </tr>
                        <tr>
                            <td>Expiry Month: </td>
                            <td>${tracing_bean.expm}</td>
                        </tr>
                        <tr>
                            <td>Exipty Year: </td>
                            <td>${tracing_bean.expy}</td>
                        </tr>
                        <tr>
                            <td>Confirmation: </td>
                            <td>${tracing_bean.cfm}</td>
                        </tr>
                        <tr>
                            <td><h1><font color="blue" style="italic" >Rooms Information: </font></h1></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>NO: </td>
                            <td>Type</td>
                            <td>View</td>
                            <td>Price</td>
                        </tr>
                            
                        <%
                            /*
                            <c:forEach var="record" items="${tracing_bean.roomT}" varStatus="count">
                            <tr><td>${count.count} </td><td>${tracing_bean.roomT[count.count]}</td></tr>
                            </c:forEach>
                             */

                            for(int i=0; i<tracing_bean.getRooms_id().length; i++){
                                out.print("<tr><td>"+(i+1)+" </td><td>"+tracing_bean.roomT[i]+"</td><td>"+tracing_bean.roomV[i]+"</td><td>"+tracing_bean.price[i]+"</td></tr>");
                                String test = "";

                            }
                        %>
                        <tr>
                            <td><label>
                                <input type="submit" name="Submit" value="Submit" />
                            </label>
                            </td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                        </tr>
                    </table>
                </form>
                        
                        
            </div>
            <div class="ndesign" id="nnavi">
                <%@include file="navigation_buttons.jsp"%>
            </div>
            <div class="ndesign" id="welcome"></div>
        </div>
    </body>
</html>
