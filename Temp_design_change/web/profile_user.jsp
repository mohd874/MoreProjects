<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Profile</title>
        <style type="text/css">
            <!--
            @import url("CSS/ndesign.css");
            -->
        </style>

        <%@include file="trace_n_taglib2.jsp"%>
    </head>

    <body>
        <div class="ndesign" id="cssall">
            <div class="ndesign" id="nlocation">
                <div align="center">
                    <p>&nbsp;</p>
                    <p><img src="location gif/Profile.gif" width="295" height="100"></p>
                </div>
            </div>
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
            <div class="ndesign" id="ncenter">
                <sql:setDataSource url="jdbc:mysql://localhost:3306/dph_db_test" driver="com.mysql.jdbc.Driver" user="root" password="7710072" var="myDB"/>
                <% 
                    //if(session.getAttribute("user_id") == null)
                    //    session.setAttribute("user_id",request.getParameter("user_id"));
                    //}
                %>
                <c:if test="${sessionScope.user_id == null}">
                    <% session.setAttribute("user_id",request.getParameter("user_id")); %>
                </c:if>
                
                <c:if test="${sessionScope.user_id != param.user_id}">
                    <% session.setAttribute("user_id",request.getParameter("user_id")); %>
                </c:if>
                <c:if test="${sessionScope.return_to == null}">
                    <% session.setAttribute("return_to","profile_user.jsp"); %>
                </c:if>
                
                
                <sql:transaction dataSource="${myDB}">
                   
                    <sql:query var="user_info">
                        select * from sysuser, customers where user_id = '${sessionScope.user_id}' and user_id = customer_id
                    </sql:query>
                   

                    <sql:query var="names">
                        select user_id, name from sysuser, customers where user_id = customer_id
                    </sql:query>
                    
                    <sql:query var="countries">
                        select * from countries
                    </sql:query>
                
                </sql:transaction>
                ${sessionScope.user_id}
                <form id="form2" method="post" action="profile_user.jsp">
                    <p>Select a customer:
                        <select name="user_id">
                            <option value=""> SELECT </option>
                            <c:forEach var="customer" items="${names.rows}">
                                <option value="${customer.user_id}" <c:if test="${param.user_id == customer.user_id}">selected </c:if> > ${customer.name} </option>
                            </c:forEach>
                        </select> 
                    </p>
                    <p>
                        <input type="submit" name="Submit2" value="Submit">
                    </p>
                </form>
                <form id="form1" method="post" action="profile_control.page">
                    <font color="red">
                        <b>
                            ${status}
                            ${errors}
                           
                        </b>
                    </font>
                    <table width="500" border="0">
                        <tr>
                            <td colspan="2"><h1><strong><em><font color="#3399FF" face="Arial, Helvetica, sans-serif">Account Information</font></em></strong></h1></td>
                        </tr>
                        <c:forEach var="record" items="${user_info.rows}">
                            <tr>
                                <td width="182">User name: </td>
                                <td width="308">
                                    <input name="uname" type="text" id="uname" value="${record.user_name}" readonly="true"/>
                                </td>
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
                                <td>
                                <select name="title" id="title">
                                    <option value="mr" <c:if test="${record.title == mr}"> selected </c:if> >Mr.</option>
                                    <option value="dr" <c:if test="${record.title == dr}"> selected </c:if> >Dr.</option>
                                    <option value="miss" <c:if test="${record.title == miss}"> selected </c:if> >Miss</option>
                                    <option value="mrs" <c:if test="${record.title == mrs}"> selected </c:if> >Mrs.</option>
                                </select>
                                <font color="#CC3300">*</font></td>
                            </tr>
                            <tr>
                                <td>Phone Number: </td>
                                <td>
                                    <input name="phone" type="text" id="phone" value="${record.phone_number}"/>
                                </td>
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
                                <td>
                                    <select name="nationality" id="nationality" >
                                        <option value="" selected >SELECT</option>
                                        <c:forEach var="country" items="${countries.rows}">
                                            <option value="${country.country_value}" <c:if test="${country.country_value == record.nationality}"> selected </c:if> >${country.country_name}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>E-mail:</td>
                                <td><input name="email" type="text" id="email" value="${record.e_mail}"/>
                                <font color="#CC3300">*</font></td>
                            </tr>
                            <tr>
                                <td>Send Account information to the E-mail: </td>
                                <td>
                                <input name="con_email" type="radio" value="y" />
                                Yes
                                        
                                <input name="con_email" type="radio" value="n" checked="checked" />
                                No</td>
                            </tr>
                            <tr>
                                <td>
                                    <input name="Submit" type="submit" value="update" />
                                </td>
                                <td>
                                    <input type="reset" name="reset" value="Reset" />
                                </td>
                            </tr>
                            
                        </c:forEach>
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
