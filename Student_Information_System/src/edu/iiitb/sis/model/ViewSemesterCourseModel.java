package edu.iiitb.sis.model;

import java.util.ArrayList;

public class ViewSemesterCourseModel {

	private String semesterName;
	private ArrayList<String> courseid;
	private ArrayList<String> coursename;
	private ArrayList<String> coursecredit;
	
	public String getSemesterName() {
		return semesterName;
	}
	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}
	public ArrayList<String> getCourseid() {
		return courseid;
	}
	public void setCourseid(ArrayList<String> courseid) {
		this.courseid = courseid;
	}
	public ArrayList<String> getCoursename() {
		return coursename;
	}
	public void setCoursename(ArrayList<String> coursename) {
		this.coursename = coursename;
	}
	public ArrayList<String> getCoursecredit() {
		return coursecredit;
	}
	public void setCoursecredit(ArrayList<String> coursecredit) {
		this.coursecredit = coursecredit;
	}
}
