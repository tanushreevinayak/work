package edu.iiitb.sis.model;

public class FacultyEdit {
	private String phone;
	private String qualification;
	private String facultyId;
	private String facultyUserName;
	public String getFacultyUserName() {
		return facultyUserName;
	}
	public void setFacultyUserName(String facultyUserName) {
		this.facultyUserName = facultyUserName;
	}
	public String getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

}
