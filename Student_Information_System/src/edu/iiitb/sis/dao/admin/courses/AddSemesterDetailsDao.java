package edu.iiitb.sis.dao.admin.courses;



import java.sql.Connection;
import java.sql.PreparedStatement;

import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.AddSemesterDetailsModel;
import edu.iiitb.sis.model.CourseModel;

public class AddSemesterDetailsDao {

	public String addsemester(AddSemesterDetailsModel course)
	{
		Connection con=ConnectionPool.getConnection();
		PreparedStatement addCourseStatement=null;
		try
		{
			String query="insert into semester(semester_id,semester_name,course_id)values(?,?,?)";
			addCourseStatement=con.prepareStatement(query);
			addCourseStatement.setString(1, course.getSemesterId());
			addCourseStatement.setString(2, course.getSemesterName());
			addCourseStatement.setString(3, course.getCourseId());
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
