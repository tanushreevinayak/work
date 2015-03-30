package edu.iiitb.sis.dao.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.Student_Search_Model;



public class Student_Search_Dao {
	
	public boolean search(Student_Search_Model obj)
	{
		System.out.println(obj.getStudent_rollno());

		try
		{
			Connection con=ConnectionPool.getConnection();
			Statement statement = con.createStatement();
			System.out.println(obj.getStudent_rollno());
		ResultSet rs;
		rs = statement.executeQuery("select * from student where student_rollno='"+obj.getStudent_rollno()+"'");
		if(rs.next())
		{
			obj.setStudent_image(rs.getString("student_image"));
			
			obj.setStudent_name(rs.getString("student_name"));
			obj.setStudent_rollno(rs.getString("student_rollno"));
			System.out.println(obj.getStudent_rollno());
			obj.setStudent_phoneno(rs.getString("student_phoneno"));
			obj.setStudent_mailid(rs.getString("student_mail"));
			obj.setStudent_address(rs.getString("student_address"));
			
			Date ra = rs.getDate("student_dob");
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String date = sdf.format(ra);
			obj.setStudent_dob(date);
			rs.close();
			statement.close();
			con.close();

		}
		else
		{
			System.out.println("No Data Found");
		}
		
	}
	catch (SQLException e)
	{
		e.printStackTrace();
	}

	try
	{
			Connection con=ConnectionPool.getConnection();
			Statement statement = con.createStatement();

			ResultSet rs1;
		
		rs1 = statement.executeQuery("SELECT distinct(interest_name) FROM student_interest WHERE student_rollno='"+obj.getStudent_rollno()+"'");
		
			ArrayList<String> interest_list = new ArrayList<String>();
			while(rs1.next())
			{
				
				interest_list.add(rs1.getString("interest_name"));
			}
			
			
			StringBuilder sb = new StringBuilder();			
			for (String s : interest_list)
			{
			    sb.append(s);
			    sb.append(", ");
			}			
			
			obj.setStudent_interest(sb);
			System.out.println(obj.getStudent_interest());			
			
			rs1.close();
			statement.close();
			con.close();
		} 
		catch (SQLException e) 
		{
			System.out.println("No Interest Data Found");
			e.printStackTrace();
		}

		
		try 
		{
			Connection con=ConnectionPool.getConnection();
			Statement statement = con.createStatement();


			ResultSet rs2;

			rs2 = statement.executeQuery("SELECT course.course_name FROM course WHERE course.course_id IN (SELECT course_id FROM student_course WHERE student_rollno='"+obj.getStudent_rollno()+"')");
			ArrayList<String> course_list = new ArrayList<String>();
			while(rs2.next())
			{
				course_list.add(rs2.getString("course_name"));
			}
			
			
			StringBuilder sb = new StringBuilder();			
			for (String s : course_list)
			{
			    sb.append(s);
			    sb.append(", ");
			}			
			
			obj.setStudent_course(sb);
			System.out.println(obj.getStudent_course());			
			rs2.close();
			statement.close();
			con.close();
			return true;	
	}
	catch (SQLException e) 
	{
		System.out.println("No Course Data Found");
		e.printStackTrace();
	}

	return false;
}



}
