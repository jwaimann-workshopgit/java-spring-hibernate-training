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
html, body
{
	background-color:#F2F2F2;
	font-family: 'Open Sans', sans-serif;
}
.circular {
	width: 100px;
	height: 100px;
	border-radius: 150px;
	-webkit-border-radius: 150px;
	-moz-border-radius: 150px;
	}
.container {
  width: 800px;
  text-align: left;
  position: center;
}
input[type=text]
{
    position: center; 
    font-size:20pt;
    width: 800px;
}
.button
{
    float: right;
}
.subcontainer {
  text-align: left;
  position: center;
  width: 800px;
  background-color: white;
  padding: 20px;
}
.posts-title {
  width: 100%;
  font-size: 15pt;
  background-color: #2E2E2E;
  color:white;
  bottom: 0;
  margin-bottom:0;
  padding-bottom:0;
}
.posts-action {
  float: right;
  font-size: 12pt;
  margin-right:20px;
  vertical-align: top;
}
.account{
	font-size: 20pt;
	vertical-align: middle;
	text-align: right;
	color: #2E2E2E;
	margin-bottom: 0;
	position: inline;
}
.footer{
	font-size: 8pt;
}
.textfoot{
	font-size: 11pt;
	margin-top:10px;
}
a {text-decoration: none; color: black;} /* All anchors */
a:link, a:visited {text-decoration: none; color: black;} /* Override */

</style>

</head>
<body>
<center>

 <img class='circular' src="https://fbcdn-profile-a.akamaihd.net/hprofile-ak-frc1/t1.0-1/p160x160/1912414_433749300089607_2133199806_n.png" "/>
 <h1><bold>DEV &amp; TECH</bold> blogs</h1>
 <div class="container">
  <div class="account"> user: ${user.fullname} <img src = "http://icons.iconarchive.com/icons/visualpharm/icons8-metro-style/32/Management-Manager-icon.png" width="24px" height="23px"/></div>
  <div class="subcontainer">
    <div class="posts-title"> > Posts </div>
    <c:forEach items="${posts}" var="postVar" varStatus="status">
    <div>
	     <div class="posts-action"><img src="http://icons.iconarchive.com/icons/visualpharm/icons8-metro-style/32/Mathematic-Minus-icon.png" align="bottom" width="24px" height="24px"></div>
	     <a href="../edit/${postVar.id}"><div class="posts-action"><img src="http://icons.iconarchive.com/icons/visualpharm/icons8-metro-style/32/Editing-Edit-icon.png" align="bottom" width="24px" height="24px"></div></a>
	  
	     <div class="textfoot"><strong>${postVar.title}</strong></div>
	
	     <div class="footer">${postVar.date}</div>
	         <hr>
    </div>
    </c:forEach> 
    <br>
    <a href="../add/"><div class="posts-action"><img src="http://icons.iconarchive.com/icons/visualpharm/icons8-metro-style/32/Mathematic-Plus2-icon.png" align="top" width="24px" height="24px"><strong>add</strong></div></a>
    <br>
  </div>
</div>
</center>
</body>
</html>