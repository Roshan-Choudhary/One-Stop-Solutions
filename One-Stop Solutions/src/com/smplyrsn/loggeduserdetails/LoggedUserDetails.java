package com.smplyrsn.loggeduserdetails;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smplyrsn.spresult.spresult;

import javax.servlet.RequestDispatcher;  
import java.io.*;  
import java.sql.*;  
import javax.servlet.http.*;  

/**
 * Servlet implementation class LoggedUserDetails
 */
@WebServlet("/LoggedUserDetails")

public class LoggedUserDetails extends HttpServlet {
	
	String url="jdbc:mysql://localhost:3306/test";
	String username="root";
	String pass="aa3ro";

	int count=0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		String current_user_email=(String)session.getAttribute("email");
		
		String sql="select * from userdetails where email=?";
		
		/* '"+current_user_email+"' */
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,pass);
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,(String)session.getAttribute("email"));
			
			ResultSet rs=st.executeQuery();
			
			String current_user_details[]= new String[6];
			
			while(rs.next())
			{
				
				current_user_details[0]=(rs.getString("email"));
				current_user_details[1]=(rs.getString("fname"));
				current_user_details[2]=(rs.getString("lname"));
				current_user_details[3]=(rs.getString("contact"));
				current_user_details[4]=(rs.getString("address"));
				current_user_details[5]=(rs.getString("city"));		
			
			}
			
			
			
			  request.setAttribute("current_user_details",current_user_details);   
			  RequestDispatcher rd=request.getRequestDispatcher("details.jsp");
			  rd.forward(request,response);
			 
			

			
			}catch(Exception e)

			{
				e.printStackTrace();
			}
		
	}


}
