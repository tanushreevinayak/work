package edu.iiitb.sis.actions.admin;
import java.util.ArrayList;

import javax.swing.JComboBox;

import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.dao.Enrollmentdao;
import edu.iiitb.sis.dao.RemoveSubjectsAdmin;
import edu.iiitb.sis.dao.UpdateSubjectsAdmin;
import edu.iiitb.sis.model.Course;
public class Enrollment implements ModelDriven<Course> {

	private Course course=new Course();
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	//JComboBox subjects = new JComboBox();
	ArrayList <String>subjects=new ArrayList<String>();
	Enrollmentdao enroll=new Enrollmentdao();
	public String execute()
	{
		//System.out.println("in execute"+ course.getCourse_name());
		course.setSubjects(enroll.enrollSubjects(course));
		for(int i=0;i<subjects.size();i++)
		{
		System.out.println(subjects.get(i));
		}
		return "success";
		
	}
	@Override
	public Course getModel() {
		// TODO Auto-generated method stub
		return course;
	}

}
