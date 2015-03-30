package edu.iiitb.sis.dao.student.enrollment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.Course;
import edu.iiitb.sis.model.Enroll;

public class Enrollmentdao 
{
	private String FQuery;
	int i=0;
	ArrayList<String> subjects=new ArrayList<String>();
	public ArrayList<String> enrollSubjects(Course course)
	{
		try
		{
			Connection con=ConnectionPool.getConnection();
			java.sql.PreparedStatement prestmt;
			FQuery="select course_name from course";
			prestmt=con.prepareStatement(FQuery);
			ResultSet rs=prestmt.executeQuery();
			
			while(rs.next())
			{	
				String item=rs.getString("course_name");
				subjects.add(item);
			}
			return subjects;	
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			course=null;
			return subjects;
				
		}
	}
		
	
	public String enrolledSubjects(Enroll en,Course cs,String rollNumber)
	{
		try
		{
			Connection con=ConnectionPool.getConnection();
			java.sql.PreparedStatement prestmt=null;
			
			
			for(String s:en.getSubjects())
			{
				
				FQuery="insert into student_course(course_id,student_rollno) values(?,?)" ;
				prestmt=con.prepareStatement(FQuery);
				Statement stmt=con.createStatement();
				System.out.println(s);
				String queryToGetCourseId="select course_id from course where course_name='"+s+"'";
				ResultSet courseIdResultset=stmt.executeQuery(queryToGetCourseId);
				if(courseIdResultset.next())
				{
				 prestmt.setString(1, courseIdResultset.getString("course_id"));
				 prestmt.setString(2, rollNumber);
				 prestmt.executeUpdate();
				}
			}
			return "success";
		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
			return "failure";
					
		}
		
	}

		
		
					}
		
		
		
	
		
	
	
	


