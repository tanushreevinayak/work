package edu.iiitb.sis.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.Login;

public class AuthenticationDao
{
	private String loginQuery;
	private String message;
	
	/*
	 * The Following method checks login details and returns the authentication type
	else it will return the message whether user exists or not 
	
	*/
	
	public String checkLogin(Login login)
	{
		
		try
		{
				
			Connection con=ConnectionPool.getConnection();
			Statement loginStmt=con.createStatement();
			
			//Query To Retrieve Login Information based on given user name
			
			loginQuery="select * from login where login_id='"+login.getUserName()+" '";
			ResultSet rs=loginStmt.executeQuery(loginQuery);
			
			if(rs.next())
			{
				if(login.getUserName().equals(rs.getString("login_id"))&&login.getPassword().equals(rs.getString("password")))
				{
					//Authentication Type
					if(rs.getString("user_type").equals("A"))
					{
						message="Admin";
						System.out.println(message);
						
					}
					else if(rs.getString("user_type").equals("F"))
					{
						message="Faculty";
					}
					else
					{
						message="Student";
					}
								
				}
				else
				{
					//Incorrect Password
					 message="Invalid User name/Password";
					 System.out.println(message);
				}
				
			}
			else
			{
				//There is no login information exists with given user name 
				message="User Doesn't Exist";
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			message="failure";
			return message;
		}
		return message;
		
	}
	
	
}
