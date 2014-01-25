<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Facilites</title>
        <style type="text/css">

            @import url("CSS/ndesign.css");
            .style1 {color: #FFFFFF}
            a:link {
            text-decoration: none;
            }
            a:visited {
            text-decoration: none;
            }
            a:hover {
            text-decoration: underline;
            }
            a:active {
            text-decoration: none;
            }

        </style>
    </head>

    <body>
        <div class="ndesign" id="cssall">
            <div class="ndesign" id="nlocation">
                <div align="center">
                    <p>&nbsp;</p>
                    <p><img src="location gif/Facility.gif" width="295" height="100"></p>
                </div>
            </div>
            <%@include file="trace_n_taglib.jsp"%> 
            <div class="ndesign" id="nwelcome">
                <div align="center">${tracing_bean.title} ${tracing_bean.name}</div>
            </div>
            <div class="ndesign" id="nnavi">
                <%@include file="navigation_buttons.jsp"%>
            </div>
            <div class="ndesign" id="nclock">
                <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="100" height="100">
                    <param name="movie" value="SWF/Clock.swf">
                    <param name="quality" value="high">
                    <embed src="SWF/Clock.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="100" height="100"></embed>
                </object>
            </div>
            <div class="ndesign" id="ncenter">
                <div class="ndesign" id="fac_pic1">
                    <div align="center">
                        <p><a href="alarabia.jsp"><img src="web_images/arabia1.gif" width="150" height="150" border="0"></a></p>
                        <p><a href="alarabia.jsp">Al Arabia Press &amp; Media </a></p>
                    </div>
                </div>
                <div class="ndesign" id="fac_pic2">
                    <p align="center"><a href="swimming pool.jsp"><img src="web_images/espa_thump.jpg" width="150" height="150" border="0"></a></p>
                    <p align="center"><a href="swimming pool.jsp">Swimming Pool &amp; Beach </a></p>
                </div>
                <div class="ndesign" id="fac_pic3">
                    <div align="center">
                        <p><a href="kunooz.jsp"><img src="web_images/kunooz.gif" width="150" height="150" border="0"></a></p>
                        <p><a href="kunooz.jsp">Kunooz Jewellary Store </a></p>
                    </div>
                </div>
                <div class="ndesign" id="fac_pic4">
                    <div align="center">
                        <p><a href="meeting rooms.jsp"><img src="web_images/Img085.gif" width="150" height="150" border="0"></a></p>
                        <p><a href="meeting rooms.jsp">Meeting Rooms</a></p>
                    </div>
                </div>
                <div class="ndesign" id="fac_pic5">
                    <div align="center">
                        <p>&nbsp;</p>
                        <p><a href="havanaclub.jsp"><img src="web_images/havanaclublogo2.jpg" width="150" height="100" border="0"></a></p>
                        <p><a href="havanaclub.jsp">Havana Club </a></p>
                    </div>
                </div>
                <div class="ndesign" id="fac_pic6">
                    <div align="center">
                        <p><a href="Rooms.jsp"><img src="web_images/d5.jpeg" width="150" height="150" border="0"></a></p>
                        <p><a href="Rooms.jsp">Daffodils Palace Hotel Rooms </a></p>
                    </div>
                </div>
                <div class="ndesign" id="fac_pic7">
                    <div align="center">
                        <p>&nbsp;</p>
                        <p><a href="Sayad.jsp"><img src="web_images/sayadlogo.GIF" width="150" height="100" border="0"></a></p>
                        <p><a href="Sayad.jsp">Sayad Resturan</a></p>
                        <p>&nbsp;</p>
                    </div>
                </div>
                <div class="ndesign" id="fac_pic8">
                    <div align="center">
                        <p><a href="conference_hall.jsp"><img src="web_images/epaudit1.jpg" width="150" height="150" border="0"></a></p>
                        <p><a href="conference_hall.jsp">Conference Hall </a></p>
                    </div>
                </div>
            </div>
            <div class="ndesign" id="nsound">
                <embed src="sound/melfes Shining Blue.mp3" width="145" height="40" autoplay="true" loop="true" volume="50"></embed>
            </div>
        </div>
    </body>
</html>
