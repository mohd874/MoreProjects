<%@ taglib prefix="a" uri="http://jmaki/v1.0/jsp" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test Login Page</title>
        <%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
        <%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
        
    </head>
    <body>
        <h1>Test Login Page</h1>
        <html:errors />
        <html:form action="myLoginTest">
            <table border="0">
                <thead>
                    <tr>
                        <th>Login</th>
                        <th>Page</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><bean:message key="login.name" /></td>
                        <td><html:text property="name" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><html:password property="password" /></td>
                    </tr>
                    <tr>
                        <td>User Type</td>
                        <td>
                            <html:select property="type">
                                <html:option value="user">User</html:option>
                                <html:option value="officer">Officer</html:option>
                                <html:option value="admin">Admin</html:option>
                            </html:select>
                        </td>
                    </tr>
                    <tr>
                        <td><html:submit value="Login" /></td>
                    </tr>
                </tbody>
            </table>
        </html:form>
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
        
        
        <a:widget name="dojo.clock"  />
        
    </body>
</html>
