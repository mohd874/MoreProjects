<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <script type="text/javascript" src="imag v2/js/prototype.js"></script>
        <script type="text/javascript" src="imag v2/js/scriptaculous.js?load=effects"></script>
        <script type="text/javascript" src="imag v2/js/lightbox.js"></script>
        <link rel="stylesheet" href="imag v2/css/lightbox.css" type="text/css" media="screen" />

        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Welcome To Daffodils Palace Hotel</title>
        <style type="text/css">
            @import url("CSS/ndesign.css");
            .style1 {color: #FFFFFF}
            a:link {
            color: #FFFFFF;
            text-decoration: none;
            }
            a:visited {
            text-decoration: none;
            color: #FFFFFF;
            }
            a:hover {
            text-decoration: underline;
            color: #FFFFFF;
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
                    <p><img src="location gif/Meetings.gif" width="295" height="100"></p>
                </div>
            </div>
            <%@include file="trace_n_taglib.jsp"%> 
            <div class="ndesign" id="nwelcome">
                <div align="center">${tracing_bean.title} ${tracing_bean.name}</div>
            </div>
            <div class="ndesign" id="ncenter">
                <div class="ndesign" id="center_pic"><a href="web_images/d5.jpeg" rel="lightbox" title="Daffodils Palace Logo"><img src="web_images/d5.jpeg" width="198" height="198"></a></div>
                <p align="justify">Whether it's a convention for over   1000 people or </p>
                <p align="justify">an intimate business meeting, Daffodils Palace Hotel </p>
                <p align="justify">has all the   facilities, equipment and experienced </p>
                <p align="justify">staff that you need to make it a success. </p>
                <p align="justify">&nbsp;</p>
                <p align="justify">&nbsp;</p>
                <div class="ndesign" id="line">
                    <div align="center" class="style1">Select a Picture </div>
                </div>
                <p align="justify">&nbsp;</p>
                <p align="justify">&nbsp;</p>
                <p align="justify">&nbsp;</p>
                <p align="center"><a href="web_images/meeting1.gif" rel="lightbox" title="Meeting Room"><img src="web_images/meeting1.gif" width="150" height="150"></a> <a href="web_images/meeting2.gif" rel="lightbox" title="Meeting Room"><img src="web_images/meeting2.gif" width="150" height="150"></a></p>
            </div>
            <div class="ndesign" id="nnavi">
                <%@include file="navigation_buttons.jsp"%>
                <font color="white" >${errors}</font>
            </div>
            <div class="ndesign" id="nclock">
                <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="100" height="100">
                    <param name="movie" value="SWF/Clock.swf">
                    <param name="quality" value="high">
                    <embed src="SWF/Clock.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="100" height="100"></embed>
                </object>
            </div>
            <div class="ndesign" id="nsound">
                <embed src="sound/melfes Shining Blue.mp3" width="145" height="40" autoplay="true" loop="true" volume="50"></embed>
            </div>
        </div>
    </body>
</html>
