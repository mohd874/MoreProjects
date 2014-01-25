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
            <script language="JavaScript" src="java_script/pupdate.js">
            </script>
            
            <%
                String new_date_from = "";
                String new_date_to   = "";
                try{
                    int a_day, a_month, a_year;
                    a_day = Integer.parseInt(request.getParameter("date_from").substring(3,5));
                    //System.out.println("the day is: "+a_day);
                    a_month = Integer.parseInt(request.getParameter("date_from").substring(0,2));
                    //System.out.println("The month is :"+a_month);
                    a_year = Integer.parseInt(request.getParameter("date_from").substring(6,10));
                    //System.out.println("The year is : "+a_year);

                    int d_day, d_month, d_year;
                    d_day = Integer.parseInt(request.getParameter("date_to").substring(3,5));
                    //System.out.println("the day is: "+d_day);
                    d_month = Integer.parseInt(request.getParameter("date_to").substring(0,2));
                    //System.out.println("The month is :"+d_month);
                    d_year = Integer.parseInt(request.getParameter("date_to").substring(6,10));
                    //System.out.println("The year is : "+d_year);

                    new_date_from = (a_year+"-"+a_month+"-"+a_day);
                    new_date_to   = (d_year+"-"+d_month+"-"+d_day);

                }catch (Exception ex){

                }
            %>
            
            <sql:setDataSource url="jdbc:mysql://localhost:3306/dph_db_test" driver="com.mysql.jdbc.Driver" user="root" password="7710072" var="myDB"/>
            
            <sql:transaction dataSource="${myDB}">

                <sql:query var="default">
                
                    Select
                    service_schedule.order_id,
                    service_schedule.`date`,
                    service_schedule.`time`,
                    service_schedule.description,
                    service_schedule.job_done,
                    service_schedule.reservation_id,
                    service_schedule.employee_id,
                    service_schedule.service_no,
                    services.service_type,
                    rooms.room_number,
                    sysuser.user_name,
                    sysuser.name,
                    sysuser.surname,
                    sysuser.user_id,
                    rooms.room_id

                    From
                    service_schedule
                    ,
                    rooms
                    ,
                    sysuser
                    ,
                    customer_reservation
                    ,
                    services
                    Where
                    service_schedule.reservation_id = customer_reservation.reservation_id AND
                    sysuser.user_id = customer_reservation.customer_id AND
                    rooms.room_id = customer_reservation.room_id AND
                    services.service_no = service_schedule.service_no
                    <c:if test="${param.room_number != '' && param.room_number != null}">
                        AND rooms.room_id = '${param.room_number}'    
                    </c:if>
                    <c:if test="${param.employee != '' && param.employee != null}">
                        AND service_schedule.employee_id = '${param.employee}'
                    </c:if>
                    <c:if test="${param.service_type != '' && param.service_type != null}">
                        AND services.service_no = '${param.service_type}'
                    </c:if>
                    <c:if test="${param.customer != '' && param.customer != null}">
                        AND sysuser.user_id = '${param.customer}'
                    </c:if>
                    <c:if test="${param.date_from != '' && param.date_from != null && param.date_to != '' && param.date_to != null}">
                        AND service_schedule.`date` between '<%= new_date_from%>' and '<%= new_date_to%>'
                    </c:if>
                    <c:if test="${param.job_done != '' && param.job_done != null}">
                        <c:if test="${param.job_done == 'y'}">
                            AND service_schedule.job_done = 'job done : yes'
                        </c:if>
                        <c:if test="${param.job_done == 'n'}">
                            AND service_schedule.job_done is null
                        </c:if>
                    </c:if>
                    
                    <c:choose>
                        <c:when test="${param.order == 'service_type'}">
                            order by 
                            services.service_type
                        </c:when>
                        <c:when test="${param.order == 'employee'}">
                            order by 
                            service_schedule.employee_id
                        </c:when>
                        <c:when test="${param.order == 'job_done'}">
                            order by 
                            service_schedule.job_done
                        </c:when>
                        <c:when test="${param.order == 'room_number'}">
                            order by 
                            rooms.room_number
                        </c:when>
                        <c:when test="${param.order == 'customer_name'}">
                            order by 
                            sysuser.name
                        </c:when>
                        <c:when test="${param.order == 'date'}">
                            order by 
                            service_schedule.`date`
                        </c:when>
                        
                    </c:choose>
                </sql:query>
                
                <sql:query var="employees">
                    select user_id, name, surname from sysuser where
                    user_id in (select employee_id from employees)
                    AND user_type = '6'
                </sql:query>
                <%-- 
                <option value="date">Date</option>
                <option value="job_done">Job Done</option>
                <option value="employee">Employee</option>
                <option value="service_type">Service Type</option>
                <option value="room_number">Room Number</option>
                <option value="customer_name">Customer Name</option>
                            
                ${param.room_number}
                ${param.employee}
                ${param.service_type}
                ${param.customer}
                ${param.date_from}
                ${param.date_to}
                ${param.job_done}
                ${param.order}
                --%>    
                <sql:query var="customers">
                    select user_id, name, surname from sysuser where
                    user_id in (select customer_id from customers)
                </sql:query>
                
                <sql:query var="services">
                    select service_no, service_type from services
                </sql:query>
                
                <sql:query var="rooms">
                    select room_id, room_number from rooms
                </sql:query>
                
            </sql:transaction>
            
            <div class="ndesign" id="nmiddlebar">
                <form id="form1" name="form1" method="post" action="report_services.jsp">
                    <table border="0">
                        <tr>
                            <th colspan="5" scope="col">Report Generator panel (Services) </th>
                        </tr>
                        <tr>
                            <td>Room Number: </td>
                            <td><select name="room_number" id="room_number">
                                <option value="">ALL</option>
                                <c:forEach var="room" items="${rooms.rows}">
                                    <option value="${room.room_id}">${room.room_number}</option>
                                </c:forEach>
                            </select></td>
                            <td>Job Done: </td>
                            <td ><select name="job_done" id="job_done">
                                <option value="">ALL</option>
                                <option value="y">Yes</option>
                                <option value="n">No</option>
                            </select></td>
                            <td>Order By:
                            <select name="order">
                                <option value="date">Date</option>
                                <option value="job_done">Job Done</option>
                                <option value="employee">Employee</option>
                                <option value="service_type">Service Type</option>
                                <option value="room_number">Room Number</option>
                                <option value="customer_name">Customer Name</option>
                            </select>							</td>
                        </tr>
                        <tr>
                            <td>
                            Employee:</td>
                            <td colspan="2">
                            <select name="employee" id="employee">
                                <option value="">ALL</option>
                                <c:forEach var="employee" items="${employees.rows}">
                                    <option value="${employee.user_id}">${employee.name} ${employee.surname}</option>
                                </c:forEach>
                            </select>                            </td>
                            <td>
                            Customer Name </td>
                            <td>
                            <select name="customer">
                                <option value="">ALL</option>
                                <c:forEach var="customer" items="${customers.rows}">
                                    <option value="${customer.user_id}">${customer.name} ${customer.surname}</option>
                                </c:forEach>
                            </select>                            </td>
                        </tr>
                        <tr>
                            <td>Service Type: </td>
                            <td colspan="2">
                            <select name="service_type" id="service_type">
                                <option value="">ALL</option>
                                <c:forEach var="service" items="${services.rows}">
                                    <option value="${service.service_no}">${service.service_type}</option>
                                </c:forEach>
                            </select></td>
                            <td>
                            Date:</td>
                            <td  colspan="2">From:
                            <input name="date_from" type="text" id="date_from"><a href="#" style="color:blue" onclick="getCalendarFor(document.form1.date_from);return false">[Choose Date]</a></td>
                            
                        </tr>
                        <tr>
                            <td><input type="submit" name="Submit" value="Submit"></td>
                            <td>&nbsp;</td>
                            <td><input type="reset" name="Reset" value="Reset"></td>
                            <td>&nbsp;</td>
                            <td>To:  
                                &nbsp;&nbsp;&nbsp;&nbsp;<input name="date_to" type="text" id="date_to"><a href="#" style="color:blue" onclick="getCalendarFor(document.form1.date_to);return false">[Choose Date]</a>
                            </td>
                        </tr>
                    </table>	
                </form>
                
                <table border="1">
                    
                    <tr>
                        <td>Service No </td>
                        <td>Date</td>
                        <td>Time</td>
                        <td>Description</td>
                        <td>Job Done </td>
                        <td>Reservation ID </td>
                        <td>Employee</td>
                        <td>Service Type </td>
                        <td>Room Number </td>
                        <td>Customer Name </td>
                    </tr>
                    
                    <c:forEach var="record" items="${default.rows}">
                        <%--<c:if test="${record.employee_id == null}">
                        <sql:query var="employees_job" dataSource="${myDB}">
                        select user_id, name, surname from sysuser where
                        user_id = ${record.employee_id}
                        </sql:query>     
                        </c:if>--%>
                        <tr>
                            <td>${record.service_no}&nbsp;</td>
                            <td>${record.date}&nbsp;</td>
                            <td>${record.time}&nbsp;</td>
                            <td>${record.description}&nbsp;</td>
                            <td>
                                <c:if test="${record.job_done != null && record.job_done != ''}"><font color="green" ><b>${record.job_done}</b></font></c:if>
                                <c:if test="${record.job_done == null || record.job_done == ''}"><font color="red" ><b>job done: no</font></b></c:if>&nbsp;
                            </td>
                            <td>${record.reservation_id}&nbsp;</td>
                            <td>
                            
                            <%--<c:forEach var="emp" items="${employees_job.rows}">
                            ${emp.name} ${emp.surname}
                            </c:forEach>--%>
                            ${record.employee_id}
                            &nbsp;</td>
                            <td>${record.service_type}&nbsp;</td>
                            <td>${record.room_number}&nbsp;</td>
                            <td>${record.name} ${record.surname}&nbsp;</td>
                        </tr>
                    
                    </c:forEach>
                </table>
                
                <form action="report_services_print.jsp" id="form2" name="form2" method="post">
                    <br>
                    <input name="room_number" type="hidden" value="${param.room_number}">
                    <input name="employee" type="hidden" value="${param.employee}">
                    <input name="service_type" type="hidden" value="${param.service_type}">
                    <input name="customer" type="hidden" value="${param.customer}">
                    <input name="date_from" type="hidden" value="${param.date_from}">
                    <input name="date_to" type="hidden" value="${param.date_to}">
                    <input name="job_done" type="hidden" value="${param.job_done}">
                    <input name="order" type="hidden" value="${param.order}">
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
        
        <script language="JavaScript">
            if (document.all) {
            document.writeln("<div id=\"PopUpCalendar\" style=\"position:absolute; left:0px; top:0px; z-index:7; width:200px; height:77px; overflow: visible; visibility: hidden; background-color: #FFFFFF; border: 1px none #000000\" onMouseOver=\"if(ppcTI){clearTimeout(ppcTI);ppcTI=false;}\" onMouseOut=\"ppcTI=setTimeout(\'hideCalendar()\',500)\">");
            document.writeln("<div id=\"monthSelector\" style=\"position:absolute; left:0px; top:0px; z-index:9; width:181px; height:27px; overflow: visible; visibility:inherit\">");}
            else if (document.layers) {
            document.writeln("<layer id=\"PopUpCalendar\" pagex=\"0\" pagey=\"0\" width=\"200\" height=\"200\" z-index=\"100\" visibility=\"hide\" bgcolor=\"#FFFFFF\" onMouseOver=\"if(ppcTI){clearTimeout(ppcTI);ppcTI=false;}\" onMouseOut=\"ppcTI=setTimeout('hideCalendar()',500)\">");
            document.writeln("<layer id=\"monthSelector\" left=\"0\" top=\"0\" width=\"181\" height=\"27\" z-index=\"9\" visibility=\"inherit\">");}
            else {
            document.writeln("<p><font color=\"#FF0000\"><b>Error ! The current browser is either too old or too modern (usind DOM document structure).</b></font></p>");}
        </script>
        <noscript><p><font color="#FF0000"><b>JavaScript is not activated !</b></font></p></noscript>
        <table border="1" cellspacing="1" cellpadding="2" width="200" bordercolorlight="#000000" bordercolordark="#000000" vspace="0" hspace="0"><form name="ppcMonthList"><tr><td align="center" bgcolor="#CCCCCC"><a href="javascript:moveMonth('Back')" onMouseOver="window.status=' ';return true;"><font face="Arial, Helvetica, sans-serif" size="2" color="#000000"><b>< </b></font></a><font face="MS Sans Serif, sans-serif" size="1"> 
        <select name="sItem" onMouseOut="if(ppcIE){window.event.cancelBubble = true;}" onChange="switchMonth(this.options[this.selectedIndex].value)" style="font-family: 'MS Sans Serif', sans-serif; font-size: 9pt"><option value="0" selected>2000 ? January</option><option value="1">2000 ? February</option><option value="2">2000 ? March</option><option value="3">2000 ? April</option><option value="4">2000 ? May</option><option value="5">2000 ? June</option><option value="6">2000 ? July</option><option value="7">2000 ? August</option><option value="8">2000 ? September</option><option value="9">2000 ? October</option><option value="10">2000 ? November</option><option value="11">2000 ? December</option><option value="0">2001 ? January</option></select></font><a href="javascript:moveMonth('Forward')" onMouseOver="window.status=' ';return true;"><font face="Arial, Helvetica, sans-serif" size="2" color="#000000"><b> ></b></font></a></td></tr></form></table>
        <table border="1" cellspacing="1" cellpadding="2" bordercolorlight="#000000" bordercolordark="#000000" width="200" vspace="0" hspace="0"><tr align="center" bgcolor="#CCCCCC"><td width="20" bgcolor="#FFFFCC"><b><font face="MS Sans Serif, sans-serif" size="1">Su</font></b></td><td width="20"><b><font face="MS Sans Serif, sans-serif" size="1">Mo</font></b></td><td width="20"><b><font face="MS Sans Serif, sans-serif" size="1">Tu</font></b></td><td width="20"><b><font face="MS Sans Serif, sans-serif" size="1">We</font></b></td><td width="20"><b><font face="MS Sans Serif, sans-serif" size="1">Th</font></b></td><td width="20"><b><font face="MS Sans Serif, sans-serif" size="1">Fr</font></b></td><td width="20" bgcolor="#FFFFCC"><b><font face="MS Sans Serif, sans-serif" size="1">Sa</font></b></td></tr></table>
        <script language="JavaScript">
            if (document.all) {
            document.writeln("</div>");
            document.writeln("<div id=\"monthDays\" style=\"position:absolute; left:0px; top:52px; z-index:8; width:200px; height:17px; overflow: visible; visibility:inherit; background-color: #FFFFFF; border: 1px none #000000\"> </div></div>");}
            else if (document.layers) {
            document.writeln("</layer>");
            document.writeln("<layer id=\"monthDays\" left=\"0\" top=\"52\" width=\"200\" height=\"17\" z-index=\"8\" bgcolor=\"#FFFFFF\" visibility=\"inherit\"> </layer></layer>");}
            else {/*NOP*/}
        </script>
    </body>
</html>
