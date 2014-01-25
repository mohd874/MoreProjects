<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Invoice</title>
        <style type="text/css">
            <!--
            @import url("CSS/ndesign.css");
            -->
        </style>
        <SCRIPT Language="Javascript">

        /*
        This script is written by Eric (Webcrawl@usa.net)
        For full source code, installation instructions,
        100's more DHTML scripts, and Terms Of
        Use, visit dynamicdrive.com
        */

        function printit(){  
        if (window.print) {
        window.print() ;  
        } else {
        var WebBrowser = '<OBJECT ID="WebBrowser1" WIDTH=0 HEIGHT=0 CLASSID="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></OBJECT>';
        document.body.insertAdjacentHTML('beforeEnd', WebBrowser);
        WebBrowser1.ExecWB(6, 2);//Use a 1 vs. a 2 for a prompting dialog box    WebBrowser1.outerHTML = "";  
        }
        }
        </script>

    </head>

    <body>
        <% 
            SimpleDateFormat sdf = new SimpleDateFormat();
            Date d = new Date();

            sdf.applyPattern("yyyy-MM-dd");
            String shortDate = sdf.format(d);

            sdf.applyPattern("hh:mm:ss");
            String shortTime = sdf.format(d);

        %>
        
        <%@include file="trace_n_taglib2.jsp"%>
        <%@page import="java.text.SimpleDateFormat, java.util.Date"%>
            
        <sql:setDataSource url="jdbc:mysql://localhost:3306/dph_db_test" driver="com.mysql.jdbc.Driver" user="root" password="7710072" var="myDB"/>
            
        <sql:transaction dataSource="${myDB}">
            <c:if test="${param.user_id != '' && param.user_id != null}">
                <sql:query var="user">
                    Select s.name,s.surname,r.room_number,r.room_type,r.room_price,r.room_view,(datediff(c.depart_date,c.arrival_date)) as days,c.depart_date,c.arrival_date,(datediff(c.depart_date,c.arrival_date) * r.room_price) as single_room_price From sysuser AS s , rooms AS r , customer_reservation AS c Where s.user_id = c.customer_id AND r.room_id = c.room_id and user_id = ${param.user_id} and depart_date = (select curdate())
                </sql:query>
                <sql:query var="user_name">
                    Select s.name,s.surname From sysuser AS s , rooms AS r , customer_reservation AS c Where s.user_id = c.customer_id AND r.room_id = c.room_id and user_id = ${param.user_id} and depart_date = (select curdate())
                </sql:query>
                    
                <%-- this query gives error
                <sql:query var="grand">
                Select  sum((datediff(c.depart_date,c.arrival_date) * r.room_price)) as total
                From 
                sysuser AS s , 
                rooms AS r , 
                customer_reservation AS c 
                Where 
                s.user_id = c.customer_id AND r.room_id = c.room_id and user_id = ${param.user_id} and depart_date = (select curdate())
                group by
                s.name
                </sql:query>
                --%>
                    
            </c:if>
                
            <sql:query var="customer">
                select user_id, name, surname from sysuser where user_id in (select customer_id from customers)
            </sql:query>
                    
        </sql:transaction>
        <div id="invoice" class="ndesign">
             
            <table width="500" border="0" cellspacing="0">
                <tr>
                    <td>Date:</td>
                    <td><input type="text" name="date" value="<%= shortDate.toString() %>"></td>
                    <td><label>Time:</label></td>
                    <td><label>
                        <input type="text" name="time" value="<%= shortTime.toString() %>">
                    </label></td>
                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><input type="text" name="user_name" value="${tracing_bean.uname}"></td>
                    <td><label>Name: </label></td>
                    <td><label>
                        <input type="text" name="name" value="${tracing_bean.name}">
                    </label></td>
                </tr>
            </table>
            <br>
            <table border="1" align="center" >
                    
                <tr>
                    <td colspan="6"style="color:blue"><b><h2>Customer Information</h2></b></td>
                            
                </tr>
                <c:forEach var="name" items="${user_name.rows}" begin="0" end="0">
                    <tr>
                        <td><b>Customer Name</b></td>
                        <td colspan="5">${name.name} ${name.surname}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="6" style="color:blue"><b><h2>Reservation Information</h2></b></td>
                       
                </tr>
                        
                <tr>
                    <td><b>Room Number</b></td>
                    <td><b>Type</b></td>
                    <td><b>View</b></td>
                    <td><b>Price</b></td>
                    <td><b>How many Days</b></td>
                    <td><b>Single Room Total</b></td>
                </tr>
                    
                <% 
                    int grandTotal = 0;
                %>
                    
                <c:forEach var="record" items="${user.rows}">
                    <tr>
                        <td>${record.room_number}</td>
                        <td>${record.room_type}</td>
                        <td>${record.room_view}</td>
                        <td>${record.room_price}</td>
                        <td>${record.days}</td>
                        <td>${record.single_room_price}</td>
                            
                    </tr>
                    <% grandTotal += Integer.parseInt ((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.single_room_price}", java.lang.String.class, (PageContext)_jspx_page_context, null, false)); %>
                </c:forEach>
                <tr>
                    <td colspan="4">
                    
                    </td>
                    <td>
                        <b>Grand Total</b>
                    </td>
                    <td>
                        <%= grandTotal %>
                    </td>
                </tr>
            </table>            <br>
            <SCRIPT Language="Javascript">  
            var NS = (navigator.appName == "Netscape");
            var VERSION = parseInt(navigator.appVersion);
            if (VERSION > 3) {
            document.write('<form><input type=button value="Print this Page" name="Print" onClick="printit()"></form>');        
            }
            </script>
            </form>
        </div>
    </body>
</html>
