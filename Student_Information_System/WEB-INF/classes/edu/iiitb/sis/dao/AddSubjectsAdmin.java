package edu.iiitb.sis.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.Course;
import edu.iiitb.sis.model.Login;

public class AddSubjectsAdmin
{
	private String loginQuery;
	private String message;
	
	/*
	 * The Following method checks login details and returns the authentication type
	else it will return the message whether user exists or not 
	
	*/
	
	public String AddSubjects(Course course)
	{
		
		try
		{
				
			Connection con=ConnectionPool.getConnection();
			Statement loginStmt=con.createStatement();
			
			//Query To Retrieve Login Information based on given user name
			
loginQuery="insert into course (course_id,course_name,course_syllabus,course_credits)values (?,?,?,?)";
			
			 java.sql.PreparedStatement preStmt;
			 //System.out.println("Name" +StudentName);
			 preStmt = con.prepareStatement(loginQuery);
			 preStmt.setString(1, course.getCourse_id());	
			 preStmt.setString(2, course.getCourse_name());
			 preStmt.setString(3, course.getCourse_syllabus());
			 preStmt.setString(4, course.getCourse_credits());
			// preStmt.setInt(5, getMarks());
			 //preStmt.setBinaryStream(6,fin,image.length());
			 preStmt.executeUpdate();
			 return "success";
		}
			catch(Exception e)
		{
			System.out.println(e.getMessage());
			message="failure";
			return message;
		}
		
	
	
	}
}
