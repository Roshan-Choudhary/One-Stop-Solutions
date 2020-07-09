<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.smplyrsn.spresult.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SP Results1</title>
<link rel="stylesheet" type="text/css" href="css/searchresultsstyle.css">

</head>

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
	<form action="Booking" method="get">
		<table id="sp">
			<tr>
				<th>SP Name</th>
				<th>Gender</th>
				<th>Experience</th>
				<th>Area</th>
				<th>Contact no.</th>
				<th>Service</th>
				<th>Book</th>
			</tr>


			<%
	
		int count=(int) (request.getAttribute("count"));

		spresult[] result=(spresult[]) (request.getAttribute("result"));
		
		for(int i=0;i<count;i++)
	 	 { %>

			<tr>
				<td><font color="white"><%=(result[i].getSpname())%></font></td>
				<td><font color="white"><%=(result[i].getGender())%></font></td>
				<td><font color="white"><%=(result[i].getExp())%></font></td>
				<td><font color="white"><%=(result[i].getArea())%></font></td>
				<td><font color="white"><%=(result[i].getContactno())%></font></td>
				<td><font color="white"><%=(result[i].getService())%></font></td>


				<td><input type="radio" name="spid"
					value=<%=result[i].getSpid()%>></td>
			</tr>

			<% } %>
		</table>
		<br>
		<br> <input type="submit" onclick="alert('Booking Successfull')"
			value="submit">

	</form>
</body>
</html>