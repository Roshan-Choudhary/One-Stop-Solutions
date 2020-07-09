<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.smplyrsn.spresult.*"%>

<!DOCTYPE html>
<HTML>
<HEAD>
<title>One-Stop Solutions</title>
<link rel="stylesheet" type="text/css" href="css/style5.css">
<link rel="stylesheet" type="text/css" href="css/searchresult.css">
</HEAD>
<body background="img/afterloginback.jpg">

	<div id="nav">

		<ul>
			<li><a href="search.jsp">Search</a></li>

			<li><a href="History" id="onclick">Your Bookings</a></li>

			<li><a href="LoggedUserDetails">Your Details</a></li>

			<div id="currentuser">
				${email} &nbsp; &nbsp; <font face="verdana" color="red">Logout</font>

				<a href="Logout"> <img src="img/logout.png" alt="logout">
				</a>

			</div>
		</ul>
	</div>

	<div id="main">

		<h1>
			<b>Active Booking</b>
		</h1>
		<form action="Cancellation" method="get">
			<table id="sp">
				<tr>
					<th>Booking ID</th>
					<th>SP Name</th>
					<th>SP Gender</th>
					<th>Contact No.</th>
					<th>Service</th>
					<th>Timing</th>
					<th>Booking Time/date</th>
					<th>Cancel Booking</th>
				</tr>


				<%
	
		int count=(int) (request.getAttribute("count"));
		spresult[] booking_history=(spresult[]) (request.getAttribute("booking_history"));
		
		for(int i=0;i<count;i++)
	 	 { %>

				<tr bgcolor=Aquamarine>
					<td><font color="black"><%=(booking_history[i].getBookid())%></font></td>
					<td><font color="black"><%=(booking_history[i].getSpname())%></font></td>
					<td><font color="black"><%=(booking_history[i].getGender())%></font></td>
					<td><font color="black"><%=(booking_history[i].getContactno())%></font></td>
					<td><font color="black"><%=(booking_history[i].getService())%></font></td>
					<td><font color="black"><%=(booking_history[i].getTimings())%></font></td>
					<td><font color="black"><%=(booking_history[i].getBookedtime())%></font></td>

					<td><input type="radio" name="spid"
						value=<%=booking_history[i].getSpid()%>></td>


					<% } %>
				
			</table>
			<br>
			<br> <input type="submit"
				onclick="alert('Cancellation Successfull')" value="CANCEL">
		</form>

		<br>
		<br>
		<form action="CancelHistory" method='get'>
			<input type="submit" value="CancelHistory">
		</form>

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
