<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Service</title>
    </head>
    <body>
    ${errors}
    <form name="form1" method="post" action="add_service_control.page">
      <table width="500" height="138">
        <tr>
          <th colspan="2" scope="col"><h1>Add Service</h1></th>
        </tr>
        <tr>
          <th scope="row">Service Type: </th>
          <td><label>
            <input name="service_type" type="text" id="service_type">
          </label></td>
        </tr>
        <tr>
          <th scope="row">Service Description: </th>
          <td><label>
          <textarea name="service_desc" id="service_desc"></textarea>
          </label></td>
        </tr>
        <tr>
          <th scope="row"><label>
            <input type="submit" name="Submit" value="Submit">
          </label></th>
          <td><label>
            <input name="reset" type="reset" id="reset" value="Reset">
          </label></td>
        </tr>
      </table>
      <p></p>
      <p></p>
      <p></p>
          <p>
            <a href="home.jsp">HOME</a>
          </p>
      
    </form>

    
    </body>
</html>
