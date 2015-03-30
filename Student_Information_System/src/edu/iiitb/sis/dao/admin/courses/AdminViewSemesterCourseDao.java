package edu.iiitb.sis.dao.admin.courses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.CourseModel;
import edu.iiitb.sis.model.ViewSemesterCourseModel;

public class AdminViewSemesterCourseDao 
{
	private Connection con=null;
	private Statement courseStatement=null;
	private Statement syllabusStatement=null;
	private ArrayList<String> semesterList=null;
	public ArrayList<String> getCourses()
	{
		try
		{
			con=ConnectionPool.getConnection();
			courseStatement=con.createStatement();
			String query="SELECT Distinct semester_name FROM student_info_system.semester";
			ResultSet rs=null;
			semesterList=new ArrayList<String>();
			rs=courseStatement.executeQuery(query);
			while(rs.next())
			{
				semesterList.add(rs.getString("semester_name"));
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
		}
		return semesterList;
	}
	public List<String> getSemesterCourses(ViewSemesterCourseModel obj)
	{
		System.out.println(obj.getSemesterName());
		try
		{
			con=ConnectionPool.getConnection();
			syllabusStatement=con.createStatement();
			ResultSet rs=null;
			String semesterCourseQuery="SELECT course.course_name FROM student_info_system.course where course.semester_name = '"+obj.getSemesterName()+"'";

			rs=syllabusStatement.executeQuery(semesterCourseQuery);
			ArrayList<String> course_list = new ArrayList<String>();
			System.out.println();

			while(rs.next())
			{
				System.out.println("rah");
				course_list.add(rs.getString("course_name"));
				System.out.println(course_list);
			}
System.out.println(course_list);
			StringBuilder sb = new StringBuilder();			
			for (String s : course_list)
			{
			    sb.append(s);
			    sb.append("");
			}
			//obj.setCourse_name(sb);
			//System.out.println(obj.getCourse_name());
			return course_list;
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
		}
		return null;
	}
}
