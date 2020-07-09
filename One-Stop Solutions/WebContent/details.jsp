<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<HTML>
<HEAD>
<title>User Detail</title>
<link rel="stylesheet" type="text/css" href="css/style5.css">
<link rel="stylesheet" type="text/css" href="css/details.css">

</HEAD>
<body background="img/afterloginback.jpg">
	<div id="nav">

		<ul>
			<li><a href="search.jsp">Search</a></li>

			<li><a href="History">Your Bookings</a></li>

			<li><a href="LoggedUserDetails" id="onclick">Your Details</a></li>

			<div id="currentuser">
				${username} &nbsp; &nbsp; <font face="verdana" color="red">Logout</font>
				<a href="Logout"> <img src="img/logout.png" alt="logout">
				</a>

			</div>
		</ul>
	</div>

	<div id="main"></div>

	<%
	
        String current_user_details[]=(String[]) (request.getAttribute("current_user_details"));
		//spresult[] result=(spresult[]) (request.getAttribute("result"));
	 %>

	<table id="ud" bgcolor=white>

		<tr>
			<th>Email:</th>
			<td bgcolor=red><h3>
					<p><%=current_user_details[0] %></p>
				</h3></td>
		</tr>

		<tr>
			<th>Fname:</th>
			<td bgcolor=red><h3><%=current_user_details[1] %></h3></td>
		</tr>
		<tr>
			<th>Lname:</th>
			<td bgcolor=red><h3><%=current_user_details[2] %></h3></td>
		</tr>
		<tr>
			<th>Contact:</th>
			<td bgcolor=red><h3><%=current_user_details[3] %></h3></td>
		</tr>
		<tr>
			<th>Address:</th>
			<td bgcolor=red><h3><%=current_user_details[4] %></h3></td>
		</tr>

		<tr>
			<th>City:</th>
			<td bgcolor=red><h3><%=current_user_details[5] %></h3></td>
		</tr>



	</table>





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
