<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>events</title> 
        
    </head>
    <body>
    
    <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <script language="JavaScript" src="java_script/pupdate.js">
        </script>
        
    <form name="form1" method="post" action="add_event.page">
        ${msg}
      <p>Date from: 
        <label>
        <input type="text" name="dateF">
        </label><a href="#" onclick="getCalendarFor(document.form1.dateF);return false">[Choose Date]</a>
      </p>
      <p>Date To:
        <label>
        <input type="text" name="dateT">
        </label><a href="#" onclick="getCalendarFor(document.form1.dateT);return false">[Choose Date]</a>
      </p>
      <p>Comment(any extra things):
        <label>
        <textarea name="comment"></textarea>
        </label>
      </p>
      <p>Total Price:
        <label>
        <input type="text" name="price">
        </label>
      </p>
      <p>Description(To be displayed on the home page):
        <label>
        <textarea name="desc"></textarea>
        </label>
      </p>
      <p>Customer Name: 
        <label>
        <select name="name">
          <c:forEach var="record" items="${result_names.rows}">
              <option value="${record.user_id}"><c:out value="${record.name}, ${record.surname}"/></option>
          </c:forEach>
        </select>
        </label>
      </p>
      <p>Facility:
        <label>
        <select name="facility">
            <c:forEach var="record" items="${result_facilities.rows}">
              <option value="${record.facility_no}"><c:out value="${record.facility_type}"/></option>
          </c:forEach>
        </select>
        </label>
      </p>
      <p>Event Type: 
        <label>
        <select name="event">
            <c:forEach var="record" items="${result_events.rows}">
              <option value="${record.event_id}"><c:out value="${record.event_type}"/></option>
          </c:forEach>
        </select>
        </label>
      </p>
      <p>
        <label>
        <input type="submit" name="Submit" value="Submit">
        </label>&nbsp;&nbsp;&nbsp;
        <label>
        <input type="reset" name="Submit2" value="Reset">
        </label>
      </p>
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
