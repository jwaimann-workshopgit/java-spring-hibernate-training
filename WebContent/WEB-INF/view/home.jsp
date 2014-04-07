<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JPA - Hibernate Example</title>
</head>

<body>
	<h1>JPA - Hibernate Example</h1>
	
	<h2>Add User: </h2>
	
	<form:form method="post" modelAttribute="user" action="save">
	
	<p> <label>Username: </label> <form:input class="input-small" path="username" />
		<label>${usernameMessage}</label></p>
	
	<p><input class="button" type="submit" name="submit" value="Add" /></p>
	
	</form:form>
	
	<h2>List of Users</h2>
	
	<table>
		<tr>
			<th>ID</th>
			<th>Username</th>
		</tr>
		
		<c:forEach items="${users}" var="userVar" varStatus="status">
		
		<tr>
			<td>${userVar.id}</td>
			<td>${userVar.username}</td>
		</tr>
		
		</c:forEach>
		
	</table>

</body>
</html>