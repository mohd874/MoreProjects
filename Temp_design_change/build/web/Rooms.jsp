<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <script type="text/javascript" src="imag v2/js/prototype.js"></script>
        <script type="text/javascript" src="imag v2/js/scriptaculous.js?load=effects"></script>
        <script type="text/javascript" src="imag v2/js/lightbox.js"></script>
        <link rel="stylesheet" href="imag v2/css/lightbox.css" type="text/css" media="screen" />

        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Welcome To Daffodils Palace</title>
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
                    <p><img src="location gif/Rooms.gif" width="295" height="100"></p>
                </div>
            </div>
            <%@include file="trace_n_taglib.jsp"%>
            <div class="ndesign" id="nwelcome">
                <div align="center">${tracing_bean.title} ${tracing_bean.name}</div>
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
            <div class="ndesign" id="ncenter">
                <div class="ndesign" id="center_pic"><a href="web_images/d5.jpeg" rel="lightbox" title="Daffodils Palace Logo"><img src="web_images/d5.jpeg" width="191" height="160"></a></div>
                <div class="ndesign" id="line">
                    <div align="center"><span class="style1">Luxury  Room </span></div>
                </div>
                <p>Daffodils Palace Hotel Have:</p>
                <ul>
                    <li>130 room</li>
                </ul>
                <div class="ndesign style1" id="line2">
                    <div align="center">Khaleej Room </div>
                </div>
                <p>&nbsp;</p>
                <ul>
                    <li>every room have plasma screen</li>
                </ul>
                <p>&nbsp;</p>
                <ul>
                    <li>every room have a private balcony</li>
                </ul>
                <p>&nbsp;</p>
                <ul>
                    <li>every room have have a good working area </li>
                </ul>
                <p>&nbsp;</p>
                <p align="left">Tranquil color combinations of light blue, gold and cr&egrave;me in silk upholstery,</p>
                <p align="left">brightened up by honey brown wooden veneer and marble floorings, create the</p>
                <p align="left">perfect atmosphere for relaxation. Added to this are magnificent views of either</p>
                <p align="left">lush exotic gardens or intricately landscaped swimming pools or glistening blue</p>
                <p align="left">waves of the Arabian Gulf</p>
                <p align="center"><a href="web_images/grandroom_thump.jpg" rel="lightbox" title="Luxury Bed Room"><img src="web_images/grandroom_thump.jpg" width="150" height="150"></a> <a href="web_images/grandbathroom_thump.jpg" rel="lightbox" title="Luxury Room Bathroom"><img src="web_images/grandbathroom_thump.jpg" width="150" height="150"></a></p>
                <p align="center">&nbsp;</p>
                <p align="left">the Khaleej Suites comprise a spacious lounge area, bedroom and a luxury</p>
                <p align="left">bathroom. The Khaleej Deluxe Suites offer complete options for entertaining and</p>
                <p align="left">living with a separate lounge and a dining room</p>
                <p align="center"><a href="web_images/khaleejbedroom_thump.jpg" rel="lightbox" title="Khaleej Bed Room"><img src="web_images/khaleejbedroom_thump.jpg" width="150" height="150"></a> <a href="web_images/khaleejbathroom_thump.jpg" rel="lightbox" title="Khaleej Bathroom"><img src="web_images/khaleejbathroom_thump.jpg" width="150" height="150"></a></p>
                <div class="ndesign" id="line3">
                    <div align="center" class="style1">Royal Room </div>
                </div>
                <p align="left">The Royal Suite guest quarters include a magnificent master bedroom and two   more</p>
                <p align="left"> bedrooms decorated in gentle tones, gold and silver leaf and rich marble   with a</p>
                <p align="left">spacious bath including jacuzzi and rain shower.<BR>
                </p>
                <p align="center"><a href="web_images/palacebathroom_thump.jpg" rel="lightbox" title="Royal Bethroom"><img src="web_images/palacebathroom_thump.jpg" width="150" height="150"></a> <a href="web_images/palacebedrooma_thump.jpg" rel="lightbox" title="Royal Bed Room"><img src="web_images/palacebedrooma_thump.jpg" width="150" height="150"></a> <a href="web_images/palacebathroomb_thump.jpg" rel="lightbox" title="Royal Bathroom"><img src="web_images/palacebathroomb_thump.jpg" width="150" height="150"></a></p>
            </div>
            <div class="ndesign" id="nsound">
                <embed src="sound/melfes Shining Blue.mp3" width="145" height="40" autoplay="true" loop="true" volume="50"></embed>
            </div>
        </div>
    </body>
</html>
