package com.smplyrsn.cancelhistory;

import java.io.IOException;
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

import com.smplyrsn.spresult.spresult;


@WebServlet("/CancelHistory")
public class CancelHistory extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="jdbc:mysql://localhost:3306/test";
		String username="root";
		String pass="aa3ro";
		
		HttpSession session = request.getSession(true);
		String current_user_email=(String)session.getAttribute("email");
		
		String sql="Select s.*,c.bookid,c.candate from cancelledbookings c,spdetails s where s.spid=c.spid and c.email=?";
		
		response.setContentType("text/html");
	
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,pass);
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,current_user_email);
			ResultSet rs=st.executeQuery();
			
			int count=0;
			spresult[] cancel_history= new spresult[20];
			
			while(rs.next())
			{
				cancel_history[count]=new spresult();
				
				cancel_history[count].setSpid(rs.getInt("spid"));
				cancel_history[count].setBookid(rs.getInt("bookid"));
				cancel_history[count].setSpname(rs.getString("spname"));
				cancel_history[count].setGender(rs.getString("gender"));
				cancel_history[count].setContactno(rs.getString("contactno"));
				cancel_history[count].setService(rs.getString("service"));
				cancel_history[count].setTimings(rs.getString("timings"));
				cancel_history[count].setBookedtime(rs.getString("candate"));
				
				count++;
				
			}
			
			
			  request.setAttribute("cancel_history",cancel_history); 
			  request.setAttribute("count", count);
			  RequestDispatcher rd=request.getRequestDispatcher("cancelhistory.jsp");
			  rd.forward(request,response);
			 
			

			
			}catch(Exception e)

			{
				e.printStackTrace();
			}
	}


}
