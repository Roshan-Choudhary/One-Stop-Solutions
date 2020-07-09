<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>User SignUp</title>
<link rel="stylesheet" type="text/css" href="css/userregstyle.css">
</head>

<body background="img/userback.jpg">
	<a href="front.jsp"> <img src="img/backicon.png" alt="back">
	</a>


	<div id="form">
		<form action="registerU" method='post'>
			<h2>User Sign-Up</h2>
			<br> Email <br> <input type="email"
				placeholder="eg. roshan@gmail.com" name="email" required><br>

			First Name<br> <input type="text" placeholder="eg. Roshan"
				name="fname" required><br> Last Name<br> <input
				type="text" placeholder="eg. Choudhary" name="lname"><br>

			Password<br> <input type="password" name="password"
				maxlength="15" required><br> Contact no.<br> <input
				type="text" placeholder="eg. 7587070731" name="contact" required><br>

			Address<br>
			<textarea rows="4" cols="39" name="address" required> </textarea>
			<br> City<br> <select id="cityselect" name='city' required>
				<option></option>
				<option value="Bangalore">Bangalore</option>
				<option value="Ranchi">Ranchi</option>
				<option value="Korba">Korba</option>

			</select><br>
			<br> &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp; <input
				type="submit" value="Submit">

		</form>
	</div>
</body>

</body>
</html>