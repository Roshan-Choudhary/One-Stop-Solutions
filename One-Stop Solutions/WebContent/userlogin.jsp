<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>User Login</title>
<link rel="stylesheet" type="text/css" href="css/loginstyle.css">
</head>
<body background="img/loginback.jpg">

	<a href="front.jsp"> <img id="back" src="img/backicon.png"
		alt="back">
	</a>

	<div id="form">

		<image src="img/usericon.png" alt="usericon" id="icon"></image>

		<form action="UserLogin" method="post">
			<h2>User Login</h2>
			Email<br> <input type="text" name="email"><br>

			Password<br> <input type="password" name="password"
				maxlength="15"><br> <input type="submit" value="submit"><br>

			New to One-Stop Solutions?<br> &nbsp &nbsp &nbsp &nbsp &nbsp
			&nbsp &nbsp<a href="uregform.jsp">Register</a>here




		</form>
	</div>
</body>
</html>
</html>