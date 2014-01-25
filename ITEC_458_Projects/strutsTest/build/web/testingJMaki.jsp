<%@ taglib prefix="a" uri="http://jmaki/v1.0/jsp" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>JSP Page</h1>
    
    <a:widget name="yahoo.calendar" />

    <a:widget name="jmaki.menu"
      value="{menu : [
       {label: 'Links',
            menu: [
                { label : 'Sun.com',
                  href : 'http://www.sun.com'},
                { label : 'jMaki.com',
                  href : 'http://www.jmaki.com'}
                ]
       },
       {label: 'Actions',
            menu: [
                { label : 'Select',
                  action :{topic: '/foo/select',
                         message: { targetId : 'bar'}}
                },
                { label :'Set Content',
                  action :{topic: '/foo/setContent',
                         message: { value : 'test.jsp'}}
                }
                ]}
                ]
       }" />

    </body>
</html>
