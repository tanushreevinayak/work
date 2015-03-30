package edu.iiitb.sis.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.Login;
import edu.iiitb.sis.model.UserDetails;

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
			
			loginQuery="select * from login where login_id='"+login.getUserName()+" '"+"and login_status='Active'" ;
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
	public UserDetails getUserDetails(String rollNumber)
	{
		UserDetails user=new UserDetails();
		String query;
		try
		{
			Connection con=ConnectionPool.getConnection();
			Statement emailStmt=con.createStatement();
			query="select student_name,student_mail from student where student_rollno='"+rollNumber+"'";
			ResultSet rs=null;
			rs=emailStmt.executeQuery(query);
			if(rs.next())
			{
				user.setName(rs.getString("student_name"));
				user.setEmail(rs.getString("student_mail"));
			}
			else
			{
				return null;
			}
			user.setPassword(getPassword(rollNumber));
			System.out.println("Roll Number "+rollNumber);
			user.setLoginId(rollNumber);
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
		}
		return user;
	}
	
	public String getPassword(String rollNumber)
	{
		String password=null;
		String query;
		
		try
		{
			Connection con=ConnectionPool.getConnection();
			Statement pwdStmt=con.createStatement();
			query="select password from login where login_id='"+rollNumber+"'";
			ResultSet rs=null;
			rs=pwdStmt.executeQuery(query);
			if(rs.next())
			{
				password=rs.getString("password");
			}
			return password;
		}
		
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			return e.getLocalizedMessage();
		}
	}
	public String getFacultyName(String loginId)
	{
		try
		{
			String name=null;
			Connection con=ConnectionPool.getConnection();
			Statement pwdStmt=con.createStatement();
			String query="select faculty_name from faculty where faculty_id='"+loginId+"'";
			ResultSet rs=null;
			rs=pwdStmt.executeQuery(query);
			if(rs.next())
			{
				name=rs.getString("faculty_name");
			}
			return name;
		}
		
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			return e.getLocalizedMessage();
		}
	}
	public String getStudentName(String loginId)
	{
		try
		{
			String name=null;
			Connection con=ConnectionPool.getConnection();
			Statement pwdStmt=con.createStatement();
			String query="select student_name from student where student_rollno='"+loginId+"'";
			ResultSet rs=null;
			rs=pwdStmt.executeQuery(query);
			if(rs.next())
			{
				name=rs.getString("student_name");
			}
			return name;
		}
		
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			return e.getLocalizedMessage();
		}
	}
}
