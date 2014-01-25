<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>employee registration</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
</head>

<body>
<sql:setDataSource url="jdbc:mysql://localhost:3306/dph_db_test" driver="com.mysql.jdbc.Driver" user="root" password="7710072" var="myDB"/>

        <sql:transaction dataSource="${myDB}">
            <sql:query var="service">
                select service_no, service_type from services
            </sql:query>
        </sql:transaction>
Fill all the fields with the proper information
<font color="red"> ${errors} </font>
<form name="form1" method="post" action="emp_registration_control.page">
  <table width="500" border="1">
    <tr>
      <td colspan="2"><div align="center"><strong>Account Information </strong></div></td>
    </tr>
    <tr>
      <td>User Name: </td>
      <td><label>
        <input name="user_name" type="text" id="user_name">
      </label></td>
    </tr>
    <tr>
      <td>Password:</td>
      <td><label>
        <input name="password" type="password" id="password">
      </label></td>
    </tr>
    <tr>
      <td>Confirm Password: </td>
      <td><label>
        <input name="con_password" type="password" id="con_password">
      </label></td>
    </tr>
    <tr>
      <td colspan="2"><div align="center"><strong>Personal Information </strong></div></td>
    </tr>
    <tr>
      <td>Name:</td>
      <td><label>
        <input name="name" type="text" id="name">
      </label></td>
    </tr>
    <tr>
      <td>Sur Name: </td>
      <td><label>
        <input name="surname" type="text" id="surname">
      </label></td>
    </tr>
    <tr>
      <td>Phone Number: </td>
      <td><label>
        <input name="phone_number" type="text" id="phone_number">
      </label></td>
    </tr>
    <tr>
      <td>Mobile Number: </td>
      <td><label>
        <input name="mobile_number" type="text" id="mobile_number">
      </label></td>
    </tr>
    <tr>
      <td>B.O.Box:</td>
      <td><label>
        <input type="text" name="b_o_box">
      </label></td>
    </tr>
    <tr>
      <td>Address:</td>
      <td><label>
        <textarea name="address" rows="4" id="address"></textarea>
      </label></td>
    </tr>
    <tr>
      <td>Passport Number: </td>
      <td><label>
        <input name="passport_number" type="text" id="passport_number">
      </label></td>
    </tr>
    <tr>
      <td>Nationality:</td>
      <td><label>
        <input name="nationality" type="text" id="nationality">
      </label></td>
    </tr>
    <tr>
      <td>Job Title: </td>
      <td><label>
        <input name="job_title" type="text" id="job_title">
      </label></td>
    </tr>
    <tr>
      <td>Marital Status: </td>
      <td><label>
        <select name="marital_status" size="1">
          <option value="single">Single</option>
          <option value="married">Married</option>
        </select>
      </label></td>
    </tr>
    <tr>
      <td>Gender:</td>
      <td><label>
        <select name="gender" size="1">
          <option value="male">Male</option>
          <option value="female">Female</option>
        </select>
      </label></td>
    </tr>
    <tr>
      <td>Years of Exp: </td>
      <td><label>
        <input name="years_of_exp" type="text" id="years_of_exp">
      </label></td>
    </tr>
    <tr>
      <td>Service Type: </td>
      <td><label>
        <select name="service_type">
          <option>select</option>
          <c:forEach var="record" items="${service.rows}">
              <option value="${record.service_no}">${record.service_type}</option>
          </c:forEach>
        </select>
      </label></td>
    </tr>
    <tr>
      <td><label>
        <input type="submit" name="Submit" value="Submit">
      </label></td>
      <td><input name="reset" type="reset" value="Reset"></td>
    </tr>
  </table>
</form>
</body>
</html>
