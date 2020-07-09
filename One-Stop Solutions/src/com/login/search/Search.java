package com.login.search;
import javax.servlet.RequestDispatcher;  
import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smplyrsn.spresult.spresult;



@WebServlet("/Search")
public class Search extends HttpServlet {
	
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		
   		String url="jdbc:mysql://localhost:3306/test";
		String username="root";
		String pass="aa3ro";
				
		String service=request.getParameter("service");
		String area=request.getParameter("area");
		String timings=request.getParameter("timings");
		String g=request.getParameter("gender");
		char gender=g.charAt(0);
		int exp=Integer.parseInt(request.getParameter("exp"));

		String sql="select s.* from test.spdetails s where s.spid not in (select distinct b.spid from booking b) and s.service='"+service+"' and s.area='"+area+"' and s.timings='"+timings+"' and s.gender='"+gender+"' and s.exp>='"+exp+"'";
		int count=0;
		spresult[] result= new spresult[20]; 

		response.setContentType("text/html");
			
		try {
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(url,username,pass);
				PreparedStatement st=con.prepareStatement(sql);

				//				PreparedStatement st=con.prepareStatement(sql);
//				st.setString(1,service);
//				st.setString(2,area);
//				st.setString(3,timings);
//				st.setString(4,g);
//				st.setInt(5,exp);
				
				ResultSet rs=st.executeQuery();
				
				
				
				while(rs.next())
				{
					result[count]=new spresult();
					
					result[count].setSpid(rs.getInt("spid"));
					result[count].setSpname(rs.getString("spname"));
					result[count].setGender(rs.getString("gender"));
					result[count].setArea(rs.getString("area"));
					result[count].setExp(rs.getInt("exp"));
					result[count].setContactno(rs.getString("contactno"));
					result[count].setService(rs.getString("service"));
					result[count].setTimings(rs.getString("timings"));
					count++;
				}
				
				
			request.setAttribute("result", result);
			request.setAttribute("count", count);
				
			RequestDispatcher rd=request.getRequestDispatcher("searchresults.jsp");
			rd.forward(request,response);
				
				}catch(Exception e)

				{
					e.printStackTrace();
				}
			

   	}
}