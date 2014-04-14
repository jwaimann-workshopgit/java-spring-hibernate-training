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
.subhead {
  width: 100%;
  height: 1px;
  background-color: #5DA552;
  position: absolute;
}
.circular {
	width: 100px;
	height: 100px;
	border-radius: 150px;
	-webkit-border-radius: 150px;
	-moz-border-radius: 150px;
	}
.circular-img {
  width: 20px;
  height: 20px;
  border-top-left-radius: 150px;
  border-top-right-radius: 150px;
  border-bottom-right-radius: 150px;
  border-bottom-left-radius: 150px;
  background-image: url(http://link-to-your/image.jpg);
  background-position: initial initial;
  background-repeat: no-repeat no-repeat;
}
.container {
  margin: 50px auto;
  width: 90%;
  height:95%;
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
  width: 90%;
  height:95%;
  background-color: #FFF;
  background:rgba(255,255,255,0.5);
  border-radius: 5px;
  -webkit-border-radius: 5px;
  -moz-border-radius: 5px;
}
html
{
  background-image:url('http://wallpapersfor.me/wp-content/uploads/2012/02/city-hazy-blurred-unsharp-night-rain-1920x1080.jpg'); 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}
 .foot {
  width: 100%;
  position: relative;
  bottom: 0px;
  margin:0 auto;  
}
.textfoot {
  padding: 0px;
  margin: 0px 0px 0px 20px;
  font-weight: 500;
  text-align: left;
  margin-left: 15%;
}
.dates
{
  font-weight: 500;
  font-size: 10pt;
  text-align: left;
  margin-left: 15%;
}
a {text-decoration: none; color: black;} /* All anchors */
a:link, a:visited {text-decoration: none; color: black;} /* Override */

</style>
</head>
<body>
<div class="container">
  <div class="login">
    <img class='circular' src="https://fbcdn-profile-a.akamaihd.net/hprofile-ak-frc1/t1.0-1/p160x160/1912414_433749300089607_2133199806_n.png"/>  
     <br>
   <div class="foot">
   <div class ="subhead">
    
    </div>
    <br>
   <div class="textfoot"><h2>LATEST POSTS</h2></div>

   <c:forEach items="${posts}" var="postVar" varStatus="status">
   <div class="dates"> ${postVar.date}</div>
   <div class="textfoot"> <a href="${postVar.user.username}/${postVar.id}"><strong> ${postVar.title}</strong> by   ${postVar.user.fullname} <img class="circular-img" src="${postVar.user.imageurl} "> </a></div><br>
   </c:forEach> 
       <div class ="subhead">   </div>
   </div>
   <div class="foot2"></div>
  </div>
</div>
</body>
</html>