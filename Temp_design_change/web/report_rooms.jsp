<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Rooms Report</title>
        <style type="text/css">
            <!--
            @import url("CSS/ndesign.css");
            -->
        </style>
    </head>

    <body>
        <div class="ndesign" id="cssall2">
            <div class="ndesign" id="nlocation">
                <div align="center">
                    <p>&nbsp;</p>
                    <p><img src="location gif/Reports.gif" width="295" height="100"></p>
                </div>
            </div>
            <%@include file="trace_n_taglib2.jsp"%> 
            <div class="ndesign" id="nclock">
                <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="100" height="100">
                    <param name="movie" value="SWF/Clock.swf">
                    <param name="quality" value="high">
                    <embed src="SWF/Clock.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="100" height="100"></embed>
                </object>
            </div>
            <sql:setDataSource url="jdbc:mysql://localhost:3306/dph_db_test" driver="com.mysql.jdbc.Driver" user="root" password="7710072" var="myDB"/>
            
            <sql:transaction dataSource="${myDB}">
                <c:choose>
                    <c:when test="${param.status == 'all'}">
                        <sql:query var="rooms_report_part_1">
                            Select
                            r.room_number,
                            r.room_type,
                            r.room_price,
                            r.room_view,
                            s.name,
                            s.surname
                            From
                            rooms AS r
                            ,
                            sysuser AS s
                            ,
                            customers AS c
                            ,
                            customer_reservation cr
                            where 
                            s.user_id = c.customer_id and
                            r.room_id = cr.room_id and
                            s.user_id = cr.customer_id
                            <c:if test="${param.type != '' && param.type != null}">
                                and  r.room_type = '${param.type}' 
                            </c:if>
                            <c:if test="${param.view != '' && param.view != null}">
                                and  r.room_view = '${param.view}' 
                            </c:if>
                            <c:if test="${param.user_id != '' && param.user_id != null}">
                                and  s.user_id = '${param.user_id}' 
                            </c:if>
                            and ( select curdate() ) between cr.arrival_date and cr.depart_date
                            order by r.room_number    
                        </sql:query>
                        <sql:query var="rooms_report_part_2">
                            Select
                            r.room_number,
                            r.room_type,
                            r.room_price,
                            r.room_view
                            From
                            rooms AS r
                            where
                            r.room_id not in (select room_id from customer_reservation) 
                            <c:if test="${param.type != '' && param.type != null}">
                                and  r.room_type = '${param.type}' 
                            </c:if>
                            <c:if test="${param.view != '' && param.view != null}">
                                and  r.room_view = '${param.view}' 
                            </c:if>
                            
                            order by r.room_number    
                        </sql:query>
                    </c:when>
                    
                    <c:when test="${param.status == 'o'}">
                        <sql:query var="rooms_report_part_1">
                            Select
                            r.room_number,
                            r.room_type,
                            r.room_price,
                            r.room_view,
                            s.name,
                            s.surname
                            From
                            rooms AS r
                            ,
                            sysuser AS s
                            ,
                            customers AS c
                            ,
                            customer_reservation cr
                            where 
                            s.user_id = c.customer_id and
                            r.room_id = cr.room_id and
                            s.user_id = cr.customer_id
                            <c:if test="${param.type != '' && param.type != null}">
                                and  r.room_type = '${param.type}' 
                            </c:if>
                            <c:if test="${param.view != '' && param.view != null}">
                                and  r.room_view = '${param.view}' 
                            </c:if>
                            <c:if test="${param.user_id != '' && param.user_id != null}">
                                and  s.user_id = '${param.user_id}' 
                            </c:if>
                            and ( select curdate() ) between cr.arrival_date and cr.depart_date
                            order by r.room_number    
                        </sql:query>
                    </c:when>
                    
                    <c:when test="${param.status == 'n'}">
                        <sql:query var="rooms_report_part_2">
                            Select
                            r.room_number,
                            r.room_type,
                            r.room_price,
                            r.room_view
                            From
                            rooms AS r
                            where
                            r.room_id not in (select room_id from customer_reservation) 
                            <c:if test="${param.type != '' && param.type != null}">
                                and  r.room_type = '${param.type}' 
                            </c:if>
                            <c:if test="${param.view != '' && param.view != null}">
                                and  r.room_view = '${param.view}' 
                            </c:if>
                            order by r.room_number    
                        </sql:query>
                    </c:when>
                    
                </c:choose>
                <sql:query var="t">
                    select distinct(room_type) from rooms    
                </sql:query>
                
                <sql:query var="v">
                    select distinct(room_view) from rooms    
                </sql:query>
                
                <sql:query var="n">
                    select name,surname from sysuser where user_id in  (select customer_id from customers)
                </sql:query>
                
            </sql:transaction>
            
            <div class="ndesign" id="nmiddlebar">
                <form id="form1" name="form1" method="post" action="report_rooms.jsp">
                    <table width="500" border="0">
                        <tr>
                            <th colspan="6" scope="col">Report Generator panel (Rooms) </th>
                        </tr>
                        <tr>
                            <td width="97">
                            Room Status:                            </td>
                            <td width="69" colspan="2">
                            <select name="status">
                                <option value="all">ALL</option>
                                <option value="o">Occupied</option>
                                <option value="n">Empty</option>
                            </select>                            </td>
                            <td width="84">
                            Room Type:                            </td>
                            <td width="131">
                            <select name="type">
                                <option value="">ALL</option>
                                <c:forEach var="t_record" items="${t.rows}">
                                    <option value="${t_record.room_type}">${t_record.room_type}</option>
                                </c:forEach>
                            </select>                            </td>
                            <td width="97">&nbsp;</td>
                        </tr>
                        <tr>
                            <td>
                            Room View:                            </td>
                            <td colspan="2">
                            <select name="view">
                                <option value="">ALL</option>
                                <c:forEach var="v_record" items="${v.rows}">
                                    <option value="${v_record.room_view}">${v_record.room_view}</option>
                                </c:forEach>
                            </select>                            </td>
                            <td colspan="2">
                            Customer Name & Surname<b> (for Occupied Rooms only)</b>                           </td>
                            <td>
                            <select name="name">
                                <option value="">ALL</option>
                                <c:forEach var="n_record" items="${n.rows}">
                                    <option value="${n_record.user_id}">${n_record.name}, ${n_record.surname} </option>
                                </c:forEach>
                            </select>                            </td>
                        </tr>
                        <tr>
                            <td><input type="submit" name="Submit" value="Submit"></td>
                            <td>&nbsp;</td>
                            <td><input type="reset" name="Reset" value="Reset"></td>
                            <td colspan="2">&nbsp;</td>
                            <td>&nbsp;</td>
                        </tr>
                    </table>
				
                </form>
                <table border="1">
                    <tr>
                        <td colspan="6" align="center">
                            <b><h1><font color="blue">Rooms Report</font></h1></b>
                        </td>
                    </tr>
                    <c:if test="${param.status == 'all' || param.status == 'o'}">
                        <tr>
                            <td colspan="6" align="center">
                                <b><h2><font color="blue">The Occupied Rooms</font></h2></b>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                number
                            </td>
                            <td>
                                type
                            </td>
                            <td>
                                price
                            </td>
                            <td>
                                view
                            </td>
                            <td>
                                customer name
                            </td>
                            <td>
                                customer surname
                            </td>
                        </tr>
                    </c:if>
                    <c:forEach var="record" items="${rooms_report_part_1.rows}">
                        <tr>
                            <td>
                                ${record.room_number}
                            </td>
                            <td>
                                ${record.room_type}
                            </td>
                            <td>
                                ${record.room_price}
                            </td>
                            <td>
                                ${record.room_view}
                            </td>
                            <td>
                                ${record.name}
                            </td>
                            <td>
                                ${record.surname}
                            </td>
                        </tr>    
                    </c:forEach>
                    <c:if test="${param.status == 'all' || param.status == 'n'}">
                        <tr>
                            <td colspan="6" align="center">
                                <b><h2><font color="blue">The Empty Rooms</font></h2></b>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                number
                            </td>
                            <td>
                                type
                            </td>
                            <td>
                                price
                            </td>
                            <td>
                                view
                            </td>
                            <td>
                                customer name
                            </td>
                            <td>
                                customer surname
                            </td>
                        </tr>
                    </c:if>
                    <c:forEach var="record" items="${rooms_report_part_2.rows}">
                        <tr>
                            <td>
                                ${record.room_number}
                            </td>
                            <td>
                                ${record.room_type}
                            </td>
                            <td>
                                ${record.room_price}
                            </td>
                            <td>
                                ${record.room_view}
                            </td>
                            <td>
                                ${record.name}&nbsp;
                            </td>
                            <td>
                                ${record.surname}&nbsp;
                            </td>
                        </tr>    
                    </c:forEach>
                </table>
                <form action="report_rooms_print.jsp" id="form2" name="form2" method="post">
                    <br>
                    <input name="view" type="hidden" value="${param.view}">
                    <input name="type" type="hidden" value="${param.type}">
                    <input name="status" type="hidden" value="${param.status}">
                    <input name="user_id" type="hidden" value="${param.user_id}">
				
                    &nbsp;&nbsp;&nbsp;<input name="submit" type="submit" value="Print Frindly Page">
                </form>
            </div>
            <div class="ndesign" id="nwelcome">
                <div align="center" style="color:white" >${tracing_bean.title} ${tracing_bean.name}</div>
            </div>
            <div class="ndesign" id="nnavi">
                <%@include file="navigation_buttons.jsp"%>
            </div>
            <div class="ndesign" id="welcome"></div>
        </div>
    </body>
</html>
