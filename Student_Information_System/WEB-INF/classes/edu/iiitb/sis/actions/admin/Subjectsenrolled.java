package edu.iiitb.sis.actions.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;

import com.opensymphony.xwork2.ModelDriven;

import antlr.collections.List;
import edu.iiitb.sis.dao.Enrollmentdao;
import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.Course;
import edu.iiitb.sis.model.Enroll;


public class Subjectsenrolled implements ModelDriven<Enroll>{
	private String message;
	int i=0;
	//private Course course=new Course();
	private Enroll en=new Enroll();
	private Course cs=new Course();

	//private Enroll enr;
	
	public Course getCs() {
		return cs;
	}

	public void setCs(Course cs) {
		this.cs = cs;
	}

	public Enroll getEn() {
		return en;
	}

	public void setEn(Enroll en) {
		this.en = en;
	}

	Enrollmentdao enroll=new Enrollmentdao();
	public String execute()
	{
		//System.out.println("in execute"+ course.getCourse_name());
		en.setSubjects(enroll.enrolledSubjects(en,cs));
		//setEnr(enroll.enrolledSubjects(en));
		///System.out.println(en.getSubjects().get(0));
		return "success";
		
	}

	@Override
	public Enroll getModel() {
		// TODO Auto-generated method stub
		return en;
	}

}
