<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservation Confirmation</title>
    </head>
    <body>
        <jsp:useBean id="tracing_bean" class="com.hotel.model.tracing_bean" scope="session"/>
    
        <sql:setDataSource url="jdbc:mysql://localhost:3306/dph_db_test" driver="com.mysql.jdbc.Driver" user="root" password="7710072" var="myDB"/>
    
        <sql:transaction dataSource="${myDB}">
            <sql:query var="rooms">
                select r.room_id, room_number, confirmation from rooms r, customer_reservation c where r.room_id in (select c.room_id from customer_reservation) AND customer_id = '${tracing_bean.userID}'
            </sql:query>
        </sql:transaction>
        <table width="500" height="130" border="1">
            <tr>
                <th colspan="3" scope="col"><h1><strong>Reservation Confirmation </strong></h1></th>
            </tr>
            <tr>
                <th width="200" scope="col">User Name: </th>
                <th width="284" colspan="2" scope="col"><label> ${tracing_bean.uname} </label></th>
            </tr>
            <tr>
                <th height="24" colspan="3" scope="row"><h2>Reserved Rooms</h2></th>
            </tr>
            <tr>
                <th scope="row">Room Number</th>
                <th scope="row">Room Status </th>
                <th scope="row">Action</th>
            </tr>
            <c:forEach var="record" items="${rooms.rows}">
                <tr>
                    <th scope="row">${record.room_number}</th>
                    <td>
                    <c:choose>
                        <c:when test="${record.confirmation == 'n'}">
                        Not Confirmed
                        </c:when>
                        <c:when test="${record.confirmation == 'y'}">
                        Confirmed
                        </c:when>
                    </c:choose>
                    </td>
                    <td>
                        <input type="radio" name="action" value="y" checked>confirm</input>    
                        <input type="radio" name="action" value="n">cancel</input>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <input type="submit" value="Submit">&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Reset">
    
    
    </body>
</html>
