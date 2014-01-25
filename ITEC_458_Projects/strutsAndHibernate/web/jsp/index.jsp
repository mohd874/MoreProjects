<%@ page language="java"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
 
<html> 
	<head>
		<title>Welcome to Library Web</title>
	</head>
	<body>
  <body>
    Welcome!
    <br>
    <html:link action="bookList">Show the book list</html:link>
    <br>
    <html:link action="customerList">Show the customer list</html:link>
  </body>
</html>