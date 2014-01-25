<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <script type="text/javascript" src="imag v2/js/prototype.js"></script>
        <script type="text/javascript" src="imag v2/js/scriptaculous.js?load=effects"></script>
        <script type="text/javascript" src="imag v2/js/lightbox.js"></script>
        <link rel="stylesheet" href="imag v2/css/lightbox.css" type="text/css" media="screen" />
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Untitled Document</title>
        <style type="text/css">

            @import url("CSS/ndesign.css");
            .style1 {color: #FFFFFF}

        </style>
    </head>

    <body>
        <div class="ndesign" id="cssall">
            <div class="ndesign" id="nlocation">
                <div align="center">
                    <p>&nbsp;</p>
                    <p><img src="location gif/Sayad.gif" alt="sayad" width="295" height="100"></p>
                </div>
            </div>
            <div class="ndesign" id="nclock">
                <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="100" height="100" title="c">
                    <param name="movie" value="SWF/Clock.swf">
                    <param name="quality" value="high">
                    <embed src="SWF/Clock.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="100" height="100"></embed>
                </object>
            </div>
            <%@include file="trace_n_taglib.jsp"%> 
            <div class="ndesign" id="nwelcome">
                <div align="center">${tracing_bean.title} ${tracing_bean.name}</div>
            </div>
            <div class="ndesign" id="ncenter">
                <div class="ndesign" id="center_pic"><a href="web_images/sayadlogo.jpg" rel="lightbox" title="Sayad Logo"><img src="web_images/sayadlogo.jpg" alt="sayadf" width="160" height="90"></a></div>
                <div class="ndesign" id="line">
                    <div align="center"><span class="style1">Select a Picture </span></div>
                </div>
                <p>Let Sayad bring the sea's treasures to your table with lavish flair.</p>
                <p> Your every   wish is our command at Sayad where</p>
                <p> your every whim and whimsy will be fulfilled.</p>
                <p> Our fishermen have been placed around the globe and freshly caught </p>
                <p>seafood is   flown in especially for our clientele on a daily basis.</p>
                <p>&nbsp;</p>
                <p>&nbsp;</p>
                <p>&nbsp;</p>
                <p>&nbsp;</p>
                <p align="center"><a href="web_images/sayad_web.jpg" rel="lightbox" title="Sayad"><img src="web_images/sayad_web.jpg" alt="sayad" width="150" height="150"></a><a href="web_images/sayadaq_thump.jpg" rel="lightbox" title="Sayad"> <img src="web_images/sayadaq_thump.jpg" alt="sayad" width="150" height="150"></a> <a href="web_images/sayadentrance_thump.jpg" rel="lightbox" title="Sayad"><img src="web_images/sayadentrance_thump.jpg" alt="sayad" width="150" height="150"></a></p>
            </div>
            <div class="ndesign" id="nsound">
                <embed src="sound/melfes Shining Blue.mp3" width="145" height="40" autoplay="true" loop="true" volume="50"></embed>
            </div>  
            <div class="ndesign" id="nnavi">
                <%@include file="navigation_buttons.jsp"%>
                <font color="white" >${errors}</font>
            </div>
        </div>
    </body>
</html>
