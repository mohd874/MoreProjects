<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Events Panel</title>
        
        <script language="JavaScript" src="java_script/pupdate.js">
        </script>
        
    </head>
    <body>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <form name="form1" method="post" action="events_control.page">
            <label>Date from: 
                <input type="text" name="dateF">
                <a href="#" onclick="getCalendarFor(document.form1.dateF);return false">[Choose Date]</a>
            </label>
            <p>
                <label>Date to:
                    <input type="text" name="dateT">
                    <a href="#" onclick="getCalendarFor(document.form1.dateT);return false">[Choose Date]</a>
                </label>
            </p>
            <p>Total price       </p>
            <p>
                <label>Min:
                    <input type="text" name="minP">
                </label>&nbsp;&nbsp;
                <label>Max:
                    <input type="text" name="maxP">
                </label>
            </p>
            <p>
                <label>Customer name:
                    <input type="text" name="c_name">
                </label>
            </p>
            <p>
                <label>Facility type:
                    <input type="text" name="typeF">
                </label>
            </p>
            <p>
                <label>Event type:
                    <input type="text" name="typeE">
                </label>
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
            <p>To 'Add' new event click <a href="before_add_event.page">HERE</a> </p>
        
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
                            ${record.comment}
                        </td>
                        <td>
                            ${record.total_price}
                        </td>
                        <td>
                            ${record.description}
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
                        <td>
                            <input type="checkbox" id="selectedResults" name="selectedResults" value="${record.appointment_no}">
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
        <%
            /*
            ResultSet res = (ResultSet)request.getAttribute("results");


            if(res != null){
            //out.println("first loop!!!");
            res.beforeFirst();
            String appointment_no = "";
            while(res.next()){

            out.println("<tr>");
            out.println("<td>");
            out.println(res.getString("appointment_no")); appointment_no = res.getString("appointment_no");
            out.println("</td>");
            out.println("<td>");
            out.println(res.getString("date_from"));
            out.println("</td>");
            out.println("<td>");
            out.println(res.getString("date_to"));
            out.println("</td>");
            out.println("<td>");
            out.println(res.getString("comment"));
            out.println("</td>");
            out.println("<td>");
            out.println(res.getString("total_price"));
            out.println("</td>");
            out.println("<td>");
            out.println(res.getString("description"));
            out.println("</td>");
            out.println("<td>");
            out.println(res.getString("customer_id"));
            out.println("</td>");
            out.println("<td>");
            out.println(res.getString("facility_no"));
            out.println("</td>");
            out.println("<td>");
            out.println(res.getString("event_id"));
            out.println("</td>");
            out.println("<td>");
            out.println("<input type=checkbox id=selectedResults value="+ appointment_no +">");
            out.println("</td>");
            out.println("</tr>");

            }
            }else{
            out.print("jsp: res in null");
            }
            out.println("</table>");

            res = (ResultSet)request.getSession().getAttribute("results");


            if(res != null){
            res.beforeFirst();
            out.println("second loop!!!");
            while(res.next()){
            out.println(res.getString("total_price"));
            }
            }else{
            out.print("jsp2: res in null");
            }
             */
        %>
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
        <select name="sItem" onMouseOut="if(ppcIE){window.event.cancelBubble = true;}" onChange="switchMonth(this.options[this.selectedIndex].value)" style="font-family: 'MS Sans Serif', sans-serif; font-size: 9pt"><option value="0" selected>2000  January</option><option value="1">2000  February</option><option value="2">2000  March</option><option value="3">2000  April</option><option value="4">2000  May</option><option value="5">2000  June</option><option value="6">2000  July</option><option value="7">2000  August</option><option value="8">2000  September</option><option value="9">2000  October</option><option value="10">2000  November</option><option value="11">2000  December</option><option value="0">2001  January</option></select></font><a href="javascript:moveMonth('Forward')" onMouseOver="window.status=' ';return true;"><font face="Arial, Helvetica, sans-serif" size="2" color="#000000"><b> ></b></font></a></td></tr></form></table>
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
