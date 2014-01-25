<%-- 
    Document   : hello
    Created on : Feb 20, 2008, 5:37:33 PM
    Author     : Saeed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Using Implicit Objects</title>
    </head>
    <body>
        <h2>Hello World!</h2>
        <%
            out.println("<br/>Your IP address is "+ request.getRemoteAddr());
            String userAgent = request.getHeader("user-agent");
            String browser = "unknown";
            out.println("<br/>and your browser is ");
            if(userAgent != null){
                if(userAgent.indexOf("MSIE") > -1){
                    browser = "MS Internet Explorer";
                }else if(userAgent.indexOf("FireFox") > -1){
                    browser = "Mozilla FireFox";
                }
            }
            
            out.println(browser);
        %>
    </body>
</html>
