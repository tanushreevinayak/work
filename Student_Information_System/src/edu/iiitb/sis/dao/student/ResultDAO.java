package edu.iiitb.sis.dao.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.Result_Model;

public class ResultDAO {        
	
	
	
	public boolean check(Result_Model obj,String rollNo)
	{
		ResultSet rs;

		try {
			Connection con = ConnectionPool.getConnection();
			Statement statement;
			statement = con.createStatement();
			rs = statement.executeQuery("select * from marks join course on marks.course_id=course.course_id and  marks.student_rollno='"+rollNo+"'");
			
			ArrayList<String> course =new ArrayList<String>();
			ArrayList<String> mark =new ArrayList<String>();
			ArrayList<String> results =new ArrayList<String>();
			ArrayList<String> rollnos =new ArrayList<String>();
			ArrayList<String> grades =new ArrayList<String>();
			
			while(rs.next())
			{
				System.out.println("Round ");
				course.add(rs.getString("course_name"));
				mark.add(rs.getString("subject_marks"));
				results.add(rs.getString("result"));
				rollnos.add(rs.getString("student_rollno"));
				grades.add(rs.getString("grade"));
			}
			obj.setCourse(course);
			obj.setGrades(grades);
			obj.setMark(mark);
			obj.setResults(results);
			obj.setRollnos(rollnos);
			
			for(String c:course)
			{
				System.out.println(c);
			}
			rs.close();
			statement.close();
			con.close();}
		 catch (SQLException e)
		 {
			e.printStackTrace();
		 }
		
	
	
		return true;
	}
}	

