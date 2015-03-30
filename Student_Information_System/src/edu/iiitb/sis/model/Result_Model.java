package edu.iiitb.sis.model;

import java.util.ArrayList;

public class Result_Model {
	
	public String student_rollno;
	public String grade;
	public int marks;
	public String course_id;
	public String course_name;
	public String result;
	ArrayList<String> course =new ArrayList<String>();
	ArrayList<String> mark =new ArrayList<String>();
	ArrayList<String> results =new ArrayList<String>();
	ArrayList<String> rollnos =new ArrayList<String>();
	ArrayList<String> grades =new ArrayList<String>();
	ArrayList<String> courseName = new ArrayList<String>();
	
	public ArrayList<String> getCourseName() {
		return courseName;
	}
	public void setCourseName(ArrayList<String> courseName) {
		this.courseName = courseName;
	}
	public ArrayList<String> getMark() {
		return mark;
	}
	public void setMark(ArrayList<String> mark) {
		this.mark = mark;
	}
	public ArrayList<String> getResults() {
		return results;
	}
	public void setResults(ArrayList<String> results) {
		this.results = results;
	}
	public ArrayList<String> getRollnos() {
		return rollnos;
	}
	public void setRollnos(ArrayList<String> rollnos) {
		this.rollnos = rollnos;
	}
	public ArrayList<String> getGrades() {
		return grades;
	}
	public void setGrades(ArrayList<String> grades) {
		this.grades = grades;
	}
	public ArrayList<String> getCourse() {
		return course;
	}
	public void setCourse(ArrayList<String> course) {
		this.course = course;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String string) {
		this.result = string;
	}
	
	
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String string) {
		this.course_id = string;
		
	}
	
	
	
	public String getStudent_rollno() {
		return student_rollno;
	}
	public void setStudent_rollno(String student_rollno) {
		this.student_rollno = student_rollno;
	}
	
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String string) {
		this.grade = string;
	}
	
	
	public int getMarks() {
		return marks;
	}
	public void setMarks(int i) {
		this.marks = i;
	}
	
	
	
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	
	}
	
