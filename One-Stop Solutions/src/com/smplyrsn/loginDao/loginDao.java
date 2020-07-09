package com.smplyrsn.loginDao;

import java.sql.*;

import java.sql.DriverManager;

public class loginDao {
	
	String url="jdbc:mysql://localhost:3306/test";
	String username="root";
	String pass="aa3ro";
	String sql="select * from test.userauth where useremail=? and pass=?";
	
	public boolean check(String email,String password)
	{

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,pass);
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,email);
			st.setString(2,password);
			ResultSet rs=st.executeQuery();
			
			if(rs.next())
			{
				return true;
			}
			
		}catch(Exception e)
		
		{
			e.printStackTrace();
		}
		
		
		return false;
	}

}
