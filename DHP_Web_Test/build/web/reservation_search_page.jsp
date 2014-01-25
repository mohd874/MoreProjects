<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title>Reservation</title>
        <style type="text/css" media="all">
            <!--
            @import url("CSS/hotel.css");
            .style1 {            font-size: 36px;
            font-style: italic;
            font-weight: bold;
            }
            -->
        </style>
    </head>

    <body>
        
        <table width="800" height="600" border="0" cellspacing="0">
            <tr>
                <th width="200" height="100" scope="col"><div id="logo"></div></th>
                <th width="300" height="100" scope="col"><div id="location">
                    <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="300" height="100">
                        <param name="movie" value="SWF/Head_Left_reservation.swf" />
                        <param name="quality" value="high" />
                        <embed src="SWF/Head_Left_reservation.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="300" height="100"></embed>
                    </object>
                </div></th>
                <th width="300" height="100" scope="col"><div id="menu"></div></th>
            </tr>
            <tr>
                <th height="300" width="200" scope="row"><div id="navi"></div></th>
                <td height="500" width="600" colspan="2" rowspan="2"><div id="center"></br>
                    <div id="center_center">
                        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
                        <%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
                        <form id="form1" name="form1" method="post" action="room_search.page">
                            <table width="100%" border="0" cellspacing="0">
                                <tr>
                                    <td><div align="center">Room Type </div></td>
                                    <td><label>
                                        <select name="room_type" id="room_type">
                                            <option value="*">ALL</option>
                                            <option value="lexury">Lexury</option>
                                            <option value="khaleej">Khaleej</option>
                                            <option value="royal">Royal Palace</option>
                                        </select>
                                    </label></td>
                                    <td><div align="center">Room View </div></td>
                                    <td><label>
                                        <select name="room_view" id="room_view">
                                            <option value="*">ALL</option>
                                            <option value="marina">Marina</option>
                                            <option value="swimming_pool">Swimming Pool</option>
                                            <option value="garden">Garden</option>
                                        </select>
                                    </label></td>
                                </tr>
                                <tr>
                                    <td><div align="center">Price </div></td>
                                    <td><label>
                                        <div align="center">Min
                                            <input name="first_num" type="text" id="first_num" />
                                        </div>
                                    </label></td>
                                    <td><div align="center"></div></td>
                                    <td><label>
                                        <div align="center">Max
                                            <input name="second_num" type="text" id="second_num" />
                                        </div>
                                    </label></td>
                                </tr>
                                <tr>
                                    <td colspan="2"><label>
                                        <div align="center">
                                            <input name="search" type="submit" id="search" value="Search" src="" />
                                        </div>
                                    </label></td>
                                    <td colspan="2"><div align="center">
                                        <label>
                                            <input name="reset" type="reset" id="reset" value=" Rest  " />
                                        </label>
                                    </div></td>
                                </tr>
                            </table>
           
                        </form>
                        
                        <form id="form2" action="room_validate.page" method="post">
                            <table border="1"> 
                                <tr align="center"> 
                                    <td>Result number</td>
                                    <td>Type</td>
                                    <td>View</td>
                                    <td>Price</td>
                                    <td>Select room</td>
                                </tr> 
                                <c:forEach var="record" items="${results2.rows}" varStatus="count">
                                    <c:if test="${count.count mod 2 ==0}">
                                        <tr bgcolor="CCFFFF" align="center">
                                            <td>${count.count}</td>
                                            <td><c:out value="${record.room_type}"/> </td>
                                            <td><c:out value="${record.room_view}"/> </td>
                                            <td><c:out value="${record.room_price}"/> </td>  
                                            <td><input type="checkbox" name="selected_rooms" value="${record.room_id}">
                                        </tr>
                                    </c:if>
                                
                                    <c:if test="${count.count mod 2 !=0}">
                                        <tr bgcolor="FF6666" align="center">
                                            <td>${count.count}</td>
                                            <td><c:out value="${record.room_type}"/> </td>
                                            <td><c:out value="${record.room_view}"/> </td>
                                            <td><c:out value="${record.room_price}"/> </td>
                                            <td><input type="checkbox" name="selected_rooms" value="${record.room_id}">
                                        </tr>
                                    </c:if>
                                </c:forEach>
                                <tr>
                                    <c:if test="${results2 != null}">
                                        <td><input type="submit" name="Submit" value="Submit" /></td>
                                        <td><input type="reset" name="Reset" value="Reset" /></td>
                                    </c:if>
                                </tr>
                            </table>
                        </form>
                        <%
                            /*
                            ResultSet res = (ResultSet)request.getAttribute("results");
                            if( res != null ) {
                            int count = 0;
                            while(res.next()){
                            count++;
                            out.println(count);
                            out.println(res.getString("room_type")+"<br>");
                            }
                            } else{
                            out.println("res is null!!");
                            }

                            out.println("from here start the session <br>");

                            res = (ResultSet)request.getSession().getAttribute("results");

                            if( res != null ) {
                            res.beforeFirst();
                            }

                            if( res != null ) {
                            int count = 0;
                            while(res.next()){
                            count++;
                            out.println(count);
                            out.println(res.getString("room_type")+"<br>");
                            }
                            }

                            session.setAttribute("results",null);
                            out.println("<br>"+(String)request.getAttribute("msg"));
                             */
                        %>
                        ${msg}
                    </div>
                    <p>
                        <label></label>
                    </p>
                    <p align="left">
                        <label></label>
                    </p>
                </div></td>
            </tr>
            <tr>
                <th width="200" height="200" scope="row"><div id="clock">
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
