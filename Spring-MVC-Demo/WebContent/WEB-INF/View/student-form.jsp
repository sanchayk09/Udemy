<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration Form</title>
</head>
<body>
	<form:form action="processForm" method="post" modelAttribute="student">
	<table>
	<tr>
	<td>First Name:</td>
	<td><form:input path="firstName"/></td>
	</tr>
	<tr>
	<td>Last Name:</td>
	<td><form:input path="lastName"/></td>
	</tr>
	<tr>
		<td>Country</td>
		<td> 
		<form:select path="country">
		<form:options items="${student.countryOption }" />
		</form:select>
		 
		</td>
	</tr>
	<tr>
	<td>
		<input type="Submit" value="Submit" />
	</td>
	</tr>
	</table>
		
	</form:form>
</body>
</html>