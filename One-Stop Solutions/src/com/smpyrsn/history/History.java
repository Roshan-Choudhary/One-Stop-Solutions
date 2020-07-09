package com.smpyrsn.history;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smplyrsn.spresult.*;

/**
 * Servlet implementation class History
 */
@WebServlet("/History")
public class History extends HttpServlet {

	String url="jdbc:mysql://localhost:3306/test";
	String username="root";
	String pass="aa3ro";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		HttpSession session = request.getSession(true);
	    String email= (String) session.getAttribute("email");
        
        String sql="select b.bookid,s.*,b.bookedtime from test.spdetails s, test.booking b where s.spid=b.spid and b.email='"+email+"'";

		int count=0;
		spresult[] booking_history= new spresult[20];


		response.setContentType("text/html");
			
		try {
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(url,username,pass);
				PreparedStatement st=con.prepareStatement(sql);
				ResultSet rs=st.executeQuery();
				
				
				
				while(rs.next())
				{
					booking_history[count]=new spresult();
					
					booking_history[count].setSpid(rs.getInt("spid"));
					booking_history[count].setBookid(rs.getInt("bookid"));
					booking_history[count].setSpname(rs.getString("spname"));
					booking_history[count].setGender(rs.getString("gender"));
					booking_history[count].setContactno(rs.getString("contactno"));
					booking_history[count].setService(rs.getString("service"));
					booking_history[count].setTimings(rs.getString("timings"));
					booking_history[count].setBookedtime(rs.getString("bookedtime"));
					
					count++;
					
				}
				
				
				
						
			  request.setAttribute("booking_history",booking_history);
			  request.setAttribute("count", count);
			  
			  RequestDispatcher rd=request.getRequestDispatcher("history.jsp");
			  rd.forward(request,response);
			 
				
				}catch(Exception e)

				{
					e.printStackTrace();
				}
			
	}


}
