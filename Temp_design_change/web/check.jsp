<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Welcome to Daffodils Palace Hotel</title>
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
                    <p><img src="location gif/Check.gif" width="295" height="100"></p>
                </div>
            </div>
            <%@include file="trace_n_taglib2.jsp"%> 
            <%@page import="java.text.SimpleDateFormat, java.util.Date"%>
            <div class="ndesign" id="nwelcome">
                <div align="center">${tracing_bean.title} ${tracing_bean.name}</div>
            </div>
            <div class="ndesign" id="nclock">
                <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="100" height="100">
                    <param name="movie" value="SWF/Clock.swf">
                    <param name="quality" value="high">
                    <embed src="SWF/Clock.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="100" height="100"></embed>
                </object>
            </div>
             <% 
            SimpleDateFormat sdf = new SimpleDateFormat();
            Date d = new Date();

            sdf.applyPattern("yyyy-MM-dd");
            String shortDate = sdf.format(d);
            //out.print(shortDate);
             %>
            
            <sql:setDataSource url="jdbc:mysql://localhost:3306/dph_db_test" driver="com.mysql.jdbc.Driver" user="root" password="7710072" var="myDB"/>

            <sql:transaction dataSource="${myDB}">
                <sql:query var="names">
                    select user_id, name, surname 
                    from sysuser 
                    where user_id in (select customer_id from customers)
                    
                </sql:query>
                
                <sql:query var="rooms">
                    select room_number,room_id
                    from rooms
                </sql:query>
                
                <c:choose>
                <c:when test="${param.user_id != '' && param.user_id != null && param.room_id == '' || param.room_id == null}">
                    <sql:query var="reservations">
                        Select
                        s.name,
                        s.surname,
                        cr.reservation_id,
                        cr.arrival_date,
                        cr.depart_date,
                        cr.check_in,
                        r.room_id,
                        r.room_number,
                        r.room_type,
                        r.room_view,
                        r.room_price
                        From
                        customers AS c
                        ,
                        customer_reservation AS cr
                        ,
                        sysuser AS s
                        ,
                        rooms AS r
                        Where
                        s.user_id = c.customer_id AND
                        s.user_id = cr.customer_id AND
                        r.room_id = cr.room_id AND
                        s.user_id = '${param.user_id}' AND 
                        cr.arrival_date >= '<%= shortDate %>'
                    </sql:query>
                </c:when>
                <c:when test="${param.room_id != '' && param.room_id != null && param.user_id == '' || param.user_id == null}">
                    <sql:query var="reservations">
                        Select
                        s.name,
                        s.surname,
                        cr.reservation_id,
                        cr.arrival_date,
                        cr.depart_date,
                        cr.check_in,
                        r.room_id,
                        r.room_number,
                        r.room_type,
                        r.room_view,
                        r.room_price
                        From
                        customers AS c
                        ,
                        customer_reservation AS cr
                        ,
                        sysuser AS s
                        ,
                        rooms AS r
                        Where
                        s.user_id = c.customer_id AND
                        s.user_id = cr.customer_id AND
                        r.room_id = cr.room_id AND
                        r.room_id = '${param.room_id}' AND
                        cr.arrival_date >= '<%= shortDate %>'
                    </sql:query>
                </c:when>
                <c:when test="${param.room_id != '' && param.room_id != null && param.user_id != '' && param.user_id != null}">
                    <sql:query var="reservations">
                        Select
                        s.name,
                        s.surname,
                        cr.reservation_id,
                        cr.arrival_date,
                        cr.depart_date,
                        cr.check_in,
                        r.room_id,
                        r.room_number,
                        r.room_type,
                        r.room_view,
                        r.room_price
                        From
                        customers AS c
                        ,
                        customer_reservation AS cr
                        ,
                        sysuser AS s
                        ,
                        rooms AS r
                        Where
                        s.user_id = c.customer_id AND
                        s.user_id = cr.customer_id AND
                        r.room_id = cr.room_id AND
                        user_id = '${param.user_id}' AND
                        r.room_id = '${param.room_id}' AND
                        cr.arrival_date >= '<%= shortDate %>'
                    </sql:query>
                </c:when>
                
                </c:choose>
            </sql:transaction>
            <div class="ndesign" id="ncenter">
                
                <form action="check.jsp" method="post">
                    <p>Select a customer to check: 
                        <select name="user_id">
                            <option value="">Select</option>
                            <c:forEach var="record" items="${names.rows}">
                                <option value="${record.user_id}">
                                    <c:out value="${record.name}, ${record.surname}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </p>
                    <p>Select a room to check: 
                        <select name="room_id">
                            <option value="">Select</option>
                            <c:forEach var="room" items="${rooms.rows}">
                                <option value="${room.room_id}">
                                    <c:out value="${room.room_number}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </p>
                    <p>
                        <input type="submit" name="Submit" value="Submit">
                    </p>
                </form>
                
                <form name="form1" method="post" action="check_in.page">
                    ${errors}
                    ${status}
                    <table width="555" border="1">
                        <tr>
                            <td colspan="7"><b>Customer Information </b></td>
                        </tr>
                        <tr>
                            <td colspan="3"><b>Customer Name: </b></td>
                            <c:forEach var="c_name" items="${reservations.rows}" begin="0" end="0">
                            <td colspan="4">${c_name.name} ${c_name.surname} </td>
                            </c:forEach>
                        </tr>
                        <tr>
                            <td colspan="7"><b>Reservation Information</b> </td>
                        </tr>
                        <tr>
                            <td><b>Arrival Date</b></td>
                            <td><b>Depart Date</b></td>
                            <td><b>Room Number</b></td>
                            <td><b>Room Type</b></td>
                            <td><b>Room View</b></td>
                            <td><b>Room Price</b></td>
                            <td><b>Check In</b></td>
                        </tr>
                        <c:forEach var="record1" items="${reservations.rows}">
                            <tr>
                                <td >${record1.arrival_date}</td>
                                <td >${record1.depart_date}</td>
                                <td >${record1.room_number}</td>
                                <td >${record1.room_type}</td>
                                <td>${record1.room_view}</td>
                                <td>${record1.room_price}</td>
                                
                                    <c:if test="${record1.check_in == 'y'}">
                                <td><b>IN</b></td>
                                    </c:if>
                                    <c:if test="${record1.check_in == 'n'}">
                                <td><input type="checkbox" value="${record1.reservation_id}" name="reservation_id"></td>
                                    </c:if>
                                    
                            </tr>
                            
                        </c:forEach>
                        
                    </table>
                    
                    <table width="500" border="0">
                      <tr>
                        <td width="181"><input type="submit" name="Submit2" value="Submit"></td>
                        <td width="309"><input type="reset" name="Submit3" value="Reset"></td>
                      </tr>
                    </table>
                    
                </form>
            </div>
            <div class="ndesign" id="nnavi">
                <%@include file="navigation_buttons.jsp"%>
                <font color="white" >${errors}</font>
            </div>
            <div class="ndesign" id="welcome"></div>
        </div>
    </body>
</html>
