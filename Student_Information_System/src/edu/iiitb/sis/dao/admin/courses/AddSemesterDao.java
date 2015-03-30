package edu.iiitb.sis.dao.admin.courses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.CourseModel;
import edu.iiitb.sis.model.ViewSemesterCourseModel;

public class AddSemesterDao 
{
	private Connection con=null;
	private Statement courseStatement=null;
	private Statement syllabusStatement=null;
	private ArrayList<String> semesterList=null;
	public ArrayList<String> getSemesterName()
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
			System.out.println(semesterList);
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
//			String semesterCourseQuery="SELECT course.course_name FROM student_info_system.course where course.semester_name = '"+obj.getSemesterName()+"'";
			String semesterCourseQuery="SELECT course_id,course_name,course_credits FROM student_info_system.course where semester_name = '"+obj.getSemesterName()+"'";

			rs=syllabusStatement.executeQuery(semesterCourseQuery);
			ArrayList<String> course_list = new ArrayList<String>();
			ArrayList<String> courseid_list = new ArrayList<String>();
			ArrayList<String> coursecredits_list = new ArrayList<String>();
			System.out.println();
			System.out.println("before while rah");
			while(rs.next())
			{
				System.out.println("after while rah");
				course_list.add(rs.getString("course_name"));
				courseid_list.add(rs.getString("course_id"));
				coursecredits_list.add(rs.getString("course_credits"));
//				System.out.println(course_list);
			}
System.out.println("name"+course_list);
obj.setCoursename(course_list);
System.out.println("modal"+obj.getCoursename());
System.out.println("id"+courseid_list);
obj.setCourseid(courseid_list);
System.out.println("modal"+obj.getCourseid());
System.out.println("credits"+coursecredits_list);
obj.setCoursecredit(coursecredits_list);
System.out.println("modal"+obj.getCoursecredit());
/*			StringBuilder sb = new StringBuilder();			
			for (String s : course_list)
			{
			    sb.append(s);
			    sb.append("");
			}
			obj.setCourse_name(sb);
			System.out.println(obj.getCourse_name());
			return course_list;
*/		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
		}
//		return null;
		return null;
	}
}
