package edu.iiitb.sis.model;


public class Faculty_Search_Model {

	private String faculty_id;
	public String getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(String faculty_id) {
		this.faculty_id = faculty_id;
	}

	private String faculty_image;
	private String faculty_name;
	private String faculty_qualification;
	private String faculty_phoneno;
	private String faculty_mailid;
	private StringBuilder faculty_course;

	public StringBuilder getFaculty_course() {
		return faculty_course;
	}

	public void setFaculty_course(StringBuilder faculty_course) {
		this.faculty_course = faculty_course;
	}

	public String getFaculty_image() {
		return faculty_image;
	}

	public void setFaculty_image(String faculty_image) {
		this.faculty_image = faculty_image;
	}

	public String getFaculty_name() {
		return faculty_name;
	}

	public void setFaculty_name(String faculty_name) {
		this.faculty_name = faculty_name;
	}

	public String getFaculty_qualification() {
		return faculty_qualification;
	}

	public void setFaculty_qualification(String faculty_qualification) {
		this.faculty_qualification = faculty_qualification;
	}

	public String getFaculty_phoneno() {
		return faculty_phoneno;
	}

	public void setFaculty_phoneno(String faculty_phoneno) {
		this.faculty_phoneno = faculty_phoneno;
	}

	public String getFaculty_mailid() {
		return faculty_mailid;
	}

	public void setFaculty_mailid(String faculty_mailid) {
		this.faculty_mailid = faculty_mailid;
	}





}
