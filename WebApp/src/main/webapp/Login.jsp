<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#loginForm").validate({
			rules: {
				name : {
					required: true
				},
				pass:{
					required: true
				}
			}
		});
	});
</script>

</head>
<body>
<form action="Login" method="post" id="loginForm">

<pre>

User ID  <input type="text" name="name" id="name">

Password <input type="password" name="pass" id="pass">

         <input type="submit" name="Submit" value="Submit">

</pre>

</form>

</body>
</html>