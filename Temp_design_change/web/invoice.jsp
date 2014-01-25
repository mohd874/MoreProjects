<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Welcome to Daffodils Palace Hotel</title>
        <style type="text/css">
            <!--
            @import url("CSS/ndesign.css");
            -->
        </style>
    </head>

    <body>
        <div class="ndesign" id="cssall">
            <div class="ndesign" id="nlocation">
                <div align="center">
                    <p>&nbsp;</p>
                    <p><img src="location gif/Invoice.gif" width="295" height="100"></p>
                </div>
            </div>
            <%@include file="trace_n_taglib2.jsp"%> 
            <div class="ndesign" id="nwelcome">
                <div align="center">${tracing_bean.title} ${tracing_bean.name}</div>
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
            
            <div class="ndesign" id="ncenter">
                
                <form name="form1" action="invoice.jsp" method="post">
                    Select a customer: <select name="user_id">
                        <option value="">Select</option> 
                        <c:forEach var="names" items="${customer.rows}">
                            <option value="${names.user_id}">${names.name}, ${names.surname}</option> 
                        </c:forEach>
                    </select> <input type="submit" value="Submit">
                </form>
                
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
                </table>
                 <form action="invoice_print.jsp" id="form2" name="form2" method="post">
                    <br>
                    <input name="user_id" type="hidden" value="${param.user_id}">
                    &nbsp;&nbsp;&nbsp;<input name="submit" type="submit" value="Print Frindly Page">
                </form>
            </div>
            <div class="ndesign" id="nnavi">
                <%@include file="navigation_buttons.jsp"%>
                <font color="white" >${errors}</font>
            </div>
            <div class="ndesign" id="welcome"></div>
        </div>
    </body>
</html>
