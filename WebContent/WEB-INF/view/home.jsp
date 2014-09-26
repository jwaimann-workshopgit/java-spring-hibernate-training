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
html, body {
    width: 100%;
    height: 100%;
    margin: 0px;
    background-color: #128EC7;
    font-family: 'Open Sans', sans-serif;
    text-align: center;
  }
body {
	
	color: #585858;
	
	-webkit-font-smoothing: antialiased;
	-webkit-text-shadow: rgba(0,0,0,.01) 0 0 1px;
}
.header_container { 
	left:0; 
	position:fixed; 
	width:100%; 
	top:0; 
	z-index:999;
}
.head {
  width: 100%;
  height: 180px;
  background-image: url(http://wallpapersfor.me/wp-content/uploads/2012/02/city-hazy-blurred-unsharp-night-rain-1920x1080.jpg);
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  color: white;
  position: relative;
  margin:0 auto; 
}
.subhead {
  width: 100%;
  height: 3%;
  background-color: #128EC7;
  position: absolute;
}
.texthead {
  font-size: 5.9vw;
  margin: 0px 0px 0px 30px;
  padding-top: 15px;
  vertical-align: middle;
  font-weight: 600;
  text-decoration: none;
}
.textfoot {
  color: white;
  padding: 0px;
  margin: 0px 0px 0px 20px;
  font-weight: 500;
  text-align: left;
  margin-left: 15%;
}
.subtexthead {
  color: white;
  font-size: 12pt;
  margin: 0px 0px 0px 40px;
  font-weight: 200;
  text-align: left;
}
.textcontent{
  padding:10;
  margin-left: 15%;
  font-size: 11pt;
  max-width: 70%;
  text-align:justify;
  text-justify:inter-word;
}
.container { 
	background-color:#FAFAFA;
	margin:0 auto; 
	overflow:auto; 
	padding-top:200px; 
	
	width:100%; 
	z-index:0;	
}
.content {
  width: 100%;
  position: relative;
  bottom: 0px;
}
 .foot {
  width: 100%;
  height: 200px;
  background-color: #128EC7;
  position: relative;
  bottom: 0px;
  margin:0;  
}

.circular {
  width: 90px;
  height: 90px;
  border-top-left-radius: 150px;
  border-top-right-radius: 150px;
  border-bottom-right-radius: 150px;
  border-bottom-left-radius: 150px;
  background-image: url(http://link-to-your/image.jpg);
  background-position: initial initial;
  background-repeat: no-repeat no-repeat;
}
.h1
{
	text-align: left;
}
.icon
{
	height:15px;
	width:15px;
}
a {text-decoration: none; color: white;} /* All anchors */
a:link, a:visited {text-decoration: none; color: white;} /* Override */
.ui-datepicker { font-size: 8pt !important;}
.filters{
   text-align: right;
}
</style>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/flick/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#datepicker" ).datepicker({
    	
    	dateFormat: 'dd-mm-yy',
    	onClose: function(dateText, inst){ if (dateText!="") window.location.href=".?date="+dateText;}
    });
  });
  </script>
</head>

 <body>
 <div class="header_container">
    <div class="head">
      <p class="texthead">${user.fullname}
        <img class="circular" src="${user.imageurl}"> 
      </p>
       <div class="subtexthead"><center>${user.username} @msdtblogs</center></div>
       
    </div>
    <div class ="subhead">
      
    </div>
 </div>
 <div class ="container">
     <div class="content">
        
	    <div class="textcontent">
	         <div class="filters">Filter a date: <input id="datepicker"></input> </div>
	         <c:if test="${not empty  post}" >
		      <h1>${post.title} </h1> <img class="icon" src="http://www.danddlondon.com/wp-content/themes/brandstyle1/images/groupsite-brands/calendar-icon.png"/>${post.date}
		      <br>${post.content}<br>
		      </c:if>
		      <c:if test="${empty post}" >
		      <center>
		      <br>
		      <img src="http://capcitypetcare.com/img/check.png">
		      <h2>Nothing here yet!</h2>
		      <br>
		      </center>
		      </c:if>
	    </div>
    </div>
 </div>
 <div class="foot">
   <div class="textfoot"><img src="http://demo.athemes.com/wp-metro/wp-content/themes/wpmetro/images/icon_menu.png"><h2>LATEST POSTS</h2></div>
   <c:forEach items="${posts}" var="postVar" varStatus="status">
   <div class="textfoot"><a href="./${postVar.id}">- <strong>${postVar.title}</strong> from ${postVar.date}</a></div>
   </c:forEach> 
 </div>
</body>
</html>