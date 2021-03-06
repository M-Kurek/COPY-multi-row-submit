<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Spring 3 MVC Multipe Row Submit</title>
<style>
table {
	border: 1px solid;
	border-collapse: collapse;
}
td {
	border: 1px solid;
}
th {
	background: #ffbb00;
}
</style>
</head>
<body>

<h2>Spring MVC Multiple Row Form Submit </h2>
<span>Every cell ready to edit</span>
<div>
<form:form method="post" action="save.html" modelAttribute="contactForm">
	<table>
	<tr>
		<th>No.</th>
		<th>Name</th>
		<th>Lastname</th>
		<th>Email</th>
		<th>Phone</th>
	</tr>
	<c:forEach items="${contactForm.contacts}" var="contact" varStatus="status">
		<tr>
			<td align="center">${status.count}</td>
			<td><input name="contacts[${status.index}].firstname" value="${contact.firstname}"/></td>
			<td><input name="contacts[${status.index}].lastname" value="${contact.lastname}"/></td>
			<td><input name="contacts[${status.index}].email" value="${contact.email}"/></td>
			<td><input name="contacts[${status.index}].phone" value="${contact.phone}"/></td>
		</tr>
	</c:forEach>
</table>	
</div>

<input type="submit" value="Save" />
	
</form:form>
</body>
</html>
