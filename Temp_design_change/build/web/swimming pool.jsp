<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <script type="text/javascript" src="imag v2/js/prototype.js"></script>
        <script type="text/javascript" src="imag v2/js/scriptaculous.js?load=effects"></script>
        <script type="text/javascript" src="imag v2/js/lightbox.js"></script>
        <link rel="stylesheet" href="imag v2/css/lightbox.css" type="text/css" media="screen" />

        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Pool</title>
        <style type="text/css">
            <!--
            @import url("CSS/ndesign.css");
            .style1 {color: #FFFFFF}
            -->
        </style>
    </head>

    <body>
        <div class="ndesign" id="cssall">
            <div class="ndesign" id="nlocation">
                <div align="center">
                    <p>&nbsp;</p>
                    <p><img src="location gif/The_Pool.gif" alt="swimming pool" width="295" height="100"></p>
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
            <div class="ndesign" id="nnavi">
                <%@include file="navigation_buttons.jsp"%>
            </div>
            <div class="ndesign" id="ncenter">
                <div class="ndesign" id="center_pic"><a href="web_images/espa_thump.jpg" rel="lightbox" title="The Swimming Pool"><img src="web_images/espa_thump.jpg" alt="swimming pool" width="198" height="198"></a></div>
                <div class="ndesign" id="line">
                    <div align="center"><span class="style1">Select a Picture </span></div>
                </div>
                <p align="justify">&nbsp;</p>
                <p align="justify">1.3 km of secluded private beach and   </p>
                <p align="justify">two swimming pool landscapes on the </p>
                <p align="justify">east and west wing sides. </p>
                <p>&nbsp;</p>
                <p>&nbsp;</p>
                <p>&nbsp;</p>
                <p>&nbsp;</p>
                <p>&nbsp;</p>
                <p align="center"><a href="web_images/beach.jpg" rel="lightbox" title="The Beach"><img src="web_images/beach.jpg" alt="havana" width="150" height="150"></a> <a href="web_images/Pool.jpg" rel="lightbox" title="The Pool"><img src="web_images/Pool.jpg" alt="havana" width="150" height="150"> </a><a href="web_images/Havana-Club-060803-(4).jpg" rel="lightbox" title="my caption"></a></p>
            </div>
            <div class="ndesign" id="nsound"><embed src="sound/melfes Shining Blue.mp3" width="145" height="40" autoplay="true" loop="true" volume="50"></embed></div>
        </div>
    </body>
</html>
