<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<HEAD>
<title>One-Stop Solutions</title>
<link rel="stylesheet" type="text/css" href="css/style5.css">

</HEAD>

<body background="img/afterloginback.jpg">

	<div id="nav">

		<ul>
			<li><a href="search.jsp">Search</a></li>

			<li><a href="History">Your Bookings</a></li>

			<li><a href="LoggedUserDetails">Your Details</a></li>

			<div id="currentuser">
				${email} &nbsp; &nbsp; <font face="verdana" color="red">Logout</font>

				<a href="Logout"> <img src="img/logout.png" alt="logout">
				</a>

			</div>

		</ul>

	</div>
	<div id="main">

		<h1>HOW IT ALL WORKS?</h1>


		<p>"Initially ,the service providers need to fill a form
			comprising their basic details such as name,gender,contact number,
			complete address, work-timings. These details will be added in
			database as they join. On the other hand, the Users will be provided
			with an interactive UI , where they have to select desired options
			such as State,city,area, locality, service type ,gender preference,
			pay range. According to their search, filtered results will be
			produced from the database. If User proceeds to book particular
			worker, he/she has to fill form comprising their details such as
			name, address, contact number. After submission of this form ,user
			has to complete payment and will receive booking confirmation . After
			this whole procedure the database will be updated accordingly."</p>
	</div>

	<!-- for removing backspace problem -->
	<%
		
			response.setHeader("Cache-Control","no-cache,no-store,must-validate");// http 1.1
			response.setHeader("Pragma","no-cache");// http 1.0 (not reqd in new version)
			response.setHeader("Expires","0");//proxies (servers)
		
		
			if(session.getAttribute("email")==null)
				response.sendRedirect("userlogin.jsp");

		 %>




	<!-- <form action="Logout">
		<br><input type="submit" value="LogOut">
	</form> -->

</body>
</html>