package edu.iiitb.sis.model;

public class Faculty {

	private String facultyName;
	private String phoneNumber;
	private String email;
	private String qualifications;
	private String status;
	private String facultyUserName;
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFacultyUserName() {
		return facultyUserName;
	}
	public void setFacultyUserName(String facultyUserName) {
		this.facultyUserName = facultyUserName;
	}
	public String getQualifications() {
		return qualifications;
	}
	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}
	
	
}
