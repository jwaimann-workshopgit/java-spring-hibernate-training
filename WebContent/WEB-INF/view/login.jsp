<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<title>Insert title here</title>
<style>
.container {
  margin: 50px auto;
  width: 640px;
  font-family: 'Open Sans', sans-serif;
  text-align:center;
}
 
.login {
  position: relative;
  margin: 0 auto;
  padding: 20px 20px 20px;
  width: 310px;
}
</style>
<script>
function signinCallback(authResult) {
  if (authResult['status']['signed_in']) {
    // Update the app to reflect a signed in user
    // Hide the sign-in button now that the user is authorized, for example:
    document.getElementById('signinButton').setAttribute('style', 'display: none');
  } else {
    // Update the app to reflect a signed out user
    // Possible error values:
    //   "user_signed_out" - User is signed-out
    //   "access_denied" - User denied access to your app
    //   "immediate_failed" - Could not automatically log in the user
    console.log('Sign-in state: ' + authResult['error']);
  }
}
</script>
</head>
<body>
<div class="container">
  <div class="login">
    <h1><bold>MS DEV &amp; TECH</bold><br>blogs</h1>
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
    <script type="text/javascript">
      (function() {
       var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
       po.src = 'https://apis.google.com/js/client:plusone.js';
       var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
     })();
    </script>
</body>
</html>