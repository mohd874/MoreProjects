<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
<style type="text/css" media="all">
<!--
@import url("CSS/hotel.css");
-->
</style>
</head>

<body>
<table width="800" height="600" border="0" cellspacing="0" bgcolor="#FDD398">
  <tr>
    <th width="200" height="100" scope="col"><div id="logo"></div></th>
    <th width="300" height="100" scope="col"><div id="location"></div></th>
    <th width="300" height="100" scope="col"><div id="menu"></div></th>
  </tr>
  <tr>
    <th height="300" width="200" scope="row" bgcolor="#FDD398"><div id="navi"></div></th>
    <td colspan="2" rowspan="2"><div id="center"></br>
	<div id="center_center">
	  <h1><em>Thank you for reserving in Daffodils Palace Hotel</em> </h1>
          <jsp:forward page="home.jsp"/>
	</div>
    </div></td>
  </tr>
  <tr>
    <th width="200" height="200" scope="row"><div id="clock">
      <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="201" height="202">
        <param name="movie" value="SWF/Clock.swf" />
        <param name="quality" value="high" />
        <embed src="SWF/Clock.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="201" height="202"></embed>
      </object>
    </div></th>
  </tr>
</table>
</body>
</html>
