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
.subcontainer {
  text-align: left;
  position: center;
  width: 800px;
  background-color: white;
  padding: 20px;
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
.account{
	font-size: 20pt;
	vertical-align: middle;
	text-align: right;
	color: #2E2E2E;
	margin-bottom: 0;
	position: inline;
}
a {text-decoration: none; color: black;} /* All anchors */
a:link, a:visited {text-decoration: none; color: black;} /* Override */

</style>
<script type="text/javascript" src="//tinymce.cachefly.net/4.0/tinymce.min.js"></script>
<script type="text/javascript">
 
 tinymce.init({
    selector: "textarea",
    theme: "modern",
    width: 800,
    height: 300,
    plugins: [
         "advlist autolink link image lists preview hr anchor",
         "searchreplace code fullscreen insertdatetime media",
         "save table contextmenu directionality emoticons paste "
   ],
   paste_as_text: true,
   paste_text_sticky: true,
   paste_text_sticky_default: true,
   toolbar: "undo redo | bold italic | alignleft aligncenter alignjustify | bullist numlist outdent indent | l      ink image |  preview media fullpage ", 
 }); 
 
 function validateForm()
 {
	 var x=document.forms["postit"]["title"].value;
	 if (x==null || x=="")
	   {
		   alert("Title must be filled out");
		   return false;
	   }
 }
</script>

</head>
<body>
<center>

 <img class='circular' src="https://fbcdn-profile-a.akamaihd.net/hprofile-ak-frc1/t1.0-1/p160x160/1912414_433749300089607_2133199806_n.png" "/>
 <h1><bold>DEV &amp; TECH</bold> blogs</h1>
 <div class="container">
    <div class="account"> user: ${user.fullname}  | <a href="../logout"><strong>logout</strong></a>  <img src = "http://icons.iconarchive.com/icons/custom-icon-design/mini/24/Login-in-icon.png" width="24px" height="23px"/></div>
    <div class="subcontainer">
    <form:form method="post" name="postit" id="postit" modelAttribute="post" action="save" onsubmit="return validateForm()">
	    Title: <form:input class="input-small" path="title"  />
		<form:textarea path="content"/>
		<form:hidden path="id"/>
		<p><a href="javascript: history.go(-1)"><< back </a><input class="button" type="submit" name="submit" id="submit" value="Save" /></p>
	</form:form>
	</div>
</div>
</center>
</body>
</html>