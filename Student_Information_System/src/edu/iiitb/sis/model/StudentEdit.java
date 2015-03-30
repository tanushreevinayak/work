package edu.iiitb.sis.model;

import java.util.List;

public class StudentEdit 
{
	private String studentRollNo;
	
	private String phone;
	private String password;
	private String address;
	private List<String> a;
	
	public String getStudentRollNo()
	{
		return studentRollNo;
	}
	public void setStudentRollNo(String studentRollNo) 
	{
		this.studentRollNo = studentRollNo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<String> getA() {
		return a;
	}
	public void setA(List<String> a) {
		this.a = a;
	}
	
	

}
