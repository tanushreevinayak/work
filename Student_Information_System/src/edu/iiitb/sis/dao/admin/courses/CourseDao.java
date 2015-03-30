package edu.iiitb.sis.dao.admin.courses;
import java.sql.Connection;
import java.sql.PreparedStatement;

import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.CourseModel;
public class CourseDao
{
	public String addCourse(CourseModel course)
	{
		Connection con=ConnectionPool.getConnection();
		PreparedStatement addCourseStatement=null;
		try
		{
			String query="insert into course(course_name,course_syllabus,course_credits,semester_name)values(?,?,?,?)";
			addCourseStatement=con.prepareStatement(query);
			addCourseStatement.setString(1, course.getCourseName());
			addCourseStatement.setString(2, course.getCourseSyllabus());
			addCourseStatement.setString(3, course.getCourseCredits());
			addCourseStatement.setString(4, course.getSemesterName());
			if(addCourseStatement.executeUpdate()>0)
			{
				return "success";
				
			}
			else
			{
				return "failure";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "failure";

		}
		
	}
}
