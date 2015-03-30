package edu.iiitb.sis.model;

public class CourseModel 
{
	private String courseName;
	private String courseCredits;
	private String courseSyllabus;
	private String courseId;
	private String semesterName;
	public String getCourseName() 
	{
		return courseName;
	}
	public void setCourseName(String courseName) 
	{
		this.courseName = courseName;
	}
	public String getCourseCredits() 
	{
		return courseCredits;
	}
	public void setCourseCredits(String courseCredits) 
	{
		this.courseCredits = courseCredits;
	}
	public String getCourseSyllabus() 
	{
		return courseSyllabus;
	}
	public void setCourseSyllabus(String courseSyllabus) 
	{
		this.courseSyllabus = courseSyllabus;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getSemesterName() {
		return semesterName;
	}
	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}
	
}
