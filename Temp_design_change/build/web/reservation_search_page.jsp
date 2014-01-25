<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Room Search</title>
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
                    <p><img src="location gif/Home.gif" width="295" height="100"></p>
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
                
                <form id="form1" name="form1" method="post" action="room_search.page">
                    <table width="100%" border="0" cellspacing="0">
                        <tr>
                            <td><div align="center">Room Type </div></td>
                            <td><label>
                                <select name="room_type" id="room_type">
                                    <option value="*">ALL</option>
                                    <option value="lexury">Lexury</option>
                                    <option value="khaleej">Khaleej</option>
                                    <option value="royal">Royal Palace</option>
                                </select>
                            </label></td>
                            <td><div align="center">Room View </div></td>
                            <td><label>
                                <select name="room_view" id="room_view">
                                    <option value="*">ALL</option>
                                    <option value="marina">Marina</option>
                                    <option value="swimming pool">Swimming Pool</option>
                                    <option value="garden">Garden</option>
                                </select>
                            </label></td>
                        </tr>
                        <tr>
                            <td><div align="center">Price </div></td>
                            <td><label>
                                <div align="center">Min
                                    <input name="first_num" type="text" id="first_num" />
                                </div>
                            </label></td>
                            <td><div align="center"></div></td>
                            <td><label>
                                <div align="center">Max
                                    <input name="second_num" type="text" id="second_num" />
                                </div>
                            </label></td>
                        </tr>
                        <tr>
                            <td colspan="2"><label>
                                <div align="center">
                                    <input name="search" type="submit" id="search" value="Search" src="" />
                                </div>
                            </label></td>
                            <td colspan="2"><div align="center">
                                <label>
                                    <input name="reset" type="reset" id="reset" value=" Reset  " />
                                </label>
                            </div></td>
                        </tr>
                    </table>
           
                </form>
                ${errors}       
                <form id="form2" action="room_validate.page" method="post">
                    <table border="1"> 
                        <tr align="center"> 
                            <td>Result number</td>
                            <td>Type</td>
                            <td>View</td>
                            <td>Price</td>
                            <td>Select room</td>
                        </tr> 
                        <c:forEach var="record" items="${results2.rows}" varStatus="count">
                            <c:if test="${count.count mod 2 ==0}">
                                <tr bgcolor="FF6666" align="center">
                                    
                                        <td><font color="white">${count.count}</font></td>
                                        <td><font color="white"><c:out value="${record.room_type}"/> </font></td>
                                        <td><font color="white"><c:out value="${record.room_view}"/> </font></td>
                                        <td><font color="white"><c:out value="${record.room_price}"/> </font></td>  
                                        <td><input type="checkbox" name="selected_rooms" value="${record.room_id}">
                                    
                                </tr>
                            </c:if>
                                
                            <c:if test="${count.count mod 2 !=0}">
                                <tr bgcolor="CCFFFF" align="center">
                                    <td>${count.count}</td>
                                    <td><c:out value="${record.room_type}"/> </td>
                                    <td><c:out value="${record.room_view}"/> </td>
                                    <td><c:out value="${record.room_price}"/> </td>
                                    <td><input type="checkbox" name="selected_rooms" value="${record.room_id}">
                                </tr>
                            </c:if>
                        </c:forEach>
                        <tr>
                            <c:if test="${results2 != null}">
                                <td><input type="submit" name="Submit" value="Submit" /></td>
                                <td><input type="reset" name="Reset" value="Reset" /></td>
                            </c:if>
                        </tr>
                    </table>
                </form>
                ${msg}
            </div>
            <div class="ndesign" id="nnavi">
                <%@include file="navigation_buttons.jsp"%>
            </div>
            <div class="ndesign" id="welcome"></div>
        </div>
    </body>
</html>
