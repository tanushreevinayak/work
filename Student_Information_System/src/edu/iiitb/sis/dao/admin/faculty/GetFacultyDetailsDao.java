package edu.iiitb.sis.dao.admin.faculty;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.Faculty;

public class GetFacultyDetailsDao {

	
	private String message;
	
	
	public String getFacutyDetails(Faculty facultyModelObj, String searchedFaculty) {
		// TODO Auto-generated method stub
		Connection con=ConnectionPool.getConnection();
		Statement stmt=null;
		try {
			
			stmt=con.createStatement();
			String queryToGetFacultyDetails="select * from faculty where faculty_name='"+searchedFaculty+"'";
			ResultSet facultyDeatailsresultSet=stmt.executeQuery(queryToGetFacultyDetails);
			if(facultyDeatailsresultSet.next())
			{

				facultyModelObj.setEmail(facultyDeatailsresultSet.getString("faculty_mailid"));
				facultyModelObj.setPhoneNumber(facultyDeatailsresultSet.getString("faculty_phoneno"));
				facultyModelObj.setQualifications(facultyDeatailsresultSet.getString("faculty_qualification"));
				facultyModelObj.setFacultyName(facultyDeatailsresultSet.getString("faculty_name"));
				
				String queryToGetFacultyUserName="select faculty_id from faculty where faculty_name='"+searchedFaculty+"'";
				Statement stmt2=con.createStatement();
				ResultSet rs1=stmt2.executeQuery(queryToGetFacultyUserName);
				if(rs1.next())
				{
					facultyModelObj.setFacultyUserName(rs1.getString("faculty_id"));
					String query="select login_status from login where login_id='"+facultyModelObj.getFacultyUserName()+"'";
					Statement stmt3=con.createStatement();
					ResultSet rs2=stmt3.executeQuery(query);
					if(rs2.next())
					{
						facultyModelObj.setStatus(rs2.getString("login_status"));
						System.out.println(facultyModelObj.getStatus());
					}
				}
				
				message="success";			
			}
			else 
				message="failure";
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		message="failure";
		}
		
		
		return message;
	}



	
	
	
	

}
