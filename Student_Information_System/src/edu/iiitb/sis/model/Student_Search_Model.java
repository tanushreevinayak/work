package edu.iiitb.sis.model;


public class Student_Search_Model {

	private String student_image;
	private String student_name;
	private String student_rollno;
	private String student_phoneno;
	private String student_mailid;
	private String student_address;
	private String student_dob;
	private StringBuilder student_course;
	private StringBuilder student_interest;
	
	
	public StringBuilder getStudent_interest() {
		return student_interest;
	}

	public void setStudent_interest(StringBuilder student_interest) {
		this.student_interest = student_interest;
	}

	public StringBuilder getStudent_course() {
		return student_course;
	}

	public void setStudent_course(StringBuilder student_course) {
		this.student_course = student_course;
	}

	public String getStudent_image() {
		return student_image;
	}

	public void setStudent_image(String student_image) {
		this.student_image = student_image;
	}


	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_rollno() {
		return student_rollno;
	}

	public void setStudent_rollno(String student_rollno) {
		this.student_rollno = student_rollno;
	}

	public String getStudent_phoneno() {
		return student_phoneno;
	}

	public void setStudent_phoneno(String student_phoneno) {
		this.student_phoneno = student_phoneno;
	}

	public String getStudent_mailid() {
		return student_mailid;
	}

	public void setStudent_mailid(String student_mailid) {
		this.student_mailid = student_mailid;
	}

	public String getStudent_address() {
		return student_address;
	}

	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}

	public String getStudent_dob() {
		return student_dob;
	}

	public void setStudent_dob(String student_dob) {
		this.student_dob = student_dob;
	}

}
