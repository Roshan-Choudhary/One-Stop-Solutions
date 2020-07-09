<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<title>SP Registration</title>
<link rel="stylesheet" type="text/css" href="css/spregstyle1.css">
</head>
<body background="img/spback.jpg">

	<a href="front.jsp"> <img src="img/backicon.png" alt="back">
	</a>

	<div id="form">
		<form action='register' method='post'>

			<h2>Enter Details</h2>

			Name<br> <input type="text" placeholder="eg. Ritwik Gupta"
				name="spname" required><br> Gender<br> <input
				type="radio" name="gender" value="m">Male <input
				type="radio" name="gender" value="f">Female<br>

			Experience<br> <input type="number" placeholder="eg. 2yrs "
				min="1" max="10" name="exp" required><br> Area<br>
			<select name="area" required>
				<option></option>
				<option value="RR Nagar">RR Nagar</option>
				<option value="Banashankari">Banashankari</option>
				<option value="JP Nagar">JP Nagar</option>
			</select><br> Contact No.<br> <input type="text"
				placeholder="7004467948" name="contactno" length accept="10"
				required><br> Service type<br> <select
				name="service" required>
				<option></option>
				<option value="cook">cook</option>
				<option value="maid">maid</option>
				<option value="carpenter">carpenter</option>
				<option value="painter">painter</option>
				<option value="plumber">plumber</option>
			</select><br> TIMINGS<br> <select name="timings">
				<option value="morning">9am-2pm(Morning)</option>
				<option value="evening">2pm-6pm(Evening)</option>
				<option value="night">6pm-10pm(Night)</option>
			</select><br> <input type="submit" value="submit"> <br>

			<%--           	<font color="red"> &nbsp ${Success}</font>
            <% session.invalidate();  %>
         --%>
		</form>

	</div>
</body>
</html>