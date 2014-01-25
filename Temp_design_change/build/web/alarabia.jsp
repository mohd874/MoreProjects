<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Untitled Document</title>
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
            <div class="ndesign" id="ncenter">
                <div class="ndesign" id="line">
                    <div align="center"><span class="style1">Select a Picture </span></div>
                </div>
                <div align="center">
                    <p>
                        <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="544" height="178">
                            <param name="movie" value="SWF/alarabia_bannernew.swf">
                            <param name="quality" value="high">
                            <embed src="SWF/alarabia_bannernew.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="544" height="178"></embed>
                        </object>
                    </p>
                    <p>The Daffodils Palace offered the arabia press and media shop that will support the palace guests with magazines and newspapers. This will keep the palaces guests in a good relation with the external world.</p>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <p><img src="web_images/arabia1.gif" width="150" height="150"> <img src="web_images/arabia2.gif" width="150" height="150"> <img src="web_images/arabia3.gif" width="150" height="150"></p>
                </div>
            </div>
            <div class="ndesign" id="nlocation">
                <div align="center">
                    <p>&nbsp;</p>
                    <p><img src="location gif/ALARABIA.gif" width="295" height="100"></p>
                </div>
            </div>
            <%@include file="trace_n_taglib.jsp"%> 
            <div class="ndesign" id="nwelcome">
                <div align="center">${tracing_bean.title} ${tracing_bean.name}</div>
            </div>
            <div class="ndesign" id="nnavi">
                <%@include file="navigation_buttons.jsp"%>
            </div>
            <div class="ndesign" id="nsound">
                <embed src="sound/melfes Shining Blue.mp3" width="145" height="40" autoplay="true" loop="true" volume="50"></embed>
            </div>
            <div class="ndesign" id="nclock">
                <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="100" height="100">
                    <param name="movie" value="SWF/Clock.swf">
                    <param name="quality" value="high">
                    <embed src="SWF/Clock.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="100" height="100"></embed>
                </object>
            </div>
        </div>
    </body>
</html>
