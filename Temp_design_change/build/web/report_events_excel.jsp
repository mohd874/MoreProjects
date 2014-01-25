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

            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=" + "report_events.xls" );
        %>
        
        <%@include file="trace_n_taglib2.jsp"%>
        <%@page import="java.text.SimpleDateFormat, java.util.Date"%>
            
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
        <div id="event" class="ndesign">
             
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
            <br>
            
            </form>
        </div>
    </body>
</html>
