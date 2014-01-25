<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <script type="text/javascript" src="imag v2/js/prototype.js"></script>
        <script type="text/javascript" src="imag v2/js/scriptaculous.js?load=effects"></script>
        <script type="text/javascript" src="imag v2/js/lightbox.js"></script>
        <link rel="stylesheet" href="imag v2/css/lightbox.css" type="text/css" media="screen" />
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Welcome to Daffodils Palace Hotel</title>
        <style type="text/css">
            <!--
            @import url("CSS/ndesign.css");
            -->
        </style>
    </head>
    
    <body>
        <div class="ndesign" id="cssall">
            <div class="ndesign" id="news">
                <script language="JavaScript1.2">
                   
                    /*
                    Cross browser Marquee script- © Dynamic Drive (www.dynamicdrive.com)
                    For full source code, 100's more DHTML scripts, and Terms Of Use, visit http://www.dynamicdrive.com
                    Credit MUST stay intact
                    */

                    //Specify the marquee's width (in pixels)
                    var marqueewidth="300px"
                    //Specify the marquee's height
                    var marqueeheight="25px"
                    //Specify the marquee's marquee speed (larger is faster 1-10)
                    var marqueespeed=1
                    //configure background color:
                    var marqueebgcolor="#ddcaf5"
                    //Pause marquee onMousever (0=no. 1=yes)?
                    var pauseit=1

                    //Specify the marquee's content (don't delete <nobr> tag)
                    //Keep all content on ONE line, and backslash any single quotations (ie: that\'s great):

                    var marqueecontent='<nobr><font face="Arial">Today is the grand opening of Daffodiles Palace Hotel were you will recieve top service like none other, Please enjoy your stay. If there is any complaint or suggestion please call: +9712-6009900 or email: <a href="mailto:customersupport@daffodils.com?subject=compliment%20or%20suggestion" style="color:blue"> customersupport@daffodils.com </a> </font></nobr>'


                    ////NO NEED TO EDIT BELOW THIS LINE////////////
                    marqueespeed=(document.all)? marqueespeed : Math.max(1, marqueespeed-1) //slow speed down by 1 for NS
                    var copyspeed=marqueespeed
                    var pausespeed=(pauseit==0)? copyspeed: 0
                    var iedom=document.all||document.getElementById
                    if (iedom)
                    document.write('<span id="temp" style="visibility:hidden;position:absolute;top:-100px;left:-9000px">'+marqueecontent+'</span>')
                    var actualwidth=''
                    var cross_marquee, ns_marquee

                    function populate(){
                    if (iedom){
                    cross_marquee=document.getElementById? document.getElementById("iemarquee") : document.all.iemarquee
                    cross_marquee.style.left=parseInt(marqueewidth)+8+"px"
                    cross_marquee.innerHTML=marqueecontent
                    actualwidth=document.all? temp.offsetWidth : document.getElementById("temp").offsetWidth
                    }
                    else if (document.layers){
                    ns_marquee=document.ns_marquee.document.ns_marquee2
                    ns_marquee.left=parseInt(marqueewidth)+8
                    ns_marquee.document.write(marqueecontent)
                    ns_marquee.document.close()
                    actualwidth=ns_marquee.document.width
                    }
                    lefttime=setInterval("scrollmarquee()",20)
                    }
                    window.onload=populate

                    function scrollmarquee(){
                    if (iedom){
                    if (parseInt(cross_marquee.style.left)>(actualwidth*(-1)+8))
                    cross_marquee.style.left=parseInt(cross_marquee.style.left)-copyspeed+"px"
                    else
                    cross_marquee.style.left=parseInt(marqueewidth)+8+"px"

                    }
                    else if (document.layers){
                    if (ns_marquee.left>(actualwidth*(-1)+8))
                    ns_marquee.left-=copyspeed
                    else
                    ns_marquee.left=parseInt(marqueewidth)+8
                    }
                    }

                    if (iedom||document.layers){
                    with (document){
                    document.write('<table border="0" cellspacing="0" cellpadding="0"><td>')
                    if (iedom){
                    write('<div style="position:relative;width:'+marqueewidth+';height:'+marqueeheight+';overflow:hidden">')
                    write('<div style="position:absolute;width:'+marqueewidth+';height:'+marqueeheight+';background-color:'+marqueebgcolor+'" onMouseover="copyspeed=pausespeed" onMouseout="copyspeed=marqueespeed">')
                    write('<div id="iemarquee" style="position:absolute;left:0px;top:0px"></div>')
                    write('</div></div>')
                    }
                    else if (document.layers){
                    write('<ilayer width='+marqueewidth+' height='+marqueeheight+' name="ns_marquee" bgColor='+marqueebgcolor+'>')
                    write('<layer name="ns_marquee2" left=0 top=0 onMouseover="copyspeed=pausespeed" onMouseout="copyspeed=marqueespeed"></layer>')
                    write('</ilayer>')
                    }
                    document.write('</td></table>')
                    }
                    }
                </script>
            </div>
            <div class="ndesign" id="nlocation">
                <div align="center">
                    <p>&nbsp;</p>
                    <p><img src="location gif/Home.gif" width="295" height="100"></p>
                </div>
            </div>
            <%@include file="trace_n_taglib.jsp"%> 
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
            <sql:setDataSource url="jdbc:mysql://localhost:3306/dph_db_test" driver="com.mysql.jdbc.Driver" user="root" password="7710072" var="myDB"/>
            
            <sql:transaction dataSource="${myDB}">
                <sql:query var="events" >
                    Select
                    es.date_from,
                    es.date_to,
                    es.description,
                    s.name,
                    s.surname,
                    f.facility_type,
                    e.event_type
                    From
                    event_schedule AS es
                    ,
                    sysuser AS s
                    ,
                    facilities AS f
                    ,
                    events AS e
                    Where
                    es.facility_no = f.facility_no AND
                    s.user_id = es.customer_id AND
                    es.event_id = e.event_id AND
                    es.home_show = 'y' AND
                    date_from > (select curdate())
                    limit 0,3
                </sql:query>
            </sql:transaction>
            <div class="ndesign" id="ncenter">
                
                <div class="ndesign style1" id="line">
                    <div align="center" style="color:white">The upcoming Events </div>
                </div>
                <div class="ndesign" id="center_pic"><a href="web_images/d5.jpeg" rel="lightbox" title="Daffodils Palace Logo"><img src="web_images/d5.jpeg" width="150" height="150"></a></div>
                <p align="justify">Feel the promise of a majestic   experience fit for</p>
                <p align="justify">a king and deserving of an emperor.</p>
                <p align="justify">The Palace boasts 130   superior rooms</p>
                <p align="justify">each combining the ultimate in luxury</p>
                <p align="justify">with 22nd century technology.</p>
                <p align="justify">&nbsp;</p>
                <p align="justify">&nbsp;</p>
                <p align="justify">&nbsp;</p>
                <p align="justify">&nbsp;</p>
                <div class="ndesign" id="center-center">
                    
                    
                    <table width="500" height="150" border="1">
                        <c:forEach var="event" items="${events.rows}" varStatus="count">
                        
                            <tr>
                                <td width="126">
                                <b>Event number:</b>                            </td>
                                <td width="189" align="center">
                                ${count.count}</td>
                                <td width="189">
                                <b>Date From:</b></td>
                                <td width="189">
                                ${event.date_from}</td>
                                <td width="189">
                                <b>Date To:</b></td>
                                <td width="189">
                                ${event.date_to}</td>
                            
                            </tr>
                        
                            <tr>
                                <td width="126">
                                <b>Customer Name:</b>                            </td>
                                <td width="189" colspan="5">
                                ${event.name} ${event.surname}                            </td>
                            </tr>
                            <tr>
                                <td>
                                    <b>Facility:</b>
                                </td>
                                <td colspan="5">
                                    ${event.facility_type} 
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <b>Event:</b>
                                </td>
                                <td colspan="5">
                                    ${event.event_type} 
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <b>Description:</b>
                                </td>
                                <td colspan="5">
                                    ${event.description} &nbsp;
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
              
                </div>
                <p align="justify"><BR>
                </p>
               
            </div>
            <div class="ndesign" id="nnavi">
                <%@include file="navigation_buttons.jsp"%>
                <font color="white" >${errors}</font>
            </div>
            <div class="ndesign" id="welcome"></div>
        </div>
    </body>
</html>
