<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*, com.hotel.model.tracing_bean" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title>Reservation Check</title>
        <style type="text/css" media="all">
            <!--
            @import url("CSS/hotel.css");
            -->
        </style>
    </head>

    <body>
        
        <table width="800" height="600" border="0" cellspacing="0" bgcolor="#FDD398">
            <tr>
                <th width="200" height="100" scope="col"><div id="logo"></div></th>
                <th width="300" height="100" scope="col"><div id="location"></div></th>
                <th width="300" height="100" scope="col"><div id="menu"></div></th>
            </tr>
            <tr>
                <th height="300" width="200" scope="row" bgcolor="#FDD398"><div id="navi"></div></th>
                <td colspan="2" rowspan="2"><div id="center"></br>
                    <div id="center_center">
                        <%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*, com.hotel.model.tracing_bean" errorPage="" %>
                        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
                        <jsp:useBean id="tracing_bean" class="com.hotel.model.tracing_bean" scope="session"/>

                        <form id="form1" name="form1" method="post" action="reservation_update.page">
                            Please check if all the information are correct:
                            <table>
                                <tr>
                                    <td><h1><font color="blue" style="italic" >Personal Information: </font></h1></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>User name: </td>
                                    <td>${tracing_bean.uname}</td>
                                </tr>
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
                                    <td>Flight: </td>
                                    <td>${tracing_bean.flight}</td>
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
                </div></td>
            </tr>
            <tr>
                <th width="200" height="200" scope="row"><div id="clock">
                    <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="201" height="202">
                        <param name="movie" value="../SWF/Clock.swf" />
                        <param name="quality" value="high" />
                        <embed src="SWF/Clock.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="201" height="202"></embed>
                    </object>
                </div></th>
            </tr>
        </table>
    </body>
</html>
