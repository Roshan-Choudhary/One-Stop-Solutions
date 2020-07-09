<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<HEAD>
<title>One-Stop Solutions</title>
<link rel="stylesheet" type="text/css" href="css/style5.css">
<link rel="stylesheet" type="text/css" href="css/style6.css">

</HEAD>
<body background="img/afterloginback.jpg">
	<div id="nav">

		<ul>
			<li><a href="search.jsp" id="onclick">Search</a></li>

			<li><a href="History">Your Bookings</a></li>

			<li><a href="LoggedUserDetails">Your Details</a></li>

			<div id="currentuser">
				${email} &nbsp; &nbsp; <font face="verdana" color="red">Logout</font>
				<a href="Logout"> <img src="img/logout.png" alt="logout">
				</a>

			</div>
		</ul>
	</div>
	<div id="actual">

		<form action="Search">

			SERVICE<br> <select name="service">
				<option value="">none</option>
				<option value="cook">cook</option>
				<option value="maid">maid</option>
				<option value="carpenter">carpenter</option>
				<option value="painter">painter</option>
				<option value="plumber">plumber</option>
			</select><br> Area<br> <select name="area" required>
				<option></option>
				<option value="RR Nagar">RR Nagar</option>
				<option value="Banashankari">Banashankari</option>
				<option value="JP Nagar">JP Nagar</option>
			</select><br> TIMINGS<br> <select name="timings">
				<option value="morning">9am-2pm(Morning)</option>
				<option value="evening">2pm-6pm(Evening)</option>
				<option value="night">6pm-10pm(Night)</option>
			</select><br> PREFERRED WORKER's GENDER<br> <input type="radio"
				name="gender" value="m">Male <input type="radio"
				name="gender" value="f">Female<br> MINIMUM EXPERIENCE<br>
			<input type="number" placeholder="eg. 2yrs " min="0" max="10"
				name="exp"><br> <input type="submit" value="submit">
		</form>

	</div>

	<div id="imageslider">
		<div id="slider">

			<figure>
				<img src="img/1.jpg" alt="not working">
				<img src="img/2.jpg">
				<img src="img/3.jpg">
				<img src="img/4.jpg" alt="not comming">

			</figure>
		</div>

	</div>


	<!-- for removing backspace problem -->
	<%
		
			response.setHeader("Cache-Control","no-cache,no-store,must-validate");// http 1.1
			response.setHeader("Pragma","no-cache");// http 1.0 (not reqd in new version)
			response.setHeader("Expires","0");//proxies (servers)
		
		
			if(session.getAttribute("email")==null)
				response.sendRedirect("userlogin.jsp");

		 %>

</body>

</HTML>
