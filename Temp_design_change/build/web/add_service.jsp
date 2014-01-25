<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Add Service</title>
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
                ${errors}
                <form name="form1" method="post" action="add_service_control.page">
                    <table width="500" height="138">
                        <tr>
                            <th colspan="2" scope="col"><h1>Add Service</h1></th>
                        </tr>
                        <tr>
                            <th scope="row">Service Type: </th>
                            <td><label>
                                <input name="service_type" type="text" id="service_type">
                            </label></td>
                        </tr>
                        <tr>
                            <th scope="row">Service Description: </th>
                            <td><label>
                                <textarea name="service_desc" id="service_desc"></textarea>
                            </label></td>
                        </tr>
                        <tr>
                            <th scope="row"><label>
                                <input type="submit" name="Submit" value="Submit">
                            </label></th>
                            <td><label>
                                <input name="reset" type="reset" id="reset" value="Reset">
                            </label></td>
                        </tr>
                    </table>
                    <p></p>
                    <p></p>
                    <p></p>
                    <p>
                        <a href="home.jsp">HOME</a>
                    </p>
      
                </form>

            </div>
            <div class="ndesign" id="nnavi">
                <%@include file="navigation_buttons.jsp"%>
            </div>
            <div class="ndesign" id="welcome"></div>
        </div>
    </body>
</html>
