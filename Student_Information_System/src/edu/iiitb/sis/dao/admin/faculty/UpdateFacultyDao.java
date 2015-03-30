package edu.iiitb.sis.dao.admin.faculty;

import java.sql.Connection;



import java.sql.PreparedStatement;

import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.Faculty;

public class UpdateFacultyDao {
	private String message;
	
	
	
	public String updateFaculty(Faculty facultyModelObj) {
		// TODO Auto-generated method stub
	Connection con=ConnectionPool.getConnection();
	
	try 
	{
		
		String queryToUpdateFaculty="update faculty set faculty_mailid=?,faculty_qualification=?,faculty_phoneno=? where faculty_id='"+facultyModelObj.getFacultyUserName()+"'";
		PreparedStatement  pstmt=con.prepareStatement(queryToUpdateFaculty);
		pstmt.setString(1, facultyModelObj.getEmail());
		pstmt.setString(2, facultyModelObj.getQualifications());
		pstmt.setString(3, facultyModelObj.getPhoneNumber());
		
		
		String queryToUpdateLoginStatus="update login set login_status=? where login_id='"+facultyModelObj.getFacultyUserName()+"'";
		PreparedStatement pstmt2=con.prepareStatement(queryToUpdateLoginStatus);
		pstmt2.setString(1, facultyModelObj.getStatus());
		System.out.println(pstmt.executeUpdate());
		pstmt2.executeUpdate();
		message="success";	
			
	}
	catch (Exception e)
	{
		e.printStackTrace();
		// TODO: handle exception
		message="failure";
	}
		return message;
		
		
		
	}

}
