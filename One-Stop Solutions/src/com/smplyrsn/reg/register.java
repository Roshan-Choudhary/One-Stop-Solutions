package com.smplyrsn.reg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	
	String url="jdbc:mysql://localhost:3306/test";
	String username="root";
	String pass="aa3ro";
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * String ename=request.getParameter("ename"); String
		 * sex=request.getParameter("sex"); String
		 * workas=request.getParameter("workas"); int
		 * expr=Integer.parseInt(request.getParameter("expr")); String
		 * timeslot=request.getParameter("timeslot");
		 */
		
		String spname=request.getParameter("spname");
		String g=request.getParameter("gender");
		char gender=g.charAt(0);
		String service=request.getParameter("service");
		int exp=Integer.parseInt(request.getParameter("exp"));
		String area=request.getParameter("area");
		String contactno=request.getParameter("contactno");
		String timings=request.getParameter("timings");
		
		PrintWriter out=response.getWriter();
	
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,pass);
	
			CallableStatement stm=con.prepareCall("{call intospdetails('"+spname+"','"+gender+"',"+exp+",'"+area+"','"+contactno+"','"+service+"','"+timings+"')}");
			stm.execute();


			//CallableStatement ste=con.prepareCall("{call intospdetails('"+spname+"','"+gender+"',"+exp+",'"+area+"','"+contactno+"','"+service+"','"+evening+"')}");
			//ste.execute();
			//CallableStatement stn=con.prepareCall("{call intospdetails('"+spname+"','"+gender+"',"+exp+",'"+area+"','"+contactno+"','"+service+"','"+night+"')}");
			//stn.execute();
			
			//"insert into spdetails(spname,gender,exp,area,contactno,service,timings) values('"+spname+"','"+gender+"',"+exp+",'"+area+"','"+contactno+"','"+service+"','"+morning+"');");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		
		
		/*
		 * String success_msg="Registeration Successfull"; HttpSession
		 * session1=request.getSession(); session1.setAttribute("Success",success_msg);
		 */
		 
		 
		response.sendRedirect("regform.jsp");
	}

}
