package com.smplyrsn.UserLogin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smplyrsn.loginDao.loginDao;


/**
 * Servlet implementation class Login
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String email=request.getParameter("email");
		 String password=request.getParameter("password");
		 
		 loginDao dao=new loginDao();
		 
		 if(dao.check(email,password))
		 {
			 HttpSession session=request.getSession();
			 session.setAttribute("email",email);
			 response.sendRedirect("homepage.jsp");
		 }
		 
		 else
		 {
			 response.sendRedirect("userlogin.jsp");
		 }
	}


}
