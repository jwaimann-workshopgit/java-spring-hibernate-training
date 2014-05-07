<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://apis.google.com/js/plusone.js" type="text/javascript"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<title>MS D&T BLOGS</title>
<style>
.circular {
	width: 100px;
	height: 100px;
	border-radius: 150px;
	-webkit-border-radius: 150px;
	-moz-border-radius: 150px;
	}
.container {
  margin: 50px auto;
  width: 640px;
  font-family: 'Open Sans', sans-serif;
  text-align:center;
  -webkit-font-smoothing: antialiased;
  -webkit-text-shadow: rgba(0,0,0,.01) 0 0 1px;
}
 
.login {
  position: center;
  margin: 0 auto;
  margin-top: 10%;
  padding: 20px 20px 20px;
  width: 310px;
  background-color: #FFF;
  background:rgba(255,255,255,0.5);
  border-radius: 5px;
  -webkit-border-radius: 5px;
  -moz-border-radius: 5px;
}
html
{
  background-image:url("http://upload.wikimedia.org/wikipedia/commons/3/34/Rub_al_Khali_002.JPG"); 
  
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}
a {text-decoration: none; color: white;} /* All anchors */
a:link, a:visited {text-decoration: none; color: white;} /* Override */
</style>

</head>
<body>
<div class="container">
  <div class="login">
    <img class='circular' src="https://fbcdn-profile-a.akamaihd.net/hprofile-ak-frc1/t1.0-1/p160x160/1912414_433749300089607_2133199806_n.png"/>
    <h1><bold>DEV &amp; TECH</bold><br>blogs</h1>
    Oops! Something went wrong. <br>We couldn't authenticate user
    <br>
    <a href="../user/login"><strong>GO BACK!</strong></a>
  </div>
</div>
</body>
</html>