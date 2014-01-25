<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Customer Services</title>
        <style type="text/css">
            <!--
            @import url("CSS/ndesign.css");
            -->
        </style>
        <script language="JavaScript" src="java_script/pupdate.js">
        </script>
        
        <script>
            <!--

            /*
            Auto Refresh Page with Time script
            By JavaScript Kit (javascriptkit.com)
            Over 200+ free scripts here!
            */

            //enter refresh time in "minutes:seconds" Minutes should range from 0 to inifinity. Seconds should range from 0 to 59
            var limit="0:30"

            if (document.images){
            var parselimit=limit.split(":")
            parselimit=parselimit[0]*60+parselimit[1]*1
            }
            function beginrefresh(){
            if (!document.images)
            return
            if (parselimit==1)
            window.location.reload()
            else{ 
            parselimit-=1
            curmin=Math.floor(parselimit/60)
            cursec=parselimit%60
            if (curmin!=0)
            curtime=curmin+" minutes and "+cursec+" seconds left until page refresh!"
            else
            curtime=cursec+" seconds left until page refresh!"
            window.status=curtime
            setTimeout("beginrefresh()",1000)
            }
            }

            window.onload=beginrefresh
            //-->
        </script>

    </head>

    <body>
        <div class="ndesign" id="cssall2">
            <div class="ndesign" id="nlocation">
                <div align="center">
                    <p>&nbsp;</p>
                    <p><img src="location gif/Customer_Ord.gif" width="295" height="100"></p>
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
            <div class="ndesign" id="nmiddlebar">
                
                <!-- if the user was a guest -->
                <c:if test="${tracing_bean.utype == 5}">
                    <jsp:forward page="home.jsp"/>
                </c:if>

                <sql:setDataSource url="jdbc:mysql://localhost:3306/dph_db_test" driver="com.mysql.jdbc.Driver" user="root" password="7710072" var="myDB"/>

                <sql:transaction dataSource="${myDB}">
                    <sql:query var="service">
                        select service_no, service_type from services
                    </sql:query>
                    <sql:query var="rooms">
                        select room_id, room_number from rooms where room_id in (select room_id from customer_reservation)
                    </sql:query>
                    <sql:query var="customers">
                        select user_id, name, surname from sysuser where user_id in (select customer_id from customer_reservation)
                    </sql:query>
                    <sql:query var="defult">
                        ${query}
                        <c:if test="${query == null}">
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
                            <c:if test="${param.customers != '' && param.customers != null}">
                                and sysuser.user_id = ${param.customers}
                            </c:if>
                            
                            <c:if test="${param.rooms != '' && param.rooms != null}">
                                and rooms.room_id = ${param.rooms}
                            </c:if>

                            <c:if test="${param.date_from != '' && param.date_from != null && param.date_to != '' && param.date_to != null}">
                                and service_schedule.`date`between ${param.date_from} and ${param.date_to}
                            </c:if>
                            
                            order by 
                            service_schedule.employee_id

                        </c:if>
                    </sql:query>
                    <sql:query var="employees">
                        Select
                        sysuser.user_id,
                        sysuser.name,
                        sysuser.surname
                        From
                        sysuser
                        where
                        user_id in (select employee_id from employees) AND
                        user_type = '6'

                    </sql:query>
    
                </sql:transaction>

                <form name="form1" method="post" action="services_officer.jsp">
                    <label></label>
                    <p>&nbsp;</p>
                    <table width="809" height="180" border="0">
                        <tr>
                            <th colspan="2" scope="row"><h1>Services search </h1></th>
                        </tr>
                        <tr>
                            <th width="190" scope="row">Officer name:</th>
                            <td width="603"><input type="text" name="uname" readonly="true" value="${tracing_bean.uname}"></td>
                        </tr>
                        <tr>
                            <th scope="row">Customers:</th>
                            <td><select name="customers">
                                <option value="">select</option>
                                <c:forEach var="record" items="${customers.rows}">
                                    <option value="${record.user_id}">${record.name} ${record.surname}</option>
                                </c:forEach>
                            </select></td>
                        </tr>
                        <tr>
                            <th scope="row">Reservaed Rooms:</th>
                            <td><select name="rooms">
                                <option value="">select</option>
                                <c:forEach var="record" items="${rooms.rows}">
                                    <option value="${record.room_id}">${record.room_number}</option>
                                </c:forEach>
                            </select></td>
                        </tr>
                        <tr>
                            <th scope="row">Dates:</th>
                            <td>From: 
                            <label>
                                <input type="text" name="date_from"><a href="#" style="color:blue" onclick="getCalendarFor(document.form1.date_from);return false">[Choose Date]</a>
                            </label> 
                            To:
                            <label>
                                <input type="text" name="date_to"><a href="#" style="color:blue" onclick="getCalendarFor(document.form1.date_to);return false">[Choose Date]</a>
                            </label></td>
                        </tr>
                        <tr>
                            <th scope="row"><label>
                                <input type="submit" name="Submit" value="search">
                            </label></th>
                            <td>&nbsp;</td>
                        </tr>
                    </table>
                    <p>
                        <label></label>
                    </p>
                    <p>&nbsp; </p>
                </form>
                <a href="home.jsp">HOME</a>
                <form id="form2" action="services_update.page" method="post">
                    <font color="red">${errors}</font>
                    <table border="1">
                        <tr>
               
                            <td><b>Order status</b></td>
                            <td><b>order_id</b></td>
                            <td><b>date</b></td>
                            <td><b>time</b></td>
                            <td><b>description</b></td>
                            <td><b>job done</b></td>
                            <td><b>reservation_id</b></td>
                            <td><b>employee name</b></td>
                            <td><b>service type</b></td>
                            <td><b>room number</b></td>
                            <td><b>customer name</b></td>
                            <td><b>Assign</b></td>
                        
                        </tr>
                        
                        <c:forEach var="record" items="${defult.rows}" >
                            <tr>
                                <td>
                                    <c:choose>
                                        <c:when test="${record.employee_id == null}">
                                            <font color="red"><b> Unassigned order </b></font> 
                                        </c:when>
                                        <c:when test="${record.employee_id != null}">
                                            <font color="green"><b> Assigned order </b></font> 
                                        </c:when>
                                    </c:choose>              
                                </td>
                                <td>${record.order_id}</td>
                                <td>${record.date}</td>
                                <td>${record.time}</td>
                                    <td>${record.description}&nbsp;</td>
                                <td>
                            
                                    <select name="job_done" <c:if test="${record.job_done != null}"> disabled="true" </c:if> >
                                        <option value="">No</option>
                                        <option value="${record.order_id}" <c:if test="${record.job_done != null}"> selected </c:if> >Yes</option>
                                    </select> 
                            
                                </td>
                                <td>${record.reservation_id}</td>
                                
                                <td>
                                    <c:choose>
                                        <c:when test="${record.employee_id == null}">
                                            <select name="emp_id" size="1">
                                                <option value="" selected>select</option>
                                                <c:forEach var="emp" items="${employees.rows}">
                                                    <option value="${emp.user_id}">${emp.name} ${emp.surname}</option>
                                                </c:forEach>
                                            </select>
                                        </c:when>
                                        <c:when test="${record.employee_id != null}">
                                
                                            <sql:query var="emp_name" dataSource="${myDB}">
                                                select name, surname from sysuser where user_id = ${record.employee_id}
                                            </sql:query>
                                
                                            <c:forEach var="name" items="${emp_name.rows}">
                                                ${name.name} ${name.surname}
                                            </c:forEach>
                                        </c:when>
                                    </c:choose>
                                </td>
                        
                                <td>${record.service_type}</td>
                                <td>${record.room_number}</td>
                                <td>${record.name} ${record.surname}</td>
                        
                                <td> 
                                    <select name="order_id" <c:if test="${record.employee_id != null}"> disabled="true" </c:if> >
                                        <option value="">No </option>
                                        <option value="${record.order_id}">Yes </option>
                                    </select>
                                </td>
                        
                            </tr>
                        </c:forEach>
                
                        <tr> 
                            <td>
                                <input type="submit" value="Submit" >
                            </td>
                            <td>
                                <input type="reset" value="Reset" >
                            </td>
                        </tr>
                
                    </table>
            
                </form>
                
                
            </div>
            <div class="ndesign" id="nwelcome">
                <div align="center" style="color:white"> ${tracing_bean.title} ${tracing_bean.name} </div>
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
        <select name="sItem" onMouseOut="if(ppcIE){window.event.cancelBubble = true;}" onChange="switchMonth(this.options[this.selectedIndex].value)" style="font-family: 'MS Sans Serif', sans-serif; font-size: 9pt"><option value="0" selected>2000 • January</option><option value="1">2000 • February</option><option value="2">2000 • March</option><option value="3">2000 • April</option><option value="4">2000 • May</option><option value="5">2000 • June</option><option value="6">2000 • July</option><option value="7">2000 • August</option><option value="8">2000 • September</option><option value="9">2000 • October</option><option value="10">2000 • November</option><option value="11">2000 • December</option><option value="0">2001 • January</option></select></font><a href="javascript:moveMonth('Forward')" onMouseOver="window.status=' ';return true;"><font face="Arial, Helvetica, sans-serif" size="2" color="#000000"><b> ></b></font></a></td></tr></form></table>
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
