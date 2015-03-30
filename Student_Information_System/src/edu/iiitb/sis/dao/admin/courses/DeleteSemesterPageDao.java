package edu.iiitb.sis.dao.admin.courses;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.CourseModel;
import edu.iiitb.sis.model.DeleteSemesterCourseModel;
import edu.iiitb.sis.model.ViewSemesterCourseModel;

public class DeleteSemesterPageDao {

	private Connection con=null;
	private Statement courseStatement=null;
	private Statement syllabusStatement=null;
	private ArrayList<String> semesterList=null;
	
	public ArrayList<String> getSemesterId()
	{
		try
		{
			con=ConnectionPool.getConnection();
			courseStatement=con.createStatement();
			String query="SELECT semester_id FROM student_info_system.semester";
			ResultSet rs=null;
			semesterList=new ArrayList<String>();
			rs=courseStatement.executeQuery(query);
			while(rs.next())
			{
				semesterList.add(rs.getString("semester_id"));
			}
			System.out.println(semesterList);
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
		}
		return semesterList;
	}
	public String DeleteSemesterCourses(DeleteSemesterCourseModel obj)
	{
		System.out.println(obj.getSemesterId());
		try
		{
			con=ConnectionPool.getConnection();
			
			PreparedStatement deletesemestercourseStmt=null;
//			String semesterCourseQuery="SELECT course.course_name FROM student_info_system.course where course.semester_name = '"+obj.getSemesterName()+"'";
//			String semesterCourseQuery="delete FROM student_info_system.semester where semester_id='"+obj.getSemesterId()+"'";

			String query="delete FROM student_info_system.semester where semester_id=?";
			
			deletesemestercourseStmt=con.prepareStatement(query);
			deletesemestercourseStmt.setString(1, obj.getSemesterId());
			
			if(deletesemestercourseStmt.executeUpdate()>0)
			{
				return "success";
			}
			else
			{
				return "failure";
			}
			
/**			ArrayList<String> course_list = new ArrayList<String>();
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
**/		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
		}
//		return null;
		return "failure";
	}
}
