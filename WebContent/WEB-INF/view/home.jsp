<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<title>MS D&T BLOGS</title>
<style>
body
{
	font-family: 'Open Sans', sans-serif;
	color: #585858;
 	background-color:#FAFAFA;
 	-webkit-font-smoothing: antialiased;
 	-webkit-text-shadow: rgba(0,0,0,.01) 0 0 1px;
}
.content
{
	font-size:14px;
	width:800px;
	
}
</style>
</head>

<body>
	<h1>MS D&T BLOGS : jwaimann@makingsense</h1>
	
<%-- 	<h2>Add User: ${user.username} </h2> --%>
	
	
	<h2> ${post.title} </h2>
	<p>${post.date} </p>
	<p><div class="content">${post.content}</div>  </p>
	

	
	<h2>List of posts</h2>
	
	<table>
	
		<c:forEach items="${posts}" var="postVar" varStatus="status">
		
		<tr>
			<td>${postVar.title}</td>
			
		</tr>
		
		</c:forEach>
		
	</table>

</body>
</html>