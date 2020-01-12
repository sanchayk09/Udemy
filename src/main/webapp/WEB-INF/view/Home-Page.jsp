<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home-Page</title>
</head>
<body>
	<h1>Good Job</h1>
	<br/>
	<h3>
		User: <security:authentication property="principal.username"/>
		<br/><br/>
		User: <security:authentication property="principal.authorities"/>
		
	</h3>
	
	<br>
	<hr/>
	<security:authorize access="hasRole('MANAGER')">
		<a href="${pageContext.request.contextPath}/leaders">Mangerial View</a><br/>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
	<a href="${pageContext.request.contextPath}/system">Admin View</a>
	</security:authorize>
	<form:form action="${pageContext.request.contextPath}/logout"
	method="POST">
	
	<input type="Submit" value="logout"/>
	</form:form>
</body>
</html>