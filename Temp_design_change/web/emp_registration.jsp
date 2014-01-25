<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Employee Registration</title>
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
                    <p><img src="location gif/New_Employee.gif" width="295" height="100"></p>
                </div>
            </div>
            <%@include file="trace_n_taglib2.jsp"%> 
            <div class="ndesign" id="nwelcome">
                <div align="center"> ${tracing_bean.title} ${tracing_bean.name} </div>
            </div>
            <div class="ndesign" id="nclock">
                <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="100" height="100">
                    <param name="movie" value="SWF/Clock.swf">
                    <param name="quality" value="high">
                    <embed src="SWF/Clock.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="100" height="100"></embed>
                </object>
            </div>
            <div class="ndesign" id="ncenter">
      
                <sql:setDataSource url="jdbc:mysql://localhost:3306/dph_db_test" driver="com.mysql.jdbc.Driver" user="root" password="7710072" var="myDB"/>

                <sql:transaction dataSource="${myDB}">
                    <sql:query var="service">
                        select service_no, service_type from services
                    </sql:query>
                    
                    <sql:query var="types">
                        select type_id, user_type from usertype
                    </sql:query>
                    <sql:query var="countries">
                        select * from countries
                    </sql:query>
                </sql:transaction>
                Fill all the fields with the proper information
                <%-- <font color="red"> ${errors} </font> --%>
                <form name="form1" method="post" action="emp_registration_control.page">
                    <table width="500" border="1">
                        <tr>
                            <td colspan="2"><div align="center"><h2><strong>Account Information </strong></h2></div></td>
                        </tr>
                        <tr>
                            <td>User Name: </td>
                            <td><label>
                                <input name="user_name" type="text" id="user_name" value="${uname}">
                            </label> <font color="red"> ${ht["uname"]} </font> </td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><label>
                                <input name="password" type="password" id="password">
                            </label> <font color="red"> ${ht["password"]} </font> </td>
                        </tr>
                        <tr>
                            <td>Confirm Password: </td>
                            <td><label>
                                <input name="con_password" type="password" id="con_password">
                            </label> <font color="red"> ${ht["con_password"]} </font> </td>
                        </tr>
                        <tr>
                            <td colspan="2"><div align="center"><h2><strong>Personal Information </strong></h2></div></td>
                        </tr>
                        <tr>
                            <td>Name:</td>
                            <td><label>
                                <input name="name" type="text" id="name" value="${name}">
                            </label> <font color="red"> ${ht["name"]} </font> </td>
                        </tr>
                        <tr>
                            <td>Sur Name: </td>
                            <td><label>
                                <input name="surname" type="text" id="surname" value="${surname}">
                            </label> <font color="red"> ${ht["surname"]} </font> </td>
                        </tr>
                        <tr>
                            <td>Phone Number: </td>
                            <td><label>
                                <input name="phone_number" type="text" id="phone_number" value="${phone}">
                            </label> <font color="red"> ${ht["phone"]} </font> </td>
                        </tr>
                        <tr>
                            <td>Mobile Number: </td>
                            <td><label>
                                <input name="mobile_number" type="text" id="mobile_number" value="${mobile}">
                            </label><font color="red">${ht["mobile"]}</font> </td>
                        </tr>
                        <tr>
                            <td>P.O.Box:</td>
                            <td><label>
                                <input type="text" name="b_o_box" value="${b_o_box}">
                            </label><font color="red">${ht["b_o_box"]}</font> </td>
                        </tr>
                        <tr>
                            <td>Address:</td>
                            <td><label>
                                <textarea name="address" rows="4" id="address">${address}</textarea>
                            </label><font color="red">${ht["address"]}</font> </td>
                        </tr>
                        <tr>
                            <td>Passport Number: </td>
                            <td><label>
                                <input name="passport_number" type="text" id="passport_number" value="${passport}">
                            </label><font color="red">${ht["passport"]}</font> </td>
                        </tr>
                        <tr>
                            <td>Nationality:</td>
                            <td><%--<label>
                            <input name="nationality" type="text" id="nationality" value="${nationality}">
                            </label>--%>
                            <select name="nationality" size="1">
                                <option value="" selected >SELECT</option>
                                <c:forEach var="country" items="${countries.rows}">
                                    <option value="${country.country_value}" <c:if test="${country.country_value == nationality}"> selected </c:if> >${country.country_name}</option>
                                </c:forEach>
                            </select>
                            <font color="red">${ht["nationality"]}</font> </td>
                        </tr>
                        <tr>
                            <td>Job Title: </td>
                            <td><label>
                                <input name="job_title" type="text" id="job_title" value="${job_title}">
                            </label><font color="red">${ht["job_title"]}</font> </td>
                        </tr>
                        <tr>
                            <td>Marital Status: </td>
                            <td><label>
                                <select name="marital_status" size="1">
                                    <option value="">Select</option>
                                    <option value="single" <c:if test="${marital_status == 'single'}"> selected </c:if> >Single</option>
                                    <option value="married"<c:if test="${marital_status == 'married'}"> selected </c:if> >Married</option>
                                </select>
                            </label><font color="red">${ht["marital_status"]}</font> </td>
                        </tr>
                        <tr>
                            <td>Gender:</td>
                            <td><label>
                                <select name="gender" size="1">
                                    <option value="">Select</option>
                                    <option value="male"  <c:if test="${gender == 'male'}"> selected </c:if> >Male</option>
                                    <option value="female"  <c:if test="${gender == 'female'}"> selected </c:if> >Female</option>
                                </select>
                            </label><font color="red">${ht["gender"]}</font> </td>
                        </tr>
                        <tr>
                            <td>Years of Exp: </td>
                            <td><label>
                                <input name="years_of_exp" type="text" id="years_of_exp" value="${years_of_exp}">
                            </label><font color="red">${ht["years_of_exp"]}</font> </td>
                        </tr>
                        <tr>
                            <td>Service Type: </td>
                            <td><label>
                                <select name="service_type">
                                    <option value="">select</option>
                                    <c:forEach var="record" items="${service.rows}">
                                        <option value="${record.service_no}" <c:if test="${record.service_no == service_no}"> selected </c:if>  >${record.service_type}</option>
                                    </c:forEach>
                                </select>
                            </label><font color="red">${ht["service_no"]}</font> </td>
                        </tr>
                        <tr>
                            <td>User Type:</td>
                            <td>
                                <select name="user_type">
                                    <option value="">Select</option>
                                    <c:forEach var="type" items="${types.rows}">
                                        <c:if test="${type.user_type != 'Customer'}">
                                            <option value="${type.type_id}" <c:if test="${type.type_id == user_type}"> selected </c:if> >${type.user_type}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                                <font color="red">${ht["uset_type"]}</font> 
                            </td>
                        </tr>
                        <tr>
                            <td><label>
                                <input type="submit" name="Submit" value="Submit">
                            </label></td>
                            <td><input name="reset" type="reset" value="Reset"></td>
                        </tr>
                    </table>
                </form>
      
      
            </div>
            <div class="ndesign" id="nnavi">
                <%@include file="navigation_buttons.jsp"%>
            </div>
            <div class="ndesign" id="welcome"></div>
        </div>
    </body>
</html>
