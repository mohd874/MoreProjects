<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Registration</title>
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
                    <p><img src="location gif/Registration.gif" width="295" height="100"></p>
                </div>
            </div>
            <%@include file="trace_n_taglib.jsp"%>
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
                    <sql:query var="countries">
                        select * from countries
                    </sql:query>
                </sql:transaction>
                
                <form id="form1" name="form1" method="post" action="registeration.page">
                    <table width="500" border="0">
                        <tr>
                            <td colspan="2"><h1><strong><em><font color="#3399FF" face="Arial, Helvetica, sans-serif">Account Information</font></em></strong></h1></td>
                        </tr>
                        <tr>
                            <td width="157">Login name: </td>
                            <td width="327"><label>
                            <input name="uname" type="text" id="uname" value="${uname}"/>
                            <font color="#CC3300">*${hashTable.uname}</font></label></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input name="pass" type="password" id="pass" />
                            <font color="#CC3300">* ${hashTable.pass}</font></td>
                        </tr>
                        <tr>
                            <td>Confirm Password: </td>
                            <td><input name="con_pass" type="password" id="con_pass" />
                            <font color="#CC3300">* ${hashTable.con_pass}</font></td>
                        </tr>
                        <tr>
                            <td colspan="2"><h1><strong><em><font color="#3399FF" face="Arial, Helvetica, sans-serif">Personal Information </font></em></strong></h1></td>
                        </tr>
                        <tr>
                            <td>First Name:</td>
                            <td><input name="name" type="text" id="name" value="${name}"/>
                            <font color="#CC3300">* ${hashTable.name}</font></td>
                        </tr>
                        <tr>
                            <td>SurName: </td>
                            <td><input name="sur_name" type="text" id="sur_name" value="${sur_name}"/>
                            <font color="#CC3300">* ${hashTable.surname}</font></td>
                        </tr>
                        <tr>
                            <td>Title:</td>
                            <td><label>
                            <select name="title" id="title">
                                <option value="mr" <c:if test="${title == 'mr'}"> selected </c:if> >Mr.</option>
                                <option value="dr" <c:if test="${title == 'dr'}"> selected </c:if> >Dr.</option>
                                <option value="miss" <c:if test="${title == 'miss'}"> selected </c:if> >Miss</option>
                                <option value="mrs" <c:if test="${title == 'mrs'}"> selected </c:if> >Mrs.</option>
                            </select>
                            <br><font color="#CC3300"></font></label></td>
                        </tr>
                        <tr>
                            <td>Phone Number: </td>
                            <td>
                                <input name="pre_phone" type="text" id="pre_phone" size="6" value="${pre_phone}"/>
                                - 
                                <input name="phone" type="text" id="phone" value="${phone}"/>
                                <font color="#CC3300">${hashTable.phone}</font>
                            </td>
                        </tr>
                        <tr>
                            <td>Moblie Number: </td>
                            <td><input name="pre_mobile" type="text" id="pre_mobile" size="6" value="${pre_mobile}"/>
                            -
                            <input name="mobile" type="text" id="mobile" value="${mobile}"/>
                            <font color="#CC3300">${hashTable.mobile}</font></td>
                        </tr>
                        <tr>
                            <td>Fax:</td>
                            <td><input name="fax" type="text" id="fax" value="${fax}"/>
                                <font color="#CC3300">${hashTable.fax}</font>
                            </td>
                        </tr>
                        <tr>
                            <td>Address:</td>
                            <td><input name="address" type="text" id="address" value="${address}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Passport Number: </td>
                            <td><input name="passport" type="text" id="passport" value="${passport}"/></td>
                        </tr>
                        <tr>
                            <td>P.O.Box:</td>
                            <td><input name="b_o_box" type="text" id="b_o_box" value="${b_o_box}"/></td>
                        </tr>
                        <tr>
                            <td>Nationality:</td>
                            <td><label>
                                <select name="nationality">
                                    <option value="" selected >SELECT</option>
                                    <c:forEach var="country" items="${countries.rows}">
                                        <option value="${country.country_value}" <c:if test="${country.country_value == nationality}"> selected </c:if> >${country.country_name}</option>
                                    </c:forEach>
                                </select>
                            </label></td>
                        </tr>
                        <tr>
                            <td>E-mail:</td>
                            <td><input name="email" type="text" id="email" value="${email}"/>
                            <font color="#CC3300">* ${hashTable.email}</font></td>
                        </tr>
                        <tr>
                            <td>Send Account information to the E-mail: </td>
                            <td><label>
                            <input name="email_confirmation" type="radio" value="y" <c:if test="${email_confirmation == 'y'}"> checked </c:if> />     
                            Yes</label>
                            <label>
                            <input name="email_confirmation" type="radio" value="n" <c:if test="${email_confirmation == 'n'}"> checked </c:if> />
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
            <div class="ndesign" id="nnavi">
                <%@include file="navigation_buttons.jsp"%>
            </div>
            <div class="ndesign" id="welcome"></div>
        </div>
    </body>
</html>
