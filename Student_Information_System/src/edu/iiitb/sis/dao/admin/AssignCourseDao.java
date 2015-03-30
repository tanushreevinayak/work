package edu.iiitb.sis.dao.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;



import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.Admin_Assign_Course2F;
//import edu.iiitb.sis.model.Login;

public class AssignCourseDao {
	
	private String faculty_Id;
	
	public String Retrieve_facultyname_coursename_function(Admin_Assign_Course2F Assign)
	{
		
		List<String> courseList = new ArrayList<String>();
		List<String> facultylist=new ArrayList<String>();
		try
		{

			Connection con = ConnectionPool.getConnection();
			Statement Stmt = con.createStatement();
			String QueryForCourse = "select course_name from course";
			ResultSet rs = Stmt.executeQuery(QueryForCourse);
			while (rs.next())
				courseList.add(rs.getString("course_name"));

			Statement Stmt2 = con.createStatement();
			String QueryForFaculty = "select faculty_name from faculty";
			ResultSet rs1 = Stmt2.executeQuery(QueryForFaculty);
			while (rs1.next())
				facultylist.add(rs1.getString("faculty_name"));

			Assign.setCourselist(courseList);
			Assign.setFacultylist(facultylist);

		}

		catch (Exception e)
		{
			e.printStackTrace();
		}

		return "success";

	}

	public String assignCourses_mainFunction(String facultyname,String course_names)
	{
		List<String> CourseId = new ArrayList<String>();
            
		System.out.println(course_names);
		String Splitted[] = course_names.split(", ");
		
		Connection con = ConnectionPool.getConnection();
		Statement stmt1 = null, stmt2 = null;
		try 
		{

			System.out.println(Splitted.length);
			for (int i = 0; i < Splitted.length; i++)
			{
				String QueryToGetCourseId = "select course_id from course where course_name='"+ Splitted[i] + "'";
				stmt1 = con.createStatement();
			    ResultSet courseIdResultSet = stmt1.executeQuery(QueryToGetCourseId);
				if (courseIdResultSet.next())
					CourseId.add(courseIdResultSet.getString("course_id"));
			}

		}
		catch (Exception e)
		{
		
			e.printStackTrace();
		}

		try 
		{

			String QueryToGetFacultyId = "select faculty_id from faculty where faculty_name='"+ facultyname + "'";
			stmt2 = con.createStatement();
			ResultSet FacultyIDResultSet = stmt2.executeQuery(QueryToGetFacultyId);
			if (FacultyIDResultSet.next()) 
			{
				faculty_Id=FacultyIDResultSet.getString("faculty_id");
			}
		
		} 
		catch (Exception e)
		{
		
			e.printStackTrace();
		}
		
		try 
		{
			
           for(int j=0;j<CourseId.size();j++)
           {
               String QueryToInsertCourses="insert into faculty_course (faculty_id,course_id) values(?,?)";
               PreparedStatement pstmt=con.prepareStatement(QueryToInsertCourses);
              
               pstmt.setString(1, faculty_Id);
               pstmt.setString(2,CourseId.get(j) );
               pstmt.executeUpdate();
           }         				
	    			
		}
		catch (Exception e)
		{
		
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		
		}
		return "success";
		
		
		

	}

	public String getFaculty_Id() 
	{
		return faculty_Id;
	}

	public void setFaculty_Id(String faculty_Id) 
	{
		this.faculty_Id = faculty_Id;
	}

}