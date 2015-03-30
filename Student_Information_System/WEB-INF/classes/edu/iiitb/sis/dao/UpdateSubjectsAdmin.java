package edu.iiitb.sis.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.Course;

public class UpdateSubjectsAdmin {
		private String Query,FQuery;
		int i=0;
		private String value;
		//value=request.getParameter("first");
		
		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		
		public Course UpdateSubjects(Course course)
		{
			try
			{
				Connection con=ConnectionPool.getConnection();
				java.sql.PreparedStatement prestmt;
				//System.out.println("value is"+value);
				//	if(course.getFlag().equals("option"))
				//System.out.println(course.getCourse_name());
				FQuery="select * from course where course_name=?";
				prestmt=con.prepareStatement(FQuery);
				prestmt.setString(1, course.getCourse_name());
				ResultSet rs=prestmt.executeQuery();
				
				//System.out.println(course.getCourse_name());
				if(rs.next())
				{	
				 course.setCourse_id(rs.getString("course_id"));
				 course.setCourse_name(rs.getString("course_name"));
				 course.setCourse_syllabus(rs.getString("course_syllabus"));	
				 course.setCourse_credits(rs.getString("course_credits"));
				// System.out.println(course.getCourse_id()+course.getCourse_syllabus()+course.getCourse_credits());
				}
				return course;	
				
			}
				 catch (SQLException e) 
				 {
					 e.printStackTrace();
						System.out.println(e.getMessage());
						course=null;
						return course;
						// TODO Auto-generated catch block
						
					}
						}
			
			
			
			public String UpdateOption(Course course)
			{
				try{
				Connection con=ConnectionPool.getConnection();
				java.sql.PreparedStatement prestmt;
			
			
	Query="Update course set course_id=?,course_syllabus=?,course_credits=? where course_name='"+course.getCourse_name()+"'";
					
						prestmt=con.prepareStatement(Query);
						prestmt.setString(1,course.getCourse_id() );
						
						//prestmt.setString(2,course.getCourse_name() );
						prestmt.setString(2,course.getCourse_syllabus() );
						prestmt.setString(3,course.getCourse_credits() );
						 i=prestmt.executeUpdate();
							
					} catch (SQLException e) {
						System.out.println(e.getMessage());
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
			if(i>0)
				 return "success";
				 else
					 return "failure";

			
		}

		}
		
		

