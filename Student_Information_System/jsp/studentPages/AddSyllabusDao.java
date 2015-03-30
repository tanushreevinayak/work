package edu.iiitb.sis.dao.admin.AddSyllabus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.iiitb.sis.dbUtil.ConnectionPool;

public class AddSyllabusDao {

	public List<String> SelectSubjectToAddSyllabus() {

		List<String> courselist=new ArrayList<String>();
		
		Connection con=ConnectionPool.getConnection();
	try {
		
		Statement stmt=con.createStatement();
		String queryToGetCoursename="select * from course";
		
		ResultSet coursenameResutSet=stmt.executeQuery(queryToGetCoursename);
		while(coursenameResutSet.next())
		{
			courselist.add(coursenameResutSet.getString("course_name"));
		}
		
		
	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}
		
		
		return courselist;
		// TODO Auto-generated method stub
		
		
		
		
	}

	public void AddSyllabusForSelectedSubject(String courseSelected, String syllabus) {
		// TODO Auto-generated method stub
		
		System.out.println(courseSelected);
		System.out.println(syllabus);
		try {
			Statement stmt=null;
			Connection con=ConnectionPool.getConnection();
			stmt=con.createStatement();
			String QueryToAddSyllabus="UPDATE course SET course_syllabus='"+syllabus+"' WHERE course_name='"+courseSelected+"'";                      
	     stmt.executeUpdate(QueryToAddSyllabus);
	    
		
		
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}
	
	
	
	

}
