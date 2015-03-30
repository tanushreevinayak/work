package edu.iiitb.sis.model;

import java.sql.Connection;

import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.CourseModel;

public class RemoveSubjectsAdmin {
	
	private String loginQuery;
	int i=0;
	
	/*
	 * The Following method checks login details and returns the authentication type
	else it will return the message whether user exists or not 
	
	*/
	
	public String RemoveSubjects(CourseModel course)
	{
		
		try
		{
			Connection con=ConnectionPool.getConnection();
			loginQuery="delete from  course where course_name=?";
			
			 java.sql.PreparedStatement preStmt;
			 preStmt = con.prepareStatement(loginQuery);
			 preStmt.setString(1, course.getCourseName());
			 i=preStmt.executeUpdate();
 		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		if(i>0)
			 return "success";
		 else
			 return "failure";

	}

}
