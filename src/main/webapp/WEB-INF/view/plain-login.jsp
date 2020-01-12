<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Custom Login</title>
<style>
		
		.failed{
			color: red
		}

</style>
</head>
<body>
	<h3>My Custom login</h3>
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
	method="POST">
	<c:if test="${param.error!=null }">
	
	<i class="failed">ERROR</i>
	
	</c:if>
	
		<table>
			<tr>
				<td>User Name:</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<th><input type="Submit" value="Login" /> </th>
			</tr>
		</table>
	
	</form:form>
</body>
</html>