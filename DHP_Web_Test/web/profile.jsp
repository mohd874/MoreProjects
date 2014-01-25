<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>profile</title>
    </head>
    <body>
        <form id="form1" method="post" action="profile_control.page">
            <table width="500" border="0">
                <tr>
                    <td colspan="2"><h1><strong><em><font color="#3399FF" face="Arial, Helvetica, sans-serif">Account Information</font></em></strong></h1></td>
                </tr>
                <c:forEach var="record" items="${user_info.rows}">
                    <tr>
                        <td width="182">User name: </td>
                        <td width="308"><label>
                            <input name="uname" type="text" id="uname" value="${record.user_name}" readonly="true"/>
                        </label></td>
                    </tr>
                    <tr>
                        <td colspan="2"><h3><strong>Changing Password </strong><font color="#FF0000">( leave it empty if you don't want to change it ) </font></h3> </td>
                    </tr>
                    <tr>
                        <td>Old Password:</td>
                        <td><input name="old_pass" type="password" id="old_pass" /></td>
                    </tr>
                    <tr>
                        <td>New Password: </td>
                        <td><input name="new_pass" type="password" id="new_pass" /></td>
                    </tr>
                    <tr>
                        <td>Confirm Password: </td>
                        <td><input name="con_pass" type="password" id="con_pass" /></td>
                    </tr>
                    <tr>
                        <td colspan="2"><h1><strong><em><font color="#3399FF" face="Arial, Helvetica, sans-serif">Personal Information </font></em></strong></h1></td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td><input name="name" type="text" id="name" value="${record.name}"/>
                        <font color="#CC3300">*</font></td>
                    </tr>
                    <tr>
                        <td>Sur Name: </td>
                        <td><input name="sur_name" type="text" id="sur_name" value="${record.surname}"/>
                        <font color="#CC3300">*</font></td>
                    </tr>
                    <tr>
                        <td>Title:</td>
                        <td><label>
                        <select name="title" id="title">
                            <option value="mr" <c:if test="${record.title == mr}"> selected </c:if> >Mr.</option>
                            <option value="dr" <c:if test="${record.title == dr}"> selected </c:if> >Dr.</option>
                            <option value="miss" <c:if test="${record.title == miss}"> selected </c:if> >Miss</option>
                            <option value="mrs" <c:if test="${record.title == mrs}"> selected </c:if> >Mrs.</option>
                        </select>
                        <font color="#CC3300">*</font></label></td>
                    </tr>
                    <tr>
                        <td>Phone Number: </td>
                        <td><label>
                            <input name="phone" type="text" id="phone" value="${record.phone_number}"/>
                        </label></td>
                    </tr>
                    <tr>
                        <td>Moblie Number: </td>
                        <td><input name="mobile" type="text" id="mobile" value="${record.mobile_number}"/>
                        <font color="#CC3300">*</font></td>
                    </tr>
                    <tr>
                        <td>Fax:</td>
                        <td><input name="fax" type="text" id="fax" value="${record.fax}"/></td>
                    </tr>
                    <tr>
                        <td>Address:</td>
                        <td><input name="address" type="text" id="address" value="${record.address}"/>
                        <font color="#CC3300">*</font></td>
                    </tr>
                    <tr>
                        <td>Passport Number: </td>
                        <td><input name="passport" type="text" id="passport" value="${record.passport_number}"/></td>
                    </tr>
                    <tr>
                        <td>P.O.Box:</td>
                        <td><input name="b_o_box" type="text" id="b_o_box" value="${record.b_o_box}"/></td>
                    </tr>
                    <tr>
                        <td>Nationality:</td>
                        <td><label>
                            <select name="nationality" id="nationality" >
                                <option value="bahrain" <c:if test="${record.nationality == bahrain}"> selected </c:if>>Bahrain</option>
                                <option value="saudi" <c:if test="${record.nationality == saudi}"> selected </c:if>>Saudi Arabia</option>
                                <option value="uae" <c:if test="${record.nationality == uae}"> selected </c:if>>UAE</option>
                                <option value="uk" <c:if test="${record.nationality == uk}"> selected </c:if>>UK</option>
                                <option value="other">Other</option>
                            </select>
                        </label></td>
                    </tr>
                    <tr>
                        <td>E-mail:</td>
                        <td><input name="email" type="text" id="email" value="${record.e_mail}"/>
                        <font color="#CC3300">*</font></td>
                    </tr>
                    <tr>
                        <td>Send Account information to the E-mail: </td>
                        <td><label>
                        <input name="con_email" type="radio" value="y" />
                        Yes</label>
                        <label>
                        <input name="con_email" type="radio" value="n" checked="checked" />
                        No</label></td>
                    </tr>
                    <tr>
                        <td><label>
                            <input name="Submit" type="submit" value="update" />
                        </label></td>
                        <td><label>
                            <input type="reset" name="reset" value="Reset" />
                        </label></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    
    
    </body>
</html>
