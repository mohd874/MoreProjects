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
        <div id="rooms" class="ndesign">
             
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
            <table border="1" align="center">  
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
            <br>
            </form>
            
                <form action="report_rooms_excel.jsp" id="form2" name="form2" method="post">
                    <br>
                    <input name="view" type="hidden" value="${param.view}">
                    <input name="type" type="hidden" value="${param.type}">
                    <input name="status" type="hidden" value="${param.status}">
                    <input name="user_id" type="hidden" value="${param.user_id}">
				
                    &nbsp;&nbsp;&nbsp;<input name="submit" type="submit" value="Export to Excel">
                </form>
        </div>
    </body>
</html>
