<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

        <title>Services</title>

        <script language="JavaScript" src="java_script/pupdate.js">
        </script>
    </head>

    <body>
        <jsp:useBean id="tracing_bean" scope="session" class="com.hotel.model.tracing_bean"/>
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
            
        </sql:transaction>
        <form name="form1" method="post" action="services_control.page">
            ${msg}
            <table width="500" border="0">
                <tr>
                    <td>User Name: </td>
                    <td><label>
                        <input type="text" name="uname" readonly="true" value="${tracing_bean.uname}">
                    </label></td>
                </tr>
                <tr>
                    <td>Service Type: </td>
                    <td><label>
                        <select name="service_id" size="1">
                            <option value="" selected>select</option>
                            <c:forEach var="record" items="${service.rows}">
                                <option value="${record.service_no}" > ${record.service_type} </option>
              
                            </c:forEach>
      
                        </select>
                    </label></td>
                </tr>
                <tr>
                    <td>Date:</td>
                    <td><label>
                        <input name="date" type="text" id="date">
                    </label><a href="#" onclick="getCalendarFor(document.form1.date);return false">[Choose Date]</a></td>
                </tr>
                <tr>
                    <td>Time:</td>
                    <td><label>
                    <input name="hours" type="text" id="hours" size="4" maxlength="2">
                    -
                    <input name="minuts" type="text" id="minuts" size="4" maxlength="2">
                    (the format of time is HH-MM using 24 time system)</label></td>
                </tr>
                <tr>
                    <td>Description:</td>
                    <td><label>
                        <textarea name="description" cols="50" rows="4" id="description"></textarea>
                    </label></td>
                </tr>
                <tr>
                    <td>Rooms to serve </td>
                    <td><label>
                        <c:forEach var="record" items="${rooms.rows}">
                            <input type="checkbox" name="selectedRooms" value="${record.room_id}"> ${record.room_number} <br>
                        </c:forEach>
                    </label></td>
                </tr>
                <tr>
                    <td><label>
                        <input type="submit" name="Submit" value="Submit">
                    </label></td>
                    <td><label>
                        <input name="reset" type="reset" id="reset" value="Reset">
                    </label></td>
                </tr>
            </table>
            

        </form>


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
