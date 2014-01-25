<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Reservation Confirmation</title>
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
                    <p><img src="location gif/Confirm.gif" width="295" height="100"></p>
                </div>
            </div>
            <%@include file="trace_n_taglib2.jsp"%>
            <div class="ndesign" id="nwelcome">
                <div align="center">${tracing_bean.name} ${tracing_bean.surname} </div>
            </div>
            <div class="ndesign" id="nclock">
                <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="100" height="100">
                    <param name="movie" value="SWF/Clock.swf">
                    <param name="quality" value="high">
                    <embed src="SWF/Clock.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="100" height="100"></embed>
                </object>
            </div>
            <div class="ndesign" id="ncenter">
                <form action="confirmation_control.page" id="form1" name="form1" method="post">            
                    <sql:setDataSource url="jdbc:mysql://localhost:3306/dph_db_test" driver="com.mysql.jdbc.Driver" user="root" password="7710072" var="myDB"/>
    
                    <sql:transaction dataSource="${myDB}">
                        <sql:query var="rooms">
                            select r.room_id, room_number, confirmation, c.reservation_id, c.arrival_date, c.depart_date from rooms r, customer_reservation c where r.room_id in (select c.room_id from customer_reservation) AND customer_id = '${tracing_bean.userID}'
                        </sql:query>
                    </sql:transaction>
                    ${status}
                    <table width="500" height="130" border="1">
                        <tr>
                            <th colspan="5" scope="col"><h1><strong>Reservation Confirmation </strong></h1></th>
                        </tr>
                        <tr>
                            <th width="200" scope="col">User Name: </th>
                            <th width="284" colspan="4" scope="col"><label> ${tracing_bean.name} </label></th>
                        </tr>
                        <tr>
                            <th height="24" colspan="5" scope="row"><h2>Reserved Rooms</h2></th>
                        </tr>
                        <tr>
                            <th scope="row">Room Number</th>
                            <th scope="row">Room Status </th>
                            <th scope="row">Action</th>
                            <th scope="row">Arrival Date</th>
                            <th scope="row">Depart Date</th>
                            
                        </tr>
                        <c:forEach var="record" items="${rooms.rows}">
                            <tr>
                                <th scope="row">${record.room_number}</th>
                                <td>
                                    <c:choose>
                                        <c:when test="${record.confirmation == 'n'}">
                                            <font color="red"> Not Confirmed </font>
                                        </c:when>
                                        <c:when test="${record.confirmation == 'y'}">
                                            <font color="green"> Confirmed </font>
                                        </c:when>
                                    </c:choose>
                                </td>
                                <td>
                                    <select name="action">
                                        <option value="">Do Nothing</option>
                                        <c:if test="${record.confirmation == 'n'}">
                                            <option value="confirm">Confirm</option>
                                        </c:if>
                                        <option value="cancel">Cancel</option>
                                    </select>
                                    <input type="hidden" name="reservation_id" id="reservation_id" value="${record.reservation_id}">
                                </td>
                                
                                <td>
                                ${record.arrival_date}
                                </td>
                                <td>
                                ${record.depart_date}
                                </td>
                                
                            </tr>
                        </c:forEach>
                    </table>
                    <input type="submit" value="Submit">&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Reset">
    
                </form>
            </div>
            <div class="ndesign" id="nnavi">
                <%@include file="navigation_buttons.jsp"%>
            </div>
            <div class="ndesign" id="welcome"></div>
        </div>
    </body>
</html>
