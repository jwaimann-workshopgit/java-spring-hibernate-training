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
  background-image:url("http://www.scenicreflections.com/files/Retro%20Summer%20Beach%20Wallpaper__yvt2.jpg"); 
  
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}
</style>
<script>
function submitform(){
    document.forms["myForm"].submit();
}
function signinCallback(authResult) {
  if (authResult['status']['signed_in']) {
	gapi.auth.setToken(authResult); 
    // Update the app to reflect a signed in user
    // Hide the sign-in button now that the user is authorized, for example:
    document.getElementById('signinButton').setAttribute('style', 'display: none');
    setData();
    $('#token').val(authResult['code']);
    $("#submit").click();
    
  } else {
    // Update the app to reflect a signed out user
    // Possible error values:
    //   "user_signed_out" - User is signed-out
    //   "access_denied" - User denied access to your app
    //   "immediate_failed" - Could not automatically log in the user
    console.log('Sign-in state: ' + authResult['error']);
  }
}
function setData(){
    // Carga las bibliotecas oauth2 para habilitar los métodos userinfo.
    gapi.client.load('oauth2', 'v2', function() {
          var request = gapi.client.oauth2.userinfo.get();
          request.execute(getEmailCallback);
        });
  }

  function getEmailCallback(obj){
    
    $('#username').val((obj['given_name']+obj['family_name']).toLowerCase());
    $('#fullname').val(obj['name']);
    $('#token').val(obj['id']);
    $('#imageurl').val(obj['picture']);
    
   

  }

</script>
</head>
<body>
<div class="container">
  <div class="login">
    <img class='circular' src="https://fbcdn-profile-a.akamaihd.net/hprofile-ak-frc1/t1.0-1/p160x160/1912414_433749300089607_2133199806_n.png"/>
    <h1><bold>DEV &amp; TECH</bold><br>blogs</h1>
    <span id="signinButton">
  <span
    class="g-signin"
    data-callback="signinCallback"
    data-clientid="251114476069.apps.googleusercontent.com"
    data-cookiepolicy="single_host_origin"
    data-requestvisibleactions="http://schemas.google.com/AddActivity"
    data-scope="https://www.googleapis.com/auth/plus.login">
  </span>
</span>
  </div>
</div>
<div  style="visibility:hidden; display:none"> 
	<form:form method="post" name="user" id="user" modelAttribute="user" action="save">
	
	<form:input class="input-small" path="username" />
	<form:input class="input-small" path="fullname" />
	<form:input class="input-small" path="token" />	
	<form:input class="input-small" path="imageurl" />	
	
	<p><input class="button" type="submit" name="submit" id="submit" value="Add" /></p>
	
	</form:form>
</div>

    <script type="text/javascript">
      (function() {
       var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
       po.src = 'https://apis.google.com/js/client:plusone.js';
       var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
     })();
    </script>
</body>
</html>