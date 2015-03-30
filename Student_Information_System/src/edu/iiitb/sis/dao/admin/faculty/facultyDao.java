package edu.iiitb.sis.dao.admin.faculty;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.Faculty;

public class facultyDao {

	private String message;
	public String addFaculty(Faculty facultyModelObj) {
		// TODO Auto-generated method stub
		
		Connection con=ConnectionPool.getConnection();
		PreparedStatement pstmt=null;
		String queryToAddFaculty="insert into faculty (faculty_name,faculty_qualification,faculty_phoneno,faculty_mailid,faculty_id) values(?,?,?,?,?)";
		try 
		{
			
			
			
			pstmt=con.prepareStatement(queryToAddFaculty);
			pstmt.setString(1, facultyModelObj.getFacultyName());
			pstmt.setString(2, facultyModelObj.getQualifications());
			pstmt.setString(3, facultyModelObj.getPhoneNumber());
			pstmt.setString(4, facultyModelObj.getEmail());
			pstmt.setString(5, facultyModelObj.getFacultyUserName());
			int result=pstmt.executeUpdate();
			
			
			 if(addFacultyToLogin(facultyModelObj.getFacultyUserName(), con)>0)
			 {
				message="success";
			 }
			 else
			 { 
				 message="User Already Exists";
				 System.out.println("Failed to insert into Login");
			 }
			
			
			
			if(result>0)
				message="success";
			else	
			message= "failure";
			
			
		}
		catch(SQLIntegrityConstraintViolationException e)
		{
			
			System.out.println(e.getMessage());
			message="User already Exists With Given UserName";
		}
		catch (Exception e)
		{
			
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
	
		}
		return message;
	}
	public int addFacultyToLogin(String facultyUserName, Connection con) {
		// TODO Auto-generated method stub
		
		int result;
		String defaultPassword="password";
		PreparedStatement insertIntoLogin=null;
		String insertQuery=null;
		insertQuery="insert into login(login_id,password,user_type,login_status) values(?,?,?,?)";
		System.out.println("Adding to Login");
		try
		{
			insertIntoLogin=con.prepareStatement(insertQuery);
			insertIntoLogin.setString(1, facultyUserName);
			insertIntoLogin.setString(2, defaultPassword);
			insertIntoLogin.setString(3, "F");
			insertIntoLogin.setString(4, "Active");
			result=insertIntoLogin.executeUpdate();
			System.out.println(result);
		}
		catch(Exception e)
		{
			result=0;
		}
		return result;
		
		
		
	}

	
	
	
	
}
