package com.smplyrsn.cancellation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Cancellation")
public class Cancellation extends HttpServlet {
	
	String url="jdbc:mysql://localhost:3306/test";
	String username="root";
	String pass="aa3ro";
	
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	 int spid=Integer.parseInt(request.getParameter("spid"));
	 
	 String sql="delete from booking where spid="+spid+"";
	 
		try {	
				
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,pass);
			PreparedStatement st=con.prepareStatement(sql);
			st.executeUpdate();
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		response.sendRedirect("homepage.jsp");
	}
}


