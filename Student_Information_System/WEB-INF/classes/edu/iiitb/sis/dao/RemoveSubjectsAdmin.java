package edu.iiitb.sis.dao;

import java.sql.Connection;
import java.sql.Statement;

import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.Course;

public class RemoveSubjectsAdmin {
	
	private String loginQuery;
	int i=0;
	
	/*
	 * The Following method checks login details and returns the authentication type
	else it will return the message whether user exists or not 
	
	*/
	
	public String RemoveSubjects(Course course)
	{
		
		try
		{
			Connection con=ConnectionPool.getConnection();
			//Statement loginStmt=con.createStatement();
			
			
			//Query To Remove Information based on given Subject name
			
loginQuery="delete from  course where course_name=?";
			
			 java.sql.PreparedStatement preStmt;
			 //System.out.println("Name" +StudentName);
			 preStmt = con.prepareStatement(loginQuery);
				
			 preStmt.setString(1, course.getCourse_name());
			 i=preStmt.executeUpdate();
			 		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			//message="failure";
			//return message;
		}
		if(i>0)
			 return "success";
			 else
				 return "failure";

		}

	
	
}
