package edu.iiitb.sis.dao.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.CourseModel;

public class ViewCoursesDao 
{
	private Connection con=null;
	private Statement courseStatement=null;
	private Statement syllabusStatement=null;
	private ArrayList<String> courseList=null;
	public ArrayList<String> getCourses()
	{
		try
		{
			con=ConnectionPool.getConnection();
			courseStatement=con.createStatement();
			String query="select course_name from course";
			ResultSet rs=null;
			courseList=new ArrayList<String>();
			rs=courseStatement.executeQuery(query);
			while(rs.next())
			{
				courseList.add(rs.getString("course_name"));
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
		}
		return courseList;
	}
	public CourseModel getSyllabus(CourseModel course)
	{
		
		try
		{
			con=ConnectionPool.getConnection();
			syllabusStatement=con.createStatement();
			ResultSet rs=null;
			String syllabusQuery="select * from course where course_name='"+course.getCourseName()+"'";
			rs=syllabusStatement.executeQuery(syllabusQuery);
			if(rs.next())
			{
				course.setCourseId(rs.getString("course_id"));
				course.setCourseCredits(rs.getString("course_credits"));
				course.setCourseSyllabus(rs.getString("course_syllabus"));
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
		}
		return course;
	}
}
