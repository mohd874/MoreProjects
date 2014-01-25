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
        <div class="ndesign" id="cssall2">
            <div class="ndesign" id="nlocation">
                <div align="center">
                    <p>&nbsp;</p>
                    <p><img src="location gif/Data_Base.gif" width="295" height="100"></p>
                </div>
            </div>
            <%@include file="trace_n_taglib2.jsp"%> 
            
            <div class="ndesign" id="nclock">
                <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="100" height="100">
                    <param name="movie" value="SWF/Clock.swf">
                    <param name="quality" value="high">
                    <embed src="SWF/Clock.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="100" height="100"></embed>
                </object>
            </div>
            
            <jsp:useBean id="limit" scope="session" class="com.hotel.model.limit">
                <jsp:setProperty name="limit" property="limit_1" value="0"/>
                <jsp:setProperty name="limit" property="limit_2" value="10"/>
            </jsp:useBean>
            
           
            <c:if test="${param.set == 'Set' && param.limit_selection != (limit.limit_2 - limit.limit_1)}">
                <c:if test="${param.limit_selection != '' && param.limit_selection != null}">
                    <jsp:setProperty name="limit" property="limit_1" value="0"/>
                    <jsp:setProperty name="limit" property="limit_2" value="${param.limit_selection}"/>
                </c:if>
            </c:if>
            
            <c:if test="${param.navigat_records == 'Next'}">
                <jsp:setProperty name="limit" property="limit_1" value="${limit.limit_1 + param.limit_selection}"/>
                <%--<jsp:setProperty name="limit" property="limit_2" value="${limit.limit_2 + param.limit_selection}"/>--%>
            </c:if>
            
            <c:if test="${param.navigat_records == 'Previous' && limit.limit_1 != 0}">
                <jsp:setProperty name="limit" property="limit_1" value="${limit.limit_1 - param.limit_selection}"/>
                <%--<jsp:setProperty name="limit" property="limit_2" value="${limit.limit_2 - param.limit_selection}"/>--%>
            </c:if>
            

            <%session.setAttribute("limit",limit);%>
            <%session.setAttribute("selection",request.getAttribute("limit_selection"));%>
            
            <sql:setDataSource url="jdbc:mysql://localhost:3306/dph_db_test" driver="com.mysql.jdbc.Driver" user="root" password="7710072" var="myDB"/>
            
            <sql:transaction dataSource="${myDB}">
                <sql:query var="selection" >
                    Select
                    sysuser.user_id,
                    sysuser.user_name,
                    sysuser.`password`,
                    sysuser.name,
                    sysuser.surname,
                    sysuser.phone_number,
                    sysuser.mobile_number,
                    sysuser.address,
                    sysuser.passport_number,
                    sysuser.b_o_box,
                    sysuser.nationality,
                    sysuser.user_type,
                    customers.title,
                    customers.fax,
                    customers.e_mail
                    from sysuser, customers
                    where 
                    <c:if test="${param.name != '' && param.name != null}">
                        name = '${param.name}' and
                    </c:if>
                    <c:if test="${param.user_name != '' && param.user_name != null}">
                        user_name = '${param.user_name}' and
                    </c:if>
                    <c:if test="${param.surname != '' && param.surname != null}">
                        surname = '${param.surname}' and
                    </c:if>                    
                    user_id = customer_id
                    <c:if test="${param.field != '' && param.field != null}">
                        order by ${param.field}
                    </c:if>
                    limit ${limit.limit_1}, ${limit.limit_2}
                    
                </sql:query>
                
                <sql:query var="sysuser_fields" >
                    desc sysuser
                </sql:query>
                
                <sql:query var="customers_fields">
                    desc customers
                </sql:query>
                
                <sql:query var="list_boxs">
                    Select
                    sysuser.user_name,
                    sysuser.name,
                    sysuser.surname
                    from sysuser, customers
                    where user_id = customer_id
                </sql:query>
                
            </sql:transaction>
            
            <div class="ndesign" id="nmiddlebar">
                
                
                <form name="form1" method="post" action="db_customers.jsp">
                   
                    <table width="500" border="0">
                        <tr>
                            <th colspan="5" scope="col">Customers Database Panel</th>
                        </tr>
                        <tr>
                            <td colspan="3">Login Name:                                </td>
                            <td colspan="2">
                            <select name="user_name">
                                <option value="">ALL</optiotn>
                                <c:forEach var="list_1" items="${list_boxs.rows}">
                                    <option value="${list_1.user_name}"> ${list_1.user_name} </option>
                                </c:forEach>
                            </select>                                </td>
                        </tr>
                        <tr>
                            <td colspan="3">First Name:                                </td>
                            <td colspan="2">
                            <select name="name">
                                <option value="">ALL</optiotn>
                                <c:forEach var="list_2" items="${list_boxs.rows}">
                                    <option value="${list_2.name}"> ${list_2.name} </option>
                                </c:forEach>
                            </select></td>
                        </tr>
                        <tr>
                            <td colspan="3">Surname:</td>
                            <td colspan="2"><select name="surname">
                                <option value="">ALL</optiotn>
                                <c:forEach var="list_3" items="${list_boxs.rows}">
                                    <option value="${list_3.surname}"> ${list_3.surname} </option>
                                </c:forEach>
                            </select></td>
                        </tr>
                        <tr>
                            <td colspan="3"><label>Records Limit:
                                <select name="limit_selection">
                                    <option value="10" selected >10</option>
                                    <option value="20" <c:if test="${param.limit_selection == 20}"> selected </c:if> >20</option>
                                    <option value="30" <c:if test="${param.limit_selection == 30}"> selected </c:if> >30</option>
                                    <option value="50" <c:if test="${param.limit_selection == 50}"> selected </c:if> >50</option>
                                    <option value="100" <c:if test="${param.limit_selection == 100}"> selected </c:if> >100</option>
                                </select>
                            </label> <input name="set" type="submit" id="set" value="Set"> </td>
                            <td colspan="3">Order by: 
                            <select name="field" id="field">
                                <c:forEach var="fields_1" items="${sysuser_fields.rows}">
                                    <option value="${fields_1.field}">${fields_1.field}</option>
                                </c:forEach>
                                <c:forEach var="fields_2" items="${customers_fields.rows}">
                                    <option value="${fields_2.field}">${fields_2.field}</option>
                                </c:forEach>
                            </select></td>
                        </tr>
                        
                        <tr>
                            <td width="81"><input name="navigat_records" type="submit" id="previous" value="Previous"></td>
                            <td width="65"><input name="navigat_records" type="submit" id="next" value="Next"></td>
                            <td width="73"><input type="submit" name="Submit" value="Submit"></td>
                            <td width="263"><label>
                                <input type="reset" name="reset" value="Reset">
                            </label></td>
                        </tr>
                    </table>		   
                </form>
                <form name="form2" method="post" action="db_action_control.page">
                    <table width="1799">
                        <tr>
                            <td width="43">
                            Select                                </td>
                            <td colspan="2">
                            Customer_id                                </td>
                            <td colspan="2">
                            Login Name                                </td>
                            <td width="92">
                            title                                </td>                                
                            <td width="103">
                            First Name                                </td>
                            <td width="121">
                            Surname                                </td>
                            <td width="161">
                            Phone Number                                </td>
                            <td width="164">
                            Mobile Number                                </td>
                            <td width="118">
                            Address                                </td>
                            <td width="176">
                            Passport Number                                </td>
                            <td width="126">
                            P.O.Box                                </td>
                            <td width="131">
                            Nationality                                </td>
                            <td width="89">
                            Fax                                </td>
                            <td width="110">
                            E-mail                                </td>
                            
                        </tr>
                            
                        <c:forEach var="record" items="${selection.rows}" >
                            <tr>
                            <td>
                                <input type="checkbox" name="user_id" id="user_id" value="${record.user_id}">                                </td>
                                <td colspan="2">
                                ${record.user_id}                                </td>
                                <td colspan="2">
                                ${record.user_name}                                </td>
                                <td>
                                ${record.title}                                </td>                                
                                <td>
                                ${record.name}                                </td>
                                <td>
                                ${record.surname}                                </td>
                                <td>
                                ${record.phone_number}                                </td>
                                <td>
                                ${record.mobile_number}                                </td>
                                <td>
                                ${record.address}                                </td>
                                <td>
                                ${record.passport_number}                                </td>
                                <td>
                                ${record.b_o_box}                                </td>
                                <td>
                                ${record.nationality}                                </td>
                                <td>
                                ${record.fax}                                </td>
                                <td>
                                ${record.e_mail}                                </td>
                                
                            </tr>
                        </c:forEach>
                         
                     
                        <td><input name="edit" type="submit" id="edit" value="Edit"></td>
                        <td width="74"><label>
                            <input name="delete" type="submit" id="delete" value="Delete">
                        </label></td>
                        <td width="103"><label>
                            <input name="add" type="submit" id="add" value="Add">
                        </label></td>
                        </tr>
                    </table> 
                </form>
                
            </div>
            <div class="ndesign" id="nwelcome">
                <div align="center" style="color:white" >${tracing_bean.title} ${tracing_bean.name}</div>
            </div>
            <div class="ndesign" id="nnavi">
                <%@include file="navigation_buttons.jsp"%>
            </div>
            <div class="ndesign" id="welcome"></div>
        </div>
    </body>
</html>
