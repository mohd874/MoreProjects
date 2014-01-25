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
	  <form id="form1" name="form1" method="post" action="registeration.page">
	    <table width="500" border="0">
          <tr>
            <td colspan="2"><h1><strong><em><font color="#3399FF" face="Arial, Helvetica, sans-serif">Account Information</font></em></strong></h1></td>
          </tr>
          <tr>
            <td width="157">User name: </td>
            <td width="327"><label>
              <input name="uname" type="text" id="uname" />
              <font color="#CC3300">*</font></label></td>
          </tr>
          <tr>
            <td>Password:</td>
            <td><input name="pass" type="password" id="pass" />
              <font color="#CC3300">*</font></td>
          </tr>
          <tr>
            <td>Confirm Password: </td>
            <td><input name="con_pass" type="password" id="con_pass" />
              <font color="#CC3300">*</font></td>
          </tr>
          <tr>
            <td colspan="2"><h1><strong><em><font color="#3399FF" face="Arial, Helvetica, sans-serif">Personal Information </font></em></strong></h1></td>
            </tr>
          <tr>
            <td>Name:</td>
            <td><input name="name" type="text" id="name" />
              <font color="#CC3300">*</font></td>
          </tr>
          <tr>
            <td>Sur Name: </td>
            <td><input name="sur_name" type="text" id="sur_name" />
              <font color="#CC3300">*</font></td>
          </tr>
          <tr>
            <td>Title:</td>
            <td><label>
              <select name="title" id="title">
                <option value="mr" selected="selected">Mr.</option>
                <option value="dr">Dr.</option>
                <option value="miss">Miss</option>
                <option value="mrs">Mrs.</option>
              </select>
              <font color="#CC3300">*</font></label></td>
          </tr>
          <tr>
            <td>Phone Number: </td>
            <td><label>
              <input name="pre_phone" type="text" id="pre_phone" size="6" />
            - 
            <input name="phone" type="text" id="phone" />
            </label></td>
          </tr>
          <tr>
            <td>Moblie Number: </td>
            <td><input name="pre_mobile" type="text" id="pre_mobile" size="6" />
-
  <input name="mobile" type="text" id="mobile" />
  <font color="#CC3300">*</font></td>
          </tr>
          <tr>
            <td>Fax:</td>
            <td><input name="fax" type="text" id="fax" /></td>
          </tr>
          <tr>
            <td>Address:</td>
            <td><input name="address" type="text" id="address" />
              <font color="#CC3300">*</font></td>
          </tr>
          <tr>
            <td>Passport Number: </td>
            <td><input name="passport" type="text" id="passport" /></td>
          </tr>
          <tr>
            <td>P.O.Box:</td>
            <td><input name="b_o_box" type="text" id="b_o_box" /></td>
          </tr>
          <tr>
            <td>Nationality:</td>
            <td><label>
              <select name="nationality" id="nationality">
                <option value="bahrain">Bahrain</option>
                <option value="saudi">Saudi Arabia</option>
                <option value="uae">UAE</option>
                <option value="uk">UK</option>
                <option value="other">Other</option>
              </select>
            </label></td>
          </tr>
          <tr>
            <td>E-mail:</td>
            <td><input name="email" type="text" id="email" />
              <font color="#CC3300">*</font></td>
          </tr>
          <tr>
            <td>Send Account information to the E-mail: </td>
            <td><label>
              <input name="email_confirmation" type="radio" value="y" />
              Yes</label>
              <label>
              <input name="email_confirmation" type="radio" value="n" checked="checked" />
              No</label></td>
          </tr>
          <tr>
            <td><label>
              <input type="submit" name="Submit" value="Submit" />
            </label></td>
            <td><label>
              <input type="reset" name="Submit2" value="Reset" />
            </label></td>
          </tr>
        </table>
          </form>
	  </div>
    </div></td>
  </tr>
  <tr>
    <th width="200" height="200" scope="row"><div id="clock">
      <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="201" height="202">
        <param name="movie" value="SWF/Clock.swf" />
        <param name="quality" value="high" />
        <embed src="../Clock.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="201" height="202"></embed>
      </object>
    </div></th>
  </tr>
</table>
</body>
</html>
