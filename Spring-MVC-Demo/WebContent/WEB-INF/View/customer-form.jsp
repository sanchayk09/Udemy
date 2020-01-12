<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Registration Form</title>
<style>
.error{color:red}
</style>
</head>
<body>
	<form:form action="processForm" method="post" modelAttribute="customer">
	<table>
	<tr>
	<td>First Name:</td>
	<td><form:input path="firstName"/></td>
	</tr>
	<tr>
	<td>Last Name(*):</td>
	<td><form:input path="lastName"/>
	<form:errors path="lastName" cssClass="error"></form:errors>
	</td>
	</tr>
	<tr>
	<td>Free Passes(*):</td>
	<td><form:input path="freePasses"/>
	<form:errors path="freePasses" cssClass="error"></form:errors>
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