package edu.iiitb.sis.actions.admin;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.dao.RemoveSubjectsAdmin;
import edu.iiitb.sis.dao.UpdateSubjectsAdmin;
import edu.iiitb.sis.model.Course;

public class UpdateOption implements ModelDriven<Course>  {
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
		//System.out.println("in execute1 "+ course.getCourse_name());
		
		course=Update.UpdateSubjects(course);
		
		//System.out.println(course.getCourse_id());
		//System.out.println(course.getCourse_credits());
		if(course==null)
		{
			return "failure";
		}
		return "success";
	}

	@Override
	public Course getModel() {
		// TODO Auto-generated method stub
		return course;
	}
		


}
