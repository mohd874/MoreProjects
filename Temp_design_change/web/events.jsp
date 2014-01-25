<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <style type="text/css">
            <!--
            @import url("CSS/ndesign.css");
            -->
        </style>
        <title>Events Panel</title>
        <script language="JavaScript" src="java_script/pupdate.js">
        </script>
    </head>

    <body>
        <div class="ndesign" id="cssall2">
            <div class="ndesign" id="nlocation">
                <div align="center">
                    <p>&nbsp;</p>
                    <p><img src="location gif/Events.gif" width="295" height="100"></p>
                </div>
            </div>
            <%@include file="trace_n_taglib.jsp"%>
            
            <div class="ndesign" id="nclock">
                <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="100" height="100">
                    <param name="movie" value="SWF/Clock.swf">
                    <param name="quality" value="high">
                    <embed src="SWF/Clock.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="100" height="100"></embed>
                </object>
            </div>
            
            <sql:setDataSource url="jdbc:mysql://localhost:3306/dph_db_test" driver="com.mysql.jdbc.Driver" user="root" password="7710072" var="myDB"/>

            <sql:transaction dataSource="${myDB}">
                <sql:query var="result_names">
                    select user_id, name, surname from sysuser where user_id in (select customer_id from customers)
                </sql:query>
                <sql:query var="result_facilities">
                    select * from facilities
                </sql:query>
                <sql:query var="result_events">
                    select * from events
                </sql:query>
                    
            </sql:transaction>
            <div class="ndesign" id="nmiddlebar">
                ${status} <%-- from add event --%>
                <form name="form1" method="post" action="events_control.page">
                    <label>Date from: 
                        <input type="text" name="dateF" value="01/01/1900">
                        <a href="#" onclick="getCalendarFor(document.form1.dateF);return false" style="color:blue">[Choose Date]</a>
                    </label>
                    <p>
                        <label>Date to:
                            <input type="text" name="dateT" value="12/31/9999">
                            <a href="#" onclick="getCalendarFor(document.form1.dateT);return false" style="color:blue">[Choose Date]</a>
                        </label>
                    </p>
                    <p>Total price</p>
                    <p>
                        <label>Min:
                            <input type="text" name="minP">
                        </label>&nbsp;&nbsp;
                        <label>Max:
                            <input type="text" name="maxP">
                        </label>
                    </p>
                    <p>Customer Name: 
                        <label>
                            <select name="c_name">
                                <option value="">Select</option>
                                <c:forEach var="record" items="${result_names.rows}">
                                    <option value="${record.user_id}"><c:out value="${record.name}, ${record.surname}"/></option>
                                </c:forEach>
                            </select>
                        </label>
                        <font color="red"> ${ht["name"]} </font>
                    </p>
                    <p>Facility:
                        <label>
                            <select name="typeF">
                                <option value="">Select</option>
                                <c:forEach var="record" items="${result_facilities.rows}">
                                    <option value="${record.facility_no}"><c:out value="${record.facility_type}"/></option>
                                </c:forEach>
                            </select>
                        </label>
                        <font color="red"> ${ht["facility"]} </font>
                    </p>
                    <p>Event Type: 
                        <label>
                            <select name="typeE">
                                <option value="">Select</option>
                                <c:forEach var="record" items="${result_events.rows}">
                                    <option value="${record.event_id}"><c:out value="${record.event_type}"/></option>
                                </c:forEach>
                            </select>
                        </label>
                        <font color="red"> ${ht["event"]} </font>
                    </p>
                    <p>Action to be performed: 
                        <label>
                        <input name="act" type="radio" value="s" checked>
                        Search</label> 
                        <label>
                        <input name="act" type="radio" value="d">
                        Delete</label> 
                        <label>
                        <input name="act" type="radio" value="e">
                        Edit</label>
                    </p>
                    <p>
                        <label>
                            <input type="submit" name="Submit" value="Submit">
                        </label>
                    </p>
                    <p>To 'Add' new event click <a href="add_event.jsp" style="color:blue">HERE</a> </p>
                    <font color="red">${error}</font>
                    <table border="1">
                        <tr>
                            <td>
                                appointment ID
                            </td>
                            <td>
                                Date From
                            </td>
                            <td>
                                Date To
                            </td>
                            <td>
                                comment
                            </td>
                            <td>
                                total price
                            </td>
                            <td>
                                description
                            </td>
                            <td>
                                customer ID
                            </td>
                            <td>
                                facility ID
                            </td>
                            <td>
                                event ID
                            </td>
                            <td>
                                Selection
                            </td>
                        </tr>
        
                        <c:forEach var="record" items="${results1.rows}" varStatus="count">
                            <tr>
                                <td>
                                    ${record.appointment_no}
                                </td>
                                <td>
                                    ${record.date_from}
                                </td>
                                <td>
                                    ${record.date_to}
                                </td>
                                <td>
                                    ${record.comment}&nbsp;
                                </td>
                                <td>
                                    ${record.total_price}
                                </td>
                                <td>
                                    ${record.description}&nbsp;
                                </td>
                                <td>
                                    ${record.customer_id}
                                </td>
                                <td>
                                    ${record.facility_no}
                                </td>
                                <td>
                                    ${record.event_id}
                                </td>
                                <td align="center">
                                    <input type="checkbox" id="selectedResults" name="selectedResults" value="${record.appointment_no}">
                                </td>
                            </tr>
                        </c:forEach>
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
