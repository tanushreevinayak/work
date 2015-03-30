package edu.iiitb.sis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;

import antlr.collections.List;
import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.Course;
import edu.iiitb.sis.model.Enroll;

public class Enrollmentdao {
	private String FQuery;
	int i=0;
	ArrayList<String>subjects=new ArrayList<String>();
	//JComboBox subjects = new JComboBox();
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
					// TODO Auto-generated catch block
					
				}
					}
		
	
	public ArrayList<String> enrolledSubjects(Enroll en,Course cs)
	{
		try
		{
			// ArrayList<String>Subjects =new ArrayList<String>();
			Connection con=ConnectionPool.getConnection();
			java.sql.PreparedStatement prestmt=null;
			//System.out.println("value is"+value);
			//	if(course.getFlag().equals("option"))
			//System.out.println(course.getCourse_name());
			
			Statement st=con.createStatement();
			//FQuery="insert into student_course(student_course_id,course_id,student_rollno) values(?,?,?)  where student_rollno=124";
			//prestmt.setString(1, course.getCourse_name());
			
		//	ResultSet rs=prestmt.executeQuery();
			// prestmt.setString(1, en.getStudent_course_id());
			 //prestmt.setString(2, en.getCourse_id());
			 //prestmt.setString(3, en.getStudent_rollno());
		/*	 while(rs.next())
			 {
				 String sub=rs.getString("FQuery");
				 subjects.add(sub);
				 System.out.println("subjects is"+sub);
			 }*/
			
			for(String s:en.getSubjects())
			{
				System.out.println(s);
				
				FQuery="insert into student_course(course_id,student_rollno) values(?,?)" ;
				prestmt=con.prepareStatement(FQuery);
				Statement stmt=con.createStatement();
				String queryToGetCourseId="select course_id from course where course_name='"+s+"'";
				ResultSet courseIdResultset=stmt.executeQuery(queryToGetCourseId);
				if(courseIdResultset.next())
				{
				 prestmt.setString(1, courseIdResultset.getString("course_id"));
				 prestmt.setString(2, "135");
				 prestmt.executeUpdate();
				}
			}
			
			
			
			 
	//		 i=prestmt.executeUpdate();
			 		
			
			
			
			//System.out.println(course.getCourse_name());
		}
			 catch (SQLException e) 
			 {
				 e.printStackTrace();
					System.out.println(e.getMessage());
					//course=null;
				
					// TODO Auto-generated catch block
					
				}
		return subjects;
		
			}

		
		
					}
		
		
		
	
		
	
	
	


