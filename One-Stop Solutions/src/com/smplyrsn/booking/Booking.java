package com.smplyrsn.booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Booking
 */
@WebServlet("/Booking")
public class Booking extends HttpServlet {
	
	String url="jdbc:mysql://localhost:3306/test";
	String username="root";
	String pass="aa3ro";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int spid= Integer.parseInt(request.getParameter("spid"));
		HttpSession session = request.getSession(true);
		
        String email= (String)session.getAttribute("email");
        
        String sql="call restobooking('"+email+"',"+spid+")";
	try {	
		
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,pass);
		PreparedStatement st=con.prepareStatement(sql);
		ResultSet rs=st.executeQuery();
	    } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	response.sendRedirect("homepage.jsp");
}
}