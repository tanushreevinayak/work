package edu.iiitb.sis.actions.admin;

import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.dao.RemoveSubjectsAdmin;
import edu.iiitb.sis.model.Course;

public class RemoveSubjects implements ModelDriven<Course>{
	private Course course=new Course();
	private String message;
	//private String course_name;

	RemoveSubjectsAdmin dataremove=new RemoveSubjectsAdmin();
	public String execute()
	{
		System.out.println("in execute"+ course.getCourse_name());
		message=dataremove.RemoveSubjects(course);
		return message;
	}
	
	

	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}



	@Override
	public Course getModel() {
		// TODO Auto-generated method stub
		return course;
	}
	

}
