<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Reservation</title>
        <style type="text/css">
            <!--
            @import url("CSS/ndesign.css");
            -->
        </style>

        <script language="JavaScript" src="java_script/pupdate.js">
        </script>
        
    </head>

    <body>
        <div class="ndesign" id="cssall">
            <div class="ndesign" id="nlocation">
                <div align="center">
                    <p>&nbsp;</p>
                    <p><img src="location gif/Reservation.gif" width="295" height="100"></p>
                </div>
            </div>
            <%@include file="trace_n_taglib2.jsp"%>
            <div class="ndesign" id="nwelcome">
                <div align="center"> ${tracing_bean.title} ${tracing_bean.name}</div>
            </div>
            <div class="ndesign" id="nclock">
                <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="100" height="100">
                    <param name="movie" value="SWF/Clock.swf">
                    <param name="quality" value="high">
                    <embed src="SWF/Clock.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="100" height="100"></embed>
                </object>
            </div>
            
            <sql:setDataSource url="jdbc:mysql://localhost:3306/dph_db_test" driver="com.mysql.jdbc.Driver" user="root" password="7710072" var="myDB"/>
                
            <sql:transaction dataSource="${myDB}">
                <sql:query var="customers">
                    select user_id, name, surname from sysuser where user_id in (select customer_id from customers)
                </sql:query>
            </sql:transaction>
            
            <div class="ndesign" id="ncenter">
                
                <form id="form1" name="form1" method="post" action="reservation.page">
                    
                    <table width="475" height="559" border="0" cellspacing="0">
                        <tr>       
                            <td>
                                Select Customer:
                            </td>
                            <td>
                                <select name="user_id" id="user_id">
                                    <option value="">SELECT</option>
                                    <c:forEach var="record" items="${customers.rows}">
                                        <option value="${record.user_id}" <c:if test="${field_values.customer_id == record.user_id}"> selected </c:if> >${record.name} ${record.surname}</option>
                                    </c:forEach>
                                </select><font color="red">* ${field_values.ht["user_id"]}</font>
                            </td>
                        </tr>
                       
                        <tr>
                            <td height="43">Date of Arrival:
                            <label></label></td>
                            <td><p>
                                <input type="text" name="date_arrival" readonly="true" value="${field_values.ard}"/>
                                <font color="red">* </font><a href="#" style="color:blue" onclick="getCalendarFor(document.form1.date_arrival);return false">[Choose Date]</a><font color="red"> ${field_values.ht["ard"]}</font></p>
                            </td>
                        </tr>
                        <tr>
                            <td height="43">Date of Depart:</td>
                            <td><p>
                                <input type="text" name="date_depart" readonly="true" value="${field_values.dpd}"/>
                                <font color="red">* </font><a href="#" style="color:blue" onclick="getCalendarFor(document.form1.date_depart);return false">[Choose Date]</a><font color="red"> ${field_values.ht["dpd"]}</font></p>
                            </td>
                        </tr>
                        <tr>
                            <td height="43">Flight Number: </td>
                            <td><label>
                                <input name="flight" type="text" id="flight" value="${field_values.flight}"/>
                            </label></td>
                        </tr>
                        <tr>
                            <td height="43">Credit Card No:
                            <label> </label></td>
                            <td><input name="credit_card_no" type="text" maxlength="30" value="${field_values.ccn}"/>
                            <font color="red">* ${field_values.ht["ccn"]}</font></td>
                        </tr>
                        <%--<tr>
                        <td height="43">Credit Card Type:</td>
                        <td><select name="credit_card_type">
                        <option value="select" selected="selected">Select</option>
                        <option value="master_card">Master Card</option>
                        <option value="visa_card">Visa Card</option>
                        <option value="american_experess">American Experess</option>
                        </select>
                        <font color="red">* ${field_values.ht["cct"]}</font></td>
                        </tr>--%>
                        <tr>
                            <td height="43"> Credit Card Expiry  Month:
                            <label></label></td>
                            <td><select name="expiry_month">
                                <option value="">Select</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                            </select>
                            <font color="red">* ${field_values.ht["expm"]}</font></td>
                        </tr>
                        <tr>
                            <td height="43">Credit Card Expiry Year:
                            <label></label>
                            <label></label></td>
                            <td><select name="expiry_year">
                                <option value="">Select</option>
                                <option value="2000">2000</option>
                                <option value="2001">2001</option>
                                <option value="2002">2002</option>
                                <option value="2003">2003</option>
                                <option value="2004">2004</option>
                                <option value="2005">2005</option>
                                <option value="2006">2006</option>
                                <option value="2007">2007</option>
                                <option value="2008">2008</option>
                                <option value="2009">2009</option>
                                <option value="2010">2010</option>
                                <option value="2011">2011</option>
                                <option value="2012">2012</option>
                                <option value="2013">2013</option>
                                <option value="2014">2014</option>
                                <option value="2015">2015</option>
                                <option value="2016">2016</option>
                                <option value="2017">2017</option>
                                <option value="2018">2018</option>
                                <option value="2019">2019</option>
                                <option value="2020">2020</option>
                                <option value="2021">2021</option>
                                <option value="2022">2022</option>
                                <option value="2023">2023</option>
                                <option value="2024">2024</option>
                                <option value="2025">2025</option>
                                <option value="2026">2026</option>
                                <option value="2027">2027</option>
                                <option value="2028">2028</option>
                                <option value="2029">2029</option>
                                <option value="2030">2030</option>
                                <option value="2031">2031</option>
                                <option value="2032">2032</option>
                                <option value="2033">2033</option>
                                <option value="2034">2034</option>
                                <option value="2035">2035</option>
                                <option value="2036">2036</option>
                                <option value="2037">2037</option>
                                <option value="2038">2038</option>
                                <option value="2039">2039</option>
                                <option value="2040">2040</option>
                                <option value="2041">2041</option>
                                <option value="2042">2042</option>
                                <option value="2043">2043</option>
                                <option value="2044">2044</option>
                                <option value="2045">2045</option>
                                <option value="2046">2046</option>
                                <option value="2047">2047</option>
                                <option value="2048">2048</option>
                                <option value="2049">2049</option>
                                <option value="2050">2050</option>
                            </select>
                            <font color="red">* ${field_values.ht["expy"]}</font></td>
                        </tr>
                        <tr>
                            <td height="43">Confirm Now:</td>
                            <td>Yes
                            <label>
                                <input name="confirmation" type="radio" value="y"/>
                            </label>
                            No
                            <label>
                                <input name="confirmation" type="radio" value="n" checked="checked"/>
                            </label><font color="red">* ${field_values.ht["cfm"]}</font></td>
                        </tr>
                        <tr>
                            <td height="43">Note:</td>
                            <td><label>
                                <textarea name="note" id="note" ><c:if test="${field_values.note != ''}"> ${field_values.note} </c:if></textarea>
                            </label></td>
                        </tr>
                        <tr>
                            <td height="43"><div align="center">
                                <input type="submit" name="Submit" value=" Next " />
                            </div></td>
                            <td><input name="reset" type="reset" id="reset" value="Reset" /></td>
                        </tr>
                        <tr>
                            <td height="43" colspan="2"><div align="center"></div></td>
                        </tr>
                    </table>
                    <p>
                        <label></label>
                    </p>
                    <p align="left">
                        <label></label>
                    </p>
                    <p>
                        <label></label>
                        <label></label>
                    </p>
                    <p>&nbsp;</p>
                    <p>
                        <label></label>
                        <label></label>
                        <label></label>
                    </p>
                    <p>
                        <label></label>
                        <label></label>
                    </p>
                    <p>
                        <label></label>
                        <label></label>
                    </p>
                </form>
                        
                        
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
