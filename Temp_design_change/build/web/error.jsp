<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<%@page isErrorPage="true"%>
<script type="text/javascript" src="java_script/moveobj.js"> </script>
<script type="text/javascript">

/***********************************************
* Floating image script- By Virtual_Max (http://www.geocities.com/siliconvalley/lakes/8620)
* Modified by Dynamic Drive for various improvements
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

//Step 1: Define unique variable names depending on number of flying images (ie:3):
var flyimage1

function pagestart(){
//Step 2: Using the same variable names as 1), add or delete more of the below lines (60=width, height=80 of image):
 flyimage1=new Chip("flyimage1",47,68);


//Step 3: Using the same variable names as 1), add or delete more of the below lines:
movechip("flyimage1");

}

if (window.addEventListener)
window.addEventListener("load", pagestart, false)
else if (window.attachEvent)
window.attachEvent("onload", pagestart)
else if (document.getElementById)
window.onload=pagestart

</script>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Error</title>
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
  <%@include file="trace_n_taglib.jsp"%>
  <div class="ndesign" id="nwelcome">
    <div align="center">${tracing_bean.name} ${tracing_bean.surname} </div>
  </div>
  <div class="ndesign" id="nclock">
    <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="100" height="100">
      <param name="movie" value="SWF/Clock.swf">
      <param name="quality" value="high">
      <embed src="SWF/Clock.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="100" height="100"></embed>
    </object>
  </div>
  
  <div class="ndesign" id="ncenter">
      
      <h1 align="center">
          Error
      </h1>
      <p>
      Sorry, there was an error in the process, please try again later!!<br><br>
      <%= exception %>
      
      </p>
  </div>
  <div class="ndesign" id="nnavi">
      <%@include file="navigation_buttons.jsp"%>
  </div>
  <div class="ndesign" id="welcome"></div>
</div>

<DIV ID="flyimage1" STYLE="position:absolute; left: -500px; width:47; height:68;">
<IMG SRC="web_images/bug2.gif" BORDER=0>
</DIV>


</body>
</html>
