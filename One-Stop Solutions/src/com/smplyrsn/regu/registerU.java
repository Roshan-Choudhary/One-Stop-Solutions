package com.smplyrsn.regu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class register
 */
@WebServlet("/registerU")
public class registerU extends HttpServlet {
	
	String url="jdbc:mysql://localhost:3306/test";
	String username="root";
	String pass="aa3ro";
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String contact=request.getParameter("contact");
		String city=request.getParameter("city");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		
		
		//int phn=Integer.parseInt(contact);
		
		PrintWriter out=response.getWriter();
		//out.println(name+" "+uname+" "+contact+" "+email);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,pass);
			CallableStatement st=con.prepareCall("{call userinfo('"+email+"','"+fname+"','"+lname+"','"+contact+"','"+address+"','"+city+"','"+password+"')}");
			st.execute();
			/*
			 * int i=st.executeUpdate("insert into usrreg values('"+name+"','"+uname+"','"+
			 * password+"',"+contact+",'"+email+"')");
			 */
				
			//out.println("registered");
			response.sendRedirect("userlogin.jsp");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
