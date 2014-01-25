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
            response.setHeader("Content-Disposition", "attachment; filename=" + "report_services.xls" );

%>
        
    
        <%@include file="trace_n_taglib2.jsp"%>
        <%@page import="java.text.SimpleDateFormat, java.util.Date"%>
            
        <sql:setDataSource url="jdbc:mysql://localhost:3306/dph_db_test" driver="com.mysql.jdbc.Driver" user="root" password="7710072" var="myDB"/>
            
        <sql:transaction dataSource="${myDB}">
            <sql:query var="default">
                
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
                    <c:if test="${param.room_number != '' && param.room_number != null}">
                        AND rooms.room_id = '${param.room_number}'    
                    </c:if>
                    <c:if test="${param.employee != '' && param.employee != null}">
                        AND service_schedule.employee_id = '${param.employee}'
                    </c:if>
                    <c:if test="${param.service_type != '' && param.service_type != null}">
                        AND services.service_no = '${param.service_type}'
                    </c:if>
                    <c:if test="${param.customer != '' && param.customer != null}">
                        AND sysuser.user_id = '${param.customer}'
                    </c:if>
                    <c:if test="${param.date_from != '' && param.date_from != null && param.date_to != '' && param.date_to != null}">
                        AND service_schedule.`date` between '<%= new_date_from%>' and '<%= new_date_to%>'
                    </c:if>
                    <c:if test="${param.job_done != '' && param.job_done != null}">
                        <c:if test="${param.job_done == 'y'}">
                            AND service_schedule.job_done = 'job done : yes'
                        </c:if>
                        <c:if test="${param.job_done == 'n'}">
                            AND service_schedule.job_done is null
                        </c:if>
                    </c:if>
                    
                    <c:choose>
                        <c:when test="${param.order == 'service_type'}">
                            order by 
                            services.service_type
                        </c:when>
                        <c:when test="${param.order == 'employee'}">
                            order by 
                            service_schedule.employee_id
                        </c:when>
                        <c:when test="${param.order == 'job_done'}">
                            order by 
                            service_schedule.job_done
                        </c:when>
                        <c:when test="${param.order == 'room_number'}">
                            order by 
                            rooms.room_number
                        </c:when>
                        <c:when test="${param.order == 'customer_name'}">
                            order by 
                            sysuser.name
                        </c:when>
                        <c:when test="${param.order == 'date'}">
                            order by 
                            service_schedule.`date`
                        </c:when>
                        
                    </c:choose>
                </sql:query>
                
                <sql:query var="employees">
                    select user_id, name, surname from sysuser where
                    user_id in (select employee_id from employees)
                    AND user_type = '6'
                </sql:query>
                <%-- 
                <option value="date">Date</option>
                <option value="job_done">Job Done</option>
                <option value="employee">Employee</option>
                <option value="service_type">Service Type</option>
                <option value="room_number">Room Number</option>
                <option value="customer_name">Customer Name</option>
                            
                ${param.room_number}
                ${param.employee}
                ${param.service_type}
                ${param.customer}
                ${param.date_from}
                ${param.date_to}
                ${param.job_done}
                ${param.order}
                --%>    
                <sql:query var="customers">
                    select user_id, name, surname from sysuser where
                    user_id in (select customer_id from customers)
                </sql:query>
                
                <sql:query var="services">
                    select service_no, service_type from services
                </sql:query>
                
                <sql:query var="rooms">
                    select room_id, room_number from rooms
                </sql:query>
                    
        </sql:transaction>
    <div id="services" class="ndesign">
             
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
            
                    <tr>
                        <td>Service No </td>
                        <td>Date</td>
                        <td>Time</td>
                        <td>Description</td>
                        <td>Job Done </td>
                        <td>Reservation ID </td>
                        <td>Employee</td>
                        <td>Service Type </td>
                        <td>Room Number </td>
                        <td>Customer Name </td>
                    </tr>
                    
                    <c:forEach var="record" items="${default.rows}">
                        <%--<c:if test="${record.employee_id == null}">
                        <sql:query var="employees_job" dataSource="${myDB}">
                        select user_id, name, surname from sysuser where
                        user_id = ${record.employee_id}
                        </sql:query>     
                        </c:if>--%>
                        <tr>
                            <td>${record.service_no}&nbsp;</td>
                            <td>${record.date}&nbsp;</td>
                            <td>${record.time}&nbsp;</td>
                            <td width="100" >${record.description}&nbsp;</td>
                            <td>
                                <c:if test="${record.job_done != null && record.job_done != ''}"><font color="green" ><b>${record.job_done}</b></font></c:if>
                                <c:if test="${record.job_done == null || record.job_done == ''}"><font color="red" ><b>job done: no</font></b></c:if>&nbsp;
                            </td>
                            <td>${record.reservation_id}&nbsp;</td>
                            <td>
                            
                            <%--<c:forEach var="emp" items="${employees_job.rows}">
                            ${emp.name} ${emp.surname}
                            </c:forEach>--%>
                            ${record.employee_id}
                            &nbsp;</td>
                            <td>${record.service_type}&nbsp;</td>
                            <td>${record.room_number}&nbsp;</td>
                            <td>${record.name} ${record.surname}&nbsp;</td>
                        </tr>
                    
                    </c:forEach>
      </table>
            <br>
            
            </form>
            
    </div>
    </body>
</html>
