package edu.iiitb.sis.model;

import java.util.ArrayList;


public class Enroll {
	private ArrayList<String> Subjects;
	public ArrayList<String> getSubjects() {
		return Subjects;
	}
	public void setSubjects(ArrayList<String> subjects) {
		Subjects = subjects;
	}
	private String message;
	private String student_course_id;
	private String student_rollno;
	private String course_id;
	public String getStudent_course_id() {
		return student_course_id;
	}
	public void setStudent_course_id(String student_course_id) {
		this.student_course_id = student_course_id;
	}
	public String getStudent_rollno() {
		return student_rollno;
	}
	public void setStudent_rollno(String student_rollno) {
		this.student_rollno = student_rollno;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	
}
