package edu.iiitb.sis.actions.admin;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.dao.RemoveSubjectsAdmin;
import edu.iiitb.sis.dao.UpdateSubjectsAdmin;
import edu.iiitb.sis.model.Course;


public class UpdateSubjects implements ModelDriven<Course> {

	private Course course=new Course();
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	private String message;
	 
		UpdateSubjectsAdmin Update=new UpdateSubjectsAdmin();
		public String execute()
		{
			System.out.println("in execute"+ course.getCourse_name());
			message=Update.UpdateOption(course);
			
			return "success";
			
		}
			
				
	
	
	@Override
	public Course getModel() {
		// TODO Auto-generated method stub
		return course;
	}
			
	
	
}
