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
                
                <sql:transaction dataSource="${myDB}">
                    <c:if test="${param.user_id != '' && param.user_id != null }">
                        <sql:query var="employees">
                            select * from sysuser,employees 
                            where user_id = '${param.user_id}' AND employee_id = user_id 
                        </sql:query>
                    
                        <sql:query var="customers">
                            select * from sysuser,customers
                            where user_id = '${param.user_id}' AND customer_id = user_id 
                        </sql:query>
                    </c:if>
                    
                    <c:if test="${user_id != '' && user_id != null }">
                        <sql:query var="employees">
                            select * from sysuser,employees 
                            where user_id = '${user_id}' AND employee_id = user_id 
                        </sql:query>
                    
                        <sql:query var="customers">
                            select * from sysuser,customers
                            where user_id = '${user_id}' AND customer_id = user_id 
                        </sql:query>
                    </c:if>
                    
                    <sql:query var="names">
                        select user_id, name,surname, usertype.user_type from sysuser, customers, usertype where usertype.type_id = sysuser.user_type AND user_id = customer_id
                        order by name
                    </sql:query>
                    
                    <sql:query var="self">
                        select user_id, name, surname from sysuser where user_id = '${tracing_bean.userID}'
                    </sql:query>
                
                    <sql:query var="countries">
                        select * from countries
                    </sql:query>
                
                </sql:transaction>
                
                <form id="form2" method="post" action="profile_reseptionist.jsp">
                    <p>Select a customer:
                        <select name="user_id">
                            <option value=""> SELECT </option>
                            <c:forEach var="name" items="${self.rows}">
                                <option value="${name.user_id}" <c:if test="${param.user_id == name.user_id || user_id == name.user_id}">selected </c:if> > ${name.name} ${name.surname} </option>
                            </c:forEach>
                            <c:forEach var="user" items="${names.rows}">
                                <option value="${user.user_id}" <c:if test="${param.user_id == user.user_id}">selected </c:if> > ${user.name} ${user.surname} </option>
                            </c:forEach>
                        </select> 
                    </p>
                    <p>
                        <input type="submit" name="Submit2" value="Submit">
                    </p>
                </form>
                <form id="form1" method="post" action="profile_admin_control.page">
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
                        <c:forEach var="record" items="${customers.rows}">

                            <tr>
                                <td width="182">User name: </td>
                                <td width="308">
                                    <input name="uname" type="text" id="uname" value="${record.user_name}" readonly="true"/>
                                    
                                </td>
                            </tr>
                            <tr>
                                <td><input name="Submit" type="submit" value="Reset Password"> </td>
                                <td><font color="red"> This will reset the password to "0000"</font></td>
                            </tr>
                            
                            <td colspan="2"><h1><strong><em><font color="#3399FF" face="Arial, Helvetica, sans-serif">Personal Information </font></em></strong></h1></td>
                            </tr>
                            <tr>
                                <td>Name:</td>
                                <td><input name="name" type="text" id="name" value="${record.name}"/>
                                <font color="#CC3300">* ${ht["name"]}</font></td>
                            </tr>
                            <tr>
                                <td>Sur Name: </td>
                                <td><input name="sur_name" type="text" id="sur_name" value="${record.surname}"/>
                                <font color="#CC3300">*${ht["sur_name"]}</font></td>
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
                                <font color="#CC3300">*${ht["title"]}</font></td>
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
                                    <select name="nationality" size="1">
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
                                <font color="#CC3300">*${ht["email"]}</font></td>
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
                                    <input type="reset" name="reset" value="Reset" /><input type="hidden" value="${record.user_type}" name="hidden_user_type">
                                    <input type="hidden" value="${record.user_id}" name="hidden_user_id">
                                </td>
                            </tr>
                            
                        </c:forEach>
                        <c:forEach var="record" items="${employees.rows}">
                            <tr>
                                <td width="182">User name: </td>
                                <td width="308">
                                    <input name="uname" type="text" id="uname" value="${record.user_name}" readonly="true"/>
                                </td>
                            </tr>
                            <c:choose>
                                <c:when test="${tracing_bean.userID != record.user_id}">
                                    <tr>
                                        <td><input name="Submit" type="submit" value="Reset Password"> </td>
                                        <td><font color="red">This will reset the password to "0000"</font></td>
                                    </tr>
                                </c:when>
                                <c:when test="${tracing_bean.userID == record.user_id}">
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
                                </tr>    </c:when>
                                
                            </c:choose>
                            <tr>
                                <td colspan="2"><h1><strong><em><font color="#3399FF" face="Arial, Helvetica, sans-serif">Personal Information </font></em></strong></h1></td>
                            </tr>
                            <tr>
                                <td>Name:</td>
                                <td><input name="name" type="text" id="name" value="${record.name}"/>
                                <font color="#CC3300">*${ht["name"]}</font></td>
                            </tr>
                            <tr>
                                <td>Sur Name: </td>
                                <td><input name="sur_name" type="text" id="sur_name" value="${record.surname}"/>
                                <font color="#CC3300">*${ht["sur_name"]}</font></td>
                            </tr>
                            <tr>
                                <td>Job Title: </td>
                                <td>
                                    <input name="job_title" type="text" id="job_title" value="${record.job_title}"/>
                                    <font color="#CC3300">*${ht["job_title"]}</font>
                                </td>
                            </tr>
                            <tr>
                                <td>Marital Status: </td>
                                <td>
                                    <select name="marital_status">
                                        <option value="single" <c:if test="${record.gender == 'single'}"> selected </c:if> > Single </option>
                                        <option value="married" <c:if test="${record.gender == 'married'}"> selected </c:if> > Married </option>
                                    </select>
                                    <font color="#CC3300">*${ht["marital_status"]}</font>
                                </td>
                            </tr>
                            <tr>
                                <td>Gender: </td>
                                <td>
                                    <select id="gender" name="gender" >
                                        <option value="male" <c:if test="${record.gender == 'male'}"> selected </c:if> >Male</option>
                                        <option value="female" <c:if test="${record.gender == 'female'}"> selected </c:if> >Female</option>
                                    </select>
                                    <font color="#CC3300">*${ht["gender"]}</font>
                                </td>
                            </tr>
                                    
                            <tr>
                                <td>Phone Number: </td>
                                <td>
                                    <input name="phone" type="text" id="phone" value="${record.phone_number}"/>
                                    <font color="#CC3300">*${ht["phone"]}</font>
                                </td>
                            </tr>
                            <tr>
                                <td>Moblie Number: </td>
                                <td><input name="mobile" type="text" id="mobile" value="${record.mobile_number}"/>
                                </td>
                            </tr>
                                    
                            <tr>
                                <td>Address:</td>
                                <td><input name="address" type="text" id="address" value="${record.address}"/>
                                <font color="#CC3300">*</font></td>
                            </tr>
                            <tr>
                                <td>Passport Number: </td>
                                <td><input name="passport" type="text" id="passport" value="${record.passport_number}"/>
                                    <font color="#CC3300">*${ht["passport"]}</font>
                                </td>
                            </tr>
                            <tr>
                                <td>P.O.Box:</td>
                                <td><input name="b_o_box" type="text" id="b_o_box" value="${record.b_o_box}"/>
                                        
                                </td>
                            </tr>
                            <tr>
                                <td>Nationality:</td>
                                <td>
                                    <select name="nationality" size="1">
                                        <option value="select">Select</option>
                                        <option value="afghanistan">Afghanistan</option>
                                        <option value="albania">Albania</option>
                                        <option value="algeria">Algeria</option>
                                        <option value="andorra">Andorra</option>
                                        <option value="anguilla">Anguilla</option>
                                        <option value="antigua_and_barbuda">Antigua and Barbuda</option>
                                        <option value="argentina">Argentina</option>
                                        <option value="armenia">Armenia</option>
                                        <option value="aruba">Aruba</option>
                                        <option value="ashmore_and_cartier_islands">Ashmore and Cartier Islands</option>
                                        <option value="australia">Australia</option>
                                        <option value="austria">Austria</option>
                                        <option value="azerbaijan">Azerbaijan</option>
                                        <option value="bahamas">Bahamas</option>
                                        <option value="bahrain">Bahrain</option>
                                        <option value="bangladesh">Bangladesh</option>
                                        <option value="barbados">Barbados</option>
                                        <option value="belarus">Belarus</option>
                                        <option value="belgium">Belgium</option>
                                        <option value="belize">Belize</option>
                                        <option value="benin">Benin</option>
                                        <option value="bhutan">Bhutan</option>
                                        <option value="bolivia">Bolivia</option>
                                        <option value="bosnia_and_herzegovina">Bosnia and Herzegovina</option>
                                        <option value="botswana">Botswana</option>
                                        <option value="brazil">Brazil</option>
                                        <option value="british">British</option>
                                        <option value="brunei">Brunei</option>
                                        <option value="bulgaria">Bulgaria</option>
                                        <option value="burkina_faso">Burkina Faso</option>
                                        <option value="burma">Burma</option>
                                        <option value="burundi">Burundi</option>
                                        <option value="cambodia">Cambodia</option>
                                        <option value="cameroon">Cameroon</option>
                                        <option value="canada">Canada</option>
                                        <option value="cape_verde">Cape Verde</option>
                                        <option value="cayman_islands">Cayman Islands</option>
                                        <option value="central_african_republic">Central African Republic</option>
                                        <option value="chad">Chad</option>
                                        <option value="chile">Chile</option>
                                        <option value="china">China</option>
                                        <option value="colombia">Colombia</option>
                                        <option value="comoros">Comoros</option>
                                        <option value="congo">Congo</option>
                                        <option value="congo_Dem_rep">Congo, Dem. Rep.</option>
                                        <option value="cook_islands">Cook Islands</option>
                                        <option value="costa_rica">Costa Rica</option>
                                        <option value="cote_d'ivoire">Cote d'Ivoire</option>
                                        <option value="croatia">Croatia</option>
                                        <option value="cuba">Cuba</option>
                                        <option value="cyprus">Cyprus</option>
                                        <option value="czech_republic">Czech Republic</option>
                                        <option value="denmark">Denmark</option>
                                        <option value="deutschland">Deutschland</option>
                                        <option value="djibouti">Djibouti</option>
                                        <option value="dominica">Dominica</option>
                                        <option value="dominican_republic">Dominican Republic</option>
                                        <option value="east_timor">East Timor</option>
                                        <option value="ecuador">Ecuador</option>
                                        <option value="egypt">Egypt</option>
                                        <option value="el_salvador">El Salvador</option>
                                        <option value="equatorial_guinea">Equatorial Guinea</option>
                                        <option value="eritrea">Eritrea</option>
                                        <option value="estonia">Estonia</option>
                                        <option value="ethiopia">Ethiopia</option>
                                        <option value="faroe_islands">Faroe Islands</option>
                                        <option value="fiji">Fiji</option>
                                        <option value="finland">Finland</option>
                                        <option value="france">France</option>
                                        <option value="french_guyana">French Guyana</option>
                                        <option value="french_polynesia">French Polynesia</option>
                                        <option value="fyrom">F.Y.R.O.M.</option>
                                        <option value="gabon">Gabon</option>
                                        <option value="gambia">Gambia</option>
                                        <option value="georgia">Georgia</option>
                                        <option value="germany">Germany</option>
                                        <option value="ghana">Ghana</option>
                                        <option value="great_britain">Great Britain</option>
                                        <option value="greece">Greece</option>
                                        <option value="greenland">Greenland</option>
                                        <option value="grenada">Grenada</option>
                                        <option value="guadeloupe">Guadeloupe</option>
                                        <option value="guam">Guam</option>
                                        <option value="guatemala">Guatemala</option>
                                        <option value="guernsey">Guernsey</option>
                                        <option value="guinea">Guinea</option>
                                        <option value="guinea_bissau">Guinea-Bissau</option>
                                        <option value="guyana">Guyana</option>
                                        <option value="haiti">Haiti</option>
                                        <option value="holland">Holland</option>
                                        <option value="honduras">Honduras</option>
                                        <option value="hungary">Hungary</option>
                                        <option value="iceland">Iceland</option>
                                        <option value="india">India</option>
                                        <option value="indonesia">Indonesia</option>
                                        <option value="iran">Iran</option>
                                        <option value="iraq">Iraq</option>
                                        <option value="ireland ">Ireland </option>
                                        <option value="isle_of_man">Isle of Man</option>
                                        <option value="israel">Israel</option>
                                        <option value="italy">Italy</option>
                                        <option value="jamaica">Jamaica</option>
                                        <option value="japan">Japan</option>
                                        <option value="jordan">Jordan</option>
                                        <option value="kazakstan">Kazakstan</option>
                                        <option value="kenya">Kenya</option>
                                        <option value="kiribati">Kiribati</option>
                                        <option value="korea_north">Korea, North</option>
                                        <option value="korea_south">Korea, South</option>
                                        <option value="kuwait">Kuwait</option>
                                        <option value="kyrgyzstan">Kyrgyzstan</option>
                                        <option value="laos">Laos</option>
                                        <option value="latvia">Latvia</option>
                                        <option value="lebanon">Lebanon</option>
                                        <option value="lesotho">Lesotho</option>
                                        <option value="liberia">Liberia</option>
                                        <option value="libya">Libya</option>
                                        <option value="liechtenstein">Liechtenstein</option>
                                        <option value="lithuania">Lithuania</option>
                                        <option value="luxembourg">Luxembourg</option>
                                        <option value="madagascar">Madagascar</option>
                                        <option value="malawi">Malawi</option>
                                        <option value="malaysia">Malaysia</option>
                                        <option value="maldives">Maldives</option>
                                        <option value="mali">Mali</option>
                                        <option value="malta">Malta</option>
                                        <option value="marshall_islands">Marshall Islands</option>
                                        <option value="martinique">Martinique</option>
                                        <option value="mauritania">Mauritania</option>
                                        <option value="mauritius">Mauritius</option>
                                        <option value="mexico">Mexico</option>
                                        <option value="micronesia_federated_states_of">Micronesia, Federated States Of</option>
                                        <option value="moldova">Moldova</option>
                                        <option value="monaco">Monaco</option>
                                        <option value="mongolia">Mongolia</option>
                                        <option value="montserrat">Montserrat</option>
                                        <option value="morocco">Morocco</option>
                                        <option value="mozambique">Mozambique</option>
                                        <option value="myanmar">Myanmar</option>
                                        <option value="namibia">Namibia</option>
                                        <option value="nauru">Nauru</option>
                                        <option value="nato">NATO</option>
                                        <option value="nepal">Nepal</option>
                                        <option value="netherlands">Netherlands</option>
                                        <option value="netherlands_antilles">Netherlands Antilles</option>
                                        <option value="new_caledonia">New Caledonia</option>
                                        <option value="new_zealand">New Zealand</option>
                                        <option value="nicaragua">Nicaragua</option>
                                        <option value="niger">Niger</option>
                                        <option value="nigeria">Nigeria</option>
                                        <option value="niue">Niue</option>
                                        <option value="norfolk_island">Norfolk Island</option>
                                        <option value="north_korea">North Korea</option>
                                        <option value="northern_mariana_islands">Northern Mariana Islands</option>
                                        <option value="norway">Norway</option>
                                        <option value="oman">Oman</option>
                                        <option value="pakistan">Pakistan</option>
                                        <option value="palau">Palau</option>
                                        <option value="palestine">Palestine</option>
                                        <option value="panama">Panama</option>
                                        <option value="papua_new_guinea">Papua New Guinea</option>
                                        <option value="paraguay">Paraguay</option>
                                        <option value="peru">Peru</option>
                                        <option value="philippines">Philippines</option>
                                        <option value="poland">Poland</option>
                                        <option value="portugal">Portugal</option>
                                        <option value="qatar">Qatar</option>
                                        <option value="romania">Romania</option>
                                        <option value="russia">Russia</option>
                                        <option value="saint_kitts_and_nevis">Saint Kitts and Nevis</option>
                                        <option value="saint_lucia">Saint Lucia</option>
                                        <option value="saint_pierre_and_miquelon">Saint Pierre and Miquelon</option>
                                        <option value="saint_vincent_and_the_grenadines">Saint Vincent and the Grenadines</option>
                                        <option value="samoa">Samoa</option>
                                        <option value="san_marino">San Marino</option>
                                        <option value="sao_tome_and_principe">Sao Tome and Principe</option>
                                        <option value="saudi_arabia">Saudi Arabia</option>
                                        <option value="senegal">Senegal</option>
                                        <option value="serbia_&amp;_montenegro">Serbia &amp; Montenegro</option>
                                        <option value="seychelles">Seychelles</option>
                                        <option value="sierra_leone">Sierra Leone</option>
                                        <option value="singapore">Singapore</option>
                                        <option value="slovakia">Slovakia</option>
                                        <option value="slovania">Slovania</option>
                                        <option value="solomon_islands">Solomon Islands</option>
                                        <option value="somalia">Somalia</option>
                                        <option value="south_africa">South Africa</option>
                                        <option value="south_korea">South Korea</option>
                                        <option value="spain">Spain</option>
                                        <option value="sri_lanka">Sri Lanka</option>
                                        <option value="st_kitts_and_nevis">St. Kitts and Nevis</option>
                                        <option value="sudan">Sudan</option>
                                        <option value="suriname">Suriname</option>
                                        <option value="swaziland">Swaziland</option>
                                        <option value="sweden">Sweden</option>
                                        <option value="switzerland">Switzerland</option>
                                        <option value="syria">Syria</option>
                                        <option value="taiwan">Taiwan</option>
                                        <option value="tajikistan">Tajikistan</option>
                                        <option value="tanzania">Tanzania</option>
                                        <option value="thailand">Thailand</option>
                                        <option value="togo">Togo</option>
                                        <option value="tonga">Tonga</option>
                                        <option value="trinidad_and_tobago">Trinidad and Tobago</option>
                                        <option value="tunisia">Tunisia</option>
                                        <option value="turkey">Turkey</option>
                                        <option value="turkmenistan">Turkmenistan</option>
                                        <option value="turks_and_caicos_islands">Turks and Caicos Islands</option>
                                        <option value="tuvalu">Tuvalu</option>
                                        <option value="uganda">Uganda</option>
                                        <option value="ukraine">Ukraine</option>
                                        <option value="united_arab_emirates">United Arab Emirates</option>
                                        <option value="united_kingdom">United Kingdom</option>
                                        <option value="england">England</option>
                                        <option value="northern_ireland">Northern Ireland</option>
                                        <option value="scotland">Scotland</option>
                                        <option value="united_states">United States</option>
                                        <option value="uruguay">Uruguay</option>
                                        <option value="uzbekistan">Uzbekistan</option>
                                        <option value="vanuatu">Vanuatu</option>
                                        <option value="vatican_city">Vatican City</option>
                                        <option value="venezuela">Venezuela</option>
                                        <option value="vietnam">Vietnam</option>
                                        <option value="yemen">Yemen</option>
                                        <option value="yugoslavia">Yugoslavia</option>
                                        <option value="zambia">Zambia</option>
                                        <option value="zimbabwe">Zimbabwe</option>
                                    </select>
                                    <font color="#CC3300">*</font>
                                </td>
                            </tr>
                            <tr>
                                <td>Years of Exp: </td>
                                <td> <input type="text" maxlength="3" size="3" name="years_of_exp" id="years_of_exp" value="${record.years_of_exp}">
                                    <font color="#CC3300">*${ht["years_of_exp"]}</font>
                                </td>
                            </tr>
                            <tr>
                                <sql:query dataSource="${myDB}" var="service">
                                    select service_no ,service_type from services
                                </sql:query>
                                <td>Service: </td>
                                <td>
                                    <select id="service_no" name="service_no">
                                        <c:forEach var="serv" items="${service.rows}">
                                            <option value="${serv.service_no}" <c:if test="${record.service_no == serv.service_no}"> selected </c:if> > ${serv.service_type} </option>
                                        </c:forEach>
                                    </select>
                                    <font color="#CC3300">*</font>
                                </td>
                            </tr>
                            <td>
                                <input name="Submit" type="submit" value="update" />
                            </td>
                            <td>
                                <input type="reset" name="reset" value="Reset" /><input type="hidden" value="${record.user_type}" name="hidden_user_type">
                                <input type="hidden" value="${record.user_id}" name="hidden_user_id">
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
