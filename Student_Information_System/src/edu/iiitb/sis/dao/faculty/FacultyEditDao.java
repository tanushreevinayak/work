package edu.iiitb.sis.dao.faculty;

import java.sql.Connection;
import java.sql.Statement;

import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.FacultyEdit;


public class FacultyEditDao {
	private String editfacultyQuery;
	public String EditDetails(FacultyEdit faculty)
	{
		try
		{
			Connection con=ConnectionPool.getConnection();
			Statement faculty_editStmt=con.createStatement();
			editfacultyQuery = "UPDATE faculty SET faculty_phoneno = '"+faculty.getPhone()+"', faculty_qualification ='"+faculty.getQualification()+"' WHERE faculty_id='"+faculty.getFacultyId()+"'";
			System.out.println(faculty_editStmt.executeUpdate(editfacultyQuery));
			System.out.println(faculty.getPhone());
		}
		catch (Exception e) 
		 {
			e.printStackTrace();
		
		}
		return "success";
	}
}

