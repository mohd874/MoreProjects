<%@ page language="java"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for customerEditForm form</title>
	</head>
	<body>
		<html:form action="/customerEdit">
		<html:hidden property="id"/>
		<html:hidden property="do" value="saveCustomer"/>		
		First Name: <html:text property="firstname"/><br/>
		Last name <html:text property="lastname"/><br/>
		Age <html:text property="age"/><br/>	
			<html:submit/><html:cancel/>
		</html:form>
	</body>
</html>