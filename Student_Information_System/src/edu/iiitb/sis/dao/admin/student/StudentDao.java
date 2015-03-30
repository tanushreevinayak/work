package edu.iiitb.sis.dao.admin.student;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;








import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.Student;

public class StudentDao 
{
	private String message;
	
	/*@Author : Mahesh Samudrala
	 * 
	 * The following function takes Student data and inserts into Student Table
	 * 
	 * */
	public String addStudent(Student studentObj)
	{
		Connection con=ConnectionPool.getConnection();
		PreparedStatement preStmt=null;
		String imageLocation=null;
		String query="insert into student(student_name,student_rollno,student_phoneno,student_mail,student_address,student_dob,student_image) values(?,?,?,?,?,?,?)";
		System.out.println("In add Student");
		try
		{
				preStmt=con.prepareStatement(query);
				preStmt.setString(1, studentObj.getStudentName());
				 preStmt.setString(2, studentObj.getStudentRollNo());
				 preStmt.setString(3, studentObj.getPhoneNumber());
				 preStmt.setString(4, studentObj.getEmail());
				 preStmt.setString(5, studentObj.getAddress());
				 Date dobDate = null;
			     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			      try 
			      {
			    	 // dobDate=(Date) formatter.parse(studentObj.getDateOfBirth());
			        dobDate = new Date(formatter.parse(studentObj.getDateOfBirth()).getTime());
			      } 
			      catch (ParseException e) 
			      {
			        e.printStackTrace();
			      }
			      
				 preStmt.setDate(6,  dobDate);
				 
				 File destFile = new File(studentObj.getImagePath(),studentObj.getImageFileName());
				 FileUtils.copyFile(studentObj.getImage(), destFile);
				  FileInputStream inputStream = new FileInputStream(destFile);
				  

				  System.out.println(imageLocation);
				 preStmt.setBlob(7, inputStream);
				 preStmt.executeUpdate();
				
				 if(addStudentToLogin(studentObj.getStudentRollNo(), con)>0)
				 {
					message="success";
				 }
				 else
				 { 
					 message="User Already Exists";
					 System.out.println("Failed to insert into Login");
				 }
		}
		catch(SQLIntegrityConstraintViolationException e)
		{
			
			System.out.println(e.getMessage());
			message="User already Exists With Given Roll Number";
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			return "failure";
		}
		
		return message;
	}
	
	
	
	/*	@Author : Mahesh
	 * The Following function will take the student Roll Number and inserts student data into Login table
	 * with default password.
	 * 
	 * */
	public int addStudentToLogin(String rollNumber,Connection con)
	{
		int result;
		String defaultPassword="password";
		PreparedStatement insertIntoLogin=null;
		String insertQuery=null;
		insertQuery="insert into login(login_id,password,user_type,login_status) values(?,?,?,?)";
		System.out.println("Adding to Login");
		try
		{
			insertIntoLogin=con.prepareStatement(insertQuery);
			insertIntoLogin.setString(1, rollNumber);
			insertIntoLogin.setString(2, defaultPassword);
			insertIntoLogin.setString(3, "S");
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
	
	/*@Author  : Mahesh Samudrala
	 * 
	 * The following function takes the search key as parameter and returns 
	 *  
	 * a list of students matching with search key.
	 * */
	public List<String> getStudentRollNumbers()
	{
		String searchQuery;
		Connection con=null;
		Statement searchStatement=null;
		ResultSet rs=null;
		List<String> listOfUsers=new ArrayList<String>();
		try
		{
			con=ConnectionPool.getConnection();
			searchStatement=con.createStatement();
			searchQuery="select student_rollno from student ";
			rs=searchStatement.executeQuery(searchQuery);
			while(rs.next())
			{
				listOfUsers.add(rs.getString("student_rollno"));
			}
			
			rs.close();
			searchStatement.close();
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
		}
		
		return listOfUsers;
	}
	
	public Student getStudentDetails(String rollNo)
	{
		Student studentObj=null;
		Connection con=null;
		Statement getStudentDataStatement=null;
		Statement getStatusStatement=null;
		ResultSet rs=null;
		String query;
		try
		{
			con=ConnectionPool.getConnection();
			getStudentDataStatement=con.createStatement();
			System.out.println("Roll No :"+rollNo);
			query="select student_name,student_phoneno,student_mail,student_address,student_dob from student where student_rollno='"+rollNo+"'";
			rs=getStudentDataStatement.executeQuery(query);
			studentObj=new Student();
			if(rs.next())
			{
				System.out.println("In Result set");
				studentObj.setStudentName(rs.getString("student_name"));
				studentObj.setStudentRollNo(rollNo);
				studentObj.setPhoneNumber(rs.getString("student_phoneno"));
				studentObj.setEmail(rs.getString("student_mail"));
				studentObj.setAddress(rs.getString("student_address"));
				studentObj.setDateOfBirth(rs.getDate("student_dob").toString());
						
			}
			rs.close();
			getStatusStatement=con.createStatement();
			query="select login_status from login where login_id='"+rollNo+"'";
			rs=getStatusStatement.executeQuery(query);
			if(rs.next())
			{
				studentObj.setStatus(rs.getString("login_status"));
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
			System.out.println("Something went wrong");
		}
		
		return studentObj;
	}
	public String updateStudent(Student studentObj)
	{
		Connection con=null;
		PreparedStatement updateStudentStatement=null;
		PreparedStatement updateLogin=null;
		String query;
		try
		{
			con=ConnectionPool.getConnection();
			query="update student set student_mail=?,student_phoneno=?,student_address=?,student_dob=? where student_rollno='"+studentObj.getStudentRollNo()+"'";
			updateStudentStatement=con.prepareStatement(query);
			updateStudentStatement.setString(1, studentObj.getEmail());
			updateStudentStatement.setString(2, studentObj.getPhoneNumber());
			updateStudentStatement.setString(3, studentObj.getAddress());
			Date dobDate = null;
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		    try 
		    {
		        dobDate = new Date(formatter.parse(studentObj.getDateOfBirth()).getTime());
		    } 
		    catch (ParseException e) 
		    {
		        e.printStackTrace();
		    }
		    updateStudentStatement.setDate(4, dobDate);
			updateStudentStatement.executeUpdate();
			System.out.println(studentObj.getStatus());
			updateLogin=con.prepareStatement("update login set login_status='"+studentObj.getStatus()+"' where login_id='"+studentObj.getStudentRollNo()+"'");
			updateLogin.executeUpdate();
			
			con.close();
		    message="success";

		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			message="failure";
		}
		return message;
		
	}
}
