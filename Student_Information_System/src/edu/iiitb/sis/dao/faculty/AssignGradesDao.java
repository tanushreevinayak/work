package edu.iiitb.sis.dao.faculty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.iiitb.sis.dbUtil.ConnectionPool;

public class AssignGradesDao {

	public List<String> assignGradesFunction(String facultyName) {
		
		List<String> courselist=new ArrayList<String>();
		
		Connection con=ConnectionPool.getConnection();
		try
		{
		
			Statement stmt=con.createStatement();
			String queryToGetCoursename="select course_name from course where course_id in (select course_id from faculty_course where faculty_id='"+facultyName+"')";
		
			ResultSet coursenameResutSet=stmt.executeQuery(queryToGetCoursename);
			while(coursenameResutSet.next())
			{
				courselist.add(coursenameResutSet.getString("course_name"));
			}
		
		
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return courselist;
	}

	public List<String> getstudentFunction(String searchKey) {
		// TODO Auto-generated method stub
		List<String> studentlist=new ArrayList<String>();
		Connection con=ConnectionPool.getConnection();
		try {
			Statement stmt=con.createStatement();
			String queryToGetStudents="select student_rollno from student_course where course_id in (select course_id from course where course_name='"+searchKey+"' ) ";
			ResultSet studentListResulSet=stmt.executeQuery(queryToGetStudents);
			while(studentListResulSet.next())
			{
				studentlist.add(studentListResulSet.getString("student_rollno"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
		
		return studentlist;
	}

	public String insertmarkstodatabase(String marks, String coursename, String studentKey) {
		// TODO Auto-generated method stub
		Connection con=ConnectionPool.getConnection();
		try {
		
			Statement stmt=con.createStatement();
			int marksGiven = Integer.parseInt(marks);
			String grade,result;
			System.out.println("in dao");
			System.out.println(coursename);
			System.out.println(studentKey);
			System.out.println(marksGiven);
			String queryToGetCourseId="select course_id from course where course_name='"+coursename+"'";
			ResultSet CourseIdResultSet=stmt.executeQuery(queryToGetCourseId);
			if(CourseIdResultSet.next())
			{
				result="PASS";
				grade="NO GRADE";
			     if(marksGiven>95)    grade="A+";
			     else if(marksGiven>85 && marksGiven<=95)  grade="A";
			     else if(marksGiven>70 && marksGiven<=85)  grade="B";
			     else if(marksGiven>50 && marksGiven<=70)  grade="C";
			     else if(marksGiven>=35 && marksGiven<=50)  grade="D";
			     else if(marksGiven<35) { grade="F"; result="FAIL" ;  }
			     
			     System.out.println("nowwww");
			     System.out.println(CourseIdResultSet.getString("course_id"));
			     PreparedStatement pstmt=null;
					String queryToAddmarks="insert into marks (student_rollno,course_id,subject_marks,result,grade) values(?,?,?,?,?)";
					try 
					{
						pstmt=con.prepareStatement(queryToAddmarks);
						pstmt.setString(1, studentKey);
						pstmt.setString(2, CourseIdResultSet.getString("course_id"));
						pstmt.setString(3, marks);
						pstmt.setString(4, result);
						pstmt.setString(5, grade);
						pstmt.executeUpdate();
						
						
						
					} 
					catch(SQLIntegrityConstraintViolationException e)
					{
						
						System.out.println(e.getMessage());
						return "marks were entered for this student";
					}
					catch (Exception e)
					{
						System.out.println(e.getLocalizedMessage());
						return "failure";
					}
			    
			     System.out.println(grade);
			     System.out.println(result);
			
			
			}
			
			
			
			
		} 
		catch (Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			return "failure";
		}
		
		
		return "success";
		
		
	}

}
