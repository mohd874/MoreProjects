<%@page import="java.util.Date" contentType="text/html" pageEncoding="UTF-8"%>

<html>

	<head>
		<title> My First JSP Page </title>
	</head>

	<body>

	<h1 style="text-align: center">JSP Page</h1>
	<br/>
	<%
		Date today = new Date();
		out.println(today);
	%>
	</body>
</html>