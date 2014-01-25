<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Events Report</title>
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
                <sql:query var="events">
                    Select
                    es.appointment_no,
                    es.date_from,
                    es.date_to,
                    e.event_type,
                    e.event_desc,
                    e.event_price,
                    es.`comment`,
                    es.total_price,
                    s.name,
                    s.surname,
                    s.mobile_number
                    From
                    events AS e
                    ,
                    event_schedule AS es
                    ,
                    sysuser AS s

                    where e.event_id = es.event_id 
                    <c:if test="${param.event_type != '' && param.event_type != null && param.event_type != 'all'}">
                        and e.event_id = ${param.event_type}
                    </c:if>
                    <c:if test="${param.customer_id != '' && param.customer_id != null}">
                        and user_id = ${param.customer_id}
                    </c:if>
                    
                    <% if(!new_date_from.equalsIgnoreCase("")  
                    && !new_date_to.equalsIgnoreCase("") ) { %>
                    
                    and date_to between '<%= new_date_from %>' and '<%= new_date_to %>'
                    <% } %>
                    
                    <c:if test="${param.min_price != '' && param.min_price != null && param.max_price != '' && param.max_price != null}">
                        and event_price between ${param.min_price} and ${param.max_price}
                    </c:if>
                    and s.user_id = es.customer_id
                </sql:query>
                
                <sql:query var="event_types">
                    select * from events
                </sql:query>
                <sql:query var="event_customers">
                    select name,surname,user_id from sysuser where user_id in (select customer_id from event_schedule)
                </sql:query>
                
            </sql:transaction>
            <script language="JavaScript" src="java_script/pupdate.js">
            </script>
            
            <div class="ndesign" id="nmiddlebar">
                 
                <form id="form1" name="form1" method="post" action="report_events.jsp">
                    <table  border="0">
                        <tr>
                            <th colspan="7" scope="col">Report Generator panel (Events) </th>
                        </tr>
                        <tr>
                            <td >
                            Events type:                            </td>
                            <td colspan="2">
                            <select name="event_type">
                                <option value="all">ALL</option>
                                <c:forEach var="type" items="${event_types.rows}">
                                    <option value="${type.event_id}">${type.event_type}</option>
                                </c:forEach>
                            </select>                            </td>
				
                            <td >
                            Customer Name:                            </td>
                            <td colspan="3">
                            <select name="customer_id">
                                <option value="">ALL</option>
                                <c:forEach var="customer" items="${event_customers.rows}">
                                    <option value="${customer.user_id}">${customer.name} ${customer.surname}</option>
                                </c:forEach>
                            </select></td>
                        </tr>
                        <tr>
                            <td>
                            Date:                            </td>
                            <td colspan="4">From:                            
                            <input name="date_from" type="text" id="date_from">
                            <a href="#" style="color:blue" onclick="getCalendarFor(document.form1.date_from);return false">[Choose Date]</a></td>
                            <td>
                            Base Price:                              </td>
                            <td>Max:
                            <input name="max_price" type="text" id="max_price"></td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                            <td colspan="4">To:
                          
                            &nbsp;&nbsp;&nbsp;&nbsp;<input name="date_to" type="text" id="date_to">
                            <a href="#" style="color:blue" onClick="getCalendarFor(document.form1.date_to);return false">[Choose Date]</a></td>
                            <td>&nbsp;</td>
                            <td>Min:&nbsp;
                            <input name="min_price" type="text" id="min_price"></td>
                        </tr>
                        <tr>
                            <td><input type="submit" name="Submit" value="Submit"></td>
                            <td >&nbsp;</td>
                            <td ><input type="reset" name="Reset" value="Reset"></td>
                            <td colspan="2">&nbsp;</td>
                            <td colspan="2">&nbsp;</td>
                        </tr>
                    </table>
				
                </form>
                
                <table  border="1">
                    <tr>
                        <td>
                        Appointment	No				</td>
                        <td>Date From </td>
                        <td>Date To</td>
                        <td>Event Type </td>
                        <td>Descreption</td>
                        <td>Base Price </td>
                        <td>Total Price </td>
                        <td>Comment</td>
                        <td>Customer Name </td>
                        <td>Customer Mobile </td>
                    </tr>
                    <c:forEach var="event" items="${events.rows}">
                        <tr>
                            <td>${event.appointment_no}&nbsp;</td>
                            <td>${event.date_from}&nbsp;</td>
                            <td>${event.date_to}&nbsp;</td>
                            <td>${event.event_type}&nbsp;</td>
                            <td>${event.event_desc}&nbsp;</td>
                            <td>${event.event_price}&nbsp;</td>
                            <td>${event.total_price}&nbsp;</td>
                            <td>${event.comment}&nbsp;</td>
                            <td>${event.name} ${event.surname}&nbsp;</td>
                            <td>${event.mobile_number}&nbsp;</td>
                        </tr>
                    </c:forEach>
                </table>
                <form action="report_events_print.jsp" id="form2" name="form2" method="post">
                    <br>
                    <input name="event_type" type="hidden" value="${param.event_type}">
                    <input name="customer_id" type="hidden" value="${param.customer_id}">
                    <input name="date_from" type="hidden" value="${param.date_from}">
                    <input name="date_to" type="hidden" value="${param.date_to}">
                    <input name="min_price" type="hidden" value="${param.min_price}">
                    <input name="max_price" type="hidden" value="${param.max_price}">
                    &nbsp;&nbsp;&nbsp;<input name="submit" type="submit" value="Print Frindly Page">
                </form>
         
            </div>
            <div class="ndesign" id="nwelcome">
                <div align="center" style="color:white" >${tracing_bean.title} ${tracing_bean.name}</div>
            </div>
            <div class="ndesign" id="nnavi">
                <%@include file="navigation_buttons.jsp"%>
                <font color="white" >${errors}</font>
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
