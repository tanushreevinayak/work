package edu.iiitb.sis.dao.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.StudentEdit;

public class StudentEditDao {
	private String editQuery;
	private String pwdQuery;
	private String interestQuery;
	
	public String EditDetails(StudentEdit edit)
	{
		try
		{
			Connection con=ConnectionPool.getConnection();
			Statement editStmt=con.createStatement();
			
			editQuery = "UPDATE student SET student_phoneno = '"+edit.getPhone()+"', student_address ='"+edit.getAddress()+"' WHERE student_rollno='"+edit.getStudentRollNo()+"'";
			editStmt.executeUpdate(editQuery);
			System.out.println(edit.getPhone());
			
			Statement pwdStmt= con.createStatement();
			pwdQuery="UPDATE login SET password='"+edit.getPassword()+"' WHERE login_id='"+edit.getStudentRollNo()+"'";
			pwdStmt.executeUpdate(pwdQuery);
			System.out.println(edit.getPassword());
			
			PreparedStatement interestStmt = null;
			if(!edit.getA().isEmpty())
			{	Statement deleteStmt=con.createStatement();
				deleteStmt.executeUpdate("delete from student_interest where student_rollno='"+edit.getStudentRollNo()+"'");
				for(String str:edit.getA())
				{
					interestQuery="INSERT into student_interest (student_rollno,interest_name) VALUES (?,?)"; 
					interestStmt=con.prepareStatement(interestQuery);
					interestStmt.setString(1,edit.getStudentRollNo());
					interestStmt.setString(2,str);
					interestStmt.executeUpdate();
				}
			}
		}

		 catch (Exception e) 
		 {
			e.printStackTrace();
		
		}
		return "success";
	}

}
