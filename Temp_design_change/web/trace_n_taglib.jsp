<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page errorPage="error.jsp"%>

<jsp:useBean id="tracing_bean" class="com.hotel.model.tracing_bean" scope="session" >
    <jsp:setProperty name="tracing_bean" property="uname" value="Guest"/>
    <jsp:setProperty name="tracing_bean" property="name" value="Guest"/>
    <jsp:setProperty name="tracing_bean" property="title" value=""/>
    <jsp:setProperty name="tracing_bean" property="utype" value="5"/>
</jsp:useBean> 

<div class="ndesign" id="menu1">
    <div align="center" class="style1"><a href="home.jsp">Home</a></div>
</div>
  <div class="ndesign" id="menu2">
      <div align="center"><span class="style1"><a href="facilities.jsp">Facilities</a></span></div>
  </div>
  <div class="ndesign" id="menu3">
      <div align="center" class="style1"><a href="Rooms.jsp">Rooms</a></div>
  </div>